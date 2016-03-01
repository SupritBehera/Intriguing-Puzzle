
/*
 * Java program to solve a puzzle whose details are mentioned in the description / README.txt file attached with this repository.
 * 
 * Date Started : 28th February, 2016.
 * 
 * Author : Suprit Kr. Behera
 * 
 * To run this program, download the .java file and run it using any Java IDE or in command line.
 * 
 * Comments have been given wherever necessary to make the logic clearer. 
 * Certain System.out.println() comments can be uncommented for testing and analysis purposes. 
 * 
 * Input ---> Number of People in String data type (numerals). 
 */

public class LastManPuzzle {
	boolean ar[]; // Boolean array to store whether n number of persons are alive(true) or dead(false).
	int countNumberOfKills;
	int numberOfPeople;
	
	public static void main (String args []) { // Accept the number of people.
		int n = Integer.parseInt(args[0]); // Store the number of people in integer variable n by converting the accepted String to an integer.
		LastManPuzzle p = new LastManPuzzle (n); 
		p.run();
	}
	
	public LastManPuzzle (int numberOfPeople) {
		ar = new boolean [numberOfPeople]; // Initialize array ar[] having elements equal to the number of people.
		for (int i = 0; i < ar.length; i++) // Loop to assign (boolean) true to every element of array ar[].
			ar[i] = true; // All elements of array are true, indicating all persons are alive initially.
		countNumberOfKills = 0;
		this.numberOfPeople = numberOfPeople;
	}
	
	void run () {
		int indexOfAlivePerson = 0; // As the first person or element ar[0] is alive and is the first one to have the sword.
		int indexOfSword = -1; // Initialization 
		while (countNumberOfKills <= (numberOfPeople - 2)) { //(numberOfPeople - 2) because the last killing happens when the value of countNumberOfKills is numberOfPeople - 2).
			kill (indexOfAlivePerson); // Kill the next alive person after the index which is passed.	 
		    indexOfSword = passSword (indexOfAlivePerson); // Pass the sword to the next alive person after the kill and store it's index.
			indexOfAlivePerson = indexOfSword; // As the person who gets the sword becomes the killer in the next iteration.
		}
	    System.out.println("Remaining Person : " + (getNextAlive(0) + 1));  // (getNextAlive(0) + 1) because indexing starts from 0 not 1 in an array.
	}
	
	int getNextAlive(int a) { // Function to return the next alive person after the index passed.
		a++; // If this is not done, function will return a if ar[a] = true.
		boolean isAlive = false;
		for (int j = a; j <= numberOfPeople; j++) {
			if (j == numberOfPeople)
				return getNextAlive(-1); // For example, no. of people are 10. Let the 7th and 2nd elements be true and the rest are false. To find the next person alive after the 7th element,
			                             // j becomes 8 (a++) and goes on checking if any element of ar[] is true till it reaches 10. Then, as it becomes equal to the number of people (10), the method is 
			                             // called again with -1 passed. Hence j becomes 0 (a++) and checks for true elements from the 0th index and returns the appropriate index.
			isAlive = ar[j]; 
			if (isAlive) { 
				//System.out.println(j);
				return j;
			}
		}
	   return -1; // Some value has to be returned which is in the scope of the method as this method returns a data of int type. 
	}
	
	void kill(int c) { // Method to kill the next alive peson after the passed value. 
		//System.out.println("Killed Person : " + getNextAlive(c));
		int d = getNextAlive(c);
		ar[d] = false; // Kill the next alive person by changing it's value to (boolean) false.
		countNumberOfKills++;
		// System.out.println("Number of Kills : " + countNumberOfKills);
	}
	
	int passSword(int b) { // Method to transfer the sword after the kill.
		//System.out.println("Sword Passed To :" + getNextAlive(b));
		return getNextAlive(b);
	}
	
	
		
		
}
	 


