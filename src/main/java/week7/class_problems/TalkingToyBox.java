package week7.class_problems;

public class TalkingToyBox {
    static abstract class Toy {
        private static int nextToyNumber = 1001;
        protected final String name;
        private final String toyId;

        public Toy(String name) {
            this.name = name;
            this.toyId = "TOY-" + nextToyNumber++;
        }

        public abstract String makeSound();

        public String getToyId() {
            return toyId;
        }
    }

    static class ToyCar extends Toy {
        public ToyCar(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return name + ": Vroom vroom!";
        }
    }

    static class ToyRobot extends Toy {
        public ToyRobot(String name) {
            super(name);
        }

        @Override
        public String makeSound() {
            return name + ": Beep boop!";
        }
    }

    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());
        System.out.println(c.getToyId());
        System.out.println(r.getToyId());

        // Toy t = new Toy("Generic"); // Does not compile because Toy is abstract.
    }
}
