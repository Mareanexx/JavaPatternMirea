    package practice8.Mediator;

    public class Door extends DeviceInHome {
        public Door(Mediator mediator) {
            super(mediator);
        }

        @Override
        void receiveMessage(String message) {
            if (message.contains("Обнаружено движение")) {
                System.out.println("Сообщение получено! Закрываю дверь.");
                this.CloseDoor();
            }
        }

        void CloseDoor() {
            System.out.println("Дверь закрыта.");
        }
    }
