import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

@SuppressWarnings("RedundantCast")
public final class LocalInstanceFieldTest {

    static class A {
        String x = "A.x";

        void testX() {
            // reference A.x through A instance
            String x1 = x;
            String x2 = this.x;
            String x3 = A.this.x;
            String x4 = ((A)this).x;
            String x5 = ((A)A.this).x;

            assertEquals("A.x", x1);
            assertEquals("A.x", x2);
            assertEquals("A.x", x3);
            assertEquals("A.x", x4);
            assertEquals("A.x", x5);
        }
    }

    @Test
    void test() {
        final A instance = new A();
        instance.testX();
    }
}