import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("RedundantCast")
public final class SuperInnerSuperClassInstanceFieldTest {

    static class OuterSuperClass {
        String v = "OuterSuperClass.v";
        String w = "OuterSuperClass.w";
        String x = "OuterSuperClass.x";
        String z = "OuterSuperClass.z";
    }

    static class Outer extends OuterSuperClass {
        String v = "Outer.v";
        String w = "Outer.w";
        String x = "Outer.x";
        String y = "Outer.y";

        class InnerSuperClass {
            String v = "InnerSuperClass.v";
            String x = "InnerSuperClass.x";
            String y = "InnerSuperClass.y";
            String z = "InnerSuperClass.z";
        }

        class SubClass extends InnerSuperClass {
            String x = "SubClass.x";

            void testV() {
                // reference InnerSuperClass.v through SubClass instance
                String v1 = v;
                String v4 = this.v;
                String v5 = (SubClass.this).v;
                String v6 = (SubClass.this).v;
                String v7 = ((SubClass)this).v;
                String v8 = ((SubClass)SubClass.this).v;
                String v9 = ((SubClass)SubClass.this).v;

                assertEquals("InnerSuperClass.v", v1);
                assertEquals("InnerSuperClass.v", v4);
                assertEquals("InnerSuperClass.v", v5);
                assertEquals("InnerSuperClass.v", v6);
                assertEquals("InnerSuperClass.v", v7);
                assertEquals("InnerSuperClass.v", v8);
                assertEquals("InnerSuperClass.v", v9);

                // reference InnerSuperClass.v through InnerSuperClass instance
                String v11 = super.v;
                String v12 = ((InnerSuperClass)this).v;
                String v13 = ((InnerSuperClass)SubClass.this).v;
                String v14 = ((InnerSuperClass)SubClass.this).v;

                assertEquals("InnerSuperClass.v", v11);
                assertEquals("InnerSuperClass.v", v12);
                assertEquals("InnerSuperClass.v", v13);
                assertEquals("InnerSuperClass.v", v14);

                // reference Outer.v through Outer instance
                String v16 = (Outer.this).v;
                String v17 = ((Outer)Outer.this).v;

                assertEquals("Outer.v", v16);
                assertEquals("Outer.v", v17);

                // reference OuterSuperClass.v through OuterSuperClass instance
                String v19 = ((OuterSuperClass)Outer.this).v;

                assertEquals("OuterSuperClass.v", v19);
            }
            
            
            void testW() {
                // reference Outer.w through Outer instance
                String w1 = w;
                String w16 = (Outer.this).w;
                String w17 = ((Outer)Outer.this).w;

                assertEquals("Outer.w", w1);
                assertEquals("Outer.w", w16);
                assertEquals("Outer.w", w17);

                // reference OuterSuperClass.w through OuterSuperClass instance
                String w19 = ((OuterSuperClass)Outer.this).w;

                assertEquals("OuterSuperClass.w", w19);
            }
            
            void testX() {
                // reference SubClass.x through SubClass instance
                String x1 = x;
                String x4 = this.x;
                String x5 = (SubClass.this).x;
                String x6 = (SubClass.this).x;
                String x7 = ((SubClass)this).x;
                String x8 = ((SubClass)SubClass.this).x;
                String x9 = ((SubClass)SubClass.this).x;

                assertEquals("SubClass.x", x1);
                assertEquals("SubClass.x", x4);
                assertEquals("SubClass.x", x5);
                assertEquals("SubClass.x", x6);
                assertEquals("SubClass.x", x7);
                assertEquals("SubClass.x", x8);
                assertEquals("SubClass.x", x9);

                // reference InnerSuperClass.x through InnerSuperClass instance
                String x11 = super.x;
                String x12 = ((InnerSuperClass)this).x;
                String x13 = ((InnerSuperClass)SubClass.this).x;
                String x14 = ((InnerSuperClass)SubClass.this).x;

                assertEquals("InnerSuperClass.x", x11);
                assertEquals("InnerSuperClass.x", x12);
                assertEquals("InnerSuperClass.x", x13);
                assertEquals("InnerSuperClass.x", x14);

                // reference Outer.x through Outer instance
                String x16 = (Outer.this).x;
                String x17 = ((Outer)Outer.this).x;

                assertEquals("Outer.x", x16);
                assertEquals("Outer.x", x17);

                // reference OuterSuperClass.x through OuterSuperClass instance
                String x19 = ((OuterSuperClass)Outer.this).x;

                assertEquals("OuterSuperClass.x", x19);
            }

            void testY() {
                // reference InnerSuperClass.y through SubClass instance
                String y1 = y;
                String y4 = this.y;
                String y5 = (SubClass.this).y;
                String y6 = (SubClass.this).y;
                String y7 = ((SubClass)this).y;
                String y8 = ((SubClass)SubClass.this).y;
                String y9 = ((SubClass)SubClass.this).y;

                assertEquals("InnerSuperClass.y", y1);
                assertEquals("InnerSuperClass.y", y4);
                assertEquals("InnerSuperClass.y", y5);
                assertEquals("InnerSuperClass.y", y6);
                assertEquals("InnerSuperClass.y", y7);
                assertEquals("InnerSuperClass.y", y8);
                assertEquals("InnerSuperClass.y", y9);

                // reference InnerSuperClass.y through InnerSuperClass instance
                String y11 = super.y;
                String y12 = ((InnerSuperClass)this).y;
                String y13 = ((InnerSuperClass)SubClass.this).y;
                String y14 = ((InnerSuperClass)SubClass.this).y;

                assertEquals("InnerSuperClass.y", y11);
                assertEquals("InnerSuperClass.y", y12);
                assertEquals("InnerSuperClass.y", y13);
                assertEquals("InnerSuperClass.y", y14);

                // reference Outer.y through Outer instance
                String y16 = (Outer.this).y;
                String y17 = ((Outer)Outer.this).y;

                assertEquals("Outer.y", y16);
                assertEquals("Outer.y", y17);
            }
            
            
            void testZ() {
                // reference InnerSuperClass.z through SubClass instance
                String z1 = z;
                String z4 = this.z;
                String z5 = (SubClass.this).z;
                String z6 = (SubClass.this).z;
                String z7 = ((SubClass)this).z;
                String z8 = ((SubClass)SubClass.this).z;
                String z9 = ((SubClass)SubClass.this).z;

                assertEquals("InnerSuperClass.z", z1);
                assertEquals("InnerSuperClass.z", z4);
                assertEquals("InnerSuperClass.z", z5);
                assertEquals("InnerSuperClass.z", z6);
                assertEquals("InnerSuperClass.z", z7);
                assertEquals("InnerSuperClass.z", z8);
                assertEquals("InnerSuperClass.z", z9);

                // reference InnerSuperClass.z through InnerSuperClass instance
                String z11 = super.z;
                String z12 = ((InnerSuperClass)this).z;
                String z13 = ((InnerSuperClass)SubClass.this).z;
                String z14 = ((InnerSuperClass)SubClass.this).z;

                assertEquals("InnerSuperClass.z", z11);
                assertEquals("InnerSuperClass.z", z12);
                assertEquals("InnerSuperClass.z", z13);
                assertEquals("InnerSuperClass.z", z14);

                // reference OuterSuperClass.z through Outer instance
                String z16 = (Outer.this).z;
                String z17 = ((Outer)Outer.this).z;

                assertEquals("OuterSuperClass.z", z16);
                assertEquals("OuterSuperClass.z", z17);

                // reference OuterSuperClass.z through OuterSuperClass instance
                String z19 = ((OuterSuperClass)Outer.this).z;

                assertEquals("OuterSuperClass.z", z19);
            }
        }
    }

    @Test
    void test() {
        final Outer.SubClass instance = new Outer().new SubClass();
        instance.testV();
        instance.testW();
        instance.testX();
        instance.testY();
        instance.testZ();
    }
}