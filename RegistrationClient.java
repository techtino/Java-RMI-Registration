import java.rmi.*;
import javax.swing.*;
public class RegistrationClient{
    public static void main(String[] args){
        try{
            Registration connection=(Registration)Naming.lookup("rmi://localhost:5000/registration");  
            connection.setUsername("jeff"); 
            connection.setPassword("pass");
            connection.setEmail("Email");
            connection.setAddress("Address");
            System.out.println(connection.getUsername()); 
            System.out.println(connection.getPassword()); 
            System.out.println(connection.getEmail()); 
            System.out.println(connection.getAddress()); 
            connection.logData();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}