Action()
{
	lr_start_transaction("main_transaction");
	
	web_rest("POST: http://localhost:8083/profile",
		"URL=http://localhost:8083/",
		"Method=POST",
		"EncType=raw",
		"Snapshot=t827851.inf",
		"Body={\n"
		"\"name\": \"Ivan\",\n"
		"\"lastName\": \"Ivanov\",\n"
		"\"middleName\": \"Ivanovich\"\n"
		"}",
		HEADERS,
		"Name=Content-Type", "Value=application/json", ENDHEADER,
		LAST);
	
	lr_end_transaction("main_transaction", LR_AUTO);

}