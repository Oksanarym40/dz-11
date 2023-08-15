package org.example;

public class Person {

    protected String firstName;
    protected String lastName;
    protected int age;
    protected Person partner;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return partner;
    }

    public boolean isRetired() {
        return (this.age >= (this instanceof Woman ? 60 : 65));
    }
    public void setPartner(Person partner) {
        this.partner = partner;
        if (partner != null) {
            partner.partner = this;
        }
    }

    public void registerPartnership(Person partner) {
        this.partner = partner;
        if (this instanceof Woman) {
            this.lastName = partner.getLastName();
        }
    }


    public void deregisterPartnership(boolean returnToPreviousLastName) {
        this.partner = null;
        partner.partner = null;
        if (this instanceof Woman && returnToPreviousLastName) {
            this.lastName = this.partner.getLastName();
        }
        partner = null;
    }
}