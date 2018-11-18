package no.nylend.api.chess;

import no.nylend.api.chess.pieces.Pawn;
import no.nylend.api.chess.pieces.Piece;
import no.nylend.api.chess.pieces.PieceColor;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Game {
	private Board board;
	private PieceColor turn = PieceColor.WHITE;
	private boolean hasWhiteCastled = false;
	private boolean hasBlackCastled = false;

	public Game() {
		this(new Board());
	}

	public Game(Board board){
		this.board = board;
		this.reset();
	}

	public void reset(){
		this.board = new Board();
		hasWhiteCastled = false;
		hasBlackCastled = false;
	}

	public boolean move(Piece piece, Position newPosition){
		// TODO: Assert that the piece actually can move to this position


		// move the piece
		Piece captured = placePieceAt(piece, newPosition);

		// TODO: Save move and captured piece
		return true;
	}

	/**
	 *
	 * @param piece
	 * @param newPosition
	 * @return a captured piece, or null if no captured piece
	 */
	private Piece placePieceAt(Piece piece, Position newPosition){
		Piece capturedPiece = board.capturePiece(newPosition);
		board.movePiece(piece, newPosition);

		// TODO handle promotion

		// TODO handle castling

		return capturedPiece;
	}

	public List<String> getAvailableActions(){
		if (turn.equals(PieceColor.WHITE))
			return getAvailableWhiteActions();
		return getAvailableBlackActions();
	}

	public List<String> getAvailableBlackActions(){
		return getAvailableActions(board.getBlackPiecesObj());
	}

	public List<String> getAvailableWhiteActions(){
		return getAvailableActions(board.getWhitePiecesObj());
	}

	private List<String> getAvailableActions(List<Piece> pieces){
		ArrayList<String> allMoves = new ArrayList<>();
		for (Piece piece : pieces){
			BitSet moves = new BitSet(64);
			moves.or(piece.getMoveSet());

			// TODO update moves based on where opponent/friendly pieces is on the board
			// TODO how do we do this efficiently?

			if (piece instanceof Pawn){
				// TODO update for en passant
				// TODO update for opponent pieces (both in front and in fron-diagonal)
			}

			// Print all moves in bitmap
			int next = moves.nextSetBit(0);
			while (next != -1) {
				System.out.println(piece.getClass().getSimpleName() + "|" + Utils.indexConverter(next));
				allMoves.add(piece.getClass().getSimpleName() + "|" + Utils.indexConverter(next));
				next = moves.nextSetBit(next+1);
			}
		}

		// TODO handle king moves separately


		// TODO should probably not be String
		return allMoves;
	}

	private void switchTurn(){
		turn = (turn == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
	}

	public static void main(String[] args) {
		// For testing
		Game g = new Game();
		g.getAvailableWhiteActions();
		System.out.println("--------------------------------");
		g.getAvailableBlackActions();
	}

}
