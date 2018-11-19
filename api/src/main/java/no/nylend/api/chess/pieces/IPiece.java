package no.nylend.api.chess.pieces;

import java.util.BitSet;

public interface IPiece {
	/**
	 * Update available moves for the current piece
	 * @return a bitmap of the pure available moves with an empty board
	 */
    BitSet updateMoves();
}
