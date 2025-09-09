package Algorithms;

import java.util.*;

import static java.lang.Math.abs;

public class ConvexHull {
    static class Point implements Comparable<Point> {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point other) {
            if (this.x != other.x) return this.x - other.x;
            return this.y - other.y;
        }
    }

    static int dist(Point p, Point q, Point r) {
        return abs((r.y - p.y) * (q.x - p.x) - (r.x - p.x) * (q.y - p.y));
    }

    static int loc(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;
        return (val > 0) ? 1 : 2;
    }

    static List<Point> hull(List<Point> points, Point p1, Point p2) {
        ArrayList<Point> hull = new ArrayList<Point>();
        if (points.isEmpty()) return hull;
        int maxDist = 0;
        Point farPoint = null;
        for (Point p : points) {
            int d = dist(p1, p2, p);
            if (loc(p1, p2, p) == 2 && d > maxDist) {
                maxDist = d;
                farPoint = p;
            }
        }

        if (farPoint == null) return hull;
        ArrayList<Point> leftSet1 = new ArrayList<Point>();
        ArrayList<Point> leftSet2 = new ArrayList<Point>();
        for (Point p : points) {
            if (p == farPoint) continue;
            if (loc(p1, farPoint, p) == 2) leftSet1.add(p);
            if (loc(farPoint, p2, p) == 2) leftSet2.add(p);
        }

        List<Point> hull1 = hull(leftSet1, p1, farPoint);
        List<Point> hull2 = hull(leftSet2, farPoint, p2);
        hull.addAll(hull1);
        hull.add(farPoint);
        hull.addAll(hull2);
        return hull;
    }

    static List<Point> buildHull(List<Point> points) {
        if (points.size() <= 2) return new ArrayList<>(points);
        Point leftmost = points.getFirst();
        Point rightmost = points.getFirst();
        for (Point p : points) {
            if (p.x < leftmost.x || (p.x == leftmost.x && p.y < leftmost.y))
                leftmost = p;
            if (p.x > rightmost.x || (p.x == rightmost.x && p.y > rightmost.y))
                rightmost = p;
        }

        ArrayList<Point> upperPoints = new ArrayList<Point>();
        ArrayList<Point> lowerPoints = new ArrayList<Point>();
        for (Point p : points) {
            if (p == leftmost || p == rightmost) continue;
            int position = loc(leftmost, rightmost, p);
            if (position == 2) upperPoints.add(p);
            else if (position == 1) lowerPoints.add(p);
        }

        List<Point> upperHull = hull(upperPoints, leftmost, rightmost);
        List<Point> lowerHull = hull(lowerPoints, rightmost, leftmost);
        List<Point> res = new ArrayList<>();
        res.add(leftmost);
        res.addAll(upperHull);
        res.add(rightmost);
        res.addAll(lowerHull);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Point> points = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            String[] tokens = line.split("\\s+");
            if (tokens.length < 2) continue;
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            points.add(new Point(x, y));
        }

        System.out.println("Convex Hull is:");
        if (points.isEmpty()) return;
        List<Point> hull = buildHull(points);
        for (Point p : hull) {
            System.out.println(p.x + " " + p.y);
        }
    }
}