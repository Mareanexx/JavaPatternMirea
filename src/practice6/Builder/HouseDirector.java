package practice6.Builder;

public class HouseDirector {
    public House constructLuxuryHouse() {
        return new ConcreteHouseBuilder()
                .setNumofRooms(5)
                .setDesignDescription("Шикарные комнаты")
                .setArea(350)
                .build();
    }

    public House constructSmallHouse() {
        return new ConcreteHouseBuilder()
                .setNumofRooms(1)
                .setDesignDescription("Маленький дом, маленькие комнаты")
                .setArea(25)
                .build();
    }
    public House constructMediumHouse() {
        return new ConcreteHouseBuilder()
                .setNumofRooms(2)
                .setDesignDescription("Средний дом, комнаты обычные")
                .setArea(60)
                .build();
    }
}
