import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"AccessStaticViaInstance", "RedundantCast"})
public final class LocalStaticFieldTest {

    static class A {
        static String x = "A.x";

        void testX() {
            // reference A.x statically through A
            String x1 = x;
            String x2 = A.x;

            assertEquals("A.x", x1);
            assertEquals("A.x", x2);

            // reference A.x through A instance (not recommended, but valid in Java)
            String x3 = this.x;
            String x4 = A.this.x;
            String x5 = ((A)this).x;
            String x6 = ((A)A.this).x;

            assertEquals("A.x", x3);
            assertEquals("A.x", x4);
            assertEquals("A.x", x5);
            assertEquals("A.x", x6);
        }
    }

    @Test
    void test() {
        final A instance = new A();
        instance.testX();
    }
}