package invocation_handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * InvocationHandler для отслеживания времени выполнения сортировок
 */
public class TimingDynamicInvocationHandler implements InvocationHandler {

    private Object target;
    private final Map<String, Method> methods = new HashMap<>();

    public TimingDynamicInvocationHandler(Object target) {
        this.target = target;
        for (Method method : target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = methods.get(method.getName()).invoke(target, args);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("execution time for "
                + target.getClass().getSimpleName() +
                "#"
                + method.getName() +
                " :"
                + elapsed);
        return result;
    }
}
