package practice5;

//ЗАДАНИЕ --
//Реализовать паттерн Singleton 3-мя способами


public class TestSingletons {
    public static void main(String[] args) {
        //Тестирование первого способа -- публик метод getInstance()
        Singleton1 singleton1_1 = Singleton1.getInstance();
        Singleton1 singleton1_2 = Singleton1.getInstance();

        System.out.println("Объекты класса Singleton1 один и тот же? : " + singleton1_1.equals(singleton1_2));

        //Тестирование второго способа -- использование перечисления (тк там константы)
        Singleton2 singleton2_1 = Singleton2.INSTANCE;
        Singleton2 singleton2_2 = Singleton2.INSTANCE;

        System.out.println("Объекты класса Singleton2 один и тот же? : " + singleton2_1.equals(singleton2_2));

        //Тестирование третьего способа --
        Singleton3 singleton3_1 = Singleton3.getInstance();
        Singleton3 singleton3_2 = Singleton3.getInstance();

        System.out.println("Объекты класса Singleton3 один и тот же? : " + singleton3_1.equals(singleton3_2));

    }
}
