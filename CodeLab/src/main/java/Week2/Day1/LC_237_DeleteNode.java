package Week2.Day1;

//LC 237
public class LC_237_DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
}
