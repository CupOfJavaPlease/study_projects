Action()
{
	lr_start_transaction("UC01_main_transaction");
	


	web_rest("POST: http://localhost:8083/",
		"URL=http://localhost:8083/",
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

	
	lr_end_transaction("UC01_main_transaction", LR_AUTO);

}