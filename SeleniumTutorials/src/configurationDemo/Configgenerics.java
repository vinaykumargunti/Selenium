package configurationDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Configgenerics {
	static Properties pro;
	public static Properties properties() {
	
	try {
		FileInputStream fis=new FileInputStream(new File("./ConfigurationProperty/Configure.property"));
		
		pro=new Properties();
		pro.load(fis);
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pro;
	
	
	}
}
