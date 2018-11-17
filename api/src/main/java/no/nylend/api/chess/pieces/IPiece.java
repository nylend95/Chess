package no.nylend.api.chess.pieces;

import no.nylend.api.chess.Position;

import java.util.Set;

public interface IPiece {
    Set<Position> getMoves();

    Set<Position> getAttack();
}
