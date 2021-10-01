package rpc;

import java.util.ArrayList;

public class Function {
	// Attributs
	String confidentiality;
	String signature;
	String return_type;
	String name;
	ArrayList<Argument> arguments;
	ArrayList<String> exceptions;

	// Methods
	public Function(String confidentiality, String return_type, String name, ArrayList<Argument> arguments, ArrayList<String> exceptions) {
		this.confidentiality = confidentiality;
		this.return_type = return_type;
		this.name = name;
		this.arguments = arguments;
		this.exceptions = exceptions;

		this.generateSignature();

		System.out.println("Just generated : " + this.signature);
	}

	public void generateSignature() {
		String preambule = this.confidentiality + " " + this.return_type + " " + this.name;

		// for every argument in the arraylist
		String string_args = " (";
		int number_args = this.arguments.size();
		for (int i=0; i<number_args; i++) {
			string_args += this.arguments.get(i).toString();
			if (i != number_args - 1) {
				string_args += ", ";
			}
		}
		string_args = string_args + ")";

		// for every exeception in the arraylist
		String string_exceptions = " throws ";
		int number_exceptions = this.exceptions.size();
		for (int i=0; i<number_exceptions; i++) {
			string_exceptions += this.exceptions.get(i);
			if (i != number_exceptions - 1) {
				string_exceptions += ", ";
			}
		}

		this.signature = preambule + string_args + string_exceptions;
	}

	public String getConfidentiality() {
		return this.confidentiality;
	}

	public String getReturnType() {
		return this.return_type;
	}

	public String getName() {
		return this.name;
	}

	public String getSignature() {
		return this.signature;
	}
}