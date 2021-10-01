package rpc;

import java.util.HashMap; // import the HashMap class
import java.util.ArrayList; // import the ArrayList class
import java.lang.Class;
import java.util.Arrays;
import java.lang.reflect.Method;

public class Parse {
	/* Attributs */
	public String interface_name;
	public ArrayList<Function> methods = new ArrayList<Function>();

	/* Methods */
	public Parse(String file_path) throws ClassNotFoundException {
		// get the name of the interface from the file path
		interface_name = this.getInterfaceFromFilePath(file_path);
		System.out.println("Interface name: " + interface_name);

		// analyse the file
		Class class_to_analyse = Class.forName("rpc." + interface_name);

		for (Method method : class_to_analyse.getDeclaredMethods()) {
			// faire le traitement pour chaque fonction

			System.out.println("Initial output: " + method.toString());

			int index_arg = 0;
			String keyword_arg = "arg";
			ArrayList<Argument> list_args = new ArrayList<Argument>();
			ArrayList<String> list_exceptions = new ArrayList<String>();

			// traiter les arguments et créer l'arraylist associée
			// récupérer une liste des paramètres
			for (Class param : method.getParameterTypes()) {
				list_args.add(new Argument(keyword_arg+index_arg, splitDotLastElement(param.toString())));
				index_arg++;
			}

			// get the exceptions
			for (Class exception : method.getExceptionTypes()) {
				list_exceptions.add(splitDotLastElement(exception.toString()));
			}

			// TODO find a way to get the confidentiality programatically
			Function f = new Function("public", splitDotLastElement(method.getReturnType().toString()), method.getName(), list_args, list_exceptions);
			methods.add(f);
		}
	}

	public static String splitDotLastElement(String string_to_split) {
		String[] elements = string_to_split.split("\\.");
		return elements[elements.length-1];
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