import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

	static int sq = 0;
//	static List list = new List();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new FileReader(
						"C:\\Users\\Maksim\\Projects\\MovBox\\Coloring\\sample_input.txt"));
		String str = br.readLine();
		int test = Integer.valueOf(str);

		for (int i = 0; i < test; i++) {
			String[] size = br.readLine().split(" ");
			int w = Integer.valueOf(size[0]);
			int h = Integer.valueOf(size[1]);
			Cell[][] field = new Cell[h][w];
			for (int j = 0; j < h; j++) {
				String[] sarr = br.readLine().split(" ");
				for (int k = 0; k < w; k++) {
					field[j][k] = new Cell(Integer.valueOf(sarr[k]));
				}
			}
			
//			for (int j = 0; j < h; j++) {
//				for (int k = 0; k < w; k++) {
//					System.out.print(field[j][k].getType());
//				}
//				System.out.println();
//			}
			
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < w; k++) {
					sq = count(field, j, k);
					if (sq != 0) {
						list.add(sq);
						sq=0;
					}					
				}
			}
			int result=0;
			Collections.sort(list);
			Collections.reverse(list);
			for (int t =0;t<list.size();t++) {
				if (t%3==0) {
					result+=list.get(t);
				}
			}
			System.out.println(result);
//for (int j=0;j<h;j++) {
//	for (int k =0; k<w; k++) {
//		if (field[j][k].getType() == 1 ||field[j][k].isVisited()) {
//			break;
//		}
//		field[j][k].setVisited(true);
//		sq++;
//	}
//}

		}
		br.close();
	}

	private static int count(Cell[][] field, int i, int j) {
		try {
			if (field[i][j].getType() == 1 || field[i][j].isVisited()) {
				return sq;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			return sq;
		}

		field[i][j].setVisited(true);
		sq++;
		count(field, i-1, j);
		count(field, i, j+1);
		count(field, i+1, j);
		count(field, i, j-1);
		
//list.put(sq);
//sq = 0;
		return sq;
	}

//	public static class List {
//
//		Node header = new Node(null, null, null);
//		Integer size;
//
//		private class Node {
//			Integer value;
//			Node next, prev;
//
//			public Node(Integer value, Node next, Node prev) {
//				this.next = next;
//				this.prev = prev;
//				this.value = value;
//			}
//		}
//
//		public List() {
//			size = 0;
//			header.next = header;
//			header.prev = header;
//		}
//
//		public void put(Integer value) {
//			Node node = new Node(value, header, header.prev);
//			node.prev.next = node;
//			node.next.prev = node;
//			size++;
//		}
//	}
}
