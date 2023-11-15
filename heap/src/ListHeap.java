import java.util.ArrayList;
import java.util.List;

/**
 * @author danghf
 * @data 2023/11/14 20:40
 * 使用列表实现堆
 */
public class ListHeap {
    /**
     * 大顶堆
     */
    private final List<Integer> maxHeap;

    public ListHeap() {
        maxHeap = new ArrayList<>();
    }

    /**
     * 构造堆
     */
    public ListHeap(List<Integer> maxHeap) {
        this.maxHeap = maxHeap;
        // 此时堆中的元素并不是一个大顶堆，需要进行堆化
        // 从最后一个非叶子节点开始，自下而上进行堆化
        // 因为叶子节点不需要堆化。所以从 最后一个节点的父节点开始
        // 将 i 为 根节点的 子树进行堆化
        for (int i = parent(size() - 1); i >= 0; i--) {
            // 自上而下堆化 i 为子树根节点
            siftDown(i);
        }
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 入堆
     */
    public void push(int val) {
        // 先将元素放到最后
        maxHeap.add(val);
        // 然后进行堆化
        int size = size();
        heapify(size - 1);
    }

    /**
     * 堆顶元素出堆
     * 将堆顶元素和堆底元素进行交换
     * 堆[0 - size-1) 进行堆化
     */
    public int pop() {
        int peek = peek();
        int size = size();
        swap(maxHeap, 0, size - 1);
        // 删除堆底元素
        maxHeap.remove(size - 1);
        // 堆化(自上而下)
        siftDown(0);

        return peek;
    }

    /**
     * 堆化 (自上而下)
     */
    private void siftDown(int i) {
        // 得到左右子节点较大的一个索引
        int left = left(i);
        int right = right(i);
        int next;
        if (left >= size()) {
            /* 左右节点都不存在 */
            return;
        } else if (right >= size()) {
            /* 存在一个节点 左节点 */
            next = left;
        } else {
            /* 两个节点都存在，选择值大的 */
            next = maxHeap.get(left) > maxHeap.get(right) ? left : right;
        }
        // 如果子节点小于当前节点，结束
        if (maxHeap.get(next) <= maxHeap.get(i)) {
            return;
        }
        // 如果子节点大于当前节点，交换
        swap(maxHeap, i, next);
        // 然后继续向下堆化
        siftDown(next);
    }

    /**
     * 堆化 (自下而上)
     * 我们比较插入节点与其父节点的值，
     * 如果插入节点更大，则将它们交换。
     * 然后继续执行此操作，从底至顶修复堆中的各个节点，
     * 直至越过根节点或遇到无须交换的节点时结束。
     */
    public void heapify(int index) {
        // 获取父节点
        int parent = parent(index);
        // 如果父节点 大于 当前节点，结束
        if (parent < 0 || maxHeap.get(parent) >= maxHeap.get(index)) {
            return;
        }
        swap(maxHeap, index, parent);
        // 继续向上堆化
        heapify(parent);
    }

    /**
     * 交换大顶堆中两个节点的值
     */
    public void swap(List<Integer> maxHeap, int child, int parent) {
        Integer temp = maxHeap.get(child);
        maxHeap.set(child, maxHeap.get(parent));
        maxHeap.set(parent, temp);
    }

    /**
     * 访问堆顶元素
     */
    public int peek() {
        return maxHeap.get(0);
    }

    public int size() {
        return maxHeap.size();
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public List<Integer> getMaxHeap() {
        return maxHeap;
    }
}
