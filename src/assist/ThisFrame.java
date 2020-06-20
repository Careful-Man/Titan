package assist;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;




public class ThisFrame {
	
	
	public static void getLocation(Shell frame, Display display) {
		frame.setLocation(
	    display.getPrimaryMonitor().getBounds().x + (display.getPrimaryMonitor().getBounds().width - frame.getBounds().width) / 2,
	    display.getPrimaryMonitor().getBounds().y + (display.getPrimaryMonitor().getBounds().height - frame.getBounds().height) / 2);
		frame.setImage(new Image(null, "titan.jpg"));
	}
	
	
	
	public static void cancelPress(Shell frame) {
		boolean md = MessageDialog.openConfirm(frame, "Cancel", 
		"Canceling this window will NOT save your registration "
		+ "and will discard input data. Proceed?");
		
		if(md) {
			frame.dispose();
		}else {
			
		}
		
		
	}
	
	
	
	
	public static void messageDialog(Shell frame) {
		MessageDialog.open(4, frame, "Info", "An active instance already exists. "
		+ "You cannot open another registration frame.", 1);
		
	}
	
	
	public static void smallRegisterFrame(Shell frame) {
		frame.setSize(635, 380);
		frame.setMinimumSize(635, 380);
		
	}
	
	public static void mediumRegisterFrame(Shell frame) {
		frame.setMinimumSize(660, 460);
		frame.setSize(660, 460);
	}
	
	public static void largeRegisterFrame(Shell frame) {
		frame.setSize(660, 735);
		frame.setMinimumSize(660, 735);
	}
	
	

}
