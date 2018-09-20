package com.json.util;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.json.Validate001;
import com.json.Validator;

public class Utils extends Validator{
	final static Logger logger = Logger.getLogger(Utils.class);
	Validate001 validator = new Validate001();
	public boolean validateEmptyCheck(JSONObject field,List<String> fileStrucTokens) 
	{
		for (String tokens : fileStrucTokens) {
			
			if(field.isNull(tokens)){
				logger.error(tokens +"token not present for the JSON array - "+field);
				errorList.add(tokens +"token not present for the JSON array - "+field);
			}
		}
		return true;
		
	}
	
	public boolean validatePossibleValues(List<String> possibleValueList, String value)
	{
		for(String str: possibleValueList) {
		    if((str.trim().equalsIgnoreCase(value)))
		    	return true;
		}
		return false;
	}
}
