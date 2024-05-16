package practice6.Builder;

import java.util.Scanner;

public class TestBuilder {
    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();
        System.out.println("Выбери какой дом нужно построить: ");
        System.out.println("1. Маленький дом");
        System.out.println("2. Дом люкс-класса");
        System.out.println("3. Дом среднего класса");
        System.out.print("Введите свой выбор: ");
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        House mynewHouse = (choice == 1) ? director.constructSmallHouse() : (choice == 2) ?
                director.constructLuxuryHouse() : (choice == 3) ? director.constructMediumHouse() : null;

        System.out.println(mynewHouse.toString());
    }
}
