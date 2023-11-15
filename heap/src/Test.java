import java.util.List;

/**
 * @author danghf
 * @data 2023/11/14 21:09
 */
public class Test {
    public static void main(String[] args) {
        ListHeap listHeap = new ListHeap();
        listHeap.push(1);
        listHeap.push(2);
        listHeap.push(3);
        listHeap.push(4);
        listHeap.push(5);
        List<Integer> maxHeap = listHeap.getMaxHeap();
        // [5, 4, 2, 1, 3]
        System.out.println(maxHeap);
        int pop = listHeap.pop();
        // 4 3 2 1
        System.out.println(maxHeap);
    }
}
