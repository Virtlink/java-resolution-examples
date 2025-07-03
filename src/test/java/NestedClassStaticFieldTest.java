import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"AccessStaticViaInstance", "RedundantCast"})
public final class NestedClassStaticFieldTest {

    static class Outer {
        static String x = "Outer.x";
        static String y = "Outer.y";

        static class Nested {
            static String x = "Nested.x";
            static String z = "Nested.z";

            void testX() {
                // reference Nested.x statically through Nested
                String x1 = x;
                String x2 = Nested.x;
                String x3 = Outer.Nested.x;
                
                assertEquals("Nested.x", x1);
                assertEquals("Nested.x", x2);
                assertEquals("Nested.x", x3);

                // reference Nested.x through Nested instance (not recommended, but valid in Java)
                String x4 = this.x;
                String x5 = Nested.this.x;
                String x6 = Outer.Nested.this.x;
                String x7 = ((Nested)this).x;
                String x8 = ((Nested)Nested.this).x;
                String x9 = ((Nested)Outer.Nested.this).x;
                
                assertEquals("Nested.x", x4);
                assertEquals("Nested.x", x5);
                assertEquals("Nested.x", x6);
                assertEquals("Nested.x", x7);
                assertEquals("Nested.x", x8);
                assertEquals("Nested.x", x9);

                // reference Outer.x statically through Outer
                String x10 = Outer.x;
                
                assertEquals("Outer.x", x10);
            }

            void testY() {
                // reference Outer.y lexically through Nested
                String y1 = y;
                
                assertEquals("Outer.y", y1);

                // reference Outer.y statically through Outer
                String y10 = Outer.y;
                
                assertEquals("Outer.y", y10);
            }

            void testZ() {
                // reference Nested.z statically through Nested
                String z1 = z;
                String z2 = Nested.z;
                String z3 = Outer.Nested.z;
                
                assertEquals("Nested.z", z1);
                assertEquals("Nested.z", z2);
                assertEquals("Nested.z", z3);

                // reference Nested.z through Nested instance (not recommended, but valid in Java)
                String z4 = this.z;
                String z5 = Nested.this.z;
                String z6 = Outer.Nested.this.z;
                String z7 = ((Nested)this).z;
                String z8 = ((Nested)Nested.this).z;
                String z9 = ((Nested)Outer.Nested.this).z;
                
                assertEquals("Nested.z", z4);
                assertEquals("Nested.z", z5);
                assertEquals("Nested.z", z6);
                assertEquals("Nested.z", z7);
                assertEquals("Nested.z", z8);
                assertEquals("Nested.z", z9);
            }
        }
    }

    @Test
    void test() {
        final Outer.Nested instance = new Outer.Nested();
        instance.testX();
        instance.testY();
        instance.testZ();
    }
}