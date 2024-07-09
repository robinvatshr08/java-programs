package recursionexample;

public class printnumber {
    public static int number(int n)
    {
        if(n==0)
        return 0;
        int a= number(n-1)+1;
        System.out.println(a);
        return a;

    }
    public static int digit(int n)
    {
        if(n==0)
        {
            return 0;

        }
        return digit(n/10)+1;
    }
    public static void main(String [] args)
    {
       // int b=number(4);
        int c=digit(404000);
        System.out.println(c);
    }
    
}
