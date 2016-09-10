package HomeWork71;

public class Dock {
private boolean busy=false;
private int number;



public Dock() {
	super();
}

public Dock( int number) {
	super();
	this.number=number;
	
	
}


public int getNumber() {
	return number;
}



public boolean isBusy() {
	return busy;
}



public synchronized void unload(Ship ship) {
	
	while (busy)
	{
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	Начинаю разгрузку
	busy=true;
	
	while (ship.getBoxes()>0)
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	System.out.println("Док №"+number+" Разгрузил один ящик c Корабля №"+ship.getNumber()+ " Осталось ящиков "+ship.getBoxes());
	ship.dowloadOneBox();
	}
	
	busy=false;
	notifyAll();
}





}
