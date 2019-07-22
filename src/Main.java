import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        KlasaZPolamiDoWstrzykniecia mojaKlasa = new KlasaZPolamiDoWstrzykniecia();
        // Przed wstrzyknieciem
        System.out.println(mojaKlasa);
        // Wstrzykniecie
        wstrzyknij(mojaKlasa, "");
        // Po wstrzyknięciu

    }

    static void wstrzyknij(Object target, String name) {
        // TODO pobierz pola obiektu i przeiteruj po nich
        for (Field field: target.getClass().getDeclaredFields()) {
            System.out.println(field);
        }
    }

    // TODO 1 własna adnotacja
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface WstrzyknijJesliMnieZnajdziesz {
    }

    // TODO 2 klasa do wstrzykniecia
    class Colaborator {
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
