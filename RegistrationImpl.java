import java.rmi.*;
import java.rmi.server.*;  
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class RegistrationImpl extends UnicastRemoteObject implements Registration{          
    
    // user detail variables
    private String username;
    private String password;
    private String email;
    private String address;
    private Boolean status;

    // implements the Registration class as the super class
    RegistrationImpl()throws RemoteException{  
        super();
    }  

    // getters and setters for variables
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status= status;
    }

    public void logData(){
        // timestamp is generated based on current time/date
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String timestamp = timeFormat.format(new Date());
        try{
            //writes user details to text file for logging and closes connection
            FileWriter writer = new FileWriter("log.txt",true);
            writer.write(timestamp + " Username:" + getUsername() + " Password:" + getPassword() + " Email: " + getEmail() + " Address: " + getAddress() + "\n");
            writer.close();
            setStatus(true);
        }
        catch(IOException e){
            System.out.println(e);
            setStatus(false);
        }
    }

    public void viewLogs(){
        // variables for list are created
        String line;
        int i = 0;
        DefaultListModel logList = new DefaultListModel();
        try{
            // readers for text file and reading to string
            FileReader fr = new FileReader("log.txt");
            BufferedReader reader = new BufferedReader(fr);
            // if line of a file is not empty then add it to the list
            while ((line = reader.readLine()) != null){
                logList.addElement(line);    
                i++;
            }
            //creation of GUI list and displaying it inside a scrolling pane.
            JList list = new JList(logList);
            JOptionPane.showMessageDialog(null, new JScrollPane(list));
            setStatus(true);
            reader.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}