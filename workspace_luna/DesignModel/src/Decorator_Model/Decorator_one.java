package Decorator_Model;

public class Decorator_one extends Decorator {
    
    public Decorator_one(Human human) {
    	super(human);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		System.out.println("Decorator_one...");
	}

	@Override
	public void walkToWhere() {
		super.walkToWhere();
		System.out.println("Decorator_one");
		// TODO Auto-generated method stub
	}
}
