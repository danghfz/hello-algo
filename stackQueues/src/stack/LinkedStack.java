package stack;

/**
 * @author danghf
 * @data 2023/11/9 23:58
 * 基于链表实现的栈
 */
public class LinkedStack {
    private class Node{
        Node(int val){
            this.val = val;
        }
        private int val;
        private Node next;
    }
    // 栈顶元素
    private Node stackPeek;
    // 栈大小
    private int size;
    /* 获取栈的长度 */
    public int size(){
        return size;
    }
    /* 判断栈是否为空 */
    public boolean isEmpty(){
        return size() == 0;
    }
    /* 入栈 */
    public void push(int val){
        Node node = new Node(val);
        // 该节点指向原先的栈顶元素,该节点为新的栈顶元素
        node.next = stackPeek;
        stackPeek = node;
        size++;
    }
    /* 获取栈顶元素 */
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        return stackPeek.val;
    }
    /* 出栈 */
    public int pop(){
        int val = peek();
        stackPeek = stackPeek.next;
        size--;
        return val;
    }
    public int[] toArray(){
        int[] arr = new int[size()];
        Node node = stackPeek;
        for(int i = size() - 1; i >= 0; i--){
            arr[i] = node.val;
            node = node.next;
        }
        return arr;
    }

}
