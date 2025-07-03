import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("RedundantCast")
public final class InnerClassInstanceFieldTest {

    static class Outer {
        String x = "Outer.x";
        String y = "Outer.y";

        class Inner {
            String x = "Inner.x";
            String z = "Inner.z";

            void testX() {
                // reference Inner.x through Inner instance
                String x1 = x;
                String x2 = this.x;
                String x3 = Inner.this.x;
                String x4 = Outer.Inner.this.x;
                String x5 = ((Inner)this).x;
                String x6 = ((Inner)Inner.this).x;
                String x7 = ((Inner)Outer.Inner.this).x;

                assertEquals("Inner.x", x1);
                assertEquals("Inner.x", x2);
                assertEquals("Inner.x", x3);
                assertEquals("Inner.x", x4);
                assertEquals("Inner.x", x5);
                assertEquals("Inner.x", x6);
                assertEquals("Inner.x", x7);

                // reference Outer.x through Outer instance
                String x8 = Outer.this.x;
                String x9 = ((Outer)Outer.this).x;

                assertEquals("Outer.x", x8);
                assertEquals("Outer.x", x9);
            }

            void testY() {
                // reference Outer.y lexically through Inner
                String y1 = y;

                assertEquals("Outer.y", y1);

                // reference Outer.y through Outer instance
                String y2 = Outer.this.y;
                String y3 = ((Outer)Outer.this).y;

                assertEquals("Outer.y", y2);
                assertEquals("Outer.y", y3);
            }

            void testZ() {
                // reference Inner.z through Inner instance
                String z1 = z;
                String z2 = this.z;
                String z3 = Inner.this.z;
                String z4 = Outer.Inner.this.z;
                String z5 = ((Inner)this).z;
                String z6 = ((Inner)Inner.this).z;
                String z7 = ((Inner)Outer.Inner.this).z;

                assertEquals("Inner.z", z1);
                assertEquals("Inner.z", z2);
                assertEquals("Inner.z", z3);
                assertEquals("Inner.z", z4);
                assertEquals("Inner.z", z5);
                assertEquals("Inner.z", z6);
                assertEquals("Inner.z", z7);
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