package validators;

import interfaces.Validator;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonStringValidator implements Validator<String> {
	@Override
	public boolean isValid(String value) {
		try {
			new JSONObject(value);
			return true;
		} catch (JSONException ex) {
//			ex.printStackTrace();
			return false;
		}
	}
}
