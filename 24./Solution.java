
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
        int raw1[] = { 1};

        ListNode head = createLN(raw1);
        ListNode result = swapPairs(head);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
    }
    
    public static ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode toBrowse = head;
        int count = 1;
        int prev = toBrowse.val;
        int current = toBrowse.val;
        
        while(toBrowse.next != null){
            prev = toBrowse.val;
            current = toBrowse.next.val;
            count++;
            if(count==2){
                count = 0;
                toBrowse.val = current;
                toBrowse.next.val = prev;
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