
import java.util.Random;
import java.util.Scanner;
class fcfs{
	public static void main(String args[])throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for (int i=0;i<n;i++)
		{
			int k=(int)(Math.random()*499);
			a[i]=k;
		}
		System.out.println("INPUT");
		for (int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		int b[]=new int[n+1];
		int header=(int)(Math.random()*499);
		System.out.println("HEADER : "+header);
		int j=0;
		b[j]=header;
		j++;
		for (int i=0;i<n;i++)
		{
			b[j]=a[i];
			j++;
		}
		int pos=j;
		
		int sum=0;
		for (int i=0;i<pos-1;i++)
		{
			int rem=b[i+1]-b[i];
			if (rem<0)
			{
				rem=rem*(-1);
			}
			sum=sum+rem;
		}
		System.out.println("OUTPUT");
		for (int i=0;i<pos;i++)
		{
			System.out.println(b[i]);
		}
		System.out.println("SUM");
		System.out.println(sum);
	}
}
			
