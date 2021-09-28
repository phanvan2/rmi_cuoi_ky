package interf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;

import server.User;

public interface ConnectDB_interface extends Remote   {
	 
	 int changeData(String sql) throws RemoteException;
	 User getData(String sql) throws RemoteException;
	 User findOneData(String sql) throws RemoteException; 
	 int countData(String sql) throws RemoteException; 
	 
}
