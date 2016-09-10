package HomeWork72;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy implements Runnable {
	private long fileSize;
	private long progress;
	private long statusbar;
	private boolean endCopy;
	private boolean changed;
	private File fileFrom, fileTo;

	public FileCopy() {
		super();
	}

	public FileCopy(File fileFrom, File fileTo) {
		super();
		this.fileFrom = fileFrom;
		this.fileTo = fileTo;
	}

	public boolean isEndCopy() {
		return endCopy;
	}

	public synchronized long getStatusbar() {

		while (!changed) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		changed = false;

		return statusbar;
	}

	private synchronized void setStatusbar(long statusbar) {

		if (this.statusbar != statusbar) {
			this.statusbar = statusbar;
			changed = true;
			notify();
		}
	}

	private void CopyFile(File fileFrom, File fileTo) {

		if ((fileFrom == null) || (fileTo == null))
			throw new IllegalArgumentException("Один или оба параметра null");
		if (!fileFrom.exists() || fileFrom.isDirectory())
			throw new IllegalArgumentException("Файл источник не существует или директория");
		if (!fileTo.exists() || !fileTo.isDirectory())
			throw new IllegalArgumentException("Директория назначения не существует или не директория");

		// Поехали ))

		fileSize = fileFrom.length();

		try (FileInputStream fis = new FileInputStream(fileFrom);
				FileOutputStream fos = new FileOutputStream(
						fileTo.getAbsolutePath() + File.separator + fileFrom.getName())) {
			byte[] buffer = new byte[1024 * 1204];
			int s;
			while ((s = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, s);
				progress += s;
				setStatusbar(progress * 100 / fileSize);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		CopyFile(fileFrom, fileTo);
		endCopy = true;
	}

}
