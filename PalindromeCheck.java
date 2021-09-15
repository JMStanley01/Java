/*******************************************************
* Project PalindromeCheck
********************************
* Dermines if given number is a palindrome
* Feb 6, 2020
*****************/
import java.util.Scanner;
public class PalindromeCheck{
public static void main(String[] args){
/************************
* Create Scanner
*************************/
Scanner input = new Scanner(System.in);

/*****************************
*have the system ask for the input
******************************/

	System.out.println("Enter 0 if you would like to enter a 4-digit number.  Enter 1 if you" +
" would like to have the computer generate it.");
	int value = input.nextInt();
	/************
	* set up if statements for inputs of 0 and 1
	****/
	if (value == 0)
	{
		System.out.println("Enter the 4-digit number:");
		int palindrome = input.nextInt();
		
		/*************
		* should display an error if palindrome input is not 4 digits
		*****/
		if((palindrome < 1000) || (palindrome > 9999))
		{
			System.out.println("Incorrect input");
		}
		else
		{	
			/**********************************
			* Set up an if statements that checks that the number is an actual palindrome
			************************************/
			if((palindrome % 10) == (palindrome / 1000) && ((palindrome % 100) / 10) == ((palindrome / 100) % 10))
			{
				
				System.out.println(palindrome + " is a palindrome");
			}
			/***************************
			* Set up a statement for when it fails the previous if statement
			*****************************/
			else
			{

				System.out.println(palindrome + " is not a palindrome");
			}
		}
	}
	else if (value == 1)
	{
		/****************
		*set up Math.random and configure it to produce 4 digit numbers
		******/
		int palindrome = (int)(Math.random() * 9999) + 1000;
		System.out.println(palindrome);
		/*****************
		* Just like the the steps above for input == 0, set up an if statement that checks for a palindrome
		*****************/
		if((palindrome % 10) == (palindrome / 1000) && ((palindrome % 100) / 10) == ((palindrome / 100) % 10))
		{
		System.out.println(palindrome + " is a palindrome");
		}
		/***************************
		* Set up a statement for when it fails the previous if statement
		*****************************/
		else
		{
			System.out.println(palindrome + " is not a palindrome");
		}

	}
	/******************
	* Set up statement for when something other than 0 or 1 is entered.
	*****************/
	else
	{
		System.out.println("Incorrect input");
	}

}
}
