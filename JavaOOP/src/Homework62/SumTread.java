package Homework62;

import java.math.BigInteger;

public class SumTread implements Runnable {

	private int start, end;
	private Thread tr;
	private BigInteger sum;
	private BigInteger[] array;
	public SumTread() {
		// TODO Auto-generated constructor stub
	}
	

	public SumTread(int start, int end, BigInteger[] array) {
		super();
		this.start = start;
		this.end = end;
		this.array = array;
		sum = new BigInteger("0");
		tr = new Thread(this);
	}
	

	public BigInteger getSum() {
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
			sum= sum.add(new BigInteger(""+array[i]));
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
