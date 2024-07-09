package linkedlist;

class Recursion
{
    /**
     * @param head
     * @return
     */
    public static void printR(Node head)
    {
        if(head==null)
        return ;
        System.out.println(head.data);
        printR(head.next);
        
    }
    public static void main(String args[])
    {
        Node head =input();
        printR(head);
    }
    private static Node input() {
        return null;
    }
}