import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author danghf
 * @data 2023/11/13 11:47
 * 数组形式的树
 */
public class ArrayBinaryTree {
    private List<Integer> arr;

    public ArrayBinaryTree(List<Integer> arr) {
        this.arr = arr;
    }

    public ArrayBinaryTree() {

    }

    /**
     * 生产测试数据
     */
    public void init(){
        arr = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
    }

    public Integer val(int index) {
        if (index < 0 || index >= arr.size()) {
            return null;
        }
        return arr.get(index);
    }

    public Integer left(int index) {
        return val(2 * index + 1);
    }

    public Integer right(int index) {
        return val(2 * index + 2);
    }

    public Integer parent(int index) {
        return val((index - 1) / 2);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        for (Integer i : arr) {
            if (i != null) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(0);
    }

    public void preOrder(int index) {
        System.out.print(arr.get(index) + " ");
        Integer left = left(index);
        if (left != null) {
            preOrder(left);
        }
        Integer right = right(index);
        if (right != null) {
            preOrder(right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(0);
    }

    public void inOrder(int index) {
        Integer left = left(index);
        if (left != null) {
            inOrder(left);
        }
        System.out.print(arr.get(index) + " ");
        Integer right = right(index);
        if (right != null) {
            inOrder(right);
        }
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        postOrder(0);
    }

    public void postOrder(int index) {
        Integer left = left(index);
        if (left != null) {
            postOrder(left);
        }
        Integer right = right(index);
        if (right != null) {
            postOrder(right);
        }
        System.out.print(arr.get(index) + " ");
    }

    /**
     * 深度优先遍历
     * @param i 当前节点
     * @param order 遍历顺序 pre/in/post/
     * @param res 存储结果
     */
    private void dfs(Integer i, String order, List<Integer> res) {
        // 若为空位，则返回
        if (val(i) == null) {
            return;
        }
        // 前序遍历
        if (Objects.equals(order, "pre")) {
            res.add(val(i));
        }
        dfs(left(i), order, res);
        // 中序遍历
        if (Objects.equals(order, "in")) {
            res.add(val(i));
        }
        dfs(right(i), order, res);
        // 后序遍历
        if (Objects.equals(order, "post")) {
            res.add(val(i));
        }
    }

    /** 前序遍历 */
    public List<Integer> dfsPreOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "pre", res);
        return res;
    }

    /** 中序遍历 */
    public List<Integer> dfsInOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "in", res);
        return res;
    }

    /** 后序遍历 */
    public List<Integer> dfsPostOrder() {
        List<Integer> res = new ArrayList<>();
        dfs(0, "post", res);
        return res;
    }


}
