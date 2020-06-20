package storeFrames;

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

public class StoreFrame {
	private Text nameValue;
	private Text addressValue;
	private Text areaValue;
	private Text telephoneValue;
	private Text emailValue;
	private Text commentValue;

	
	public StoreFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell storeFrame = new Shell();
		storeFrame.setText("New Store");
		
		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(storeFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(storeFrame, display);
		
		
		
		
		//GUI components
		Label idLabel = new Label(storeFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(storeFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(store.Store.getNextId());
		idValue.setBounds(10, 31, 56, 22);
		
		Label nameLabel = new Label(storeFrame, SWT.NONE);
		nameLabel.setText("Name: *");
		nameLabel.setBounds(11, 62, 55, 15);
		
		nameValue = new Text(storeFrame, SWT.BORDER);
		nameValue.setBounds(10, 83, 238, 22);
		
		Label addressLabel = new Label(storeFrame, SWT.NONE);
		addressLabel.setText("Address: *");
		addressLabel.setBounds(11, 116, 55, 15);
		
		addressValue = new Text(storeFrame, SWT.BORDER);
		addressValue.setBounds(10, 137, 238, 22);
		
		Label areaLabel = new Label(storeFrame, SWT.NONE);
		areaLabel.setText("Area: ");
		areaLabel.setBounds(11, 170, 55, 15);
		
		areaValue = new Text(storeFrame, SWT.BORDER);
		areaValue.setBounds(10, 191, 238, 22);
		
		Label telephoneLabel = new Label(storeFrame, SWT.NONE);
		telephoneLabel.setText("Telephone: *");
		telephoneLabel.setBounds(11, 257, 69, 15);
		
		telephoneValue = new Text(storeFrame, SWT.BORDER);
		telephoneValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(telephoneValue.getText(), event);
			}
		});
		telephoneValue.setBounds(10, 278, 238, 22);
		
		
		Label emailLabel = new Label(storeFrame, SWT.NONE);
		emailLabel.setText("Email:");
		emailLabel.setBounds(11, 311, 55, 15);
		
		emailValue = new Text(storeFrame, SWT.BORDER);
		emailValue.setBounds(10, 332, 238, 22);
		
		Label openDateLabel = new Label(storeFrame, SWT.NONE);
		openDateLabel.setText("Opening Date:");
		openDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime openDate = new DateTime(storeFrame, SWT.BORDER);
		openDate.setEnabled(false);
		openDate.setBounds(324, 31, 101, 24);
		
		Button keepOpenDate = new Button(storeFrame, SWT.RADIO);
		keepOpenDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				openDate.setEnabled(true);
			}
		});
		keepOpenDate.setBounds(300, 31, 13, 24);
		
		Button dontKeepOpenDate = new Button(storeFrame, SWT.RADIO);
		dontKeepOpenDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				openDate.setEnabled(false);
			}
		});
		dontKeepOpenDate.setText("   Do not register an opening date.");
		dontKeepOpenDate.setSelection(true);
		dontKeepOpenDate.setBounds(300, 61, 206, 24);
		
		commentValue = new Text(storeFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 248, 309, 81);
		
		Label commentLabel = new Label(storeFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 227, 69, 15);
		
		Label messageLabel = new Label(storeFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(327, 372, 282, 15);
		
		Button cancelButton = new Button(storeFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(storeFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 393, 75, 25);
		
		Button submitButton = new Button(storeFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || nameValue.getText().equals("") ||
				   addressValue.getText().equals("") || telephoneValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(storeFrame);
				}else {
					if(Aid.TheFrame.submitPressed(storeFrame)) {
						new store.Store(
								idValue.getText(),
								nameValue.getText(),
								addressValue.getText(),
								areaValue.getText(),
								
								telephoneValue.getText(),
								emailValue.getText(),
								
								openDate.getDay(),
								openDate.getMonth(),
								openDate.getYear(),
								keepOpenDate.getSelection(),
								
								commentValue.getText());
					}
					storeFrame.dispose();
					Aid.TheFrame.messageDialogItemRegistered(storeFrame);
				}
				
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 393, 75, 25);
		
		

		storeFrame.open();
		storeFrame.layout();
		while (!storeFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
