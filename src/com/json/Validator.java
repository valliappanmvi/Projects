package com.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.json.util.Constants;
import com.json.util.Utils;

public class Validator {
	final static Logger logger = Logger.getLogger(Validate001.class);
	public List<String> errorList = new ArrayList<String>();
	public static JSONObject jsondef;
	public static String FileName;
	public List<String> getErrorList()
	{
		return errorList;
	}

	//########### Writer DEF ###################
	public void validateWriterDefStructure() {
		try {
			Utils util = new Utils();
			JSONObject writerDefConfig = jsondef.getJSONObject(Constants.WRITER_DEF);
			if (validateWriterDef(jsondef)) {
				util.validateEmptyCheck(writerDefConfig, Constants.WRITERDEF_TOKENS);
				validateWriterDefFields(writerDefConfig);
			} else {
				logger.error("WRITER_DEF config does not exist in the JSON file - "+FileName);
				errorList.add("WRITER_DEF config does not exist in the JSON file - "+FileName);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public boolean validateWriterDefFields(JSONObject field) {
		boolean status = true;
		Utils util = new Utils();
		try {
			String type = field.getString(Constants.TYPE);
			if (!util.validatePossibleValues(Constants.POSSIBLE_WRITERDEF_VALUES, type)) {
				errorList.add("Invalid TYPE value :" + type + " configured for JSON array - " + field);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage() + "for the JSON array - " + field);
			errorList.add(e.getLocalizedMessage() + "for the JSON array - " + field);
		}
		return status;
	}

	public boolean validateWriterDef(JSONObject jsondef) throws JSONException {
		return !jsondef.isNull(Constants.WRITER_DEF) && (jsondef.getJSONObject(Constants.WRITER_DEF).length() > 0);
	}
	//######################################
	
	
	
	//########## File Structure Config (002,003,005) ############
	public boolean validateFileStructure_002_003_005(){
		try {
			Utils util = new Utils();
			JSONArray fileStructure = jsondef.getJSONArray(Constants.FILE_STRUCTURE);
			ArrayList<Integer> seqList = new ArrayList<Integer>();
			if(ValidateFileStruc()){
				int size = fileStructure.length();
				for(int index = 0; index < size; index++){
					JSONObject field = fileStructure.getJSONObject(index);
					util.validateEmptyCheck(field,Constants.FILE_STRUC_TOKENS_002_003_005);
					validateFileStructureFields002_003_005(field, seqList);
				}
			}else
			{
//				logger.error("File structure config does not exists in the JSON file");
				errorList.add("File structure config does not exists in the JSON file");
			}
		} catch (JSONException e) {
			e.printStackTrace();
//			logger.error("File structure config does not exists in the JSON file");
			errorList.add("File structure config does not exists in the JSON file");
			return false;
		}
		return true;
	}
	
	public boolean validateFileStructureFields002_003_005(JSONObject field, ArrayList<Integer> seqList){
		// validate seq
		try {
			Utils util = new Utils();
			Object seqObj = field.get(Constants.SEQ);
			if(!(seqObj instanceof Integer)){
				logger.error("SEQ value :"+ seqObj+" is not an integer value for the JSON array - "+field);
				errorList.add("SEQ value :"+ seqObj+" is not an integer value for the JSON array - "+field);
				return false;
			}
			int seq = field.getInt(Constants.SEQ);
			if(seqList.contains(seq)){
				logger.error("SEQ value :"+ seq+" is a duplicate value for the JSON array - "+field);
				errorList.add("SEQ value :"+ seq+" is a duplicate value for the JSON array - "+field);
				return false;
			}else
				seqList.add(seq);
			
			String sourceObj = field.getString(Constants.SOURCE);
			if(!util.validatePossibleValues(Constants.POSSIBLE_SOURCE_VALUES_002_003_005, sourceObj)){
				logger.error("Invalid source value :"+sourceObj+" in the JSON array - "+field);
				errorList.add("Invalid source value :"+sourceObj+" in the JSON array - "+field);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage() +" for the json array - "+field);
			errorList.add(e.getLocalizedMessage() +" for the json array - "+field);
		}
		return true;
	}
	
	
	public boolean ValidateFileStruc() throws JSONException{
		return !jsondef.isNull(Constants.FILE_STRUCTURE) && (jsondef.getJSONArray(Constants.FILE_STRUCTURE).length()>0);
	}
	//#############################
	
	
	//############ FILE_CFG (002,003,005) ##########
	
	public boolean validateFileConfigStructure002_003_005(){
		try {
			Utils util = new Utils();
			JSONObject fileConfig = jsondef.getJSONObject(Constants.FILE_CONFIG);
			if(validateFileCfg()){
					util.validateEmptyCheck(fileConfig,Constants.FILE_CONFIG_TOKENS_002_003_005);
					validateFileConfigFields(fileConfig);
			}else
			{
				logger.error("FILE_CONFIG does not exist in the JSON file");
				errorList.add("FILE_CONFIG does not exist in the JSON file");
			}
		} catch (JSONException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
		}
		return true;
	}
	
	public boolean validateFileConfigFields(JSONObject field){
		boolean status = true;
		try {
			String extn = field.getString(Constants.EXTN);
			Utils util = new Utils();
			if(!util.validatePossibleValues(Constants.POSSIBLE_EXTN_VALUES, extn)){
				logger.error("Invalid extn value "+ extn +" configured for JSON array - "+field);
				errorList.add("Invalid EXTN value :"+ extn +" configured for JSON array - "+field);
			}
			
			String hasHeader = String.valueOf(field.getBoolean(Constants.HAS_HEADER));
			if(!util.validatePossibleValues(Constants.POSSIBLE_HAS_HEADER_VALUES, hasHeader)){
				logger.error("Invalid HAS_HEADER value :"+ hasHeader +" configured for JSON array - "+field);
				errorList.add("Invalid HAS_HEADER value :"+ hasHeader +" configured for JSON array - "+field);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage() +"for the JSON array - "+field);
			errorList.add(e.getLocalizedMessage() +"for the JSON array - "+field);
		}
		return status;
	}
	
	public boolean validateFileCfg() throws JSONException{
		return !jsondef.isNull(Constants.FILE_CONFIG) && (jsondef.getJSONObject(Constants.FILE_CONFIG).length()>0);
	}
	
	//#####################
	
	//######### VALIDATION #########
	public boolean validateValidationDef() throws JSONException {
		return !jsondef.isNull(Constants.VALIDATION) && (jsondef.getJSONObject(Constants.VALIDATION).length() > 0);
	}
	
	public boolean validateInstLevelValidationDef(JSONObject validationInstLevelConfig) throws JSONException {
		return !validationInstLevelConfig.isNull(Constants.INST_LEVEL) && (validationInstLevelConfig.getJSONObject(Constants.INST_LEVEL).length() > 0);
	}
	
}
