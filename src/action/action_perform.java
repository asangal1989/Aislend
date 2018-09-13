package action;

import java.io.IOException;

import global_utility.global_variables;

public class action_perform extends global_variables{
	
	action_execute act_execute=new action_execute();
	int Status;
	
	public int Perform_OpenBrowser(String Environment,String BrowserName) throws IOException, InterruptedException
	{		
		Status=act_execute.OpenBrowser(Environment,BrowserName);
		return Status;
				
	}
	
	public int Perform_GetURL(String url) throws Exception
	{		
		Status=act_execute.URL(url);
		return Status;
	}
	
	public int Perform_VerifyURL(String url) throws Exception
	{
		
		Status=act_execute.VerifyURL(url);
		return Status;
	}
	
	public int Perform_VerifyText(String ElementKey,String ElementSelector,String text) throws Exception
	{
		
		Status=act_execute.VerifyText(ElementKey,ElementSelector, text);
		return Status;
	}
	
	public int Perform_VerifyTitle(String title,String WindowType) throws Exception
	{
		
		Status=act_execute.VerfyTitle(title,WindowType);
		return Status;
	}
	
	
	public int Perform_VerifyElement(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.VerfyElement(ElementKey,ElementSelector);
		return Status;
	}
	
	
	
	public int Perform_VerifyNoElement(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.VerifyNoElement(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyCategoryAndProduct(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.VerifyCategoryAndProduct(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyMyAccountMenu(String ElementKey, String ElementSelector,String MenuName) throws Exception
	{
		
		Status=act_execute.VerifyMyAccountMenu(ElementKey,ElementSelector,MenuName);
		return Status;
	}
	
	
	public int Perform_MoveToProductList(String ElementKey, String ElementSelector,String CategoryName,String ProductListName) throws Exception
	{
		
		Status=act_execute.MoveToProductList(ElementKey,ElementSelector,CategoryName,ProductListName);
		return Status;
	}
	
	public int Perform_MoveToCategory(String ElementKey, String ElementSelector,String CategoryName) throws Exception
	{
		
		Status=act_execute.MoveToCategory(ElementKey,ElementSelector,CategoryName);
		return Status;
	}
	
	public int Perform_VerifySiteMapFromCategoryPage(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.VerifySiteMapFromCategoryPage(ElementKey,ElementSelector);
		return Status;
	}
	
	
	public int Perform_VerifyMiniCart(String ElementKey, String ElementSelector,String CartMessage) throws Exception
	{

		Status=act_execute.VerifyMiniCart(ElementKey,ElementSelector,CartMessage);
		return Status;
	}
	
	public int Perform_VerifyBrokenLink() throws Exception
	{
		
		Status=act_execute.VerifyBrokenLink();
		return Status;
	}
	
	public int Perform_AddProductfromMiniCart(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.AddProductfromMiniCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_RemoveProductfromMiniCart(String ElementKey, String ElementSelector) throws Exception
	{

		Status=act_execute.RemoveProductfromMiniCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_DeleteProductfromMiniCart(String ElementKey, String ElementSelector,String RemoveAll) throws Exception
	{
		
		Status=act_execute.DeleteProductfromMiniCart(ElementKey,ElementSelector,RemoveAll);
		return Status;
	}
	
	public int Perform_AddProductfromViewCart(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.AddProductfromViewCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_AddInstruction(String ElementKey, String ElementSelector,String Instruction) throws Exception
	{

		Status=act_execute.AddInstruction(ElementKey,ElementSelector,Instruction);
		return Status;
	}
	
	public int Perform_EditInstruction(String ElementKey, String ElementSelector,String Instruction) throws Exception
	{

		Status=act_execute.EditInstruction(ElementKey,ElementSelector,Instruction);
		return Status;
	}
	
	public int Perform_RemoveInstruction(String ElementKey, String ElementSelector) throws Exception
	{

		Status=act_execute.RemoveInstruction(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_RemoveProductfromViewCart(String ElementKey, String ElementSelector) throws Exception
	{

		Status=act_execute.RemoveProductfromViewCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_DeleteProductfromViewCart(String ElementKey, String ElementSelector,String DeleteAll) throws Exception
	{
		
		Status=act_execute.DeleteProductfromViewCart(ElementKey,ElementSelector,DeleteAll);
		return Status;
	}
	
	public int Perform_VerifySummaryViewCart(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.VerifySummaryViewCart(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyMiniCartMsg(String ElementKey, String ElementSelector,String CartMsg) throws Exception
	{
		
		Status=act_execute.VerifyMiniCartMsg(ElementKey,ElementSelector,CartMsg);
		return Status;
	}
	
	public int Perform_Click(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.Click(ElementKey,ElementSelector);
		return Status;
	}
	
	
	
	public int Perform_SelectMyAccountTab(String ElementKey, String ElementSelector,String MenuName) throws Exception
	{
		
		Status=act_execute.SelectMyAccountTab(ElementKey,ElementSelector,MenuName);
		return Status;
	}
	
	public int Perform_SetText(String ElementKey, String ElementSelector,String InputString) throws Exception
	{
		
		Status=act_execute.SetText(ElementKey,ElementSelector,InputString);
		return Status;
	}
	
	public int Perform_wait(String WaitTime) throws Exception
	{
		
		Status=act_execute.wait(Integer.parseInt(WaitTime));
		return Status;
	}
	
	
	
	public int Perform_ClearText(String ElementKey, String ElementSelector) throws Exception
	{
		
		Status=act_execute.ClearText(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_SearchProduct(String ElementKey, String ElementSelector,String productName)
	{
		
		Status=act_execute.SearchProduct(ElementKey,ElementSelector,productName);
		return Status;
	}
	
	public int Perform_SearchAndAddToWishlist(String ElementKey, String ElementSelector,String productName) throws InterruptedException
	{
	
		Status=act_execute.SearchAndAddToWishlist(ElementKey,ElementSelector,productName);
		return Status;
	}
	
	public int Perform_HeaderMenuSearch(String ElementKey, String ElementSelector,String productName)
	{
		
		Status=act_execute.HeaderMenuSearch(ElementKey,ElementSelector,productName);
		return Status;
	}
	
	
	public int Perform_MoveAndAddProduct(String ElementKey, String ElementSelector,String Exist) throws InterruptedException
	{
		
		Status=act_execute.MoveAndAddProduct(ElementKey,ElementSelector,Exist);
		return Status;
	}
	
	public int Perform_MoveAndRemoveProduct(String ElementKey, String ElementSelector,String AllProduct) throws InterruptedException
	{
		
		Status=act_execute.MoveAndRemoveProduct(ElementKey,ElementSelector,AllProduct);
		return Status;
	}
	
	public int Perform_VerifyFooterLinks(String ElementKey, String ElementSelector)
	{
		
		Status=act_execute.VerifyFooterLinks(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_VerifyPopularMultiLink(String ElementKey, String ElementSelector)
	{
		
		Status=act_execute.VerifyPopularMultiLink(ElementKey,ElementSelector);
		return Status;
	}
	
	public int Perform_SelectSubstitute(String ElementKey, String ElementSelector,String Substitute_Type) throws InterruptedException
	{
		
		Status=act_execute.SelectSubstitute(ElementKey,ElementSelector,Substitute_Type);
		return Status;
	}
	
	public int Perform_SortBy(String ElementKey, String ElementSelector,String SortType) throws Exception
	{
		
		Status=act_execute.SortBy(ElementKey,ElementSelector,SortType);
		return Status;
	}
	
	public int Perform_SelectSlot(String ElementKey, String ElementSelector,String Selection_date,String Selection_time) throws InterruptedException
	{
		
		Status=act_execute.SelectSlot(ElementKey,ElementSelector,Selection_date,Selection_time);
		return Status;
	}
	
	public int Perform_CloseBrowser(String Browser_type) throws Exception 
	{
		
		Status=act_execute.CloseBrowser(Browser_type);		
		return Status; 
	}
	
	public void Perform_QuitDriver() throws Exception
	{
		
		act_execute.QuitDriver();		
		
	}
}
