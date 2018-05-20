

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class gui_disk {

	public JFrame frame;
	private JTextField scan_out;
	private JTextField in_pro;
	private JTextField scan_header;
	private JButton btnLook;
//	private JTextField scan_header;
	private JTextPane scan_in;
//	private JTextPane scan_arr;
//	private JTextField scan_out;
//	private JTextField scan_header;
//	private JTextField scan_out;
	private JButton btnClook;
//	private JTextField scan_header;
//	private JTextPane scan_in;
//	private JTextPane scan_arr;
//	private JTextField scan_out;
//	private JButton btnHome;
//	private JTextField scan_header;
//	private JTextField scan_out;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui_disk window = new gui_disk();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public gui_disk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 799, 488);
	
		in_pro = new JTextField();
		in_pro.setBounds(183, 100, 86, 20);
		frame.getContentPane().add(in_pro);
		in_pro.setColumns(10);
		
		frame.getContentPane().setLayout(null);

		JTextPane scan_in = new JTextPane();
		scan_in.setBounds(183, 229, 372, 20);
		frame.getContentPane().add(scan_in);
		
		//JTextPane scan_arr = new JTextPane();
		//scan_arr.setForeground(Color.WHITE);
		//scan_arr.setBackground(Color.GRAY);
		//scan_arr.setBounds(170, 250, 372, 20);
		//frame.getContentPane().add(scan_arr);
		
		scan_header = new JTextField();
		//scan_header.setForeground(Color.WHITE);
		//scan_header.setBackground(Color.GREEN);
		scan_header.setBounds(183, 200, 86, 20);
		frame.getContentPane().add(scan_header);
		scan_header.setColumns(10);
		
		JButton btnScan = new JButton("scan");
		//btnScan.setBackground(Color.CYAN);
	//	btnScan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnScan.setBounds(631, 151, 89, 23);
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int n=Integer.valueOf(in_pro.getText());
				int a[]=new int[n];
				for (int i=0;i<n;i++)
				{	
					//int k=sc.nextInt();
					//a[i]=k;
					a[i]=(int) (Math.random() *499 );
				}
               String inp=String.valueOf(a[0]+"   ");
				
				for(int i=1;i<n;i++)
				{
					inp=inp.concat(a[i]+"   ");
				}
				
				scan_in.setText(inp);
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
				String outp=String.valueOf(header);
				scan_header.setText(outp);

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
					j++;
					b[j]=499;
					
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
						b[j]=499;
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
					j++;
					b[j]=0;
					
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
               String inp1=String.valueOf(b[0]+"   ");
				
				for(int i=1;i<pos1;i++)
				{
					inp1=inp1.concat(b[i]+"   ");
				}
				
			//	scan_arr.setText(inp1);
				System .out.println("SUM");
				String outp1=String.valueOf(sum1);
				scan_out.setText(outp1);

				System.out.println(sum1);
			}
		});
		frame.getContentPane().add(btnScan);
		
		
		
		scan_out = new JTextField();
	//	scan_out.setForeground(Color.WHITE);
	//	scan_out.setBackground(Color.RED);
		scan_out.setBounds(183, 259, 86, 20);
		frame.getContentPane().add(scan_out);
		scan_out.setColumns(10);
		
		
		
	//	scan_header = new JTextField();
	//	scan_header.setForeground(Color.WHITE);
	//	scan_header.setBackground(Color.GREEN);
	//	scan_header.setBounds(279, 151, 86, 20);
	//	frame.getContentPane().add(scan_header);
	//	scan_header.setColumns(10);
		
	//	scan_in = new JTextPane();
	//	scan_in.setForeground(Color.WHITE);
	//	scan_in.setBackground(Color.BLACK);
	//	scan_in.setBounds(283, 182, 36, 184);
	//	frame.getContentPane().add(scan_in);
		
	//	scan_arr = new JTextPane();
	//	scan_arr.setForeground(Color.WHITE);
	//	scan_arr.setBackground(Color.GRAY);
	//	scan_arr.setBounds(329, 182, 36, 184);
	//	frame.getContentPane().add(scan_arr);
		
	//	scan_out = new JTextField();
	//	scan_out.setForeground(Color.WHITE);
	//	scan_out.setBackground(Color.RED);
	//	scan_out.setBounds(279, 377, 86, 20);
	//	frame.getContentPane().add(scan_out);
	//	scan_out.setColumns(10);
		btnLook = new JButton("look");
	//	btnLook.setBackground(Color.ORANGE);
	//	btnLook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnLook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scanner sc=new Scanner(System.in);
				int n=Integer.valueOf(in_pro.getText());
				int a[]=new int[n];
				for (int i=0;i<n;i++)
				{	
					//int k=sc.nextInt();
					//a[i]=k;
					a[i]=(int) (Math.random() *499 );
				}
                String inp=String.valueOf(a[0]+"   ");
				
				for(int i=1;i<n;i++)
				{
					inp=inp.concat(a[i]+"   ");
				}
				
				scan_in.setText(inp);
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
				
				int sum=0;
				int rem=0;
				int pos=10000;
				int pos1=0;
				System .out.println("HEADER");
				String outp=String.valueOf(header);
				scan_header.setText(outp);

				System.out.println(header);
				//System .out.println("PREVIOUS");
				
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
				 String inp1=String.valueOf(b[0]+"   ");
					
					for(int i=1;i<pos1;i++)
					{
						inp1=inp1.concat(b[i]+"   ");
					}
					
					//scan_arr.setText(inp1);
					System .out.println("SUM");
					String outp1=String.valueOf(sum1);
					scan_out.setText(outp1);

					System.out.println(sum1);
				
			}
		});
		btnLook.setBounds(631, 188, 89, 23);
		frame.getContentPane().add(btnLook);
		
	//	scan_header = new JTextField();
	//	scan_header.setForeground(Color.WHITE);
	//	scan_header.setBackground(Color.GREEN);
	//	scan_header.setBounds(398, 151, 86, 20);
	//	frame.getContentPane().add(scan_header);
	//	scan_header.setColumns(10);
		
	//	JTextPane scan_in = new JTextPane();
	//	scan_in.setForeground(Color.WHITE);
	//	scan_in.setBackground(Color.BLACK);
	//	scan_in.setBounds(399, 182, 36, 184);
	//	frame.getContentPane().add(scan_in);
		
	//	JTextPane scan_arr = new JTextPane();
	//	scan_arr.setForeground(Color.WHITE);
	//	scan_arr.setBackground(Color.GRAY);
	//	scan_arr.setBounds(448, 182, 36, 184);
	//	frame.getContentPane().add(scan_arr);
		
	//	scan_out = new JTextField();
	//	scan_out.setForeground(Color.WHITE);
	//	scan_out.setBackground(Color.RED);
	//	scan_out.setBounds(399, 377, 86, 20);
	//	frame.getContentPane().add(scan_out);
	//	scan_out.setColumns(10);
		
		JButton btnCscan = new JButton("cscan");
	//	btnCscan.setBackground(Color.YELLOW);
	//	btnCscan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnCscan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Scanner sc=new Scanner(System.in);
				int n=Integer.valueOf(in_pro.getText());
				int a[]=new int[n];
				for (int i=0;i<n;i++)
				{
					//int k=sc.nextInt();
					//a[i]=k;
					a[i]=(int) (Math.random() *499 );
				}
				 String inp=String.valueOf(a[0]+"   ");
					
					for(int i=1;i<n;i++)
					{
						inp=inp.concat(a[i]+"   ");
					}
					
					scan_in.setText(inp);
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
				//int header=sc.nextInt();
				System.out.println("header : "+header);
				String outp=String.valueOf(header);
				scan_header.setText(outp);
				int pos=10000;
				int j=0;
				b[j]=header;
				//System.out.println(b[j]);
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
					//System.out.println(b[j]);
					b[j]=a[i];
					j++;
					//rem=a[i]-b[j-1];
				}
				b[j]=499;
				j++;
				b[j]=0;
				j++;
				}
				if (pos==10000)
				{
					
					b[j]=499;//System.out.println(b[j]);
					j++;
					b[j]=0;
					//System.out.println(b[j]);
					j++;
					pos=n;
				}
				for (int i=0;i<pos;i++)
				{
					b[j]=a[i];
					//System.out.println(b[j]);
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
				String inp1=String.valueOf(b[0]+"   ");
				
				for(int i=1;i<pos1;i++)
				{
					inp1=inp1.concat(b[i]+"   ");
				}
				
			//	scan_arr.setText(inp1);
				
				String outp1=String.valueOf(sum1);
				scan_out.setText(outp1);
			}
		});
		btnCscan.setBounds(631, 226, 89, 23);
		frame.getContentPane().add(btnCscan);
		
	//	scan_header = new JTextField();
//		scan_header.setForeground(Color.WHITE);
//	//	scan_header.setBackground(Color.GREEN);
	//	scan_header.setBounds(518, 151, 86, 20);
	//	frame.getContentPane().add(scan_header);
	//	scan_header.setColumns(10);
		
	//	scan_in = new JTextPane();
//		scan_in.setForeground(Color.WHITE);
//		scan_in.setBackground(Color.BLACK);
	//	scan_in.setBounds(513, 182, 36, 184);
	//	frame.getContentPane().add(scan_in);
		
	//	scan_arr = new JTextPane();
//		scan_arr.setForeground(Color.WHITE);
//		scan_arr.setBackground(Color.GRAY);
	//	scan_arr.setBounds(568, 182, 36, 185);
	//	frame.getContentPane().add(scan_arr);
		
	//	scan_out = new JTextField();
//		scan_out.setForeground(Color.WHITE);
//		scan_out.setBackground(Color.RED);
	//	scan_out.setBounds(518, 377, 86, 20);
	//	frame.getContentPane().add(scan_out);
	//	scan_out.setColumns(10);
		
		btnClook = new JButton("clook");
//		btnClook.setBackground(Color.BLUE);
//		btnClook.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnClook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int n=Integer.valueOf(in_pro.getText());
				int a[]=new int[n];
				for (int i=0;i<n;i++)
				{
					//int k=sc.nextInt();
					//a[i]=k;
					a[i]=(int) (Math.random() *499 );
				}
				String inp=String.valueOf(a[0]+"   ");
				
				for(int i=1;i<n;i++)
				{
					inp=inp.concat(a[i]+"   ");
				}
				
				scan_in.setText(inp);
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
				//int header=sc.nextInt();
				System.out.println("header : "+header);
				String outp=String.valueOf(header);
				scan_header.setText(outp);
				int pos=10000;
				int j=0;
				b[j]=header;
				//System.out.println(b[j]);
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
					//System.out.println(b[j]);
					b[j]=a[i];
					j++;
					//rem=a[i]-b[j-1];
				}
				//b[j]=a[n];
				//j++;
				//b[j]=a[0];
				//j++;
				}
				if (pos==10000)
				{
					
					//b[j]=a[n-1];//System.out.println(b[j]);
					//j++;
					//b[j]=a[0];
					//System.out.println(b[j]);
					//j++;
					pos=n;
				}
				for (int i=0;i<pos;i++)
				{
					b[j]=a[i];
					//System.out.println(b[j]);
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
				String inp1=String.valueOf(b[0]+"   "+'\n');
				
				for(int i=1;i<pos1;i++)
				{
					inp1=inp1.concat(b[i]+"   "+'\n');
				}
				
			//	scan_arr.setText(inp1);
				System.out.println("SUM");
				String outp1=String.valueOf(sum1);
				scan_out.setText(outp1);
				System.out.println("SUM : "+sum1);
			}
		});
		btnClook.setBounds(631, 260, 89, 23);
		frame.getContentPane().add(btnClook);

		
	//	scan_header = new JTextField();
	//	scan_header.setForeground(Color.WHITE);
	//	scan_header.setBackground(Color.GREEN);
	//	scan_header.setBounds(634, 151, 86, 20);
	//	frame.getContentPane().add(scan_header);
	//	scan_header.setColumns(10);
		
	//	JTextPane scan_in = new JTextPane();
	//	scan_in.setForeground(Color.WHITE);
	//	scan_in.setBackground(Color.BLACK);
	//	scan_in.setBounds(631, 182, 36, 184);
	//	frame.getContentPane().add(scan_in);
		
	//	JTextPane scan_arr = new JTextPane();
	//	scan_arr.setForeground(Color.WHITE);
	//	scan_arr.setBackground(Color.GRAY);
	//	scan_arr.setBounds(684, 182, 36, 184);
	//	frame.getContentPane().add(scan_arr);
		
	//	scan_out = new JTextField();
	//	scan_out.setForeground(Color.WHITE);
	//	scan_out.setBackground(Color.RED);
	//	scan_out.setBounds(631, 377, 86, 20);
	//	frame.getContentPane().add(scan_out);
		scan_out.setColumns(10);
		
		JButton btnFcfs = new JButton("fcfs");
	//	btnFcfs.setBackground(Color.MAGENTA);
	//	btnFcfs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n=Integer.valueOf(in_pro.getText());
				int a[]=new int[n];
				for (int i=0;i<n;i++)
				{
					int k=(int)(Math.random()*499);
					a[i]=k;
				}
                String inp=String.valueOf(a[0]+"   ");
				
				for(int i=1;i<n;i++)
				{
					inp=inp.concat(a[i]+"   ");
				}
				
				scan_in.setText(inp);
				System.out.println("INPUT");
				for (int i=0;i<n;i++)
				{
					System.out.println(a[i]);
				}
				int b[]=new int[n+1];
				int header=(int)(Math.random()*499);
				System.out.println("HEADER : "+header);
				String outp=String.valueOf(header);
				scan_header.setText(outp);

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
				String inp1=String.valueOf(b[0]+"   "+'\n');
				
				for(int i=1;i<pos;i++)
				{
					inp1=inp1.concat(b[i]+"   "+'\n');
				}
				
			//	scan_arr.setText(inp1);
				System .out.println("SUM");
				String outp1=String.valueOf(sum);
				scan_out.setText(outp1);
				
			}
		});
		btnFcfs.setBounds(631, 117, 89, 23);
		frame.getContentPane().add(btnFcfs);
		
		JLabel lblNewLabel = new JLabel("Header");
	//	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(26, 200, 102, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total Head Movement");
	//	lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 259, 131, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblInput = new JLabel("Input");
	//	lblInput.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInput.setBounds(26, 229, 115, 20);
		frame.getContentPane().add(lblInput);
		
		JLabel lblProcesses = new JLabel("No. of Requests");
	//	lblProcesses.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProcesses.setBounds(21, 100, 102, 17);
		frame.getContentPane().add(lblProcesses);
		
		JLabel lblDiskManagement = new JLabel("DISK SCHEDULING ALOGORITHMS");
		lblDiskManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 23));
		lblDiskManagement.setBounds(190, 22, 450, 40);
		frame.getContentPane().add(lblDiskManagement);
		
		
		
		
		
		
		
		
		
		
	}
}
