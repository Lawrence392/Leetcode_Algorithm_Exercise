package Other;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
}


public class Binarytree {
    // 输出前缀二叉树-递归
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        fun1(root, list);
        return list;
    }
    public static void fun1(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        fun1(root.left,list);
        fun1(root.right,list);
        
        return;
    }
    // 输出前缀二叉树-迭代
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    // 输出中缀二叉树-递归    
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        fun2(root,list);
        return list;
    }
    public static void fun2(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        fun2(root.left,list);
        list.add(root.val);
        fun2(root.right,list);
        
        return;
    }
    // 输出中缀二叉树-迭代    
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    // 输出后缀二叉树-递归
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        fun3(root, list);
        return list;
    }
    public static void fun3(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        fun3(root.left,list);
        fun3(root.right,list);
        list.add(root.val);
        return;
    }
    // 输出后缀二叉树-迭代
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
            list.add(node.val);
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    // 逐层输出二叉树-迭代
    public static List<List<Integer>> levelOrder(TreeNode root) {
    //边界条件判断
        if (root == null)
            return new ArrayList<>();
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //根节点入队
        queue.add(root);
        //如果队列不为空就继续循环
        while (!queue.isEmpty()) {
            //BFS打印，levelNum表示的是每层的结点数
            int levelNum = queue.size();
            //subList存储的是每层的结点值
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                //出队
                TreeNode node = queue.poll();
                subList.add(node.val);
                //左右子节点如果不为空就加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把每层的结点值存储在res中，
            res.add(subList);
        }
        return res;
    }


    //输出二叉树的最大深度-递归
    public static int maxDepth1(TreeNode root) {
        if(root == null){return 0;}
        int leftdepth = maxDepth1(root.left);
        int rightdepth = maxDepth1(root.right);
        return Math.max(leftdepth, rightdepth) + 1;
    }
    //输出二叉树的最大深度-迭代
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int size = 0;
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            size = queue.size();
            while(size > 0){
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
                size--;
            }
            ans++;
        }            
        return ans;
    }
    //路径之和为targetSum
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(targetSum - root.val == 0){
            return true;
        }
        return  hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    // 


    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2,treeNode3,null);
        TreeNode treeNode1 = new TreeNode(1,null,treeNode2);
        // List<Integer> list = Binarytree.postorderTraversal2(treeNode1);

        // int depth = maxDepth1(treeNode1);
        // System.out.println(depth);
        if(hasPathSum(treeNode1,6)){
            System.out.println("yes");
        }
    }
}


class Solution2 {
    int pre_idx;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
    
    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }
        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);
        // 下标减一
        pre_idx++;
        // 构造左子树
        root.left = helper(in_left, index - 1);
        // 构造右子树
        root.right = helper(index + 1, in_right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // int[] preorder, int[] inorder
        this.preorder = preorder;
        this.inorder = inorder;
        pre_idx = 0;
        
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        new Solution2().buildTree(preorder, inorder);


    }
}



