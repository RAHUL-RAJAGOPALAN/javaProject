import java.util.*;
class moon<T extends Number>
{
    private T sum;
    ArrayList<T> arr;
    moon(Object o, T s)
    {
        arr=(ArrayList)o;
        sum=s;
    }
    public void getnum()
    {
        for(int i=0;i<arr.size();i++)
        {
            sum = (T)(Integer)(sum.intValue() + arr.get(i).intValue());
            //sum = (T)o;
        }
        System.out.println("The sum is : "+sum);
    }
}
class sun
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> l1 =new ArrayList<Integer>();
        for(int i=0;i<5;i++)
        {
            System.out.println("Enter number :");
            l1.add(scan.nextInt());
        }
        moon<Integer> m = new moon<Integer>(l1,5);
        m.getnum();
    }
}