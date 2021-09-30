package rpc;

import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.HashMap;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.Writer;
import java.io.StringWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.*;

public class Ctm{

	// java rpc.Ctm Filepath @IP Port

	public static void main(String [] arg) throws Exception {
		// Créer fichiers 
		try{
			createStub(arg[0]);
			createBoot(arg[0]);
		}catch(Exception e) {
            e.printStackTrace();
        }
	}


	/**
	 * 
	 * Creates the Stub file based on InterfaceName. 
	 * 
	 * */


	private static void createStub(String InterfaceName) throws Exception{
		String filename = InterfaceName+"Stub.java";
		createFile(filename);
		String content = readFile("StubStructure.txt");
		FileWriter(filename, content);
	}


	private static void createBoot(String InterfaceName) throws Exception{
		String filename = InterfaceName+"Boot.java";
		createFile(filename);
		String content = readFile("BootStructure.txt");
		FileWriter(filename, content);
	}

	/**
	 * 
	 * Returns parameters from interface's files
	 * 
	*/
/*
	private static HashMap<Object, Object> getParams(){

		return new HashMap<Object, Object>();

	}*/

	private static void createFile(String filename){
		 try {
	      	File file = new File(filename);
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

	private static void FileWriter(String path, String content){
		try {
	      FileWriter myWriter = new FileWriter(path);
	      myWriter.write(content);
	      myWriter.close();
	      System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}

	 /**
     * Read content of file
     *
     * @param path path to file
     * @return return a String of the content of the file
     */
    private static String readFile(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        return readFileInputStream(is);
    }


    /**
     * Read content of file
     *
     * @param is inputstream of the file
     * @return return a String of the content of the file
     */
    public static String readFileInputStream(InputStream is) throws IOException {
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }
        return writer.toString();
    }
}