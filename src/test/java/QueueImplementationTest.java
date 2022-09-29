import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class QueueImplementationTest extends TestCase
{
    @Test
    public void size_of_queue_correctly_calculated() throws FullQueueException {
        Queue<Integer> queue = new QueueImplementation<Integer>();
        queue.push(1);
        queue.push(5);
        queue.push(3);
        assertEquals(3, queue.size());
    }

    @Test
    public void pop_to_empty_queue_throws_exception() {
        Queue<Integer> queue = new QueueImplementation<Integer>();
        Assert.assertThrows(EmptyQueueException.class, queue::pop);
    }

    @Test
    public void push_to_add_queue_element() throws FullQueueException {
        Queue<Integer> queue = new QueueImplementation<Integer>();
        queue.push(2);
        assertEquals(1, queue.size());
    }

    @Test
    public void pop_to_remove_queue_element() throws FullQueueException, EmptyQueueException {
        Queue<Integer> queue = new QueueImplementation<Integer>();
        int firstElement = 4;
        queue.push(firstElement);
        queue.push(3);
        int beforeSize = queue.size();
        int elementPopped = queue.pop();
        int afterSize = queue.size();
        assertEquals(2, beforeSize);
        assertEquals(1, afterSize);
        assertEquals(elementPopped, firstElement);
    }
}