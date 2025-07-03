import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"AccessStaticViaInstance", "RedundantCast"})
public final class SuperClassStaticFieldTest {

    static class SuperClass {
        static String x = "SuperClass.x";
        static String y = "SuperClass.y";
    }

    static class SubClass extends SuperClass {
        static String x = "SubClass.x";
        static String z = "SubClass.z";

        void testX() {
            // reference SubClass.x statically through SubClass
            String x1 = x;
            String x2 = SubClass.x;

            assertEquals("SubClass.x", x1);
            assertEquals("SubClass.x", x2);

            // reference SubClass.x through SubClass instance (not recommended, but valid in Java)
            String x3 = this.x;
            String x4 = ((SubClass)this).x;
            String x5 = ((SubClass)SubClass.this).x;

            assertEquals("SubClass.x", x3);
            assertEquals("SubClass.x", x4);
            assertEquals("SubClass.x", x5);

            // reference SuperClass.x statically through SuperClass
            String x6 = SuperClass.x;

            assertEquals("SuperClass.x", x6);

            // reference SuperClass.x through SuperClass instance (not recommended, but valid in Java)
            String x7 = super.x;
            String x8 = ((SuperClass)this).x;
            String x9 = ((SuperClass)SubClass.this).x;

            assertEquals("SuperClass.x", x7);
            assertEquals("SuperClass.x", x8);
            assertEquals("SuperClass.x", x9);
        }

        void testY() {
            // reference SuperClass.y statically through SubClass
            String y1 = y;
            String y2 = SubClass.y;

            assertEquals("SuperClass.y", y1);
            assertEquals("SuperClass.y", y2);

            // reference SuperClass.y through SubClass instance (not recommended, but valid in Java)
            String y3 = this.y;
            String y4 = ((SubClass)this).y;
            String y5 = ((SubClass)SubClass.this).y;

            assertEquals("SuperClass.y", y3);
            assertEquals("SuperClass.y", y4);
            assertEquals("SuperClass.y", y5);

            // reference SuperClass.y statically through SuperClass
            String y6 = SuperClass.y;

            assertEquals("SuperClass.y", y6);

            // reference SuperClass.y through SuperClass instance (not recommended, but valid in Java)
            String y7 = super.y;
            String y8 = ((SuperClass)this).y;
            String y9 = ((SuperClass)SubClass.this).y;

            assertEquals("SuperClass.y", y7);
            assertEquals("SuperClass.y", y8);
            assertEquals("SuperClass.y", y9);
        }

        void testZ() {
            // reference SubClass.z statically through SubClass
            String z1 = z;
            String z2 = SubClass.z;

            assertEquals("SubClass.z", z1);
            assertEquals("SubClass.z", z2);

            // reference SubClass.z through SubClass instance (not recommended, but valid in Java)
            String z3 = this.z;
            String z4 = ((SubClass)this).z;
            String z5 = ((SubClass)SubClass.this).z;

            assertEquals("SubClass.z", z3);
            assertEquals("SubClass.z", z4);
            assertEquals("SubClass.z", z5);
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