package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class Confiuration {
	public static boolean isPathSet = false;
	public static String pathName = "";
	
	public static void main(String []args) throws Exception {
		Confiuration con = new Confiuration();
		Map<String, Object> a = con.getConfig("interactions");
		System.out.println("Map is: " +a);
		
		Map<String, String> b = con.getConfigStr("interactions");
		System.out.println("Map is: " +b);
	}
	public void setPath(String path) {
		pathName = path;
		isPathSet = true;
	}
	public Map<String, Object> getConfig(String name) throws IOException {
		Map<String, Object> config = null;
		String conName = "./resources/service.yaml";
		Object input = null;
		if(!isPathSet) {
			input = new FileInputStream(conName);
		} else {
			 input = new FileInputStream(pathName);
		}
		
		 try {
			 if (input == null)
				 throw new FileNotFoundException();
			 else {
				 Object data;
				 for(Iterator var6 = (new Yaml()).loadAll((InputStream)input).iterator();
						 var6.hasNext(); config = (Map) ((Map)data).get(name)) {
							 data = var6.next();
						 }
				 if(config == null) {
					 throw new NullPointerException();
				 } else {
					 ((InputStream) input).close();
					 return config;
				 }
			 }
			 
		 } catch (Exception var7) {
			 var7.printStackTrace();
		 }
		return config;
	}
	public Map<String, String> getConfigStr(String name) throws IOException {
		Map<String, String> config = null;
		String conName = "./resources/service.yaml";
		Object input = null;
		if(!isPathSet) {
			input = new FileInputStream(conName);
		} else {
			 input = new FileInputStream(pathName);
		}
		
		 try {
			 if (input == null)
				 throw new FileNotFoundException();
			 else {
				 Object data;
				 for(Iterator var6 = (new Yaml()).loadAll((InputStream)input).iterator();
						 var6.hasNext(); config = (Map) ((Map)data).get(name)) {
							 data = var6.next();
						 }
				 if(config == null) {
					 throw new NullPointerException();
				 } else {
					 ((InputStream) input).close();
					 return config;
				 }
			 }
			 
		 } catch (Exception var7) {
			 var7.printStackTrace();
		 }
		return config;
	}

}
