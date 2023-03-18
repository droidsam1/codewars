package kata;

import static java.lang.Math.abs;
import static java.lang.Math.min;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Kata {

    private Kata() {
    }

    /*
        More info about solution:
        * https://personal.utdallas.edu/~ka.teo/pub/closest_pair_slides_KT.pdf
        * https://www.youtube.com/watch?v=6u_hWxbOc7E
     */
    public static List<Point> closestPair(List<Point> points) {
        var sortedPointsByX = points.stream().sorted(Comparator.comparingDouble(o -> o.x)).toList();
        return new ArrayList<>(closestPairOfPoints(sortedPointsByX).asListOfPoints());
    }

    private static PairOfPoints closestPairOfPoints(List<Point> points) {
        //base case
        if (points.size() < 3) {
            return closestPairOfPointsByBruteForce(points);
        }

        //half the problem in two
        var middlePoint = points.get(points.size() / 2);
        var leftHalf = points.subList(0, points.size() / 2);
        var rightHalf = points.subList(points.size() / 2, points.size());

        var closestPairInLeftHalf = closestPairOfPoints(leftHalf);
        var closestPairInRightHalf = closestPairOfPoints(rightHalf);

        //recursive divide and conquer
        var minimumDistance = min(closestPairInLeftHalf.distanceBetweenThem,
                                  closestPairInRightHalf.distanceBetweenThem
        );

        // check points close to middle point (the closest pair can be one point from right half and another from the left half)
        // the points cannot be farther apart than a distance "minimumDistance" because that would invalidate previous calculations of the closest pairs in both halves
        var pointsAroundMiddlePoint = Stream.concat(
                getPointsWithinDeltaDistanceFromMiddlePoint(leftHalf, minimumDistance, middlePoint).stream(),
                getPointsWithinDeltaDistanceFromMiddlePoint(rightHalf, minimumDistance, middlePoint).stream()
        ).toList();

        if (pointsAroundMiddlePoint.isEmpty()) {
            return getPairWithMinimumDistanceOf(closestPairInLeftHalf, closestPairInRightHalf);
        }

        //find the closest pair in points around middle point
        var closestAroundMiddle = closestPairOfPointsByBruteForce(pointsAroundMiddlePoint);

        return getPairWithMinimumDistanceOf(closestAroundMiddle, closestPairInLeftHalf, closestPairInRightHalf);
    }

    private static PairOfPoints closestPairOfPointsByBruteForce(List<Point> points) {
        assert (points != null);
        assert (!points.isEmpty());
        if (points.size() == 1) {
            return new PairOfPoints(points.get(0));
        }
        if (points.size() == 2) {
            return new PairOfPoints(points.get(0), points.get(1));
        }

        List<Point> result = new ArrayList<>();
        var minDistance = Double.MAX_VALUE;

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                var distance = PairOfPoints.calculateDistance(points.get(i), points.get(j));
                if (Double.compare(distance, minDistance) < 0) {
                    minDistance = distance;
                    result = List.of(points.get(i), points.get(j));
                }
            }
        }
        return new PairOfPoints(result.get(0), result.get(1));
    }

    private static PairOfPoints getPairWithMinimumDistanceOf(PairOfPoints... points) {
        return Arrays.stream(points)
                     .min(Comparator.comparingDouble(o -> o.distanceBetweenThem))
                     .orElse(new PairOfPoints());
    }

    private static List<Point> getPointsWithinDeltaDistanceFromMiddlePoint(
            List<Point> points, double delta, Point middle
    ) {

        var closesToMiddleLine = new ArrayList<Point>();

        for (Point p : points) {
            if (abs(p.x - middle.x) < abs(delta)) {
                closesToMiddleLine.add(p);
            }
        }
        return closesToMiddleLine;
    }

    private static class PairOfPoints {

        private final Point one;
        private final Point another;
        private final double distanceBetweenThem;

        public PairOfPoints(Point one, Point another) {
            this.one = one;
            this.another = another;
            this.distanceBetweenThem = calculateDistance(one, another);
        }

        public PairOfPoints(Point one) {
            this.one = one;
            this.another = null;
            this.distanceBetweenThem = Double.POSITIVE_INFINITY;
        }

        public PairOfPoints() {
            this.one = null;
            this.another = null;
            this.distanceBetweenThem = Double.POSITIVE_INFINITY;
        }

        private static double calculateDistance(Point one, Point another) {
            return sqrt(pow(one.x - another.x, 2) + pow(one.y - another.y, 2));
        }

        public List<Point> asListOfPoints() {
            return List.of(one, another);
        }
    }

}