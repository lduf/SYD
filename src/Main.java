package rpc;

public class Main {

	public static void main(String[] args) {
		try {
			Parse p = new Parse("./Guitare.java");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Wallah ça a merdé");
		}
	}
}