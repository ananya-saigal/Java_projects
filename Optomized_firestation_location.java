import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pro2_saigala3 {
    //Initializing a public BufferedReader object; the only BufferedReader object in the entire program
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
	//creating the main method
    public static void main(String[] args) throws NumberFormatException, IOException {
    	 //initializing 2D array to store all house coordinates
    	int[][] data_array = new int[20][2];

        //initializing variables to use later
        int radius_firestaton=0;
        int number_houses=0;
        int output_choice=0;
        
        //Loop runs for all inputs except 0 (0 makes the loop end)
        do{
            displayMenu();
            //Making the output an integer value
            //If it can't be an integer then error is printed
            try {
            	output_choice= Integer.parseInt(reader.readLine());
               
            }
            catch(NumberFormatException e) {
            	output_choice=-1;
            }
            catch(IOException e) {
            	output_choice=-1;
            }
            
            //User wants to input house coordinates so calling the function
            if (output_choice==1){
                number_houses=getHouseCoords(data_array, number_houses);
            }
            
            //User wants to view home coordinates
            //Only displays data if data the array has home coordinates 
            else if (output_choice==2){
                if (number_houses==0) {
                    System.out.println("\nERROR: No houses entered!\n");
                }
               
                else{
                    displayHouses(data_array, number_houses);  
                }
            }
            
            //User wants to input the fire station radius
            else if (output_choice==3){
            	System.out.println();
                radius_firestaton=getInteger("Enter fire station radius: ", 0, 30);
                System.out.println();
            }
            
            //User wants to assess the fire station radius
            //Only possible if the array contains home coordinates
            else if (output_choice==4){
                if (number_houses==0) {
                    System.out.println("\nERROR: No houses entered!\n");
                }
                else{
                    assessFireStationLocations(radius_firestaton, data_array, number_houses);
                }
            }
            
            //user wants database cleared so we make number_homes variable 0
            else if (output_choice==5) {
                number_houses = 0;
                System.out.println("\nHouse location database cleared!\n");
                data_array = new int[20][2];
 
            } 
            
            //Error check and statement as the input can't be anything other than 0,1,2,3,4,and 5
            else {
            	if (output_choice!=0){
            		System.out.println("\nERROR: Invalid menu choice!\n");
            	}
            }
    //Once the user inputs 0 the program ends        
    }while (output_choice!=0);
        System.out.println("\nAu revoir!");
    }
    
    
    //Function prints the program name and menu options
    public static void displayMenu() {
        System.out.println("   JAVA FIRE STATION LOCATION PROGRAM");
        System.out.println("0 - Quit");
        System.out.println("1 - Enter location of houses");
        System.out.println("2 - Display house locations");
        System.out.println("3 - Set fire station radius");
        System.out.println("4 - Assess fire station locations");
        System.out.println("5 - Clear house locations\n");
        System.out.print("Enter choice: ");

    }

    //Function ensures a valid integer input is provided by the user 
    //To be valid the input is in between the specified max and min value	  
    public static int getInteger(String prompt, int LB, int UB) {
        int input=0;
        int valid=0;
        //Creating error messages
        String error_message;
        if (UB==Integer.MAX_VALUE){
            error_message="ERROR: Input must be an integer in ["+LB+", infinity]!\n";
            }
        if (LB==Integer. MIN_VALUE){
        	error_message="ERROR: Input must be an integer in [-infinity, "+UB+"]!\n";;
        }
        else{
        	error_message="ERROR: Input must be an integer in ["+LB+", "+UB+"]!\n";
        }

        //Catching and printing error message if input is not integer or specified bound
        while (valid==0){
            System.out.print(prompt);
            
            try {
                input= Integer.parseInt(reader.readLine());
               
            }
            catch(NumberFormatException e) {
                valid = 0;
                input=-1;
            	
                
            }
            catch(IOException e) {
                valid = 0;
                input=-1;
            	
                
            }
            
            if (input>=LB && input<=UB) {
                valid=1;
            }
            else {
            	valid=0;
            	System.out.println(error_message);
                
            }
        }    
        //returns the valid input
        return input;
    }
   
    
    //Function takes house coordinates and stores it into the provided array
    public static int getHouseCoords(int [][] houseCoords, int nHouses){
       System.out.println("\nEnter coordinates (0, 0)  to quit at any time.\n");
       int x_coordinate =  getInteger("x-coordinate of house " + (nHouses+1)+": ", 0, 20);
       int y_coordinate =  getInteger("y-coordinate of house " + (nHouses+1)+": ", 0, 20);
       System.out.println("");
       nHouses=nHouses+1;
       
       //Loop runs if coordinate is not (0,0)
       while (y_coordinate!=0||x_coordinate!=0) {
           houseCoords[nHouses-1][0]=x_coordinate;
           houseCoords[nHouses-1][1]=y_coordinate;
           nHouses=nHouses+1;
           x_coordinate =  getInteger("x-coordinate of house " + (nHouses)+": ", 0, 20);
           y_coordinate =  getInteger("y-coordinate of house " + (nHouses)+": ", 0, 20);
           System.out.println("");
       }
       return (nHouses-1);
       }
    
    //Function takes house coordinates from the provided array and prints it in tale form
    public static void displayHouses(int [][] houseCoords, int nHouses){
        System.out.println("\nHouse   X   Y");
        System.out.println("-------------");
        for (int i = 0; i < (nHouses) ; ++i) {
            System.out.format("%2d%7d%4d\n",(i+1),houseCoords[i][0],houseCoords[i][1]); 
        }
        System.out.print("\n");
    }  

    
    // Assess the fire station  based of Euclidean distances and returns the minimum distance
    public static void assessFireStationLocations(int r, int [][] houseCoords, int nHouses) {
        System.out.println("\nEnter coordinates (0, 0)  to quit at any time.\n");
        int runs=0;
        int x_value=0;
        int y_value=0;
        int x_firestation, y_firestation=0;
        //Minimum is initially set as largest value so it can slowly decrease to minimum
        double min=Double.MAX_VALUE;
        do {
            x_firestation =  getInteger("x-coordinate of fire station: ", 0, 20);
            y_firestation =  getInteger("y-coordinate of fire station: ", 0, 20);
            double sum=0.0;
            
            if (x_firestation!=0||y_firestation!=0) {
                for (int i = 0; i < nHouses; ++i) {
                	//Euclidean distances calculation 
                    double square_root= Math.sqrt(Math.pow(houseCoords[i][0]-x_firestation, 2.0)+Math.pow(houseCoords[i][1] - y_firestation, 2.0));
               
                    if  (square_root> r){
                    	sum+=square_root;
                    }
                }
                System.out.format("Score of fire station at (%d, %d): %.2f\n\n", x_firestation, y_firestation, sum);
                runs= runs+1;
               
                if (sum<min){
                    min=sum;
                    x_value=x_firestation;
                    y_value=y_firestation;
                }
   
            }
        }while (x_firestation!=0||y_firestation!=0);
         
        if (runs>0){
        	System.out.print("\n");
        	System.out.format("%d locations tried.\n", runs);
        	System.out.format("Best location: (%d, %d) with score %.2f.\n\n", x_value, y_value, min);
        }
    }
}
