package Decorator_Model;

public class Test {
	public static void main(String[] args) {
		Decorator decorator = new Decorator_two(new Decorator_one(new Decorator_zero(new Person())));
		
		decorator.wearClothes();
		decorator.walkToWhere();
	}
}
