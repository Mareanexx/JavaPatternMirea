package practice5;

public class Singleton1 {
    private static Singleton1 object; //приватный статический объект

    private Singleton1() { //привватный конструктор, чтобы не вызвать его в других классах

    }
    public static Singleton1 getInstance() { //публичный статический метод для создания объекта (если объект уже создан, то он просто вернет поле)
        if (object == null)
            object = new Singleton1();
        return object;
    }
}
