package chapter14.Lambda;

public class LambdaEx3 {

	class Outer {
		int val = 10;
		
		class Inner {
			int val = 20;
			
			void method(int i) {
				int val = 30;
	//			i = 10;
				
				MyFunction f = () -> {
					System.out.println(" i : " + i);
					System.out.println(" val : " + val);
					System.out.println(" this.val : " + ++this.val);
					System.out.println(" Outer.this.val : " + ++Outer.this.val);
				
				};
				
				
			}
		}
	}
	
	public static void main(String[] args) {
		MyFunction f = () -> {};
		Object obj = (MyFunction) (() -> {});
		String str = ((Object) (MyFunction) (() -> {})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
	}

}
