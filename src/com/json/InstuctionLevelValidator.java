package com.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.json.util.Constants;
import com.json.util.Utils;

public class InstuctionLevelValidator extends Validate002{
	
	
	public void validateInstLevelValidation(JSONObject validationFileLevelConfig) {
		try {
			if (validateInstLevelCFGValidation(validationFileLevelConfig)) {
				JSONObject cfg = validationFileLevelConfig.getJSONObject(Constants.CFG);
				validateInstLevelValidationCfg(cfg);
				JSONArray defn = validationFileLevelConfig.getJSONArray(Constants.DEFN);
				validateFileLevelValidationDefn(defn);
			} else {
				logger.error("INST_CONFIG does not exist in the JSON file");
				errorList.add("INST_CONFIG does not exist in the JSON file");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean validateInstLevelValidationCfg(JSONObject fileLevelCfg) {
		Utils util = new Utils();
		util.validateEmptyCheck(fileLevelCfg, Constants.VALIDATION_INST_LEVEL_CFG_TOKENS_002);
		return true;
	}
	
	public void validateFileLevelValidationDefn(JSONArray fileLevelDefn) {
		FileLevelValidation fileLevel = new FileLevelValidation();
		fileLevel.validateValidationDefnList(fileLevelDefn, Constants.VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_002,
				Constants.VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_002_REQUIRED);
	}

	
	public boolean validateInstLevelCFGValidation(JSONObject instLevelcfg) throws JSONException
	{
		return !instLevelcfg.isNull(Constants.CFG) && (instLevelcfg.getJSONObject(Constants.CFG).length()>0);
	}
	
	public boolean validateInstLevelDEFN(JSONObject instLeveldefn) throws JSONException
	{
		return !instLeveldefn.isNull(Constants.DEFN) && (instLeveldefn.getJSONObject(Constants.DEFN).length()>0);
	} 

	
}
