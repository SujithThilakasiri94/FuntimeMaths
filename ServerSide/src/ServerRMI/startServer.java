package ServerRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class startServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("");
		try {
			questionServer question = new questionServer();
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("QuestionService1819",question);

			System.out.println("Service started. Welcome to FunTime Maths!");
			
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
