package practice8.Memento;

public class Main {
    public static void main(String[] args) {
        Document document = new Document("Данные для инициализации\n");
        History history = new History();
        document.write("Логин: mareanexx\n");
        history.addMemento(document.createMemento()); //добавить в список моментов

        // Записать какую то информацию в документ
        document.write("ФИО: Марианна Пермиловская Евгеньевна\n");
        history.addMemento(document.createMemento()); //добавить в список моментов

        // Записываю еще информацию
        document.write("Пол: женский\n");
        history.addMemento(document.createMemento());

        //Возвращаюсь к предыдущему состоянию -- где еще не было Надписи про пол
        document.restoreFromMemento(history.getMemento(1));

        System.out.println(document.getContent());
    }
}
