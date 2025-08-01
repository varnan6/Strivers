package DSA.LinkedLists.Medium_LL;

public class Sort_List {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){

        if(head == null || head.next == null) return head;
        
        // Finding list's middle
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list
        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);

        return merge(left, right);
    }

    public ListNode merge(ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}