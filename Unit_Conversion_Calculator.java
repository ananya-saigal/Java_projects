//Program converts between feet and inches and centimeters. The conversion factor 1 in = 2.54cm.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Unit_Conversion_Calculator{
	
	//creating the main method
	public static void main(String[] args) throws NumberFormatException, IOException {
		//Printing the program name and menu options
		System.out.println("   JAVA CONVERSION PROGRAM"); 
		System.out.print( "0 - Quit\n"+"1 - Convert feet and inches to centimeters\n"+
		"2 - Convert centimeters to feet and inches\n"+"\nEnter choice: " );
		
		//reading the choice
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//Making the output an integer value
		int output_choice= Integer.parseInt(reader.readLine());
		
		//The while loop runs for all inputs except 0 (0 makes the loop end)
		while(output_choice!=0){
			
			//user wants feet and inches to be converted to cm
			if (output_choice==1){
				System.out.print("\nEnter feet and inches: ");
				//using the reader object to get the feet and inches input 
				double feet=Double.parseDouble(reader.readLine());
				double inches= Double.parseDouble(reader.readLine());
				
				//Feet and inches can't be less than 0, hence conducting an error check
				if (feet<0 || inches<0) {
					System.out.println("ERROR: Negative numbers not allowed!\n");
				}
				//Converting the inputed inches and feet to cm
				else {
					//1 foot is 12 inches; 2.54 cm is 1 inch.
					double cm=feet*(12)*(2.54);  
					//converting inches to cm and adding it to the previously calculated cm
					cm=cm+(inches*2.54);
				
					//Print out the converted feet and inches to cm
					System.out.println(feet + " feet " + inches + " inches equals "+ cm +" centimeters.\n");
					}
				}
			
			//user wants cm to be converted to feet and inches
			else if (output_choice==2){
				System.out.print("\nEnter centimeters: ");
				//using the reader object to get the cm input 
				double centimeter=Double.parseDouble(reader.readLine());
				
				//Centimeter can not be less than 0, hence conducting an error check
				if (centimeter<0) {
					System.out.println("ERROR: Negative numbers not allowed!\n");	
				}
				//Converting the inputed cm to inches and feet
				else {
					//converting centimeter to inches
					double centimeter_to_inches= (centimeter)/(2.54);
					//we want to convert centimeter to feet 
					//we want feet to be rounded down (i.e 5.6 feet should be 5.0 feet)
					double feet = Math.floor((centimeter)/(2.54*12)); 
					//calculating the amount of inches not converted to feet
					double inch = centimeter_to_inches-(feet*12);
					//Print out the converted feet and inches 
					System.out.println(centimeter + " centimeters equals " + feet + " feet " + inch + " inches.\n");
					
					}
				    
				}
		
			//Error check and statement as the input can't be anything other than 0,1,and 2
			else {
				System.out.println("\nERROR: Invalid menu choice!\n");
				}	
			
			//Showing menu and intro again(after each conversion or error statement the menu is printed for the user)
			System.out.println("   JAVA CONVERSION PROGRAM");
			System.out.print( "0 - Quit\n"+"1 - Convert feet and inches to centimeters\n"+"2 - "
					+ "Convert centimeters to feet and inches\n"+"\nEnter choice: " );
			output_choice= Integer.parseInt(reader.readLine());
		}
		//Once the user inputs 0 the program ends and "Goodbye" is printed
		System.out.println("\nGoodbye!");
	}
		

}
