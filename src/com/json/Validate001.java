package com.json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.json.util.Constants;
import com.json.util.Utils;


public class Validate001 extends Validator{
	
	public void validate001JSON()
	{
		if(jsondef!=null){
				validateFileStructure();
				validateFileConfigStructure();
				validateDeriveStructure();
				validateTableInsertStructure();
				if(errorList.size()>0){
					logger.info("Consolidated error messages in 001 JSON validation :");
					for (String errmsg : errorList) {
						logger.error(errmsg);
					}
				}
				else
					logger.info("File "+ FileName+" validated successfully");
		}
	
	}
	
	public boolean validateFileStructure(){
		try {
			Utils util = new Utils();
			JSONArray fileStructure = jsondef.getJSONArray(Constants.FILE_STRUCTURE);
			ArrayList<Integer> seqList = new ArrayList<Integer>();
			if(ValidateFileStruc()){
				int size = fileStructure.length();
				for(int index = 0; index < size; index++){
					JSONObject field = fileStructure.getJSONObject(index);
					util.validateEmptyCheck(field,Constants.FILE_STRUC_TOKENS_001);
					validateFileStructureFields(field, seqList);
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
	
	public boolean validateDeriveStructure(){
		try {
			Utils util = new Utils();
			JSONArray fileStructure = jsondef.getJSONArray(Constants.DERIVE);
			ArrayList<Integer> seqList = new ArrayList<Integer>();
			if(validateDerive()){
				int size = fileStructure.length();
				for(int index = 0; index < size; index++){
					JSONObject field = fileStructure.getJSONObject(index);
					util.validateEmptyCheck(field,Constants.DERIVE_TOKENS);
					validateDeriveStructureFields(field, seqList);
				}
			}else
			{
				errorList.add("Derive Structure configuration does not exist in the JSON file");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add(e.getLocalizedMessage());
		}
		return true;
	}
	
	
	public boolean validateTableInsertStructure() {
		try {
			JSONArray tableInsert = jsondef.getJSONArray(Constants.TBL_INSERT);
			ArrayList<String> tables = new ArrayList<String>();
			if (validateTblInsert()) {
				int size = tableInsert.length();
				for (int index = 0; index < size; index++) {
					JSONObject insert = tableInsert.getJSONObject(index);
					if(!validateTableInsertFields(insert, tables))
						return false;
				}
				if(!tables.contains(Constants.INST_MEM)){
					logger.error("No TBLINSERT entry for INST_MEM");
					return false;
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("No Table insert inside JSON");
			return false;
		}
		return true;
	}
	
	
	public boolean validateTableInsertFields(JSONObject tableInsert, ArrayList<String> tableList){
		// check for columns
		try {
			Utils util = new Utils();
			JSONArray columnList = tableInsert.getJSONArray(Constants.COLUMNS);
			for(int columnIndex = 0; columnIndex < columnList.length(); columnIndex ++) {
				JSONObject column = columnList.getJSONObject(columnIndex);
				util.validateEmptyCheck(column, Constants.TBL_INSERT_TOKENS);
				}
			
		} catch (JSONException e) {
			errorList.add(e.getLocalizedMessage());
		}
		//check for CFG
		try {
			JSONObject cfg = tableInsert.getJSONObject(Constants.CFG);
			validateTableInsertFieldTBLRef(cfg, tableList);
			validateTableInsertFieldGroupBy(cfg);
		}catch (JSONException e) {
			e.printStackTrace();
			errorList.add("TBLINSERT Token CFG is missing");
		}
		return true;
	}
	
	
	public boolean validateTableInsertFieldTBLRef(JSONObject cfg, ArrayList<String> tableList){
		try {
			String tableRef = cfg.getString(Constants.TBL_REF);
			tableList.add(tableRef);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add(e.getLocalizedMessage());
		}
		return true;
	}
	
	public boolean validateTableInsertFieldGroupBy(JSONObject cfg){
		try {
			Utils util = new Utils();
			String groupBy = cfg.getString(Constants.GROUP_BY);
			
			
			if(!util.validatePossibleValues(Constants.POSSIBLE_GROUP_BY_VALUES, groupBy)){
			logger.error("Invalid group_by value -"+ groupBy+" in derive config - " + cfg);
			errorList.add("Invalid group_by value -"+ groupBy+" in derive config - " + cfg);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorList.add(e.getLocalizedMessage());
			logger.error(e.getLocalizedMessage());
		}
		return true;
	}
	
	
	
	public boolean validateFileConfigStructure(){
		try {
			Utils util = new Utils();
			JSONObject fileConfig = jsondef.getJSONObject(Constants.FILE_CONFIG);
			if(validateFileCfg()){
					util.validateEmptyCheck(fileConfig,Constants.FILE_CONFIG_TOKENS_001);
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
	
	public boolean validateFileStructureFields(JSONObject field, ArrayList<Integer> seqList){
		// validate seq
		try {
			Object seqObj = field.get(Constants.SEQ);
			if(!(seqObj instanceof Integer)){
//				logger.error("SEQ value :"+ seqObj+" is not an integer value for the JSON array - "+field);
				errorList.add("SEQ value :"+ seqObj+" is not an integer value for the JSON array - "+field);
				return false;
			}
			int seq = field.getInt(Constants.SEQ);
			if(seqList.contains(seq)){
//				logger.error("SEQ value :"+ seq+" is a duplicate value for the JSON array - "+field);
				errorList.add("SEQ value :"+ seq+" is a duplicate value for the JSON array - "+field);
				return false;
			}else
				seqList.add(seq);
		} catch (JSONException e) {
			e.printStackTrace();
//			logger.error(e.getLocalizedMessage() +" for the json array - "+field);
			errorList.add(e.getLocalizedMessage() +" for the json array - "+field);
		}
		return true;
	}
	
	public boolean validateDeriveStructureFields(JSONObject field, ArrayList<Integer> seqList){
		try {
			Utils util = new Utils();
			String source = field.getString(Constants.SOURCE);
			
			if(!util.validatePossibleValues(Constants.POSSIBLE_SOURCE_VALUES, source)){
				logger.error("Invalid source value :"+source+" in the JSON array - "+field);
				errorList.add("Invalid source value :"+source+" in the JSON array - "+field);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage() +"for the JSON array -"+field);
			errorList.add(e.getLocalizedMessage() +"for the JSON array -"+field);
		}
		return true;
	}
	
	
	public boolean validateDerive() throws JSONException{
		return !jsondef.isNull(Constants.DERIVE) && (jsondef.getJSONArray(Constants.DERIVE).length()>0);
	}
	
	public boolean validateTblInsert() throws JSONException{
		return !jsondef.isNull(Constants.TBL_INSERT) && (jsondef.getJSONArray(Constants.TBL_INSERT).length()>0);
	}
	
	
	
}
