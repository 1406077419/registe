package com.registe.brick.computerbrick.util;

import com.registe.brick.computerbrick.controller.ComputController;
import com.registe.brick.computerbrick.entity.Computer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamUtil {

    public static void main(String[] args) {

        List<Computer> compList = ComputController.getList();

        // 按字段排序
        //compList.sort(comparing(Computer::getMemory));

        // 过滤 范围
        //List<Computer> filterList = compList.stream().filter(c -> c.getMemory() >= 256).collect(Collectors.toList());

        // 获取字段集合
        List<String> charList = compList.stream().map(Computer::getName).collect(Collectors.toList());

        // 字段长度
        List<Integer> lengList = compList.stream().map(Computer::getName).map(String::length).collect(Collectors.toList());

        // 字段进行数值操作
        List<Integer> cacuList = compList.stream().map(Computer::getMemory).map(c -> {
            return c / 2;
        }).collect(Collectors.toList());

        // 任意匹配返回true
        boolean anyMatch = compList.stream().anyMatch(c -> c.getMemory() > 10);

        // 全部匹配返回true
        boolean allMatch = compList.stream().allMatch(c -> c.getMemory() > 10);

        // 全部不匹配返回true
        boolean noneMatch = compList.stream().noneMatch(c -> c.getMemory() > 10);

        // 字段求和
        int sum = compList.stream().mapToInt(Computer::getMemory).sum();

        // 字段求平均值
        OptionalDouble aa = compList.stream().mapToInt(Computer::getMemory).average();

        //汇总统计
        IntSummaryStatistics intSummary = compList.stream().mapToInt(Computer::getMemory).summaryStatistics();

        // 求和
        //System.out.println(intSummary.getSum());

        // 最大值
        //System.out.println(intSummary.getMax());

        //最小值
        //System.out.println(intSummary.getMin());

        // 平均值
        //System.out.println(intSummary.getAverage());

        // 总个数
        //System.out.println(intSummary.getCount());

        // 字段去重
        //List<Integer> dinstinct = compList.stream().map(Computer::getMemory).distinct().collect(Collectors.toList());

        // 按字段归并实体集合
        Map<Integer, List<Computer>> map1 = compList.stream().collect(Collectors.groupingBy(Computer::getMemory));

        // 按字段归并实体,不能有重复字段
        //Map<Integer, Computer> map2 = compList.stream().collect(Collectors.toMap(Computer::getMemory,Computer-> Computer));


        // 获取字段
        compList.stream().flatMapToInt(c -> IntStream.of(c.getName().length())).forEach(System.out::println);

        Map<String,Integer> tMap = new HashMap<>();
        tMap.put("a",2);
        tMap.put("b",3);
        tMap.put("c",2);
        tMap.put("d",4);
        tMap.put("e",5);

        map1.forEach((k,v) ->{
            System.out.println(k+"    "+v);
        });

    }


}
