
public class TestDegreeGrader_Y3872052 {

	public static void main(String[] args) {
		DegreeGrader_Y3872052 test_dg = new DegreeGrader_Y3872052();
		DegreeGrader_Y3872052 test_input= new DegreeGrader_Y3872052();
		
		// test read and validate input
		test_input.readAndValidateInput("All modules", 100);
		test_input.readAndValidateInput("Outright failed", 11);
		
		//test continue grading
		test_input.continueGrading();
		
		// all together now :)
		test_dg.startDegreeGrading();
	}

}
