import java.rmi.*;
import java.rmi.registry.*;
public class RegistrationServer{
    public static void main(String[] args){
        try{
            //RegistrationImpl to encapsulate in RMI naming system
            Registration connection = new RegistrationImpl();
            //Binds the implementation to the RMI remote address
            Naming.rebind("rmi://localhost:5000/registration",connection);
        }
        catch (Exception e)
        {
            System.out.println(e);
        };
    }
}