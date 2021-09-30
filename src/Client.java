package rpc;

public class Client {
  public static void main(String [] arg) throws Exception {
    //distant : Guitare g = new Guitare_stub();
    Guitare g = new Guitare_impl();
    Morceau m = g.play("Coucou");
    System.out.println(m);
  }
}