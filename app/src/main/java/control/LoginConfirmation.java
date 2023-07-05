package control;

import java.util.ArrayList;

import entities.User;

public class LoginConfirmation {

    public static boolean login(ArrayList<User>userlist,String username, String password){
        for(User user:userlist){
            if(user.getName().equals(username)&&user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
