import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("RedundantCast")
public final class SuperClassInstanceFieldTest {

    static class SuperClass {
        String x = "SuperClass.x";
        String y = "SuperClass.y";
    }

    static class SubClass extends SuperClass {
        String x = "SubClass.x";
        String z = "SubClass.z";

        void testX() {
            // reference SubClass.x through SubClass instance
            String x1 = x;
            String x2 = this.x;
            String x3 = ((SubClass)this).x;
            String x4 = ((SubClass)SubClass.this).x;

            assertEquals("SubClass.x", x1);
            assertEquals("SubClass.x", x2);
            assertEquals("SubClass.x", x3);
            assertEquals("SubClass.x", x4);

            // reference SuperClass.x through SuperClass instance
            String x5 = super.x;
            String x6 = ((SuperClass)this).x;
            String x7 = ((SuperClass)SubClass.this).x;

            assertEquals("SuperClass.x", x5);
            assertEquals("SuperClass.x", x6);
            assertEquals("SuperClass.x", x7);
        }

        void testY() {
            // reference SuperClass.y through SubClass instance
            String y1 = y;
            String y2 = this.y;
            String y3 = ((SubClass)this).y;
            String y4 = ((SubClass)SubClass.this).y;

            assertEquals("SuperClass.y", y1);
            assertEquals("SuperClass.y", y2);
            assertEquals("SuperClass.y", y3);
            assertEquals("SuperClass.y", y4);

            // reference SuperClass.y through SuperClass instance
            String y5 = super.y;
            String y6 = ((SuperClass)this).y;
            String y7 = ((SuperClass)SubClass.this).y;

            assertEquals("SuperClass.y", y5);
            assertEquals("SuperClass.y", y6);
            assertEquals("SuperClass.y", y7);
        }

        void testZ() {
            // reference SubClass.z through SubClass instance
            String z1 = z;
            String z2 = this.z;
            String z3 = ((SubClass)this).z;
            String z4 = ((SubClass)SubClass.this).z;

            assertEquals("SubClass.z", z1);
            assertEquals("SubClass.z", z2);
            assertEquals("SubClass.z", z3);
            assertEquals("SubClass.z", z4);
        }
    }

    @Test
    void test() {
        final SubClass instance = new SubClass();
        instance.testX();
        instance.testY();
        instance.testZ();
    }
}