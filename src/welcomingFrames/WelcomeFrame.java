package welcomingFrames;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class WelcomeFrame {

	private Display display;
	private Shell welcomeFrame;
	private Button newRecordButton;
	private Button olderRecordsButton;
	
	private boolean openFrame = false;
	
	
	private Text welcomeTextValue;
	
	public WelcomeFrame(boolean connectionEstablished, Exception e) {
		boolean printed = false;
		
		//frame components
		display = Display.getDefault();
		welcomeFrame = new Shell();
		welcomeFrame.setMinimumSize(new Point(800, 800));
		welcomeFrame.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		welcomeFrame.setSize(800, 800);
		welcomeFrame.setText("Titan");
		
		
		
		//frame location
		Aid.TheFrame.getFrameLocation(welcomeFrame, display);
		
		
		
		
		
		//GUI components
		//titan image
		final Image image = new Image(display, "titanWelcome.png");

        welcomeFrame.addListener (SWT.Paint, new Listener () {
            public void handleEvent (Event e) {
                GC gc = e.gc;
                int x = 329, y = 10;
                gc.drawImage (image, x, y);
                gc.dispose();
            }
        });
        //thanks Hubble space telescope ^_^
        
        
        
        
        
        
		
		newRecordButton = new Button(welcomeFrame, SWT.NONE);
		newRecordButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new welcomingFrames.NewRecordFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogWelcomeFrame(welcomeFrame);
				}
				
				
			}
		});
		newRecordButton.setBounds(289, 726, 86, 25);
		newRecordButton.setText("New Record");
		
		olderRecordsButton = new Button(welcomeFrame, SWT.NONE);
		olderRecordsButton.setText("Older Records");
		olderRecordsButton.setBounds(405, 726, 86, 25);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss       dd/MM/yyyy");
		welcomeTextValue = new Text(welcomeFrame, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		welcomeTextValue.setText("Attempting connection with database \"Saturn\"...\n\n"
		+ "\n"
		+ "Session started at: \n\n" + formatter.format(LocalDateTime.now()) + ""
		+ "\n\n\n\n"
		+ "New record:  register a new item.\n\n"
		+ "Older records:  view registered items.\n\n"
		+ "-------------------------------------------------------------------------"
		+ "-------------------------------------------------------------------------\n\n");
		welcomeTextValue.setEditable(false);
		welcomeTextValue.setBounds(10, 234, 764, 449);
		
		
		
		
	    welcomeFrame.open();
	    welcomeFrame.layout();
		while (!welcomeFrame.isDisposed()) {
			
			if (!display.readAndDispatch()) {
				display.sleep();
			}
			
			if(connectionEstablished) {
				if(!printed) {
					try {
						Thread.sleep(1);
						
					}catch(InterruptedException ie) {
						welcomeTextValue.append("InterruptedException thrown.");
					}
					welcomeTextValue.append("Connection established.\n\n"
					+ "-------------------------------------------------------------------------"
					+ "-------------------------------------------------------------------------\n\n");
					printed = true;
				}
			}else {
				if(!printed) {
					try {
						Thread.sleep(600);
					}catch(InterruptedException ie) {
						welcomeTextValue.append("InterruptedException thrown.");
					}
					welcomeTextValue.append("Errors found: \n\n" + 
					e + ". Check database status and try again.\n\n"
					+ "-------------------------------------------------------------------------"
					+ "-------------------------------------------------------------------------\n\n");
					printed = true;
					
				}
			}
			
			
		}
	}
}
