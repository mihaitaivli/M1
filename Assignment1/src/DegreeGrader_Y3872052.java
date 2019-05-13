import java.util.*;

public class DegreeGrader_Y3872052 {
	private final int MINIMUM = 0;
	private int all_ModuleAverage;
	private int ism_ModuleAverage;
	private int compensatableFailedModules;
	private int outrightFailedModules;
	
	Scanner kb = new Scanner(System.in);
	
	public int readAndValidateInput(String target, int maximum) {
		boolean shouldContinue = true;
		int value = 0;
		
		while(shouldContinue) {
			System.out.printf("Please input the value for %s\n", target);
			value = kb.nextInt();
			if(value < MINIMUM || value > maximum) {
				System.out.printf("The value %d is not valid.\n"
						+ "Please enter a value between %d and %d\n", value, MINIMUM, maximum);
			} else {
				shouldContinue = false;
			}
			
		}
		return value;
	}
	
	public boolean continueGrading() {
		System.out.println("\nContinue grading? (y/n)\n");
		boolean shouldContinue = true;
		
		String input = kb.next();
		if(input.equals("n")) { // atm we only check for the char 'n'- TODO: improve input validation
			System.out.println("Bye...");
			shouldContinue = false;
		}
		return shouldContinue;
	}
	
	public String gradeDegree(
			int all_ModuleAverage,
			int ism_ModuleAverage,
			int compensatableFailedModules,
			int outrightFailedModules
		) {
			String outcome = "fail";
			
			if(
				(outrightFailedModules == 0) &&
				(ism_ModuleAverage >= 70) &&
				(compensatableFailedModules == 0) &&
				(all_ModuleAverage >= 70)
			) {
				outcome = "distinction";
			} else if (
				(all_ModuleAverage >= 60) &&
				(ism_ModuleAverage >= 60) &&
				(compensatableFailedModules <= 1) &&
				(outrightFailedModules <= 1)
			) {
				outcome = "merit";
			} else if (
					(all_ModuleAverage >= 50) &&
					(ism_ModuleAverage >= 50) &&
					(compensatableFailedModules <= 1) &&
					(outrightFailedModules <= 1)
				) {
					outcome = "pass";
				}
			
			return outcome;
		}
	
	public void startDegreeGrading() {
		System.out.println("*********** Degree Classification Program *********");
		do {
			all_ModuleAverage = readAndValidateInput("All modules average", 100);
			ism_ModuleAverage = readAndValidateInput("ISM modules average", 100);
			compensatableFailedModules = readAndValidateInput("Compensatable Failed Modules", 180);
			outrightFailedModules = readAndValidateInput("Outright Failed Modules", 11);
			
			String gradingOutcome = gradeDegree(
					all_ModuleAverage,
					ism_ModuleAverage,
					compensatableFailedModules,
					outrightFailedModules);
			
			System.out.printf("The degree grade is: %s\n", gradingOutcome);
		} while(continueGrading());
	}
}
