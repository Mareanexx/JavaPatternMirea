package practice4;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//ЗАДАНИЕ --
//Реализовать собственную имплементацию ExecutorService с
//единственным параметром конструктора – количеством потоков.


public class TestMyExecutorService {
    public static void main(String[] args) {
        try (MyExecutorService myExecutorService = new MyExecutorService(3)) {
            //Задача 1
            Future<Integer> task1 = myExecutorService.submit(() -> {
                Thread.sleep(1000);
                int a = 20;
                int b = 10;
                System.out.println("Выполнено: Task 1");
                return a + b;
            });

            //Задача 2
            Future<String> task2 = myExecutorService.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Выполнено: Task 2");
            }, "Runnable task result");

            //Задача 3 -- список задач
            List<Callable<Double>> listTasks = Arrays.asList(
                    () -> {
                        double a = 5.0;
                        double b = 2.5;
                        return a / b;
                    },
                    () -> {
                        Thread.sleep(1000);
                        System.out.println("Выполнено: Task 3");
                        return 10.0 / 1.5;
                    }
            );

            List<Future<Double>> task3 = myExecutorService.invokeAll(listTasks);

            System.out.println("Результат задач №3 (");
            for (Future<Double> task : task3) {
                System.out.println(task.get());
            }
            System.out.println(")");

            // Ожидаем завершения задачи 1 и выводим результат
            System.out.println("Результат задачи №1 (считает 10 + 20) : " + task1.get());

            // Ожидаем завершения задачи 2 и выводим результат
            System.out.println("Результат задачи №2 (вывод текста) : " + task2.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTimestamp() {
        return new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
    }
}
