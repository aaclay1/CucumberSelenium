package toolbox.JSON;

import java.util.Iterator;
import java.util.Map.Entry;
import com.fasterxml.jackson.databind.JsonNode;
import Simple.Se.GlobalVars;

public class JSONTools_Credentials extends JSONTools{
	JsonNode root;

	public void init() {
		setCurFile(GlobalVars.credentialsFile);
		loadJSON();
		root = getRoot();
	}
	
	public Entry<String, JsonNode> getCredentials(String user){
		user = utility.getValue(user);
		Iterator<Entry<String, JsonNode>> credentials = root.get(user).get(0).fields();
		return credentials.next();
	}
	
	public String getPassword(String user) {
		return getCredentials(user).getValue().textValue();
	}

	public String getUsername(String user) {
		return getCredentials(user).getKey();
	}

}
