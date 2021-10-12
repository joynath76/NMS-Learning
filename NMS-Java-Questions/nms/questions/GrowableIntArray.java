package nms.questions;

public class GrowableIntArray {
	
	static int[] growArray(int[] arr, int newSize) {
		if(arr.length > newSize) return arr;
		
		int[] newArray = new int[newSize];
		for(int i = 0; i < arr.length; i++) newArray[i] = arr[i];
		return newArray;
	}

	public static void main(String[] args) {
		int[] intA = new int[] {2,4,6} ;
		intA = growArray(intA, 5);
		System.out.println(intA.length);
		for(int i = 0; i < intA.length; i++)
			System.out.println(intA[i]);
		
	}

}
