package entities;

public class Entity 
{
	private int id;
	
	public Entity(int id)
	{
		setId(id);
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String toString() 
	{
		return "\n" + "id: " + id + "\n";
	}
}
