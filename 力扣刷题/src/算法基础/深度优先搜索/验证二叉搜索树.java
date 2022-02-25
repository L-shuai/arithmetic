package 算法基础.深度优先搜索;

public class 验证二叉搜索树 {

/**
 * 如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
 * 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * 它的左右子树也为二叉搜索树。
 */
//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
//    }
//
//    public boolean isValidBST(TreeNode root,long lower,long upper) {
//        if(root ==null){
//            return true;
//        }
//        if(root.val<=lower || root.val>=upper){
//            return false;
//        }
//        return isValidBST(root.left,lower,root.val) && isValidBST(root.right,root.val,upper);
//
//    }
}
