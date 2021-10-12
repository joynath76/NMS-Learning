package nms.questions;

import java.util.Random;

public class QuestionNumber6 {
	static void fillArray(int[] arr) {
		Random rnd = new Random();
		int counter = 0;
		while(counter < arr.length - 1) {
			int val = rnd.nextInt(arr.length);
			if(!isPresent(arr, val)) {
				arr[counter] = val;
				counter += 1;
			}
		}
		System.out.println("Output");
		for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
	}
	
	private static boolean isPresent(int[] arr, int val) {
		for(int i = 0; i < arr.length; i++) if(arr[i] == val) return true;
		return false;
	}

	public static void main(String[] args) {
		int size = 25;
		int[] intA = new int[size];
		fillArray(intA);
	}
}
