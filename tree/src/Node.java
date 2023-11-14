import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author danghf
 * @data 2023/11/13 10:31
 * 二叉树节点
 */
public class Node {
    public Object val;
    public Node left;
    public Node right;

    public Node(Object val) {
        this.val = val;
    }
    public static Node init(){
        Node root = new Node(0);
        Node left = new Node(1);
        Node right = new Node(2);
        left.left = new Node(3);
        left.right = new Node(4);
        right.left = new Node(5);
        right.right = new Node(6);
        root.left = left;
        root.right = right;
        return root;
    }
    /**
     * 层序遍历
     * 使用 队列 先进先出 实现
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            // 出栈
            Node poll = queue.poll();
            // 获取左右节点
            Node left = poll.left;
            Node right = poll.right;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            System.out.println(poll);
        }
    }

    /**
     * 前序遍历
     * 顺序：根节点 -> 左子树 -> 右子树
     */
    public void preOrder() {
        System.out.println(this);
        if (left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }

    /**
     * 中序遍历
     * 顺序：左子树 -> 根节点 -> 右子树
     */
    public void inOrder(){
        if (left != null) {
            left.inOrder();
        }
        System.out.println(this);
        if (right != null) {
            right.inOrder();
        }
    }

    /**
     * 后续遍历
     * 顺序：左子树 -> 右子树 -> 根节点
     */
    public void postOrder(){
        if (left != null) {
            left.postOrder();
        }
        if (right != null) {
            right.postOrder();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        Object l = left == null ? null : left.val;
        Object r = right == null ? null : right.val;
        return "Node{" +
                "val=" + val +
                ", left=" + l +
                ", right=" + r +
                '}';
    }

}
