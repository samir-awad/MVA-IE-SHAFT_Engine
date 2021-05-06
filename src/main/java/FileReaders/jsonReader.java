package FileReaders;

import com.shaft.tools.io.JSONFileManager;

public class jsonReader {
    private static JSONFileManager users;

    public static String getUserName(String user) {
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String username = users.getTestData(user);
        return username;
    }

    public static String getPassword(String pass) {
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "users.json");
        String password = users.getTestData(pass);
        return password;
    }
}
