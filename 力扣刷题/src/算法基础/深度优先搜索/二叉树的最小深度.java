package 算法基础.深度优先搜索;

public class 二叉树的最小深度 {

//    public int minDepth(TreeNode root) {
//        if(root==null)
//            return 0;
//        if(root.left==null && root.right==null)
//            return 1;
//        int min_depth = Integer.MAX_VALUE;
//        if(root.left!=null){
//            min_depth = Math.min(minDepth(root.left),min_depth);
//        }
//        if(root.right!=null){
//            min_depth = Math.min(minDepth(root.right),min_depth);
//        }
//        min_depth+=1;
//        return min_depth;
//    }


//    public int minDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//
////        1,当左右孩子都为空时，即叶子节点，返回1
//        if(root.left==null && root.right==null){
//            return 1;
//        }
////        2,当左右节点有一个为空时
//        int m1 = minDepth(root.left);
//        int m2 = minDepth(root.right);
//        if(root.left==null || root.right==null){
////            左右节点有一个为空时，mi和m2有一个为0  返回m1+m2+1即可
//            return m1+m2+1;
//        }
////        3,左右节点都不为空时    返回较小的
//        return Math.min(m1,m2)+1;
//
//    }
}
