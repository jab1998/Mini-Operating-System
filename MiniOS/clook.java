

import java.util.Random;
import java.util.Scanner;
class clook{
	public static void main(String args[])throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for (int i=0;i<n;i++)
		{
			a[i]=(int) (Math.random() *499 );
		}
		System .out.println("INPUT");
		for (int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
		for (int i=0;i<a.length;i++)
		{
			for (int j=0;j<a.length;j++)
			{
				if (a[i]<a[j])
				{
					int k=a[i];
					a[i]=a[j];
					a[j]=k;
				}
			}
		}
		int b[]=new int[1000];
		int header=(int)(Math.random()*499);
		System.out.println("header : "+header);
		int pos=10000;
		int j=0;
		b[j]=header;
		j++;
		for (int i=0;i<a.length;)
		{
			if (a[i]>=header)
			{
				pos=i;
				break;
			}
			else
			{
				i++;
			}
		}
		if (pos!=10000)
		{
			
		for (int i=pos;i<a.length;i++)
		{
			b[j]=a[i];
			j++;
		}
		}
		if (pos==10000)
		{
			pos=n;
		}
		for (int i=0;i<pos;i++)
		{
			b[j]=a[i];
			j++;
		}
		int pos1=j;
		b[j]='\0';
		j++;
		for (int i=0;i<pos1;i++)
		{
			System.out.println(b[i]);
		}
		int sum1=0;
		for (int i=0;i<pos1-1;i++)
		{
			int rem1=b[i+1]-b[i];
			if (rem1<0)
			{
				rem1=rem1*(-1);
			}
			sum1=sum1+rem1;
		}
		System.out.println("SUM : "+sum1);
}
}
