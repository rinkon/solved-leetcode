
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static void main(String[] args) {
        
        int raw1[] = { 1, 4, 3, 2, 5, 2};
        ListNode head = createLN(raw1);
        ListNode result = partition(head,3);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
    }
    
    public static ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode leftHead = null;
        ListNode rightHead = null;
        boolean leftFound = false;
        boolean rightFound = false;

        while (head != null) {
            if (head.val < x) {
                if(!leftFound){
                    left = head;
                    leftHead = left;
                    leftFound = true;
                }
                else{
                    left.next = head;
                    left = left.next;
                }
            } else {
                if (!rightFound) {
                    right = head;
                    rightHead = right;
                    rightFound = true;
                }
                else{
                    right.next = head;
                    right = right.next;
                }
            }
            head = head.next;
        }
        right.next = null;
        
        if(leftHead == null) return rightHead;
        else{
            left.next = rightHead;
            return leftHead;
        }
        
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