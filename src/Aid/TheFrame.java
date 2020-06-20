package Aid;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import hardware.Hardware;




public class TheFrame {
	
	private static int countDots = 0;
	
	public static final String SERVERIP = "192.168.86.4";
	public static final String USERNAME = "user";
	public static final String PASSWORD = "mypass";
	public static final String URL = "jdbc:mysql://" + SERVERIP + "/saturn?useSSL=false";
	
	
	//location (is global)
	public static void getFrameLocation(Shell frame, Display display) {
		frame.setLocation(
	    display.getPrimaryMonitor().getBounds().x + (display.getPrimaryMonitor().getBounds().width - frame.getBounds().width) / 2,
	    display.getPrimaryMonitor().getBounds().y + (display.getPrimaryMonitor().getBounds().height - frame.getBounds().height) / 2);
		frame.setImage(new Image(null, "titan.jpg"));
	}
	
	
	
	
	
	
	//buttons pressed
	public static void cancelPressed(Shell frame) {
		boolean md = MessageDialog.openConfirm(frame, "Cancel", 
		"Canceling this window will NOT save this registration. Proceed?");
		
		if(md) 
			frame.dispose();
		
	}
	public static boolean submitPressed(Shell frame) {
		boolean md = MessageDialog.openConfirm(frame, "Register new item", 
		"Register data?");
		
		return md;
		
	}
	
	
	
	
	
	
	//message dialogs
	public static void messageDialogRecordFrame(Shell frame) {
		MessageDialog.open(4, frame, "Info", "You cannot open another registration frame.", 1);
	}
	public static void messageDialogWelcomeFrame(Shell frame) {
		MessageDialog.open(4, frame, "Info", "You cannot open another record frame.", 1);
	}
	
	public static void messageDialogItemRegistered(Shell frame) {
		MessageDialog.open(4, frame, "Info", "Item has been registered.", 1);		
	}
	public static void messageDialogEmptyFields(Shell frame) {
		MessageDialog.open(1, frame, "Error", "Fields marked with an asterisk cannot be empty.", 1);		
	}
	
	
	
	
	
	//frame sizes
	public static void smallRegisterFrameSize(Shell frame) {
		frame.setSize(635, 470);
		frame.setMinimumSize(635, 470);
		
	}
	public static void mediumRegisterFrameSize(Shell frame) {
		frame.setMinimumSize(635, 580);
		frame.setSize(635, 580);
	}
	public static void largeRegisterFrameSize(Shell frame) {
		frame.setSize(660, 800);
		frame.setMinimumSize(660, 735);
	}
	
	
	
	
	//fields number formation
	public static void integerNumberOnlyTextField(String text, VerifyEvent event) {

        // get old text and create new text by using the VerifyEvent.text
        final String initialString = text;
        String verifiedString = initialString.substring(0, event.start) + event.text + initialString.substring(event.end);
        
        boolean isInteger = false;
        try {
        	if(verifiedString.length() == 0) 
        		verifiedString = "";
        	else 
        		Integer.parseInt(verifiedString);
            
        }
        catch(NumberFormatException exeption) {
            isInteger = true;
        }
        
        if(isInteger) event.doit = false;
        
	}
	public static void floatNumberOnlyTextField(String text, VerifyEvent event) {

        // get old text and create new text by using the VerifyEvent.text
        final String initialString = text;
        String verifiedString = initialString.substring(0, event.start) + event.text + initialString.substring(event.end);
        
        boolean isFloat = false;
        try {
        	if(verifiedString.length() == 0) verifiedString = "";
        	else Float.parseFloat(verifiedString);
            
        }
        catch(NumberFormatException exeption) {
            isFloat = true;
        }
        
        if(isFloat) event.doit = false;
        
	}
	public static void ipAddressTextField(String text1, VerifyEvent event) {
		 
		String allowedCharacters = "0123456789.";
	    String text = event.text;
	   
	    for (int i=0; i<text.length(); i++) {
	        char character = text.charAt(i);
	        boolean isAllowed = allowedCharacters.indexOf(character) > -1;
	        
        	if (!isAllowed) 
        		event.doit = false;
        			
	    }    
	}
	public static void ipAddressFormatter(Text ip, KeyEvent event) {
		if(!(event.keyCode == SWT.BS)) {
			if(ip.getText().length() != 0) {
				if(ip.getText().substring(ip.getText().length()-1).equals(".")) {
					ip.setSelection(ip.getText().length());
				}else if(ip.getText().length() == 3) {
					ip.setText(ip.getText() + ".");
					ip.setSelection(ip.getText().length());
				}else if(ip.getText().length() == 7) {
					ip.setText(ip.getText() + ".");
					ip.setSelection(ip.getText().length());
				}else if(ip.getText().length() == 11) {
					ip.setText(ip.getText() + ".");
					ip.setSelection(ip.getText().length());
				}
			}
		}
	}
	
	
	
	
	
	
	
	//id auto increment
	public static String getNextId(List<hardware.Hardware> list) {
		if(list.isEmpty()) 
			return "001";
		else {
			hardware.Hardware e = (Hardware) list.get(list.size() - 1);
			int returnedId = Integer.parseInt(e.getId().substring(e.getId().length() - 3, e.getId().length())) + 1;
			if(returnedId % 10 == returnedId)	
				return "00" + returnedId;
			else if(returnedId % 100 == returnedId)
				return "0" + returnedId;
			return "" + returnedId;
		}
	}





	//get statement for db queries
	public static Statement getStatement() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD).createStatement();
		
	}
	
	
	

}
