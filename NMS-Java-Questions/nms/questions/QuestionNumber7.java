package nms.questions;

public class QuestionNumber7 {
	public static void main(String[] args) {
		String S = "java";
		printAllCombination(S, "");
		
	}

	private static void printAllCombination(String str, String ans) {
		
	        if (str.length() == 0) {
	            System.out.print(ans + " ");
	            return;
	        }
	  
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            String newStr = str.substring(0, i) + str.substring(i + 1);
	            printAllCombination(newStr, ans + ch);
	        }
	    
	}
}
