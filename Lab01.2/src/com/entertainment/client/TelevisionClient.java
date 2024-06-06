package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TelevisionClient {

    public static void main(String[] args) {

        //  examine == and the equals() method
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());

        //  use == to show if tvA and tvB refer to same physical object
        System.out.println("tvA == tvB: " + (tvA == tvB));  //  false (of course)

        //  use equals() to show if tvA and tvB are "equal"
        System.out.println("tvA.equals(tvB): " + tvA.equals(tvB));
        System.out.println();

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);
        System.out.println("The size of the Set is: " + tvs.size());    //  should be 1

        for (Television tv : tvs) {
            System.out.println(tv);
        }
        System.out.println();
    }
}