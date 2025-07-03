import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"AccessStaticViaInstance", "RedundantCast"})
public final class InnerClassStaticFieldTest {

    static class Outer {
        static String x = "Outer.x";
        static String y = "Outer.y";

        class Inner {
            static String x = "Inner.x";
            static String z = "Inner.z";

            void testX() {
                // reference Inner.x statically through Inner
                String x1 = x;
                String x2 = Inner.x;
                String x3 = Outer.Inner.x;
                
                assertEquals("Inner.x", x1);
                assertEquals("Inner.x", x2);
                assertEquals("Inner.x", x3);

                // reference Inner.x through Inner instance (not recommended, but valid in Java)
                String x4 = this.x;
                String x5 = Inner.this.x;
                String x6 = Outer.Inner.this.x;
                String x7 = ((Inner)this).x;
                String x8 = ((Inner)Inner.this).x;
                String x9 = ((Inner)Outer.Inner.this).x;
                
                assertEquals("Inner.x", x4);
                assertEquals("Inner.x", x5);
                assertEquals("Inner.x", x6);
                assertEquals("Inner.x", x7);
                assertEquals("Inner.x", x8);
                assertEquals("Inner.x", x9);

                // reference Outer.x statically through Outer
                String x10 = Outer.x;
                
                assertEquals("Outer.x", x10);

                // reference Outer.x through Outer instance (not recommended, but valid in Java)
                String x11 = Outer.this.x;
                String x12 = ((Outer)Outer.this).x;
                
                assertEquals("Outer.x", x11);
                assertEquals("Outer.x", x12);
            }

            void testY() {
                // reference Outer.y lexically through Inner
                String y1 = y;
                
                assertEquals("Outer.y", y1);

                // reference Outer.y statically through Outer
                String y10 = Outer.y;
                
                assertEquals("Outer.y", y10);

                // reference Outer.y through Outer instance (not recommended, but valid in Java)
                String y11 = Outer.this.y;
                String y12 = ((Outer)Outer.this).y;
                
                assertEquals("Outer.y", y11);
                assertEquals("Outer.y", y12);
            }

            void testZ() {
                // reference Inner.z statically through Inner
                String z1 = z;
                String z2 = Inner.z;
                String z3 = Outer.Inner.z;
                
                assertEquals("Inner.z", z1);
                assertEquals("Inner.z", z2);
                assertEquals("Inner.z", z3);

                // reference Inner.z through Inner instance (not recommended, but valid in Java)
                String z4 = this.z;
                String z5 = Inner.this.z;
                String z6 = Outer.Inner.this.z;
                String z7 = ((Inner)this).z;
                String z8 = ((Inner)Inner.this).z;
                String z9 = ((Inner)Outer.Inner.this).z;
                
                assertEquals("Inner.z", z4);
                assertEquals("Inner.z", z5);
                assertEquals("Inner.z", z6);
                assertEquals("Inner.z", z7);
                assertEquals("Inner.z", z8);
                assertEquals("Inner.z", z9);
            }
        }
    }

    @Test
    void test() {
        final Outer.Inner instance = new Outer().new Inner();
        instance.testX();
        instance.testY();
        instance.testZ();
    }
}