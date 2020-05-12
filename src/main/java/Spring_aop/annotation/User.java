package Spring_aop.annotation;

import java.lang.reflect.Method;

/**
 * @author shkstart
 * @create 2020-05-10 16:38
 */
public class User {

    @AddAnnotation(userId =18,username = "小明",arrays = {"1"})
    public void add(){

    }

    public void del(){

    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 怎么样获取到方法上注解信息 反射机制
        Class<?> forName = Class.forName("Spring_aop.annotation.User");
        // 获取到当前类（不包含继承）所有的方法
        Method[] declaredMethods = forName.getDeclaredMethods();
        for(Method method:declaredMethods){
            // 获取该方法上是否存在注解
            System.out.println("####方法名称" + method.getName());
            AddAnnotation addAnnotation = method.getAnnotation(AddAnnotation.class);
            if (addAnnotation == null){
                // 该方法上没有注解
                System.out.println("该方法上没有加注解..");
                continue; //continue必须加，否则会爆空指针异常
            }

            // 在该方法上查找到该注解
            System.out.println("userId:" + addAnnotation.userId());
            System.out.println("userName:" + addAnnotation.username());
            System.out.println("arrays:" + addAnnotation.arrays());
            System.out.println();
        }

    }
}
