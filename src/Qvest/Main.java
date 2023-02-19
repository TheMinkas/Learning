package Qvest;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        someClass.meth1();
        someClass.meth2();
        someClass.meth3();
    }
    
}


abstract class Solution {
    public void meth1() {
        System.out.println("test");
    }

    abstract void meth2();
    abstract void meth3();
}

class SomeClass extends Solution{

    @Override
    void meth2() {
        System.out.println("meth2");
    }

    @Override
    void meth3() {
        System.out.println("meth3");
    }

    @Override
    public void meth1() {
        super.meth1();
    }
}