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
