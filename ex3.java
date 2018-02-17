// Places elements into the array
// and they printing out only even 
// numbers of array.
//	Exercise 3
import java.util.Scanner;

public class ex3 {

	public static void main(String[] str) {
		int i;
		int[] pin;

		Scanner reader = new Scanner(System.in);	
		pin = new int[4];
	
		for( i = 0; i < 4; i++) {
			System.out.println("Enter element:");
			pin[i] = reader.nextInt();	
		}		
	
		System.out.println("Array entered is:");

		for( i = 0; i < 4; i++) {
	
			if( (pin[i] % 2 == 0) )		
				System.out.println(pin[i]);			
		}			
		reader.close();
	}	
}
