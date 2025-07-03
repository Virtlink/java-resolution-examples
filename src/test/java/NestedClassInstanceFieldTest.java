import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("RedundantCast")
public final class NestedClassInstanceFieldTest {

    static class Outer {
        String x = "Outer.x";
        String y = "Outer.y";

        static class Nested {
            String x = "Nested.x";
            String z = "Nested.z";

            void testX() {
                // reference Nested.x through Nested instance
                String x1 = x;
                String x2 = this.x;
                String x3 = Nested.this.x;
                String x4 = Outer.Nested.this.x;
                String x5 = ((Nested)this).x;
                String x6 = ((Nested)Nested.this).x;
                String x7 = ((Nested)Outer.Nested.this).x;
                
                assertEquals("Nested.x", x1);
                assertEquals("Nested.x", x2);
                assertEquals("Nested.x", x3);
                assertEquals("Nested.x", x4);
                assertEquals("Nested.x", x5);
                assertEquals("Nested.x", x6);
                assertEquals("Nested.x", x7);
            }

            void testZ() {
                // reference Nested.z through Nested instance
                String z1 = z;
                String z2 = this.z;
                String z3 = Nested.this.z;
                String z4 = Outer.Nested.this.z;
                String z5 = ((Nested)this).z;
                String z6 = ((Nested)Nested.this).z;
                String z7 = ((Nested)Outer.Nested.this).z;
                
                assertEquals("Nested.z", z1);
                assertEquals("Nested.z", z2);
                assertEquals("Nested.z", z3);
                assertEquals("Nested.z", z4);
                assertEquals("Nested.z", z5);
                assertEquals("Nested.z", z6);
                assertEquals("Nested.z", z7);
            }
        }
    }

    @Test
    void test() {
        final Outer.Nested instance = new Outer.Nested();
        instance.testX();
        instance.testZ();
    }
}