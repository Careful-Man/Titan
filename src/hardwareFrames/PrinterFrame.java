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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class PrinterFrame {
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private Text commentValue;
	private Text supplierValue;

	
	public PrinterFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell printerFrame = new Shell();
		printerFrame.setText("New Printer");
		
		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(printerFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(printerFrame, display);
		
		
		
		
		//GUI components
		Label idLabel = new Label(printerFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(printerFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(hardware.Printer.getNextId());
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(printerFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(printerFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 23);
		
		Label brandLabel = new Label(printerFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 62, 55, 15);
		
		brandValue = new Text(printerFrame, SWT.BORDER);
		brandValue.setBounds(10, 83, 238, 22);
		
		Label modelLabel = new Label(printerFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(10, 111, 55, 15);
		
		modelValue = new Text(printerFrame, SWT.BORDER);
		modelValue.setBounds(10, 132, 238, 22);
		
		Label snLabel = new Label(printerFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(10, 160, 55, 15);
		
		snValue = new Text(printerFrame, SWT.BORDER);
		snValue.setBounds(10, 181, 238, 22);
		
		Label supplierLabel = new Label(printerFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(10, 209, 64, 15);
		
		supplierValue = new Text(printerFrame, SWT.BORDER);
		supplierValue.setBounds(10, 230, 238, 22);
		
		Label printerTypeLabel = new Label(printerFrame, SWT.NONE);
		printerTypeLabel.setText("Printer type:");
		printerTypeLabel.setBounds(10, 266, 83, 15);
		
		List printerTypeValue = new List(printerFrame, SWT.BORDER);
		printerTypeValue.setItems(new String[] {"Laser", "Inkjet"});
		printerTypeValue.setBounds(10, 287, 238, 34);
		
		Label ipAddressLabel = new Label(printerFrame, SWT.NONE);
		ipAddressLabel.setText("IP Address: ");
		ipAddressLabel.setBounds(10, 349, 83, 15);
		
		Text ipAddressValue = new Text(printerFrame, SWT.BORDER);
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
		ipAddressValue.setBounds(10, 367, 238, 22);
		
		Label purchaseDateLabel = new Label(printerFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(304, 10, 83, 15);

		DateTime purchaseDate = new DateTime(printerFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(328, 31, 101, 24);
		
		Text guaranteeValue = new Text(printerFrame, SWT.BORDER);
		guaranteeValue.setEnabled(false);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setBounds(458, 31, 56, 22);
		
		Button keepPurchaseDate = new Button(printerFrame, SWT.RADIO);
		keepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepPurchaseDate.setBounds(304, 31, 13, 24);
		
		Button dontKeepPurchaseDate = new Button(printerFrame, SWT.RADIO);
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
		dontKeepPurchaseDate.setBounds(304, 61, 206, 24);
		
		Label guaranteeLabel = new Label(printerFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(458, 10, 76, 15);
		
		Label yearsLabel = new Label(printerFrame, SWT.NONE);
		yearsLabel.setText("years.");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(519, 31, 64, 22);
		
		Label userLabel = new Label(printerFrame, SWT.NONE);
		userLabel.setText("User: ");
		userLabel.setBounds(304, 91, 83, 15);
		
		Combo userValue = new Combo(printerFrame, SWT.NONE);
		userValue.setItems(employee.Employee.getExistingEmployees());
		userValue.setBounds(304, 112, 238, 23);
		
		Button activeValue = new Button(printerFrame, SWT.CHECK);
		activeValue.setText("This piece of hardware is active.");
		activeValue.setBounds(304, 140, 188, 15);
		
		Label interfaceLabel = new Label(printerFrame, SWT.NONE);
		interfaceLabel.setText("Printer Interface:");
		interfaceLabel.setBounds(304, 170, 101, 15);
		
		List printerInterfaceValue = new List(printerFrame, SWT.BORDER | SWT.MULTI);
		printerInterfaceValue.setItems(new String[] {"Net", "USB", "Parallel", "Serial"});
		printerInterfaceValue.setBounds(304, 191, 120, 64);
		
		Label commentLabel = new Label(printerFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(308, 266, 69, 15);
		
		commentValue = new Text(printerFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(308, 287, 305, 81);
		
		Label messageLabel = new Label(printerFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(338, 374, 275, 15);
		
		Button cancelButton = new Button(printerFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(printerFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(458, 395, 75, 25);
		
		Button submitButton = new Button(printerFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				   brandValue.getText().equals("") || modelValue.getText().equals("") ||
				   snValue.getText().equals("") || supplierValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(printerFrame);
				}else {
					if(Aid.TheFrame.submitPressed(printerFrame)) {
						new hardware.Printer(
							"PRN - " + idValue.getText(), 
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
							
							printerTypeValue.getSelection().toString(),
							ipAddressValue.getText(),
							printerInterfaceValue.getSelection());
						printerFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(printerFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(539, 395, 75, 25);
		
		

		printerFrame.open();
		printerFrame.layout();
		while (!printerFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
