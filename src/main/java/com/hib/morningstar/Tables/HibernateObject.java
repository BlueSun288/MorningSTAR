package com.hib.morningstar.Tables;

import org.json.simple.JSONObject;

public interface HibernateObject {
	void save();
	JSONObject toJSON();
}
