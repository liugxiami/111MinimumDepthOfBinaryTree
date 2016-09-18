package com.ccsi;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	    TreeNode root=buildTree();
        System.out.println(minDepth2(root));
    }
    //Given a binary tree,find its minimum depth.
    //The minimum depth is the number of nodes along the shortest path from the root node
    //down to the nearest leaf node.
    //1.DFS
    public static int minDepth1(TreeNode root){
        if(root==null)return 0;
        return 1+Math.min(minDepth1(root.left),minDepth1(root.right));
    }
    //2.BFS
    public static int minDepth2(TreeNode root){
        if(root==null)return 0;
        int minDepth=Integer.MAX_VALUE;
        Queue<TreeNode> queue=new LinkedList<>();
        Queue<Integer> height=new LinkedList<>();
        queue.offer(root);
        height.offer(0);
        while (!queue.isEmpty()){
            TreeNode curr=queue.poll();
            int h=height.poll();
            if(curr.left==null&&curr.right==null){
                minDepth=minDepth>h?h:minDepth;
            }else {
                if(curr.left!=null){
                    queue.offer(curr.left);
                    height.offer(h+1);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                    height.offer(h+1);
                }
            }
        }
        return minDepth;
    }
    public static TreeNode buildTree(){
        TreeNode root=new TreeNode(5);
        root.left=new TreeNode(4);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(11);
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(2);
        root.right.left=new TreeNode(13);
        root.right.left.left=new TreeNode(10);
        root.right.right=new TreeNode(4);
        root.right.right.right=new TreeNode(1);
        root.right.right.right.right=new TreeNode(9);
        return root;
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
