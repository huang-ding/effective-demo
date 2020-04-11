package examples.ann;

/**
 * @author huangding
 * @date 2020/4/8 20:49
 */
public class Sample2 {

    @ExceptionTest(value = RuntimeException.class)
    public static void m1() {
    }

    public static void m2() {
    }

    @ExceptionTest(value = RuntimeException.class)
    public static void m3() {
        throw new RuntimeException("m3");
    }

    public static void m4() {
    }

    @ExceptionTest(value = RuntimeException.class)
    public static void m5() {
    }

    public static void m6() {
    }

    @ExceptionTest(value = IllegalArgumentException.class)
    public static void m7() {
        throw new IllegalArgumentException("m7");
    }


    public static void m8() {
    }

}
