
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
        int raw1[] = { 7,5};

        ListNode head = createLN(raw1);
        ListNode result = swapNodes(head,1);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
    }
    
    public static ListNode swapNodes(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode toBrowse = head;
        ListNode front = head;
        ListNode back = head;
        int count = 0;
        
        while(toBrowse != null){
            count++;
            toBrowse = toBrowse.next;
            if(count <= k-1){
                front = front.next;
            }
            if(count>k){
                back = back.next;
            }
        }
        int tmp = front.val;
        front.val = back.val;
        back.val = tmp;

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