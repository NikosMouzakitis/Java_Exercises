// Array holds 5 random numbers.
// We want to prin MaxArray that 
// holds two numbers,and goal is
// to contain the two biggers sorted.
//	Exercise 4.
//
public class ex4 {
	public static void main(String[] str) {
		int[] array, MaxArray;
		int i, j, tmp, max;

		array = new int[5];
		MaxArray = new int[2];
		
		for( i = 0; i < 5; i++) {
			array[i] = (int)( Math.random() * 100 );
			System.out.println(array[i]);
		}

		// using selection sort.
		for( i = 0; i < 5-1; i++) {
		
			max = array[i];

			for( j = i+1; j < 5; j++) {
				if(max < array[j]) {
					max = array[j];
					tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		System.out.println("MaxArray : ");

		for( i = 0; i < 2; i++) {
			MaxArray[i] = array[i];
			System.out.println(MaxArray[i]);
		}
	}
}
