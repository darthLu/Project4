package lwade;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
public class TimingAspect {

    @Pointcut("execution(* *(..))")
    public void allMethods() {}

    @Around( "allMethods()" )
    public Object profile( final ProceedingJoinPoint joinPoint) throws Throwable {

        final long start = System.currentTimeMillis();

        try {
            final Object value = joinPoint.proceed();
            return value;
        } catch (Throwable t) {
            throw t;
        } finally {
            final long stop = System.currentTimeMillis();
            System.out.println("Execution time: "+ joinPoint.getSignature().getName() + " : "+ (stop-start));
        }
    }
}
