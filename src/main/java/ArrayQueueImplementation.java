public class ArrayQueueImplementation<E> implements Queue<E> {
    int p;
    E[] v;
    int maximum;
    public ArrayQueueImplementation(int len){

        this.p=0;
        this.maximum=len;
        this.v = (E[]) new Object[len];
    }
    @Override
    public void push(E e) throws FullQueueException {
        if(isFull())
            throw new FullQueueException();
        v[p]=e;
        p++;

    }

    private boolean isFull() {
        return (p==maximum);
    }

    @Override
    public E pop() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        E elementToPop= v[0];
        rearrange(v);
        p--;
        return elementToPop;
    }

    private void rearrange(E[] v) {
        for (int i=0; i<v.length-1;i++) {
            v[i] = v[i++];
        }
    }

    private boolean isEmpty() {
        return (p==0);
    }

    @Override
    public int size() {
        return this.p;
    }
}
