/**
 * @author danghf
 * @data 2023/11/9 21:01
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    /* 在链表的节点 n0 之后插入节点 P */
    public static void insert(ListNode n0, ListNode p){
        ListNode next = n0.next;
        n0.next = p;
        p.next = next;
    }
    /* 删除链表的节点 n0 之后的首个节点 */
    public static void delete(ListNode n0){
        ListNode next = n0.next;
        if (next == null){
            return;
        }
        n0.next = next.next;
    }
    /* 访问链表中索引为 index 的节点 */
    public static ListNode get(ListNode head, int index){
        for (int i = 0; i < index; i++) {
            if (head != null){
                head = head.next;
            }
        }
        return head;
    }

    /* 查找链表中值为 target 的节点 */
    public static int getIndex(ListNode head, int target){
        int index = 0;
        while (head != null){
            if (head.val == target){
                return index;
            }
            head = head.next;
            index++;
        }
       return -1;
    }

}
