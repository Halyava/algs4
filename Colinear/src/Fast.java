public class Fast {
   public static void main(String[] args)
   {
        In f = new In(args[0]);
        int pointCount = f.readInt();
        int position = 0;
        Point[] points = new Point[pointCount];
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        while (!f.isEmpty())
        {
            Point p = new Point(f.readInt(), f.readInt());
            points[position] = p;
            p.draw();
            position++;
        }
   }
}