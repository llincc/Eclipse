package FlyWeight_Model;

public class Test {
	public static void main(String[] args) {
		String a = "abc";    
		String b = "abc";  //����b��ʱ���ȿ�����abc���Ƿ��Ѿ���������ʵ��������ǣ���ֱ��ʹ�����ж���
		System.out.println(a == b);

		b = b + "d";  //"abc"���ַ����������������´���һ���ַ���
		System.out.println(a == b);
	}
}
