package lwade;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class QuoteDBAspect {
    @AfterReturning(pointcut = "execution(* QuoteDao.*(..))", returning= "result")

    public void logReturn(JoinPoint jp, Object result)
    {
        Quotes q = (Quotes) result;

        if(q != null) {
            System.out.println("----------Start---------------");
            System.out.println("***** Custom Quote: " + q.getQuote());
            System.out.println("----------End-----------------");
        }
    }

}
