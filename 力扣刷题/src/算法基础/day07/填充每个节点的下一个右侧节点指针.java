package 算法基础.day07;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class 填充每个节点的下一个右侧节点指针 {


//    public Node connect(Node root) {
//        if(root==null){
//            return null;
//        }
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.offer(root);//将root先加入队列
//        while (!queue.isEmpty()){
//            int n = queue.size();
//            Node last = null;//上一个节点
//            //遍历每一层
//            for(int i=1;i<=n;i++){
//                Node f = queue.poll();//将当前节点出队
//                if(f.left!=null){
////                    将左孩子入队
//                    queue.offer(f.left);
//                }
//                if(f.right!=null){
////                    将右孩子入队
//                    queue.offer(f.right);
//                }
//                if(i!=1){
////                    如果不是每一层的最左第一个节点
//                    last.next=f;  //将上一个节点的next指向当前节点，每一层形成一个链表
//                }
//                last = f;//更新last
//            }
//        }
//        return root;

//    }
}
