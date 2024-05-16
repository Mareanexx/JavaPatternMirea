package practice6;


//Абстрактная фабрика предоставляет интерфейс для создания семейств
// взаимосвязанных или взаимозависимых объектов, не специфицируя их конкретных классов.


//– позволяет создавать семейства
//определенных объектов

interface FurnitureFactory {
    GlassTable createGlassTable();
    WoodenTable createWoodenTable();
}


interface Table {
    void produce();
}


class GlassTable implements Table {
    @Override
    public void produce() {
        System.out.println("Был создан стеклянный стол");
    }
}

class WoodenTable implements Table {
    @Override
    public void produce() {
        System.out.println("Был создан деревянный стол");
    }
}


class TableFactory implements FurnitureFactory {
    @Override
    public GlassTable createGlassTable() {
        return new GlassTable();
    }

    @Override
    public WoodenTable createWoodenTable() {
        return new WoodenTable();
    }
}


public class Client {
    public static void main(String[] args) {
        // Создаем абстрактную фабрику для столов
        FurnitureFactory factory = new TableFactory();

        // Создаем стеклянный стол с использованием абстрактной фабрики
        GlassTable glassTable = factory.createGlassTable();
        // Производим стеклянный стол
        glassTable.produce();

        // Создаем деревянный стол с использованием абстрактной фабрики
        WoodenTable woodenTable = factory.createWoodenTable();
        // Производим деревянный стол
        woodenTable.produce();
    }
}
