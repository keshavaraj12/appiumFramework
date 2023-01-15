package Generics;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {
	public  String propertyfile(String key) throws Throwable {
		//FileInputStream fis=new FileInputStream("./src/test/resources/Commondata.properties");
		FileInputStream fis=new FileInputStream(ipathCanstant.PROPERTYFILE_PATH);
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
