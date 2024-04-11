package lab1;

import java.lang.Math;

public class exercise2 {
    public static void main(String[] args) {

        double T;
        double y;

        for (float a = 1; a <= 10; a++) { 
            T = 2 * Math.PI / a;

            for (float x = 0; x <= T; x++) {
                y = 1 / (1.1 + Math.pow(Math.cos(a * x), 2));
                System.out.println("1/1.1 * cos("+a+"*"+x+")^2 = " + y);
            }
        }
    }
}
