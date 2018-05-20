import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.*;
import java.util.Date;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;


class Terminal {
    public JFrame frm = new JFrame("Terminal");
    private JTextArea txtArea = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane();    
    private CommandProcessor processor = CommandProcessor.getInstance();
    private final String LINE_SEPARATOR = System.lineSeparator();
    private Font font = new Font("SansSerif", Font.BOLD, 15);
    private String path=".";
    private String directory=" >";
    Terminal() {
        frm.getContentPane().add(scrollPane);
        scrollPane.setViewportView(txtArea);
        txtArea.addKeyListener(new KeyListener());
        txtArea.setFont(font);
        disableArrowKeys(txtArea.getInputMap());
    }

    private void disableArrowKeys(InputMap inputMap) {
	System.out.println(inputMap);
        String[] keystrokeNames = { "UP", "DOWN", "LEFT", "RIGHT", "HOME" };
        for (int i = 0; i < keystrokeNames.length; ++i)
            inputMap.put(KeyStroke.getKeyStroke(keystrokeNames[i]), "none");
    }

    public void open(final int xLocation, final int yLocation, final int width,
            final int height) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frm.setBounds(xLocation, yLocation, width, height);
                frm.setVisible(true);
                showPrompt();
            }
        });
    }

    public void close() {
        frm.dispose();
    }

    public void clear() {
        txtArea.setText("");
        showPrompt();
    }

    private void showPrompt() {
        txtArea.setText(txtArea.getText()+directory+"> ");
    }
	public static void Dir(String name,String pa){
//Scanner reader = new Scanner(System.in);
        boolean success = false;

        System.out.println("Enter path of directory to create");
        String dir = pa+'/'+name;

        // Creating new directory in Java, if it doesn't exists
        File directory = new File(dir);
        if (directory.exists()) {
            System.out.println("Directory already exists ...");
		JOptionPane.showMessageDialog(null, "Directory already exists "+name, "InfoBox: " + "Hello..!!", JOptionPane.INFORMATION_MESSAGE);

        } else {
            System.out.println("Directory not exists, creating now");

            success = directory.mkdir();
            if (success) {
                System.out.printf("Successfully created new directory : %s%n", dir);
		JOptionPane.showMessageDialog(null, "Successfully created new directory..!!!! "+dir, "InfoBox: " + "Hello..!!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.printf("Failed to create new directory: %s%n", dir);
		JOptionPane.showMessageDialog(null, "Failed to create new directory..!!!! "+dir, "InfoBox: " + "Hello..!!", JOptionPane.INFORMATION_MESSAGE);
            }
        }}

	public static void Fil(String name,String pa){
//Scanner reader = new Scanner(System.in);
        boolean success = false;

        System.out.println("Enter path of directory to create");
	//System.out.println(path);
        String dir = pa+'/'+name;

        // Creating new directory in Java, if it doesn't exists
       try{ File directory = new File(dir);
        if (directory.exists()) {
            System.out.println("file already exists ...");
		JOptionPane.showMessageDialog(null, "File already exists...!!! "+dir, "InfoBox: " + "Hello..!!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("file not exists, creating now");
		success = directory.createNewFile();
            //success = directory.mkdir();
            if (success) {
                System.out.printf("Successfully created new file : %s%n", dir);
		JOptionPane.showMessageDialog(null, "Successfully created new file...!!! "+dir, "InfoBox: " + "Hello..!!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.printf("Failed to create new file: %s%n", dir);
		JOptionPane.showMessageDialog(null, "Failed to create new file...!!! "+dir, "InfoBox: " + "Hello..!!", JOptionPane.INFORMATION_MESSAGE);
            }
        }}
	catch(IOException e){
		e.printStackTrace();
	}
}
    private void showNewLine() {

	String terminalText = txtArea.getText();
	String use;
	int lastPromptIndex = terminalText.lastIndexOf('>') + 2;
        if (lastPromptIndex < 0 || lastPromptIndex >= terminalText.length())
            use="";
        else
            use=terminalText.substring(lastPromptIndex);
	System.out.println(use);
	
	//System.out.println(use.length());
//	use=use.substring(0,use.length());
//	System.out.println(use);
	//int retval = use.compareTo("ls");
	if (use.startsWith("ls"))
	{

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

    		for (int i = 0; i < listOfFiles.length; i++)
		{
     			 if (listOfFiles[i].isFile()) 
			{
       		 		System.out.println("File >>>>>>>>>>>>" + listOfFiles[i].getName());
				txtArea.append('\n'+"FILE >>>" + listOfFiles[i].getName()+LINE_SEPARATOR);
      			} 
			else if (listOfFiles[i].isDirectory()) 
			{
       				 System.out.println("Directory >>>>>>>>>>>>>" + listOfFiles[i].getName());
				txtArea.append('\n'+"DIRECTORY >>>" + listOfFiles[i].getName()+LINE_SEPARATOR);     			
			}
    		}

	}
	else if (use.startsWith("cd .."))
	{	
		int last=directory.lastIndexOf('>');
		int last1=path.lastIndexOf('/');
		path=path.substring(0,last1-1);
		System.out.println(path);
		directory=directory.substring(0,last-1);
		System.out.println(directory);
	}
	else if (use.startsWith("cd "))
	{
		String dir=use.substring(3);
		boolean flag=false;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if  (dir.startsWith(listOfFiles[i].getName()))
			{
				if (listOfFiles[i].isDirectory())
				{
					flag=true;
					break;
				}
			}
		}
	//	String s1=s.substring(6);
		if (flag==true)
		{	
			path=path+'/'+dir;
			path.trim();
	//		System.out.println(path);
			txtArea.append('\n'+path);
			directory=directory+'>'+dir;
		}
		else
			txtArea.append('\n'+"NO SUCH DIRECTORY EXISTS....!!!!!");
	}
	
	else if (use.startsWith("cd"))
	{
			path=".";
			directory=" >";
	}
	else if (use.startsWith("rm "))
	{
		String name=use.substring(3);
	//	boolean flag=false;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if  (name.startsWith(listOfFiles[i].getName()))
			{
				listOfFiles[i].delete();
				JOptionPane.showMessageDialog(null, "Successfully Deleted "+name, "InfoBox: " + "Hello..!!", JOptionPane.INFORMATION_MESSAGE);
			}
		}		
	}
	else if (use.startsWith("mkdir "))
	{
		String name=use.substring(6);
		Dir(name,path);
	/*	File f = null;
      boolean bool = false;
		f = new File("test.txt");
         	bool = f.createNewFile();*/	
	}
	else if (use.startsWith("touch "))
	{
		String name=use.substring(6);
		Fil(name,path);
	}
	else if (use.startsWith("datetime"))
	{
		Date date = new Date();

      // display time and date using toString()
		txtArea.append('\n'+date.toString());
      		System.out.println(date.toString());
	}
	else if(use.startsWith("Text Editor"))
	{
		//System.out.println("TTTTTTTT");
		Editor editor = new Editor();
		editor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		editor.setVisible(true);
	}
	else if (use.startsWith("Game"))
	{
		JFrame frame = new Game();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         	   frame.setVisible(true);
	}
	else if (use.startsWith("cmds"))
	{
		txtArea.append('\n'+"ls");
		txtArea.append('\n'+"rm <File/Directory Name>");
		txtArea.append('\n'+"cd <Directory Name>");
		txtArea.append('\n'+"cd");
		txtArea.append('\n'+"cd ..");
		txtArea.append('\n'+"touch <FileName>");
		txtArea.append('\n'+"mkdir <Directory Name>");
		txtArea.append('\n'+"datetime");
		txtArea.append('\n'+"Text Editor");
		txtArea.append('\n'+"Game");
	}	
	else
		txtArea.append('\n'+"COMMAND NOT FOUND....!!!!!");






//	System.out.println(txtArea.getText());
	//txtArea.append('\n'+"APPLE"+LINE_SEPARATOR);
	//txtArea.setText(""+'\n');
	//System.out.println(txtArea.getText());
	        txtArea.setText(txtArea.getText()+ LINE_SEPARATOR);
    }

    private class KeyListener extends KeyAdapter {
        private final int ENTER_KEY = KeyEvent.VK_ENTER;
        private final int BACK_SPACE_KEY = KeyEvent.VK_BACK_SPACE;
        private final String BACK_SPACE_KEY_BINDING = getKeyBinding(
                txtArea.getInputMap(), "BACK_SPACE");
        private final int INITIAL_CURSOR_POSITION = 2;

        private boolean isKeysDisabled;
        private int minCursorPosition = INITIAL_CURSOR_POSITION;

        private String getKeyBinding(InputMap inputMap, String name) {
            return (String) inputMap.get(KeyStroke.getKeyStroke(name));
        }

        public void keyPressed(KeyEvent evt) {
            int keyCode = evt.getKeyCode();
            if (keyCode == BACK_SPACE_KEY) {
                int cursorPosition = txtArea.getCaretPosition();
                if (cursorPosition == minCursorPosition && !isKeysDisabled) {
                    disableBackspaceKey();
                } else if (cursorPosition > minCursorPosition && isKeysDisabled) {
                    enableBackspaceKey();
                }
            } else if (keyCode == ENTER_KEY) {
                disableTerminal();
                String command = extractCommand();
                executeCommand(command);
                showNewLine();
                showPrompt();
                enableTerminal();
            }
        }

        public void keyReleased(KeyEvent evt) {
            int keyCode = evt.getKeyCode();
            if (keyCode == ENTER_KEY) {
                txtArea.setCaretPosition(txtArea.getCaretPosition() - 1);
                setMinCursorPosition();
            }
        }

        private void disableBackspaceKey() {
            isKeysDisabled = true;
            txtArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),
                    "none");
        }

        private void enableBackspaceKey() {
            isKeysDisabled = false;
            txtArea.getInputMap().put(KeyStroke.getKeyStroke("BACK_SPACE"),
                    BACK_SPACE_KEY_BINDING);
        }

        private void setMinCursorPosition() {
            minCursorPosition = txtArea.getCaretPosition();
        }
    }

    public void enableTerminal() {
        txtArea.setEnabled(true);
    }

    public void disableTerminal() {
        txtArea.setEnabled(false);
    }

    private void executeCommand(String command) {
        processor.processCmd(command);
    }

    private String extractCommand() {
        removeLastLineSeparator();
        String newCommand = stripPreviousCommands();
        return newCommand;
    }

    private void removeLastLineSeparator() {
        String terminalText = txtArea.getText();
        terminalText = terminalText.substring(0, terminalText.length() - 1);
        txtArea.setText(terminalText);
    }

    private String stripPreviousCommands() {
        String terminalText = txtArea.getText();
        int lastPromptIndex = terminalText.lastIndexOf('>') + 2;
        if (lastPromptIndex < 0 || lastPromptIndex >= terminalText.length())
            return "";
        else
            return terminalText.substring(lastPromptIndex);
    }

    public static Terminal getInstance() {
        return TerminalHolder.INSTANCE;
    }

    private static final class TerminalHolder {
        static final Terminal INSTANCE = new Terminal();
    }
}

class CommandProcessor {
    private CommandProcessor() {
    }

    public void processCmd(String command) {
        System.out.println("User command: " + command);
    }

    public static CommandProcessor getInstance() {
        return CommandProcessorHolder.INSTANCE;
    }

    private static final class CommandProcessorHolder {
        static final CommandProcessor INSTANCE = new CommandProcessor();
    }
}
