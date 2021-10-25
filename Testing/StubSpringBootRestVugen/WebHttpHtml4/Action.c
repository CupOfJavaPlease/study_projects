Action()
{
	
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
	
//	web_custom_request("post_query.exe", "Method=POST",
//    "URL=http://localhost:8083/", 
//    "Body={\n"
//		"\"name\": \"Ivan\",\n"
//		"\"firstName\": \"Ivanov\",\n"
//		"\"middleName\": \"Ivanovich\"\n"
//		"}",
//				HEADERS,
//		"Name=Content-Type", "Value=application/json", ENDHEADER,
//    LAST ); 


}