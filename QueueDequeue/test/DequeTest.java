/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Dmitryi
 */
public class DequeTest {
    
    public DequeTest() {
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
     * Test of isEmpty method, of class Deque.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Deque instance = new Deque();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class Deque.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Deque instance = new Deque();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFirst method, of class Deque.
     */
    @Test
    public void testAddFirst() {
        System.out.println("addFirst");
        Object item = "Test";
        Deque instance = new Deque();
        instance.addFirst(item);
    }

    /**
     * Test of addLast method, of class Deque.
     */
    @Test
    public void testAddLast() {
        System.out.println("addLast");
        Object item = "Test";
        Deque instance = new Deque();
        instance.addLast(item);
    }

    /**
     * Test of removeFirst method, of class Deque.
     */
    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        Deque instance = new Deque();
        Object expResult = "Test";
        instance.addFirst(expResult);
        Object result = instance.removeFirst();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeLast method, of class Deque.
     */
    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        Deque instance = new Deque();
        Object expResult = "Test";
        instance.addLast(expResult);
        Object result = instance.removeLast();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFirst method, of class Deque.
     */
    @Test
    public void testAddFirstRemoveLast() {
        System.out.println("addFirst -> removeLast");
        Object item = "Test";
        Deque instance = new Deque();
        instance.addFirst(item);
        Object result = instance.removeLast();
        assertEquals(item, result);
    }

    /**
     * Test of addFirst method, of class Deque.
     */
    @Test
    public void testAddLastRemoveFirst() {
        System.out.println("addLast -> removeFirst");
        Object item = "Test";
        Deque instance = new Deque();
        instance.addLast(item);
        Object result = instance.removeFirst();
        assertEquals(item, result);
    }
}
