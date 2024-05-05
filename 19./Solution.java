
/*
 * Easy problem. Mainly tests understanding of linkedlist
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static void main(String[] args) {
        int raw1[] = { 1,2,3,4,5,6,7};

        ListNode head = createLN(raw1);
        ListNode result = removeNthFromEnd(head, 7);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode toBrowse = head;
        int length = 0;

        while (true) {
            length++;

            if (toBrowse.next == null) {
                break;
            }
            toBrowse = toBrowse.next;
        }
        toBrowse = head;

        if (length == 1 && n == 1)
            return null;
        if (length == n)
            return toBrowse.next;

        for (int i = 0; i < length; i++) {

            if (i >= length - n - 1) {

                toBrowse.next = toBrowse.next.next;
                break;
            }

            toBrowse = toBrowse.next;
        }

        return head;
        
    }
    
    public static ListNode createLN(int[] raw){
        ListNode result = new ListNode();
        ListNode returnResult = result;

        for(int i = 0; i<raw.length; i++){
            result.val = raw[i];
            if(i != raw.length - 1){
                ListNode tmp = new ListNode();
                result.next = tmp;
                result = tmp;
            }
        }
        return returnResult;
    }
}