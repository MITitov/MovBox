import java.io.StringWriter;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Shuffler {

	public static void main(String[] args) throws JAXBException {
//		System.out.println(pow(8, 12));
//		System.out.println(recPOW(8, 12));
//		System.out.print(Math.pow(8, 12));
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter numer of tests: ");
		int tests = sc.nextInt();
		for (int i = 0; i < tests; i++) {
			// List list = new List();
			// list.push(1);
			// list.push(2);
			// list.push(3);
			//
			// StringWriter writer = new StringWriter();
			// JAXBContext context = JAXBContext.newInstance(List.class);
			// Marshaller marshaller = context.createMarshaller();
			// marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
			// Boolean.TRUE);
			//
			// marshaller.marshal(list, writer);
			// System.out.println(writer.toString());

			System.out.println("Enter cards:");
			sc.nextLine();
			String input = sc.nextLine();
			String[] inputArr = input.split(" ");
			int size = inputArr.length;
			int[] cards = new int[size];
							
			int[][] arr = new int[5000000][size];
			for (int j = 0; j < inputArr.length; j++) {
				cards[j] = Integer.valueOf(inputArr[j]);
			}
			MergeSort ob = new MergeSort();
			int arr1[] = {12, 11, 13, 5, 6, 7}; 
			  
	        System.out.println("Given Array"); 
	        printArr(arr1); 
	  	        
//	        ob.sort(arr1, 0, arr1.length-1); 
	  quickSort(arr1, 0, arr1.length-1);
	        System.out.println("\nSorted array"); 
	        printArr(arr1); 
			
			
			
			// int ss = 1;
			// int sst = 0;
			// int ssa = 0;
			// int result = -1;
			// arr[ssa++] = cards;
			// if (!checkSortable(cards)) {
			// result = -1;
			// } else {
			// finish: for (int j = 0; j < 7; j++) {
			// for (int k = sst; k < ss; k++) {
			// if (checkSorted(arr[k])) {
			// result = j;
			// break finish;
			// }
			// for (int x = 1; x < size; x++) {
			// arr[ssa++] = shuffle(arr[k], x, size);
			// }
			// }
			// sst = ss;
			// ss = ssa;
			// }
			// }
			// System.out.println(result);
			for (int x = 1; x < size; x++) {
				System.out.println();
				printArr(shuffle(cards, x, size));
			}
		}
		sc.close();
	}

	public static boolean equalArr(int[] a1, int[] a2) {
		if (a1.length != a2.length) {
			return false;
		} else {
			for (int i = 0; i < a1.length; i++) {
				if (a1[i] != a2[i]) {
					return false;
				}
			}
		}
		return true;
	}

	// public static int[] shuffle(int[] arr, int x, int size) {
	// int[] res = new int[size];
	// for (int i = 0; i < arr.length; i++) {
	// int tt = i - size / 2;
	// int pos = 0;
	// if (i < size / 2) {
	// int t = x + tt;
	// if (t < 0) {
	// pos = i;
	// } else {
	// pos = i + t + 1 > size / 2 ? i + size / 2 : i + t + 1;
	// }
	// } else {
	// int t = x - tt > 0 ? x - tt : 0;
	// if (t > size / 2) {
	// pos = i - size / 2;
	// } else {
	// pos = i - t;
	// }
	// }
	// res[pos] = arr[i];
	// }
	// return res;
	// }
	public static int[] shuffle(int[] arr, int x, int size) {
		int[] res = new int[size];
		int half = size / 2;
		int count = 0;
		if (x > half) {
			x-= half;
			for (int i = 0; i <x+1; i++) {
				res[i] = arr[i+half];
			}
			for (int i = x+1; i < size - x-1; i++) {
				if (count % 2 == 0) {
					res[i] = arr[++count / 2];
					//
				} else {
					res[i] = arr[i + half - ++count/2];
				}
			}
			for (int i = size - x-1; i < size; i++) {
				res[i] = arr[i-half];
			}			
		} else {
			for (int i = 0; i < half - x; i++) {
				res[i] = arr[i];
			}
			for (int i = half - x; i < half + x; i++) {
				if (count % 2 == 0) {
					res[i] = arr[count++ / 2 + half];
				} else {
					res[i] = arr[i - ++count / 2];
				}
			}
			for (int i = half + x; i < size; i++) {
				res[i] = arr[i];
			}
		}
		return res;
	}

	public static boolean checkSorted(int[] arr) {
		int temp = arr[1] - arr[0];
		for (int i = 1; i < arr.length / 2; i++) {
			if (arr[i + 1] - arr[i] != 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkSortable(int[] arr) {
		int N = arr.length;
		for (int i = 0; i < N / 2; i++) {
			if (arr[i] + arr[N - i - 1] != N + 1) {
				return false;
			}
		}
		return true;
	}

	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int pow(int a, int n) {
		int res = a;
		for (int i = 0; i < n - 1; i++) {
			res *= a;
		}
		return res;
	}

	public static int recPOW(int a,int n) {
		int res;
		if (n==1) return a;
		if (n % 2 == 0) {
			res = recPOW(a,n/2);
			return res*res;
		} else {
			res = recPOW(a, (n-1)/2);
			return res*res*a;
		}
	}
	
	static class MergeSort 
	{ 
	    void merge(int arr[], int l, int m, int r) 
	    { 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 

	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	  
	        for (int i=0; i<n1; ++i) 
	            L[i] = arr[l + i]; 
	        for (int j=0; j<n2; ++j) 
	            R[j] = arr[m + 1+ j]; 

	        int i = 0, j = 0, k = 1; 
	   	       
	        while (i < n1 && j < n2) 
	        { 
	            if (L[i] <= R[j]) 
	            { 
	                arr[k] = L[i]; 
	                i++; 
	            } 
	            else
	            { 
	                arr[k] = R[j]; 
	                j++; 
	            } 
	            k++; 
	        } 
	  
	        while (i < n1) 
	        { 
	            arr[k] = L[i]; 
	            i++; 
	            k++; 
	        } 
	  
	        while (j < n2) 
	        { 
	            arr[k] = R[j]; 
	            j++; 
	            k++; 
	        } 
	    } 
	  
	    void sort(int arr[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	            int m = (l+r)/2; 
	  
	            sort(arr, l, m); 
	            sort(arr , m+1, r); 

	            merge(arr, l, m, r); 
	        } 
	    } 
	}
	public static void quickSort(int[] arr, int l, int r) {
		int s = partitionQ(arr,l,r);
		if (l<r) {
			quickSort(arr, l, s-1);
			quickSort(arr, s+1, r);
		}
	}

	private static int partitionQ(int[] arr, int l, int r) {
		int p = arr[l];
		
		int i = l-1;
		int j = r+1;
		
		while (true) {					
			do { 
				i++;
			}
			while (arr[i]<=p);
			do {
				j--;
			}
			while (arr[j]>=p); 
			if (i>=j) {
				return j;
//                int temp = arr[i]; 
//                arr[i] = arr[j]; 
//                arr[j] = temp; 
			}
			int temp = arr[i]; 
	        arr[i] = arr[j]; 
	        arr[j] = temp;
		}
         
//		return j;
		
	}

	static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  

    static void sort(int arr[], int low, int high) 
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
