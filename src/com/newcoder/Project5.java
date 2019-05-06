package com.newcoder;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Project5{
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0)
            return null;
        TreeNode node = new TreeNode(pre[0]);
        if(pre.length == 1)
            return node;
        int i = 0;
        for(;i<in.length;i++){
            if(pre[0] == in[i])
                break;
        }
        if(pre.length -i -1 <0)
            System.out.println(pre[0]+ " "+ pre[1] + i);
        int [] preLeft = new int [i];
        int [] preRight = new int [pre.length - i -1];
        int [] inLeft = new int [i];
        int [] inRight = new int [in.length - i -1];
        System.arraycopy(in,0,inLeft,0,i);
        System.arraycopy(in,i+1,inRight,0,in.length - i -1);
        System.arraycopy(pre,1,preLeft,0,i);
        System.arraycopy(pre,i+1,preRight,0,in.length - i -1);
        node.left = reConstructBinaryTree(preLeft,inLeft);
        node.right = reConstructBinaryTree(preRight,inRight);
        System.out.print("node"+node.val+node.left.val+node.right.val);

        return node;
    }
    public static void main(String [] args){
        Project5 p =new Project5();
        int [] pre  = {1,2,3,4,5,6,7};
        int [] in ={3,2,4,1,6,5,7};
        p.reConstructBinaryTree(pre,in);
    }
}
