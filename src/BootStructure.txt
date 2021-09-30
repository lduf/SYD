package rpc;
public class Matlab_boot {

  public static void main(String [] arg) throws Exception {
    // DYN Matlab m = new Matlab_impl();
    java.net.ServerSocket sos = new java.net.ServerSocket(//1234);  PORT NUM
    java.net.Socket s = sos.accept();

    java.io.DataInputStream dis = new java.io.DataInputStream(s.getInputStream());
    java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(s.getOutputStream());

    String fonction = dis.readUTF(); ="calcul"
  }
}
