package com.json;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.json.util.Constants;
import com.json.util.Utils;

public class Validate003 extends Validator {

	public void validate003JSON() {
		Validate002 validator002 = new Validate002();
		if (jsondef != null) {
			// writer def
			validateWriterDefStructure();
			// file structure
			validateFileStructure_002_003_005();
			// file cfg
			validateFileConfigStructure002_003_005();
			// validation
			validateValidationStructure();
			
			validator002.validateTableInsertStructure();
			errorList.addAll(getErrorList());
			
			if (errorList.size() > 0) {
				logger.info("Consolidated error messages in 001 JSON validation :");
				for (String errmsg : errorList) {
					logger.error(errmsg);
				}
			} else {
				System.out.println("003 file is valid");
			}
		}
	}

	public void validateValidationStructure() {
		try {
			JSONObject instLevelValidation = jsondef.getJSONObject(Constants.VALIDATION);
			if(validateValidationDef() && validateInstLevelValidationDef(instLevelValidation))
			{
				instLevelValidation = instLevelValidation.getJSONObject(Constants.INST_LEVEL);
				
				JSONObject cfg = instLevelValidation.getJSONObject(Constants.CFG);
				Utils util = new Utils();
				util.validateEmptyCheck(cfg, Constants.VALIDATION_INST_LEVEL_CFG_TOKENS_003);

				JSONArray defn = instLevelValidation.getJSONArray(Constants.DEFN);
				FileLevelValidation validation = new FileLevelValidation();
				validation.validateValidationDefnList(defn, Constants.VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003,
					Constants.VALIDATION_INST_LEVEL_DEFN_REQUIRED_003);

				// validate retrieve
				validateValidationRetrieveStructure(defn);
			}else
			{
				errorList.add("Inst_Level Validation not found in the json file - "+FileName);
			}
		}
			catch (JSONException e) {
				e.printStackTrace();
				logger.error(e.getLocalizedMessage() +" in the json file - "+FileName);
			}
		}
	

	public void validateValidationRetrieveStructure(JSONArray instLevelValidation) {
		Utils util = new Utils();
		for (int index = 0; index < instLevelValidation.length(); index++) {
			try {
				JSONObject defn = instLevelValidation.getJSONObject(index);
				Iterator<?> keys = defn.keys();
				while (keys.hasNext()) {
					String defnItemName = (String) keys.next();
					if (defnItemName.equals(Constants.MIN_DEF) || defnItemName.equals(Constants.MAX_DEF)
							|| defnItemName.equals(Constants.VALUE_CHK)) {
						Object defnObj = defn.get(defnItemName);
						if (defnObj instanceof JSONObject) {
							JSONObject retrieve = ((JSONObject) defnObj).getJSONObject(Constants.RETRIEVE);
							util.validateEmptyCheck(retrieve, Constants.VALIDATION_INST_LEVEL_DEFN_RETRIEVE_TOKENS_003);
						}else if (defnObj instanceof JSONArray) {
							JSONArray defnArr = (JSONArray) defnObj;
							for(int index1 = 0; index1 < defnArr.length(); index1++){
								JSONObject retrieve = defnArr.getJSONObject(index1).getJSONObject(Constants.RETRIEVE);
								util.validateEmptyCheck(retrieve, Constants.VALIDATION_INST_LEVEL_DEFN_RETRIEVE_TOKENS_003);
							}
						}
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		errorList.addAll(util.errorList);
	}

}
