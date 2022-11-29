package com.zou.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * @author 你好
 */
public class JdkMeipoProxy implements InvocationHandler {

    /**
     * 被代理对象应用保存下来
     */
    private Object target;


    /**
     * 生成代理对象
     */
    public Object getInstance(Object target){
        this.target = target;
        Class<?> aClass = target.getClass();
        Object o = Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
        return o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(this.target, args);
        after();
        return invoke;
    }

    private void before(){
        System.out.println("before========================");
    };
    private void after(){
        System.out.println("after=========================");
    };
}
