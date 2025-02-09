package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String str;
            while ((str = reader.readLine()) != null) {
                int index = str.indexOf(":");
                if (str.contains("Name"))
                    profile.setName(str.substring(index + 2));
                else if (str.contains("Age"))
                    profile.setAge(Integer.parseInt(str.substring(index + 2)));
                else if (str.contains("Email"))
                    profile.setEmail(str.substring(index + 2));
                else if (str.contains("Phone"))
                    profile.setPhone(Long.parseLong(str.substring(index + 2)));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return new Profile(profile.getName(), profile.getAge(), profile.getEmail(), profile.getPhone());
    }
}
