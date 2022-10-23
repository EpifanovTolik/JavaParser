package firstApp;


public class Refer {

    String name;
    String address;

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", address='" + address + '\'' +
                        '}';
    }

    public Refer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Refer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}




