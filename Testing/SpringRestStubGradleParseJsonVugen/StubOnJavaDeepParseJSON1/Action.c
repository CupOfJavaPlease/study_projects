Action()
{		
//	int arrSize;
//	int incr;
	
	lr_start_transaction("UC01_main_transaction");
	
//		web_reg_save_param_json(  - изначально пробовал распарсить json, в конечном итоге пришел к выводу, что это было неудачным способом решения, оставил, так как проект учебный
//		"ParamName=nameParam",
//		"QueryString=$..*",
//		"NotFound=warning",
//		"SelectAll=Yes",
//		SEARCH_FILTERS,
//		"Scope=BODY",
//		"RelFrameID=All",
//		"RequestUrl={host}",
//		"ContentType=*",
//		LAST);
	
	web_reg_save_param_ex(                 /*в конечном виде реализовал через обычную корреляцию без джсона*/
		"ParamName=nameParam",
		"LB=",
		"RB=",
		SEARCH_FILTERS,
		"Scope=BODY",
		"IgnoreRedirections=Yes",
		"RequestUrl={host}",
		LAST);

	web_rest("POST: {host}",
		"URL={host}",
		"Method=POST",
		"EncType=raw",
		"Snapshot=t392872.inf",
		"Body={\n"
		"\"messageId\": 57447884018,\n"
		"\"sessionId\": \"86024848-c12b-4056-b58b-93c69b412314\",\n"
		"\"messageName\": \"EVENTS_RS\",\n"
		"\"uuid\": {\n"
		"\"userChannel\": \"FEBRUARY\",\n"
		"\"sub\": \"d2d6da62-6bdd-452b-b5dd-a145090075ba\",\n"
		"\"userId\": \"5665ecef-edd5-44ab-85bc-49d388e80262\"\n"
		"},\n"
		"\"payload\": {\n"
		"\"eventsService\": {\n"
		"\"status\": \"1\"\n"
		"}\n"
		"}\n"
		"}",
		HEADERS,
		"Name=Content-Type", "Value=application/json", ENDHEADER,
		LAST);
	
//	arrSize = lr_paramarr_len("nameParam");     --- тут полученные значения json'а выводил через цикл
	
//	lr_output_message( "% d" , arrSize);
	
//	for (incr = 1; incr <= arrSize; ++ incr) {
//        lr_output_message (lr_paramarr_idx ("nameParam", incr));
//	}

	lr_message("Output message: %s", lr_eval_string("{nameParam}"));

	lr_end_transaction("UC01_main_transaction", LR_AUTO);
}