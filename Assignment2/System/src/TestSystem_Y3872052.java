import javax.swing.JOptionPane;

public class TestSystem_Y3872052 {

	public static void main(String[] args) {
		System_Y3872052 testSystem1 = new System_Y3872052("Dell", "XPS", 150);
		
		displayOptions(testSystem1);
	}

	// ---helper methods---
	private static String getInputData(String message) {
		String inputString = JOptionPane.showInputDialog(message);
		return inputString;
	}
	
	static private void inputMemorySize(System_Y3872052 system) {
		// TODO - validate the input
		int memorySize = Integer.parseInt(getInputData("Please provide the memory size, in MB"));
		system.setMemory(memorySize);
	}
	
	static private void inputHardDiskSize(System_Y3872052 system) {
		// TODO - validate the input
		double hdSize = Double.parseDouble(getInputData("Please provide the hard disk size, in GB"));
		system.setHardDisk(hdSize);
	}
	
	static private void displayOptions(System_Y3872052 system) {
		String[] choices = {
			"1 - Print System Details",
			"2 - Dyagnose System",
			"3 - Set Details",
			"4 - System Properties",
			"5 - Quit"
		};
		
		boolean shouldContinue = true;
		
		while(shouldContinue) {
			String choice = (String) JOptionPane.showInputDialog(
				null,
				"Please chose an option",
				"Please chose an option",
				JOptionPane.QUESTION_MESSAGE,
				null,
				choices,
				choices[0]
			);

			if (choice != null) {
				String inputChoice = choice.substring(0, 1);
				
				switch(inputChoice) {
					case "1":
						system.displayDetails();
						break;
					case "2":
						system.diagnoseSystem();
						break;
					case "3":
						inputMemorySize(system);
						inputHardDiskSize(system);
						system.diagnoseSystem();
						break;
					case "4":
						system.displaySystemProperties();
						break;
					default:
						shouldContinue = false;
						break;
				}
			} else {
				shouldContinue = false;
			}
		}
	}
}
