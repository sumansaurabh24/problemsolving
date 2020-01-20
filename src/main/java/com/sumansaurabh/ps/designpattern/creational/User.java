package com.sumansaurabh.ps.designpattern.creational;

public class User {

    private int id;
    private String name;
    private int age;
    private String address;

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder{
        private int id;
        private String name;
        private int age;
        private String address;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }
    }
}
