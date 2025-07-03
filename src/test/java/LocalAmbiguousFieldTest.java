import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class LocalAmbiguousFieldTest {

    static class a {
        String x = "A.x";
        C a = new C();

        void testX() {
            // reference a.x
            String x1 = x;
            String x2 = this.x;
            String x3 = a.this.x;

            assertEquals("A.x", x1);
            assertEquals("A.x", x2);
            assertEquals("A.x", x3);

            // reference C.x
            String x4 = a.x;

            assertEquals("C.x", x4);
        }
    }

    static class C {
        String x = "C.x";
    }

    @Test
    void test() {
        final a instance = new a();
        instance.testX();
    }
}