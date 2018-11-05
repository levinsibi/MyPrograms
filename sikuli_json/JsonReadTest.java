package sikuli;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonReadTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		FileReader reader=new FileReader(new File("D:\\test.json")); 
		JsonParser parser=new JsonParser();
		
		Object ob=parser.parse(reader);
		System.out.println(ob);
		
		JsonObject job=(JsonObject)ob;
		
		String name=job.get("name").toString();
		
		System.out.println(name);
		
		JsonArray jarray=(JsonArray)job.get("Messages For You");
		
		Iterator<JsonElement>it=jarray.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		
	}

}
