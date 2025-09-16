package dailymixes;

import queue.EmptyQueueException;
import queue.QueueInterface;

// -------------------------------------------------------------------------
/**
 * The capactity of the AarrayQueue that gets created
 * 
 * @author nathanokubazgi
 * @version Apr 5, 2025
 * @param <T>
 *            in a queue
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Nathan Okubazgi (906705115)

public class ArrayQueue<T>
    implements QueueInterface<T>
{

    /**
     * The DEFAULT_CAPACITY is 20
     */
    public static final int DEFAULT_CAPACITY = 20;
    private T[] queue;
    private int dequeueIndex;
    private int enqueueIndex;
    private int size;

    // ----------------------------------------------------------
    /**
     * Create a new ArrayQueue object.
     * 
     * @param capacity
     *            the items in the queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity)
    {
        queue = (T[])new Object[capacity + 1];
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }


    /**
     * sets a new constructer for the capacirt
     */
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }


    /**
     * this method clears all items in the queue
     */
    @SuppressWarnings("unchecked")
    public void clear()
    {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        dequeueIndex = 0;
        enqueueIndex = 0;
        size = 0;
    }


    /**
     * increment an index in the array
     * 
     * @return increment an index in the array
     */
    private int incrementIndex(int index)
    {
        return (index + 1) % queue.length;
    }


    /**
     * puts the item in an array list
     * 
     * @return full string output
     */
    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++)
        {
            sb.append(queue[(dequeueIndex + i) % queue.length]);
            if (i < size - 1)
            {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * compares different queues
     * 
     * @param obj
     *            different item being compared
     * @return the comparison of the different playlist being compared
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        ArrayQueue<?> other = (ArrayQueue<?>)obj;
        if (this.size != other.size)
        {
            return false;
        }
        for (int i = 0; i < size; i++)
        {
            if (!queue[(dequeueIndex + i) % queue.length].equals(
                other.queue[(other.dequeueIndex + i) % other.queue.length]))
            {
                return false;
            }
        }
        return true;
    }


    /**
     * returns true if the size of the playlist is 0 meaning empty
     * 
     * @return true or false if playlist is empty
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * removes item from queue
     * 
     * @return a removed item
     */
    public T dequeue()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        T item = queue[dequeueIndex];
        queue[dequeueIndex] = null;
        dequeueIndex = incrementIndex(dequeueIndex);
        size--;
        return item;
    }


    /**
     * this method upgrade the length of the underlying array
     */
    @SuppressWarnings("unchecked")
    private void ensureCapacity()

    {
        if (isFull())
        {

            T[] newQueue = (T[])new Object[queue.length * 2 - 1];
            int deqIndex = dequeueIndex;
            for (int i = 0; i < size; i++)
            {
                newQueue[i] = queue[deqIndex];
                deqIndex = incrementIndex(deqIndex);

            }
            dequeueIndex = 0;
            enqueueIndex = size;
            queue = newQueue;
        }
    }


    /**
     * add an item to the queue)
     * 
     * @param item
     *            in the queue
     */
    public void enqueue(T item)
    {
        ensureCapacity();
        queue[enqueueIndex] = item;
        enqueueIndex = incrementIndex(enqueueIndex);
        size++;
    }


    // ----------------------------------------------------------
    /**
     * getter method of the length of the underlying array
     * 
     * @return the length
     */
    public int getLengthOfUnderlyingArray()
    {
        return queue.length;
    }


    /**
     * getter method
     * 
     * @return the front of queue
     */
    public T getFront()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        return queue[dequeueIndex];
    }


    /**
     * getter method for size
     * 
     * @return size
     */
    public int getSize()
    {
        return size;
    }


    /**
     * @return true if queue is full
     */
    public boolean isFull()
    {
        return size == queue.length - 1;
    }


    /**
     * this method see accessing the data in the queue
     * 
     * @return larger then the original size
     */
    public Object[] toArray()
    {
        if (isEmpty())
        {
            throw new EmptyQueueException();
        }
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++)
        {
            result[i] = queue[(dequeueIndex + i) % queue.length];
        }
        return result;
    }

}
