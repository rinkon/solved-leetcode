
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static void main(String[] args) {
        
        int raw1[] = { };
        ListNode head = createLN(raw1);
        ListNode result = reverseBetween(head);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
    }
    
    public static ListNode reverseBetween(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode temp = head;
        ListNode prev = head;
        head = head.next;
        prev.next = null;
        
        while(head != null){
            temp = new ListNode(head.val, prev);
            prev = temp;
            head = head.next;
        }
        return prev;
        
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