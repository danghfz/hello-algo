import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author danghf
 * @data 2023/11/14 10:04
 * 二叉搜索树
 */
public class BinarySearchTree {
    private Node root;

    public void init() {
    }

    /**
     * 查找节点
     */
    public Node search(int val) {
        Node node = root;
        while (node != null) {
            if ((Integer) node.val == val) {
                return node;
            } else if ((Integer) node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    /**
     * 插入节点
     */
    public void insert(int val) {
        Node insert = new Node(val);
        if (root == null) {
            root = insert;
            return;
        }
        Node node = root, pre = null;
        while (node != null) {
            if ((Integer) node.val == val) {
                // 重复值不插入
                return;
            }
            pre = node;
            if ((Integer) node.val > val) {
                // 插入左子树
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if ((Integer) pre.val > val) {
            pre.left = insert;
        } else {
            pre.right = insert;
        }
    }

    /**
     * 删除节点
     * 1. 叶子节点 直接删除
     * 2. 只有一个子节点，将子节点替换到当前节点
     * 3. 有两个子节点，将右子树的最小节点(叶子节点)替换到当前节点
     */
    public void remove(int val) {
        // 查找节点
        Node node = root;
        Node parent = null;
        while (node != null) {
            if ((Integer) node.val == val) {
                break;
            }
            parent = node;
            if ((Integer) node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        // 此时 node 是要删除的节点
        if (node == null) {
            return;
        }
        // 度为 0 的节点
//        if (node.left == null && node.right == null) {
//            // 父节点为空，说明是度为 0 的根节点
//            if (parent == null) {
//                root = null;
//            } else if (parent.left == node) {
//                parent.left = null;
//            } else {
//                parent.right = null;
//            }
//        }
        // 度为 2 的节点，将右子树的最小节点(叶子节点)替换到当前节点，然后删除右子树的最小节点
        // 同理，或者将左子树的最大节点(叶子节点)替换到当前节点，然后删除左子树的最大节点
        if(node.left != null && node.right != null){
            // 找到右子树的最小节点
            Node min = node.right;
            while (min.left != null) {
                min = min.left;
            }
            // 先删除再替换，否则会删除掉替换的节点
            remove((Integer) min.val);
            // 将 min 替换到 node
            node.val = min.val;

        }
        // 度为 1 / 0 的节点
        else {
            // 得到子节点
            Node child  = node.left != null ? node.left : node.right;
            // 将 cur 替换到 node
            if (parent == null) {
                root = child ;
            } else if (parent.left == node) {
                parent.left = child ;
            } else {
                parent.right = child ;
            }
        }

    }

}
