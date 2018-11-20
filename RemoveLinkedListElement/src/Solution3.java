class Solution3 {
    /**
     * leetcode 203
     * 递归链表删除指定元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        if(head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
        /*ListNode res = removeElements(head.next,val);
        if(head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }*/
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println(new Solution3().removeElements(head, 6));
    }

}
