package com.java.streamAPI;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamGenerator {

    public static void main(String[] args) {
        Stream<Double> gereraStream = Stream.generate(() -> Math.random()).limit(10);
        gereraStream.forEach(d -> System.out.println(d));

        Stream<Integer> gereraStream2 = Stream.iterate(10, n -> n + 2).limit(10);
        gereraStream2.forEach(i -> System.out.println(i));

        String str = new String("SUN*MON*TUE");
        Pattern p =  Pattern.compile("\\*");
        Stream<String> myStream = p.splitAsStream(str);
        myStream.forEach(s -> System.out.println(s));
    }
    
}
