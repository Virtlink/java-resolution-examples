import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"AccessStaticViaInstance", "RedundantCast"})
public final class SuperInnerSuperClassStaticFieldTest {

    static class OuterSuperClass {
        static String v = "OuterSuperClass.v";
        static String w = "OuterSuperClass.w";
        static String x = "OuterSuperClass.x";
        static String z = "OuterSuperClass.z";
    }

    static class Outer extends OuterSuperClass {
        static String v = "Outer.v";
        static String w = "Outer.w";
        static String x = "Outer.x";
        static String y = "Outer.y";

        class InnerSuperClass {
            static String v = "InnerSuperClass.v";
            static String x = "InnerSuperClass.x";
            static String y = "InnerSuperClass.y";
            static String z = "InnerSuperClass.z";
        }

        class SubClass extends InnerSuperClass {
            static String x = "SubClass.x";

            void testV() {
                // reference InnerSubClass.v statically through SubClass
                String v1 = v;
                String v2 = SubClass.v;
                String v3 = Outer.SubClass.v;

                assertEquals("InnerSuperClass.v", v1);
                assertEquals("InnerSuperClass.v", v2);
                assertEquals("InnerSuperClass.v", v3);

                // reference InnerSuperClass.v through SubClass instance (not recommended, but valid in Java)
                String v4 = this.v;
                String v5 = (SubClass.this).v;
                String v6 = (Outer.SubClass.this).v;
                String v7 = ((SubClass)this).v;
                String v8 = ((SubClass)SubClass.this).v;
                String v9 = ((SubClass)Outer.SubClass.this).v;

                assertEquals("InnerSuperClass.v", v4);
                assertEquals("InnerSuperClass.v", v5);
                assertEquals("InnerSuperClass.v", v6);
                assertEquals("InnerSuperClass.v", v7);
                assertEquals("InnerSuperClass.v", v8);
                assertEquals("InnerSuperClass.v", v9);

                // reference InnerSuperClass.v statically through InnerSuperClass
                String v10 = InnerSuperClass.v;

                assertEquals("InnerSuperClass.v", v10);

                // reference InnerSuperClass.v through InnerSuperClass instance (not recommended, but valid in Java)
                String v11 = super.v;
                String v12 = ((InnerSuperClass)this).v;
                String v13 = ((InnerSuperClass)SubClass.this).v;
                String v14 = ((InnerSuperClass)Outer.SubClass.this).v;

                assertEquals("InnerSuperClass.v", v11);
                assertEquals("InnerSuperClass.v", v12);
                assertEquals("InnerSuperClass.v", v13);
                assertEquals("InnerSuperClass.v", v14);

                // reference Outer.v statically through Outer
                String v15 = Outer.v;

                assertEquals("Outer.v", v15);

                // reference Outer.v through Outer instance (not recommended, but valid in Java)
                String v16 = (Outer.this).v;
                String v17 = ((Outer)Outer.this).v;

                assertEquals("Outer.v", v16);
                assertEquals("Outer.v", v17);

                // reference OuterSuperClass.v statically through Outer
                String v18 = OuterSuperClass.v;

                assertEquals("OuterSuperClass.v", v18);

                // reference OuterSuperClass.v through OuterSuperClass instance (not recommended, but valid in Java)
                String v19 = ((OuterSuperClass)Outer.this).v;

                assertEquals("OuterSuperClass.v", v19);
            }
            
            
            void testW() {
                // reference Outer.w statically through SubClass
                String w1 = w;

                assertEquals("Outer.w", w1);

                // reference Outer.w statically through Outer
                String w15 = Outer.w;

                assertEquals("Outer.w", w15);

                // reference Outer.w through Outer instance (not recommended, but valid in Java)
                String w16 = (Outer.this).w;
                String w17 = ((Outer)Outer.this).w;

                assertEquals("Outer.w", w16);
                assertEquals("Outer.w", w17);

                // reference OuterSuperClass.w statically through Outer
                String w18 = OuterSuperClass.w;

                assertEquals("OuterSuperClass.w", w18);

                // reference OuterSuperClass.w through OuterSuperClass instance (not recommended, but valid in Java)
                String w19 = ((OuterSuperClass)Outer.this).w;

                assertEquals("OuterSuperClass.w", w19);
            }
            
            void testX() {
                // reference SubClass.x statically through SubClass
                String x1 = x;
                String x2 = SubClass.x;
                String x3 = Outer.SubClass.x;

                assertEquals("SubClass.x", x1);
                assertEquals("SubClass.x", x2);
                assertEquals("SubClass.x", x3);

                // reference SubClass.x through SubClass instance (not recommended, but valid in Java)
                String x4 = this.x;
                String x5 = (SubClass.this).x;
                String x6 = (Outer.SubClass.this).x;
                String x7 = ((SubClass)this).x;
                String x8 = ((SubClass)SubClass.this).x;
                String x9 = ((SubClass)Outer.SubClass.this).x;

                assertEquals("SubClass.x", x4);
                assertEquals("SubClass.x", x5);
                assertEquals("SubClass.x", x6);
                assertEquals("SubClass.x", x7);
                assertEquals("SubClass.x", x8);
                assertEquals("SubClass.x", x9);

                // reference InnerSuperClass.x statically through InnerSuperClass
                String x10 = InnerSuperClass.x;

                assertEquals("InnerSuperClass.x", x10);

                // reference InnerSuperClass.x through InnerSuperClass instance (not recommended, but valid in Java)
                String x11 = super.x;
                String x12 = ((InnerSuperClass)this).x;
                String x13 = ((InnerSuperClass)SubClass.this).x;
                String x14 = ((InnerSuperClass)Outer.SubClass.this).x;

                assertEquals("InnerSuperClass.x", x11);
                assertEquals("InnerSuperClass.x", x12);
                assertEquals("InnerSuperClass.x", x13);
                assertEquals("InnerSuperClass.x", x14);

                // reference Outer.x statically through Outer
                String x15 = Outer.x;

                assertEquals("Outer.x", x15);

                // reference Outer.x through Outer instance (not recommended, but valid in Java)
                String x16 = (Outer.this).x;
                String x17 = ((Outer)Outer.this).x;

                assertEquals("Outer.x", x16);
                assertEquals("Outer.x", x17);

                // reference OuterSuperClass.x statically through Outer
                String x18 = OuterSuperClass.x;

                assertEquals("OuterSuperClass.x", x18);

                // reference OuterSuperClass.x through OuterSuperClass instance (not recommended, but valid in Java)
                String x19 = ((OuterSuperClass)Outer.this).x;

                assertEquals("OuterSuperClass.x", x19);
            }

            void testY() {
                // reference InnerSuperClass.y statically through SubClass
                String y1 = y;
                String y2 = SubClass.y;
                String y3 = Outer.SubClass.y;

                assertEquals("InnerSuperClass.y", y1);
                assertEquals("InnerSuperClass.y", y2);
                assertEquals("InnerSuperClass.y", y3);

                // reference InnerSuperClass.y through SubClass instance (not recommended, but valid in Java)
                String y4 = this.y;
                String y5 = (SubClass.this).y;
                String y6 = (Outer.SubClass.this).y;
                String y7 = ((SubClass)this).y;
                String y8 = ((SubClass)SubClass.this).y;
                String y9 = ((SubClass)Outer.SubClass.this).y;

                assertEquals("InnerSuperClass.y", y4);
                assertEquals("InnerSuperClass.y", y5);
                assertEquals("InnerSuperClass.y", y6);
                assertEquals("InnerSuperClass.y", y7);
                assertEquals("InnerSuperClass.y", y8);
                assertEquals("InnerSuperClass.y", y9);

                // reference InnerSuperClass.y statically through InnerSuperClass
                String y10 = InnerSuperClass.y;

                assertEquals("InnerSuperClass.y", y10);

                // reference InnerSuperClass.y through InnerSuperClass instance (not recommended, but valid in Java)
                String y11 = super.y;
                String y12 = ((InnerSuperClass)this).y;
                String y13 = ((InnerSuperClass)SubClass.this).y;
                String y14 = ((InnerSuperClass)Outer.SubClass.this).y;

                assertEquals("InnerSuperClass.y", y11);
                assertEquals("InnerSuperClass.y", y12);
                assertEquals("InnerSuperClass.y", y13);
                assertEquals("InnerSuperClass.y", y14);

                // reference Outer.y statically through Outer
                String y15 = Outer.y;

                assertEquals("Outer.y", y15);

                // reference Outer.y through Outer instance (not recommended, but valid in Java)
                String y16 = (Outer.this).y;
                String y17 = ((Outer)Outer.this).y;

                assertEquals("Outer.y", y16);
                assertEquals("Outer.y", y17);
            }
            
            
            void testZ() {
                // reference InnerSuperClass.z statically through SubClass
                String z1 = z;
                String z2 = SubClass.z;
                String z3 = Outer.SubClass.z;

                assertEquals("InnerSuperClass.z", z1);
                assertEquals("InnerSuperClass.z", z2);
                assertEquals("InnerSuperClass.z", z3);

                // reference InnerSuperClass.z through SubClass instance (not recommended, but valid in Java)
                String z4 = this.z;
                String z5 = (SubClass.this).z;
                String z6 = (Outer.SubClass.this).z;
                String z7 = ((SubClass)this).z;
                String z8 = ((SubClass)SubClass.this).z;
                String z9 = ((SubClass)Outer.SubClass.this).z;

                assertEquals("InnerSuperClass.z", z4);
                assertEquals("InnerSuperClass.z", z5);
                assertEquals("InnerSuperClass.z", z6);
                assertEquals("InnerSuperClass.z", z7);
                assertEquals("InnerSuperClass.z", z8);
                assertEquals("InnerSuperClass.z", z9);

                // reference InnerSuperClass.z statically through InnerSuperClass
                String z10 = InnerSuperClass.z;

                assertEquals("InnerSuperClass.z", z10);

                // reference InnerSuperClass.z through InnerSuperClass instance (not recommended, but valid in Java)
                String z11 = super.z;
                String z12 = ((InnerSuperClass)this).z;
                String z13 = ((InnerSuperClass)SubClass.this).z;
                String z14 = ((InnerSuperClass)Outer.SubClass.this).z;

                assertEquals("InnerSuperClass.z", z11);
                assertEquals("InnerSuperClass.z", z12);
                assertEquals("InnerSuperClass.z", z13);
                assertEquals("InnerSuperClass.z", z14);

                // reference OuterSuperClass.z statically through Outer
                String z15 = Outer.z;

                assertEquals("OuterSuperClass.z", z15);

                // reference OuterSuperClass.z through Outer instance (not recommended, but valid in Java)
                String z16 = (Outer.this).z;
                String z17 = ((Outer)Outer.this).z;

                assertEquals("OuterSuperClass.z", z16);
                assertEquals("OuterSuperClass.z", z17);

                // reference OuterSuperClass.z statically through Outer
                String z18 = OuterSuperClass.z;

                assertEquals("OuterSuperClass.z", z18);

                // reference OuterSuperClass.z through OuterSuperClass instance (not recommended, but valid in Java)
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