
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static void main(String[] args) {
        
        
        int raw1[] = { 2, 1, 3, 5, 6, 4, 7};
        ListNode head = createLN(raw1);
        ListNode result = reverseBetween(head,2,6);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
    }
    
    public static ListNode reverseBetween(ListNode head, int left, int right) { 
        if(head == null) return null;
        if(head.next == null) return head;
        if(head.next.next == null) return head;

        ListNode odd = head;
        ListNode evenFirst = head.next;
        ListNode oddLast = odd;
        ListNode even = evenFirst;
        head = head.next.next;
        int count = 3;

        while(head != null){
            if(count%2 == 0){
                even.next = head;
                even = even.next;
            }
            else{
                oddLast.next = head;
                oddLast = oddLast.next;
            }
            head = head.next;
            count++;
        }
        even.next = null;
        oddLast.next = evenFirst;
        return odd;
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