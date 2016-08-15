package Lesson02;

public class HouseZoo {

	private String zooName;
	private Animal[] animalArray = new Animal[10];
	public HouseZoo(String zooName) {
		super();
		this.zooName = zooName;
	}
	public HouseZoo() {
		super();
	}
	public String getZooName() {
		return zooName;
	}
	public void setZooName(String zooName) {
		this.zooName = zooName;
	}
	
	
	public boolean addAnimal(Animal animal)
	{
		for (int i = 0; i < animalArray.length; i++) {
			if (animalArray[i]==null)
			{
				animalArray[i]= animal;
				return true;
			}
		}
			
			
			if (animal.getClass() == Cat.class) {
				System.out.println("Take onu youur cat");
				
			}
			
			if (animal.getClass() == Rabit.class)
			{
				System.out.println("I is Rabit Nam-Nam");
			}
			return false;
		
		
	}
	
	@Override
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < animalArray.length; i++) {
			sb.append((i+1)+")");
			if (animalArray[i]== null)
			{
				sb.append("free");
			} else 
			{
				sb.append(animalArray[i]);
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
}
