/**
 * @author danghf
 * @data 2023/11/13 10:59
 */
public class Test {
    public static void main(String[] args) {
        Node root = Node.init();
        System.out.println("===========层序遍历===========");
        root.levelOrder();
        System.out.println("===========前序遍历===========");
        root.preOrder();
        System.out.println("===========中序遍历===========");
        root.inOrder();
        System.out.println("===========后序遍历===========");
        root.postOrder();

        ArrayBinaryTree binaryTree = new ArrayBinaryTree();
        binaryTree.init();
        System.out.println("\n===========层序遍历===========");
        binaryTree.levelOrder();
        System.out.println("\n===========前序遍历===========");
        binaryTree.preOrder();
        System.out.println("\n===========中序遍历===========");
        binaryTree.inOrder();
        System.out.println("\n===========后序遍历===========");
        binaryTree.postOrder();
    }
}
