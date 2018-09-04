package action;

import java.util.ArrayList;
import global_utility.global_variables;

public class action_select extends global_variables{
	
	public ArrayList<String> ActionSelect(String UseCase_ID,String TestCase_ID,String Description,String Action,String ElementType,String Element,String Input1,String Input2,String Input3,String Input4) 
	{
		
		action_perform act_perform=new action_perform();
		int Status=0;
		ArrayList<String> result_log=new ArrayList<String>();
		try
		{
			log_system.info("Select Action: "+ Action);
			switch(Action)
			{
			case "OpenBrowser":
			{
				log_system.info("Action Open Browser Selected");
				Status=act_perform.Perform_OpenBrowser(Input1);
				log_system.info("Action Open Browser Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add(Input1+" : Browser Open Successfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Input1+" : Browser not Opened");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "GetURL":
			{
				log_system.info("Action Get URL Selected");
				Status=act_perform.Perform_GetURL(Input1);
				log_system.info("Action verify URL Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("url verified: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("url mismatch: "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyURL":
			{
				log_system.info("Action verify URL Selected");
				Status=act_perform.Perform_VerifyURL(Input1);
				log_system.info("Action Get URL Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add(Input1+" : Open Successfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add(Input1+" : not Opened");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyText":
			{
				log_system.info("Action verify text Selected");
				Status=act_perform.Perform_VerifyText(ElementType,Element,Input1);
				log_system.info("Action verify text Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("text verified: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("text mismatch: "+Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyTitle":
			{
				log_system.info("Action Title Selected");
				Status=act_perform.Perform_VerifyTitle(Input1,Input2);
				log_system.info("Action Verify Title Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Title verified succesfully: "+ Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Title verification Failed: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyElement":
			{
				log_system.info("Action Verify Element Selected");
				Status=act_perform.Perform_VerifyElement(ElementType,Element);
				log_system.info("Action Verify Element Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Element verified succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Element verification Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}			
			case "VerifyNoElement":
			{
				log_system.info("Action Verify No Element Selected");
				Status=act_perform.Perform_VerifyNoElement(ElementType,Element);
				log_system.info("Action Verify No Element Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Element verified succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Element verification Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyCategoryAndProduct":
			{
				log_system.info("Action Verify Category and it's product");
				Status=act_perform.Perform_VerifyCategoryAndProduct(ElementType,Element);
				log_system.info("Action Verify Category and it's product  Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("verification of Category and it's product succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("verification of Category and it's product Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyMyAccountMenu":
			{
				log_system.info("Action VerifyMyAccountMenu");
				Status=act_perform.Perform_VerifyMyAccountMenu(ElementType,Element,Input1);
				log_system.info("Action VerifyMyAccountMenu  Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("verification of VerifyMyAccountMenu succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("verification of VerifyMyAccountMenu Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "MoveToCategory":
			{
				log_system.info("Action Move To Category");
				Status=act_perform.Perform_MoveToCategory(ElementType,Element,Input1);
				log_system.info("Action MoveToCategory  Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("user Move To Category successfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("user is not able to navigate to category");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifySiteMapFromCategoryPage":
			{
				log_system.info("Action VerifySiteMapFromCategoryPage");
				Status=act_perform.Perform_VerifySiteMapFromCategoryPage(ElementType,Element);
				log_system.info("Action VerifySiteMapFromCategoryPage  Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("VerifySiteMapFromCategoryPage successfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("VerifySiteMapFromCategoryPage failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "MoveToProductList":
			{

				log_system.info("Action Verify MoveToProductList");
				Status=act_perform.Perform_MoveToProductList(ElementType,Element,Input1,Input2);
				log_system.info("Action Move To Product List Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("verification of Move To Product List succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("verification of Move To Product List Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyMiniCart":
			{
				log_system.info("Action Verify MiniCart");
				Status=act_perform.Perform_VerifyMiniCart(ElementType,Element,Input1);
				log_system.info("Action Verify MiniCart Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("verification of MiniCart succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("verification of MiniCart Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "AddProductfromMiniCart":
			{
				log_system.info("Action AddProductfromMiniCart");
				Status=act_perform.Perform_AddProductfromMiniCart(ElementType,Element);
				log_system.info("Action AddProductfromMiniCart Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("AddProductfromMiniCart succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("AddProductfromMiniCart Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "RemoveProductfromMiniCart":
			{
				log_system.info("Action RemoveProductfromMiniCart");
				Status=act_perform.Perform_RemoveProductfromMiniCart(ElementType,Element);
				log_system.info("Action RemoveProductfromMiniCart Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("RemoveProductfromMiniCart succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("RemoveProductfromMiniCart Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "DeleteProductfromMiniCart":
			{
				log_system.info("Action DeleteProductfromMiniCart");
				Status=act_perform.Perform_DeleteProductfromMiniCart(ElementType,Element,Input1);
				log_system.info("Action DeleteProductfromMiniCart Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("DeleteProductfromMiniCart succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("DeleteProductfromMiniCart Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "AddProductfromViewCart":
			{
				log_system.info("Action AddProductfromViewCart");
				Status=act_perform.Perform_AddProductfromViewCart(ElementType,Element);
				log_system.info("Action AddProductfromViewCart Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("AddProductfromViewCart succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("AddProductfromViewCart Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "AddInstruction":
			{
				log_system.info("Action AddInstruction");
				Status=act_perform.Perform_AddInstruction(ElementType,Element,Input1);
				log_system.info("Action AddInstruction Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("AddInstruction succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("AddInstruction Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "EditInstruction":
			{
				log_system.info("Action EditInstruction");
				Status=act_perform.Perform_EditInstruction(ElementType,Element,Input1);
				log_system.info("Action EditInstruction Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("EditInstruction succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("EditInstruction Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "RemoveInstruction":
			{
				log_system.info("Action RemoveInstruction");
				Status=act_perform.Perform_RemoveInstruction(ElementType,Element);
				log_system.info("Action RemoveInstruction Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("RemoveInstruction succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("RemoveInstruction Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "RemoveProductfromViewCart":
			{
				log_system.info("Action RemoveProductfromViewCart");
				Status=act_perform.Perform_RemoveProductfromViewCart(ElementType,Element);
				log_system.info("Action RemoveProductfromViewCart Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("RemoveProductfromViewCart succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("RemoveProductfromViewCart Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "DeleteProductfromViewCart":
			{
				log_system.info("Action DeleteProductfromViewCart");
				Status=act_perform.Perform_DeleteProductfromViewCart(ElementType,Element,Input1);
				log_system.info("Action DeleteProductfromViewCart Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("DeleteProductfromViewCart succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("DeleteProductfromViewCart Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifySummaryViewCart":
			{
				log_system.info("Action VerifySummaryViewCart");
				Status=act_perform.Perform_VerifySummaryViewCart(ElementType,Element);
				log_system.info("Action VerifySummaryViewCart Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("VerifySummaryViewCart succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("VerifySummaryViewCart Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyMiniCartMsg":
			{
				log_system.info("Action VerifyMiniCartMsg");
				Status=act_perform.Perform_VerifyMiniCartMsg(ElementType,Element,Input1);
				log_system.info("Action VerifyMiniCartMsg Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("VerifyMiniCartMsg succesfully ");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("VerifyMiniCartMsg Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "Click":
			{
				log_system.info("Action Click Selected");
				Status=act_perform.Perform_Click(ElementType,Element);
				log_system.info("Action Click Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Click Performed succesfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Action Click Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}			
			case "SelectMyAccountTab":
			{
				log_system.info("Action SelectMyAccountTab Selected");
				Status=act_perform.Perform_SelectMyAccountTab(ElementType,Element,Input1);
				log_system.info("Action SelectMyAccountTab Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("SelectMyAccountTab Performed succesfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Action SelectMyAccountTab Failed");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SetText":
			{
				log_system.info("Action Set Text Selected");
				Status=act_perform.Perform_SetText(ElementType,Element, Input1);
				log_system.info("Action Set Text Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Text Entered successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Set Text Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "Wait":
			{
				log_system.info("Action Wait");
				Status=act_perform.Perform_wait(Input1);
				if(Status==1){result_log.add("Text Entered successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Set Text Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				break;
			}
			case "ClearText":
			{
				log_system.info("Action Clear Text Selected");
				Status=act_perform.Perform_ClearText(ElementType,Element);
				log_system.info("Action Clear Text Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Clear Entered successfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Clear Text Fail:");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SearchProduct":
			{
				log_system.info("Action Search Product Selected");
				Status=act_perform.Perform_SearchProduct(ElementType,Element, Input1);
				log_system.info("Action Search Product Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Product searched successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Product Search Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SearchAndAddToWishlist":
			{
				log_system.info("Action Search And Add To Wish list Selected");
				Status=act_perform.Perform_SearchAndAddToWishlist(ElementType,Element, Input1);
				log_system.info("Action SearchAndAddToWishlist Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("SearchAndAddToWishlist successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("SearchAndAddToWishlist Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "HeaderMenuSearch":
			{
				log_system.info("Action Search Link in Header Menu");
				Status=act_perform.Perform_HeaderMenuSearch(ElementType,Element, Input1);
				log_system.info("Action Search Header Menu");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Link searched successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Link Search Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "MoveAndAddProduct":
			{
				log_system.info("Action Move & add Product");
				Status=act_perform.Perform_MoveAndAddProduct(ElementType,Element,Input1);
				log_system.info("Action Move and Add Product Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Add product successfully");result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Move and Add product Fail ");result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "MoveAndRemoveProduct":
			{
				log_system.info("Action Move & Remove Product");
				Status=act_perform.Perform_MoveAndRemoveProduct(ElementType,Element,Input1);
				log_system.info("Action Move and Remove Product Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Remove product successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Move and Remove product Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SortBy":
			{
				log_system.info("Action Sort by");
				Status=act_perform.Perform_SortBy(ElementType,Element, Input1);
				log_system.info("Action sory by Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Product sort successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("product sort Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "VerifyFooterLinks":
			{
				log_system.info("Action VerifyFooterLinks");
				Status=act_perform.Perform_VerifyFooterLinks(ElementType,Element);
				log_system.info("Action VerifyFooterLinks Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("VerifyFooterLinks successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("VerifyFooterLinks Fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SelectSubstitute":
			{
				log_system.info("Action Select Substitute for Product");
				Status=act_perform.Perform_SelectSubstitute(ElementType,Element, Input1);
				log_system.info("Action Select Substitute Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Select Substitute successfully: "+Input1+" for product: "+ Input2);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Select Substitute Fail: "+Input1+" for product: "+ Input2);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "SelectSlot":
			{
				log_system.info("Action Select slot");
				Status=act_perform.Perform_SelectSlot(ElementType,Element, Input1,Input2);
				log_system.info("Action Select Slot Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Select Slot successfully: "+Input1+"  "+ Input2);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Select slot Fail: "+Input1+" for product: "+ Input2);result_log.add("Fail");result_log.add("-");}
				log_system.info("log captured for action: "+Action);
				break;
			}
			case "CloseBrowser":
			{
				log_system.info("Action Close Browser Selected");				
				Status=act_perform.Perform_CloseBrowser(Input1);
				log_system.info("Action Close Browser Executed");
				log_system.info("Creating manual log for: "+Action+ "Current status is "+Status);
				if(Status==1){result_log.add("Action performed successfully: "+Input1);result_log.add("Pass");result_log.add("-");}
				else{ result_log.add("Action fail: "+ Input1);result_log.add("Fail");result_log.add("-");}
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
				result_log.add("action VerifyFooterLinks failed: "+ Input1);
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
				result_log.add("action Move and add product failed: "+ Input1);
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
				if(e.getMessage().contains("500"))
				{
					Driver.navigate().back();
				}
			}
		}
		
		return result_log;
	}
}
