package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "11111";
    }

    @Override
    public void eat(String food) {
        System.out.println("2222222"+food);
    }
}

//代理类创建
class ProxyFactory{
    public static Object getProxyInstance(Object object){
        MyInvocationHandler handler =new MyInvocationHandler();
        handler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private  Object object;
    public void bind(Object object){
        this.object=object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(object,args);
    }
}
public class MyProxy {
    public static void main(String[] args) {
        SuperMan superMan=new SuperMan();
        Human proxyInstance=(Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("333333");

        NikeClothFactorty nikeClothFactorty=new NikeClothFactorty();
        ClothFactory clothFactoryInstance=(ClothFactory)ProxyFactory.getProxyInstance(nikeClothFactorty);
        clothFactoryInstance.produceCloth();
    }
}
