
import java.util.Scanner;


public class Shuffler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numer of tests: ");
		int tests = sc.nextInt();
		for (int i = 0;i<tests; i++) {
			System.out.println("Enter number of cards in test #" + i);
			int size = sc.nextInt();
			System.out.println("Enter cards:" );
			String input = sc.nextLine();
			String[] inputArr = input.split(" ");
			int[] cards = new int[size];
			for (int j = 0; j < inputArr.length;j++) {
				cards[j] = Integer.valueOf(inputArr[j]);
			}
			
			
			
		}
	}
	
	
	public static boolean equalArr(int[] a1,int[] a2) {		
		if (a1.length != a2.length) {
			return false;
		} else {
			for (int i = 0 ; i< a1.length;i++) {
				if (a1[i]!=a2[i]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static int[] shuffle(int[] arr, int x, int size) {
		for (int i = 0; i<arr.length;i++) {
			
		}
		return new int[size];
	}

}
