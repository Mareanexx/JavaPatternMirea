package practice6.Builder;

public class House {
    private int numOfRooms;
    private String designDescription;
    private int area;

    public House(int numOfRooms, String designDescription, int area) {
        this.numOfRooms = numOfRooms;
        this.designDescription = designDescription;
        this.area = area;
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }

    public String getDesignDescription() {
        return designDescription;
    }

    public int getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "Был построен дом {" +
                "Количество комнат = " + numOfRooms +
                ", описание дома = '" + designDescription + '\'' +
                ", площадь дома = " + area +
                '}';
    }
}
