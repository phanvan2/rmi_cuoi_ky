package interf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.Vector;

import server.Calc;
import server.Mess;
import server.User;

public interface ConnectDB_interface extends Remote   {
	 
	 int changeData(String sql) throws RemoteException;
	 User getUser(String sql) throws RemoteException;
	 Vector<Mess> getDataMess(String sql) throws RemoteException;

	 User findOneDataUser(String sql) throws RemoteException; 
	 int countData(String sql) throws RemoteException;
	//Mess getData(String sql); 
	public Vector<Calc> getDataCalculator(String sql) throws RemoteException; 

}
