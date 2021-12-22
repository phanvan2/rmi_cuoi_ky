package interf;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculate_IF extends Remote {
	 float getResult(String s) throws RemoteException;
	 

	    /**
	     * Giải phương trình bậc 2: ax2 + bx + c = 0
	     * 
	     * @param a: hệ số bậc 2
	     * @param b: hệ số bậc 1
	     * @param c: số hạng tự do
	     */
	 public String giaiPTBac2(float a, float b, float c) throws RemoteException;
}
