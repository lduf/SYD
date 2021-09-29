import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Bateau{

	// Attributes 
	private Point[] coordonnees;
	private int size;
	private String name;
	private int orientation;


	// Constructors 
	public Bateau(){
		this.setSize(1);
		this.setOrientation("horizontal");
		this.setName("");

		this.coordonnees = new Point[this.getSize()];
		this.setOriginCoordonnees(new Point());
		this.defineCoordonneesFromOrigin();

	}

	public Bateau(String name, Point p, int size, String orientation){

		this.setSize(size);
		this.setOrientation(orientation);
		this.setName(name);

		this.coordonnees = new Point[this.getSize()];
		this.setOriginCoordonnees(p);
		this.defineCoordonneesFromOrigin();
	}


	public Bateau(String name, int x, int y, int size, String orientation){

		
		this.setSize(size);
		this.setOrientation(orientation);
		this.setName(name);

		this.coordonnees = new Point[this.getSize()];
		this.setOriginCoordonnees(x,y);
		this.defineCoordonneesFromOrigin();
	}


	// Déplacement du bateau 

	public Point deplacerX(String direction, int value){

		try{
			if(direction == "avancer" || direction == "reculer"){
				Method method = Point.class.getDeclaredMethod(direction + "X");
	 			method.invoke(this.getOriginCoordonnees(), value);
	 			this.defineCoordonneesFromOrigin();
			}
		}catch (NoSuchMethodException e) {
           	throw new RuntimeException(e);
       	} catch (IllegalAccessException e) {
            throw new RuntimeException(e);
       	}catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
 		
 		return this.getOriginCoordonnees();
	}

	public Point deplacerY(String direction, int value){
		try{
	 		if(direction == "avancer" || direction == "reculer"){
				Method method = Point.class.getDeclaredMethod(direction + "Y");
	 			method.invoke(this.getOriginCoordonnees(), value);
	 			this.defineCoordonneesFromOrigin();
			}
		}catch (NoSuchMethodException e) {
           	throw new RuntimeException(e);
       	} catch (IllegalAccessException e) {
            throw new RuntimeException(e);
       	}catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
 		
 		return this.getOriginCoordonnees();
	}

	public String toString(){
		String str = this.getName()+" a une taille de "+this.getSize()+" et se trouve en "+this.getOriginCoordonnees();

		return str;
	}

	// Getters and Setters
	public void defineCoordonneesFromOrigin(){
		int x,y = 0;
		for(int i=1; i<this.getSize(); i++){
			if(this.getOrientation() == "horizontal"){
				y = this.getOriginCoordonnees().getY();
				x = this.getCoordonnees(i-1).getX()+1;
			}
			else{
				y = this.getCoordonnees(i-1).getY()+1;
				x = this.getOriginCoordonnees().getX();
			}
			this.setCoordonnees(new Point(x,y), i);
		}
	}

	public void setOriginCoordonnees(Point p){
		this.coordonnees[0] = p;
	}
	public void setOriginCoordonnees(int x, int y){
		this.setOriginCoordonnees(new Point(x, y));
	}
	public void setCoordonnees(Point p, int indice){
		this.coordonnees[indice] = p;
	}
	public void setCoordonnees(int x, int y, int indice){
		this.setCoordonnees(new Point(x, y), indice);
	}

	public Point getOriginCoordonnees(){
		return this.coordonnees[0];
	}

	public Point getCoordonnees(int indice){
		return this.coordonnees[indice];
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return this.size;
	}

	public void setOrientation(String orientation){
		if(orientation == "vertical"){
			this.orientation = 1;
		}
		else{
			this.orientation = 0;
		}
		
	}

	public String getOrientation(){
		return (this.orientation == 1 ? "vertical" : "horizontal");
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}
}
