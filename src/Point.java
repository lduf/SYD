class Point{

	// Attributes 
	private int x;
	private int y;


	// Constructors 
	public Point(){
		setX(0);
		setY(0);
	}

	public Point(int x, int y){
		this.setX(x);
		this.setY(y);
	}


	public void avancerX(int value){
 		this.setX(this.getX()+value);
	}

	public void reculerX(int value){
 		this.setX(this.getX()-value);
	}


	public void avancerY(int value){
 		this.setY(this.getY()+value);
	}

	public void reculerY(int value){
 		this.setY(this.getY()-value);
	}

	// Return true if this is equal to point
	public boolean equals(Point point){
		return (this.getX() == point.getX() && this.getY() == point.getY());
	}

	public String toString(){
		String str = "("+this.getX()+","+this.getY()+")";

		return str;
	}

	// Getters and Setters
	public void setX(int x){
		this.x = x;
	}

	public int getX(){
		return this.x;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getY(){
		return this.y;
	}
}
