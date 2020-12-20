package com.sxt.io;

public class DecorateTest {

}
//抽象组件
interface Drink{
    double cost();
    String info();
}
//具体组件
class Coffee implements Drink{
    private String name = "Coffee";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}
//抽象装饰类
abstract class Decorate implements Drink{
    //对抽象组件对引用
    private Drink drink;

    public Decorate(Drink drink){
        this.drink = drink;
    }

    @Override
    public double cost() {
        return drink.cost();
    }

    @Override
    public String info() {
        return drink.info();
    }

}
//具体装饰类
class Milk extends Decorate{
    public Milk(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost()+5;
    }

    @Override
    public String info() {
        return super.info()+"加入了牛奶";
    }

}
