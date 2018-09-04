package suit;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.Test;

import action.action_select;
import global_utility.global_variables;
import global_utility.handle_ajax_call;
import global_utility.random_email;
import global_utility.takescreenshot;
import global_utility.video_capture;
import reader_writer.excelReader;
import reader_writer.excelWriter;

public class open_browser extends global_variables{
  
	random_email email=new random_email();
	
	@SuppressWarnings("rawtypes")
	@Test	
	  public void openbrowser() {
		
		
		testinfo=reports.createTest(this.getClass().getName());
		log_system.info("*********************Execution Start for: "+this.getClass().getName()+"************************");
		excelReader getExcelSheet=new excelReader();
		takescreenshot getscreenshot=new takescreenshot();
		action_select act=new action_select();
		excelWriter output=new excelWriter();		
		video_capture recorder=new video_capture();
		
		try
		{
			ArrayList<List> test_data=new ArrayList<List>();
			List result_log=new ArrayList<String>();
			Properties prop=new Properties();
			InputStream in=new FileInputStream(path_lib_properties+"path_testcase.properties");
			prop.load(in);
			log_system.info("*************************Prepare Data Set for "+this.getClass().getName()+ " from excel "+prop.getProperty("aislend_OpenBrowser_FileName")+" *******************************************************************");
 			test_data=getExcelSheet.readInputs(path_lib_testcase+prop.getProperty("aislend_OpenBrowser_FileName"), prop.getProperty("aislend_OpenBrowser_SheetName"));
			log_system.info("*************************** Data set Ready for "+this.getClass().getName()+" ***************************************");
			log_system.info("******************************* Intializing Recorder *************************************");
			recorder.startRecording(path_lib_record,prop.getProperty("aislend_OpenBrowser_SheetName"));
			path_lib_recoderfull=path_lib_record+prop.getProperty("aislend_OpenBrowser_SheetName")+".mov";
			log_system.info("************************************** Start Execution "+this.getClass().getName()+" *********************************************");
			for(List TestData:test_data)
			  {
				  String UseCase_ID=TestData.get(0).toString();
				  String TestCase_ID=TestData.get(1).toString();
				  String Description=TestData.get(2).toString();
				  String Action=TestData.get(3).toString();
				  String ElementType=TestData.get(4).toString();
				  String Element=TestData.get(5).toString();				  
				  String Input1=TestData.get(6).toString().replace("\"", "");
				  String Input2=TestData.get(7).toString().replace("\"", "");
				  String Input3=TestData.get(8).toString().replace("\"", "");
				  String Input4=TestData.get(9).toString().replace("\"", "");
				  String Expected_result=TestData.get(10).toString();
				  String screenshotFolderName=TestData.get(14).toString();
				  if(UseCase_ID.contains("US_ID_14") && TestCase_ID.contains("TC_CityMarket_04") )
				  {
					  System.out.println("");
				  }

				  log_system.info(this.getClass().getName()+": Test case "+UseCase_ID+"_"+TestCase_ID+" is executing");
				  result_log= act.ActionSelect(UseCase_ID,TestCase_ID, Description, Action,ElementType,Element,Input1,Input2,Input3,Input4);				  			
				  log_system.info(this.getClass().getName()+": Execution complete for Test case "+UseCase_ID+"_"+TestCase_ID);
				  log_system.info(this.getClass().getName()+": Taking Screenshot for Test case "+UseCase_ID+"_"+TestCase_ID);
				  try {
					handle_ajax_call.HandleAjaxCall();
					  getscreenshot.screenshot(path_lib_screenshot+screenshotFolderName+"\\", UseCase_ID+"_"+TestCase_ID);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  log_system.info("Writing output in excel file");				  
				  output.writeResult(UseCase_ID,TestCase_ID,path_lib_testcase+prop.getProperty("aislend_OpenBrowser_FileName"), prop.getProperty("aislend_OpenBrowser_SheetName"),result_log,test_data.indexOf(TestData),Description,Expected_result,this.getClass().getName());				  
				  log_system.info("Output written");	  				 
			  }
			 recorder.stopRecording();
			 
		}
		catch(Exception e)
		{
			log_system.error("System is not able to execute Script or Exception found in automation script");
			log_system.error(e.getStackTrace().toString());
			log_system.error(e.getMessage());
			try {
				recorder.stopRecording();
				Driver.quit();
				reports.flush();
				System.exit(0);
			} catch (Exception e1) {
				log_system.error(e.getStackTrace().toString());
				Driver.quit();
				reports.flush();
				System.exit(0);
			}			
		}
		
	  }
}
