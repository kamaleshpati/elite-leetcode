class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Leet2AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode((l1.val+l2.val)%10);
        int remain = (l1.val+l2.val)/10;
        addTwoNumbers(l1.next,l2.next,l3,remain);
        return l3;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, ListNode l3, int remain) {
        if(l1 != null && l2 != null){
            l3.next = new ListNode((l1.val+l2.val+remain)%10);
            remain = (l1.val+l2.val+remain)/10;
            return addTwoNumbers(l1.next,l2.next,l3.next,remain);
        }

        else if(l1 != null && l2 == null){
            l3.next = new ListNode((l1.val+remain)%10);
            remain = (l1.val+remain)/10;
            return addTwoNumbers(l1.next,l2,l3.next,remain);
        }

        else if(l1 == null && l2 != null){
            l3.next = new ListNode((l2.val+remain)%10);
            remain = (l2.val+remain)/10;
            return addTwoNumbers(l1,l2.next,l3.next,remain);
        }
        else{
            if(remain != 0){
                l3.next = new ListNode(remain);
            }
        }

        return l3;
    }

}
