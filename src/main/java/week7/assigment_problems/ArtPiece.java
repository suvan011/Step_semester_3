abstract class ArtPiece {
    private static int nextId = 1;
    private final String pieceId;

    ArtPiece() {
        pieceId = String.valueOf(nextId++);
    }

    abstract String describe();

    String getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {
    private final String title;

    Painting(String title) {
        this.title = title;
    }

    String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    private final String title;

    Sculpture(String title) {
        this.title = title;
    }

    String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

class ArtPieceDemo {
    public static void main(String[] args) {
        System.out.println(new Painting("Sunset Fields").describe());
        System.out.println(new Sculpture("The Thinker II").describe());
    }
}