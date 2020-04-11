package examples.ann;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author huangding
 * @date 2020/4/8 20:47
 */
public class RunTests {

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(args[0]);
        for (Method declaredMethod : testClass.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    declaredMethod.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void test(Class testClass) {
        int tests = 0;
        int passed = 0;
        for (Method declaredMethod : testClass.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    declaredMethod.invoke(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    Throwable cause = e.getCause();
                    Class<? extends Exception> exp = declaredMethod
                        .getAnnotation(ExceptionTest.class).value();
                    if (exp.isInstance(cause)) {
                        passed++;
                    }
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
