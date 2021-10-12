package nms.questions;

import java.util.Scanner;

public class AdjascentValues {

	static void printAdjascentValues(int[][] arr, int val) {
		int m = arr.length;
		int n = arr[0].length;
		System.out.println("Adjascent values: ");
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] == val) {
					if(i + 1 < m) System.out.println(arr[i + 1][j]);
					if(j + 1 < n) System.out.println(arr[i][j + 1]);
					if(i - 1 >= 0) System.out.println(arr[i - 1][j]);
					if(j - 1 >= 0) System.out.println(arr[i][j - 1]);
					return;
				}
				
			}
		}
	}
	public static void main(String[] args) {
		int[][] arr = new int[][] {
						{22, 44, 41, 84}, 
						{68, 12, 71, 33},
						{94, 14, 44, 31},
						{88, 77, 64, 68}};
						
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value: ");
		int val = sc.nextInt();
		printAdjascentValues(arr, val);
		sc.close();
	}
	

}
