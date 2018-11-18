package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;
import no.nylend.api.chess.Utils;

import java.util.*;

import static no.nylend.api.chess.Board.N_SQUARES;

public class Bishop extends Piece {


	public Bishop(PieceColor color, Position startPosition) {
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
					moves.set(Utils.indexConverter(Utils.maxMin(position.getColumn() - i), Utils.maxMin(position.getRow() - i)));
					moves.set(Utils.indexConverter(Utils.maxMin(position.getColumn() - i), Utils.maxMin(position.getRow() + i)));
					moves.set(Utils.indexConverter(Utils.maxMin(position.getColumn() + i), Utils.maxMin(position.getRow() - i)));
					moves.set(Utils.indexConverter(Utils.maxMin(position.getColumn() + i), Utils.maxMin(position.getRow() + i)));
				}
				positionToMoveMap.put(pos, moves);
			}
		}
	}
}
