import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerEnvClient {
    public static void main(String args[]) {
        String message = "ServerEnv: OS of stdxxxx is Mac.";

        ServerEnv obj = null;

        try {
            obj = (ServerEnv)Naming.lookup("//" + "/ServerEnvServer");
            message = obj.outputEnv();
        } catch(Exception e) {
            System.out.println("ServerEnvClient exception: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Message = " + message);
    }
}
