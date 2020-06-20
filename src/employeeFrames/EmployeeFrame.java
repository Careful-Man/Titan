package employeeFrames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class EmployeeFrame {
	private Text firstNameValue;
	private Text lastNameValue;
	private Text commentValue;
	private Text telephoneValue;
	private Text emailValue;

	
	public EmployeeFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell employeeFrame = new Shell();
		employeeFrame.setSize(635, 471);
		employeeFrame.setText("New Employee");
		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(employeeFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(employeeFrame, display);
		
		
		//GUI components
		Label idLabel = new Label(employeeFrame, SWT.NONE);
		idLabel.setText("ID: ");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(employeeFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setBounds(10, 31, 70, 22);
		idValue.setText(employee.Employee.getNextId());
		
		Label fnameLabel = new Label(employeeFrame, SWT.NONE);
		fnameLabel.setText("First Name: *");
		fnameLabel.setBounds(11, 62, 113, 15);
		
		firstNameValue = new Text(employeeFrame, SWT.BORDER);
		firstNameValue.setBounds(10, 83, 238, 22);
		
		Label lnameLabel = new Label(employeeFrame, SWT.NONE);
		lnameLabel.setText("Last Name: *");
		lnameLabel.setBounds(11, 116, 113, 15);
		
		lastNameValue = new Text(employeeFrame, SWT.BORDER);
		lastNameValue.setBounds(10, 137, 238, 22);
		
		Label telephoneLabel = new Label(employeeFrame, SWT.NONE);
		telephoneLabel.setText("Telephone: ");
		telephoneLabel.setBounds(11, 203, 69, 15);
		
		telephoneValue = new Text(employeeFrame, SWT.BORDER);
		telephoneValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(telephoneValue.getText(), event);
			}
		});
		telephoneValue.setToolTipText("");
		telephoneValue.setBounds(10, 224, 238, 22);
		
		Label emailLabel = new Label(employeeFrame, SWT.NONE);
		emailLabel.setText("Email:");
		emailLabel.setBounds(11, 257, 55, 15);
		
		emailValue = new Text(employeeFrame, SWT.BORDER);
		emailValue.setBounds(10, 278, 238, 22);
				
		Label birthDateLabel = new Label(employeeFrame, SWT.NONE);
		birthDateLabel.setText("Birth Date:");
		birthDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime birthdate = new DateTime(employeeFrame, SWT.BORDER);
		birthdate.setEnabled(false);
		birthdate.setBounds(324, 31, 101, 24);
		
		Button keepBirthdate = new Button(employeeFrame, SWT.RADIO);
		keepBirthdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				birthdate.setEnabled(true);
			}
		});
		keepBirthdate.setBounds(300, 31, 13, 24);
		
		Button dontKeepBirthdate = new Button(employeeFrame, SWT.RADIO);
		dontKeepBirthdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				birthdate.setEnabled(false);
			}
		});
		dontKeepBirthdate.setText("   Do not register a birth date.");
		dontKeepBirthdate.setSelection(true);
		dontKeepBirthdate.setBounds(300, 61, 206, 24);
		
		Combo departmentValue = new Combo(employeeFrame, SWT.NONE);
		departmentValue.setItems(new String[] {"Management", "Commercial", "Marketing", "Accounting ", "Informatic Technologies", "Facilities", "Warehouse", "Operations", "Store"});
		departmentValue.setBounds(300, 112, 238, 23);
		
		Label departmentLabel = new Label(employeeFrame, SWT.NONE);
		departmentLabel.setText("Department: *");
		departmentLabel.setBounds(300, 91, 83, 15);
		
		Label label = new Label(employeeFrame, SWT.NONE);
		label.setToolTipText("Management = \u0394\u03B9\u03BF\u03AF\u03BA\u03B7\u03C3\u03B7\r\nCommercial = \u0395\u03BC\u03C0\u03BF\u03C1\u03B9\u03BA\u03CC\r\nMarketing = \u039C\u03AC\u03C1\u03BA\u03B5\u03C4\u03B9\u03BD\u03B3\u03BA\r\nAccounting = \u039B\u03BF\u03B3\u03B9\u03C3\u03C4\u03AE\u03C1\u03B9\u03BF\r\nInformatic Technologies = \u039C\u03B7\u03C7\u03B1\u03BD\u03BF\u03B3\u03C1\u03AC\u03C6\u03B7\u03C3\u03B7\r\nFacilities = \u0395\u03B3\u03BA\u03B1\u03C4\u03B1\u03C3\u03C4\u03AC\u03C3\u03B5\u03B9\u03C2\r\nWarehouse = \u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B7\r\nOperations = \u039B\u03B5\u03B9\u03C4\u03BF\u03C5\u03C1\u03B3\u03AF\u03B5\u03C2\r\nStore = \u039A\u03B1\u03C4\u03AC\u03C3\u03C4\u03B7\u03BC\u03B1");
		label.setText("  ?");
		label.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		label.setBounds(539, 113, 24, 22);
		
		Label commentLabel = new Label(employeeFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 249, 69, 15);
		
		commentValue = new Text(employeeFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 270, 305, 81);
		
		Label messageLabel = new Label(employeeFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(324, 376, 281, 15);
		
		Button cancelButton = new Button(employeeFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(employeeFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 397, 75, 25);
		
		Button submitButton = new Button(employeeFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || firstNameValue.getText().equals("") ||
				   lastNameValue.getText().equals("") || departmentValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(employeeFrame);
				}else {
					if(Aid.TheFrame.submitPressed(employeeFrame)) {
						new employee.Employee(
							"Emp - " + idValue.getText(),
							firstNameValue.getText(),
							lastNameValue.getText(),
							
							telephoneValue.getText(),
							emailValue.getText(),
							
							birthdate.getDay(), 
							birthdate.getMonth(), 
							birthdate.getYear(),
							keepBirthdate.getSelection(),
							
							departmentValue.getText(),
							
							commentValue.getText()					
							);
							
						employeeFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(employeeFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 397, 75, 25);
		
		
		
		
		
		
		
		
		employeeFrame.open();
		employeeFrame.layout();
		while (!employeeFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
