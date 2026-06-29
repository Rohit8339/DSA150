class Solution {
    private ListNode solve(ListNode l1, ListNode l2) {
        if (l1.next == null) {
            l1.next = l2;
            return l1;
        }

        ListNode curr1 = l1;
        ListNode next1 = l1.next;
        ListNode curr2 = l2;

        while (next1 != null && curr2 != null) {
            if (curr2.val >= curr1.val && curr2.val <= next1.val) {
                ListNode next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;
                
                curr1 = curr2;
                curr2 = next2;
            } else {
                curr1 = next1;
                next1 = next1.next;
                
                if (next1 == null) {
                    curr1.next = curr2;
                    return l1;
                }
            }
        }
        return l1;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val <= list2.val) {
            return solve(list1, list2);
        } else {
            return solve(list2, list1);
        }
    }
}
