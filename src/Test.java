import java.io.*;
import java.net.*;
class Test{
	public static void main(String arg[]){
		final int PORT = 5000;
		try{
				ServerSocket connection = new ServerSocket(PORT);
				Socket socket = connection.accept();
				System.out.println("Client : "+socket.getInetAddress());

				BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));

				String line = in.readLine();
				while (line  != null){
					System.out.println(line);
					line = in.readLine();
				}
				in.close();
			}catch(IOException e){
				System.err.println("I/O erreur");
			}
		
		
		Point p1 = new Point(0,1); // Creates a new point with x=0 and y=1
		Point p2 = new Point(); 

		System.out.println(p1+"  "+p2); // Returns : (0,0)
		System.out.println((p2 == p1)); // Returns : (0,0)

		p2.setY(1);
		System.out.println(p1+"  "+p2); // Returns : (0,0)
		System.out.println((p2.equals(p1))); // Returns : (0,0)

	}
}
