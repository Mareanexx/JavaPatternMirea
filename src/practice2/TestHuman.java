package practice2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

//1) класс Human (int age, String firstName, String lastName, LocalDate birthDate, int weight);
//2) приложение, которое создает список из объектов класса Human, а
//затем производит действия в соответствии с вариантом индивидуального
//задания (список после каждого этапа должен выводиться в консоль).

//ИНДИВИДУАЛЬНЫЙ ВАРИАНТ №4
//4) Сортировка по второй букве имени, фильтрация по весу кратно 10,
//сортировка по произведению веса на возраст, произведение всех весов.


public class TestHuman {
    public static ArrayList<Human> makeHumanList() {
        ArrayList<Human> humanList = new ArrayList<>();
        Human human1 = new Human(20, "Alice",
                "Tarasova", "2002-01-01", 65);
        Human human2 = new Human(10, "Tom", "Taylor",
                "2014-10-10", 35);
        Human human3 = new Human(30, "Ridge", "Polson",
                "1984-09-09", 100);
        humanList.add(human1);
        humanList.add(human2);
        humanList.add(human3);
        return humanList;
    }

    public static void main(String[] args) {
        ArrayList <Human> humanList = makeHumanList();

        System.out.println("1. -- Сортировка по второй букве имени: ");
        Stream <Human> sortedByName = humanList.stream();
        sortedByName.sorted(Comparator.comparing(human -> human.getFirstName().charAt(1)))
                .forEach(human -> System.out.println(human.toString() ));

        System.out.println("2. -- Фильтрация по весу: ");
        Stream <Human> filteredByWeight = humanList.stream();
        filteredByWeight.filter(human -> human.getWeight() % 10 == 0)
                .forEach(human -> System.out.println(human.toString() ));

        System.out.println("3. -- Сортировка по произведению веса на возраст: ");
        Stream <Human> sortedByMultWeightAndAge = humanList.stream();
        sortedByMultWeightAndAge.sorted(Comparator.comparing(human -> human.getWeight() * human.getAge()))
                .forEach(human -> System.out.println(human.toString() ));

        int productOfWeights = humanList.stream()
                .mapToInt(human -> human.getWeight())
                .reduce(1, (a, b) -> a * b); //ЧТО ТАКОЕ 1
        System.out.println("4. -- Произведение всех весов: " + productOfWeights);

    }
}
