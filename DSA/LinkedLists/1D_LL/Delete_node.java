class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Delete_node {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}