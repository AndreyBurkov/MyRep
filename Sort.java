import java.util.Random;

class Array {
	private int arr[];
	private int temp[];
	Array(int n) {
		arr = new int[n];
		RandomArray();
	}	
	private void RandomArray() {
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++)
			arr[i] = Math.abs(rand.nextInt() % 90) + 10;
	}
	void PrintArray() {
		for (int x: arr) 
			System.out.print(x + " ");
		System.out.println();
	}
	void MergeSort() {
		arr = sort(0, arr.length - 1);
	}
	private int[] sort(int left, int right) {
		if (right - left <= 0) {
			int t[] = new int[1];
			t[0] = arr[right];
			return t;
		}
		int mid = (left + right) / 2;
		int a1[] = sort(left, mid);
		int a2[] = sort(mid + 1, right);
		temp = new int[a1.length + a2.length];
		int l1, l2;
		l1 = l2 = 0;
		for (int i = 0; i < temp.length; i++) {
			if (l1 == a1.length) {
				temp[i] = a2[l2++];
				continue;
			}
			if (l2 == a2.length) {
				temp[i] = a1[l1++];
				continue;
			}
			if (a1[l1] < a2[l2]) {
				temp[i] = a1[l1++];
			} 
			else {
				temp[i] = a2[l2++];
			}
		}
		return temp;
	}
}

public class Sort {
	public static void main(String[] args) {
		Array arr = new Array(20);
		System.out.println("\tArray:");
		arr.PrintArray();
		arr.MergeSort();
		System.out.println("\tSorted Array:");
		arr.PrintArray();
	}
}