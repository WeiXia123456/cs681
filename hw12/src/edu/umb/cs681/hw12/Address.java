package edu.umb.cs681.hw12;

public final class Address {
    private final String stree, city, state;
    private final int zipcode;

    public Address(String stree, String city, String state, int zipcode) {
        this.stree = stree;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    public String getStree() {
        return stree;
    }
    public String getCity() {
        return  city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String toString() {
        return stree + " " + city + " " + state + " " + zipcode;
    }

    public boolean equals(Address another) {
        if (this.toString().equals(another.toString())) {
            return true;
        }
        return false;

    }


    public Address change(String stree, String city, String state, int zipcode) {
        return new Address(stree, city, state, zipcode);
    }




}
