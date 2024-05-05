import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    public static void main(String[] args) {
        
        
        int raw1[] = { 1, 1, 1, 2, 3, 3, 4, 5};

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
        if(head.next.next == null && head.val == head.next.val) return null;
        
        HashMap<Integer,Integer> flags = new HashMap<Integer,Integer>();
        ListNode toBrowse = head;
        ListNode toRemove = head;
        ListNode mover = head;
        
        while(toBrowse != null){
            if(flags.containsKey(toBrowse.val)){
                flags.put(toBrowse.val, flags.get(toBrowse.val) + 1);
            }
            else{
                flags.put(toBrowse.val, 1);

            }
            toBrowse = toBrowse.next;
            
        }
        boolean headfound = false;

        while(toRemove != null){
            if(flags.get(toRemove.val) > 1){
                toRemove = toRemove.next;
            }
            else{
                if(!headfound){
                    headfound =  true;
                    head = toRemove;
                    mover = head;
                }
                else{
                    mover.next = toRemove;
                }
                toRemove = toRemove.next;
            }
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