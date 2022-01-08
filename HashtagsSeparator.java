import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	    //Initialize the String which needs to be split
	    String str;
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the hashtags");
	    str = sc.nextLine();
	    
	    //Use the Split method and store the array of Strings returned in a String array
	    String[] arr = str.split(" #");
	    
	    //Printing the characters using for-each loop
	    for(String character : arr)
	    {
	    	System.out.print(character+",");
	    }
	}
}
