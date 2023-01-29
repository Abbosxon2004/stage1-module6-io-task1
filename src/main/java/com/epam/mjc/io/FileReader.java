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
                if (str.contains("Name")) profile.setName(str.substring(index + 2));
                else if (str.contains("Age")) profile.setAge(Integer.parseInt(str.substring(index + 2)));
                else if (str.contains("Email")) profile.setEmail(str.substring(index + 2));
                else if (str.contains("Phone")) profile.setPhone(Long.valueOf(str.substring(index + 2)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Profile(profile.getName(), profile.getAge(), profile.getEmail(), profile.getPhone());
    }
}
