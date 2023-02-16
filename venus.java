import java.util.*;
class mars<T>
{
    private T[] o;
    mars(T[] arr)
    {
        o=arr;
    }

}
class venus
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
        mars<ArrayList> m = new mars<ArrayList>(l1);
    }
}