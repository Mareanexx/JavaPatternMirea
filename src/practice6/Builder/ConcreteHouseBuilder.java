package practice6.Builder;

public class ConcreteHouseBuilder implements HouseBuilder {
    private House concreteHouse;

    public ConcreteHouseBuilder() {
        this.concreteHouse = new House(0, "Нет описания", 0);
    }


    @Override
    public HouseBuilder setNumofRooms(int numofRooms) {
        this.concreteHouse = new House(numofRooms, concreteHouse.getDesignDescription(), concreteHouse.getArea());
        return this;
    }

    @Override
    public HouseBuilder setDesignDescription(String designDescription) {
        this.concreteHouse = new House(concreteHouse.getNumOfRooms(), designDescription, concreteHouse.getArea());
        return this;
    }

    @Override
    public HouseBuilder setArea(int area) {
        this.concreteHouse = new House(concreteHouse.getNumOfRooms(), concreteHouse.getDesignDescription(), area);
        return this;
    }

    @Override
    public House build() {
        return this.concreteHouse;
    }
}
