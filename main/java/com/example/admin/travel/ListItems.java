package com.example.admin.travel;

/**
 * Created by Sharu on 26/3/2016.
 */

public class ListItems {
    private String name, profilePic;

    public ListItems() {
    }

    public ListItems( String name, String image) {
        super();

        this.name = name;
        this.profilePic = image;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
