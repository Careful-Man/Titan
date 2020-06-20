package hardwareFrames;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

public class LaserPrinterFrame {
	private static Text brandValue;
	private static Text modelValue;
	private static Text snValue;
	private Text commentValue;

	
	public LaserPrinterFrame() {
		//frame components
		Display display = Display.getDefault();
		Shell laserPrinterFrame = new Shell();
		laserPrinterFrame.setText("New Laser Printer");
		
		
		//frame size
		assist.ThisFrame.smallRegisterFrame(laserPrinterFrame);
		//frame location
		assist.ThisFrame.getLocation(laserPrinterFrame, display);
		
		
		
		
		//GUI components
		Label idLabel = new Label(laserPrinterFrame, SWT.NONE);
		idLabel.setText("ID: *");
		idLabel.setBounds(10, 10, 55, 15);
		
		Spinner idValue = new Spinner(laserPrinterFrame, SWT.BORDER);
		idValue.setMaximum(100000);
		idValue.setIncrement(0);
		idValue.setBounds(10, 31, 56, 22);
		
		Label brandLabel = new Label(laserPrinterFrame, SWT.NONE);
		brandLabel.setText("Brand: *");
		brandLabel.setBounds(11, 62, 55, 15);
		
		brandValue = new Text(laserPrinterFrame, SWT.BORDER);
		brandValue.setBounds(10, 83, 238, 22);
		
		Label modelLabel = new Label(laserPrinterFrame, SWT.NONE);
		modelLabel.setText("Model: *");
		modelLabel.setBounds(11, 116, 55, 15);
		
		modelValue = new Text(laserPrinterFrame, SWT.BORDER);
		modelValue.setBounds(10, 137, 238, 22);
		
		Label snLabel = new Label(laserPrinterFrame, SWT.NONE);
		snLabel.setText("S/N: *");
		snLabel.setBounds(11, 170, 55, 15);
		
		snValue = new Text(laserPrinterFrame, SWT.BORDER);
		snValue.setBounds(10, 191, 238, 22);
		
		Label commentLabel = new Label(laserPrinterFrame, SWT.NONE);
		commentLabel.setText("Comments:");
		commentLabel.setBounds(300, 111, 69, 15);
		
		commentValue = new Text(laserPrinterFrame, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		commentValue.setBounds(300, 132, 305, 81);
		
		Label messageLabel = new Label(laserPrinterFrame, SWT.NONE);
		messageLabel.setText("Fields marked with an asterisk ( * ) cannot be empty or 0.");
		messageLabel.setBounds(300, 285, 309, 15);
		
		Button cancelButton = new Button(laserPrinterFrame, SWT.NONE);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				assist.ThisFrame.cancelPress(laserPrinterFrame);
			}
		});
		cancelButton.setText("Cancel");
		cancelButton.setBounds(453, 306, 75, 25);
		
		Button submitButton = new Button(laserPrinterFrame, SWT.NONE);
		submitButton.setText("Submit");
		submitButton.setBounds(534, 306, 75, 25);
		
		Label purchaseDateLabel = new Label(laserPrinterFrame, SWT.NONE);
		purchaseDateLabel.setText("Purchase Date:");
		purchaseDateLabel.setBounds(304, 10, 83, 15);
		
		Button keepPurchaseDate = new Button(laserPrinterFrame, SWT.RADIO);
		keepPurchaseDate.setBounds(304, 31, 13, 24);
		
		DateTime purchaseDate = new DateTime(laserPrinterFrame, SWT.BORDER);
		purchaseDate.setBounds(328, 31, 101, 24);
		
		Button dontKeepPurchaseDate = new Button(laserPrinterFrame, SWT.RADIO);
		dontKeepPurchaseDate.setText("   Do not register a purchase date.");
		dontKeepPurchaseDate.setSelection(true);
		dontKeepPurchaseDate.setBounds(304, 61, 206, 24);
		
		

		laserPrinterFrame.open();
		laserPrinterFrame.layout();
		while (!laserPrinterFrame.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

}
