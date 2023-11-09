package queue;

/**
 * @author danghf
 * @data 2023/11/10 0:16
 * 基于数组实现队列
 */
public class ArrayQueue {
    private int[] arr; // 用于存储队列元素的数组
    private int front; // 队首指针，指向队首元素
    private int size; // 队列长度
    public ArrayQueue(int capacity) {
        arr = new int[capacity];
        front = size = 0;
    }
    /* 获取队列的容量 */
    public int capacity(){
        return arr.length;
    }
    /* 获取队列的长度 */
    public int size() {
        return size;
    }
    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return size == 0;
    }
    /* 入队 */
    public void push(int val){
        if (size() == capacity()){
            throw new RuntimeException("队列已满");
        }
        // 计算队尾指针，队尾指针是最后一个元素的下一个
        int rear = (front + size) % capacity();
        arr[rear] = val;
        size++;
    }
    /* 访问队首元素 */
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
    /* 出队 */
    public int pop(){
        int peek = peek();
        front = (front + 1) % capacity();
        size--;
        return peek;
    }
    public int[] toArray(){
        int[] res = new int[size()];
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity();
            res[i] = arr[index];
        }
        return res;
    }

}
