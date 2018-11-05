package sikuli;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;



public class JsonWriteTest {

	public static void main(String[] args) throws IOException, ParseException {
	
		
		
		JSONObject job=new JSONObject();
        job.put("name", "levin");
        job.put("age", 32);
        JSONArray array=new JSONArray();
        array.add("msg1:its been a long day");
        array.add("msg2:without u my friend");
        job.put("messages",array );
        
        FileWriter writer=new FileWriter(new File("D:\\test2.json"));
        writer.write(job.toJSONString());
        System.out.println(job);
		 writer.flush();
        FileReader reader=new FileReader(new File("D:\\test2.json"));
        JSONParser parser=new JSONParser();
        Object ob=parser.parse(reader);
        System.out.println("reader ob"+ob);
        JSONObject job1=(JSONObject)ob;
        String name=job1.get("name").toString();
        
        JSONArray jarray=(JSONArray) job1.get("messages");
        Iterator<String>it=jarray.iterator();
        while(it.hasNext())
        {
        	System.out.println(it.next());
        }
        
       
		
		
		
	}

}
