package welcomingFrames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class NewRecordFrame {
	
	
	
	private Display display;
	private Shell recordFrame;
	
	private boolean openFrame = false;

	
	
	public NewRecordFrame() {
		//frame components
		display = Display.getDefault();
		recordFrame = new Shell();
		recordFrame.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		recordFrame.setSize(375, 510);
		recordFrame.setMinimumSize(375, 360);
		recordFrame.setText("New Record");
		recordFrame.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		
		//frame location
		Aid.TheFrame.getFrameLocation(recordFrame, display);
		
		
		
		
		
		//GUI components
		TabFolder tabFolder = new TabFolder(recordFrame, SWT.NONE);
		tabFolder.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		
		TabItem serviceTab = new TabItem(tabFolder, SWT.NONE);
		serviceTab.setText("  Service  ");
		
		Composite servicePanel = new Composite(tabFolder, SWT.NONE);
		serviceTab.setControl(servicePanel);
		
		Label serviceLabel = new Label(servicePanel, SWT.NONE);
		serviceLabel.setText("Register a new or a completed service.");
		serviceLabel.setBounds(71, 10, 212, 15);
		
		Button newServiceButton = new Button(servicePanel, SWT.NONE);
		newServiceButton.setBounds(119, 31, 111, 31);
		newServiceButton.setText("New Service");
		
		Button completedServiceButton = new Button(servicePanel, SWT.NONE);
		completedServiceButton.setText("Completed Service");
		completedServiceButton.setBounds(119, 68, 111, 31);
		
		TabItem hardwareTab = new TabItem(tabFolder, SWT.NONE);
		hardwareTab.setText("  Hardware  ");
		
		Composite hardwarePanel = new Composite(tabFolder, SWT.NONE);
		hardwareTab.setControl(hardwarePanel);
		
		Label hardwareLabel = new Label(hardwarePanel, SWT.NONE);
		hardwareLabel.setBounds(92, 10, 185, 15);
		hardwareLabel.setText("Register a new piece of hardware.");
		
		Button newComputerButton = new Button(hardwarePanel, SWT.NONE);
		newComputerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.ComputerFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);
				}
			}
		});
		newComputerButton.setBounds(28, 31, 127, 31);
		newComputerButton.setText("Computer");
		
		Button newServerButton = new Button(hardwarePanel, SWT.NONE);
		newServerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.ServerFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newServerButton.setText("Server");
		newServerButton.setBounds(28, 68, 127, 31);
		
		Button newMonitorButton = new Button(hardwarePanel, SWT.NONE);
		newMonitorButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.MonitorFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newMonitorButton.setBounds(28, 105, 127, 31);
		newMonitorButton.setText("Monitor");
		
		Button newKeyNmouseButton = new Button(hardwarePanel, SWT.NONE);
		newKeyNmouseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.KeyMouseFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newKeyNmouseButton.setBounds(28, 142, 127, 31);
		newKeyNmouseButton.setText("Keyboard and Mouse");
		
		Button newPrinterButton = new Button(hardwarePanel, SWT.NONE);
		newPrinterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.PrinterFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newPrinterButton.setBounds(28, 179, 127, 31);
		newPrinterButton.setText("Printer");
		
		Button newUpsButton = new Button(hardwarePanel, SWT.NONE);
		newUpsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.UpsFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newUpsButton.setBounds(28, 216, 127, 31);
		newUpsButton.setText("UPS");
		
		Button newPosButton = new Button(hardwarePanel, SWT.NONE);
		newPosButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.PosFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newPosButton.setText("POS");
		newPosButton.setBounds(182, 31, 134, 25);
		
		Button newThermalPrintButton = new Button(hardwarePanel, SWT.NONE);
		newThermalPrintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.ThermalPrinterFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newThermalPrintButton.setBounds(182, 124, 134, 25);
		newThermalPrintButton.setText("Thermal Printer");
		
		Button newScannerButton = new Button(hardwarePanel, SWT.NONE);
		newScannerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.ScannerFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newScannerButton.setText("Scanner");
		newScannerButton.setBounds(182, 93, 134, 25);
		
		Button newLabelPrintButton = new Button(hardwarePanel, SWT.NONE);
		newLabelPrintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.LabelPrinterFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newLabelPrintButton.setBounds(182, 155, 134, 25);
		newLabelPrintButton.setText("Label Printer");
		
		Button newHandScannerButton = new Button(hardwarePanel, SWT.NONE);
		newHandScannerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		newHandScannerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.HandheldScannerFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newHandScannerButton.setBounds(182, 217, 134, 25);
		newHandScannerButton.setText("Portable Terminal");
		
		Button newPriceCheckButton = new Button(hardwarePanel, SWT.NONE);
		newPriceCheckButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.PriceCheckerFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newPriceCheckButton.setBounds(182, 341, 134, 25);
		newPriceCheckButton.setText("Price Checker");
		
		Button newTouchMonButton = new Button(hardwarePanel, SWT.NONE);
		newTouchMonButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.TouchMonitorFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newTouchMonButton.setText("Touch Monitor");
		newTouchMonButton.setBounds(182, 248, 134, 25);
		
		Button newScaleButton = new Button(hardwarePanel, SWT.NONE);
		newScaleButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new hardwareFrames.ScaleFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newScaleButton.setText("Scale");
		newScaleButton.setBounds(182, 279, 134, 25);
		
		Button routerButton = new Button(hardwarePanel, SWT.NONE);
		routerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new hardwareFrames.RouterFrame();
			}
		});
		routerButton.setText("Router");
		routerButton.setBounds(182, 310, 134, 25);
		
		Button switchButton = new Button(hardwarePanel, SWT.NONE);
		switchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new hardwareFrames.SwitchFrame();
			}
		});
		switchButton.setText("Switch");
		switchButton.setBounds(28, 253, 127, 31);
		
		Button cashDrawerButton = new Button(hardwarePanel, SWT.NONE);
		cashDrawerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new hardwareFrames.CashDrawerFrame();
			}
		});
		cashDrawerButton.setText("Cash Drawer");
		cashDrawerButton.setBounds(182, 62, 134, 25);
		
		Button edpsButton = new Button(hardwarePanel, SWT.NONE);
		edpsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new hardwareFrames.EdpsFrame();
			}
		});
		edpsButton.setText("EDPS");
		edpsButton.setBounds(182, 372, 134, 25);
		
		Button dvrButton = new Button(hardwarePanel, SWT.NONE);
		dvrButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new hardwareFrames.DvrFrame();
			}
		});
		dvrButton.setText("DVR");
		dvrButton.setBounds(182, 403, 134, 25);
		
		Button taxPrinterButton = new Button(hardwarePanel, SWT.NONE);
		taxPrinterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				new hardwareFrames.TaxPrinterFrame();
			}
		});
		taxPrinterButton.setText("Tax Printer");
		taxPrinterButton.setBounds(182, 185, 134, 25);
		
		TabItem storeTab = new TabItem(tabFolder, SWT.NONE);
		storeTab.setText("  Store  ");
		
		Composite storePanel = new Composite(tabFolder, SWT.NONE);
		storeTab.setControl(storePanel);
		
		Label storeLabel = new Label(storePanel, SWT.NONE);
		storeLabel.setText("Register a new store.");
		storeLabel.setBounds(128, 10, 122, 15);
		
		Button newStoreButton = new Button(storePanel, SWT.NONE);
		newStoreButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new storeFrames.StoreFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newStoreButton.setBounds(142, 31, 75, 25);
		newStoreButton.setText("New Store");
		
		TabItem employeeTab = new TabItem(tabFolder, SWT.NONE);
		employeeTab.setText("  Employee  ");
		
		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		employeeTab.setControl(composite_3);
		
		Label employeeLabel = new Label(composite_3, SWT.NONE);
		employeeLabel.setText("Register a new employee.");
		employeeLabel.setBounds(106, 10, 137, 15);
		
		Button newEmployeeButton = new Button(composite_3, SWT.NONE);
		newEmployeeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(!openFrame) {
					openFrame = true;
					new employeeFrames.EmployeeFrame();
					openFrame = false;
				}else {
					Aid.TheFrame.messageDialogRecordFrame(recordFrame);		
				}
			}
		});
		newEmployeeButton.setBounds(126, 31, 109, 25);
		newEmployeeButton.setText("New Employee");
		
		
		
		
		recordFrame.open();
		recordFrame.layout();
		while (!recordFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		
		
	}
	
	
	
	
}
