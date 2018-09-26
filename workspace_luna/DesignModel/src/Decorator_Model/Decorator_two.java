package Decorator_Model;

public class Decorator_two extends Decorator {
    
    public Decorator_two(Human human) {
    	super(human);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		System.out.println("Decorator_two...");
	}

	@Override
	public void walkToWhere() {
		super.walkToWhere();
		System.out.println("Decorator_two");
		// TODO Auto-generated method stub
	}
}
