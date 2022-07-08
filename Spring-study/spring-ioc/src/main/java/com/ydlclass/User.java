package com.ydlclass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
/*
* com.ydlclass.User
*
* */
public class User {
    private String name;
    private int age;
    private String[] hobby;
    private List<String> friends;
    private Map<String,String> parents;
    private Adress adress;
    private String add="add";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Map<String, String> getParents() {
        return parents;
    }

    public void setParents(Map<String, String> parents) {
        this.parents = parents;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", friends=" + friends +
                ", parents=" + parents +
                ", adress=" + adress +
                '}';
    }


}
