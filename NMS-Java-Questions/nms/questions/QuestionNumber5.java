package nms.questions;

public class QuestionNumber5 {
	
	static int findPreviousValue(float[] arr, float val) {
		
		if(val > arr[arr.length - 1]) return arr.length - 1;
		int start = 0;
		int end = arr.length;
		int mid = (start + end) / 2;
		while(start <= end) {
			if(arr[mid] == val) return mid - 1;
			else if((arr[mid + 1] > val && arr[mid] < val)) return mid;
			
			if(arr[mid] > val) end = mid - 1;
			else start = mid + 1;
			mid = (start + end) / 2;
		}
		return -1;
	}

	public static void main(String[] args) {
		float[] valueA =
	        { 
	          10.2f , 14.3f , 16.5f , 
	          18.4f , 22.3f , 36.8f , 
	          45.5f , 60.8f , 85.5f , 94.8f
	        } ;
		float val = 93f;
		int previous = findPreviousValue(valueA, val);
		if(previous < 0) System.out.println("No previous Value available");
		else System.out.println("1. Previous value is "+valueA[previous]);
		System.out.print("2. Nearest Value is: ");
		if(previous < 0) System.out.println(valueA[0]);
		else if(previous == valueA.length - 1) System.out.println(valueA[valueA.length - 1]);
		else {
			float prevValueDiff =val - valueA[previous];
			float nextValueDiff =valueA[previous + 1] - val;
			if(prevValueDiff > nextValueDiff) System.out.println(valueA[previous + 1]);
			else System.out.println(valueA[previous]);
		}
	}

}
