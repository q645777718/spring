package Spring_aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target(value = ElementType.METHOD) 设置注解权限<br>
 * @author shkstart
 * @create 2020-05-10 16:35
 */
@Target(value = ElementType.METHOD)  //标记在哪些地方能使用这个新的注解
@Retention(RetentionPolicy.RUNTIME)
// @interface 定义注解
public @interface AddAnnotation {

    // 手写Spring事务注解
    int userId() default 0;
    String username() default "默认名称";
    String[] arrays();

}
