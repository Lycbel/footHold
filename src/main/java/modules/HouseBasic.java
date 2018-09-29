package modules;

public class HouseBasic {
    protected long houseId;
    protected String housePicLink;
    protected String address;
    protected String Name;

    public HouseBasic(long houseId, String housePicLink, String address, String name) {
        this.houseId = houseId;
        this.housePicLink = housePicLink;
        this.address = address;
        Name = name;
    }

    public long getHouseId() {
        return houseId;
    }

    public String getHousePicLink() {
        return housePicLink;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return Name;
    }
}
