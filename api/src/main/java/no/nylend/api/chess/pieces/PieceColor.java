package no.nylend.api.chess.pieces;

public enum PieceColor {
    // white = -1 (pawns move upwards towards y=0)
    WHITE(-1),
    // black = 1 (pawns move downwards towards y=7)
    BLACK(1);

    private int value;
    PieceColor(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
