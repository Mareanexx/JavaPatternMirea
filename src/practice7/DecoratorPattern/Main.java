package practice7.DecoratorPattern;

public class Main {
    public static void main(String[] args) {
        Automobile first_auto = new NewAutomobile(); //Создаю две машины, два объекта
        Automobile second_auto = new NewAutomobile();


        first_auto = new SportPacket(first_auto); //К комплектации первой машины добавляю спорт пакет
                                                                      //    и кожаный салон
        first_auto = new LeatherInterior(first_auto);

        System.out.println(first_auto.addComponents() + " \nСтоимость данного авто будет: " + first_auto.getCost());

        second_auto = new PanoramicRoof(second_auto); //К комплектации второй машины добавляю панорамную крышу
                                                                   //    и кожаный салон
        second_auto = new LeatherInterior(second_auto);

        System.out.println(second_auto.addComponents() + " \nСтоимость данного авто будет: " + second_auto.getCost());
    }
}
