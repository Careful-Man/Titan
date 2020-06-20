package hardwareFrames;

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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class UpsFrame {
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private Text commentValue;
	private Text supplierValue;

	
	public UpsFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell upsFrame = new Shell();
		upsFrame.setSize(635, 470);
		upsFrame.setText("New UPS");
		
		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(upsFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(upsFrame, display);
		
		
		
		//GUI components
		Label idLabel = new Label(upsFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(upsFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(hardware.Ups.getNextId());
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(upsFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(upsFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 23);
		
		Label brandLabel = new Label(upsFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 92, 55, 15);
		
		brandValue = new Text(upsFrame, SWT.BORDER);
		brandValue.setBounds(10, 113, 238, 22);
		
		Label modelLabel = new Label(upsFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 141, 55, 15);
		
		modelValue = new Text(upsFrame, SWT.BORDER);
		modelValue.setBounds(10, 162, 238, 22);
		
		Label snLabel = new Label(upsFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 190, 55, 15);
		
		snValue = new Text(upsFrame, SWT.BORDER);
		snValue.setBounds(10, 211, 238, 22);
		
		Label supplierLabel = new Label(upsFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 239, 64, 15);
		
		supplierValue = new Text(upsFrame, SWT.BORDER);
		supplierValue.setBounds(10, 260, 238, 22);
		
		Label capacityLabel = new Label(upsFrame, SWT.NONE);
		capacityLabel.setText("Capacity: ");
		capacityLabel.setBounds(10, 312, 75, 15);
		
		Text capacityValue = new Text(upsFrame, SWT.BORDER);
		capacityValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(capacityValue.getText(), event);
			}
		});
		capacityValue.setBounds(10, 333, 65, 22);
		
		Label vaLabel = new Label(upsFrame, SWT.NONE);
		vaLabel.setText("VA");
		vaLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		vaLabel.setBounds(81, 333, 64, 22);
		
		
		Label purchaseDateLabel = new Label(upsFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime purchaseDate = new DateTime(upsFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(324, 31, 101, 24);
		
		Label guaranteeLabel = new Label(upsFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(453, 10, 76, 15);
		
		Text guaranteeValue = new Text(upsFrame, SWT.BORDER);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setEnabled(false);
		guaranteeValue.setBounds(453, 31, 56, 22);
		
		Button keepPurchaseDate = new Button(upsFrame, SWT.RADIO);
		keepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepPurchaseDate.setBounds(300, 31, 13, 24);
		
		Button dontKeepPurchaseDate = new Button(upsFrame, SWT.RADIO);
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
		
		Label yearsLabel = new Label(upsFrame, SWT.NONE);
		yearsLabel.setText("years.");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(514, 31, 64, 22);
		
		Label userLabel = new Label(upsFrame, SWT.NONE);
		userLabel.setBounds(300, 91, 83, 15);
		userLabel.setText("User: *");
		
		Combo userValue = new Combo(upsFrame, SWT.NONE);
		userValue.setItems(employee.Employee.getExistingEmployees());
		userValue.setBounds(300, 112, 238, 23);
		
		Button activeValue = new Button(upsFrame, SWT.CHECK);
		activeValue.setBounds(300, 141, 188, 15);
		activeValue.setText("This piece of hardware is active.");
		
		Label connectionTypeLabel = new Label(upsFrame, SWT.NONE);
		connectionTypeLabel.setBounds(300, 169, 107, 15);
		connectionTypeLabel.setText("Connection Type: ");
		
		Combo connectionTypeValue = new Combo(upsFrame, SWT.NONE);
		connectionTypeValue.setItems(new String[] {"Serial", "USB", "Serial+USB"});
		connectionTypeValue.setBounds(300, 190, 91, 23);
		
		Label batteryTypeLabel = new Label(upsFrame, SWT.NONE);
		batteryTypeLabel.setText("Battery type: *");
		batteryTypeLabel.setBounds(413, 169, 83, 15);
		
		List batteryTypeValue = new List(upsFrame, SWT.BORDER);
		batteryTypeValue.setItems(new String[] {"5Ah / 12V", "7Ah / 12V", "9Ah / 12V", "12Ah / 12V"});
		batteryTypeValue.setBounds(413, 190, 75, 64);
		
		Label batteriesLabel = new Label(upsFrame, SWT.NONE);
		batteriesLabel.setText("No. of Batteries: *");
		batteriesLabel.setBounds(499, 169, 95, 15);
		
		Text batteriesValue = new Text(upsFrame, SWT.BORDER);
		batteriesValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(batteriesValue.getText(), event);
			}
		});
		batteriesValue.setBounds(499, 190, 42, 22);
		
		Label batteriesLabel2 = new Label(upsFrame, SWT.NONE);
		batteriesLabel2.setText("batteries");
		batteriesLabel2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		batteriesLabel2.setBounds(547, 189, 62, 22);
		
		Label commentLabel = new Label(upsFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 267, 69, 15);
		
		commentValue = new Text(upsFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 288, 305, 81);
		
		Label messageLabel = new Label(upsFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(330, 375, 275, 15);
		
		Button cancelButton = new Button(upsFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(upsFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 396, 75, 25);
		
		Button submitButton = new Button(upsFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				brandValue.getText().equals("") || modelValue.getText().equals("") ||
				snValue.getText().equals("") || supplierValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(upsFrame);
				}else {
					if(Aid.TheFrame.submitPressed(upsFrame)) {
						new hardware.Ups(
							"UPS - " + idValue.getText(), 
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
							
							capacityValue.getText(),
							connectionTypeValue.getText(),
							batteryTypeValue.getSelection().toString(),
							batteriesValue.getText());
						upsFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(upsFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 396, 75, 25);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		upsFrame.open();
		upsFrame.layout();
		while (!upsFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
