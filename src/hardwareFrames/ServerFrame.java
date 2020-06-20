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

public class ServerFrame {
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private static Text cpuValue;
	private static Text osSNValue;
	private Text commentValue;
	private Text netNameValue;
	private Combo supplierValue;
	
	
	public ServerFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell serverFrame = new Shell();
		serverFrame.setSize(701, 799);
		serverFrame.setText("New Server");
		
		//frame size
		Aid.TheFrame.largeRegisterFrameSize(serverFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(serverFrame, display);
				
		
		
		//GUI components
		Label idLabel = new Label(serverFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(serverFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setTextLimit(999999);
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(serverFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(serverFrame, SWT.NONE);
		storeValue.setItems();
		storeValue.setBounds(72, 31, 176, 22);
		
		brandValue = new Text(serverFrame, SWT.BORDER);
		brandValue.setBounds(10, 83, 238, 22);
		
		Label brandLabel = new Label(serverFrame, SWT.NONE);
		brandLabel.setBounds(11, 62, 55, 15);
		brandLabel.setText("Brand: *");
		
		Label modelLabel = new Label(serverFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 116, 55, 15);
		
		modelValue = new Text(serverFrame, SWT.BORDER);
		modelValue.setBounds(10, 137, 238, 22);
		
		Label snLabel = new Label(serverFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 170, 55, 15);
		
		snValue = new Text(serverFrame, SWT.BORDER);
		snValue.setBounds(10, 191, 238, 22);
		
		Label supplierLabel = new Label(serverFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 222, 82, 15);
		
		supplierValue = new Combo(serverFrame, SWT.BORDER);
		supplierValue.setItems(new String[] {"AlfaNet", "iQom"});
		supplierValue.setBounds(10, 243, 238, 22);
		
		Label cpuLabel = new Label(serverFrame, SWT.NONE);
		cpuLabel.setBounds(10, 302, 55, 15);
		cpuLabel.setText("CPU: *");
		
		cpuValue = new Text(serverFrame, SWT.BORDER);
		cpuValue.setBounds(10, 323, 151, 22);
		
		Label cpuFrequencyLabel = new Label(serverFrame, SWT.NONE);
		cpuFrequencyLabel.setText("CPU Frequency: *");
		cpuFrequencyLabel.setBounds(10, 351, 144, 15);
		
		Text cpuFrequencyValue = new Text(serverFrame, SWT.BORDER);
		cpuFrequencyValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.floatNumberOnlyTextField(cpuFrequencyValue.getText(), event);
			}
		});
		cpuFrequencyValue.setBounds(8, 370, 71, 22);
		
		Label ghzLabel = new Label(serverFrame, SWT.NONE);
		ghzLabel.setText("GHz");
		ghzLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		ghzLabel.setBounds(85, 370, 41, 22);
		
		Label cpuBitsLabel = new Label(serverFrame, SWT.NONE);
		cpuBitsLabel.setText("CPU bits:");
		cpuBitsLabel.setBounds(160, 351, 68, 15);
		
		List cpuBitsValue = new List(serverFrame, SWT.BORDER);
		cpuBitsValue.setItems(new String[] {"32 bits", "64 bits"});
		cpuBitsValue.setBounds(160, 372, 88, 34);
		
		Label ramLabel = new Label(serverFrame, SWT.NONE);
		ramLabel.setText("RAM: *");
		ramLabel.setBounds(11, 417, 55, 15);
		
		Text ramValue = new Text(serverFrame, SWT.BORDER);
		ramValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(ramValue.getText(), event);
			}
		});
		ramValue.setBounds(10, 439, 69, 22);
		
		Label gbLabel = new Label(serverFrame, SWT.NONE);
		gbLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		gbLabel.setText("GB");
		gbLabel.setBounds(85, 438, 26, 22);
		
		Label storageTypeLabel = new Label(serverFrame, SWT.NONE);
		storageTypeLabel.setText("Storage type:");
		storageTypeLabel.setBounds(10, 486, 69, 15);
		
		List storageTypeValue = new List(serverFrame, SWT.BORDER);
		storageTypeValue.setItems(new String[] {"HDD", "SSD", "M2", "Other.."});
		storageTypeValue.setBounds(10, 507, 101, 64);
		
		Label storageSpaceLabel = new Label(serverFrame, SWT.NONE);
		storageSpaceLabel.setText("Storage space: *");
		storageSpaceLabel.setBounds(147, 486, 87, 15);
		
		Text storageSpaceValue = new Text(serverFrame, SWT.BORDER);
		storageSpaceValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(storageSpaceValue.getText(), event);
			}
		});
		storageSpaceValue.setBounds(147, 508, 69, 22);
		
		Label gbLabel2 = new Label(serverFrame, SWT.NONE);
		gbLabel2.setText("GB");
		gbLabel2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		gbLabel2.setBounds(222, 507, 26, 22);
		
		DateTime purchaseDate = new DateTime(serverFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(34, 623, 101, 24);
		
		Text guaranteeValue = new Text(serverFrame, SWT.BORDER);
		guaranteeValue.setEnabled(false);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setBounds(147, 623, 56, 22);
		
		Button keepDateRadio = new Button(serverFrame, SWT.RADIO);
		keepDateRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepDateRadio.setBounds(10, 623, 13, 24);
		
		Button dontKeepDateRadio = new Button(serverFrame, SWT.RADIO);
		dontKeepDateRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(false);
				guaranteeValue.setEnabled(false);
				guaranteeValue.setText("");
			}
		});
		dontKeepDateRadio.setText("   Do not register a purchase date.");
		dontKeepDateRadio.setBounds(10, 653, 206, 24);
		dontKeepDateRadio.setSelection(true);
		
		Label purchaseDateLabel = new Label(serverFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date: *");
		purchaseDateLabel.setBounds(10, 602, 101, 15);
		
		Label guaranteeLabel = new Label(serverFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(147, 602, 76, 15);
		
		Label yearsLabel = new Label(serverFrame, SWT.NONE);
		yearsLabel.setText("years");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(208, 623, 41, 22);
		
		Label osLabel = new Label(serverFrame, SWT.NONE);
		osLabel.setText("OS: *");
		osLabel.setBounds(318, 10, 55, 15);
		
		Combo osValue = new Combo(serverFrame, SWT.NONE);
		osValue.setItems(new String[] {"Windows 7 Professional GR", "Windows 10 Professional GR"});
		osValue.setBounds(318, 27, 238, 22);
		
		Label osBitsLabel = new Label(serverFrame, SWT.NONE);
		osBitsLabel.setText("OS bits: ");
		osBitsLabel.setBounds(318, 58, 55, 15);
		
		List osBitsValue = new List(serverFrame, SWT.BORDER);
		osBitsValue.setItems(new String[] {"32 bits", "64 bits"});
		osBitsValue.setBounds(318, 78, 238, 34);
		
		Label osSNLabel = new Label(serverFrame, SWT.NONE);
		osSNLabel.setText("OS S/N: ");
		osSNLabel.setBounds(318, 136, 55, 15);
		
		osSNValue = new Text(serverFrame, SWT.BORDER);
		osSNValue.setBounds(318, 157, 238, 22);
		
		Label netNameLabel = new Label(serverFrame, SWT.NONE);
		netNameLabel.setText("Net name: ");
		netNameLabel.setBounds(318, 279, 55, 15);
		
		netNameValue = new Text(serverFrame, SWT.BORDER);
		netNameValue.setBounds(318, 300, 238, 22);
		
		Label netSpeedLabel = new Label(serverFrame, SWT.NONE);
		netSpeedLabel.setText("Net speed: ");
		netSpeedLabel.setBounds(318, 328, 69, 15);
		
		List netSpeedValue = new List(serverFrame, SWT.BORDER);
		netSpeedValue.setItems(new String[] {"1 Gb", "100 Mb"});
		netSpeedValue.setBounds(318, 349, 92, 34);
		
		Label antivirusLabel = new Label(serverFrame, SWT.NONE);
		antivirusLabel.setText("Antivirus: *");
		antivirusLabel.setBounds(318, 499, 69, 15);
		
		Combo antivirusValue = new Combo(serverFrame, SWT.NONE);
		antivirusValue.setItems(new String[] {"Bitdefender Total", "Bitdefender Business"});
		antivirusValue.setBounds(318, 520, 238, 23);
		
		Label messageLabel = new Label(serverFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(359, 705, 275, 15);
		
		commentValue = new Text(serverFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(318, 603, 305, 81);
		
		Label commentLabel = new Label(serverFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(318, 582, 69, 15);
		
		Button submitButton = new Button(serverFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				   brandValue.getText().equals("") || modelValue.getText().equals("") ||
				   snValue.getText().equals("") || supplierValue.getText().equals("") ||
				   cpuValue.getText().equals("") || cpuFrequencyValue.getText().equals("") ||
				   storageSpaceValue.getText().equals("") || osValue.getText().equals("") ||
				   antivirusValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(serverFrame);
				}else {
					if(Aid.TheFrame.submitPressed(serverFrame)) {
						serverFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(serverFrame);
					}
				}
			}
		});
		submitButton.setBounds(559, 726, 75, 25);
		submitButton.setText("Submit");
		
		Button cancelButton = new Button(serverFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(serverFrame);
			}
		});
		cancelButton.setBounds(478, 726, 75, 25);
		cancelButton.setText("Cancel");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		serverFrame.open();
		serverFrame.layout();
		while (!serverFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
