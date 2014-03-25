/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dmitryi
 */
public class PointTest {
    
    public PointTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of slopeTo method, of class Point.
     */
    @Test
    public void testSlopeToHorizontalSegment() {
        System.out.println("slopeTo -> HorizontalSegment");
        Point that = new Point(100, 100);
        Point instance = new Point(150, 100);
        double expResult = 0.0;
        double result = instance.slopeTo(that);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of slopeTo method, of class Point.
     */
    @Test
    public void testSlopeToVerticalSegment() {
        System.out.println("slopeTo -> VerticalSegment");
        Point that = new Point(100, 150);
        Point instance = new Point(100, 100);
        double expResult = Double.POSITIVE_INFINITY;
        double result = instance.slopeTo(that);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of slopeTo method, of class Point.
     */
    @Test
    public void testSlopeToDegenerateSegment() {
        System.out.println("slopeTo -> DegenerateSegment");
        Point that = new Point(100, 100);
        Point instance = new Point(100, 100);
        double expResult = Double.NEGATIVE_INFINITY;
        double result = instance.slopeTo(that);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of slopeTo method, of class Point.
     */
    @Test
    public void testSlopeTo() {
        System.out.println("slopeTo");
        Point that = new Point(100, 120);
        Point instance = new Point(150, 100);
        double expResult = (120.0 - 100)/(100 - 150);
        double result = instance.slopeTo(that);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of compareTo method, of class Point.
     */
    @Test
    public void testCompareToEqual() {
        System.out.println("compareTo -> Equal");
        Point that = new Point(100, 100);
        Point instance = new Point(100, 100);
        int expResult = 0;
        int result = instance.compareTo(that);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Point.
     */
    @Test
    public void testCompareToX1MoreThanX2() {
        System.out.println("compareTo -> X1 More Than X2");
        Point that = new Point(100, 100);
        Point instance = new Point(150, 100);
        int expResult = +1;
        int result = instance.compareTo(that);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Point.
     */
    @Test
    public void testComparator() {
        Object[][] data = getData();
        for (int i = 0; i < data.length; i++)
        {
            Point p = (Point)data[i][0];
            Point q = (Point)data[i][1];
            Point r = (Point)data[i][2];
            int expResult = (int)data[i][3];
            int result = p.SLOPE_ORDER.compare(q, r);
            System.out.println("Comparator: p " + p + "; q " + q + "; r " + r);
            assertEquals(expResult, result);
        }
    }
    
    private Object[][] getData()
    {
        return new Object[][]{
            {new Point(20757, 7239), new Point(1719, 23770), new Point(26563, 6829), new Integer(-1)},
            {new Point(342, 380), new Point(23, 449), new Point(82, 87), new Integer(-1)},
            {new Point(25156, 26527), new Point(23377, 5093), new Point(16857, 7508), new Integer(1)},
            {new Point(5, 0), new Point(1, 9), new Point(6, 7), new Integer(-1)},
            {new Point(134, 434), new Point(380, 425), new Point(380, 425), new Integer(1)},
            {new Point(164, 244), new Point(473, 84), new Point(444, 337), new Integer(1)},
            {new Point(164, 244), new Point(444, 337), new Point(473, 84), new Integer(1)},
        };
    }
}
