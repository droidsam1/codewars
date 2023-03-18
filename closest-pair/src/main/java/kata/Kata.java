package kata;

import java.util.ArrayList;
import java.util.List;

public class Kata {

    private Kata() {
    }

    public static List<Point> closestPair(List<Point> points) {
        List<Point> result = new ArrayList<>();
        var minDistance = Double.MAX_VALUE;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                var distance = distance(points.get(i), points.get(j));
                if (Double.compare(distance, minDistance) < 0) {
                    minDistance = distance;
                    result = List.of(points.get(i), points.get(j));
                }
            }
        }

        return result;
    }

    private static double distance(Point one, Point another) {
        return Math.abs(one.x - another.x) + Math.abs(one.y - another.y);
    }
}