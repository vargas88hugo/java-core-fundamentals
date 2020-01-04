package com.unionintersection01;

import java.util.*;

/**
 * This program is a practice about sets, union, intersection,
 * symmetric and asymmetric.
 * @author Hugo Vargas
 * @version 1.0 2020-01-02
 */
public class Main {

	public static void main(String[] args)  {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 30; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        // The union store all the different elements of both sets
        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + "  elements."); // Union contains 196  elements

        // The intersecion store all the equal elements of both sets
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements."); // Intersection contains 4 elements.
        // print the repeated elements
        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        // asList is used to cast the array to list collection
        words.addAll(Arrays.asList(arrayWords));

        for (String s : words) {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        System.out.println("Nature: ");
        printSet(nature); // all but art thee nature is to unknown

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));
        System.out.println("Divine: ");
        printSet(divine); // err forgive is to divine human 

        // asymmetric difference
        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1); // all but art thee nature unknown 

        // asymmetric difference
        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature); // err forgive divine human
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        System.out.println("Union: ");
        printSet(unionTest); // all but art thee err nature forgive is to divine human unknown
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        System.out.println("Intersection: ");
        printSet(intersectionTest); // is to

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest); // all but art thee err nature forgive divine human unknown 

        if(nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if(nature.containsAll(intersectionTest)) {
            System.out.println("intersection is  subset of nature"); // intersection is  subset of nature
        }

        if(divine.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of divine"); // intersection is a subset of divine
        }

    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for(String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
