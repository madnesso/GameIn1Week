
package stickmantowerdefence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class DataManger implements Serializable{
    private ArrayList <User> users = new ArrayList<>();
    private HashMap <String,User> data = new HashMap <String,User>();
    private File myFile ;

    public DataManger(File myfile) {
        this.myFile = myfile;
    }
    
    public String addUser(String name, String id, String password)
    {
        User tempUser = new User(name,id,password);
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).getId().equals(id))
            {
                return "ID already exists.";
            }
            else if(users.get(i).getPassword().equals(password))
            {
                return "Password already exists.";
            }
        }
        users.add(tempUser);
        map();
        return "User added succesfully";
    }
    
    public String removeUser(String name, String id, String password){
        User temp = new User(name, id, password);
        for(int i=0; i<users.size(); i++)
        {
            if(users.get(i).getId().equals(temp.getId()))
            {
                if(users.get(i).getPassword().equals(password))
                users.remove(users.get(i));
                map();
                return "User removed";
            }
        }
        return "User not found";
    }
       
    public String saveUsers(){
        try {
            ObjectOutputStream saver = new ObjectOutputStream(new FileOutputStream(myFile));
            saver.writeObject(this.users);
            saver.close();
            return "File saved successfully";
        } catch (FileNotFoundException ex) {
            return "File not Found";
        } catch (IOException ex) {
            return "Couldn't save data";
        }
    }
    
    public String loadUsers(){
        try {
            ObjectInputStream loader = new ObjectInputStream(new FileInputStream(myFile));
            this.users = (ArrayList<User>)loader.readObject();
            loader.close();
            this.map();
            return "File loaded successfully";
        } catch (FileNotFoundException ex) {
            return "File not found";
        } catch (IOException ex) {
            return "Couldn't read data";
        } catch (ClassNotFoundException ex) {
            return "Couldn't find class";
        }
    }
    
    public void map(){
        data.clear();
        for(int i=0; i<users.size(); i++)
        {
            data.put(users.get(i).getId(), users.get(i));
        }
    }
    
    public String check(String id, String password){
        if(data.containsKey(id))
        {
            {
            if(data.get(id).getPassword().equals(password))
                return "User exists";
            else
                return "Wrong password";
            }
        }else 
            return "Unknown id";
    }
    
    public int getUserScore(String id){
        if(data.containsKey(id))
            return (data.get(id).getScore());
        else
        return 0;
    }
    
    public void clearData()
    {
        users.clear();
        data.clear();
    }
    
}
