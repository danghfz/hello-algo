import java.util.List;
import java.util.PriorityQueue;

/**
 * @author danghf
 * @data 2023/11/15 19:19
 */
public class TopK {
    public static void main(String[] args) {
        List<Integer> integers = new TopK().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(integers);
    }
    /**
     * 取出 nums 中 最小的 k 个数
     * @param nums 数组
     * @param k 前k个
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        ListHeap heap = new ListHeap();
        // 将 前 k 个数进行入堆
        for (int i = 0; i < k; i++) {
            heap.push(nums[i]);
        }
        // 将剩余的数进行入堆
        for (int i = k+1; i < nums.length; i++) {
            // 如果当前值 小于 堆顶元素，堆顶元素出堆，该元素入堆
            if (nums[i] < heap.peek()) {
                heap.pop();
                heap.push(nums[i]);
            }
        }
        return heap.getMaxHeap();
    }
}
