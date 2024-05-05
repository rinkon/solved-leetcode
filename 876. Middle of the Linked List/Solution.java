
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static void main(String[] args) {

        
        int raw1[] = { 1, 2, 3, 4, 5};
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
        if(head.next == null) return head;
        if(head.next.next == null) return head.next;
        if(head.next.next.next == null) return head.next;

        ListNode finder = head;
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        if(length%2 == 0) length = length/2 + 1;
        else length = (length-1)/2 + 1;

        while(length!=0){
            finder = finder.next;
            length--;
            if(length == 1) break;
        }

        return finder;
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