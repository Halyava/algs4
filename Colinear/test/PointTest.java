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
}
