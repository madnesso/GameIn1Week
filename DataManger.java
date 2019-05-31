
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class DataManger implements Serializable
{
    private static final long serialVersionUID = -2666183491977336367L;
    private ArrayList<User> users = new ArrayList<>();
    private HashMap<String, User> data = new HashMap<>();

    public String addUser(String name, String id, String password)
    {
        User tempUser = new User(name, id, password);
        for (User user : users)
        {
            if (user.getId().equals(id))
            {
                return "ID already exists.";
            }
            else if (user.getPassword().equals(password))
            {
                return "Password already exists.";
            }
        }
        users.add(tempUser);
        map();
        return "User added succesfully";
    }

    private void map()
    {

        data.clear();
        for (User user : users)
        {
            data.put(user.getId(), user);

        }
    }

    public String removeUser(String name, String id, String password)
    {
        User temp = new User(name, id, password);
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).getId().equals(temp.getId()))
            {
                if (users.get(i).getPassword().equals(password))
                {
                    users.remove(users.get(i));
                }
                map();
                return "User removed";
            }
        }
        return "User not found";
    }

    public String saveUsers(File myFile)
    {
        try
        {
            ObjectOutputStream saver = new ObjectOutputStream(new FileOutputStream(myFile));
            saver.writeObject(users);
            saver.close();
            return "File saved successfully";
        } catch (FileNotFoundException ex)
        {
            return "File not Found";
        } catch (IOException ex)
        {
            return "Couldn't save data";
        }
    }

    public String loadUsers(File myFile)
    {
        try
        {
            ObjectInputStream loader = new ObjectInputStream(new FileInputStream(myFile));
            users = (ArrayList<User>) loader.readObject();
            loader.close();
            map();
            return "File loaded successfully";
        } catch (FileNotFoundException ex)
        {
            return "File not found";
        } catch (IOException ex)
        {
            return "Couldn't read data";
        } catch (ClassNotFoundException ex)
        {
            return "Couldn't find class";
        }
    }

    public String check(String id, String password)
    {
        if (data.containsKey(id))
        {

            if (data.get(id).equals(password)) { return "User exists"; }
            else { return "Wrong password"; }

        }
        else { return "Unknown id"; }
    }

 /*   public boolean checkforfunds(User u){
        for (int i = 0; i < users.size(); i++) {

if (users.get(i).getId().equals(u.getId())){


}


        }

    }
*/
    public void clearData()
    {
        users.clear();
        data.clear();
    }

}

	
	