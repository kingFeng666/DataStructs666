package Tree.Tree1;
/**
 * @ClassName: TreeTraversal
 * @Description:
 * @Author: 李峰
 * @Date: 2020 年 12月 04 14:54
 * @Version 1.0
 */
public class TreeTraversal {
    public static void preTraversal(TreeNode root){
        if (root!=null){
            //先处理跟节点
            System.out.print(root.v);
            //然后递归处理左子树
            preTraversal(root.left);
            //然后递归处理右子树
            preTraversal(root.right);
        }else {
            //如果是一颗空树什么也不干
        }
    }
    public static void inTraversal(TreeNode root){
        if (root!=null) {
            //先处理左子树
            inTraversal(root.left);
            //处理根节点
            System.out.print(root.v);
            //处理右子树
            inTraversal(root.right);
        }
    }
    public static void postTraversal(TreeNode root){
        if (root!=null) {
            //先处理左子树
            postTraversal(root.left);
            //再处理右子树
            postTraversal(root.right);
            //最后处理根节点
            System.out.print(root.v);
        }
    }



    public static void main(String[] args) {
        //把树的初始化封装进了一个方法中去
        BuildTree root = new BuildTree();
        //通过这个方法会创建一棵树
        TreeNode tree = root.Tree();
        System.out.print("前序遍历   :");
        preTraversal(tree);
        System.out.print("中序遍历  :");
        inTraversal(tree);
        System.out.print("后序遍历   ");
        postTraversal(tree);
    }
}
