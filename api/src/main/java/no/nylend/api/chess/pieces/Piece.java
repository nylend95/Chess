package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;

import java.util.BitSet;
import java.util.HashMap;

import static no.nylend.api.chess.Board.N_SQUARES;

public abstract class Piece implements IPiece {

	protected final PieceColor color;
	protected Position position;
	protected final HashMap<Position, BitSet> positionToMoveMap = new HashMap<>();

	protected BitSet moveSet = new BitSet(N_SQUARES);

	public Piece(PieceColor color, Position startPosition) {
		this.color = color;
		this.position = startPosition;
		initFixedMoves();
		updateMoves();
	}

	protected void initFixedMoves(){
		// Implement this if the piece use fixed moves function
	}

	public PieceColor getColor() {
		return color;
	}

	public Position getPosition() {
		return position;
	}

	public BitSet getMoveSet() {
		return moveSet;
	}

	public void setPosition(Position position) {
		this.position = position;
		updateMoves();
	}

	@Override
	public BitSet updateMoves() {
		moveSet.clear();
		moveSet.or(positionToMoveMap.get(position));
		return getMoveSet();
	}
}
