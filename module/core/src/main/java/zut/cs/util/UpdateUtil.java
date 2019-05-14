package zut.cs.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class UpdateUtil {
    private static List<Method> methodList = new ArrayList<>();

    public static Object get(Object obj, Object obj2) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.invoke(obj, null) != null) {
                methodList.add(method);
            }
        }
        for (Method method : methodList) {
            Object o = method.invoke(obj, null);
            for (Method method1 : methods) {
                if (method1.getName().equals("set" + method.getName().substring(3))) {
                    method1.invoke(obj2, o);
                }
            }
        }
        return obj2;
    }
}
