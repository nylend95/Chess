package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;
import no.nylend.api.chess.Utils;

import java.util.BitSet;

public class Pawn extends Piece {

	public Pawn(PieceColor color, Position startPosition) {
		super(color, startPosition);
	}

	@Override
	public BitSet updateMoves() {
		moveSet.clear();
		moveSet.set(Utils.indexConverter(position.getColumn(), Utils.maxMin(position.getRow() + color.getValue())));
		moveSet.set(Utils.indexConverter(Utils.maxMin(position.getColumn() + 1), Utils.maxMin(position.getRow() + color.getValue())));
		moveSet.set(Utils.indexConverter(Utils.maxMin(position.getColumn() - 1), Utils.maxMin(position.getRow() + color.getValue())));
		return moveSet;
	}
}
