package queue;

/**
 * @author danghf
 * @data 2023/11/10 0:10
 * 基于链表实现队列
 */
public class LinkedQueue<T> {
    private class Node<T> {
        Node(T val) {
            this.val = val;
        }

        T val;
        Node<T> next;
    }
    // 队列的头尾指针
    private Node<T> front, rear;
    private int size;

    public LinkedQueue() {
    }
    /* 获取队列长度 */
    public int size(){
        return size;
    }
    /* 判断队列是否为空 */
    public boolean isEmpty(){
        return size() == 0;
    }
    /* 入队 */
    public void push(T val){
        Node<T> node = new Node<>(val);
        if (isEmpty()){
            front = rear = node;
        }else {
            rear.next = node;
            rear = node;
        }
        size++;
    }
    /* 出队 */
    public T pop(){
        T peek = peek();
        front = front.next;
        size--;
        return peek;
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return front.val;
    }
    public Object[] toArray(){
        Object[] arr = new Object[size()];
        Node<T> node = front;
        for (int i = 0; i < size(); i++) {
            arr[i] = node.val;
            node = node.next;
        }
        return arr;
    }

}
