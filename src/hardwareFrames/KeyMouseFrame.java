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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class KeyMouseFrame {
	
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private static Text commentValue;
	private static Text supplierValue;
	
	
	
	
	public KeyMouseFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell keyMouseFrame = new Shell();
		keyMouseFrame.setText("New Keyboard and Mouse");

		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(keyMouseFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(keyMouseFrame, display);
		
		
		
		
		//GUI components
		Label idLabel = new Label(keyMouseFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(keyMouseFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setBounds(10, 31, 56, 22);
		idValue.setText(hardware.KeyMouse.getNextId());
		
		Label storeLabel = new Label(keyMouseFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(keyMouseFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 23);
		
		Label brandLabel = new Label(keyMouseFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 92, 55, 15);
		
		brandValue = new Text(keyMouseFrame, SWT.BORDER);
		brandValue.setBounds(10, 113, 238, 22);
		
		Label modelLabel = new Label(keyMouseFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 141, 55, 15);
		
		modelValue = new Text(keyMouseFrame, SWT.BORDER);
		modelValue.setBounds(10, 162, 238, 22);
		
		Label snLabel = new Label(keyMouseFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 190, 55, 15);
		
		snValue = new Text(keyMouseFrame, SWT.BORDER);
		snValue.setBounds(10, 211, 238, 22);
		
		Label supplierLabel = new Label(keyMouseFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 239, 64, 15);
		
		supplierValue = new Text(keyMouseFrame, SWT.BORDER);
		supplierValue.setBounds(10, 260, 238, 22);
		
		Label purchaseDateLabel = new Label(keyMouseFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime purchaseDate = new DateTime(keyMouseFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(324, 31, 101, 24);
		
		Text guaranteeValue = new Text(keyMouseFrame, SWT.BORDER);
		guaranteeValue.setEnabled(false);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setBounds(453, 31, 56, 22);
		
		Button keepPurchaseDate = new Button(keyMouseFrame, SWT.RADIO);
		keepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepPurchaseDate.setBounds(300, 31, 13, 24);
		
		Button dontKeepPurchaseDate = new Button(keyMouseFrame, SWT.RADIO);
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
		
		Label guaranteeLabel = new Label(keyMouseFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(453, 10, 76, 15);
		
		Label yearsLabel = new Label(keyMouseFrame, SWT.NONE);
		yearsLabel.setText("years.");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(514, 31, 37, 22);
		
		Combo userValue = new Combo(keyMouseFrame, SWT.NONE);
		userValue.setItems(new String[] {});
		userValue.setBounds(300, 112, 238, 23);
		
		Label userLabel = new Label(keyMouseFrame, SWT.NONE);
		userLabel.setText("User: ");
		userLabel.setBounds(300, 91, 83, 15);
		
		Button activeValue = new Button(keyMouseFrame, SWT.CHECK);
		activeValue.setText("This piece of hardware is active.");
		activeValue.setBounds(300, 151, 188, 15);
		
		Label commentLabel = new Label(keyMouseFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 267, 69, 15);
		
		commentValue = new Text(keyMouseFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 288, 305, 81);
		
		Label messageLabel = new Label(keyMouseFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(300, 375, 309, 15);
		
		Button cancelButton = new Button(keyMouseFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(keyMouseFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 396, 75, 25);
		
		Button submitButton = new Button(keyMouseFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				brandValue.getText().equals("") || modelValue.getText().equals("") ||
				snValue.getText().equals("") || supplierValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(keyMouseFrame);
				}else {
					if(Aid.TheFrame.submitPressed(keyMouseFrame)) {
						new hardware.KeyMouse(
							"KEY - " + idValue.getText(), 
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
							
							commentValue.getText());
						keyMouseFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(keyMouseFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 396, 75, 25);
		
		
		
		
		
		
		
		
		
		
		
		

		keyMouseFrame.open();
		keyMouseFrame.layout();
		while (!keyMouseFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
		
	}
}
