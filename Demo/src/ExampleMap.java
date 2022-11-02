import java.util.HashMap;
import java.util.Map;

public class ExampleMap {

	public static void main(String[] args)
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("key1", "value1");
		map.put("key2", "");
		
		System.out.println(map.get("key1"));
	}
	
}
