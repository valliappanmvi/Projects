package com.json.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Constants {

	
	public static final String APPLICATION_PROPERTY = "com.json.util.application";
	public static final String FILE_LOC_001 = "file.location.001";
	public static final String FILE_LOC_002 = "file.location.002";
	public static final String FILE_LOC_003 = "file.location.003";
	public static final String FILE_LOC_004 = "file.location.004";
	public static final String FILE_LOC_005 = "file.location.005";
	public static final String FILE_LOC_006 = "file.location.006";
	
	// File Structure related key configurations
	public static final String FILE_STRUCTURE = "FILE_STRUCTURE";
	public static final String FIELD_REF = "FIELD_REF";
	public static final String HEADER = "HEADER";
	public static final String SEQ = "SEQ";
	public static final String RETRIEVE = "RETRIEVE";
	public static final String KEY = "KEY";
	
	// File Configurations
	public static final String FILE_CONFIG = "FILE_CFG";
	public static final String EXTN = "EXTN";
	public static final String HAS_HEADER = "HAS_HEADER";
	
	// File Configurations 004
	public static final String MAX_RECORD_COUNT = "MAX_RECORD_COUNT";
	public static final String MAX_FILE_SIZE = "MAX_FILE_SIZE";

	// Derive Configurations
	public static final String SOURCE = "SOURCE";
	public static final String DERIVE = "DERIVE";
	public static final String FILE_NAME = "FILE_NAME";
	public static final String FILE_DATA = "FILE_DATA";

	// WriterDef Config
	public static final String WRITER_DEF = "WRITER_DEF";
	public static final String TYPE = "TYPE";
	public static final String csv = "csv";
	public static final String csvout = "csv.out";

	// Table Insert Configurations
	public static final String TBL_INSERT = "TBL_INSERT";
	public static final String CFG = "CFG";
	public static final String COLUMNS = "COLUMNS";
	public static final String TBL_REF = "TBL_REF";
	public static final String GROUP_BY = "GROUP_BY";
	public static final String DATA_TYPE = "DATA_TYPE";
	public static final String TBL_COLUMN = "TBL_COLUMN";
	public static final String ENCRYPTED = "ENCRYPTED";
	public static final String txt = "txt";
	public static final String TRUE = "TRUE";
	public static final String FALSE = "FALSE";
	public static final String VALUE_GROUP_BY = "GROUP_BY";
	public static final String INST_MEM = "INST_MEM";
	
	// Table Insert 002
	public static final String PRECISION = "PRECISION";
	public static final String SCALE = "SCALE";
	public static final String CFG_DATA = "CFG_DATA";
	public static final String NSTRING = "NSTRING";
	public static final String STRING = "STRING";
	public static final String DECIMAL = "DECIMAL";
	
	// Table Insert 005
	public static final String REJECTED_INST = "REJECTED_INST";

	// Validation Configuration
	public static final String VALIDATION = "VALIDATION";
	public static final String FILE_LEVEL = "FILE_LEVEL";
	public static final String INST_LEVEL = "INST_LEVEL";
	public static final String RSLT_CODE_REF = "RSLT_CODE_REF";
	public static final String RSLT_DESC_REF = "RSLT_DESC_REF";
	public static final String DEFN = "DEFN";
	public static final String RSLT_CODE = "RSLT_CODE";
	public static final String RSLT_DESC = "RSLT_DESC";
	public static final String MAX = "MAX";
	public static final String CHAR_TYPE = "CHAR_TYPE";
	public static final String VALUE_CHK = "VALUE_CHK";
	public static final String FILE_EXIST = "FILE_EXIST";
	public static final String DUPL = "DUPL";
	public static final String FILE_SIZE = "FILE_SIZE";
	public static final String DECRYPT = "DECRYPT";
	public static final String ENCODE = "ENCODE";
	public static final String MISSING_HEADER = "MISSING_HEADER";
	public static final String EMPTY = "EMPTY";
	public static final String INST_COUNT = "INST_COUNT";
	public static final String LENGTH = "LENGTH";
	public static final String SIZE = "SIZE";
	public static final String MANDATORY = "MANDATORY";
	public static final String MIN = "MIN";
	public static final String AMOUNT = "AMOUNT";
	public static final String MIN_DEF = "MIN_DEF";
	public static final String MAX_DEF = "MAX_DEF";
	public static final String DUP_CHK = "DUP_CHK";
	
	// Validation Configuration 005
	public static final String WHITELIST = "WHITELIST";
	public static final String BLACKLIST = "BLACKLIST";
	public static final String CUSTOM_CASE = "CUSTOM_CASE";
	public static final String SDAPI = "SDAPI";
	public static final String VALUE = "VALUE";
	public static final String INVALID_ROW = "INVALID_ROW";
	
	//RSLTCODE VALUES
	public static final String RR04 = "RR04";
	public static final String BE16 = "BE16";
	public static final String BE22 = "BE22";
	public static final String AC01 = "AC01";
	public static final String AC09 = "AC09";
	public static final String AM12 = "AM12";
	public static final String RC10 = "RC10";
	public static final String ED05 = "ED05";
	public static final String RR09 = "RR09";
	public static final String BE09 = "BE09";
	public static final String RC07 = "RC07";
	public static final String RR03 = "RR03";
	public static final String FILE_NAME_FMT = "FILE_NAME_FMT";
	
	public static final List<String> WRITERDEF_TOKENS = new ArrayList<String>();
	static {
		WRITERDEF_TOKENS.add(TYPE);
	}

	public static final List<String> VALIDATION_INST_LEVEL_CFG_DEFN_INVLIDROW_TOKENS_002 = new ArrayList<String>();
	static {
		VALIDATION_INST_LEVEL_CFG_DEFN_INVLIDROW_TOKENS_002.add(RSLT_CODE);
		VALIDATION_INST_LEVEL_CFG_DEFN_INVLIDROW_TOKENS_002.add(RSLT_DESC);
	}
	
	public static final List<String> POSSIBLE_RSLT_CODE_VALUES = new ArrayList<String>();
	static {
		POSSIBLE_RSLT_CODE_VALUES.add(RR04);
		POSSIBLE_RSLT_CODE_VALUES.add(BE16);
		POSSIBLE_RSLT_CODE_VALUES.add(BE22);
		POSSIBLE_RSLT_CODE_VALUES.add(AC01);
		POSSIBLE_RSLT_CODE_VALUES.add(AC09);
		POSSIBLE_RSLT_CODE_VALUES.add(AM12);
		POSSIBLE_RSLT_CODE_VALUES.add(RC10);
		POSSIBLE_RSLT_CODE_VALUES.add(ED05);
		POSSIBLE_RSLT_CODE_VALUES.add(RR09);
		POSSIBLE_RSLT_CODE_VALUES.add(BE09);
		POSSIBLE_RSLT_CODE_VALUES.add(RC07);
		POSSIBLE_RSLT_CODE_VALUES.add(RR03);
		
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_TOKENS_002 = new ArrayList<String>();
	static {
		VALIDATION_INST_LEVEL_TOKENS_002.add(CFG);
		VALIDATION_INST_LEVEL_TOKENS_002.add(DEFN);
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_CFG_TOKENS_002 = new ArrayList<String>();
	static {
		VALIDATION_INST_LEVEL_CFG_TOKENS_002.add(RSLT_CODE_REF);
		VALIDATION_INST_LEVEL_CFG_TOKENS_002.add(RSLT_DESC_REF);
	}

	public static final List<String> VALIDATION_TOKENS = new ArrayList<String>();
	static {
		VALIDATION_TOKENS.add(FILE_LEVEL);
		VALIDATION_TOKENS.add(INST_LEVEL);
	}

	public static final List<String> VALIDATION_FILE_LEVEL_TOKENS = new ArrayList<String>();
	static {
		VALIDATION_FILE_LEVEL_TOKENS.add(CFG);
		VALIDATION_FILE_LEVEL_TOKENS.add(DEFN);;
	}

	public static final List<String> VALIDATION_FILE_LEVEL_CFG_TOKENS = new ArrayList<String>();
	static {
		VALIDATION_FILE_LEVEL_CFG_TOKENS.add(RSLT_CODE_REF);
		VALIDATION_FILE_LEVEL_CFG_TOKENS.add(RSLT_DESC_REF);
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_CFG_TOKENS_003 = new ArrayList<String>();
	static {
		VALIDATION_INST_LEVEL_CFG_TOKENS_003.add(FIELD_REF);
	}

	public static final HashMap<String, ArrayList<String>> VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS = new HashMap<String, ArrayList<String>>();
	static {
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(EXTN,
				new ArrayList<String>(Arrays.asList(FIELD_REF, RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(MAX,
				new ArrayList<String>(Arrays.asList(FIELD_REF, LENGTH, RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(CHAR_TYPE,
				new ArrayList<String>(Arrays.asList(FIELD_REF, TYPE, RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(VALUE_CHK,
				new ArrayList<String>(Arrays.asList(FIELD_REF, RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(FILE_EXIST,
				new ArrayList<String>(Arrays.asList(RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(DUPL,
				new ArrayList<String>(Arrays.asList(RSLT_CODE, TBL_REF, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(FILE_SIZE,
				new ArrayList<String>(Arrays.asList(RSLT_CODE, SIZE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(DECRYPT, new ArrayList<String>(Arrays.asList(RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(ENCODE, new ArrayList<String>(Arrays.asList(RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(MISSING_HEADER,
				new ArrayList<String>(Arrays.asList(RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(EMPTY, new ArrayList<String>(Arrays.asList(RSLT_CODE, RSLT_DESC)));
		VALIDATION_FILE_LEVEL_DEFN_ITEM_TOKENS.put(INST_COUNT,
				new ArrayList<String>(Arrays.asList(RSLT_CODE, SIZE, RSLT_DESC)));
	}
	
	public static final HashMap<String, ArrayList<String>> VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_002 = new HashMap<String, ArrayList<String>>();
	static {
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_002.put(INVALID_ROW,
				new ArrayList<String>(Arrays.asList(RSLT_CODE, RSLT_DESC)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_002.put(MANDATORY,
				new ArrayList<String>(Arrays.asList(FIELD_REF, RSLT_CODE, RSLT_DESC)));
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_002_REQUIRED = new ArrayList<String>();
	static {
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_002_REQUIRED.add(INVALID_ROW);
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_002_REQUIRED.add(MANDATORY);
	}

	public static final List<String> VALIDATION_FILE_LEVEL_DEFN_REQUIRED = new ArrayList<String>();
	static {
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(EXTN);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(MAX);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(CHAR_TYPE);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(VALUE_CHK);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(FILE_EXIST);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(DUPL);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(FILE_SIZE);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(DECRYPT);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(ENCODE);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(MISSING_HEADER);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(EMPTY);
		VALIDATION_FILE_LEVEL_DEFN_REQUIRED.add(INST_COUNT);
	}
	
	public static final HashMap<String, ArrayList<String>> VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_005 = new HashMap<String, ArrayList<String>>();
	static{
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_005.put(WHITELIST,
				new ArrayList<String>(Arrays.asList(FIELD_REF)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_005.put(BLACKLIST,
				new ArrayList<String>(Arrays.asList(FIELD_REF,RSLT_CODE,RSLT_DESC)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_005.put(CUSTOM_CASE,
				new ArrayList<String>(Arrays.asList(FIELD_REF,RSLT_CODE,RSLT_DESC)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_005.put(SDAPI,
				new ArrayList<String>(Arrays.asList(RSLT_CODE,RSLT_DESC)));
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_DEFN_REQUIRED_005 = new ArrayList<String>();
	static{
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_005.add(WHITELIST);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_005.add(BLACKLIST);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_005.add(CUSTOM_CASE);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_005.add(SDAPI);
	}
	
	public static final HashMap<String, ArrayList<String>> VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003 = new HashMap<String, ArrayList<String>>();
	static{
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(MANDATORY,
				new ArrayList<String>(Arrays.asList(FIELD_REF,RSLT_CODE)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(MIN,
				new ArrayList<String>(Arrays.asList(FIELD_REF,LENGTH,RSLT_CODE)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(MAX,
				new ArrayList<String>(Arrays.asList(FIELD_REF,LENGTH,RSLT_CODE)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(CHAR_TYPE,
				new ArrayList<String>(Arrays.asList(FIELD_REF,TYPE,RSLT_CODE)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(AMOUNT,
				new ArrayList<String>(Arrays.asList(FIELD_REF,RSLT_CODE)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(MIN_DEF,
				new ArrayList<String>(Arrays.asList(FIELD_REF,RSLT_CODE,RETRIEVE)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(MAX_DEF,
				new ArrayList<String>(Arrays.asList(FIELD_REF,RSLT_CODE,RETRIEVE)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(VALUE_CHK,
				new ArrayList<String>(Arrays.asList(FIELD_REF,RSLT_CODE,RETRIEVE)));
		VALIDATION_INST_LEVEL_DEFN_ITEM_TOKENS_003.put(DUP_CHK,
				new ArrayList<String>(Arrays.asList(FIELD_REF,TBL_REF,RSLT_CODE,TBL_COLUMN)));
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_DEFN_REQUIRED_003 = new ArrayList<String>();
	static{
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(MANDATORY);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(MIN);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(MAX);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(CHAR_TYPE);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(AMOUNT);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(MIN_DEF);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(MAX_DEF);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(VALUE_CHK);
		VALIDATION_INST_LEVEL_DEFN_REQUIRED_003.add(DUP_CHK);
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_DEFN_CUST_CASE_RETRIEVE_TOKENS = new ArrayList<String>();
	static{
		VALIDATION_INST_LEVEL_DEFN_CUST_CASE_RETRIEVE_TOKENS.add(TBL_REF);
		VALIDATION_INST_LEVEL_DEFN_CUST_CASE_RETRIEVE_TOKENS.add(KEY);
		VALIDATION_INST_LEVEL_DEFN_CUST_CASE_RETRIEVE_TOKENS.add(VALUE);
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_DEFN_SDAPI_RETRIEVE_TOKENS = new ArrayList<String>();
	static{
		VALIDATION_INST_LEVEL_DEFN_SDAPI_RETRIEVE_TOKENS.add(SOURCE);
		VALIDATION_INST_LEVEL_DEFN_SDAPI_RETRIEVE_TOKENS.add(FIELD_REF);
	}
	
	public static final List<String> VALIDATION_INST_LEVEL_DEFN_RETRIEVE_TOKENS_003 = new ArrayList<String>();
	static{
		VALIDATION_INST_LEVEL_DEFN_RETRIEVE_TOKENS_003.add(TBL_REF);
		VALIDATION_INST_LEVEL_DEFN_RETRIEVE_TOKENS_003.add(KEY);
	}

	public static final List<String> POSSIBLE_WRITERDEF_VALUES = new ArrayList<String>();
	static {
		POSSIBLE_WRITERDEF_VALUES.add(csv);
		POSSIBLE_WRITERDEF_VALUES.add(csvout);
	}

	public static final List<String> DERIVE_TOKENS = new ArrayList<String>();
	static {
		DERIVE_TOKENS.add(FIELD_REF);
		DERIVE_TOKENS.add(SOURCE);
	}
	
	public static final List<String> DERIVE_TOKENS_004 = new ArrayList<String>();
	static {
		DERIVE_TOKENS_004.add(FIELD_REF);
		DERIVE_TOKENS_004.add(RETRIEVE);
	}

	public static final List<String> POSSIBLE_SOURCE_VALUES = new ArrayList<String>();
	static {
		POSSIBLE_SOURCE_VALUES.add(FILE_NAME);
		POSSIBLE_SOURCE_VALUES.add(FILE_DATA);
		POSSIBLE_SOURCE_VALUES.add(DERIVE);
	}
	
	public static final String BATCH = "BATCH";
	
	public static final List<String> POSSIBLE_SOURCE_VALUES_002_003_005 = new ArrayList<String>();
	static {
		POSSIBLE_SOURCE_VALUES_002_003_005.add(BATCH);
		POSSIBLE_SOURCE_VALUES_002_003_005.add(FILE_DATA);
		POSSIBLE_SOURCE_VALUES_002_003_005.add(CFG_DATA);
	}

	public static final List<String> FILE_STRUC_TOKENS_001 = new ArrayList<String>();
	static {
		FILE_STRUC_TOKENS_001.add(FIELD_REF);
		FILE_STRUC_TOKENS_001.add(HEADER);
		FILE_STRUC_TOKENS_001.add(SEQ);
	}
	
	public static final List<String> FILE_STRUC_TOKENS_002_003_005 = new ArrayList<String>();
	static {
		FILE_STRUC_TOKENS_002_003_005.add(FIELD_REF);
		FILE_STRUC_TOKENS_002_003_005.add(HEADER);
		FILE_STRUC_TOKENS_002_003_005.add(SOURCE);
		FILE_STRUC_TOKENS_002_003_005.add(SEQ);
	}

	public static final List<String> FILE_STRUC_TOKENS_004_006 = new ArrayList<String>();
	static {
		FILE_STRUC_TOKENS_004_006.add(FIELD_REF);
		FILE_STRUC_TOKENS_004_006.add(HEADER);
		FILE_STRUC_TOKENS_004_006.add(SEQ);
		FILE_STRUC_TOKENS_004_006.add(RETRIEVE);
	}

	public static final List<String> FILE_CONFIG_TOKENS_001 = new ArrayList<String>();
	static {
		FILE_CONFIG_TOKENS_001.add(EXTN);
		FILE_CONFIG_TOKENS_001.add(HAS_HEADER);
	}
	
	public static final List<String> FILE_CONFIG_TOKENS_002_003_005 = new ArrayList<String>();
	static {
		FILE_CONFIG_TOKENS_002_003_005.add(EXTN);
		FILE_CONFIG_TOKENS_002_003_005.add(HAS_HEADER);
		FILE_CONFIG_TOKENS_002_003_005.add(FILE_NAME_FMT);
	}
	
	public static final List<String> FILE_CONFIG_TOKENS_004 = new ArrayList<String>();
	static {
		FILE_CONFIG_TOKENS_004.add(EXTN);
		FILE_CONFIG_TOKENS_004.add(HAS_HEADER);	
		FILE_CONFIG_TOKENS_004.add(MAX_RECORD_COUNT);	
		FILE_CONFIG_TOKENS_004.add(MAX_FILE_SIZE);	
	}
	
	public static final List<String> FILE_STRUC_RETRIEVE_TOKENS = new ArrayList<String>();
	static {
		FILE_STRUC_RETRIEVE_TOKENS.add(TBL_REF);
		FILE_STRUC_RETRIEVE_TOKENS.add(KEY);
	}

	public static final List<String> TBL_INSERT_TOKENS = new ArrayList<String>();
	static {
		TBL_INSERT_TOKENS.add(FIELD_REF);
		TBL_INSERT_TOKENS.add(DATA_TYPE);
		TBL_INSERT_TOKENS.add(TBL_COLUMN);
	}

	public static final List<String> POSSIBLE_EXTN_VALUES = new ArrayList<String>();
	static {
		POSSIBLE_EXTN_VALUES.add(csv);
		POSSIBLE_EXTN_VALUES.add(txt);
		POSSIBLE_EXTN_VALUES.add(csvout);
	}

	public static final List<String> POSSIBLE_HAS_HEADER_VALUES = new ArrayList<String>();
	static {
		POSSIBLE_HAS_HEADER_VALUES.add(TRUE);
		POSSIBLE_HAS_HEADER_VALUES.add(FALSE);
	}

	public static final List<String> POSSIBLE_GROUP_BY_VALUES = new ArrayList<String>();
	
	static {
		POSSIBLE_GROUP_BY_VALUES.add(VALUE_GROUP_BY);
	}
	
	public static final List<String> TBL_INSERT_COLUMNS_TOKENS_002 = new ArrayList<String>();
	static{
		TBL_INSERT_COLUMNS_TOKENS_002.add(FIELD_REF);
		TBL_INSERT_COLUMNS_TOKENS_002.add(TBL_COLUMN);
		TBL_INSERT_COLUMNS_TOKENS_002.add(DATA_TYPE);
		TBL_INSERT_COLUMNS_TOKENS_002.add(SOURCE);
	}
	
	public static final List<String> POSSIBLE_SOURCE_VALUES_002 = new ArrayList<String>();
	static{
		POSSIBLE_SOURCE_VALUES_002.add(FILE_DATA);
		POSSIBLE_SOURCE_VALUES_002.add(CFG_DATA);
	}
	
	public static final List<String> POSSIBLE_DATA_TYPE_VALUES_002 = new ArrayList<String>();
	static{
		POSSIBLE_DATA_TYPE_VALUES_002.add(NSTRING);
		POSSIBLE_DATA_TYPE_VALUES_002.add(STRING);
		POSSIBLE_DATA_TYPE_VALUES_002.add(AMOUNT);
		POSSIBLE_DATA_TYPE_VALUES_002.add(DECIMAL);
	}
	
	public static final List<String> TBL_INSERT_CFG_TOKENS_002 = new ArrayList<String>();
	static{
		TBL_INSERT_CFG_TOKENS_002.add(TBL_REF);
	}
}
