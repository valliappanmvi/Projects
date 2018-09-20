package com.json;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.json.util.Constants;
import com.json.util.Utils;

public class Validate005 extends Validator {

	public void validate005JSON() {
		Validate001 validator = new Validate001();
		if (jsondef != null) {
			validator.validateFileStructure();
			validator.validateFileConfigStructure();
			validateValidationStructure();
			validateDeriveStructure();
			validateTableInsertStructure();
			
			// consolidate error message
			errorList.addAll(validator.errorList);
			if (errorList.size() > 0) {
				logger.info("Consolidated error messages in 001 JSON validation :");
				for (String errmsg : errorList) {
					logger.error(errmsg);
				}
			}
		}
	}

	public void validateValidationStructure() {
		try {
			JSONObject instLevelValidation = jsondef.getJSONObject(Constants.VALIDATION)
					.getJSONObject(Constants.INST_LEVEL);

			JSONObject cfg = instLevelValidation.getJSONObject(Constants.CFG);
			FileLevelValidation validator = new FileLevelValidation();
			validator.validateFileLevelValidationCfg(cfg);

			JSONArray defn = instLevelValidation.getJSONArray(Constants.DEFN);
			validateInstLevelValidationDefn(defn);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
		}

	}

	public void validateInstLevelValidationDefn(JSONArray instLevelValidation) {
		FileLevelValidation validator = new FileLevelValidation();
		Utils util = new Utils();
		validator.validateValidationDefnList(instLevelValidation, Constants.VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_005,
				Constants.VALIDATION_INST_LEVEL_DEFN_REQUIRED_005);
		// Validation for Derive
		for (int index = 0; index < instLevelValidation.length(); index++) {
			try {
				JSONObject defnObj = instLevelValidation.getJSONObject(index);
				Iterator<?> keys = defnObj.keys();
				while (keys.hasNext()) {
					String defnItemName = (String) keys.next();
					if (defnItemName.equals(Constants.CUSTOM_CASE)) {
						JSONArray custCaseDerive = defnObj.getJSONObject(Constants.CUSTOM_CASE)
								.getJSONArray(Constants.RETRIEVE);
						for (int index1 = 0; index1 < custCaseDerive.length(); index1++) {
							util.validateEmptyCheck(custCaseDerive.getJSONObject(index1),
									Constants.VALIDATION_INST_LEVEL_DEFN_CUST_CASE_RETRIEVE_TOKENS);
						}
					}
					if (defnItemName.equals(Constants.SDAPI)) {
						JSONArray sdapiDerive = defnObj.getJSONObject(Constants.SDAPI)
								.getJSONArray(Constants.RETRIEVE);
						for (int index2 = 0; index2 < sdapiDerive.length(); index2++) {
							util.validateEmptyCheck(sdapiDerive.getJSONObject(index2),
									Constants.VALIDATION_INST_LEVEL_DEFN_SDAPI_RETRIEVE_TOKENS);
						}
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean validateDeriveStructure() {
		Validate001 validator = new Validate001();
		try {
			Utils util = new Utils();
			JSONArray fileStructure = jsondef.getJSONArray(Constants.DERIVE);
			ArrayList<Integer> seqList = new ArrayList<Integer>();
			if (validator.validateDerive()) {
				int size = fileStructure.length();
				for (int index = 0; index < size; index++) {
					JSONObject field = fileStructure.getJSONObject(index);
					util.validateEmptyCheck(field, Constants.DERIVE_TOKENS);
				}
			} else {
				errorList.add("Derive Structure configuration does not exist in the JSON file");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add(e.getLocalizedMessage());
		}
		return true;
	}

	public void validateTableInsertStructure() {
		Validate001 validator = new Validate001();
		try {
			JSONArray tableInsert = jsondef.getJSONArray(Constants.TBL_INSERT);
			ArrayList<String> tables = new ArrayList<String>();
			if (validator.validateTblInsert()) {
				int size = tableInsert.length();
				for (int index = 0; index < size; index++) {
					JSONObject insert = tableInsert.getJSONObject(index);
					validateTableInsertFields(insert, tables);
				}
				if (!tables.contains(Constants.REJECTED_INST)) {
					errorList.add("No TBLINSERT entry for " + Constants.REJECTED_INST);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add("No Table insert inside JSON");
		}
	}

	public boolean validateTableInsertFields(JSONObject tableInsert, ArrayList<String> tableList) {
		Validate001 validator = new Validate001();
		// check for columns
		try {
			Utils util = new Utils();
			JSONArray columnList = tableInsert.getJSONArray(Constants.COLUMNS);
			for (int columnIndex = 0; columnIndex < columnList.length(); columnIndex++) {
				JSONObject column = columnList.getJSONObject(columnIndex);
				util.validateEmptyCheck(column, Constants.TBL_INSERT_TOKENS);
			}

		} catch (JSONException e) {
			errorList.add(e.getLocalizedMessage());
		}
		// check for CFG
		try {
			JSONObject cfg = tableInsert.getJSONObject(Constants.CFG);
			validator.validateTableInsertFieldTBLRef(cfg, tableList);
		} catch (JSONException e) {
			e.printStackTrace();
			errorList.add("TBLINSERT Token CFG is missing");
		}
		return true;
	}

}
