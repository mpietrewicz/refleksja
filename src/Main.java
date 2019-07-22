import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        KlasaZPolamiDoWstrzykniecia mojaKlasa = new KlasaZPolamiDoWstrzykniecia();
        // Przed wstrzyknieciem
        System.out.println("Moja klasa: " +mojaKlasa);
        // Wstrzykniecie
        wstrzyknij(mojaKlasa, "test");
        // Po wstrzyknięciu
        System.out.println("Moja klasa: " +mojaKlasa);

    }

    static void wstrzyknij(Object target, String name) throws IllegalAccessException {
        // TODO pobierz pola obiektu i przeiteruj po nich
        for (Field field: target.getClass().getDeclaredFields()) {
            System.out.println("Pole: " +field);
            // TODO pobierz adnotacje pola i przeiteruj po nich
            for (Annotation annotation: field.getDeclaredAnnotations()) {
                System.out.println("Adnotacja pola: " +annotation);
                // TODO jeśli znaleziono pole z adnotacją utwórz instancje Colaboratora i przypisz do pola
                if (annotation instanceof WstrzyknijJesliMnieZnajdziesz) {
                    field.setAccessible(true);
                    field.set(target, new Colaborator(name));
                    field.setAccessible(false);
                }
            }
        }
    }

    // TODO 1 własna adnotacja
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface WstrzyknijJesliMnieZnajdziesz {
    }

    // TODO 2 klasa do wstrzykniecia
    static class Colaborator {
        private String name;

        public Colaborator(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Colaborator{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    // TODO  klasa z polem do wstrzykniecia
    static class  KlasaZPolamiDoWstrzykniecia {
        @WstrzyknijJesliMnieZnajdziesz
        private Colaborator colaborator1;
        private Colaborator colaborator2;

        @Override
        public String toString() {
            return "KlasaZPolamiDoWstrzykniecia{" +
                    "colaborator1=" + colaborator1 +
                    ", colaborator2=" + colaborator2 +
                    '}';
        }
    }
}
