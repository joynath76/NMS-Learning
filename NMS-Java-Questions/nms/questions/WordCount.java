package nms.questions;

import java.util.HashMap;

public class WordCount {

	public static void main(String[] args) {
		String s = "Java is a program language , it is a platform independent language";
		String[] words = s.split(" ");
		HashMap<String, Integer> hashMap = new HashMap<>();
		for(String word: words) {
			if(hashMap.containsKey(word)) hashMap.put(word, hashMap.get(word) + 1);
			else hashMap.put(word, 1);
		}
		hashMap.forEach((key, value) -> System.out.println(key +" -> "+ value));
	}

}
