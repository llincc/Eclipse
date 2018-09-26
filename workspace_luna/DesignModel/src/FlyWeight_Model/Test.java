package FlyWeight_Model;

public class Test {
	public static void main(String[] args) {
		String a = "abc";    
		String b = "abc";  //创建b的时候先看看“abc”是否已经创建对象实例，如果是，则直接使用已有对象
		System.out.println(a == b);

		b = b + "d";  //"abc"是字符串常量，所以是新创建一个字符串
		System.out.println(a == b);
	}
}
