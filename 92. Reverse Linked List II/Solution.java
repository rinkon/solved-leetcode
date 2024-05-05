
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public static void main(String[] args) {
        
        
        int raw1[] = { 5, 1, 3, 3, 2, 4 };
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
        if(left == right) return head;
        int index = 0;
        ListNode toBrowse = head;
        ListNode leftEnd = head;
        ListNode rightEnd = head;
        ListNode temp = new ListNode();
        ListNode prev = new ListNode();
        boolean ended = false;
        

        while(toBrowse != null){
            index++;
            if(index >= left && index <= right){
                if(index == left){
                    rightEnd = toBrowse;
                    prev = toBrowse;
                }
                
                else{
                    temp = new ListNode(toBrowse.val, prev);
                    prev = temp;
                    if (index == right && left != 1) {
                        leftEnd.next = prev;
                    }
                    else if(index == right && left == 1){
                        head = prev;
                    }
                    
                }
            }
            if(index<left && left != 1){
                leftEnd = toBrowse;
            }
            if(index > right){
                if(!ended){
                    ended = true;
                    rightEnd.next = toBrowse;
                }
            }
            if(index == right && toBrowse.next == null){
                rightEnd.next = null;
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