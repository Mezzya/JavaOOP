package Homework61;

public class SumTread implements Runnable {

	private int start, end;
	private Thread tr;
	private int sum;
	private int[] array;
	public SumTread() {
		// TODO Auto-generated constructor stub
	}
	

	public SumTread(int start, int end, int[] array) {
		super();
		this.start = start;
		this.end = end;
		this.array = array;
		tr = new Thread(this);
	}
	

	public Thread getTr() {
		return tr;
	}

	public void sum(){
		for (int i=start;i<=end;i++)
		{
			sum+=array[i];
		}
		
	}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		sum();
	}
	
	

}
