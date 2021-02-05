package com.registe.brick.computerbrick.util;

public class LamdaUtil2 {

    public static void main(String[] args) {

        // 1、运算条件在方法里定义好直接传参
        // 2、运算条件通过Lamda传进去，调用方法时直接传参
        // 3、运算条件在方法中定义，通过相同类型参数接口接口再调用


        LamdaUtil2 lamda2 = new LamdaUtil2();
        ReturnOneParam returnOneParam = ((a, b) -> {
            return a * a + (b * b);
        });
        //System.out.println(returnOneParam.method(2, 3));

        //ReturnOneParam returnOneParam1 = lamda2::addOne;
        ReturnOneParam return2 = LamdaUtil2::doubleNum;

        System.out.println(return2.method(3, 6));

        ReturnAddTwo returnAddTwo = ((a, b) -> {
            return a * b;
        });
        System.out.println(returnAddTwo.method(5, 8));

        LamdaUtil2 lamda3 = new LamdaUtil2();
        ReturnThree returnThree = lamda3::addThree;
        System.out.println(returnThree.method(9,4));
    }

    public interface ReturnThree {
        int method(int a, int b);
    }

    public int addThree(int a, int b) {
        return a - b;
    }

    public static int doubleNum(int a, int b) {
        return a * a + (b * b);
    }

    public int addOne(int a, int b) {
        return a * a + (b * b);
    }

    public interface ReturnOneParam {
        int method(int a, int b);
    }

    public interface ReturnAddTwo {
        int method(int a, int b);
    }
}

