package rft;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

public class JsonSimpleReadExample {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		
		FileReader reader=new FileReader(new File("D:\\test.json"));
		
		JSONParser parser=new JSONParser();
		
		Object ob=parser.parse(reader);
		JSONObject job=(JSONObject)ob;
		System.out.println(job);
		
		String name=job.get("name").toString();
		System.out.println(name);

		JSONArray ar=(JSONArray) job.get("Messages For You");
		Iterator<String>it=ar.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next()+" ");
		}
		
	}

}
