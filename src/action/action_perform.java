package action;

import java.io.IOException;

import global_utility.global_variables;

public class action_perform extends global_variables{
	
	action_execute act_execute=new action_execute();
	int Status;
	
	public int Perform_OpenBrowser(String BrowserName) throws IOException
	{		
		log_system.info("Perform Action: Open Browser");
		Status=act_execute.OpenBrowser(BrowserName);
		return Status;
				
	}
	
	public int Perform_GetURL(String url) throws Exception
	{
		log_system.info("Perform Action: Get URL");
		Status=act_execute.URL(url);
		return Status;
	}
	
	public int Perform_VerifyURL(String url) throws Exception
	{
		log_system.info("Perform Action: Verify URL");
		Status=act_execute.VerifyURL(url);
		return Status;
	}
	
	public int Perform_VerifyText(String ElementKey,String ElementSelector,String text) throws Exception
	{
		log_system.info("Perform Action: Verify text");
		Status=act_execute.VerifyText(ElementKey,ElementSelector, text);
		return Status;
	}
	
	public int Perform_VerifyTitle(String title,String WindowType) throws Exception
	{
		log_system.info("Perform Action: verify Title");
		Status=act_execute.VerfyTitle(title,WindowType);
		return Status;
	}
	
	public int Perform_VerifyElement(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: verify Element");
		Status=act_execute.VerfyElement(ElementKey,ElementSelector);
		return Status;
	}
	
	
	
	public int Perform_VerifyNoElement(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: verify No Element");
		Status=act_execute.VerifyNoElement(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyCategoryAndProduct(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: verify No Element");
		Status=act_execute.VerifyCategoryAndProduct(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyMyAccountMenu(String ElementKey, String ElementSelector,String MenuName) throws Exception
	{
		log_system.info("Perform Action: verify No Element");
		Status=act_execute.VerifyMyAccountMenu(ElementKey,ElementSelector,MenuName);
		return Status;
	}
	
	
	public int Perform_MoveToProductList(String ElementKey, String ElementSelector,String CategoryName,String ProductListName) throws Exception
	{
		log_system.info("Perform Action: Move To Product List");
		Status=act_execute.MoveToProductList(ElementKey,ElementSelector,CategoryName,ProductListName);
		return Status;
	}
	
	public int Perform_MoveToCategory(String ElementKey, String ElementSelector,String CategoryName) throws Exception
	{
		log_system.info("Perform Action: Move To Category");
		Status=act_execute.MoveToCategory(ElementKey,ElementSelector,CategoryName);
		return Status;
	}
	
	public int Perform_VerifySiteMapFromCategoryPage(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: Move To Category");
		Status=act_execute.VerifySiteMapFromCategoryPage(ElementKey,ElementSelector);
		return Status;
	}
	
	
	public int Perform_VerifyMiniCart(String ElementKey, String ElementSelector,String CartMessage) throws Exception
	{
		log_system.info("Perform Action: Verify Mini Cart");
		Status=act_execute.VerifyMiniCart(ElementKey,ElementSelector,CartMessage);
		return Status;
	}
	
	public int Perform_AddProductfromMiniCart(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: AddProductfromMiniCart");
		Status=act_execute.AddProductfromMiniCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_RemoveProductfromMiniCart(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: RemoveProductfromMiniCart");
		Status=act_execute.RemoveProductfromMiniCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_DeleteProductfromMiniCart(String ElementKey, String ElementSelector,String RemoveAll) throws Exception
	{
		log_system.info("Perform Action: DeleteProductfromMiniCart");
		Status=act_execute.DeleteProductfromMiniCart(ElementKey,ElementSelector,RemoveAll);
		return Status;
	}
	
	public int Perform_AddProductfromViewCart(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: AddProductfromViewCart");
		Status=act_execute.AddProductfromViewCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_AddInstruction(String ElementKey, String ElementSelector,String Instruction) throws Exception
	{
		log_system.info("Perform Action: AddProductfromViewCart");
		Status=act_execute.AddInstruction(ElementKey,ElementSelector,Instruction);
		return Status;
	}
	
	public int Perform_EditInstruction(String ElementKey, String ElementSelector,String Instruction) throws Exception
	{
		log_system.info("Perform Action: AddProductfromViewCart");
		Status=act_execute.EditInstruction(ElementKey,ElementSelector,Instruction);
		return Status;
	}
	
	public int Perform_RemoveInstruction(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: AddProductfromViewCart");
		Status=act_execute.RemoveInstruction(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_RemoveProductfromViewCart(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: RemoveProductfromViewCart");
		Status=act_execute.RemoveProductfromViewCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_DeleteProductfromViewCart(String ElementKey, String ElementSelector,String DeleteAll) throws Exception
	{
		log_system.info("Perform Action: DeleteProductfromViewCart");
		Status=act_execute.DeleteProductfromViewCart(ElementKey,ElementSelector,DeleteAll);
		return Status;
	}
	
	public int Perform_VerifySummaryViewCart(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: DeleteProductfromViewCart");
		Status=act_execute.VerifySummaryViewCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyMiniCartMsg(String ElementKey, String ElementSelector,String CartMsg) throws Exception
	{
		log_system.info("Perform Action: DeleteProductfromViewCart");
		Status=act_execute.VerifyMiniCartMsg(ElementKey,ElementSelector,CartMsg);
		return Status;
	}
	
	public int Perform_Click(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: Click");
		Status=act_execute.Click(ElementKey,ElementSelector);
		return Status;
	}
	
	
	
	public int Perform_SelectMyAccountTab(String ElementKey, String ElementSelector,String MenuName) throws Exception
	{
		log_system.info("Perform Action: Click");
		Status=act_execute.SelectMyAccountTab(ElementKey,ElementSelector,MenuName);
		return Status;
	}
	
	public int Perform_SetText(String ElementKey, String ElementSelector,String InputString) throws Exception
	{
		log_system.info("Perform Action: SetText");
		Status=act_execute.SetText(ElementKey,ElementSelector,InputString);
		return Status;
	}
	
	public int Perform_wait(String WaitTime) throws Exception
	{
		log_system.info("Perform Action: Wait");
		Status=act_execute.wait(Integer.parseInt(WaitTime));
		return Status;
	}
	
	
	
	public int Perform_ClearText(String ElementKey, String ElementSelector) throws Exception
	{
		log_system.info("Perform Action: ClearText");
		Status=act_execute.ClearText(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_SearchProduct(String ElementKey, String ElementSelector,String productName)
	{
		log_system.info("Perform Action: SearchProduct");
		Status=act_execute.SearchProduct(ElementKey,ElementSelector,productName);
		return Status;
	}
	
	public int Perform_SearchAndAddToWishlist(String ElementKey, String ElementSelector,String productName) throws InterruptedException
	{
		log_system.info("Perform Action: Search And Add To Wish list");
		Status=act_execute.SearchAndAddToWishlist(ElementKey,ElementSelector,productName);
		return Status;
	}
	
	public int Perform_HeaderMenuSearch(String ElementKey, String ElementSelector,String productName)
	{
		log_system.info("Perform Action: HeaderMenuSearch");
		Status=act_execute.HeaderMenuSearch(ElementKey,ElementSelector,productName);
		return Status;
	}
	
	
	public int Perform_MoveAndAddProduct(String ElementKey, String ElementSelector,String Exist) throws InterruptedException
	{
		log_system.info("Perform Action: Move & Add Product");
		Status=act_execute.MoveAndAddProduct(ElementKey,ElementSelector,Exist);
		return Status;
	}
	
	public int Perform_MoveAndRemoveProduct(String ElementKey, String ElementSelector,String AllProduct) throws InterruptedException
	{
		log_system.info("Perform Action: Move & Add Product");
		Status=act_execute.MoveAndRemoveProduct(ElementKey,ElementSelector,AllProduct);
		return Status;
	}
	
	public int Perform_VerifyFooterLinks(String ElementKey, String ElementSelector)
	{
		log_system.info("Perform Action: Move & Add Product");
		Status=act_execute.VerifyFooterLinks(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_SelectSubstitute(String ElementKey, String ElementSelector,String Substitute_Type) throws InterruptedException
	{
		log_system.info("Perform Action: Select Substitute");
		Status=act_execute.SelectSubstitute(ElementKey,ElementSelector,Substitute_Type);
		return Status;
	}
	
	public int Perform_SortBy(String ElementKey, String ElementSelector,String SortType) throws Exception
	{
		log_system.info("Perform Action: Select Substitute");
		Status=act_execute.SortBy(ElementKey,ElementSelector,SortType);
		return Status;
	}
	
	public int Perform_SelectSlot(String ElementKey, String ElementSelector,String Selection_date,String Selection_time) throws InterruptedException
	{
		log_system.info("Perform Action: Select Slot");
		Status=act_execute.SelectSlot(ElementKey,ElementSelector,Selection_date,Selection_time);
		return Status;
	}
	
	public int Perform_CloseBrowser(String Browser_type) throws Exception 
	{
		log_system.info("Perform Action: Close Browser");
		Status=act_execute.CloseBrowser(Browser_type);		
		return Status; 
	}
	
	public void Perform_QuitDriver() throws Exception
	{
		log_system.info("Perform Action: Quit Driver");
		act_execute.QuitDriver();		
		
	}
}
