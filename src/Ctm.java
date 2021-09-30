import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class Ctm{
	public static void main(String [] arg) throws Exception {
		// Créer fichiers 
	}


	private static void createStub(String ){
		createFile("Stub");
	}


	private static void createBoot(){
		createFile("Boot");
	}

	/**
	 * 
	 * Returns parameters from interface's files
	 * 
	*/

	private static Hashmap<Object, Object> getParams(){

	}

	private static void createFile(String filename){
		 try {
	      	File file = new File(filename+".java");
	      if (file.createNewFile()) {
	        System.out.println("File created: " + file.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}