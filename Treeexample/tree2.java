package Treeexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class tree2 {
    public static int height(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return 1 + Math.max(l, r);
    }

    public static TreeNode<Integer> input() {
        Scanner s = new Scanner(System.in);
        int rootdata;
        Queue<TreeNode<Integer>> que = new LinkedList<>();
        System.out.println("enter root data");
        rootdata = s.nextInt();
        if (rootdata == -1) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode<Integer>(rootdata);
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode<Integer> front = que.poll();

            System.out.println("enter left children of " + front.data);
            int leftchild = s.nextInt();
            if (leftchild != -1) {
                TreeNode<Integer> child = new TreeNode<>(leftchild);

                front.left = child;

                que.add(front.left);
            }

            System.out.println("enter right children of " + front.data);
            int rightchild = s.nextInt();
            if (rightchild != -1) {
                TreeNode<Integer> child1 = new TreeNode<>(rightchild);

                front.right = child1;

                que.add(front.right);
            }
        }
        return root;
    }

    public static int diameter(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int LR = height(root.left) + height(root.right);
        int LDia = diameter(root.left);
        int RDia = diameter(root.right);
        return Math.max(LDia, Math.max(LR, RDia));
    }

    public static void print(TreeNode<Integer> root) {
        // if (root == null)
        //     return;
        // String  ans="";
        // ans=ans+root.data;
        // if(root.left!=null){
        //     ans=ans+" : L-"+root.left.data;
        // }
        // if(root.right!=null){
        //     ans=ans+",R-"+root.right.data;
        // }
        // System.out.println(ans);
        // print(root.left);
        // print(root.right);

        if (root == null)
         return;
        // System.out.print(root.data+":");
        // if(root.left!=null){
        //     System.out.print(" R-"+root.left.data);
        // }
        // if(root.right!=null){
        //     System.out.print(",L-"+root.right.data);
        // }
        // System.out.println();
        // print(root.left);
        // print(root.right);
        Queue<TreeNode<Integer>> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode<Integer>cur=que.poll();
            System.out.println(cur.data);
            if(cur.left!=null){
                que.add(cur.left);

            }
            if(cur.right!=null){
                que.add(cur.right);
            }
        
        }
    }

    public static int countNode(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        
        int leftcount =countNode(root.left);
        int rightcount=countNode(root.right);
       
        return 1+leftcount+rightcount;

    }

    public static int largest(TreeNode<Integer> root) {

        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int max = root.data;
        int leftdata = largest(root.left);
       
        int rightdata = largest(root.right);
       
        return  Math.max(leftdata,Math.max(max, rightdata) );

    }

       // Function to return the diameter of a Binary Tree.
   public  Pair<Integer, Integer> heightDiameter(TreeNode<Integer> root) {
        if (root == null) {
            Pair<Integer, Integer> output = new Pair<>();
            output.first = 0;
            output.second = 0;
            return output;
        }
        //option 1
        Pair<Integer, Integer> lo = heightDiameter(root.left);
        //option 2
        Pair<Integer, Integer> ro = heightDiameter(root.right);
        //option 3
        int LR = lo.first + ro.first+1;
        
        int LT = lo.second;
        int RT = ro.second;
        
        Pair<Integer, Integer> output = new Pair<>();
        output.first =Math.max(lo.first,ro.first)+1 ;
        output.second = Math.max(LT, Math.max(RT, LR));
        return output;
    }
    
    public  static  int leafNode(TreeNode<Integer>  root){
        if(root==null){
            return  0;
        }
       
        if(root.left==null  && root.right==null ){
            return  1;
        }
        return  leafNode(root.left)+leafNode(root.right) ;
       
    }
    
    //Tree  traversal
    public  static  void    inOrder(TreeNode<Integer >   root){
        if(root==null){
            return;
        }
        
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public  static  void    preOrder(TreeNode<Integer >   root){
        if(root==null){
            return;
        }
        
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public  static  void    postOrder(TreeNode<Integer >   root){
        if(root==null){
            return;
        }
        
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    public  static  TreeNode<Integer>BuildTree(int[] in,int[] pre){
        return  treeHelper(in,pre,0,in.length-1,0,pre.length-1);
    }
    public static  TreeNode<Integer>   treeHelper(int[] in,int[] pre,int inS,int inE,int preS,int preE){
        if(inS>inE){
            return  null;
        }
        int rootdata=pre[preS];
        TreeNode<Integer>   root=new    TreeNode<Integer>(rootdata);
        int rootIndex=-1;
        for(int i=inS;i<=inE;i++){
            if(rootdata==in[i]){
                rootIndex=i;
                break;
            }
        }
        if(rootIndex==-1){
            return  null;
        }

        int LinS=inS;
        int LinE=rootIndex-1;
        int LpreS=preS+1;
        int LpreE=LinE-LinS+LpreS;
        int RinS=rootIndex+1;
        int RinE=inE;
        int RpreS=LpreE+1;
        int RpreE=preE;
        root.left=treeHelper(in, pre, LinS, LinE, LpreS, LpreE);
        root.right=treeHelper(in, pre, RinS, RinE, RpreS, RpreE);
        return  root;
    }
    public static  ArrayList<Integer> noSibling(TreeNode<Integer> root)
    {
        ArrayList<Integer>   li=new  ArrayList<>();
        if(root==null){
           
            
            return li ;
        }
        if (root.left != null && root.right != null)
        {
          noSibling(root.left);
          noSibling(root.right);
        }
        else if(root.left!=null  &&  root.right==null){
        li.add(root.left.data);
        System.out.println(li);
        }
        else if(root.left==null  &&  root.right!=null){
        li.add(root.right.data);
        System.out.println(li);
        }
        noSibling(root.left);
        noSibling(root.right);
        System.out.println(li+"g");
        Collections.sort(li);
        //System.out.println(li);
        
        if(li.isEmpty())
            li.add(-1);
      
        return  li;
    }
    public  static  void    zigzagPrint(TreeNode<Integer>   root){
        if(root==null){
            return;
        }
        Queue<TreeNode<Integer>> que = new LinkedList<>();
        que.add(root);
        int l=1;
        while (!que.isEmpty()) {
         TreeNode<Integer>cur=que.poll();
         l++;
        
         if(l%+2==0){
             System.err.println(cur.data);
            if(cur.right!=null){
                que.add(cur.right);
            }
            if(cur.left!=null){
                que.add(cur.left);
            }
         }  
         else{
            if(cur.left!=null){
                que.add(cur.left);
            }
            if(cur.right!=null){
                que.add(cur.right);
            }
            
         } 
        }
    }
    public static void main(String[] args) {
        //TreeNode<Integer> root1 = input();
        //print(root1);
        
       
        // System.out.println("largest node is "+largest(root1));
        // System.out.println("height  of  tree    is :" + height(root1));
        // System.out.println("Diameter    of  tree is :" + diameter(root1));
        // System.out.println("Diameter    of  tree is :" + heightDiameter(root1).second);
        // System.out.println("height is  :" + heightDiameter(root1).first);
        
    //Tree  traversal
    //    System.out.println("inorder    traversal   of  tree" );
    //     inOrder(root1);

    //     System.out.println("Preorder    traversal   of  tree" );
    //     preOrder(root1);

    //     System.out.println("Postorder    traversal   of  tree" );
    //     postOrder(root1);

    //BuildTree from inorder and preOrder tree
        int in[]={3,2,8,1,4,11};
        int pre[]={1,2,3,8,4,11};
         TreeNode<Integer> root=BuildTree(in,pre);
       print(root);
       zigzagPrint( root);
    //    System.out.println("total node in tree "+countNode(root));
    //    System.out.println("total leaf node is  :" + leafNode(root));

    //  ArrayList<Integer>   ans=noSibling(root);
    //    System.out.println(ans);


    }

}
