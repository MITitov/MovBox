import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		char[] init = new char[5];
		File file = new File(
				"C:\\Users\\Maksim\\Projects\\MovBox\\NumComparison\\sample_input.txt");
		Scanner sc = new Scanner(file);
		// while (sc.hasNext()) {
		// }
		String a = "31728";
		String b = "18211";
		char[] ar = a.toCharArray();
		char[] br = b.toCharArray();		
		ArrayList<Character> arl
		= new ArrayList<>(a.chars()
				.mapToObj(e -> (char) e)
				.collect(Collectors.toList()));
		ArrayList<Character> brl
		= new ArrayList<>(b.chars()
				.mapToObj(e -> (char) e)
				.collect(Collectors.toList()));
		System.out.println("Ci = " + countC(arl,brl));
		System.out.println("Di = " + countD(arl,brl));
//		List list = new List();
//		list.put(1);
//		list.put(2);
//		list.put(3);
//		list.put(4);
//		list.put(5);
//		list.put(6);
//		list.put(7);
//		list.put(8);
//		list.put(9);
//		list.print();
		// list.delete(2);
		// list.print();
		// System.out.println(list.get(2));
//		System.out.println(binarySearch(ar, '2'));
	}

	public static int countC(List a, List b) {
		int result = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == b.get(i)) {
				result++;
				a.remove(i);
				b.remove(i);
			}
		}		
		return result;
	}

	public static int countD(List a, List b) {
		int result = 0;
		for (int i =0; i<a.size();i++) {
			if (b.contains(a.get(i))) {
				result++;
				b.remove(a.get(i));
			}
		}
		return result;
	}

	public static boolean binarySearch(char[] input, char val) {
		boolean result = false;
		if (input.length == 0)
			return false;
		if (input.length == 1)
			return input[0] == val;
		if (val < input[0])
			return false;
		if (val > input[input.length - 1])
			return false;
		int l = 0;
		int r = input.length / 2;

		while (true) {
			int mid = (l + r) / 2;
			if (val == input[mid]) {
				input[mid] = 0;
				return true;
			}
			if (val < input[mid]) {
				r = mid;
			} else {
				l = mid;
			}
			return result;
		}
	}

	public static class ListC {
		Node tail, head;
		int size;

		public ListC() {
			tail = null;
			head = null;
			size = 0;
		}

		public int get(int index) {
			int result = 0;
			if (index > size - 1)
				return 0;
			if (index == 0)
				return tail.value;
			if (index == size - 1)
				return head.value;
			Node t = tail;
			for (int i = 0; i < index; i++) {
				t = t.next;
			}
			return t.value;

		}

		public void print() {
			Node t = tail;
			String s = "";
			for (int i = 0; i < size; i++) {
				s = s + " " + t.value;
				t = t.next;
			}
			System.out.println(s.trim());
		}

		public void put(int val) {
			Node n = new Node(val);
			if (size == 0) {
				head = n;
				tail = n;
				n.next = n;
				n.prev = n;
			} else {
				head.next = n;
				n.prev = head;
				head = n;
			}
			size++;
		}

		public void delete(Node node) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}

		public void delete(int val) {
			Node t = tail;
			if (t.value == val) {
				tail = tail.next;
			}
			while (t.next != null) {
				if (t.next.value == val) {
					t.next = t.next.next;
					size--;
					return;
				}
			}
		}

		public class Node {
			int value;
			Node next, prev;

			public Node(int val) {
				value = val;
			}
		}
	}

	static int partition(char arr[], int low, int high) 
    { 
		char pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                char temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        char temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  

    static void sort(char arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    }
}