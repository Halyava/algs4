public class Brute {
   public static void main(String[] args)
   {
       In f = new In(args[0]);
       int pointCount = f.readInt();
       int position = 0;
       if (pointCount >= 4) {
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
           
           position = 0;
           do
           {
                Point p = points[position];
                Point p1 = points[position + 1];
                Point p2 = points[position + 2];
                Point p3 = points[position + 3];
                boolean drawSegment = true;
                double s1 = p.slopeTo(p1);
                double s2 = p.slopeTo(p2);
                double s3 = p.slopeTo(p3);
                drawSegment = drawSegment && s1 == s2 && s1 == s3;
                if (drawSegment)
                {
                    p.drawTo(p3);
                    StdOut.printf("%s -> %s -> %s -> %s%n", p, p1, p2, p3);
                }
                   
                position++;
           }
           while (position < pointCount - 3);
       }
   }
}