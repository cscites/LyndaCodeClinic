package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by chris.scites on 3/6/2017.
 */
public class Weather {
    private int zip;
    private int year;
    private int month;
    private int date;

    URL myURL = null;
    Scanner scan = new Scanner(System.in);

    public Weather(){

        setZip();
        setYear();
        setMonth();
        setDate();

        try {
            myURL = new URL("https://www.weatherforyou.com/reports/index.php?forecast=pass&pass=archive&zipcode="
                    +Integer.toString(zip)+"&pands="+Integer.toString(zip)+"&place=&state=&icao=&country=us&month=" +
                    Integer.toString(month)+"&day="+Integer.toString(date)+"&year="+Integer.toString(year)+"&dosubmit=Go");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setZip(){
        System.out.println("Please enter a 5 digit zip code.");
        zip = scan.nextInt();
    }

    public void setYear() {
        System.out.println("Please enter the year (2011-2017).");
        year = scan.nextInt();
    }

    public void setMonth() {
        System.out.println("Please enter the month (1-12).");
        month = scan.nextInt();
    }

    public void setDate() {
        System.out.println("Please enter the day (1-31)");
        date = scan.nextInt();
    }

    public String getURL(){
        return myURL.toString();
    }

    public void showSite(){
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(myURL.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String inputLine;
        try {
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
