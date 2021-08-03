package FileReaders;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class GetUserFromJson {

	public static String getUsername(String userType) throws IOException, ParseException {
		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("username").toString());
		return username.get("username").toString();
	}

	public static String getpassword(String userType) throws IOException, ParseException {
		JSONObject userObj = (JSONObject) JsonParser.parseJson("users/users.json");
		JSONObject username = (JSONObject) userObj.get(userType);

		System.out.println(username.get("password").toString());
		return username.get("password").toString();
	}

}
