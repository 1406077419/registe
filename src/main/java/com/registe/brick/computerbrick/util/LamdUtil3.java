package com.registe.brick.computerbrick.util;

import com.registe.brick.computerbrick.entity.Computer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LamdUtil3 {

    public static void main(String[] args) {

        LamdUtil3 lamdUtil3 = new LamdUtil3();
        System.out.println(lamdUtil3.FunOne(3));

        FunTwo addTwo = (a -> {
            return a + a;
        });
        System.out.println(addTwo.method(4));

        InterThree interThree = lamdUtil3::FunThree;
        System.out.println(interThree.method(5));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(2,7);
        map.forEach((x, y) -> {
            y = y * y;
        });
        System.out.println(map.get(2));

    }

    public int FunThree(int a) {
        return a + a;
    }

    public interface InterThree {
        int method(int a);
    }

    public interface FunTwo {
        int method(int a);
    }

    public int FunOne(int a) {
        return a + a;
    }
}
