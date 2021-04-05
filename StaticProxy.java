package test;

interface ClothFactory{
    void produceCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;
    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();//精髓
        System.out.println("收尾工作");
    }
}
//被代理类
class NikeClothFactorty implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("被代理类被调用");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        //NikeClothFactorty nike=new NikeClothFactorty();
        ClothFactory nike =new NikeClothFactorty();
        //ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}
