package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);


        System.out.println("Please enter the 5 digit zip code of where you are looking");
        int zipCode = scan.nextInt();
        System.out.println("Please enter the year (2011-2017).");
        int year = scan.nextInt();
        System.out.println("Please enter the month (1-12).");
        int month = scan.nextInt();
        System.out.println("Please enter the day (1-31)");
        int day = scan.nextInt();

        URL myURL = null;
        try {
            myURL = new URL("https://www.weatherforyou.com/reports/index.php?config=&forecast=pass&pass=archive&pands="
                    + Integer.toString(zipCode) + "&zipcode=" + Integer.toString(zipCode) + "&place=&state=&country=us&county=&icao=" +
                    "&hwvMetarIcao=&zone=&cwa=RNK&month=" + Integer.toString(month) + "&day=" + Integer.toString(day) + "&year="
                    + Integer.toString(year));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(
                new InputStreamReader(myURL.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();


    }
}
