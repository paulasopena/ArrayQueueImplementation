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
        if(isFull()){
            throw new FullQueueException();
        }

        v[p]=e;
        p++;
    }

    private boolean isFull() {
        return (p==maximum);
    }

    @Override
    public E pop() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        }

        E elementToPop= v[0];
        rearrange();
        return elementToPop;
    }

    private void rearrange() {
        for (int i=0; i<this.p-1;i++) {
            this.v[i] = this.v[i+1];
        }
        this.p--;
    }

    private boolean isEmpty() {
        return (p==0);
    }

    @Override
    public int size() {
        return this.p;
    }
}
