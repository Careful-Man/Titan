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

public class PriceCheckerFrame {
	
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private static Text commentValue;
	private static Text supplierValue;
	private Text ipAddressValue;
	
	
	
	
	public PriceCheckerFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell priceCheckerFrame = new Shell();
		priceCheckerFrame.setSize(635, 470);
		priceCheckerFrame.setText("New Price Checker");
		
		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(priceCheckerFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(priceCheckerFrame, display);
		
		
		
		
		//GUI components
		Label idLabel = new Label(priceCheckerFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(priceCheckerFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(hardware.PriceChecker.getNextId());
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(priceCheckerFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(priceCheckerFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 23);
		
		Label brandLabel = new Label(priceCheckerFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 92, 55, 15);
		
		brandValue = new Text(priceCheckerFrame, SWT.BORDER);
		brandValue.setBounds(10, 113, 238, 22);
		
		Label modelLabel = new Label(priceCheckerFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 141, 55, 15);
		
		modelValue = new Text(priceCheckerFrame, SWT.BORDER);
		modelValue.setBounds(10, 162, 238, 22);
		
		Label snLabel = new Label(priceCheckerFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 190, 55, 15);
		
		snValue = new Text(priceCheckerFrame, SWT.BORDER);
		snValue.setBounds(10, 211, 238, 22);
		
		Label supplierLabel = new Label(priceCheckerFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 239, 64, 15);
		
		supplierValue = new Text(priceCheckerFrame, SWT.BORDER);
		supplierValue.setBounds(10, 260, 238, 22);
		
		Label purchaseDateLabel = new Label(priceCheckerFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime purchaseDate = new DateTime(priceCheckerFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(324, 31, 101, 24);
		
		Label guaranteeLabel = new Label(priceCheckerFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(453, 10, 76, 15);
		
		Text guaranteeValue = new Text(priceCheckerFrame, SWT.BORDER);
		guaranteeValue.setEnabled(false);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setBounds(453, 31, 56, 22);
		
		Button keepPurchaseDate = new Button(priceCheckerFrame, SWT.RADIO);
		keepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepPurchaseDate.setBounds(300, 31, 13, 24);
		
		Button dontKeepPurchaseDate = new Button(priceCheckerFrame, SWT.RADIO);
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
		
		Label yearsLabel = new Label(priceCheckerFrame, SWT.NONE);
		yearsLabel.setText("years.");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(514, 31, 64, 22);
		
		Label userLabel = new Label(priceCheckerFrame, SWT.NONE);
		userLabel.setText("User: ");
		userLabel.setBounds(300, 92, 83, 15);
		
		Combo userValue = new Combo(priceCheckerFrame, SWT.NONE);
		userValue.setItems(employee.Employee.getExistingEmployees());
		userValue.setBounds(300, 113, 238, 23);
		
		Button activeValue = new Button(priceCheckerFrame, SWT.CHECK);
		activeValue.setText("This piece of hardware is active.");
		activeValue.setBounds(300, 152, 188, 15);
		
		ipAddressValue = new Text(priceCheckerFrame, SWT.BORDER);
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
		ipAddressValue.setBounds(300, 208, 238, 22);
		
		Label ipAddressLabel = new Label(priceCheckerFrame, SWT.NONE);
		ipAddressLabel.setText("IP Address: ");
		ipAddressLabel.setBounds(300, 190, 83, 15);
		
		Label commentLabel = new Label(priceCheckerFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 267, 69, 15);
		
		commentValue = new Text(priceCheckerFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 288, 305, 81);
		
		Label messageLabel = new Label(priceCheckerFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(330, 375, 275, 15);
		
		Button cancelButton = new Button(priceCheckerFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(priceCheckerFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 396, 75, 25);
		
		Button submitButton = new Button(priceCheckerFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				  brandValue.getText().equals("") || modelValue.getText().equals("") ||
				  snValue.getText().equals("") || supplierValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(priceCheckerFrame);
				}else {
					if(Aid.TheFrame.submitPressed(priceCheckerFrame)) {
						new hardware.PriceChecker(
							"PCH - " + idValue.getText(), 
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
						priceCheckerFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(priceCheckerFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 396, 75, 25);
		
		
		
		
		
		
		
		
		
		
		
		

		priceCheckerFrame.open();
		priceCheckerFrame.layout();
		while (!priceCheckerFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
		
	}
}
