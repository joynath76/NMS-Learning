package com.java.streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    enum Color{
        RED, GREEN, BLUE
    }
    public static void main(String[] args) throws Exception {

        List<Dress> myDresses = new ArrayList<>();
        myDresses.add(new Dress("Jeans Pent", 32, Color.RED));
        myDresses.add(new Dress("Shirt", 40, Color.GREEN));
        myDresses.add(new Dress("Kurta", 45, Color.BLUE));
        myDresses.add(new Dress("Kurta", 45, Color.BLUE));
        Stream<Dress> myStream = myDresses.stream();

       // myStream.forEach(dress -> System.out.println(dress.getName() +" "+ dress.getSize() + " " + dress.getColor()));
        /* myStream
        .filter(dress -> {
            System.out.println(dress.getSize());
            return dress.getSize() > 32;
        })
        .forEach(dress -> System.out.println(dress.getName() +" "+ dress.getSize() + " " + dress.getColor())); 
        myStream
        .map(ss -> {
            System.out.println(ss.getSize());
            return ss.getSize();
        })
        .forEach(size -> System.out.println(size));
        myStream
        .filter(dress -> {
            return dress.getSize() > 32;
        })
        .map(dress -> {
            return dress.getName();
        })
        .sorted(Comparator.reverseOrder())
        .forEach(name -> {
            System.out.println(name);
        });
        myStream.sorted(Comparator.comparing((dress) -> ((Dress) dress).getSize()).reversed())
        .forEach(dress -> System.out.println(dress.getName()));*/

        Map<Color, Integer> d =  myDresses.stream().collect(Collectors.groupingBy(Dress::getColor, Collectors.summingInt(Dress::getSize)));
        System.out.println(d.get(Color.BLUE));
        System.out.println(myDresses.stream().collect(Collectors.groupingBy(Dress::getColor, Collectors.averagingDouble(Dress::getSize))));
        System.out.println(myDresses.stream().collect(Collectors.groupingBy(Dress::getColor, Collectors.summarizingLong(Dress::getSize))));
        System.out.println(myDresses.stream().collect(Collectors.partitioningBy(t -> t.getSize() > 32)));
    }
}
