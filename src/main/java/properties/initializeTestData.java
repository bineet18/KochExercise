package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class initializeTestData 
{
	public Properties propT;
	public initializeTestData() throws IOException
	{
		propT = new  Properties();
		
		FileInputStream fis = new FileInputStream("testData.Properties"); 		
		propT.load(fis);
	}
	
	public Properties returnTestData()
	{return propT;}
}
