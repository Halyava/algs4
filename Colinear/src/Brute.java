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
               int segmentLength = 0;
               Point p = points[position];
               Point lastPoint = null;
               for (int i = position+1; i< pointCount; i++)
               {
                   
               }
               if (segmentLength > 4) p.drawTo(lastPoint);
                   
               position++;
           }
           while (position < pointCount - 4);
       }
   }
}