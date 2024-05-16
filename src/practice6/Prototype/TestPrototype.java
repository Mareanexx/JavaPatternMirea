package practice6.Prototype;

public class TestPrototype {
    public static void main(String[] args) {
        Human human1 = new Human("Марина", "Маринова");
        Human human2 = human1.clone(); //клонирование объекта, а не присваивание по ссылке

        System.out.println("Объекты human1 и human2 - один и тот же объект??? : Ответ: " + (human1 == human2 ? "ДА, они одинаковые" : "НЕТ, это разные объекты"));
        System.out.println("Поля human1 -- " + human1.toString());
        System.out.println("Поля human2 -- " + human2.toString());
        human2.setFirstname("МОДИФИКАТОР");
        System.out.println("(после изменения) Поля human1 -- " + human1.toString());
        System.out.println("(после изменения) Поля human2 -- " + human2.toString());

        Human human3 = new Human("Зарина", "Заринова");
        Human human4 = human3;

        System.out.println("Объекты human3 и human4 - один и тот же объект??? : Ответ: " + (human3 == human4 ? "ДА, они одинаковые" : "НЕТ, это разные объекты"));
    }
}
