package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;

import java.util.ArrayList;
import java.util.Set;

public abstract class Piece implements IPiece {

	protected final PieceColor color;
	protected Position position;

	public Piece(PieceColor color, Position startPosition) {
		this.color = color;
		this.position = startPosition;
	}



	public abstract Set<Position> getMoves();

	public abstract Set<Position> getAttack();

}
