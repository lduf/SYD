package rpc;

import java.util.HashMap; // import the HashMap class
import java.util.ArrayList; // import the ArrayList class
import java.lang.Class;
import java.util.Arrays;

public class Parse {
	/* Attributes */
	public String confidentialite; // public, private, protected
	public String interface_name;
	public HashMap<String, ArrayList<String>> functions_and_parameters = new HashMap<String, ArrayList<String>>();

	/* Methods */
	public Parse(String file_path) throws ClassNotFoundException {
		// analyse the file
		Class class_to_analyse = Class.forName("rpc.Guitare");

		System.out.println(Arrays.toString(class_to_analyse.getDeclaredMethods()));
	}

	public String getInterfaceFromFilePath(String file_path) {

		
		return "";
	}
}