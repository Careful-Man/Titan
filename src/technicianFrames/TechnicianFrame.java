package technicianFrames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TechnicianFrame {
	private Text firstNameValue;
	private Text lastNameValue;
	private Text commentValue;
	private Text telephoneValue;
	private Text emailValue;

	
	public TechnicianFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell technicianFrame = new Shell();
		technicianFrame.setSize(635, 471);
		technicianFrame.setText("New Technician");
		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(technicianFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(technicianFrame, display);
		
		
		//GUI components
		Label idLabel = new Label(technicianFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(technicianFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setBounds(10, 31, 70, 22);
		
		Label fnameLabel = new Label(technicianFrame, SWT.NONE);
		fnameLabel.setText("First Name: *");
		fnameLabel.setBounds(11, 62, 113, 15);
		
		firstNameValue = new Text(technicianFrame, SWT.BORDER);
		firstNameValue.setBounds(10, 83, 238, 22);
		
		Label lnameLabel = new Label(technicianFrame, SWT.NONE);
		lnameLabel.setText("Last Name: *");
		lnameLabel.setBounds(11, 116, 113, 15);
		
		lastNameValue = new Text(technicianFrame, SWT.BORDER);
		lastNameValue.setBounds(10, 137, 238, 22);
		
		Label telephoneLabel = new Label(technicianFrame, SWT.NONE);
		telephoneLabel.setText("Telephone: *");
		telephoneLabel.setBounds(11, 203, 69, 15);
		
		telephoneValue = new Text(technicianFrame, SWT.BORDER);
		telephoneValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(telephoneValue.getText(), event);
			}
		});
		telephoneValue.setToolTipText("");
		telephoneValue.setBounds(10, 224, 238, 22);
		
		Label emailLabel = new Label(technicianFrame, SWT.NONE);
		emailLabel.setText("Email:");
		emailLabel.setBounds(11, 257, 55, 15);
		
		emailValue = new Text(technicianFrame, SWT.BORDER);
		emailValue.setBounds(10, 278, 238, 22);
				
		Label birthDateLabel = new Label(technicianFrame, SWT.NONE);
		birthDateLabel.setText("Birth Date:");
		birthDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime birthdate = new DateTime(technicianFrame, SWT.BORDER);
		birthdate.setEnabled(false);
		birthdate.setBounds(324, 31, 101, 24);
		
		Button keepBirthdate = new Button(technicianFrame, SWT.RADIO);
		keepBirthdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				birthdate.setEnabled(true);
			}
		});
		keepBirthdate.setBounds(300, 31, 13, 24);
		
		Button dontKeepBirthdate = new Button(technicianFrame, SWT.RADIO);
		dontKeepBirthdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				birthdate.setEnabled(false);
			}
		});
		dontKeepBirthdate.setText("   Do not register a birth date.");
		dontKeepBirthdate.setSelection(true);
		dontKeepBirthdate.setBounds(300, 61, 206, 24);
		
		Label commentLabel = new Label(technicianFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 111, 69, 15);
		
		commentValue = new Text(technicianFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 132, 305, 81);
		
		Label messageLabel = new Label(technicianFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(324, 376, 281, 15);
		
		Button cancelButton = new Button(technicianFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(technicianFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 397, 75, 25);
		
		Button submitButton = new Button(technicianFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || firstNameValue.getText().equals("") ||
				   lastNameValue.getText().equals("") || telephoneValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(technicianFrame);
				}else {
					if(Aid.TheFrame.submitPressed(technicianFrame)) {
						new technician.Technician(
							idValue.getText(),
							firstNameValue.getText(),
							lastNameValue.getText(),
							
							telephoneValue.getText(),
							emailValue.getText(),
							
							birthdate.getDay(), 
							birthdate.getMonth(), 
							birthdate.getYear(),
							keepBirthdate.getSelection(),
							
							commentValue.getText()					
							);
							
						technicianFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(technicianFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 397, 75, 25);
		
		
		
		
		
		
		
		
		technicianFrame.open();
		technicianFrame.layout();
		while (!technicianFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
