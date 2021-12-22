package server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import interf.ConnectDB_interface;

public class ConnectDB extends UnicastRemoteObject implements ConnectDB_interface, Serializable {
	final String nameDB = "rmi_cuoiky";
	final String host 	= "root";
	final String pass	= "";
	
	Statement stm ; 
	Connection conn ;
	protected ConnectDB() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/" + nameDB, host , pass);
			System.out.println("Connected !");
			stm = conn.createStatement(); 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


//	public ConnectDB() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost/" + nameDB, host , pass);
//			System.out.println("Connected !");
//			stm = conn.createStatement(); 
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public ConnectDB(Statement stm) {
//		this.stm = stm; 
//	}
	
	public int changeData(String sql) {
		int n = 0 ; 
		System.out.println(sql);
		try {
			n = stm.executeUpdate(sql); 
			System.out.println(n);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n ; 
	}
	
	public User getUser(String sql) {
		ResultSet resultSet = null;  
		try {
			resultSet = stm.executeQuery(sql); 
			System.out.println("hello");
			resultSet.next(); 
			User obj = new User(resultSet.getInt(1), resultSet.getString(2)); 
			return obj ; 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null ; 
	}
	

	@Override
	public Vector<Mess> getDataMess(String sql) throws RemoteException {
		Vector<Mess> vtMess = new Vector<Mess>(); 
		ResultSet resultSet = null;  
		try {
			System.out.println("dget data");
			resultSet = stm.executeQuery(sql); 
		//	System.out.println(resultSet);
			while (resultSet.next()) {
				vtMess.add(new Mess(resultSet.getInt(1), resultSet.getInt(2),  resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
				//System.out.println(resultSet.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vtMess ; 
	}
	
	@Override
	public Vector<Calc> getDataCalculator(String sql) throws RemoteException {
		Vector<Calc> vtMess = new Vector<Calc>(); 
		ResultSet resultSet = null;  
		try {
		//	System.out.println("dget data");
			resultSet = stm.executeQuery(sql); 
		//	System.out.println(resultSet);
			while (resultSet.next()) {
				vtMess.add(new Calc(resultSet.getInt(1), resultSet.getInt(2),  resultSet.getString(3), resultSet.getString(4)));
				//System.out.println(resultSet.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return vtMess ; 
	}
	
	public User findOneDataUser(String sql) {
		ResultSet resultSet = null;  
		try {
			resultSet = stm.executeQuery(sql); 
			
	
			resultSet.next(); 
			User obj = new User(resultSet.getInt(1), resultSet.getString(2)); 
			return obj ; 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null ; 
	}
	public int countData(String sql) {
		ResultSet resultSet = null;  
		try {
			resultSet = stm.executeQuery(sql); 
	
			
			resultSet.next(); 
			int a = resultSet.getInt(1);
			return a ; 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0 ; 
	}
	public void closeConnect() {
		try {
			conn.close();
			stm.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
				
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectDB connect = null;
		try {
			connect = new ConnectDB();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
//		
//		String sql = "INSERT INTO User (Username,Password) VALUES ('phan1', '1123')"; 
//		connect.changeData(sql); 
		
		String sql1 = "SELECT * FROM `user` WHERE 1"; 
//		ResultSet result = connect.getData(sql1);
//		try {
//			while(result.next()) {
//				System.out.println(result.getString(2) + " --" + result.getString(3) );
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
