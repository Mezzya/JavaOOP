package HomeWork71;

public class Port {
	
	private Dock[] docks;
	private int nextDock =-1;
	

	public Port(Dock[] docks) {
		super();
		this.docks = docks;
	}
	
	
	
	public synchronized Dock getFreeDock(Ship ship)
	{
//		Выдача свободного дока
		nextDock++;
		
		if (nextDock==docks.length) nextDock=0;
		System.out.println("Порт: выдаю Док №"+nextDock+" Кораблю №"+ship.getNumber());
		return docks[nextDock];		
	}
	
	
	


}
