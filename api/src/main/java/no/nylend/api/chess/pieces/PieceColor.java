package no.nylend.api.chess.pieces;

public enum PieceColor {
    WHITE(1),
    BLACK(-1);

    private int value;
    PieceColor(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
