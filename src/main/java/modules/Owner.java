package modules;

import java.util.List;
import java.util.ArrayList;
public class Owner extends  User{
    private List<HouseBasic> houses;
    public Owner(long userID, String firstName, String lastName, String userEmail, String address){
        super(userID,  firstName,  lastName,  userEmail,  address);
    }
    public void setHouses(List<HouseBasic> houses){
        this.houses = houses;
    }
    public void addAHouse(House h){
        if(houses==null){
            houses = new ArrayList<HouseBasic>();
        }
        this.houses.add(h);
    }

    public List<HouseBasic> getHouses() {
        return houses;
    }
}
