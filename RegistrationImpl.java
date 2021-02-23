import java.rmi.*;
import java.rmi.server.*;  
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class RegistrationImpl extends UnicastRemoteObject implements Registration{          
    private String username;
    private String password;
    private String email;
    private String address;
    private Boolean status;

    RegistrationImpl()throws RemoteException{  
        super();
    }  
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
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String timestamp = timeFormat.format(new Date());
        try{
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
        String line;
        int i = 0;
        DefaultListModel logList = new DefaultListModel();
        try{
            FileReader fr = new FileReader("log.txt");
            BufferedReader reader = new BufferedReader(fr);
            while ((line = reader.readLine()) != null){
                logList.addElement(line);    
                i++;
            }
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