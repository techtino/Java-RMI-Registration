import java.rmi.*;
import java.rmi.registry.*;
public class RegistrationServer{
    public static void main(String[] args){
        try{
            Registration connection = new RegistrationImpl();
            Naming.rebind("rmi://localhost:5000/registration",connection);
            System.out.println("Server waiting for requests...");
        }
        catch (Exception e)
        {
            System.out.println(e);
        };
    }
}