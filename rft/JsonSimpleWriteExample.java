package rft;

import com.google.gson.JsonObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonSimpleWriteExample {

    public static void main(String[] args) throws IOException {

        JSONObject job=new JSONObject();
        job.put("name", "levin");
        job.put("age", new Integer(21));
        JSONArray ja=new JSONArray();
        ja.add("msg1:hello");
        ja.add("msg2:time to move");
        job.put("Messages For You", ja);
        
        FileWriter writer=new FileWriter(new File("D:\\test.json"));
        writer.write(job.toJSONString());
        writer.flush();
        System.out.println(job);

    }

}