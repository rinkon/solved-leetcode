
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static void main(String[] args) {
        int raw1[] = { 1, 1, 1, 2, 3, 3};

        ListNode head = createLN(raw1);
        ListNode result = deleteDuplicates(head);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        if(head.next.next == null && head.val == head.next.val) return head.next;
        
        ListNode toBrowse = head;
        
        
        while(toBrowse != null){
            if(toBrowse.next != null && toBrowse.val == toBrowse.next.val){
                toBrowse.next = toBrowse.next.next;
            }
            else
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