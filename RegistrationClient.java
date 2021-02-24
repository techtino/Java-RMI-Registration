import java.rmi.*;
import java.io.*;
import javax.swing.*;
public class RegistrationClient{
    public static void main(String[] args){
        try{
            Registration connection=(Registration)Naming.lookup("rmi://localhost:5000/registration");  
            connection.setStatus(false);
            int result = JOptionPane.showOptionDialog(null, "Select a menu option", "Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] { "Register", "View Logs" }, JOptionPane.NO_OPTION);
            if (result == JOptionPane.YES_OPTION){
                promptUserForDetails();
                connection.logData();
            }
            else if (result == JOptionPane.NO_OPTION){
                connection.viewLogs();
            }
            else{
                System.exit(0);
            }
            if (connection.getStatus() == true){
                JOptionPane.showMessageDialog(null, "Success");
            }
            else{
                JOptionPane.showMessageDialog(null, "The process was cancelled or failed");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void promptUserForDetails(){
        try{
            Registration connection=(Registration)Naming.lookup("rmi://localhost:5000/registration");  
            connection.setStatus(false);
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
                connection.setUsername(username.getText());
                connection.setPassword(password.getText());
                connection.setEmail(email.getText());
                connection.setAddress(address.getText());
            }
            else {
                connection.setStatus(false);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}