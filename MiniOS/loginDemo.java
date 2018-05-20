import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.text.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

  
@SuppressWarnings("serial")
class login extends JFrame implements ActionListener {
  JButton SUBMIT;
  JPanel panel;
  JLabel label1,label2;
  private JTextField textField;
  private JTextField textField_1;
   login()  {
   label1 = new JLabel();
   label1.setBounds(87, 57, 83, 26);
   label1.setText("Username:");
 
   label2 = new JLabel();
   label2.setBounds(87, 126, 83, 26);
   label2.setText("Password:");
  
   SUBMIT=new JButton("LOGIN");
   SUBMIT.setBounds(154, 188, 105, 34);
   
   panel=new JPanel();
   panel.setLayout(null);
   panel.add(label1);
   panel.add(label2);
   panel.add(SUBMIT);
   getContentPane().add(panel,BorderLayout.CENTER);
   
   textField = new JTextField();
   textField.setBounds(223, 60, 105, 26);
   panel.add(textField);
   textField.setColumns(10);
   
   textField_1 = new JTextField();
   textField_1.setBounds(223, 129, 105, 26);
   panel.add(textField_1);
   textField_1.setColumns(10);
   SUBMIT.addActionListener(this);
   setTitle("LOGIN FORM");
   }
  public void actionPerformed(ActionEvent ae)
   {
   String value1=textField.getText();
   String value2=textField_1.getText();
   if (value1.equals("aravind") && value2.equals("1967")) {
   this.dispose();
   Desktop d=new Desktop();
   d.setVisible(true);
   //JLabel label = new JLabel("Mee Avida Pujaaa....");
   //d.getContentPane().add(label);
   }
   else{
   System.out.println("enter the valid username and password");
   JOptionPane.showMessageDialog(this,"Incorrect login or password",
   "Error",JOptionPane.ERROR_MESSAGE);
   }
 }
 }
  class loginDemo
 {
   private JPanel contentPane;
   public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
   			try {
   				login frame=new login();
   				frame.setBounds(100, 100, 450, 300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   				frame.setVisible(true);
   			    }
		        catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			    }
  		 }

	});
}
}

@SuppressWarnings("serial")
class Desktop extends JFrame {
	//private JFrame frame;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desktop frame = new Desktop();
					frame.setSize(500,400);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 Desktop()  {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setTitle("Desktop");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton com = new JButton(new ImageIcon("mycomputer.jpg"));
		com.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyPC c = new MyPC();
			}
		});
		com.setBounds(10, 29, 135, 96);
		contentPane.add(com);
		
		JButton text=new JButton(new ImageIcon("editor.jpg"));
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor t = new Editor();
				t.setVisible(true);
			}
		});
		text.setBounds(339, 29, 135, 96);
		contentPane.add(text);

		
		JButton ter = new JButton(new ImageIcon("terminal.jpg"));
		ter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Terminal term = Terminal.getInstance();
        			term.open(0, 0, 1000, 600);
			}
		});
		ter.setBounds(180, 29, 135, 96);
		contentPane.add(ter);

		
		JButton disk = new JButton(new ImageIcon("disk.jpg"));
		disk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		disk.setBounds(72, 207, 135, 96);
		contentPane.add(disk);
		
		JButton game = new JButton(new ImageIcon("snake.jpg"));
		game.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game g = new Game();
				g.setVisible(true);
			}
		});
		game.setBounds(275, 207, 135, 96);
		contentPane.add(game);
		
		JLabel lblFileManager = new JLabel("File Manager");
		lblFileManager.setBounds(45, 130, 79, 18);
		contentPane.add(lblFileManager);
		
		JLabel lblTerminal = new JLabel("Terminal");
		lblTerminal.setBounds(213, 130, 79, 18);
		contentPane.add(lblTerminal);
		
		JLabel lblNotepad = new JLabel("Notepad");
		lblNotepad.setBounds(372, 130, 79, 18);
		contentPane.add(lblNotepad);
		
		JLabel lblAlgorithms = new JLabel("Algorithms");
		lblAlgorithms.setBounds(110, 308, 79, 18);
		contentPane.add(lblAlgorithms);
		
		JLabel lblSnakeGame = new JLabel("Snake Game");
		lblSnakeGame.setBounds(304, 308, 79, 18);
		contentPane.add(lblSnakeGame);
		
	}

}
