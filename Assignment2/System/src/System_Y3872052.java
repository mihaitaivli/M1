import java.lang.invoke.SwitchPoint;

import javax.swing.*;

public class System_Y3872052 {
	private String make;
	private String model;
	private int speed;
	private int memorySize; // in MB
	private double hardDiskSize; // in GB
	private double purchaseCost;
	
	public System_Y3872052(String make, String model, int speed) {
		this.make = make;
		this.model = model;
		this.speed = speed;
	}

	// ---getters---
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getProcessorSpeed() {
		return speed;
	}

	// ---setters---
	public void setMemory(int memorySize) {
		this.memorySize = memorySize;
	}

	public void setHardDisk(double hardDiskSize) {
		this.hardDiskSize = hardDiskSize;
	}

	public void setPurchaseCost(double purchaseCost) {
		this.purchaseCost = purchaseCost;
	}
	
	// ---custom methods---
	public String checkHDStatus() {
		return this.hardDiskSize < 2 ?
				"Low" : "OK";
	}
	
	public boolean goodMemorySize() {
		return !(this.memorySize < 128);
				
	}
	
	public void diagnoseSystem() {
		String diagnose = String.format(
			"Hard disk size: %s\nMemory size OK: %s",
			checkHDStatus(),
			goodMemorySize()
		);
		display(diagnose, "System diagnose");
	}
	
	public void displayDetails() {
		String details = String.format(
			"Make: %s\nModel: %s\nSpeed: %d",
			getMake(),
			getModel(),
			getProcessorSpeed()
		);
		display(details, "System details");
	}

	public void displaySystemProperties() {
		String operatingSystem = System.getProperty("os.name");
		
		String additionalMessage;
		switch(operatingSystem) {
		case "windows XP":
			additionalMessage = "\nGood! Still going string.";
			break;
		case "Linux":
			additionalMessage = "\nNoo! Microsoft is losing money.";
			break;
		default:
			additionalMessage = "";
			break;
		}
		
		String properties = String.format(
				"Operating System Architecture: %s\n"
				+ "Operating System Name: %s\n"
				+ "Operating System Version: %s, User Account Name: %s\n"
				+ "Java Version :%s",
				System.getProperty("os.arch"),
				operatingSystem,
				System.getProperty("os.version"),
				System.getProperty("user.name"),
				System.getProperty("java.version")
			).concat(additionalMessage);
		
			display(properties, "System properties");
	}
	
	// --helper method---
	private void display(String text, String title) {
		JTextArea outputArea = new JTextArea();
		outputArea.setText( text );
		
		JOptionPane.showMessageDialog(
			null,
			outputArea,
			title,
			JOptionPane.INFORMATION_MESSAGE
			);
	}
}
