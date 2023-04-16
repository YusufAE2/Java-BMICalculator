import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Yusuf Ali
 * @Date: March 11, 2023
 * @Description: This program calculates the BMI of the user, it also calculates how much nutrients (proteins, carbs, calories, etc) the 
 * 				 should consume in a day
 * 
 *
 */
public class main {

	/**
	 * 
	 */
	public main() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This function displays and prints the text to the console, has custimizible font colours
	 */
	
	public static void displayText(String text, String colour) {
		
		// create final string variables for ansi colour codes
		final String ANSI_RESET = "\u001B[0m";
		
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_YELLOW = "\u001B[33m";
			
		switch (colour) {
		
		case "def": // default font colour
			System.out.println(text);
			break;
			
		case "red": // red font colour
			System.out.println(ANSI_RED + text + ANSI_RESET);
			break;
			
		case "green": // green font colour
			System.out.println(ANSI_GREEN + text + ANSI_RESET);
			break;
			
		case "yellow": // yellow font colour
			System.out.println(ANSI_YELLOW + text + ANSI_RESET);
			break;
		}
			
	}

	/**
	 * This function calculates the users BMI percentage
	 */

	public static double calculateBMI(double weight, double height) {

		double BMI = 0;

		// calculate BMI percentage
		BMI = ((weight / 2.205) / height / height) * 10000;


		return BMI;
	}
	
	/**
	 * This function calculates the users BMR
	 */
	
	public static double calculateBMR(double weight, double height, int age) {
		
		// create and initalize varaible for BMR
		double BMR = 0;
		
		// calculate users BMR
		BMR = (10 * (weight/2.205)) + (6.25 * height) - (5 * age);
		
		return BMR;
		
	}
	
	/**
	 * This function determines if the user is obeese, overweight, or normal weight based on BMI
	 */

	public static void determineBMI(double BMI) {
	
		// tells if the user is underweight, normal, overweight, or obeese
		if (BMI < 18.5) {
			System.out.println("You are underweight");
		}
		else if (BMI >= 18.5 && BMI <= 24.9) {
			System.out.println("Normal weight");
		}
		else if (BMI >= 25 && BMI <= 29.9) {
			System.out.println("You are overweight");
		}
		else {
			System.out.println("You are obeese fatty");
		}
	}
	
	/**
	 * This function determines the calories needed for the user based on their acitivty levels
	 */
	
	public static void determineCaloriesNeeded(String choice, double BMR, DecimalFormat round) {
		
		int activityLevel = Integer.parseInt(choice);
		
		// convert string value to integer value
		
		displayText("User picked option " + activityLevel, "def");
		
		// switch statement, determines how many calories the user needs based on acitivty level
		switch (activityLevel) {
			
		case 0:
			BMR = BMR * 1.2;
			displayText("You need " + round.format(BMR) + " calories", "yellow");
			break;
		case 1:
			BMR = BMR * 1.375;
			displayText("You need " + round.format(BMR) + " calories", "yellow");
			break;
		case 2:
			BMR = BMR * 1.55;
			displayText("You need " + round.format(BMR) + " calories", "yellow");
			break;
		case 3:
			BMR = BMR * 1.725;
			displayText("You need " + round.format(BMR) + " calories", "yellow");
			break;
		case 4:
			BMR = BMR * 1.9;
			displayText("You need " + round.format(BMR) + " calories", "yellow");
			break;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// create variables for weight and height
		String userAnswer, userName = "";
		double userWeight = 0, userHeight = 0, userBMI, userBMR;
		int userAge;

		DecimalFormat decimal = new DecimalFormat("0.0"); // decimal format

		// Scanner input for string and int input
		Scanner stringInput = new Scanner(System.in);
		Scanner numInput = new Scanner(System.in);

		// display welcome message
		displayText("Welcome to the BMI Calculator Program!", "green");
		displayText("Would you like to start the program (yes/no)", "def");
		
		// prompt user for yes/no answer
		userAnswer = stringInput.nextLine();

		// if user enters "yes"
		if (userAnswer.equalsIgnoreCase("yes")) {

			// prompt user for weight in kg
			displayText("Enter your weight in LBS\n", "def");
			userWeight = numInput.nextDouble();

			// prompt user for height in CM
			displayText("Enter your height in CM\n", "def");
			userHeight = numInput.nextDouble();

			// prompt user for age
			displayText("Enter your age", "def");	
			userAge = numInput.nextInt();

			// call CalculateBMI function
			userBMI = calculateBMI(userWeight, userHeight);

			displayText(decimal.format(userBMI), "def");
			
			determineBMI(userBMI); // call determineBMI function to determine if user is underweight, normal weight, etc
			
			// prompt user if they want to calculate BMR
			displayText("\nWould you like to calculate your BMR? (yes/no)", "def");			
			userAnswer = stringInput.nextLine();
			
			// if user enters "yes"
			if (userAnswer.equalsIgnoreCase("yes")) {
				userBMR = calculateBMR(userWeight, userHeight, userAge); // calculate users BMR
				
				displayText("Your BMR is " + decimal.format(userBMR), "def"); // display users BMR
				
				displayText("\n\nPick your activity levels:", "def");
				displayText("0) Sedentary (little to no exercise)", "def");
				displayText("1) Lightly active (exercise 1-3 days/week)", "def");
				displayText("2) Moderately active (exercise 3-5 days/week)", "def");
				displayText("3) Active (exercise 6-7 days/week)", "def");
				displayText("4) Very active (hard exericse 6-7 days/week)", "def");
								
				userAnswer = stringInput.nextLine();
				
				determineCaloriesNeeded(userAnswer, userBMR, decimal);
			}
			else {
				
			}
		}		                                                                                                                                                                            
		else {

		}
	}
}
