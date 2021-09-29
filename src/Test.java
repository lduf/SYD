class Test{
	public static void main(String arg[]){
		Point p1 = new Point(0,1); // Creates a new point with x=0 and y=1
		Point p2 = new Point(); 

		System.out.println(p1+"  "+p2); // Returns : (0,0)
		System.out.println((p2 == p1)); // Returns : (0,0)

		p2.setY(1);
		System.out.println(p1+"  "+p2); // Returns : (0,0)
		System.out.println((p2.equals(p1))); // Returns : (0,0)

	}
}
