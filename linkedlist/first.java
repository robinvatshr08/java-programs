import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        next=null;
    }
}
class first
{
    public static Node input()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("enter nodes of linked List");
        int data;
        data=s.nextInt();
        Node head=null;
        Node tail=null;
        while(data!=-1)
        {
            Node cur=new Node(data);
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
    public static void print(Node head)
    {
        Node start= head;
        while(start!=null)
        {
            System.out.println(start.data);
            start=start.next;
        }
    }
       public static void main(String args[])
    {
        Node head =input();
        print(head);
    }

}

 