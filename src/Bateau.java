import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Bateau{

	// Attributes 
	private Point origine;
	private int size;

	// Constructors 
	public Bateau(){
		this.setSize(1);
		this.origine = new Point();
	}

	public Bateau(Point p, int size){
		this.setSize(size);
		this.setOrigine(p);
	}


	public Bateau(int x, int y, int size){
		this(new Point(x,y), size);
	}

	// Getters and Setters
	public void setOrigine(Point p){
		this.origine = p;
	}
	public void setOrigine(int x, int y){
		this.setOrigine(new Point(x, y));
	}
	public Point getOrigine(){
		return this.origine;
	}
	public void setSize(int size){
		this.size = size;
	}
	public int getSize(){
		return this.size;
	}
}
