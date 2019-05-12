import java.util.*;

public class ModuleGrader_Y3872052 {
	
	// best practices recommend we should not allow direct access
	// to those variables but instead expose getters/setters for them
	private int mark;
	private String grade;
	
	// setters and getters
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	

	public String gradeModule(int mark) {
		
		if((mark <= 100) && (mark >=70)) {
			setGrade("Excellent");
		} else if((mark <= 69) && (mark >= 60)) {
			setGrade("Good");
		} else if((mark <= 59) && (mark >= 50)) {
			setGrade("Satisfactory");
		} else if((mark <= 49) && (mark >= 40)) {
			setGrade("Compensatable fail");
		} else {
			setGrade("Outright fail");
		}
		
		return getGrade();
	}
	

	public boolean getValidModuleMark() {
		boolean isValid = false;
		Scanner keyboardInput = new Scanner(System.in);
		System.out.println("Please input a mark between 0 and 100");
		
		do {
			int mark = keyboardInput.nextInt();
			if((mark <= 100) && (mark >= 0)) {
				setMark(mark);
				isValid = true;
			} else {
				// give helpful feedback
				System.out.println("This is not a valid mark, please enter a valid value...");
			}
		} while (!isValid);
		

		return isValid;
	}
	
	
	public void startModuleGrading() {
		boolean shouldContinue = true;
		System.out.println("*********** Module Grading Program *********");
		Scanner sc = new Scanner(System.in);
		
		// loop asks if grading continues
		do {
			// validate the mark and display the grade
			if(getValidModuleMark()) {
				int mark = getMark();
				String grade = gradeModule(mark);
				
				System.out.printf("The grade for mark %d is %s\n", mark, grade);
			}
			
			System.out.println("Grade another mark (y/n) ?");
			switch (sc.nextLine()) {
				case("n"):
					shouldContinue = false;
					break;
				case("no"):
					shouldContinue = false;
					break;
				default:
					shouldContinue = true;
					break;
			}
			
		} while (shouldContinue);
		System.out.println("Bye...");
		sc.close();
	}
}
