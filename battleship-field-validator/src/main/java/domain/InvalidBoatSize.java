package domain;

public class InvalidBoatSize extends RuntimeException {

    public InvalidBoatSize(int size) {
        super(String.format("The ship with size %s is not a valid one", size));
    }
}
