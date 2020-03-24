package com.example.java8.interfaceDemo;

/**
 * Created by duan on 2020/1/7 9:15
 *
 *  通过默认方法你可以指定接口方法的默认实现。
 *  换句话说，接口能提供方法的具体实现。因此，实现接口的类
 * 如果不显式地提供该方法的具体实现，就会自动继承默认的实现
 */
public class InterfaceDemoImpl implements InterfaceDemo {
    @Override
    public void testDefaultMethod() {
        System.out.println("interfaceDemo 实现类中的testDefaultMethod() 方法");
    }
}
