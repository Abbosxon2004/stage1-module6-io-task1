package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    public static void main(String[] args) {

    }

    public static Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String str = "";

            while ((str = reader.readLine()) != null) {
                int index = str.indexOf(":");
                if (str.contains("Name")) profile.setName(str.substring(index+2));
                if (str.contains("Age")) profile.setAge(Integer.parseInt(str.substring(index+2)));
                if (str.contains("Email")) profile.setEmail(str.substring(index+2));
                if (str.contains("Phone")) profile.setPhone(Long.valueOf(str.substring(index+2)));
            }
            return profile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
