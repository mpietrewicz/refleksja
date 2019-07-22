import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Main {

    public static void main(String[] args) {

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
    class  KlasaZPolamiDoWstrzykniecia {
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
