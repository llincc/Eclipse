package Decorator_Model;

public class Decorator implements Human {
    private Human human;
    
    public Decorator(Human human) {
    	this.human = human;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		human.wearClothes();
	}

	@Override
	public void walkToWhere() {
		human.walkToWhere();
		// TODO Auto-generated method stub
	}

}
