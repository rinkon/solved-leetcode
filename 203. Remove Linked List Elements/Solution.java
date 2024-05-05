
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static void main(String[] args) {
        
        
        int raw1[] = { 1, 2, 6, 3, 4, 5, 6};
        ListNode head = createLN(raw1);
        ListNode result = removeElements(head,6);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
    }
    
    public static ListNode removeElements(ListNode head, int val) { 
        if(head == null) 
            return head;
        if (val == 0)
            return head;
        if (head.val == val && head.next == null)
            return null;
        if (head.next == null && head.val != val)
            return head;
        if (head.next.next == null && head.val == val && head.next.val != val)
            return head.next;
        if (head.next.next == null && head.next.val == val && head.val != val) {
            head.next = null;
            return head;
        }
        if (head.next.next == null && head.val == val && head.next.val == val)
            return null;
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null) return null;
        ListNode toBrowse = head;

        while (toBrowse != null && toBrowse.next != null) {
            while (toBrowse.next != null && toBrowse.next.val == val) {
                toBrowse.next = toBrowse.next.next;
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