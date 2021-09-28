package server;

import java.io.Serializable;
import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;

import interf.ConnectDB_interface;

public class Server implements Serializable {
	public static void main( String [] args) {
		try {
			java.rmi.registry.LocateRegistry.createRegistry(1099);
			Context ctx = new InitialContext();
			ConnectDB_interface connect = new ConnectDB(); 
			
			ctx.rebind("rmi://192.168.1.148/register", connect );
			
			ctx.rebind("rmi://192.168.1.148/login", connect ); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
