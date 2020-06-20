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

public class HandheldScannerFrame {
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private Text commentValue;
	private Text supplierValue;

	
	public HandheldScannerFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell handheldScannerFrame = new Shell();
		handheldScannerFrame.setText("New Handheld Scanner");
		
		
		//frame size
		Aid.TheFrame.mediumRegisterFrameSize(handheldScannerFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(handheldScannerFrame, display);
		
		
		
		//GUI components
		Label idLabel = new Label(handheldScannerFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(handheldScannerFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(hardware.HandheldScanner.getNextId());
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(handheldScannerFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(handheldScannerFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 23);
		
		Label brandLabel = new Label(handheldScannerFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 92, 55, 15);
		
		brandValue = new Text(handheldScannerFrame, SWT.BORDER);
		brandValue.setBounds(10, 113, 238, 22);
		
		Label modelLabel = new Label(handheldScannerFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 141, 55, 15);
		
		modelValue = new Text(handheldScannerFrame, SWT.BORDER);
		modelValue.setBounds(10, 162, 238, 22);
		
		Label snLabel = new Label(handheldScannerFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 190, 55, 15);
		
		snValue = new Text(handheldScannerFrame, SWT.BORDER);
		snValue.setBounds(10, 211, 238, 22);
		
		Label supplierLabel = new Label(handheldScannerFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 239, 64, 15);
		
		supplierValue = new Text(handheldScannerFrame, SWT.BORDER);
		supplierValue.setBounds(10, 260, 238, 22);
		
		Label purchaseDateLabel = new Label(handheldScannerFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime purchaseDate = new DateTime(handheldScannerFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(324, 31, 101, 24);
		
		Text guaranteeValue = new Text(handheldScannerFrame, SWT.BORDER);
		guaranteeValue.setEnabled(false);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setBounds(449, 32, 56, 22);
		
		Button keepPurchaseDate = new Button(handheldScannerFrame, SWT.RADIO);
		keepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepPurchaseDate.setBounds(300, 31, 13, 24);
		
		Button dontKeepPurchaseDate = new Button(handheldScannerFrame, SWT.RADIO);
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
		
		Label guaranteeLabel = new Label(handheldScannerFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(449, 11, 76, 15);
		
		Label yearsLabel = new Label(handheldScannerFrame, SWT.NONE);
		yearsLabel.setText("years.");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(511, 30, 37, 22);
		
		Label userLabel = new Label(handheldScannerFrame, SWT.NONE);
		userLabel.setText("User: ");
		userLabel.setBounds(300, 92, 83, 15);
		
		Combo userValue = new Combo(handheldScannerFrame, SWT.NONE);
		userValue.setItems(new String[] {});
		userValue.setBounds(300, 113, 238, 23);
		
		Button activeValue = new Button(handheldScannerFrame, SWT.CHECK);
		activeValue.setText("This piece of hardware is active.");
		activeValue.setBounds(300, 152, 188, 15);
		
		Label ipAddressLabel = new Label(handheldScannerFrame, SWT.NONE);
		ipAddressLabel.setText("IP Address: *");
		ipAddressLabel.setBounds(300, 198, 83, 15);
		
		Text ipAddressValue = new Text(handheldScannerFrame, SWT.BORDER);
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
		ipAddressValue.setBounds(300, 219, 238, 22);
		
		Label ramLabel = new Label(handheldScannerFrame, SWT.NONE);
		ramLabel.setText("RAM: ");
		ramLabel.setBounds(301, 260, 55, 15);
		
		Text ramValue = new Text(handheldScannerFrame, SWT.BORDER);
		ramValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(ramValue.getText(), event);
			}
		});
		ramValue.setBounds(300, 282, 56, 22);
		
		Label gbRamLabel = new Label(handheldScannerFrame, SWT.NONE);
		gbRamLabel.setText("GB");
		gbRamLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		gbRamLabel.setBounds(362, 281, 26, 22);
		
		Label storageSpaceLabel = new Label(handheldScannerFrame, SWT.NONE);
		storageSpaceLabel.setText("Storage space:");
		storageSpaceLabel.setBounds(438, 263, 76, 15);
		
		Text storageSpaceValue = new Text(handheldScannerFrame, SWT.BORDER);
		storageSpaceValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(ramValue.getText(), event);
			}
		});
		storageSpaceValue.setBounds(438, 282, 76, 22);
		
		Label gbStorageLabel = new Label(handheldScannerFrame, SWT.NONE);
		gbStorageLabel.setText("GB");
		gbStorageLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		gbStorageLabel.setBounds(521, 284, 26, 22);
		
		Label commentLabel = new Label(handheldScannerFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 377, 69, 15);
		
		commentValue = new Text(handheldScannerFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 398, 305, 81);
		
		Label messageLabel = new Label(handheldScannerFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(328, 485, 281, 15);
		
		Button cancelButton = new Button(handheldScannerFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(handheldScannerFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 506, 75, 25);
		
		Button submitButton = new Button(handheldScannerFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				brandValue.getText().equals("") || modelValue.getText().equals("") ||
				snValue.getText().equals("") || supplierValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(handheldScannerFrame);
				}else {
					if(Aid.TheFrame.submitPressed(handheldScannerFrame)) {
						new hardware.HandheldScanner(
								"HSC - " + idValue.getText(), 
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
								
								ipAddressValue.getText(),
								ramValue.getText(), 
								storageSpaceValue.getText());
						handheldScannerFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(handheldScannerFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 506, 75, 25);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		handheldScannerFrame.open();
		handheldScannerFrame.layout();
		while (!handheldScannerFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
