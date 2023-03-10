package domain;

import java.util.Arrays;

public enum BoatType {

    BATTLESHIP(4), CRUISER(3), DESTROYER(2), SUBMARINE(1);

    private final int size;

    BoatType(int size) {
        this.size = size;
    }

    public static BoatType ofSize(int boatSize) {
        return Arrays.stream(BoatType.values()).filter(type -> type.getSize() == boatSize).findFirst().orElseThrow(() -> new InvalidBoatSize(boatSize));
    }

    public int getSize() {
        return size;
    }
}
