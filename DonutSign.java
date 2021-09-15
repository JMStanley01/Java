import java.util.Scanner;
import java.lang.Math.*;
public class DonutSign{

	/***************************************
	* Project 3: DonutSign.java
	**************************************
	* Project description:
	* Displays total price for sign based off of square footage and character count.
	* Feb 17th, 2020
	***************************/
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	boolean quit = false;
	/******************
	* set up loop 
	****************/
	while(quit != true) {
	/******************
	* Have user input radius, sides, angle, and string
	****************/
	System.out.println("Enter the radius of the circles:");
	double radius = input.nextDouble();
	System.out.println("Enter the first side of the parallelogram:");
	double sideA = input.nextDouble();
	System.out.println("Enter the second side of the parallelogram:");
	double sideB = input.nextDouble();
	System.out.println("Enter the angle of the parallelogram:");
	double angleC = input.nextDouble();
	System.out.println("Enter the string you would like on your sign:");
	input.nextLine();
	/******************
	* Set up trim function to remove excess string space 
	****************/
	String s = input.nextLine().trim();
	String s1 = "";
	/******************
	* Set up loop to check for spaces in between the words
	****************/
	for (int i = 0; i < s.length(); i++){
		if(s.charAt(i) != ' ')
			//s1.concat(s.charAt(i) + "");
			s1 += s.charAt(i);
	}
	/******************
	* Have system output final costs
	****************/
	double circleArea = Math.PI * (radius * radius);
	double parallelogramArea = sideA * sideB *(Math.sin(angleC));
	System.out.printf("$%.2f\n",(s1.length() * 1.65) + ((circleArea + parallelogramArea) * 2.85));
	/******************
	* Ask user if they want to quit
	****************/
	System.out.println("Would you like to create another sign? Enter quit to exit.");
	if(input.nextLine().trim().equals("quit")){
		quit = true;
	}
	}
}
}
