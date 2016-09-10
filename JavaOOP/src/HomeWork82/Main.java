package HomeWork82;

public class Main {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		
		stack.add(new String("Text"));
		stack.add(new String("Text 1"));
		stack.add(new Integer(5));
		stack.add(new String("Text 3"));
		stack.printStack();
		System.out.println("-=-");
		stack.get();
		stack.get();
		stack.getAndDel();
		System.out.println("get-"+stack.get());
		System.out.println("-=-");
		
		stack.printStack();
	
		
	}

}
