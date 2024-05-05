
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
        int raw1[] = { 0};
        int raw2[] = { 0};

        ListNode l1 = createLN(raw1);
        ListNode l2 = createLN(raw2);
        ListNode result = addTwoNumbers(l1, l2);

        while(true){
            System.out.print(result.val);
            if(result.next == null){
                break;
            }
            result=result.next;
        }
        // System.out.println("-----");

        // while(true){
        //     System.out.print(l2.val);
        //     if (l2.next == null) {
        //         break;
        //     }
        //     l2=l2.next;
        // }
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode();
        ListNode resultNode = sumNode;
        boolean l1_eligible = true;
        boolean l2_eligible = true;
        boolean carry = false;
        int a = 0,b = 0;

        while(true){
            a = b =  0;

            if(l1_eligible){
                a = l1.val;
                if(l1.next == null){
                    l1_eligible = false;
                }
            }

            if(l2_eligible){
                b = l2.val;
                if(l2.next == null){
                    l2_eligible = false;
                }
            }
            
            if(carry){
                sumNode.val = (a + b + 1) % 10;
                carry = (a + b + 1) / 10 > 0 ? true : false;
            }
            else{
                sumNode.val = (a + b) % 10;
                carry = (a + b) / 10 > 0 ? true : false;
            }

            

            if(l1.next == null && l2.next == null) {
                if(carry){
                    ListNode tmp = new ListNode();
                    tmp.val = 1;
                    sumNode.next = tmp;
                    sumNode = tmp;
                }
                break;
            }
            else{
                ListNode tmp = new ListNode();
                sumNode.next = tmp;
                sumNode = tmp;
            }

            if(l1.next != null) l1 = l1.next;
            if(l2.next != null) l2 = l2.next;
        }

        return resultNode;
        
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