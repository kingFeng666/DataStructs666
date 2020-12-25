package Tree.Tree1;
/**
 * @ClassName: TreeNodeSum
 * @Description:树的一些方法 1.递归非递归求一棵树的所有节点个数  2. 递归非递归求一棵树的所有叶子节点的个数
 * @Author: 李峰
 * @Date: 2020 年 12月 05 1:32
 * @Version 1.0
 */
public class TreeMethod {
    //统计一棵树中所有节点的个数 采用普通的遍历方式把每个节点都走一遍
    private static  int n;
    public static int NodeSum(TreeNode root){
        //每次计数之前先把n清0
        n=0;
        preOrder(root);
        System.out.println(n);
        return n;
    }
    //前序遍历
    public static void preOrder(TreeNode root){
        if (root!=null){
            n++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //也可以使用递归来求解  一棵树中所有节点的个数
    //树的节点个数=1(根)+左子树的节点个数+右子树的节点个数
    //然后递归求解
    public  static int NodeSum2(TreeNode root){
        /*递归分析
        首先求以A为节点的个数  root=1   left=4   right=5
        然后求A的左子树B节点的个数 root=1  left=3  right=0
        然后求B的左子树D为节点的个数  root =1  left=0   right=2
        然后求D的右子树G为节点的个数   root=1   left=1   right=0
        然后求G的左子树为节点的个数    root=1   left=0    right=0
        所以A的左子树的节点为4
        * */
         //使用递归的方式来求解树的节点的个数
        if (root==null){
            //相当于传进来的树是一颗空树
            return 0;
        }
        //节点不为空才进行下面的处理
        int rootNodeSize=1;
        int lestNodeSzie=NodeSum2(root.left);
        int rightNodeSzie=NodeSum2(root.right);
        return rootNodeSize+lestNodeSzie+rightNodeSzie;
    }


    //计算一棵树中的叶子节点的个数  思路 :叶子节点就是root.left==null&&roo.right==null
    //所以就遍历这棵树,如果满足上面的条件就让leafSzie++
    private static  int LeafSize;
    public static int LeafSum(TreeNode root){
        //每次计数之前先把n清0
        LeafSize=0;
        preOrder3(root);
        return LeafSize;
    }
    //前序遍历
    public static void preOrder3(TreeNode root){
        //每个节点都会走一遍 所以会统计出来所有节点的个数
        if (root!=null) {
            if (root.left == null && root.right == null) {
                LeafSize++;
            }
            preOrder3(root.left);
            preOrder3(root.right);
        }
    }

    //采用递归的方式来求解一棵树中叶子节点的个数
    public static int LeafSum2(TreeNode root){
        //这里的root已经不是节点了  要把他理解为以root为节点的树
        if (root==null){
            return 0;
        }else if (root.left==null&&root.right==null){
            return 1;
        }else{
            int LeftLeafSize=LeafSum2(root.left);
            int RightLeafSize=LeafSum2(root.right);
            return LeftLeafSize+RightLeafSize;
        }
    }
    //求第K层的节点个数  思路分析
    /*
     * 当传进来的是一棵空树的时候,return0
     * 当传进来的树只有一个节点并且k=1的时候  return  1
     * 求第k层的节点个数就相当于 求左子树k-1的节点的个数 +右子树k-1的节点的个数
     * 递归重复调用
     * */
    public static int kNodeSize(TreeNode root,int k) {
        if (root == null) {
            return 0;
        } else if (k == 1) {
            return 1;
        } else {
            int leftNodeSize = kNodeSize(root.left, k - 1);
            int rightNodeSize = kNodeSize(root.right, k - 1);
            return leftNodeSize + rightNodeSize;
        }
    }

    public static void main(String[] args) {
        BuildTree root = new BuildTree();
        TreeNode tree = root.Tree();
        //int i = NodeSum(tree);
        int i = NodeSum2(tree);
        System.out.println("树中的节点个数"+i);
        int i1 = LeafSum(tree);
        System.out.println("树中的叶子节点的个数"+i1);
        int i2 = LeafSum2(tree);
        System.out.println("树中叶子的节点的个数"+i2);
        int i3 = kNodeSize(tree, 4);
        System.out.println("第四层的节点个数为"+i3);
    }
}
