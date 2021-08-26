package com.alfa.work4;

public class MyTestClass {
    private int testClass;
    private MyInner myInner;

    public MyTestClass() {
        testClass = 1;
    }

    public void test() {
        System.out.println("MyStaticNested from MyTestClass " + MyStaticNested.staticNested);
        myInner = new MyInner();
        System.out.println("MyInner from MyTestClass " + myInner.inner);
        MyStaticNested.test(this);
        myInner.test();
        myLocal();
    }

    static class MyStaticNested {
        private static int staticNested;

        {
            staticNested = 2;
        }

        public static void test(MyTestClass myTestClass) {
            System.out.println("MyTestClass from MyStaticNested " + myTestClass.testClass);
            System.out.println("MyInner from MyStaticNested " + myTestClass.myInner.inner);
        }
    }

    class MyInner {
        private int inner;

        {
            inner = 3;
        }

        public void test() {
            System.out.println("MyStaticNested from MyInner " + MyStaticNested.staticNested);
            System.out.println("MyTestClass from MyInner " + testClass);
        }

    }

    public void myLocal() {

        class MyLocal {
            private int local1;

            {
                local1 = 4;
            }

            public void test() {
                System.out.println("MyStaticNested from MyLocal " + MyStaticNested.staticNested);
                System.out.println("MyTestClass from MyLocal " + testClass);
                System.out.println("MyInner from MyLocal " + myInner.inner);
            }
        }
        MyLocal local = new MyLocal();
        local.test();
        System.out.println("MyLocal from myLocal " + local.local1);
    }

}


