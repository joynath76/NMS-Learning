package com.java.streamAPI;

import java.util.Arrays;
import java.util.stream.Stream;

import com.java.streamAPI.App.Color;

public class StreamFromArray {
    public static void main(String[] args) {

        Dress a = new Dress("T shirt", 21, Color.BLUE);
        Dress b = new Dress("POLO", 21, Color.GREEN);
        Dress c = new Dress("Shirt", 21, Color.RED);
        Dress d = new Dress("Pant", 21, Color.BLUE);
        Dress[] dresses = new Dress[]{a,b,c,d};

        Stream<Dress> myStream = Arrays.stream(dresses);

        System.out.println("Full Array using Arrays Stream Methods");
        myStream.forEach(dress -> System.out.println(dress.getName() +" "+ dress.getSize() + " " + dress.getColor()));
        System.out.println("Half Array using Arrays Stream Methods");
        Stream<Dress> myStream2 = Arrays.stream(dresses, 1, 3);
        myStream2.forEach(dresss -> System.out.println(dresss.getName() +" "+ dresss.getSize() + " " + dresss.getColor()));

        Stream<Dress> myStream3 = Stream.of(a,b,c,d);
        System.out.println("Full Array using Stream of Methods");
        myStream3.forEach(drr -> System.out.println(drr.getName() +" "+ drr.getSize() + " " + drr.getColor()));

    }
    
}
