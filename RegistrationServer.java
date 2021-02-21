import java.rmi.*;
import java.rmi.registry.*;
public class RegistrationServer{
    public static void main(String[] args){
        try{
            Registration connection = new RegistrationImpl();
            Naming.rebind("rmi://localhost:5000/registration",connection);
            System.out.println("Server waiting for requests...");
            new Thread() {
                     public void run () {
                         try {
                             Naming.unbind("registration");
                             System.out.println(
                             "Server has shut down successfully");
                         } catch (Exception e) {
                             System.out.println(
                             "Server could not unbind from registry - giving up");
                         }
                     }
            };
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}