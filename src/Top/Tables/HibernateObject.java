package Top.Tables;

import org.json.simple.JSONObject;

public interface HibernateObject {
	void save();
	JSONObject toJSON();
}
