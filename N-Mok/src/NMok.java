import java.io.BufferedReader;
import java.io.FileReader;

public class NMok {

	public static class Cell {
		char type;
		boolean h = false, v = false, tr = false, dr = false;

		public Cell(char type) {
			this.type = type;
		}
	}

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\Maksim\\Projects\\MovBox\\sample_input.txt"));
			String str = br.readLine();
			int test = Integer.valueOf(str);
			for (int testN = 0; testN < test; testN++) {
				str = br.readLine();
				String[] conditions = str.split(" ");
				int s = Integer.valueOf(conditions[0]);
				int win = Integer.valueOf(conditions[1]);
				Cell[][] field = new Cell[s][s];
				for (int i = 0; i < s; i++) {
					str = br.readLine();
					for (int j = 0; j < s; j++) {
						field[i][j] = new Cell(str.charAt(j * 2));
					}
				}
				print(field);
				System.out.println(checkBWin(field, win));
				System.out.println(checkWWin(field, win));
			}
		} catch (Exception e) {
e.printStackTrace();
		}
	}

	private static boolean checkWWin(Cell[][] arr, int win) {
		int s = arr.length;
		// final int win = 5;
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {		
				Cell temp = arr[i][j];
				int length = 1;
				int step = 1;
				if (temp.type != '0')
					continue;
				while (j - step >= 0) {
					if (length > win)
						break;
					if (arr[i][j - step].type == '2') {
						length++;
						step++;
					} else
						break;
				}
				step = 1;
				while (j + step < s) {
					if (length > win)
						break;
					if (arr[i][j + step].type == '2') {
						length++;
						step++;
					} else
						break;
				}
				if (length == win)
					return true;
				else {
					length = 1;
					step = 1;
				}

				while (i - step >= 0) {
					if (length > win)
						break;
					if (arr[i - step][j].type == '2') {
						length++;
						step++;
					} else
						break;
				}
				step = 1;
				while (i + step < s) {
					if (length > win)
						break;
					if (arr[i + step][j].type == '2') {
						length++;
						step++;
					} else
						break;
				}
				if (length == win)
					return true;
				else {
					length = 1;
					step = 1;
				}

				while (i - step >= 0 && j - step >= 0) {
					if (length > win)
						break;
					if (arr[i - step][j - step].type == '2') {
						length++;
						step++;
					} else
						break;
				}
				step = 1;
				while (i + step < s && j + step < s) {
					if (length > win)
						break;
					if (arr[i + step][j + step].type == '2') {
						length++;
						step++;
					} else
						break;
				}
				if (length == win)
					return true;
				else {
					length = 1;
					step = 1;
				}

				while (i + step < s && j - step >= 0) {
					if (length > win)
						break;
					if (arr[i + step][j - step].type == '2') {
						length++;
						step++;
					} else
						break;
				}
				step = 1;
				while (i - step >= 0 && j + step < s) {
					if (length > win)
						break;
					if (arr[i - step][j + step].type == '2') {
						length++;
						step++;
					} else
						break;
				}
				if (length == win)
					return true;
				else {
					length = 1;
					step = 1;
				}

			}
		}
		return false;
	}

	private static boolean checkBWin(Cell[][] arr, int win) {
		int s = arr.length;
		// final int win = 5;
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s; j++) {
				Cell temp = arr[i][j];
				int length = 1;
				int step = 1;
				if (temp.type != '1')
					continue;
				try {
					if (!temp.h) {
						temp.h = true;
						while (j - step >= 0) {
							if (length > win)
								break;
							if (arr[i][j - step].type == '1') {
								arr[i][j - step].h = true;
								length++;
								step++;
							} else
								break;
						}
						step = 1;
						while (j + step < s) {
							if (length > win)
								break;
							if (arr[i][j + step].type == '1') {
								arr[i][j + step].h = true;
								length++;
								step++;
							} else
								break;
						}
					}
					if (length == win)
						return true;
					else {
						length = 1;
						step = 1;
					}

					if (!temp.v) {
						temp.v = true;
						while (i - step >= 0) {
							if (length > win)
								break;
							if (arr[i - step][j].type == '1') {
								arr[i - step][j].v = true;
								length++;
								step++;
							} else
								break;
						}
						step = 1;
						while (i + step < s) {
							if (length > win)
								break;
							if (arr[i + step][j].type == '1') {
								arr[i + step][j].v = true;
								length++;
								step++;
							} else
								break;
						}
					}
					if (length == win)
						return true;
					else {
						length = 1;
						step = 1;
					}

					if (!temp.dr) {
						temp.dr = true;
						while (i - step >= 0 && j - step >= 0) {
							if (length > win)
								break;
							if (arr[i - step][j - step].type == '1') {
								arr[i - step][j - step].dr = true;
								length++;
								step++;
							} else
								break;
						}
						step = 1;
						while (i + step < s && j + step < s) {
							if (length > win)
								break;
							if (arr[i + step][j + step].type == '1') {
								arr[i + step][j + step].dr = true;
								length++;
								step++;
							} else
								break;
						}
					}
					if (length == win)
						return true;
					else {
						length = 1;
						step = 1;
					}

					if (!temp.tr) {
						temp.tr = true;
						while (i - step >= 0 && j + step > s) {
							if (length > win)
								break;
							if (arr[i - step][j + step].type == '1') {
								arr[i - step][j + step].tr = true;
								length++;
								step++;
							} else
								break;
						}
						step = 1;
						while (i + step < s && j - step < s) {
							if (length > win)
								break;
							if (arr[i + step][j - step].type == '1') {
								arr[i + step][j - step].tr = true;
								length++;
								step++;
							} else
								break;
						}
					}
					if (length == win)
						return true;
					// else length = 1;
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		return false;
	}

	private static void print(Cell[][] arr) {
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j].type);
			}
			System.out.println();
		}
	}

}
