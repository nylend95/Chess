package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;
import no.nylend.api.chess.Utils;

import java.util.BitSet;

import static no.nylend.api.chess.Board.N_SQUARES;

public class Rock extends Piece {

	public Rock(PieceColor color, Position startPosition) {
		super(color, startPosition);
	}

	@Override
	protected void initFixedMoves(){
		// Generate static moves
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Position pos = new Position(col, row);
				BitSet moves = new BitSet(N_SQUARES);
				for (int i = 1; i < 8; i++) {
					moves.set(Utils.indexConverter(position.getColumn(), Utils.maxMin(position.getRow() + i)));
					moves.set(Utils.indexConverter(position.getColumn(), Utils.maxMin(position.getRow() - i)));

					moves.set(Utils.indexConverter(Utils.maxMin(position.getColumn() + i), position.getRow()));
					moves.set(Utils.indexConverter(Utils.maxMin(position.getColumn() - i), position.getRow()));
				}
				positionToMoveMap.put(pos, moves);
			}
		}
	}
}
