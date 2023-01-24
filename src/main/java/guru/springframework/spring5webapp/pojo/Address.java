package guru.springframework.spring5webapp.pojo;

import org.springframework.lang.Nullable;

public class Address {

    private String streetAddress1;
    @Nullable
    private String streetAddress2;
    private String city;
    private String state;
    private String zip;

    public Address() {
    }

    public Address(String streetAddress1, @Nullable String streetAddress2, String city, String state, String zip) {
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    @Nullable
    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(@Nullable String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress1='" + streetAddress1 + '\'' +
                ", streetAddress2='" + streetAddress2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
