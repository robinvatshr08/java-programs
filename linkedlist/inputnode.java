package linkedlist;
import java.util.*;

import javax.swing.tree.TreeNode;



class inputnode
{
    public static Node<Integer> input()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("enter nodes of linked List");
        int data;
        data=s.nextInt();
        Node<Integer> head=null;
        Node<Integer> tail=null;
        while(data!=-1)
        {
            Node<Integer> cur=new Node<>(data);
        if(head==null)
        {
            head=cur;
            tail=cur;
        }
        else
        
        {
            
            tail.next=cur;
            tail=tail.next;
        }
        data=s.nextInt();
       }
    return head;

    }


    public static void print(Node<Integer> head)
    {
        Node<Integer> start= head;
        while(start!=null)
        {
            System.out.println(start.data);
            start=start.next;
        }
    }


       public static void printR(Node<Integer> head)
    {
        if(head==null)
        return ;
        System.out.println(head.data);
        printR(head.next);
        
    }


    public static Node<Integer> addR(Node<Integer> head,int pos,int elm)
    {
        if(head==null)
        return null;
        Node<Integer> cur=new Node<>(elm);
        if(pos==0)
        {
            cur.next=head;
            return cur;
        }
        
          head.next=addR(head.next,pos-1,elm);
          return head;
    }
    
    public static Node<Integer> deleteR(Node<Integer> head,int pos)
    {
        if(pos==0)
         return head.next;
        if(head==null)
        return null;
        head.next=deleteR(head.next,pos-1);
         return head;

    }

       public static void main(String args[])
    {
        Node<Integer> head =input();
        //printR(head);
        System.out.println("enter node data to be inserted");
        Scanner s=new Scanner(System.in);
        int elm = s.nextInt();
        System.out.println("enter position");
        int pos=s.nextInt();
        
        //head=addR(head,pos,elm);
        head=deleteR(head,pos);
        print(head);
    }
 
}

 