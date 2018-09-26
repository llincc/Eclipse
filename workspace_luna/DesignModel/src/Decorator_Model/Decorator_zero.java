package Decorator_Model;

public class Decorator_zero extends Decorator {
    
    public Decorator_zero(Human human) {
    	super(human);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		System.out.println("Decorator_zero...");
	}

	@Override
	public void walkToWhere() {
		super.walkToWhere();
		System.out.println("Decorator_zero");
		// TODO Auto-generated method stub
	}
}
