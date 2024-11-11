package java07.practice;

import java.util.ArrayList;

public class ExPointMain {

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(2, 3));
        points.add(new Point(-5, 20));
        points.add(new Point(30, -8));

        for (Point point : points) {
            System.out.println(point);
        }
    }
}

class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

