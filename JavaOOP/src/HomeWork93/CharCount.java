package HomeWork93;

public class CharCount {
	private long count = 0;// Абсолютная частота
	private char bukva; // Сам символ
	private double relFrec =0;
	

	public CharCount(char bukva) {
		super();
		this.bukva = bukva;
		this.count = 1;
	}

	public long getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public char getBukva() {
		return bukva;
	}
	
	
	
	public double getRelFrec() {
		return relFrec;
	}

	public void inc() {
		count++;
	}
	
	public void calcrelFrec(long size)
	{
		relFrec = (double)size/count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bukva;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharCount other = (CharCount) obj;
		if (bukva != other.bukva)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CharCount [count=" + count + ", bukva=" + bukva + ", relFrec=" + relFrec + "]";
	}

	

}
