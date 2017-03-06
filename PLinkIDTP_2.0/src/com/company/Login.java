package com.company;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;


/**
 * Created by chris.scites on 3/6/2017.
 */
public class Login {
    URL loginURL = new URL("https://admin.practicelink.com/MyAccount/Login.aspx?urlPath=https://admin.practicelink.com/default.aspx");
    Scanner scanner = new Scanner(System.in);
    private String email;
    private String password;

    public Login() throws IOException {
        setEmail();
        setPassword();
        URLConnection myURLConnection = loginURL.openConnection();
        myURLConnection.connect();





    }



    public void setEmail(){
        System.out.println("Please enter login email.");
        email = scanner.nextLine();
    }

    public void setPassword(){
        System.out.println("Please enter your password.");
        password = scanner.nextLine();
    }
}
