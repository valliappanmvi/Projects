package com.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.json.util.Constants;
import com.json.util.Utils;

public class FileLevelValidation extends Validate002 {

	

	public void validateFileLevelValidation(JSONObject validationFileLevelConfig) {
		try {
			if (validateFileLevelCfgValidationDef(validationFileLevelConfig)) {
				JSONObject cfg = validationFileLevelConfig.getJSONObject(Constants.CFG);
				validateFileLevelValidationCfg(cfg);
				JSONArray defn = validationFileLevelConfig.getJSONArray(Constants.DEFN);
				validateFileLevelValidationDefn(defn);
			} else {
				logger.error("FILE_CONFIG does not exist in the JSON file");
				errorList.add("FILE_CONFIG does not exist in the JSON file");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean validateFileLevelValidationCfg(JSONObject fileLevelCfg) {
		Utils util = new Utils();
		util.validateEmptyCheck(fileLevelCfg, Constants.VALIDATION_FILE_LEVEL_CFG_TOKENS);
		return true;
	}

	public void validateFileLevelValidationDefn(JSONArray fileLevelDefn) {
		validateValidationDefnList(fileLevelDefn, Constants.VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS,
				Constants.VALIDATION_FILE_LEVEL_DEFN_REQUIRED);
	}

	public void validateValidationDefnList(JSONArray validationDefn, HashMap<String, ArrayList<String>> defnMap,
			List<String> requiredDefn) {
		int size = validationDefn.length();
		ArrayList<String> defnList = new ArrayList<String>();
		Utils util = new Utils();

		for (int index = 0; index < size; index++) {
			try {
				JSONObject defnObj = validationDefn.getJSONObject(index);
				Iterator<?> keys = defnObj.keys();
				while (keys.hasNext()) {
					String defnItemName = (String) keys.next();
					defnList.add(defnItemName);

					if (defnMap.containsKey(defnItemName)) {
						List<String> defnItemTokens = defnMap.get(defnItemName);
						if (defnObj.get(defnItemName) instanceof JSONObject) {
							if (!util.validateEmptyCheck((JSONObject) defnObj.get(defnItemName), defnItemTokens)) {
								logger.error("Token missing in DEFN with key value - " + defnItemTokens);
								errorList.add("Token missing in DEFN with key value - " + defnItemTokens);
							}
						} else if (defnObj.get(defnItemName) instanceof JSONArray) {
							JSONArray defnItemArr = (JSONArray) defnObj.get(defnItemName);
							for (int arrIndex = 0; arrIndex < defnItemArr.length(); arrIndex++) {
								if (!util.validateEmptyCheck((JSONObject) defnItemArr.get(arrIndex), defnItemTokens)) {
									logger.error("Token missing in DEFN with key value - " + defnItemTokens);
									errorList.add("Token missing in DEFN with key value - " + defnItemTokens);
								}
							}
						} else {
							logger.error("Wrong format for DEFN with key value - " + defnItemName);
							errorList.add("Wrong format for DEFN with key value - " + defnItemName);
						}
					}
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!defnList.containsAll(requiredDefn)) {
			logger.error("Required validation check missing in DEFN");
			errorList.add("Required validation check missing in DEFN");
		}
	}

	public boolean validateFileCfgDef() throws JSONException {
		return !jsondef.isNull(Constants.FILE_CONFIG) && (jsondef.getJSONObject(Constants.FILE_CONFIG).length() > 0);
	}

	public boolean validateFileLevelValidationDef(JSONObject validationFileLevelConfig) throws JSONException {
		return !validationFileLevelConfig.isNull(Constants.FILE_LEVEL) && (validationFileLevelConfig.getJSONObject(Constants.FILE_LEVEL).length() > 0);
	}
	
	public boolean validateFileLevelCfgValidationDef(JSONObject validationFileLevelConfig) throws JSONException {
		return !validationFileLevelConfig.isNull(Constants.CFG) && (validationFileLevelConfig.getJSONObject(Constants.CFG).length() > 0);
	}
}
