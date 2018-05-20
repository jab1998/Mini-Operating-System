import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.Hashtable;

public class MyPC extends JFrame {

  
  
private JPanel contentPane;
 
  private Hashtable actionHash = new Hashtable();

  public static void main(String[] args) {
    MyPC MyPC = new MyPC();
    MyPC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MyPC.setVisible(true);
  }
  
  public MyPC() {

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFileChooser chooser = new JFileChooser();
	      if (chooser.showOpenDialog(MyPC.this) !=JFileChooser.APPROVE_OPTION)
	        return;
	      File file = chooser.getSelectedFile();
	      if (file == null)
	        return;

	      FileReader reader = null;
	      try {
	        reader = new FileReader(file);
	      }
	      catch (IOException ex) {
	        JOptionPane.showMessageDialog(MyPC.this,"File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
	      }
	      finally {
	        if (reader != null) {
	          try {
	            reader.close();
	          } catch (IOException x) {}
	        }
	      }

}
}				
    

  




  

  


 
   

