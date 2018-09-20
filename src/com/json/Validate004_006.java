package com.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.json.util.Constants;
import com.json.util.Utils;

public class Validate004_006 extends Validator {

	public void validate004JSON() {
		validateFileStructure004_006();
		validateFileConfigStructure004_006();
		validateDeriveStructure004_006();
		if(errorList.size()>0){
			logger.info("Consolidated error messages in 004 JSON validation :");
			for (String errmsg : errorList) {
				logger.error(errmsg);
			}
		}
	}

	public boolean validateFileStructure004_006() {
		Validate001 validator = new Validate001();
		try {
			Utils util = new Utils();
			JSONArray fileStructure = jsondef.getJSONArray(Constants.FILE_STRUCTURE);
			ArrayList<Integer> seqList = new ArrayList<Integer>();
			if (ValidateFileStruc()) {
				int size = fileStructure.length();
				for (int index = 0; index < size; index++) {
					JSONObject field = fileStructure.getJSONObject(index);
					util.validateEmptyCheck(field, Constants.FILE_STRUC_TOKENS_004_006);
					validator.validateFileStructureFields(field, seqList);
					validateFileStructureRetrieve004_006(field);
				}
			} else {
				errorList.add("File structure config does not exists in the JSON file");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add("File structure config does not exists in the JSON file");
			return false;
		} finally {
			errorList.addAll(validator.errorList);
		}
		return true;
	}

	public void validateFileStructureRetrieve004_006(JSONObject defn) {
		Utils util = new Utils();
		JSONObject retrieve;
		try {
			retrieve = defn.getJSONObject(Constants.RETRIEVE);
			util.validateEmptyCheck(retrieve, Constants.FILE_STRUC_RETRIEVE_TOKENS);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add(e.getLocalizedMessage() + " for the json object " + defn);
		}
	}

	public boolean validateFileConfigStructure004_006() {
		try {
			Validate001 validator = new Validate001();
			Utils util = new Utils();
			JSONObject fileConfig = jsondef.getJSONObject(Constants.FILE_CONFIG);
			if (validator.validateFileCfg()) {
				util.validateEmptyCheck(fileConfig, Constants.FILE_CONFIG_TOKENS_004);
				validateFileConfigFields004_006(fileConfig);
			} else {
				errorList.add("FILE_CONFIG does not exist in the JSON file");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
		}
		return true;
	}

	public boolean validateFileConfigFields004_006(JSONObject field) {
		// validate seq
		boolean status = true;
		Utils util = new Utils();
		try {
			String extn = field.getString(Constants.EXTN);
			if (!util.validatePossibleValues(Constants.POSSIBLE_EXTN_VALUES, extn)) {
				// logger.error("Invalid extn value "+ extn +" configured for
				// JSON array - "+field);
				errorList.add("Invalid EXTN value :" + extn + " configured for JSON array - " + field);
			}

			String hasHeader = String.valueOf(field.getBoolean(Constants.HAS_HEADER));
			if (!util.validatePossibleValues(Constants.POSSIBLE_HAS_HEADER_VALUES, hasHeader)) {
				errorList.add("Invalid NEED_HEADER value :" + hasHeader + " configured for JSON array - " + field);
			}

			Object maxRecCount = field.get(Constants.MAX_RECORD_COUNT);
			if (!(maxRecCount instanceof Integer)) {
				// logger.error("SEQ value :"+ seqObj+" is not an integer value
				// for the JSON array - "+field);
				errorList.add("MAX_RECORD_COUNT value :" + maxRecCount
						+ " is not an integer value for the JSON array - " + field);
				return false;
			}

			Object maxFileSize = field.get(Constants.MAX_FILE_SIZE);
			if (!(maxFileSize instanceof Integer)) {
				// logger.error("SEQ value :"+ seqObj+" is not an integer value
				// for the JSON array - "+field);
				errorList.add("MAX_FILE_SIZE value :" + maxFileSize + " is not an integer value for the JSON array - "
						+ field);
				return false;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage() + "for the JSON array - " + field);
			errorList.add(e.getLocalizedMessage() + "for the JSON array - " + field);
		}
		return status;
	}

	public void validateDeriveStructure004_006() {
		try {
			Utils util = new Utils();
			Validate001 validator = new Validate001();
			JSONArray deriveList = jsondef.getJSONArray(Constants.DERIVE);
			if (validator.validateDerive()) {
				int size = deriveList.length();
				for (int index = 0; index < size; index++) {
					JSONObject derive = deriveList.getJSONObject(index);
					util.validateEmptyCheck(derive, Constants.DERIVE_TOKENS_004);
					validateFileStructureRetrieve004_006(derive);
				}
			} else {
				errorList.add("Derive Structure configuration does not exist in the JSON file");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add(e.getLocalizedMessage());
		}
	}

}
