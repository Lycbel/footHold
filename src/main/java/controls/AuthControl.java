package controls;

import modules.User;
import DB.*;
public class AuthControl {

    public User login(String email, String pass){

        return new AuthDB().login(email,pass);
    }
    public boolean signup(User us){
        return  0< new AuthDB().signup(us);
    }

    /*  -2 need to fill all
    -1 not match
    *  1 success
    *  0 datbase problem
    */
    public int changePassWord(User u,String pass, String cpass){
        if(pass==null||cpass==null){
            return -2;
        }
            if(pass.equals(cpass)){
                return new AuthDB().changePassWorld(u,pass);
            }else{
                return  -1;
            }
    }


}
