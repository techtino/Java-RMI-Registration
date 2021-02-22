import java.rmi.*;
import java.io.*;
import javax.swing.*;
public class RegistrationClient{
    public static void main(String[] args){
        try{
            Registration connection=(Registration)Naming.lookup("rmi://localhost:5000/registration");  
            JTextField username = new JTextField();
            JTextField password = new JPasswordField();
            JTextField email= new JTextField();
            JTextField address = new JTextField();
            Object[] message = {
                "Username:", username,
                "Password:", password,
                "Email", email,
                "Address", address
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Register", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                System.out.println("Data Sent");
            }
            else {
                System.out.println("Cancelled");
            }
            connection.setUsername(username.getText());
            connection.setPassword(password.getText());
            connection.setEmail(email.getText());
            connection.setAddress(address.getText());
            connection.logData();
            System.out.println(connection.getStatus());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}