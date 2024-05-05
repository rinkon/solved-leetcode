
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
        int raw1[] = { 1,2,3};

        ListNode head = createLN(raw1);
        ListNode result = swapNodes(head,99);

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
        int length = 1;
        while(toBrowse.next != null){
            length++;
            toBrowse = toBrowse.next;
        }
        toBrowse = head;
        k = k%length;
        
        int carrier = -200;
        int count = 0;
        int tmp = 0;

        while(count < k){
            while(toBrowse != null){
                tmp = toBrowse.val;
                if(carrier != -200){
                    toBrowse.val = carrier;
                    toBrowse = toBrowse.next;
                }
                carrier = tmp;
            }
            head.val = carrier;
            count++;
            toBrowse = head;
            carrier = -200;

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