/*************************************************************************
 * Name: Dzmitryi Halyava
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new BySlope();       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        /*Treat the slope of a horizontal line segment as positive zero; treat
        the slope of a vertical line segment as positive infinity; treat the
        slope of a degenerate line segment (between a point and itself)
        as negative infinity.*/
        double slope;
        if (x == that.x)
        {
            if (y == that.y) // a degenerate line segment)
            {
                slope = Double.NEGATIVE_INFINITY;
            }
            else  // a vertical line segment
            {
                slope = Double.POSITIVE_INFINITY;
            }
        }
        else if (y == that.y) //a horizontal line segment
        {
            slope = 0.0;
        }
        else
        {
            slope = (1.0 * that.y - y)/(that.x - x);
        }
        return slope;
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        // the invoking point (x0, y0) is less than the argument point (x1, y1)
        // if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
        int result = 0;
        if (y != that.y || x != that.x)
        {
            if (y < that.y || (y == that.y && x < that.x))
            {
                result = -1;
            }
            else
            {
                result = 1;
            }
        }
        return result;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
    
    private class BySlope implements Comparator<Point>
    {
        public int compare(Point t, Point t1)
        {
            /*
             * Formally, the point (x1, y1) is less than the point (x2, y2)
             * if and only if the slope (y1 − y0) / (x1 − x0) is less than the
             * slope (y2 − y0) / (x2 − x0). Treat horizontal, vertical,
             * and degenerate line segments as in the slopeTo() method.
             */
            double s1 = slopeTo(t);
            double s2 = slopeTo(t1);
            if (t.x == t1.x)
            {
                if (t.y == t1.y)
                {
                    return 1;
                }
            }
            else if (t.y == t1.y)
            {
                return 0;
            }
            if (s1 < s2)
            {
                return -1;
            }
            else// if (s1 > s2)
            {
                return 1;
            }
/*            else
            {
                return t.compareTo(t1);
            }
*/
        }
        
    }
}