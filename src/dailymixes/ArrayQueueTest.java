package dailymixes;

import junit.framework.TestCase;
import queue.EmptyQueueException;

// -------------------------------------------------------------------------
/**
 *
 * test the array queue class
 * 
 * @author nathanokubazgi
 * @version Apr 5, 2025
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nathan Okubazgi (906705115)
public class ArrayQueueTest
    extends TestCase
{

    private ArrayQueue<String> arrayQueue;
    private ArrayQueue<String> emptyArrayQueue;

    /**
     * initializes the fields
     */
    public void setUp()
    {
        arrayQueue = new ArrayQueue<>(5);
        emptyArrayQueue = new ArrayQueue<>();

    }


    // ----------------------------------------------------------
    /**
     * This method test by adding and removing songs from the queue
     */
    public void testEnqueueDequeue()
    {
        arrayQueue.enqueue("rock");
        arrayQueue.enqueue("country");
        arrayQueue.enqueue("pop");

        assertEquals(3, arrayQueue.getSize());
        assertEquals("rock", arrayQueue.dequeue());
        assertEquals(2, arrayQueue.getSize());
        assertEquals("country", arrayQueue.dequeue());
        assertEquals(1, arrayQueue.getSize());
    }


    // ----------------------------------------------------------
    /**
     * This method test to see if the
     */
    public void testIsEmpty()
    {
        assertTrue(arrayQueue.isEmpty());
        arrayQueue.enqueue("rap");
        assertFalse(arrayQueue.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * test to see whats in the front of the queue
     */
    public void testGetFront()
    {
        arrayQueue.enqueue("rap");
        arrayQueue.enqueue("country");

        assertEquals("rap", arrayQueue.getFront());
    }


    // ----------------------------------------------------------
    /**
     * test the exception
     */
    public void testGetFrontException()
    {
        {
            Exception exception = null;
            try
            {
                arrayQueue.getFront();
            }
            catch (EmptyQueueException e)
            {
                exception = e;
            }
            assertNotNull(exception);
        }

    }


    // ----------------------------------------------------------
    /**
     * test the exception
     */
    public void testGetDeque()
    {
        {
            Exception exception = null;
            try
            {
                arrayQueue.dequeue();
            }
            catch (EmptyQueueException e)
            {
                exception = e;
            }
            assertNotNull(exception);
        }

    }


    // ----------------------------------------------------------
    /**
     * test the output of the string
     */
    public void testToString()
    {
        assertEquals("[]", arrayQueue.toString());

        arrayQueue.enqueue("rap");
        arrayQueue.enqueue("country");

        assertEquals("[rap, country]", arrayQueue.toString());
    }


    // ----------------------------------------------------------
    /**
     * test to see if playlist is cleared
     */
    public void testClearEmpty()
    {
        arrayQueue.enqueue("rap");
        arrayQueue.enqueue("country");
        arrayQueue.clear();
        assertTrue(arrayQueue.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * test to compare other playlist
     */
    public void testEquals()
    {

        Playlist playlist =
            new Playlist("Daily Mix", 10, 20, 30, 50, 60, 70, 3);

        assertFalse(emptyArrayQueue.equals(null));

        assertFalse(arrayQueue.equals(playlist));

        arrayQueue.enqueue("rap");
        arrayQueue.enqueue("country");
        emptyArrayQueue.enqueue("rap");
        emptyArrayQueue.enqueue("country");

        assertTrue(arrayQueue.equals(emptyArrayQueue));

        emptyArrayQueue.enqueue("pop");

        assertFalse(arrayQueue.equals(emptyArrayQueue));

        arrayQueue = new ArrayQueue<>(5);
        emptyArrayQueue = new ArrayQueue<>(5);

        arrayQueue.enqueue("rock");
        arrayQueue.enqueue("jazz");

        emptyArrayQueue.enqueue("rock");
        emptyArrayQueue.enqueue("pop");

        assertFalse(arrayQueue.equals(emptyArrayQueue));

        arrayQueue.dequeue();
        arrayQueue.enqueue("country");

        emptyArrayQueue = new ArrayQueue<>(5);
        emptyArrayQueue.enqueue("jazz");
        emptyArrayQueue.enqueue("country");

        assertTrue(arrayQueue.equals(emptyArrayQueue));
    }


    /**
     * test the iff statements in the equal methods
     */
    public void testEqualsObj()
    {
        ArrayQueue<String> arrayQueue1 = new ArrayQueue<>(5);
        arrayQueue.enqueue("rap");
        arrayQueue.enqueue("country");
        arrayQueue1.enqueue("rap");
        arrayQueue1.enqueue("country");

        assertTrue(arrayQueue.equals(arrayQueue));
        assertFalse(arrayQueue.equals(emptyArrayQueue));

    }


    // ----------------------------------------------------------
    /**
     * test to see if the upgrade the length of the underlying array when the
     * queue is full.
     */
    public void testEnsureCapacity()
    {
        emptyArrayQueue.enqueue("rap");
        emptyArrayQueue.enqueue("pop");
        emptyArrayQueue.enqueue("pop");

        emptyArrayQueue.enqueue("pop");

        emptyArrayQueue.enqueue("pop");

        emptyArrayQueue.enqueue("pop");

        assertEquals(21, emptyArrayQueue.getLengthOfUnderlyingArray());
        emptyArrayQueue.enqueue("country");
        assertEquals(21, emptyArrayQueue.getLengthOfUnderlyingArray());
    }


    // ----------------------------------------------------------
    /**
     * test to see accessing the data in the queue
     */
    public void testToArray()
    {

        arrayQueue.enqueue("rap");
        arrayQueue.enqueue("pop");

        Object[] object = arrayQueue.toArray();
        assertEquals(2, object.length);
        assertEquals("rap", object[0]);
        assertEquals("pop", object[1]);
    }


    // ----------------------------------------------------------
    /**
     * test the exception
     */
    public void testToArrayException()
    {
        {
            Exception exception = null;
            try
            {
                arrayQueue.toArray();
            }
            catch (EmptyQueueException e)
            {
                exception = e;
            }
            assertNotNull(exception);
        }

    }


    /**
     * test if queue is full
     */
    public void testIsFull()
    {
        arrayQueue.enqueue("rap1");
        arrayQueue.enqueue("rap2");

        arrayQueue.enqueue("rap3");

        arrayQueue.enqueue("rap4");
        assertFalse(arrayQueue.isFull());
        arrayQueue.enqueue("country");
        assertTrue(arrayQueue.isFull());

    }

}
