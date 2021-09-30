package rpc;

import java.util.HashMap; // import the HashMap class
import java.util.ArrayList; // import the ArrayList class
import java.lang.Class;
import java.util.Arrays;
import java.lang.reflect.Method;

public class Parse {
	/* Attributs */
	public String interface_name;
	public HashMap<String, HahsMap<String, String>> interface_methods = new HashMap<String, HashMap<String, String>>();

	/* Methods */
	public Parse(String file_path) throws ClassNotFoundException {
		// get the name of the interface from the file path
		interface_name = this.getInterfaceFromFilePath(file_path);

		System.out.println(interface_name);

		// analyse the file
		Class class_to_analyse = Class.forName("rpc." + interface_name);

		for (Method method : class_to_analyse.getDeclaredMethods()) {
			System.out.println(method.toString());
		}
	}

	public static String getInterfaceFromFilePath(String file_path) {
		String interface_name = "";

		// split using the "/" symbol, creates an array. the last item is the filename
		String[] dir = file_path.split("/");
		String file_name = dir[dir.length-1];

		// split using the dot. the first item is the name of the class. the last one is the file extension
		String[] elements = file_name.split("\\.");
		interface_name = elements[0];

		return interface_name;
	}
}