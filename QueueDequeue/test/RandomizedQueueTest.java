/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import java.util.Random;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Dmitryi
 */
public class RandomizedQueueTest {
    
    public RandomizedQueueTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isEmpty method, of class RandomizedQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        RandomizedQueue instance = new RandomizedQueue();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class RandomizedQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        RandomizedQueue instance = new RandomizedQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of enqueue method, of class RandomizedQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        Object item = "Test";
        RandomizedQueue instance = new RandomizedQueue();
        instance.enqueue(item);
    }

    /**
     * Test of dequeue method, of class RandomizedQueue.
     */
    @Test
    public void testDequeue() {
        System.out.println("dequeue");
        RandomizedQueue instance = new RandomizedQueue();
        Object expResult = "Test";
        instance.enqueue(expResult);
        Object result = instance.dequeue();
        assertEquals(expResult, result);
    }

    /**
     * Test of sample method, of class RandomizedQueue.
     */
    @Test
    public void testSample() {
        System.out.println("sample");
        RandomizedQueue instance = new RandomizedQueue();
        Object expResult = "Test";
        instance.enqueue(expResult);
        Object result = instance.sample();
        assertEquals(expResult, result);
    }

    /**
     * Test of sample method, of class RandomizedQueue.
     */
    @Test
    public void RandomCals() {
        System.out.println("50 random calls");
        Random r = new Random();
        RandomizedQueue instance = new RandomizedQueue();
        for (int i = 0; i < 10000; i++)
        {
            double val = r.nextGaussian();
            Object expResult = val;
            if (val > -0.5)
            {
                instance.enqueue(expResult);
            }
            else
            {
                if (instance.size() > 0)
                {
                    Object result = instance.dequeue();
                    assertNotNull(result);
                }
            }
        }
    }

    /**
     * Test of sample method, of class RandomizedQueue.
     */
    @Test
    public void RandomCalsToEnqueueSampleDequeueIsEmptySize() {
        int N = 256;
        
        System.out.println("N random calls to: enqueue(), sample(), dequeue(), isEmpty(), and size()");
        System.out.println("                 N seconds");
        System.out.println("--------------------------");
        
        for (int test = 1; test <=8; test++)
        {
            N = N * 4;
            RandomizedQueue instance = new RandomizedQueue();
            Stopwatch w = new Stopwatch();
            for (int i = 0; i < N; i++)
            {
                int val = StdRandom.uniform(5);
                Object expResult = i;
                switch (val)
                {
                    case 0:
                        instance.enqueue(expResult);
                        break;
                    case 1:
                        if (instance.size() > 0)
                            instance.sample();
                        break;
                    case 2:
                        if (instance.size() > 0)
                            instance.dequeue();
                        break;
                    case 3:
                        instance.isEmpty();
                        break;
                    case 4:
                        instance.size();
                        break;
                    default:
                        break;
                }
            }
            System.out.println(N + " " + w.elapsedTime());
        }
    }
}
