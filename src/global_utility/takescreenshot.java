package global_utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class takescreenshot extends global_variables 
{
	
	public void screenshot(String screenpath,String Filename)
	{
		File src=((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		try {
			 Path path = FileSystems.getDefault().getPath(screenpath, Filename+".png");
				if(Files.deleteIfExists(path));
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File(screenpath+"\\"+Filename+".png"));
			path_lib_screenshotfull=screenpath+"\\"+Filename+".png";
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
			 }
	}

}
