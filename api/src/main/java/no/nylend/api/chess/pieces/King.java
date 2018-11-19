package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;
import no.nylend.api.chess.Utils;

import java.util.BitSet;

public class King extends Piece {

	public King(PieceColor color, Position startPosition) {
		super(color, startPosition);
	}

	@Override
	public BitSet updateMoves() {
		// TODO consider to do this as the same way as Queen, Rock and Bishop
		// TODO consider to include castling here
		moveSet.clear();
		moveSet.set(Utils.indexConverter(position.getColumn(), Utils.maxMin(position.getRow() + 1)));
		moveSet.set(Utils.indexConverter(position.getColumn(), Utils.maxMin(position.getRow() - 1)));
		moveSet.set(Utils.indexConverter(Utils.maxMin(position.getColumn() + 1), Utils.maxMin(position.getRow() + 1)));
		moveSet.set(Utils.indexConverter(Utils.maxMin(position.getColumn() + 1), Utils.maxMin(position.getRow() - 1)));
		moveSet.set(Utils.indexConverter(Utils.maxMin(position.getColumn() - 1), Utils.maxMin(position.getRow() + 1)));
		moveSet.set(Utils.indexConverter(Utils.maxMin(position.getColumn() - 1), Utils.maxMin(position.getRow() - 1)));
		moveSet.set(Utils.indexConverter(Utils.maxMin(position.getColumn() + 1), position.getRow()));
		moveSet.set(Utils.indexConverter(Utils.maxMin(position.getColumn() - 1), position.getRow()));
		return moveSet;
	}
}
