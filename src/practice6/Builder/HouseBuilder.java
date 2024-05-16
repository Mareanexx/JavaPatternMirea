package practice6.Builder;

public interface HouseBuilder {
    HouseBuilder setNumofRooms(int numofRooms);
    HouseBuilder setDesignDescription(String designDescription);
    HouseBuilder setArea(int area);
    House build();
}
