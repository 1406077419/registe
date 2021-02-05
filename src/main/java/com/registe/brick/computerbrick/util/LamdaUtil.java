package com.registe.brick.computerbrick.util;

public class LamdaUtil {

    public static void main(String[] args) {

        test((s) -> {
            s += s + "  -- 修改参数";
            System.out.println("简化后 " + s);
        });

        test2((x, y) -> x - y);

        test3(() -> System.out.println("只传代码"));

        //new Thread(() -> System.out.println("woshi1xianh")).start();

        System.out.println("-------------------------------------");
        // 不用括号
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = message -> System.out.println("Hello " + message);

        GreetingService greetingService3 = message -> System.out.println(message + "      这是调用后的打印值");
        greetingService3.sayMessage("111");

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");



        MathOperation mathOperationAdd = ((a, b) -> a * b);
        MathOperation mathOperationSubtract = ((a, b) -> a - b);


        int add = operate(2,9,mathOperationAdd);
        int substract = operate(4,6,mathOperationSubtract);
        System.out.println(add);
        System.out.println(substract);
    }

    interface MyInterface {
        void lMethod(String s);
    }

    interface MyInterface2 {
        int lMethod(int a, int b);
    }

    interface MyInterface3 {
        void lMethod();
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    public static void test(MyInterface myInterface) {
        myInterface.lMethod("hellow word!");
    }

    public static void test2(MyInterface2 myInterface2) {
        int res = myInterface2.lMethod(2, 3);
        System.out.println(res);
    }

    public static void test3(MyInterface3 myInterface) {
        myInterface.lMethod();
    }
}
