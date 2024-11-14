package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.WebDriver;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

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
    public static void getToken(WebDriver driver) throws IOException {
        //wait until the authToken is available
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until((ExpectedCondition<Boolean>) wd -> js.executeScript("return window.localStorage.getItem('authToken')") != null);

        //get the authToken from the localstorage
        String authToken = (String) js.executeScript("return window.localStorage.getItem('authToken');");
        System.out.println("Auth Token Retrieved: " + authToken);

        // Save the auth token to a localstorage.json file
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("authToken", authToken);
        FileWriter writer=new FileWriter("./src/test/resources/localstorage.json");
        writer.write(jsonObject.toJSONString());
        writer.flush();
        writer.close();
    }
    public static void setAuth(WebDriver driver) throws ParseException, InterruptedException, IOException {
        JSONParser jsonParser=new JSONParser();
        JSONObject authObj= (JSONObject) jsonParser.parse(new FileReader("./src/test/resources/localstorage.json"));
        String authToken= authObj.get("authToken").toString();
        System.out.println(authToken);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.setItem('authToken', arguments[0]);", authToken);
        Thread.sleep(2000);
    }


}
