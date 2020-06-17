package br.com.codenation.desafioexe;



import java.util.ArrayList;
import java.util.List;


public class DesafioApplication {


    public static List<Integer> fibonacci() {
        List<Integer> fibonacciList = new ArrayList<>();
        for (int a = 0, b = 1, i = 0; i < 15; b += a, a = b - a, i++) {
            fibonacciList.add(a);
        }

        return fibonacciList;

    }

    public static Boolean isFibonacci(Integer a) {

        return fibonacci().contains(a);

    }
}