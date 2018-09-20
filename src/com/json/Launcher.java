package com.json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.json.util.Constants;


public class Launcher {
	final static Logger logger = Logger.getLogger(Launcher.class);
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("press 1 for 001-json validation");
		System.out.println("press 2 for 002-json validation");
		System.out.println("press 3 for 003-json validation");
		System.out.println("press 4 for 004-json validation");
		System.out.println("press 5 for 005-json validation");
		System.out.println("press 6 for 006-json validation");
		System.out.println("press 7 for 007-json validation");
		
		// read file locations
		ResourceBundle appProp = ResourceBundle.getBundle(Constants.APPLICATION_PROPERTY);
		
		String input = scanner.next();
		int ans = Integer.parseInt(input);
		String fileName = "";
		switch(ans)
		{
		
			case 1 :fileName = appProp.getString(Constants.FILE_LOC_001);
					Validator.jsondef = readJsonFile(fileName);
					Validate001 validation001 = new Validate001();
					validation001.validate001JSON();
					break;
					
			case 2 :fileName = appProp.getString(Constants.FILE_LOC_002);
					Validator.jsondef = readJsonFile(fileName);
					Validate002 validation002 = new Validate002();
					validation002.validate002JSON();
					break;
			
			case 3 :fileName = appProp.getString(Constants.FILE_LOC_003);
					Validator.jsondef = readJsonFile(fileName);
					Validate003 validation003 = new Validate003();
					validation003.validate003JSON();
					break;
			
			case 4 :fileName = appProp.getString(Constants.FILE_LOC_004);
					Validator.jsondef = readJsonFile(fileName);
					Validate004_006 validation004 = new Validate004_006();
					validation004.validate004JSON();
					break;
			
			case 5 :fileName = appProp.getString(Constants.FILE_LOC_005);
					Validator.jsondef = readJsonFile(fileName);
					Validate005 validation005 = new Validate005();
					validation005.validate005JSON();
					break;
			
			case 6 :fileName = appProp.getString(Constants.FILE_LOC_006);
					Validator.jsondef = readJsonFile(fileName);
					Validate006_notneed validation006 = new Validate006_notneed();
					validation006.validate006JSON();
					break;
			
			default : System.out.println("Invalid input");
					
				
		}
		scanner.close();
	}
	
	public static JSONObject readJsonFile(String file){
		String text = null;
		JSONObject obj = null;
		try {
			text = new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Reading file failed");
			e.printStackTrace();
			return obj;
		}
		logger.info("Loaded 001 validation file");
		JSONTokener tokener = new JSONTokener(text.trim());
		try {
			obj = new JSONObject(tokener);
		} catch (JSONException e) {
			e.printStackTrace();
			logger.info("JSON format error - "+e.getLocalizedMessage());
		}
		return obj;
	}
}
