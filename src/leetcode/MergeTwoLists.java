package leetcode;

import util.ListNode;

/**
 * @ClassName MergeTwoLists
 * @Description 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author NebulaPort
 * @Date 2019/11/4 13:21
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        while(l1!=null){
            cur.next=l1;
            l1=l1.next;
            cur=cur.next;
        }
        while(l2!=null){
            cur.next=l2;
            l2=l2.next;
            cur=cur.next;
        }
        return head.next;
    }
}
