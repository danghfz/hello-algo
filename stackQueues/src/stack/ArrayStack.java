package stack;

import java.util.ArrayList;

/**
 * @author danghf
 * @data 2023/11/10 0:07
 * 基于数组实现的栈
 */
public class ArrayStack {
    private ArrayList<Integer> stack;

    public ArrayStack() {
        stack = new ArrayList<>();
    }

    /* 获取栈的长度 */
    public int size() {
        return stack.size();
    }

    /* 判断栈是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入栈 */
    public void push(int val) {
        stack.add(val);
    }

    /* 获取栈顶元素 */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return stack.get(size() - 1);
    }

    /* 出栈 */
    public int pop() {
        int val = peek();
        stack.remove(size() - 1);
        return val;
    }

    /* 将 List 转化为 stackay 并返回 */
    public Object[] toArray() {
        return stack.toArray();
    }
}
