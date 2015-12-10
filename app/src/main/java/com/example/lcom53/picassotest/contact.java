package com.example.lcom53.picassotest;

import org.json.JSONObject;

import java.io.Serializable;

public class contact implements Serializable
{
    public String id;
    public String firstName = "";        //
    public String lastName = "";        //
    public String completename = "";
    public String joinedDate = "";        //
    public String noOfContacts = "";        //
    public String Circles = "";        //  Circles in jsonarray of a perticular user
    public String photoUri = "";
    public int is_block = 0;        //
    public String ContactList = "";        //Contacts in jsonarray of a perticular user
    public int is_user_contact = 1;        //Used to differentiate circle and contact in Contact list
    // 1 for Contact and 0 for Circle
    public String message = "";        //
    public int show = 0;        //

    public String username = "";
    public String PhoneNumber = "";
    public String sortKey = "";
    public boolean isselected = false;   // Value used in contact picker default is False
    public boolean isdeputy = false, allowEdit=true;

    public int is_allow_suggestion = -1;        //
    public int is_show_circle = -1;        //
    public int is_show_contacts_list = -1;        //
    public int is_show_date_created = -1;        //
    public int is_show_numbers_of_contacts = -1;        //
    public int is_show_presence = -1;        //

    public int is_my_circle = 0;

    // Used in Suggestion list in contactFragment
    public contact(String username, String completename, String sortKey)
    {
        super();
        this.username = (username == null) ? "" : username;
        this.completename = (completename == null) ? "" : completename;
        this.sortKey = (sortKey == null) ? "" : sortKey;
    }

    // Used to create blank contact in Sign Up
    public contact(String username, String completename)
    {
        super();
        this.username = (username == null) ? "" : username;
        this.completename = (completename == null) ? "" : completename;
    }

    // Used to create blank contact in Sign Up
    public contact(String username, String completename, String avatar,String sample)
    {
        super();
        this.username = (username == null) ? "" : username;
        this.completename = (completename == null) ? "" : completename;
        this.photoUri = (avatar == null) ? "" : avatar;
    }

    // Used in blocked contacts
    public contact(String username, int is_block)
    {
        super();
        this.is_block = is_block;
        this.username = (username == null) ? "" : username;

    }

    public contact()
    {
    }

    /*
    * Create Contact from jsonObject
    * */
    public contact(JSONObject jsonObjectContact)
    {
        try
        {
            this.firstName = jsonObjectContact.optString("fn");
            this.lastName = jsonObjectContact.optString("ln");
            this.message = jsonObjectContact.optString("message");
            this.username = jsonObjectContact.optString("friend");
            this.photoUri = jsonObjectContact.optString("avatar");
            this.completename = this.firstName + " " + this.lastName;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    // Used in Newmessage page for contact list
    public contact(String id, String completename, String username, String number, String message, String joinedDate, String photoUri, String key)
    {
        this.id = (id == null) ? "" : id;
        this.completename = (completename == null) ? "" : completename;
        this.PhoneNumber = (number == null) ? "" : number;
        this.message = message;
        this.joinedDate = joinedDate;
        this.username = username;
        this.sortKey = (key == null) ? "" : key;
        this.photoUri = (photoUri == null) ? "" : photoUri;

    }

    // Updated database
    public contact(String id, String completename, String firstName, String lastName, String joinedDate, String noOfContacts, String Circles, String photoUri, int is_block,
                   String ContactList,
                   String message, int show, String username, String PhoneNumber, String sortKey, int is_mcrcl)
    {
        this.id = (id == null) ? "" : id;
        this.completename = (completename == null) ? "" : completename;
        this.firstName = (firstName == null) ? "" : firstName;
        this.lastName = (lastName == null) ? "" : lastName;
        this.joinedDate = (joinedDate == null) ? "" : joinedDate;
        this.noOfContacts = (noOfContacts == null) ? "" : noOfContacts;
        this.Circles = (Circles == null) ? "" : Circles;
        this.photoUri = (photoUri == null) ? "" : photoUri;
        this.is_block = is_block;
        this.ContactList = (ContactList == null) ? "" : ContactList;
        this.message = (message == null) ? "" : message;
        this.show = show;
        this.username = (username == null) ? "" : username;
        this.PhoneNumber = (PhoneNumber == null) ? "" : PhoneNumber;
        this.sortKey = (sortKey == null) ? "" : sortKey;
        this.is_my_circle = is_mcrcl;
    }
}
