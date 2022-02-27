package 算法基础.day03;


/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class 删除排序链表中的重复元素 {

//    public ListNode deleteDuplicates(ListNode head) {
//
//        if(head==null)
//            return head;
//        ListNode dummy = new ListNode(0,head);
////        哑变量  指向头指针
//        ListNode cur = dummy;
//        while (cur.next!=null && cur.next.next!=null){
//
//                if(cur.next.val==cur.next.next.val){
////                    出现重复
//                    int x = cur.next.val;
//                    while (cur.next!=null && cur.next.val == x ){
//                        cur.next = cur.next.next;
//                    }
//                }else{
//                    cur = cur.next;
//                }
//
//        }
//        return dummy.next;
//    }
//
//
//    public ListNode deleteDuplicates2(ListNode head) {
//        if(head==null){
//            return head;
//        }
//
//        ListNode dummy = new ListNode(0,head); //指向头节点
//        ListNode cur = dummy;
//        while (cur.next!=null && cur.next.next!=null){
//            if(cur.next.val==cur.next.next.val){
////                出现重复
//                int x = cur.next.val;
//                while(cur.next!=null && cur.next.val==x){
//                    cur.next= cur.next.next;
//                }
//            }
//            else{
//                cur = cur.next;
//            }
//        }
//        return dummy.next;
//    }

}
