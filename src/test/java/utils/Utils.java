package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public static int generateRandomNumber(int min, int max) {
        double randomID = Math.random() * (max - min) + min;
        return (int) randomID;

    }

    public static String generateRandomName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; // Includes letters and digits
        StringBuilder name = new StringBuilder();
        int length = 6;  // Set the length of the name as per your requirement

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            name.append(characters.charAt(index));
        }
        return name.toString();
    }

//    public static void main(String[] args) {
//        int num = generateRandomNumber(100, 500);
//        System.out.println(num);
//    }

    public static void saveUserInfo(String filepath, JSONObject jsonObject) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray=(JSONArray) jsonParser.parse(new FileReader(filepath));
        jsonArray.add(jsonObject);
        FileWriter fileWriter=new FileWriter(filepath);
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();



    }
}
