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

public class PosFrame {
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private Text commentValue;
	private Text supplierValue;
	private Text ipAddressValue;

	
	public PosFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell posFrame = new Shell();
		posFrame.setText("New POS");
		
		
		//frame size
		Aid.TheFrame.mediumRegisterFrameSize(posFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(posFrame, display);
		
		
		
		//GUI components
		Label idLabel = new Label(posFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(posFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(hardware.Pos.getNextId());
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(posFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(posFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 23);
		
		Label brandLabel = new Label(posFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 92, 55, 15);
		
		brandValue = new Text(posFrame, SWT.BORDER);
		brandValue.setBounds(10, 113, 238, 22);
		
		Label modelLabel = new Label(posFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 141, 55, 15);
		
		modelValue = new Text(posFrame, SWT.BORDER);
		modelValue.setBounds(10, 162, 238, 22);
		
		Label snLabel = new Label(posFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 190, 55, 15);
		
		snValue = new Text(posFrame, SWT.BORDER);
		snValue.setBounds(10, 211, 238, 22);
		
		Label supplierLabel = new Label(posFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 239, 64, 15);
		
		supplierValue = new Text(posFrame, SWT.BORDER);
		supplierValue.setBounds(10, 260, 238, 22);
		
		Label cashDeskLabel = new Label(posFrame, SWT.NONE);
		cashDeskLabel.setText("Cash Desk: *");
		cashDeskLabel.setBounds(10, 365, 75, 15);
		
		Combo cashDeskValue = new Combo(posFrame, SWT.NONE);
		cashDeskValue.setItems(new String[] {"no. 1", "no. 2", "no. 3", "no. 4"});
		cashDeskValue.setBounds(10, 386, 238, 23);
		
		Label purchaseDateLabel = new Label(posFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime purchaseDate = new DateTime(posFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(324, 31, 101, 24);
		
		Text guaranteeValue = new Text(posFrame, SWT.BORDER);
		guaranteeValue.setEnabled(false);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setBounds(453, 33, 56, 22);
		
		Button keepPurchaseDate = new Button(posFrame, SWT.RADIO);
		keepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepPurchaseDate.setBounds(300, 31, 13, 24);
		
		Button dontKeepPurchaseDate = new Button(posFrame, SWT.RADIO);
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
		
		Label guaranteeLabel = new Label(posFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(453, 12, 76, 15);
		
		Label yearsLabel = new Label(posFrame, SWT.NONE);
		yearsLabel.setText("years.");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(514, 33, 64, 22);
		
		Label userLabel = new Label(posFrame, SWT.NONE);
		userLabel.setText("User: ");
		userLabel.setBounds(300, 92, 83, 15);
		
		Combo userValue = new Combo(posFrame, SWT.NONE);
		userValue.setItems(employee.Employee.getExistingEmployees());
		userValue.setBounds(300, 113, 238, 23);
		
		Button activeValue = new Button(posFrame, SWT.CHECK);
		activeValue.setText("This piece of hardware is active.");
		activeValue.setBounds(300, 152, 188, 15);
		
		ipAddressValue = new Text(posFrame, SWT.BORDER);
		ipAddressValue.setTextLimit(15);
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
		ipAddressValue.setBounds(300, 229, 238, 22);
		
		Label ipAddressLabel = new Label(posFrame, SWT.NONE);
		ipAddressLabel.setText("IP Address: *");
		ipAddressLabel.setBounds(300, 211, 83, 15);
		
		Label ramLabel = new Label(posFrame, SWT.NONE);
		ramLabel.setText("RAM: *");
		ramLabel.setBounds(301, 268, 55, 15);
		
		Text ramValue = new Text(posFrame, SWT.BORDER);
		ramValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(ramValue.getText(), event);
			}
		});
		ramValue.setBounds(300, 295, 56, 22);
		
		Label gbRamLabel = new Label(posFrame, SWT.NONE);
		gbRamLabel.setText("GB");
		gbRamLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		gbRamLabel.setBounds(359, 294, 26, 22);
		
		Label storageTypeLabel = new Label(posFrame, SWT.NONE);
		storageTypeLabel.setText("Storage type:");
		storageTypeLabel.setBounds(403, 268, 69, 15);
		
		List storageTypeValue = new List(posFrame, SWT.BORDER);
		storageTypeValue.setItems(new String[] {"HDD", "SSD", "Other.."});
		storageTypeValue.setBounds(403, 294, 69, 49);
		
		Label storageSpaceLabel = new Label(posFrame, SWT.NONE);
		storageSpaceLabel.setText("Storage space:");
		storageSpaceLabel.setBounds(491, 268, 76, 15);
		
		Text storageSpaceValue = new Text(posFrame, SWT.BORDER);
		storageSpaceValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(storageSpaceValue.getText(), event);
			}
		});
		storageSpaceValue.setBounds(490, 295, 77, 22);
		
		Label gbStorageLabel = new Label(posFrame, SWT.NONE);
		gbStorageLabel.setText("GB");
		gbStorageLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		gbStorageLabel.setBounds(573, 294, 26, 22);
		
		Label commentLabel = new Label(posFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 377, 69, 15);
		
		commentValue = new Text(posFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 398, 305, 81);
		
		Label messageLabel = new Label(posFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(329, 485, 280, 15);
		
		Button cancelButton = new Button(posFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(posFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 506, 75, 25);
		
		Button submitButton = new Button(posFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				   brandValue.getText().equals("") || modelValue.getText().equals("") ||
				   snValue.getText().equals("") || supplierValue.getText().equals("") ||
				   cashDeskValue.getText().equals("") || ramValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(posFrame);
				}else {
					if(Aid.TheFrame.submitPressed(posFrame)) {
						new hardware.Pos(
							"POS - " + idValue.getText(), 
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
							
							cashDeskValue.getText(),
							ipAddressValue.getText(),
							ramValue.getText(),
							storageTypeValue.getSelection().toString(),
							storageSpaceValue.getText());
						posFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(posFrame);
					}
				}
				
				
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 506, 75, 25);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		posFrame.open();
		posFrame.layout();
		while (!posFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
