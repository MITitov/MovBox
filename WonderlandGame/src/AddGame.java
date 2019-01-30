import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddGame {

	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(System.in);
//		int test = sc.nextInt();
//		sc.nextLine();
		
		System.setIn(new FileInputStream("C:\\Users\\Maksim\\Projects\\MovBox\\sample_input_1.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {
			char[] digits = sc.nextLine().toCharArray();
			int l = digits.length;
			int turn = 0;
			while (l > 1) {
				int sum = digits[l - 1] + digits[l - 2] - '`';
				if (sum < 10) {
					digits[l - 2] = Character.forDigit(sum, 10);
					l--;
				} else {
					digits[l - 2] = Character.forDigit(sum / 10, 10);
					digits[l - 1] = Character.forDigit(sum % 10, 10);
				}
				turn++;
			}
			System.out.println('#' + (test_case + " ")
					+ (turn % 2 == 0 ? "B" : "A"));
		}
	}
}