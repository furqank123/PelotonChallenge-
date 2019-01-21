package Utils;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class TestDataUtil {

    private static final String PELOTON_URLS = "pelotonUrls";
    private static final String URLS = "urls";
    private static final String EMAILS = "emails";
    private static final String VALID_LOGIN = "validLogIn";
    private static final String INVALID_LOGIN = "invalidLogIn";
    private static final String PASSWORDS = "passwords";
    private static final String VALID_PASSWORDS = "validPasswords";
    private static final String INVALID_PASSWORDS = "invalidPassword";

    public TestData retrieveHomePage(){
        return getDataFromJSON(URLS, PELOTON_URLS);
    }

    public TestData retrieveValidLogIn(){
        return getDataFromJSON(EMAILS, VALID_LOGIN);
    }

    public TestData retrieveInvalidLogIn(){
        return getDataFromJSON(EMAILS, INVALID_LOGIN);
    }

    public TestData retrieveValidPasswords(){
        return getDataFromJSON(PASSWORDS, VALID_PASSWORDS);
    }

    public TestData retrieveInvalidPasswords(){
        return getDataFromJSON(PASSWORDS, INVALID_PASSWORDS);
    }

    private String loadJSONFromResource(String fileName){
        String json;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getPath()));
            StringBuilder stringBuilder = new StringBuilder();
            String readLine = bufferedReader.readLine();
            while(readLine != null){
                stringBuilder.append(readLine);
                readLine = bufferedReader.readLine();
            }
            json = stringBuilder.toString();
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

    private TestData getDataFromJSON(String tag, String type) {
        TestData testData = new TestData();
        Gson gson = new Gson();
        String data = loadJSONFromResource("TestData.json");
        try {
            JSONObject dataObject = new JSONObject(data);
            JSONObject objectTag = dataObject.getJSONObject(tag);
            String objectInfo = objectTag.optString(type);
            testData = gson.fromJson(objectInfo,TestData.class);
        } catch(JSONException e){
            e.printStackTrace();
        }
        return testData;
    }
}
