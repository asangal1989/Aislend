package action;

import java.util.ArrayList;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import global_utility.global_variables;

public class action_select extends global_variables{
	
	public ArrayList<String> ActionSelect(String UseCase_ID,String TestCase_ID,String Description,String Action,String ElementType,String Element,String Input1,String Input2,String Input3,String Input4) 
	{
		
		action_perform act_perform=new action_perform();
		int Status=0;
		ArrayList<String> result_log=new ArrayList<String>();
		try
		{			
			switch(Action)
			{
			case "OpenBrowser":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_OpenBrowser(Input1,Input2);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "GetURL":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_GetURL(Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyURL":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyURL(Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyText":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyText(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyTitle":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyTitle(Input1,Input2);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}			
			case "VerifyElement":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyElement(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}			
			case "VerifyNoElement":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyNoElement(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyCategoryAndProduct":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyCategoryAndProduct(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyMyAccountMenu":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyMyAccountMenu(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "MoveToCategory":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_MoveToCategory(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifySiteMapFromCategoryPage":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifySiteMapFromCategoryPage(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "MoveToProductList":
			{

				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_MoveToProductList(ElementType,Element,Input1,Input2);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyMiniCart":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyMiniCart(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyBrokenLink":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyBrokenLink();
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "AddProductfromMiniCart":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_AddProductfromMiniCart(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "RemoveProductfromMiniCart":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_RemoveProductfromMiniCart(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "DeleteProductfromMiniCart":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_DeleteProductfromMiniCart(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "AddProductfromViewCart":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_AddProductfromViewCart(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "AddInstruction":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_AddInstruction(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "EditInstruction":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_EditInstruction(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "RemoveInstruction":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_RemoveInstruction(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "RemoveProductfromViewCart":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_RemoveProductfromViewCart(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "DeleteProductfromViewCart":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_DeleteProductfromViewCart(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifySummaryViewCart":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifySummaryViewCart(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyMiniCartMsg":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyMiniCartMsg(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "Click":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_Click(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}			
			case "SelectMyAccountTab":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_SelectMyAccountTab(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SetText":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_SetText(ElementType,Element, Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "Wait":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_wait(Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "ClearText":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_ClearText(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SearchProduct":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_SearchProduct(ElementType,Element, Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SearchAndAddToWishlist":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_SearchAndAddToWishlist(ElementType,Element, Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "HeaderMenuSearch":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_HeaderMenuSearch(ElementType,Element, Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "MoveAndAddProduct":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_MoveAndAddProduct(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "MoveAndRemoveProduct":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_MoveAndRemoveProduct(ElementType,Element,Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SortBy":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_SortBy(ElementType,Element, Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyFooterLinks":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyFooterLinks(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyPopularMultiLink":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_VerifyPopularMultiLink(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SelectSubstitute":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_SelectSubstitute(ElementType,Element, Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SelectSlot":
			{
				log_system.info("Action Selected: "+ Action);
				Status=act_perform.Perform_SelectSlot(ElementType,Element);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "CloseBrowser":
			{
				log_system.info("Action Selected: "+ Action);				
				Status=act_perform.Perform_CloseBrowser(Input1);
				log_system.info("Action Executed: "+ Action);
				log_system.info("Status of Action "+Action+": "+Status);
				if(Status==1){result_log.add(Action+": "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Action+": "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "QuitDriver":
			{
				log_system.info("Action Quit Driver Selected");
				act_perform.Perform_QuitDriver();				
				break;
			}
			}
		}
		catch(Exception e)
		{
 			switch(Action)
			{
			case "OpenBrowser":
			{				
				result_log.add(Input1+" Browser not Opened");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "GetURL":
			{
				result_log.add(Input1+" URL not Opened");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyURL":
			{
				result_log.add(Input1+" URL not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyText":
			{
				result_log.add("text not verified: "+Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyTitle":
			{
				result_log.add(Input1+": Title not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyMyAccountMenu":
			{
				result_log.add(Input1+": VerifyMyAccountMenu");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "Wait":
			{
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());
				break;
			}			
			case "SelectMyAccountTab":
			{
				result_log.add("SelectMyAccountTab not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyElement":
			{
				result_log.add("Element not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyNoElement":
			{
				result_log.add("Element not verified");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyCategoryAndProduct":
			{
				result_log.add("VerifyCategoryAndProduct Failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "Click":
			{
				result_log.add("action click failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SetText":
			{
				result_log.add("action set text failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyFooterLinks":
			{
				result_log.add("action VerifyFooterLinks failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyPopularMultiLink":
			{
				result_log.add("action VerifyPopularMultiLink failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "ClearText":
			{
				result_log.add("action Clear text failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyMiniCartMsg":
			{
				result_log.add("action Clear text failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyMiniCart":
			{
				result_log.add("action Verify Mini Cart failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());
			}
			case "SearchProduct":
			{
				result_log.add("action Product Search failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "HeaderMenuSearch":
			{
				result_log.add("action Header Menu link Search failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "MoveAndAddProduct":
			{
				result_log.add("action Move and add product failed");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "AddInstruction":
			{
				result_log.add("action AddInstruction failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "EditInstruction":
			{
				result_log.add("action EditInstruction failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "RemoveInstruction":
			{
				result_log.add("action RemoveInstruction failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			
			case "AddProductfromViewCart":
			{
				result_log.add("action AddProductfromViewCart failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "RemoveProductfromViewCart":
			{
				result_log.add("action RemoveProductfromViewCart failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "DeleteProductfromViewCart":
			{
				result_log.add("action DeleteProductfromViewCart failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SearchAndAddToWishlist":
			{
				result_log.add("action Search And Add To Wishlist failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SortBy":
			{
				result_log.add("action sort by failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SelectSubstitute":
			{
				result_log.add("action Select Substitute failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "MoveToProductList":
			{
				result_log.add("action MoveToProductList failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "MoveToCategory":
			{
				result_log.add("action MoveToCategory failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "MoveAndRemoveProduct":
			{
				result_log.add("action MoveAndRemoveProduct failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifyBrokenLink":
			{
				result_log.add("action Verify BrokenLink failed: ");
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "SelectSlot":
			{
				result_log.add("action Select slot failed: "+ Input1+"  "+Input2);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "AddProductfromMiniCart":
			{
				result_log.add("action AddProductfromMiniCart failed: "+ Input1+"  "+Input2);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "RemoveProductfromMiniCart":
			{
				result_log.add("action RemoveProductfromMiniCart failed: "+ Input1+"  "+Input2);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifySiteMapFromCategoryPage":
			{
				result_log.add("action VerifySiteMapFromCategoryPage failed: "+ Input1+"  "+Input2);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "DeleteProductfromMiniCart":
			{
				result_log.add("action DeleteProductfromMiniCart failed: "+ Input1+"  "+Input2);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "VerifySummaryViewCart":
			{
				result_log.add("action VerifySummaryViewCart failed: "+ Input1+"  "+Input2);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			case "CloseBrowser":
			{
				result_log.add("action failed: "+ Input1);
				result_log.add("Fail");
				result_log.add(e.getMessage());
				log_system.error(e.getMessage());
				log_system.error(e.getStackTrace().toString());								
				break;
			}
			
			default:
				
				ArrayList<String> error=new ArrayList<String>();
				try
				{		
					 Logs logs = Driver.manage().logs();
				        LogEntries logEntries = logs.get(LogType.BROWSER);
				        for(LogEntry logEntry :logEntries)
				        {
				            
				            if (logEntry.getMessage().toLowerCase().contains("[error]")) {
				            	error.add(logEntry.getMessage());				            	
				            } else if (logEntry.getMessage().toLowerCase().contains("[warning]")){
				                System.out.println("Warning Message in Console:"+logEntry.getMessage());
				            }else{
				                System.out.println("Information Message in Console:"+logEntry.getMessage());
				            }
				        }
				        if(error.size()!=0)
				        {
				        	Driver.get(Driver.getCurrentUrl());		
				        }
						
					
				}
				catch(Exception e1)
				{
					Driver.get(Driver.getCurrentUrl());
				}
				if(Driver.getPageSource().contains("500") || Driver.getPageSource().contains("Time") || Driver.getPageSource().contains("400"))
				{
					
					
				}
			}
		}
		
		return result_log;
	}
}
