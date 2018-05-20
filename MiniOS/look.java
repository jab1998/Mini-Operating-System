

import java.util.Random;
import java.util.Scanner;
class look{
	public static void main(String args[])throws Exception{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for (int i=0;i<n;i++)
		{	
			//int k=sc.nextInt();
			//a[i]=k;
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
		//int header=sc.nextInt();
		int header=(int)(Math.random()*499);
		int prev=(int)(Math.random()*499);
		int sum=0;
		int rem=0;
		int pos=10000;
		int pos1=0;
		System .out.println("HEADER");
		System.out.println(header);
		//System .out.println("PREVIOUS");
		//System.out.println(prev);
		//System .out.println("POINTERS");
		if (header>199)
		{
			b[0]=header;
			int j=0;
			for (int i=0;i<a.length;)
			{
				if (a[i]>header)
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
				j++;
				b[j]=a[i];
				//System.out.println(b[j]);
				rem=a[i]-b[j-1];
				sum=sum+rem;
			}
			sum=sum+(499-b[j-1]);
			//j++;
			//b[j]=a[n];
			
			//System.out.println(b[j]);
			for (int i=pos-1;i>=0;i--)
			{
				j++;
				b[j]=a[i];
				//System.out.println(b[j]);
				rem=b[j-1]-a[i];
				sum=sum+rem;
			}
			}
			if (pos==10000)
			{
				j++;
				b[j]=a[n];
				pos=n;
				for (int i=pos-1;i>=0;i--)
				{
					j++;
					b[j]=a[i];
				}
			}
			j++;
			pos1=j;
		b[j]='\0';
				
		}
		if (header<=199)
		{
			b[0]=header;
			int j=0;
			for (int i=0;i<a.length;)
			{
				if (a[i]>header)
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
			for (int i=pos-1;i>=0;i--)
			{
				j++;
				b[j]=a[i];
				//System.out.println(b[j]);
				rem=b[j-1]-a[i];
				sum=sum+rem;
			}
			sum=sum+(b[j-1]-0);
			//j++;
			//b[j]=a[0];
			
			//System.out.println(b[j]);
			for (int i=pos;i<a.length;i++)
			{
				j++;
				b[j]=a[i];
				//System.out.println(b[j]);
				rem=a[i]-b[j-1];
				sum=sum+rem;
			}
			}
			if (pos==10000)
			{
				pos=n;
				for (int i=pos-1;i>=0;i--)
				{
					j++;
					b[j]=a[i];
				}
			}
			j++;
		b[j]='\0';
		pos1=j;
		}
		
		System.out.println("ARRAY");
		int sum1=0;
		for (int i=0;i<pos1-1;i++)
		{
			int rem1=b[i+1]-b[i];
			if (rem1<0)
			{
				rem1=rem1*(-1);
			}
			sum1=sum1+rem1;
			//System .out.println(sum1);
		}
		for (int i=0;i<pos1;i++)
		{	
			
			System.out.println(b[i]);
		}
		System .out.println("SUM");
		System.out.println(sum1);

}
}

