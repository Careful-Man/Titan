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


public class ComputerFrame {
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private static Text cpuValue;
	private static Text osSNValue;
	private static Text officeSNValue;
	private Text commentValue;
	private Text netNameValue;
	private Combo supplierValue;
	private Text numDisksValue;
	
	
	public ComputerFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell computerFrame = new Shell();
		computerFrame.setSize(658, 802);
		computerFrame.setText("New Computer");
		
		//frame size
		Aid.TheFrame.largeRegisterFrameSize(computerFrame);
		//frame location
		Aid.TheFrame.getFrameLocation(computerFrame, display);
				
		
		
		//GUI components
		Label idLabel = new Label(computerFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Text idValue = new Text(computerFrame, SWT.BORDER);
		idValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(idValue.getText(), event);
			}
		});
		idValue.setText(hardware.Computer.getNextId());
		idValue.setTextLimit(999999);
		idValue.setBounds(10, 31, 56, 22);
		
		Label storeLabel = new Label(computerFrame, SWT.NONE);
		storeLabel.setText("Store: *");
		storeLabel.setBounds(71, 10, 55, 15);
		
		Combo storeValue = new Combo(computerFrame, SWT.NONE);
		storeValue.setItems(store.Store.getExistingStores());
		storeValue.setBounds(72, 31, 176, 22);
		
		brandValue = new Text(computerFrame, SWT.BORDER);
		brandValue.setBounds(10, 83, 238, 22);
		
		Label brandLabel = new Label(computerFrame, SWT.NONE);
		brandLabel.setBounds(11, 62, 55, 15);
		brandLabel.setText("Brand: *");
		
		Label modelLabel = new Label(computerFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 116, 55, 15);
		
		modelValue = new Text(computerFrame, SWT.BORDER);
		modelValue.setBounds(10, 137, 238, 22);
		
		Label snLabel = new Label(computerFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 170, 55, 15);
		
		snValue = new Text(computerFrame, SWT.BORDER);
		snValue.setBounds(10, 191, 238, 22);
		
		Label supplierLabel = new Label(computerFrame, SWT.NONE);
		supplierLabel.setText("Supplier: *");
		supplierLabel.setBounds(11, 222, 82, 15);
		
		supplierValue = new Combo(computerFrame, SWT.BORDER);
		supplierValue.setItems(new String[] {"AlfaNet", "iQom"});
		supplierValue.setBounds(10, 243, 238, 22);
		
		Label cpuLabel = new Label(computerFrame, SWT.NONE);
		cpuLabel.setBounds(10, 302, 55, 15);
		cpuLabel.setText("CPU: *");
		
		cpuValue = new Text(computerFrame, SWT.BORDER);
		cpuValue.setBounds(10, 323, 238, 22);
		
		Label cpuFrequencyLabel = new Label(computerFrame, SWT.NONE);
		cpuFrequencyLabel.setText("CPU Frequency: *");
		cpuFrequencyLabel.setBounds(10, 351, 101, 15);
		
		Text cpuFrequencyValue = new Text(computerFrame, SWT.BORDER);
		cpuFrequencyValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.floatNumberOnlyTextField(cpuFrequencyValue.getText(), event);
			}
		});
		cpuFrequencyValue.setBounds(8, 370, 71, 22);
		
		Label ghzLabel = new Label(computerFrame, SWT.NONE);
		ghzLabel.setText("GHz");
		ghzLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		ghzLabel.setBounds(85, 370, 41, 22);
		
		Label cpuBitsLabel = new Label(computerFrame, SWT.NONE);
		cpuBitsLabel.setText("CPU bits:");
		cpuBitsLabel.setBounds(147, 351, 55, 15);
		
		List cpuBitsValue = new List(computerFrame, SWT.BORDER);
		cpuBitsValue.setItems(new String[] {"32 bits", "64 bits"});
		cpuBitsValue.setBounds(147, 369, 101, 34);
		
		Label ramLabel = new Label(computerFrame, SWT.NONE);
		ramLabel.setText("RAM: *");
		ramLabel.setBounds(11, 417, 55, 15);
		
		Text ramValue = new Text(computerFrame, SWT.BORDER);
		ramValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(ramValue.getText(), event);
			}
		});
		ramValue.setBounds(10, 434, 44, 22);
		
		Label gbLabel = new Label(computerFrame, SWT.NONE);
		gbLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		gbLabel.setText("GB");
		gbLabel.setBounds(60, 433, 26, 22);
		
		Combo raidValue = new Combo(computerFrame, SWT.NONE);
		raidValue.setItems(new String[] {"RAID - 0", "RAID - 1", "RAID - 2", "RAID - 3", "RAID - 4", "RAID - 5", "RAID - 6"});
		raidValue.setBounds(147, 434, 101, 23);
		
		Label raidLabel = new Label(computerFrame, SWT.NONE);
		raidLabel.setText("Raid:");
		raidLabel.setBounds(147, 417, 101, 15);
		
		Label storageTypeLabel = new Label(computerFrame, SWT.NONE);
		storageTypeLabel.setText("Storage type:");
		storageTypeLabel.setBounds(10, 486, 69, 15);
		
		List storageTypeValue = new List(computerFrame, SWT.BORDER | SWT.MULTI);
		storageTypeValue.setItems(new String[] {"HDD", "SSD", "M2", "Other.."});
		storageTypeValue.setBounds(10, 507, 116, 73);
		
		Label storageSpaceLabel = new Label(computerFrame, SWT.NONE);
		storageSpaceLabel.setText("Storage space: *");
		storageSpaceLabel.setBounds(147, 486, 87, 15);
		
		Text storageSpaceValue = new Text(computerFrame, SWT.BORDER);
		storageSpaceValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(storageSpaceValue.getText(), event);
			}
		});
		storageSpaceValue.setBounds(147, 508, 69, 22);
		
		Label gbLabel2 = new Label(computerFrame, SWT.NONE);
		gbLabel2.setText("GB");
		gbLabel2.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		gbLabel2.setBounds(222, 507, 26, 22);
		
		Label numDisksLabel = new Label(computerFrame, SWT.NONE);
		numDisksLabel.setText("No. of disks: ");
		numDisksLabel.setBounds(147, 536, 87, 15);
		
		numDisksValue = new Text(computerFrame, SWT.BORDER);
		numDisksValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(numDisksValue.getText(), event);
			}
		});
		numDisksValue.setBounds(147, 558, 55, 22);
		
		Label disksLabel = new Label(computerFrame, SWT.NONE);
		disksLabel.setText("disks");
		disksLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		disksLabel.setBounds(208, 557, 41, 22);
		
		DateTime purchaseDate = new DateTime(computerFrame, SWT.BORDER);
		purchaseDate.setEnabled(false);
		purchaseDate.setBounds(34, 611, 101, 24);
		
		Text guaranteeValue = new Text(computerFrame, SWT.BORDER);
		guaranteeValue.setEnabled(false);
		guaranteeValue.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent event) {
				Aid.TheFrame.integerNumberOnlyTextField(guaranteeValue.getText(), event);
			}
		});
		guaranteeValue.setBounds(147, 613, 56, 22);
		
		Button keepDateRadio = new Button(computerFrame, SWT.RADIO);
		keepDateRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(true);
				guaranteeValue.setEnabled(true);
			}
		});
		keepDateRadio.setBounds(10, 610, 13, 24);
		
		Button dontKeepDateRadio = new Button(computerFrame, SWT.RADIO);
		dontKeepDateRadio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				purchaseDate.setEnabled(false);
				guaranteeValue.setEnabled(false);
				guaranteeValue.setText("");
			}
		});
		dontKeepDateRadio.setText("   Do not register a purchase date.");
		dontKeepDateRadio.setBounds(10, 641, 206, 24);
		dontKeepDateRadio.setSelection(true);
		
		Label purchaseDateLabel = new Label(computerFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date: ");
		purchaseDateLabel.setBounds(10, 590, 101, 15);
		
		Label guaranteeLabel = new Label(computerFrame, SWT.NONE);
		guaranteeLabel.setText("Guarantee: ");
		guaranteeLabel.setBounds(147, 592, 76, 15);
		
		Label yearsLabel = new Label(computerFrame, SWT.NONE);
		yearsLabel.setText("years");
		yearsLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		yearsLabel.setBounds(208, 613, 40, 22);
		
		Label userLabel = new Label(computerFrame, SWT.NONE);
		userLabel.setBounds(10, 671, 83, 15);
		userLabel.setText("User: *");
		
		Combo userValue = new Combo(computerFrame, SWT.NONE);
		userValue.setItems(employee.Employee.getExistingEmployees());
		userValue.setBounds(10, 692, 238, 23);
		
		Button activeValue = new Button(computerFrame, SWT.CHECK);
		activeValue.setBounds(10, 731, 188, 15);
		activeValue.setText("This piece of hardware is active.");
		
		Label ipAddressLabel = new Label(computerFrame, SWT.NONE);
		ipAddressLabel.setText("IP Address: *");
		ipAddressLabel.setBounds(318, 10, 83, 15);
		
		Text ipAddressValue = new Text(computerFrame, SWT.BORDER);
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
		ipAddressValue.setBounds(318, 28, 238, 22);
		
		Label osLabel = new Label(computerFrame, SWT.NONE);
		osLabel.setText("OS: *");
		osLabel.setBounds(318, 62, 55, 15);
		
		Combo osValue = new Combo(computerFrame, SWT.NONE);
		osValue.setItems(new String[] {"Windows 7 Professional GR", "Windows 10 Professional GR"});
		osValue.setBounds(318, 79, 238, 22);
		
		Label osBitsLabel = new Label(computerFrame, SWT.NONE);
		osBitsLabel.setText("OS bits: ");
		osBitsLabel.setBounds(318, 110, 55, 15);
		
		List osBitsValue = new List(computerFrame, SWT.BORDER);
		osBitsValue.setItems(new String[] {"32 bits", "64 bits"});
		osBitsValue.setBounds(318, 130, 238, 34);
		
		Label osSNLabel = new Label(computerFrame, SWT.NONE);
		osSNLabel.setText("OS S/N: ");
		osSNLabel.setBounds(318, 170, 55, 15);
		
		osSNValue = new Text(computerFrame, SWT.BORDER);
		osSNValue.setBounds(318, 191, 238, 22);
		
		
		Label officeLabel = new Label(computerFrame, SWT.NONE);
		officeLabel.setText("MS Office: *");
		officeLabel.setBounds(318, 243, 69, 15);
		
		Combo officeValue = new Combo(computerFrame, SWT.NONE);
		officeValue.setItems(new String[] {"Microsoft Office 365", "Microsoft Office 2016", "Microsoft Office 2013", "Microsoft Office 2010", "Microsoft Office 2007", "Microsoft Office 2003"});
		officeValue.setBounds(318, 264, 238, 23);
		
		Label officeSNLabel = new Label(computerFrame, SWT.NONE);
		officeSNLabel.setText("MS Office S/N:");
		officeSNLabel.setBounds(318, 293, 83, 15);
		
		officeSNValue = new Text(computerFrame, SWT.BORDER);
		officeSNValue.setBounds(318, 311, 238, 22);
		
		Label licensesLabel = new Label(computerFrame, SWT.NONE);
		licensesLabel.setBounds(320, 354, 55, 15);
		licensesLabel.setText("Licenses:");
		
		List licensesValue = new List(computerFrame, SWT.BORDER | SWT.MULTI);
		licensesValue.setItems(new String[] {"RetailStudio", "ERP", "Mantis", "Payroll"});
		licensesValue.setBounds(318, 375, 240, 64);
		
		Label netNameLabel = new Label(computerFrame, SWT.NONE);
		netNameLabel.setText("Net name: ");
		netNameLabel.setBounds(318, 467, 55, 15);
		
		netNameValue = new Text(computerFrame, SWT.BORDER);
		netNameValue.setBounds(318, 488, 135, 22);
		
		Label netSpeedLabel = new Label(computerFrame, SWT.NONE);
		netSpeedLabel.setText("Net speed: ");
		netSpeedLabel.setBounds(469, 467, 69, 15);
		
		List netSpeedValue = new List(computerFrame, SWT.BORDER);
		netSpeedValue.setItems(new String[] {"1 Gb", "100 Mb"});
		netSpeedValue.setBounds(469, 488, 87, 34);
		
		Label antivirusLabel = new Label(computerFrame, SWT.NONE);
		antivirusLabel.setText("Antivirus: *");
		antivirusLabel.setBounds(318, 516, 69, 15);
		
		Combo antivirusValue = new Combo(computerFrame, SWT.NONE);
		antivirusValue.setItems(new String[] {"Bitdefender Total", "Bitdefender Business"});
		antivirusValue.setBounds(318, 537, 238, 23);
		
		
		Label winUpdateLabel = new Label(computerFrame, SWT.NONE);
		winUpdateLabel.setText("Last Windows Update:");
		winUpdateLabel.setBounds(318, 570, 135, 15);
		
		DateTime winUpdateValue = new DateTime(computerFrame, SWT.BORDER | SWT.SHORT);
		winUpdateValue.setBounds(318, 591, 135, 24);
		
		Label messageLabel = new Label(computerFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty.");
		messageLabel.setBounds(352, 707, 282, 15);
		
		commentValue = new Text(computerFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(318, 642, 305, 56);
		
		Label commentLabel = new Label(computerFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(318, 621, 69, 15);
		
		Button submitButton = new Button(computerFrame, SWT.NONE);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				//checking empty fields
				if(idValue.getText().equals("") || storeValue.getText().equals("") ||
				   brandValue.getText().equals("") || modelValue.getText().equals("") ||
				   snValue.getText().equals("") || supplierValue.getText().equals("") ||
				   cpuValue.getText().equals("") || cpuFrequencyValue.getText().equals("") ||
				   storageSpaceValue.getText().equals("") || ipAddressValue.getText().equals("") ||
				   osValue.getText().equals("") || officeValue.getText().equals("") || 
				   antivirusValue.getText().equals("")) {
					Aid.TheFrame.messageDialogEmptyFields(computerFrame);
				}else {
					//if fields are ok new Computer
					String licenses = "";
					if(Aid.TheFrame.submitPressed(computerFrame)) {
						for(String l: licensesValue.getSelection()) {
							licenses += l + "   ";
						}
						new hardware.Computer(
								"PC - " + idValue.getText().trim(), 
								storeValue.getText(),
								brandValue.getText(), 
								modelValue.getText(), 
								snValue.getText(), 
								supplierValue.getText(),
								
								purchaseDate.getDay(), 
								purchaseDate.getMonth(), 
								purchaseDate.getYear(), 
								guaranteeValue.getText(), 
								keepDateRadio.getSelection(),
								userValue.getText(),
								activeValue.getSelection(),
								
								commentValue.getText(),
								
								
								cpuValue.getText(), 
								cpuFrequencyValue.getText(),
								cpuBitsValue.getSelection().toString(), 
								ramValue.getText(), 
								storageTypeValue.getSelection().toString(), 
								storageSpaceValue.getText(), 
								ipAddressValue.getText(),
								osValue.getText(), 
								osBitsValue.getSelection().toString(),
								osSNValue.getText(), 
								officeValue.getText(), 
								officeSNValue.getText(), 
								licenses,//licensesValue.getSelection(),
								netNameValue.getText(),
								netSpeedValue.getSelection().toString(), 
								antivirusValue.getText(),
								winUpdateValue.getMonth(),
								winUpdateValue.getYear(),
								true);
						computerFrame.dispose();
						Aid.TheFrame.messageDialogItemRegistered(computerFrame);
					}
				}
			}
		});
		submitButton.setBounds(559, 726, 75, 25);
		submitButton.setText("Submit");
		
		Button cancelButton = new Button(computerFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				Aid.TheFrame.cancelPressed(computerFrame);
			}
		});
		cancelButton.setBounds(478, 726, 75, 25);
		cancelButton.setText("Cancel");
		
		
		
		
		
		computerFrame.open();
		computerFrame.layout();
		while (!computerFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
