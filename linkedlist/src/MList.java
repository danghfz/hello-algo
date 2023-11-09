import java.util.Arrays;

/**
 * @author danghf
 * @data 2023/11/9 21:12
 * 列表简单实现
 */
public class MList<T> {
    private Object[] arr; // 数组（存储列表元素）
    private int capacity = 10; // 列表容量
    private int size = 0; // 列表长度（即当前元素数量）
    private final int extendRatio = 2; // 每次列表扩容的倍数
    private final double expansionFactor = 0.75; // 扩容系数

    public MList() {
        arr = new Object[capacity];
    }

    /* 获取当前列表长度 */
    public int size() {
        return size;
    }

    /* 获取列表容量 */
    public int capacity() {
        return capacity;
    }
    /* 获取列表中索引为 index 的元素 */
    public T get(int index){
        if (index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T)arr[index];
    }
    /* 更新元素 */
    public void set(int index, T value){
        if (index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        arr[index] = value;
    }

    /* 扩容函数 */
    private void expansion(){
        if (size > capacity * expansionFactor){
            capacity *= extendRatio;
            arr = Arrays.copyOf(arr, capacity);
        }
    }


    /* 尾部添加元素 */
    public void add(T value){
        // 判断是否需要扩容
        expansion();
        arr[size] = value;
        size++;
    }
    /* 中间插入元素 */
    public void add(int index, T value){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        expansion();
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }
    /* 删除元素 */
    public T delete(int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // 获取删除元素
        T value = (T)arr[index];
        // 删除元素，后面的元素前移，最后一个元素不用管
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return value;
    }
    public T[] toArray(){
        // 只返回当前元素数量的数组
        return (T[])Arrays.copyOf(arr, size);
    }

}
