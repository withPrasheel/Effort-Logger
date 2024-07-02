package application;

public class inputChecker {	
		//relatively simple, for it's meant to be integrated anywhere else without needing others to rewrite it each and every time. 
	public boolean isValid(String input) {
		//SQL check, can and will be updated as needed. 
		String sqlIssues = ".*([';]+|(--)+).*";
		
		return !input.matches(sqlIssues);
	}
	
	//Below is the format of a previous code, for those who wants to see it and change it later. 
//	//retrieve the text
//			String inputText = testInput.getText();
//			System.out.println("The inputted text is: " + inputText);
//			
//			//check to see if the inputs have any SQL issues
//			//Test series of inputs:
//			/*I don't like pies; and I hate SQL
//			This is a -- comment
//			SELECT * FROM Users WHERE Username='1' OR '1' = '1' AND Password='1' OR '1' = '1'
//			 */
//			boolean Valid = isValid(inputText);
//			
//			if (Valid) { //Check worked, we go ahead.
//				System.out.println("Congrats! It's valid, continue");
//				updateLabel.setText(inputText);
//			} //Check failed, don't let anything through. 
//			else{
//				updateLabel.setText("Invalid input detected! Try to not have these: .*([';]+|(--)+).*");
//				System.out.println("It's not valid, try again.");
//			}
}
