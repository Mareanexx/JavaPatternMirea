package practice6.Factory;

import java.util.Scanner;

//Фабрика. Определяет интерфейс для создания объекта, но позволяет подклассам решать,
// какой класс инстанцинировать. Позволяет делегировать создание объекта подклассам.
//У меня вот фабрика пиццы, где есть класс фабрика и подклассы меняют тип объекта то есть это может быть там пицца пепперони там

public class TestPizzas {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactory();
        System.out.println("Какую пиццу желаете заказать?");
        System.out.println("1. Пепперони");
        System.out.println("2. Мясная пицца");
        System.out.println("3. Четыре сыра");
        System.out.print("Выберите одну пиццу и напишите ее номер: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Pizza myPizza = pizzaFactory.createPizza(choice);
        myPizza.makePizza();
        myPizza.wrapPizza();
        myPizza.deliverPizza();
    }
}
