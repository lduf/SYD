# SYD
SYD project

Compilateur d'interfaces (langage comme on veut) —> le plus générique possible



Compil : 

```bash
javac -d . *.java
```







```java
package rpc;
public class Matlab_boot {

  public static void main(String [] arg) throws Exception {
    // DYN Matlab m = new Matlab_impl();
    java.net.ServerSocket sos = new java.net.ServerSocket(//1234);  PORT NUM
    java.net.Socket s = sos.accept();

    java.io.DataInputStream dis = new java.io.DataInputStream(s.getInputStream());
    java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(s.getOutputStream());

    String fonction = dis.readUTF(); ="calcul"
    
    /* DYN
    if (fonction.equals("calcul")) {
      oos.writeObject(m.calcul(dis.readInt()));
    }
    
    -> V.2.0
    try{
    	m.fonction()
    }catch{ ……… }
    */ 
  }

}
```



-> À la papa

-> avec les if



V2.

-> à la volée

-> réflexivité

```java
package rpc;
public class /*${Matlab}*/_stub implements /*${Matlab}*/ {

  /*${public}*/ /*${Result}*/ /*${calcul*/(/*${int i} -> foreach*/) /*${throws Exception}*/ {

    java.net.Socket s = new java.net.Socket(/*${"localhost"}*/, /*${1234}*/);
    java.io.DataOutputStream dos = new java.io.DataOutputStream(s.getOutputStream());
    java.io.ObjectInputStream ois = new java.io.ObjectInputStream(s.getInputStream());

    dos.writeUTF(/*${"calcul"}*/);
    dos.write/*${Int(3)}*/; // -> foreach
    
    return((/*${Result}*/)ois.readObject());
  }
}
```



```java
package rpc;
public class Client {
  public static void main(String [] arg) throws Exception {
    
    Matlab m = new Matlab/*${_stub}*/();
    Result res = m.calcul(3);
    System.out.println("->" + res);

  }
}
```

