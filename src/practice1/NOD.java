package practice1;
import java.util.ArrayList;
import java.util.function.Function;

//ИНДИВИДУАЛЬНЫЙ ВАРИАНТ №4
//4) Имплементировать интерфейс Function, получающий на вход пару
//чисел и возвращающий наибольший общий делитель.


public class NOD implements Function<ArrayList<Integer>, Integer> {
    public static int NODfinder(int number1, int number2) {
        int MIN = Math.min(number1, number2);
        for (int i = MIN; i > 0; i--) {
            if (number1 % i == 0 && number2 % i == 0)
                return i;
        }
        return 1;
    }

    @Override
    public Integer apply(ArrayList<Integer> numbers) {
        int number1 = numbers.get(0);
        int number2 = numbers.get(1);
        return NODfinder(number1, number2);
    }
}
