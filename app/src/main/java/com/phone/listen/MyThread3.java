package com.phone.listen;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MyThread3 extends Thread
{
    private String message_con;
 
    public MyThread3(String message_con)
    {
        this.message_con = message_con;
    }
    public void run()
    {
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n    \"msgtype\": \"text\",\n   " +
                    " \"text\": {\n        \"content\": \"" + message_con + "\"\n    }\n}");
            Request request = new Request.Builder()
                    .url("https://oapi.dingtalk.com/robot/send?access_token=482212bcdd40ac4cd1ae4ef38ec99c94a166bf8b91adda03d20a5b3c87582c32")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .build();

            Response response = client.newCall(request).execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}