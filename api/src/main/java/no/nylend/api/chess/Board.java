package no.nylend.api.chess;

import no.nylend.api.chess.pieces.*;

import java.util.ArrayList;
import java.util.BitSet;

import static no.nylend.api.chess.Utils.indexConverter;

public class Board {
	public final static int N_SQUARES = 64;
	private final static int PAWN_ID = 1;
	private final static int KNIGHT_ID = 2;
	private final static int BISHOP_ID = 3;
	private final static int ROCK_ID = 4;
	private final static int QUEEN_ID = 5;
	private final static int KING_ID = 6;

	private final ArrayList<Piece> whitePiecesObj = new ArrayList<>();
	private final ArrayList<Piece> blackPiecesObj = new ArrayList<>();

	private King whiteKing, blackKing;

	private final BitSet whitePieces = new BitSet(N_SQUARES);
	private final BitSet blackPieces = new BitSet(N_SQUARES);

	private final BitSet whitePawns = new BitSet(N_SQUARES);
	private final BitSet blackPawns = new BitSet(N_SQUARES);

	private final BitSet whiteKnights = new BitSet(N_SQUARES);
	private final BitSet blackKnights = new BitSet(N_SQUARES);

	private final BitSet whiteBishops = new BitSet(N_SQUARES);
	private final BitSet blackBishops = new BitSet(N_SQUARES);

	private final BitSet whiteRocks = new BitSet(N_SQUARES);
	private final BitSet blackRocks = new BitSet(N_SQUARES);

	private final BitSet whiteKingBit = new BitSet(N_SQUARES);
	private final BitSet blackKingBit = new BitSet(N_SQUARES);

	private final BitSet whiteQueen = new BitSet(N_SQUARES);
	private final BitSet blackQueen = new BitSet(N_SQUARES);

	public Board() {
		reset();
	}

	private void reset() {
		whitePiecesObj.clear();
		blackPiecesObj.clear();

		// Initialize pawns
		for (int i = 0; i < 8; i++) {
			int whitePos = indexConverter(i, 6);
			int blackPos = indexConverter(i, 1);
			whitePieces.set(whitePos);
			whitePawns.set(whitePos);
			whitePiecesObj.add(new Pawn(PieceColor.WHITE, new Position(i, 6)));
			blackPieces.set(blackPos);
			blackPawns.set(blackPos);
			blackPiecesObj.add(new Pawn(PieceColor.BLACK, new Position(i, 1)));
		}

		// Knights
		int whitePos = indexConverter(1, 7);
		whitePieces.set(whitePos);
		whiteKnights.set(whitePos);
		whitePiecesObj.add(new Knight(PieceColor.WHITE, new Position(1, 7)));
		whitePos = indexConverter(6, 7);
		whitePieces.set(whitePos);
		whiteKnights.set(whitePos);
		whitePiecesObj.add(new Knight(PieceColor.WHITE, new Position(6, 7)));
		int blackPos = indexConverter(1, 0);
		blackPieces.set(blackPos);
		blackKnights.set(blackPos);
		blackPiecesObj.add(new Knight(PieceColor.BLACK, new Position(1, 0)));
		blackPos = indexConverter(6, 0);
		blackPieces.set(blackPos);
		blackKnights.set(blackPos);
		blackPiecesObj.add(new Knight(PieceColor.BLACK, new Position(6, 0)));

		// Bishops
		whitePos = indexConverter(2, 7);
		whitePieces.set(whitePos);
		whiteBishops.set(whitePos);
		whitePiecesObj.add(new Knight(PieceColor.WHITE, new Position(2, 7)));
		whitePos = indexConverter(5, 7);
		whitePieces.set(whitePos);
		whiteBishops.set(whitePos);
		whitePiecesObj.add(new Knight(PieceColor.WHITE, new Position(5, 7)));
		blackPos = indexConverter(2, 0);
		blackPieces.set(blackPos);
		blackBishops.set(blackPos);
		blackPiecesObj.add(new Bishop(PieceColor.BLACK, new Position(2, 0)));
		blackPos = indexConverter(5, 0);
		blackPieces.set(blackPos);
		blackBishops.set(blackPos);
		blackPiecesObj.add(new Bishop(PieceColor.BLACK, new Position(5, 0)));

		// Rocks
		whitePos = indexConverter(0, 7);
		whitePieces.set(whitePos);
		whiteRocks.set(whitePos);
		whitePiecesObj.add(new Rock(PieceColor.WHITE, new Position(0, 7)));
		whitePos = indexConverter(7, 7);
		whitePieces.set(whitePos);
		whiteRocks.set(whitePos);
		whitePiecesObj.add(new Rock(PieceColor.WHITE, new Position(7, 7)));
		blackPos = indexConverter(0, 0);
		blackPieces.set(blackPos);
		blackRocks.set(blackPos);
		blackPiecesObj.add(new Rock(PieceColor.BLACK, new Position(0, 0)));
		blackPos = indexConverter(7, 0);
		blackPieces.set(blackPos);
		blackRocks.set(blackPos);
		blackPiecesObj.add(new Rock(PieceColor.BLACK, new Position(7, 7)));


		// Queens & kings
		whitePos = indexConverter(3, 7);
		whitePieces.set(whitePos);
		whiteQueen.set(whitePos);
		whitePiecesObj.add(new Queen(PieceColor.WHITE, new Position(3, 7)));
		whitePos = indexConverter(4, 7);
		whitePieces.set(whitePos);
		whiteKingBit.set(whitePos);
		whiteKing = new King(PieceColor.WHITE, new Position(4, 7));
		blackPos = indexConverter(3, 0);
		blackPieces.set(blackPos);
		blackQueen.set(blackPos);
		blackPiecesObj.add(new Queen(PieceColor.BLACK, new Position(3, 0)));
		blackPos = indexConverter(4, 0);
		blackPieces.set(blackPos);
		blackKingBit.set(blackPos);
		blackKing = new King(PieceColor.BLACK, new Position(4, 0));
	}

	public boolean hasPiece(Position position) {
		BitSet allPieces = (BitSet) whitePieces.clone();
		allPieces.or(blackPieces);
		return allPieces.get(indexConverter(position));
	}

	public Piece capturePiece(Position position) {
		if (hasPiece(position)) {
			//TODO improve performance
			for (Piece black : blackPiecesObj) {
				if (black.getPosition().equals(position))
					return black;
			}
			for (Piece white : whitePiecesObj) {
				if (white.getPosition().equals(position))
					return white;
			}
		}
		return null;
	}

	public void movePiece(Piece piece, Position newPosition) {
		Position oldPos = piece.getPosition();
		piece.setPosition(newPosition);
	}

	/**
	 * Print the board
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N_SQUARES; i++) {
			if (blackPieces.get(i)) {
				if (blackPawns.get(i)) {
					sb.append(-PAWN_ID);
				} else if (blackRocks.get(i)) {
					sb.append(-ROCK_ID);
				} else if (blackKnights.get(i)) {
					sb.append(-KNIGHT_ID);
				} else if (blackBishops.get(i)) {
					sb.append(-BISHOP_ID);
				} else if (blackQueen.get(i)) {
					sb.append(-QUEEN_ID);
				} else if (blackKingBit.get(i)) {
					sb.append(-KING_ID);
				}
			} else if (whitePieces.get(i)) {
				if (whitePawns.get(i)) {
					sb.append(PAWN_ID);
				} else if (whiteRocks.get(i)) {
					sb.append(ROCK_ID);
				} else if (whiteKnights.get(i)) {
					sb.append(KNIGHT_ID);
				} else if (whiteBishops.get(i)) {
					sb.append(BISHOP_ID);
				} else if (whiteQueen.get(i)) {
					sb.append(QUEEN_ID);
				} else if (whiteKingBit.get(i)) {
					sb.append(KING_ID);
				}
			} else
				sb.append(0);
			sb.append("\t");
			if ((i + 1) % 8 == 0) {
				sb.append("\n");
			}
		}

		return sb.toString();
	}

	public ArrayList<Piece> getWhitePiecesObj() {
		return whitePiecesObj;
	}

	public ArrayList<Piece> getBlackPiecesObj() {
		return blackPiecesObj;
	}

	public King getWhiteKing() {
		return whiteKing;
	}

	public King getBlackKing() {
		return blackKing;
	}

	public BitSet getWhitePieces() {
		return whitePieces;
	}

	public BitSet getBlackPieces() {
		return blackPieces;
	}

	public BitSet getWhitePawns() {
		return whitePawns;
	}

	public BitSet getBlackPawns() {
		return blackPawns;
	}

	public BitSet getWhiteKnights() {
		return whiteKnights;
	}

	public BitSet getBlackKnights() {
		return blackKnights;
	}

	public BitSet getWhiteBishops() {
		return whiteBishops;
	}

	public BitSet getBlackBishops() {
		return blackBishops;
	}

	public BitSet getWhiteRocks() {
		return whiteRocks;
	}

	public BitSet getBlackRocks() {
		return blackRocks;
	}

	public BitSet getWhiteKingBit() {
		return whiteKingBit;
	}

	public BitSet getBlackKingBit() {
		return blackKingBit;
	}

	public BitSet getWhiteQueen() {
		return whiteQueen;
	}

	public BitSet getBlackQueen() {
		return blackQueen;
	}


	public static void main(String[] args) {
		// For testing
		Board b = new Board();
		b.reset();
		System.out.println(b);
	}
}
