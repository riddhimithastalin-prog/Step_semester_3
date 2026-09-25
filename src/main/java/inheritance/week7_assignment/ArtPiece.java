package inheritance.week7_assignment;

public abstract class ArtPiece {

    private static int pieceCounter = 1000;

    private final String pieceId;

    protected ArtPiece() {

        pieceCounter++;

        pieceId = "ART-" + pieceCounter;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}
