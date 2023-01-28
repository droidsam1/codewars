package domain;

public enum BoatType {

    BATTLESHIP(4), CRUISER(3);

    private final int size;

    BoatType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
