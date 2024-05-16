package practice3;

public class TestSet {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedSet<Integer> MySet = new SynchronizedSet<>();

        Thread thread1 = new Thread(() -> {
            MySet.add(1);
            MySet.add(2);
            MySet.add(3);
        });

        Thread thread2 = new Thread(() -> {
            MySet.add(4);
            MySet.add(5);
            MySet.add(6);
        });

        thread1.start();
        thread2.start();

        Thread.sleep(100);

        System.out.println("Количество элементов в Myset: " + MySet.size());
        System.out.println("Элементы из сета");
        Object[] array = MySet.toArray();
        for (Object elem : array) {
            System.out.print(elem + " ");
        }
    }
}
