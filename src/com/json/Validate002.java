package com.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.json.util.Constants;
import com.json.util.Utils;

public class Validate002 extends Validator{
	
	public void validate002JSON() {
		if (jsondef != null) {
			validateWriterDefStructure();
			validateFileStructure_002_003_005();
			validateFileConfigStructure002_003_005();
			ValidateValidationStructure();
			validateTableInsertStructure();

			// consolidate errors detected using Validate 001
			errorList.addAll(errorList);
			if (errorList.size() > 0) {
				logger.info("Consolidated error messages in 001 JSON validation :");
				for (String errmsg : errorList) {
					logger.error(errmsg);
				}
			} else {
				System.out.println("002 file is valid.");
			}
		}
	}
	
	public void ValidateValidationStructure() {
		FileLevelValidation fileInsValidation = new FileLevelValidation();
		InstuctionLevelValidator insValidator = new InstuctionLevelValidator();
		try {
			Utils util = new Utils();
			JSONObject validationLevelJson = jsondef.getJSONObject(Constants.VALIDATION);
				if(validateValidationDef()){
						util.validateEmptyCheck(validationLevelJson, Constants.VALIDATION_TOKENS);
						if(fileInsValidation.validateFileLevelValidationDef(validationLevelJson))
							fileInsValidation.validateFileLevelValidation(validationLevelJson.getJSONObject(Constants.FILE_LEVEL));
						else
						{
							logger.error("FILE_LEVEL token CONFIG does not exist in the JSON file");
							errorList.add("FILE_LEVEL token CONGIF does not exist in the JSON file");
						}
						errorList.addAll(fileInsValidation.getErrorList());
						if(insValidator.validateInstLevelValidationDef(validationLevelJson))
							insValidator.validateInstLevelValidation(validationLevelJson.getJSONObject(Constants.INST_LEVEL));
						else
						{
							logger.error("INST_LEVEL token CONFIG does not exist in the JSON file");
							errorList.add("INST_LEVEL token CONGIF does not exist in the JSON file");
						}
						errorList.addAll(insValidator.getErrorList());
				}else
				{
					logger.error("VALIDATION token does not exist in the JSON file");
					errorList.add("VALIDATION token does not exist in the JSON file");
				}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean validateInstLevelDef(JSONObject instLevel) throws JSONException
	{
		return !instLevel.isNull(Constants.INST_LEVEL) && (instLevel.getJSONObject(Constants.INST_LEVEL).length()>0);
	}
	
	public boolean validateFileLevelDef(JSONObject instLevel) throws JSONException
	{
		return !jsondef.isNull(Constants.FILE_LEVEL) && (jsondef.getJSONObject(Constants.FILE_LEVEL).length()>0);
	}
	
	public void validateTableInsertStructure(){
		try {
			JSONArray tableInsert = jsondef.getJSONArray(Constants.TBL_INSERT);
			if(validateTableInsert()){
				for(int index = 0; index < tableInsert.length(); index ++){
					JSONObject insert = tableInsert.getJSONObject(index);
					validateTableInsertFields(insert);
				}
			}else{
				logger.error("TBL_INSERT token does not exist in the JSON file");
				errorList.add("TBL_INSERT token does not exist in the JSON file");
			}
		} catch (JSONException e) {
			errorList.add(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	
	public void validateTableInsertFields(JSONObject insert){
		try {
			JSONObject cfg = insert.getJSONObject(Constants.CFG);
			validateTableInsertCfg(cfg);
			
			if(validateTableInsertColumns(insert)){
				JSONArray columns = insert.getJSONArray(Constants.COLUMNS);
				validateTableInsertColumns(columns);
			}else{
				errorList.add("COLUMNS is empty for the JSON object " + insert);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add(e.getLocalizedMessage());
		}
	}
	
	public void validateTableInsertCfg(JSONObject cfg){
		Utils util = new Utils();
		util.validateEmptyCheck(cfg, Constants.TBL_INSERT_CFG_TOKENS_002);
		errorList.addAll(util.errorList);
		
//		if(cfg.isNull(Constants.TBL_REF))
//			errorList.add("TBL token is null for JSON object " + cfg.toString());
	}
	
	public void validateTableInsertColumns(JSONArray columns){
		Utils util = new Utils();
		try{
			for(int index = 0; index < columns.length(); index ++){
				JSONObject column = columns.getJSONObject(index);
				util.validateEmptyCheck(column, Constants.TBL_INSERT_COLUMNS_TOKENS_002);
				
				String source = column.getString(Constants.SOURCE);
				if(!util.validatePossibleValues(Constants.POSSIBLE_SOURCE_VALUES_002, source))
					errorList.add("Invalid SOURCE value: " + source + " configured for JSON array - " + column);
				
				String dataType = column.getString(Constants.DATA_TYPE);
				if(!util.validatePossibleValues(Constants.POSSIBLE_DATA_TYPE_VALUES_002, dataType))
					errorList.add("Invalid DATA_TYPE value: " + dataType + " configured for JSON array - " + column);
				
				if(!column.isNull(Constants.PRECISION)){
					Object precision = column.get(Constants.PRECISION);
					if(!(precision instanceof Integer)){
						errorList.add("PRECISION value: " + precision + " is not an integer value for the JSON array - " + column);
					}
				}
				
				if(!column.isNull(Constants.SCALE)){
					Object scale = column.get(Constants.SCALE);
					if(!(scale instanceof Integer)){
						errorList.add("SCALE value: " + scale + " is not an integer value for the JSON array - " + column);
					}
				}
				
				if(!column.isNull(Constants.ENCRYPTED)){
					String encrypted = String.valueOf(column.getBoolean(Constants.ENCRYPTED));
					util.validatePossibleValues(Constants.POSSIBLE_HAS_HEADER_VALUES, encrypted);
				}
			}
		}catch(JSONException e){
			e.printStackTrace();
			errorList.add(e.getLocalizedMessage());
		}finally{
			errorList.addAll(util.errorList);
		}
	}
	
	public boolean validateTableInsert() throws JSONException {
		return !jsondef.isNull(Constants.TBL_INSERT) && (jsondef.getJSONArray(Constants.TBL_INSERT).length() > 0);
	}
	
	public boolean validateTableInsertColumns(JSONObject insert) throws JSONException {
		return !insert.isNull(Constants.COLUMNS) && (insert.getJSONArray(Constants.COLUMNS).length() > 0);
	}
	
	
	
}