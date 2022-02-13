package org.example.HomeWork4;

import static java.lang.Math.sqrt;

public class Main {

    private int a;
    private int b;
    private int c;

    public static void main(String[] args) {

        System.out.println(triangleValues(3, 4, 5));

    }

    public static int triangleValues(int a, int b, int c) {

        if ((a <= 0) || (b <= 0) || (c <= 0)) {
            throw new ArithmeticException("Стороны не могут быть иметь отрицательное значение и ровняться 0");
        }
        if ((a + b) <= c || (b + c) <= a || (a + c) <= b) {
            throw new ArithmeticException("Не корректное значение треугольника");
        }
        int p = (a + b + c) / 2;
        return (int) sqrt(p*(p - a)*(p - b)*(p - c));
    }
}
