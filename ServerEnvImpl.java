import java.rmi.Naming;
import java.rmi.RemoteException;
import java.lang.SecurityManager;
import java.rmi.server.UnicastRemoteObject;

public class ServerEnvImpl extends UnicastRemoteObject implements ServerEnv {
    public ServerEnvImpl() throws RemoteException {
        super();
    }

    public String outputEnv() {
        return "test text";
    }

    public static void main(String args[]) {
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            ServerEnvImpl obj = new ServerEnvImpl();
            Naming.rebind("ServerEnv", obj);
            System.out.println("ServerEnv bound in regstry");
        } catch(Exception e) {
            System.out.println("ServerEnvImpl err: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
