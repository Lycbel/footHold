package modules;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.lang.reflect.Field;
import java.sql.Connection;
public class HouseBean {
    private String
    name,
    space,
    description,
    notes,
    transit,
    access,
    interaction,
    house_rules,
    street,
    city,
    state,
    zipcode,
    property_tpe,
    room_type,
    bathrooms,
    bedrooms,
    beds,
    price,
    security_deposites,
    guests_includes;
    User user;
    List <String> urls = new ArrayList<String>();
    List <String> names = new ArrayList<String>();;
    public HouseBean(HttpServletRequest request,List<String>urls,List <String> names,User user){
        this.urls = urls;
        this.names = names;
        this.user = user;
        try {
            Field f[] = HouseBean.class.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                String type = f[i].getGenericType().toString();
                if (type.equals("class java.lang.String"))
                    f[i].set(this, request.getAttribute(f[i].getName()));
            }
        }catch (IllegalAccessException e){

        }

    }

 public PreparedStatement getPreParedStatement(PreparedStatement ps,Connection conn){
        String m = "insert into houses ( usrid, Thumbnail_url ";
        String e=" values (";
        List <String> values = new ArrayList<String>();
     try {
         Field f[] = HouseBean.class.getDeclaredFields();
         for (int i = 0; i < f.length; i++) {
             String type = f[i].getGenericType().toString();
             if(i!=0){
                 m+=",";
                 e+=",";
             }
             if (type.equals("class java.lang.String")){
                m+=f[i].getName();
                e+="?";
             }
             values.add((String)f[i].get(this));
         }
         m+=")";
         e+="?,?);";
         m = m + e;
         ps = conn.prepareStatement(m);
         ps.setLong(1, user.getUserID());
         if(urls.size()>=1) {
             ps.setString(2, urls.get(0));
         }else{
             ps.setString(2, null);
         }
         int i=3;
         for(String s : values){
             ps.setString(i,s);
         }
         return ps;

     }catch (IllegalAccessException ex1){

     }catch(SQLException ex2){

     }
     return null;
 }
    public HouseBean(String name, String space, String description, String notes, String transit, String access, String interaction, String house_rules, String street, String city, String state, String zipcode, String property_tpe, String room_type, String bathrooms, String bedrooms, String beds, String price, String security_deposites, String guests_includes, User user) {
        this.name = name;
        this.space = space;
        this.description = description;
        this.notes = notes;
        this.transit = transit;
        this.access = access;
        this.interaction = interaction;
        this.house_rules = house_rules;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.property_tpe = property_tpe;
        this.room_type = room_type;
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.beds = beds;
        this.price = price;
        this.security_deposites = security_deposites;
        this.guests_includes = guests_includes;
        this.user = user;
    }


    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {

        return names;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setTransit(String transit) {
        this.transit = transit;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public void setHouse_rules(String house_rules) {
        this.house_rules = house_rules;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setProperty_tpe(String property_tpe) {
        this.property_tpe = property_tpe;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSecurity_deposites(String security_deposites) {
        this.security_deposites = security_deposites;
    }

    public void setGuests_includes(String guests_includes) {
        this.guests_includes = guests_includes;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {

        return name;
    }

    public String getSpace() {
        return space;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    public String getTransit() {
        return transit;
    }

    public String getAccess() {
        return access;
    }

    public String getInteraction() {
        return interaction;
    }

    public String getHouse_rules() {
        return house_rules;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getProperty_tpe() {
        return property_tpe;
    }

    public String getRoom_type() {
        return room_type;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public String getBeds() {
        return beds;
    }

    public String getPrice() {
        return price;
    }

    public String getSecurity_deposites() {
        return security_deposites;
    }

    public String getGuests_includes() {
        return guests_includes;
    }

    public User getUser() {
        return user;
    }
}
