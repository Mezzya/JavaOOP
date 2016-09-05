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
	

	public int getSum() {
		return sum;
	}


	public int getStart() {
		return start;
	}


	public int getEnd() {
		return end;
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


	@Override
	public String toString() {
		return "SumTread [start=" + start + ", end=" + end + ", tr=" + tr + ", sum=" + sum + "]";
	}
	
	
	
	

}
