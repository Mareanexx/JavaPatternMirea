package practice5;

public enum Singleton2 {
    INSTANCE; //элемент перечисления константа

    public Singleton2 getInstance() {
        return INSTANCE;
    }
}
