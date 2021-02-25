import java.rmi.*;

public interface Registration extends Remote{
    // base definitions that throw RemoteExceptions
    public String getUsername() throws RemoteException;
    public void setUsername(String username) throws RemoteException;
    public String getPassword() throws RemoteException; 
    public void setPassword(String password) throws RemoteException; 
    public String getEmail() throws RemoteException; 
    public void setEmail(String email) throws RemoteException; 
    public String getAddress() throws RemoteException; 
    public void setAddress(String address) throws RemoteException; 
    public Boolean getStatus() throws RemoteException; 
    public void setStatus(Boolean status) throws RemoteException; 
    public void logData() throws RemoteException;
    public void viewLogs() throws RemoteException;
}