package com.json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonValidation {
	
	public static JSONObject readJson(String fileName){
		String text = null;
		try {
			text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Reading file failed");
			return null;
		}
		
		// convert text string to json array
		JSONTokener tokener = new JSONTokener(text.trim());
		try {
			JSONObject json = new JSONObject(tokener);
			return json;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean checkMandatoryField(JSONObject json, String field){
		return !json.isNull(field);
	}
	
	
	public static boolean checkMandatoryField(JSONArray jsonArr, String field){
		for(int index = 0; index < jsonArr.length(); index++){
			JSONObject json = null;
			try {
				json = jsonArr.getJSONObject(index);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!checkMandatoryField(json, field))
				return false;
		}
		return true;
	}
	
	public static boolean checkJsonArray(JSONArray jsonArr){
		return (jsonArr != null) && (jsonArr.length() > 0);
	}
	
	public static boolean checkIntegerType(JSONObject json, String field){
		Object obj;
		try {
			obj = json.get(field);
			return obj instanceof Integer;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean checkIntegerType(JSONArray jsonArr, String field){
		for(int index = 0; index < jsonArr.length(); index++){
			JSONObject json = null;
			try {
				json = jsonArr.getJSONObject(index);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!checkIntegerType(json, field))
				return false;
		}
		return true;
	}
}
