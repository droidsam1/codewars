package kata;

import java.util.List;

public class Kata {

    private Kata() {
    }

    public static List<Point> closestPair(List<Point> points) {
        return List.of(points.get(0), points.get(1));
    }
}