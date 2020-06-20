package hardwareFrames;

import java.sql.SQLException;

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

public class CashDrawerFrame {
	
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private static Text commentValue;
	private static Text supplierValue;
	
	
	
	
	public CashDrawerFrame() {
		
		//frame components
		Display display = Display.getDefault();
		Shell cashDrawerFrame = new Shell();
		cashDrawerFrame.setSize(635, 470);
		cashDrawerFrame.setText("New Cash Drawer");
		
		
		//frame size
		Aid.TheFrame.smallRegisterFrameSize(cashDrawerFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(cashDrawerFrame, display);
		
		
		
		
		//GUI components
		Label idLabel = new Label(cashDrawerFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(cashDrawerFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(hardware.CashDrawer.getNextId());
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(cashDrawerFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(cashDrawerFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 23);
		
		Label brandLabel = new Label(cashDrawerFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 92, 55, 15);
		
		brandValue = new Text(cashDrawerFrame, SWT.BORDER);
		brandValue.setBounds(10, 113, 238, 22);
		
		Label modelLabel = new Label(cashDrawerFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 141, 55, 15);
		
		modelValue = new Text(cashDrawerFrame, SWT.BORDER);
		modelValue.setBounds(10, 162, 238, 22);
		
		Label snLabel = new Label(cashDrawerFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 190, 55, 15);
		
		snValue = new Text(cashDrawerFrame, SWT.BORDER);
		snValue.setBounds(10, 211, 238, 22);
		
		Label supplierLabel = new Label(cashDrawerFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 239, 64, 15);
		
		supplierValue = new Text(cashDrawerFrame, SWT.BORDER);
		supplierValue.setBounds(10, 260, 238, 22);
		
		Label cashDeskLabel = new Label(cashDrawerFrame, SWT.NONE);
		cashDeskLabel.setText("Cash Desk: ");
		cashDeskLabel.setBounds(10, 325, 75, 15);
		
		Combo cashDeskValue = new Combo(cashDrawerFrame, SWT.NONE);
		cashDeskValue.setItems(new String[] {"no. 1", "no. 2", "no. 3", "no. 4"});
		cashDeskValue.setBounds(10, 346, 238, 23);
		
		Label purchaseDateLabel = new Label(cashDrawerFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(300, 10, 83, 15);
		
		DateTime purchaseDate = new DateTime(cashDrawerFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(324, 31, 101, 24);
		
		Text guaranteeValue = new Text(cashDrawerFrame, SWT.BORDER);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setEnabled(false);
		guaranteeValue.setBounds(453, 31, 56, 22);
		
		Button keepPurchaseDate = new Button(cashDrawerFrame, SWT.RADIO);
		keepPurchaseDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepPurchaseDate.setBounds(300, 31, 13, 24);
		
		Button dontKeepPurchaseDate = new Button(cashDrawerFrame, SWT.RADIO);
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
		
		Label guaranteeLabel = new Label(cashDrawerFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(453, 10, 76, 15);
		
		Label yearsLabel = new Label(cashDrawerFrame, SWT.NONE);
		yearsLabel.setText("years.");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(514, 31, 64, 22);
		
		Label userLabel = new Label(cashDrawerFrame, SWT.NONE);
		userLabel.setBounds(300, 113, 83, 15);
		userLabel.setText("User: ");
		
		Combo userValue = new Combo(cashDrawerFrame, SWT.NONE);
		userValue.setItems(employee.Employee.getExistingEmployees());
		userValue.setBounds(300, 134, 238, 23);
		
		Button activeValue = new Button(cashDrawerFrame, SWT.CHECK);
		activeValue.setBounds(300, 92, 188, 15);
		activeValue.setText("This piece of hardware is active.");
		
		Label commentLabel = new Label(cashDrawerFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 267, 69, 15);
		
		commentValue = new Text(cashDrawerFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 288, 305, 81);
		
		Label messageLabel = new Label(cashDrawerFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(330, 375, 275, 15);
		
		Button cancelButton = new Button(cashDrawerFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(cashDrawerFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 396, 75, 25);
		
		Button submitButton = new Button(cashDrawerFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				brandValue.getText().equals("") || modelValue.getText().equals("") ||
				snValue.getText().equals("") || supplierValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(cashDrawerFrame);
				}else {
					if(Aid.TheFrame.submitPressed(cashDrawerFrame)) {
						try {
							new hardware.CashDrawer(
								"SYR - " + idValue.getText(), 
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
								true);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						cashDrawerFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(cashDrawerFrame);
					}
				}
			}
		});
		submitButton.setText("Submit");
		submitButton.setBounds(534, 396, 75, 25);
		
		
		
		
		
		
		
		
		

		cashDrawerFrame.open();
		cashDrawerFrame.layout();
		while (!cashDrawerFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
		
	}
}
