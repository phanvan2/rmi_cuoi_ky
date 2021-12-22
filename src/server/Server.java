package server;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;

import Class.Calculate;
import Class.ChatServer;
import Class.Constant;
import interf.Calculate_IF;
import interf.ChatServerIF;
import interf.ConnectDB_interface;

public class Server implements Serializable {
	public static void main( String [] args) {
		Constant constant = new Constant() ; 
		try {
			java.rmi.registry.LocateRegistry.createRegistry(constant.PORT);
			Context ctx = new InitialContext();
			ConnectDB_interface connect = new ConnectDB(); 
			
			ctx.rebind("rmi://" + constant.HOST + "/db", connect );
			
		//	ctx.rebind("rmi://" + constant.HOST + "/db", connect ); 
			
			Calculate_IF calculate = new Calculate() ; 
			ctx.rebind("rmi://" + constant.HOST + "/calculate", calculate);
			
			ChatServerIF hello = new ChatServer();
			ctx.rebind("rmi://" +  constant.HOST  + "/" + "GroupChatService", hello);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
