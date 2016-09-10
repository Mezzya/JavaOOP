package HomeWork72;

public class StatusBar implements Runnable {

	private FileCopy fc;

	public StatusBar() {
		super();
	}

	public StatusBar(FileCopy fc) {
		super();
		this.fc = fc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!fc.isEndCopy()) {
			System.out.println("Progress bar " + fc.getStatusbar() + "%");
		}

		System.out.println("Copy completed..");

	}

}
