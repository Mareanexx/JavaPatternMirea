package practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int num1 = scan.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = scan.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(num1, num2));
        NOD nod = new NOD();

        System.out.println("Наибольший общий делитель '" + num1 + "' и '" + num2 + "' -- " + nod.apply(numbers));
    }
}
