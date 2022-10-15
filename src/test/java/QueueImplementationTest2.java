import edu.upc.dsa.queue.ArrayQueueImplementation;
import edu.upc.dsa.queue.EmptyQueueException;
import edu.upc.dsa.queue.FullQueueException;
import edu.upc.dsa.queue.Queue;
import org.junit.Test;
import org.junit.Assert;

public class QueueImplementationTest2 {
    @Test
    public void size_of_queue_correctly_calculated() throws FullQueueException {

        Queue<Integer> queue = new ArrayQueueImplementation<Integer>(4);
        queue.push(1);
        queue.push(5);
        queue.push(3);
        Assert.assertEquals(3, queue.size());
    }

    @Test
    public void pop_to_empty_queue_throws_exception() {

        Queue<Integer> queue = new ArrayQueueImplementation<Integer>(4);
        Assert.assertThrows(EmptyQueueException.class, queue::pop);
    }

    @Test
    public void push_to_add_queue_element() throws FullQueueException {
        Queue<Integer> queue = new ArrayQueueImplementation<Integer>(4);
        queue.push(2);
        Assert.assertEquals(1, queue.size());
    }

    @Test
    public void pop_to_remove_queue_element() throws FullQueueException, EmptyQueueException {

        Queue<Integer> queue = new ArrayQueueImplementation<Integer>(4);
        int firstElement = 4;
        queue.push(firstElement);
        queue.push(3);
        int beforeSize = queue.size();
        int elementPopped = queue.pop();
        int afterSize = queue.size();
        Assert.assertEquals(2, beforeSize);
        Assert.assertEquals(1, afterSize);
        Assert.assertEquals(elementPopped, firstElement);
    }
    @Test
    public void fullQueue() throws FullQueueException {
        Queue<Integer> queue = new ArrayQueueImplementation<Integer>(4);
        queue.push(2);
        queue.push(4);
        queue.push(5);
        queue.push(7);
        Assert.assertThrows(FullQueueException.class,()-> queue.push(4));
    }
}
