package Homework61;

public class SumTread implements Runnable {

	int start, end;
	
	public SumTread() {
		// TODO Auto-generated constructor stub
	}
	

	public SumTread(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		start=100;
	}
	
	

}
