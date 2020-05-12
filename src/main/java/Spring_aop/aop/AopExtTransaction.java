package Spring_aop.aop;

import Spring_aop.annotation.ExtTransaction;
import Spring_aop.transaction.TransactionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.Method;

/**
 * @author shkstart
 * @create 2020-05-10 17:40
 */
@Aspect
@Component
public class AopExtTransaction {


    @Autowired
	private TransactionUtils transactionUtils;

    @AfterThrowing("execution(* Spring_aop.service.*.*.*(..))")
	public void afterThrowing() {
        System.out.println("程序发生异常");
		// 获取当前事务 直接回滚
		transactionUtils.rollback();
	}


	// 环绕通知 在方法之前和之后处理事情
	@Around("execution(* Spring_aop.service.*.*.*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
        // 1.获取该方法上是否加上注解
        ExtTransaction extTransaction = getMethodExtTransaction(pjp);
        TransactionStatus transactionStatus = begin(extTransaction);
        // 2.调用目标代理对象方法
        pjp.proceed();
        // 3.判断该方法上是否就上注解
        commit(transactionStatus);

    }

    //提交事务
    public void commit(TransactionStatus transactionStatus){
        if (transactionStatus !=null){
            // 5.如果存在注解,提交事务
            transactionUtils.commit(transactionStatus);
        }
    }


    //开启事务
    public TransactionStatus begin(ExtTransaction extTransaction){
        if (extTransaction == null){
            return null;
        }
        // 2.如果存在事务注解,开启事务
        return transactionUtils.begin();
    }

    // 获取方法上是否存在事务注解
    private ExtTransaction getMethodExtTransaction(ProceedingJoinPoint pjp) throws NoSuchMethodException {
        // 1.获取该方法上是否加上注解
        String methodName = pjp.getSignature().getName();
//		// 获取目标对象
        Class<?> classTarget = pjp.getTarget().getClass();
//		// 获取目标对象类型
        Class<?>[] par = ((MethodSignature) pjp.getSignature()).getParameterTypes();
//		// 获取目标对象方法
        Method objMethod = classTarget.getMethod(methodName, par);
        ExtTransaction extTransaction = objMethod.getDeclaredAnnotation(ExtTransaction.class);
        return extTransaction;
    }
}
