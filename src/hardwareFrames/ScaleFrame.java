package hardwareFrames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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

public class ScaleFrame {
	
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private static Text commentValue;
	private static Text supplierValue;
	
	
	
	
	public ScaleFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell scaleFrame = new Shell();
		scaleFrame.setText("New Scale");
		
		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(scaleFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(scaleFrame, display);
		
		
		
		
		//GUI components
		Label idLabel = new Label(scaleFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(scaleFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(hardware.Scale.getNextId());
		idValue.setTextLimit(999999);
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(scaleFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(scaleFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 23);
		
		Label brandLabel = new Label(scaleFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 73, 55, 15);
		
		brandValue = new Text(scaleFrame, SWT.BORDER);
		brandValue.setBounds(10, 94, 238, 22);
		
		Label modelLabel = new Label(scaleFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 122, 55, 15);
		
		modelValue = new Text(scaleFrame, SWT.BORDER);
		modelValue.setBounds(10, 143, 238, 22);
		
		Label snLabel = new Label(scaleFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 171, 55, 15);
		
		snValue = new Text(scaleFrame, SWT.BORDER);
		snValue.setBounds(10, 192, 238, 22);
		
		Label supplierLabel = new Label(scaleFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 220, 64, 15);
		
		supplierValue = new Text(scaleFrame, SWT.BORDER);
		supplierValue.setBounds(10, 241, 238, 22);
		
		Label connectionTypeLabel = new Label(scaleFrame, SWT.NONE);
		connectionTypeLabel.setBounds(10, 288, 153, 15);
		connectionTypeLabel.setText("Connection Type: *");
		
		Combo connectionTypeValue = new Combo(scaleFrame, SWT.NONE);
		connectionTypeValue.setItems(new String[] {"Net", "Serial"});
		connectionTypeValue.setBounds(10, 309, 238, 23);
		
		Label locationLabel = new Label(scaleFrame, SWT.NONE);
		locationLabel.setText("Location:");
		locationLabel.setBounds(10, 338, 153, 15);
		
		Combo locationValue = new Combo(scaleFrame, SWT.NONE);
		locationValue.setItems(new String[] {"Cash Desk", "Bench"});
		locationValue.setBounds(10, 359, 238, 23);
		
		Label purchaseDateLabel = new Label(scaleFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime purchaseDate = new DateTime(scaleFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(324, 31, 101, 24);
		
		Text guaranteeValue = new Text(scaleFrame, SWT.BORDER);
		guaranteeValue.setEnabled(false);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setBounds(453, 31, 56, 22);
		
		Button keepPurchaseDate = new Button(scaleFrame, SWT.RADIO);
		keepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepPurchaseDate.setBounds(300, 31, 13, 24);
		
		Button dontKeepPurchaseDate = new Button(scaleFrame, SWT.RADIO);
		dontKeepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(false);
				guaranteeValue.setEnabled(false);
				guaranteeValue.setText("");
				
			}
		});
		dontKeepPurchaseDate.setText("   Do not register a purchase date.");
		dontKeepPurchaseDate.setSelection(true);
		dontKeepPurchaseDate.setBounds(300, 61, 206, 24);
		
		Label guaranteeLabel = new Label(scaleFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(453, 10, 76, 15);
		
		Label yearsLabel = new Label(scaleFrame, SWT.NONE);
		yearsLabel.setText("years.");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(514, 31, 64, 22);
		
		Label userLabel = new Label(scaleFrame, SWT.NONE);
		userLabel.setText("User: ");
		userLabel.setBounds(300, 92, 83, 15);
		
		Combo userValue = new Combo(scaleFrame, SWT.NONE);
		userValue.setItems(employee.Employee.getExistingEmployees());
		userValue.setBounds(300, 113, 238, 23);
		
		Button activeValue = new Button(scaleFrame, SWT.CHECK);
		activeValue.setText("This piece of hardware is active.");
		activeValue.setBounds(300, 141, 188, 15);
		
		
		
		Label ipAddressLabel = new Label(scaleFrame, SWT.NONE);
		ipAddressLabel.setText("IP Address: ");
		ipAddressLabel.setBounds(300, 193, 83, 15);
		
		Text ipAddressValue = new Text(scaleFrame, SWT.BORDER);
		ipAddressValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				Aid.TheFrame.ipAddressFormatter(ipAddressValue, event);
			}
		});
		ipAddressValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.ipAddressTextField(ipAddressValue.getText(), event);
				
			}
		});
		ipAddressValue.setTextLimit(15);
		ipAddressValue.setBounds(300, 211, 238, 22);
		
		Label commentLabel = new Label(scaleFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 267, 69, 15);
		
		commentValue = new Text(scaleFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 288, 305, 81);
		
		Label messageLabel = new Label(scaleFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(330, 375, 275, 15);
		
		Button cancelButton = new Button(scaleFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(scaleFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 396, 75, 25);
		
		Button submitButton = new Button(scaleFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				   brandValue.getText().equals("") || modelValue.getText().equals("") ||
				   snValue.getText().equals("") || supplierValue.getText().equals("") ||
				   connectionTypeValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(scaleFrame);
				}else {
					if(Aid.TheFrame.submitPressed(scaleFrame)) {
						if(locationValue.getText().equals("Cash Desk")) {
							new hardware.Scale(
									"ZPO - " + idValue.getText(), 
									storeValue.getText(),
									brandValue.getText(), 
									modelValue.getText(), 
									snValue.getText(),
									supplierValue.getText(),
									
									purchaseDate.getDay(), 
									purchaseDate.getMonth(), 
									purchaseDate.getYear(), 
									guaranteeValue.getText(),
									keepPurchaseDate.getSelection(),
									userValue.getText(),
									activeValue.getSelection(),
									
									commentValue.getText(),
									
									connectionTypeValue.getText(),
									locationValue.getText(),
									ipAddressValue.getText());
						}else if(locationValue.getText().equals("Bench")) {
							new hardware.Scale(
									"ZPA - " + idValue.getText(), 
									storeValue.getText(),
									brandValue.getText(), 
									modelValue.getText(), 
									snValue.getText(),
									supplierValue.getText(),
									
									purchaseDate.getDay(), 
									purchaseDate.getMonth(), 
									purchaseDate.getYear(), 
									guaranteeValue.getText(),
									keepPurchaseDate.getSelection(),
									userValue.getText(),
									activeValue.getSelection(),
									
									commentValue.getText(),
									
									connectionTypeValue.getText(),
									locationValue.getText(),
									ipAddressValue.getText());
						}else {
							new hardware.Scale(
									"SCL - " + idValue.getText(), 
									storeValue.getText(),
									brandValue.getText(), 
									modelValue.getText(), 
									snValue.getText(),
									supplierValue.getText(),
									
									purchaseDate.getDay(), 
									purchaseDate.getMonth(), 
									purchaseDate.getYear(), 
									guaranteeValue.getText(),
									keepPurchaseDate.getSelection(),
									userValue.getText(),
									activeValue.getSelection(),
									
									commentValue.getText(),
									
									connectionTypeValue.getText(),
									locationValue.getText(),
									ipAddressValue.getText());
						}
						scaleFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(scaleFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 396, 75, 25);
		
		
		
		
		
		
		
		
		
		
		
		

		scaleFrame.open();
		scaleFrame.layout();
		while (!scaleFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
		
	}
}
