package action;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.util.ArrayList;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;

import elements_ui.element_locator;
import global_utility.global_variables;
import global_utility.handle_ajax_call;
import global_utility.random_email;
import global_utility.video_capture;


public class action_execute extends global_variables{
	
	video_capture recorder=new video_capture();
	random_email r_email=new random_email();
	int Status=0;
	element_locator element_loc=new element_locator();
	By element_locator=null;
	
	public int OpenBrowser(String Environment,String BrowserName) throws IOException, InterruptedException
	{		
		Properties prop=new Properties();
		InputStream in=new FileInputStream(path_lib_properties+"config_webdriver.properties");
		prop.load(in);
		log_system.info("Open Env: "+ Environment );
		log_system.info("Open Browser: "+ BrowserName );
		switch(Environment)
		{
			case "Window":
			{
				switch(BrowserName)
				{			
				case "Chrome":
				{
					log_system.info("Set Configuration for Browser: "+ BrowserName );
					System.setProperty(prop.getProperty("property_chromeDriver"),path_lib_driver+ prop.getProperty("Path_chromeDriver"));
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
				    chromePrefs.put("download.default_directory", path_lib_download);
				    ChromeOptions options = new ChromeOptions();
				    HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				    options.setExperimentalOption("prefs", chromePrefs);
				    options.addArguments("start-maximized");
				    DesiredCapabilities cap = DesiredCapabilities.chrome();
				    cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				    cap.setCapability(ChromeOptions.CAPABILITY, options);
				    log_system.info("Creating object for browser"+ BrowserName );
				    Driver = new ChromeDriver(cap);
				    log_system.info("Browser Opened successfully: "+ BrowserName );
				    log_system.info("Deleting all cookies for: "+ BrowserName );
				    Driver.manage().deleteAllCookies();
				    Status=1;
				    mainwindow=Driver.getWindowHandle();
				    break;
				}
				case "FireFox":
				{
					System.setProperty(prop.getProperty("property_firefoxDriver"),path_lib_driver+ prop.getProperty("Path_firefoxDriver"));
					DesiredCapabilities capabilities=DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
				    Driver = new FirefoxDriver(capabilities);
				    Driver.manage().deleteAllCookies();
				    mainwindow=Driver.getWindowHandle();
				    Status=1;
				    log_system.info("Browser Opened successfully: "+ BrowserName );
				    break;
				}
				case "IE11":
				{
					System.setProperty(prop.getProperty("property_IEDriver"),path_lib_driver+ prop.getProperty("Path_IEDriver"));
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
					capabilities.setCapability("requireWindowFocus", true);
					capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
					capabilities.setCapability(CapabilityType.VERSION, "11");
					capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
					Driver = new InternetExplorerDriver(capabilities);
					Driver = new InternetExplorerDriver();
					Driver.manage().deleteAllCookies();
				    Status=1;
				    log_system.info("Browser Opened successfully: "+ BrowserName );
				    mainwindow=Driver.getWindowHandle();
				    break;
				}
				}
			}
			case "Android":
			{
				switch(BrowserName)
				{			
				case "Chrome":
				{
					
					log_system.info("Set Configuration for Browser: "+ BrowserName );					

					
					System.setProperty(prop.getProperty("property_chromeDriver"),path_lib_driver+ prop.getProperty("Path_chromeDriver"));
					HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
					chromePrefs.put("profile.default_content_settings.popups", 0);
				    chromePrefs.put("download.default_directory", path_lib_download);
				    ChromeOptions options = new ChromeOptions();
				    HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				    options.setExperimentalOption("prefs", chromePrefs);
				    options.addArguments("start-maximized");
					
					
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				    caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				    caps.setCapability(ChromeOptions.CAPABILITY, options);
				    log_system.info("Creating object for browser"+ BrowserName );
				    caps.setCapability("app-wait-activity", "activity-to-wait-for");
					/*caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi111");
					caps.setCapability(MobileCapabilityType.UDID, "5a0c7cb7d140"); //Give Device ID of your mobile phone
					caps.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);
					caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.2");	
					caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.APPIUM);
					caps.setCapability(MobileCapabilityType.NO_RESET, true);
					caps.setCapability(MobileCapabilityType.FULL_RESET, false);
					caps.setCapability("appPackage", "com.android.chrome");*/
					caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
					/*caps.setCapability("noReset", "true");*/
				/*	Driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);*/
					
					 
					log_system.info("Browser Opened successfully: "+ BrowserName );
				    log_system.info("Deleting all cookies for: "+ BrowserName );
				  //  driver.manage().deleteAllCookies();
				    Status=1;
				  //  mainwindow=driver.getWindowHandle();
				    break;
				}
				
				}
			}
		}
		
		log_system.info("Status of Open Browser: "+Status);
		return Status;

	}
	
	public int URL(String url) throws Exception
	{				
		Driver.get(url);
		Status=1;
		log_system.info("URL opened Successfully: "+ url);
		log_system.info("Status of Get URL: "+Status);
		return Status;
	}
	
	public int VerifyURL(String url) throws Exception
	{				
		if(Driver.getCurrentUrl().contains(url))Status=1;		
		log_system.info("URL verification Done: "+ url);
		log_system.info("Status of verify URL: "+Status);
		return Status;
	}
	
	public int VerifyText(String ElementKey,String ElementSelector,String text) throws Exception
	{		
		Thread.sleep(2000);
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		System.out.println(Driver.findElement(element_locator).getText().trim().toLowerCase().replace("\"", ""));
		System.out.println(text);
		if(Driver.findElement(element_locator).getText().trim().toLowerCase().replace("\"", "").contains(text.toString().trim().toLowerCase()))
		{			
			Status=1;
			log_system.info("Verify Element");
			log_system.info("Status of verify Element: "+Status);
		}				
		
		return Status;
	}
	
	public int VerfyTitle(String title,String WindowType) throws Exception
	{
		if(WindowType.contains("Child"))
		{
			 for (String winHandle : Driver.getWindowHandles()) {
				 if(!winHandle.equals(mainwindow))
				 {		
					 Driver.switchTo().window(winHandle);			 
					 if(Driver.switchTo().window(winHandle).getTitle().toString().equals(title.toString()))Status=1;
						log_system.info("title verified: "+ title);
						log_system.info("Status of verify Title: "+Status);				
				 }
			        
			    }
			
		}
		else
		{
			if(Driver.getTitle().toString().equals(title.toString()))Status=1;
			log_system.info("title verified: "+ title);
			log_system.info("Status of verify Title: "+Status);
		}
		
		return Status;
	}
	
	public int VerfyElement(String ElementKey, String ElementSelector) 
	{		
		try
		{			
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			Actions act=new Actions(Driver);
			act.moveToElement(Driver.findElement(element_locator)).build().perform();
			if(Driver.findElement(element_locator).isDisplayed())
				Status=1;	
			else
				Status=0;
			
		}
		catch(Exception e)
		{
			Status=0;
		}
		log_system.info("Verify Element");
		log_system.info("Status of verify Element: "+Status);
		return Status;
	}
	
	
	
	
	public int VerifyNoElement(String ElementKey, String ElementSelector) throws InterruptedException 
	{	
		Thread.sleep(2000);
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		if(Driver.findElement(element_locator).isDisplayed())		
			Status=0;		
		else		
			Status=1;		
		log_system.info("Verify No Element");
		log_system.info("Status of verify No Element: "+Status);
		return Status;
	}
	
	
	public int VerifyFooterLinks(String ElementKey, String ElementSelector) 
	{	
		int verifyFooterCount=0;
		ArrayList<String> categoryList=new ArrayList<String>();
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebElement FooterLink=Driver.findElement(element_locator);
		List<WebElement> FotterLink_lst=FooterLink.findElements(By.xpath("//ul[normalize-space(@class) = 'categories-list']"));
		for(WebElement footerLnk_itr:FotterLink_lst)
		{
			List<WebElement> footer_category=footerLnk_itr.findElements(By.tagName("li"));
			for(WebElement category:footer_category)
			{
				if(category.getText().length()>0)
				categoryList.add(category.getText());
			}
		}
		
		for(String categoryName:categoryList)
		{
			WebElement category_ele=Driver.findElement(By.linkText(categoryName));
			act.moveToElement(category_ele).build().perform();
			String old_url=Driver.getCurrentUrl();
			category_ele.click();
			String current_url=Driver.getCurrentUrl();
			if(old_url!=current_url)
			{
				
				Driver.navigate().back();	
			}
			else
			{
				verifyFooterCount++;
			}			
		}
		
		if(verifyFooterCount>0)
		{
			Status=0;
		}
		else
		{
			Status=1;	
		}
		log_system.info("VerifyFooterLinks");
		log_system.info("Status of VerifyFooterLinks: "+Status);
		return Status;
	}
	
	public int VerifyPopularMultiLink(String ElementKey, String ElementSelector) 
	{	
		int verifyFooterCount=0;
		ArrayList<String> categoryList=new ArrayList<String>();
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebElement FooterLink=Driver.findElement(element_locator);
		List<WebElement> FotterLink_lst=FooterLink.findElements(By.xpath(".//div[normalize-space(@class) = 'multilinks__item']"));
		
		
		for(WebElement footerLnk_itr:FotterLink_lst)
		{
			if(footerLnk_itr.getText().length()>0)
				categoryList.add(footerLnk_itr.getText());			
		}
		
		for(String categoryName:categoryList)
		{
			WebElement category_ele=Driver.findElement(By.linkText(categoryName));
			act.moveToElement(category_ele).build().perform();
			String old_url=Driver.getCurrentUrl();
			category_ele.click();
			String current_url=Driver.getCurrentUrl();
			if(old_url!=current_url)
			{
				
				Driver.navigate().back();	
			}
			else
			{
				verifyFooterCount++;
			}			
		}
		
		
		
		if(verifyFooterCount==0)
		{
			Status=1;
		}
		
		log_system.info("VerifyFooterLinks");
		log_system.info("Status of VerifyFooterLinks: "+Status);
		return Status;
	}

	public int VerifyMyAccountMenu(String ElementKey, String ElementSelector,String MenuName) 
	{	
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement menu=Driver.findElement(element_locator);
		List<WebElement> menu_list=menu.findElements(By.tagName("li"));
		for(WebElement menu_list_itr:menu_list)
		{
			if(menu_list_itr.getText().toLowerCase().equals(MenuName.toLowerCase()))
			{
				Actions act=new Actions(Driver);
				act.moveToElement(menu_list_itr).build().perform();
				Status=1;
				break;
			}
		
		
		}
		
				
		log_system.info("VerifyMyAccountMenu");
		log_system.info("Status of VerifyMyAccountMenu: "+Status);
		return Status;
	}

	
	
	
	@SuppressWarnings({ "unused" })
	public int VerifyCategoryAndProduct(String ElementKey, String ElementSelector) 
	{	
		int divcount=0;
		LinkedHashMap<String, ArrayList<String>> category_product_details= new LinkedHashMap<String, ArrayList<String>>();
		ArrayList<String> error =new ArrayList<>();
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement element;
		List<WebElement> element_list = null;
		
		element=Driver.findElement(element_locator);
		element_list=element.findElements(By.xpath("li"));
		int count=0;
		
		for(WebElement Category_product:element_list)
		{
			
			count++;
			
		}
		
		try {
			for(int i=1;i<=count;i++)
			{ 
 				Driver.findElement(By.xpath("//a[normalize-space(@class) = 'header__category-trigger hidden-xs']")).click();
				int productcount=0;								
				WebElement category = null;
				category = Driver.findElement(By.xpath("//li[starts-with(@class, 'level0 nav-"+i+"')]//div[normalize-space(@class) = 'mmenu__parent-category']//a[normalize-space(@class) = 'mmenu__parent-category-link level-top']"));
				Actions act=new Actions(Driver);
				act.moveToElement(category).build().perform();
				String categoryName=category.getText();
				WebElement product_li_temp=null;
				
				product_li_temp=category.findElement(By.xpath("//li[starts-with(@class, 'level0 nav-"+i+"')]/div[normalize-space(@class) = 'mmenu__sub-category-container']//div[normalize-space(@class) = 'mmenu__sub-category']//ul[normalize-space(@class) = 'level0 submenu']"));
				List<WebElement> product_li=null;
				product_li=product_li_temp.findElements(By.tagName("li"));
				ArrayList<String> ProductListmenu=new ArrayList<>();
				for(WebElement Product_count:product_li)
				{
										
					productcount++;					
					WebElement product=null;
					product=Product_count;
					act.moveToElement(product).build().perform();
					String productName=product.getText();
					if(productName.length()>0)
					ProductListmenu.add(productName.toLowerCase());
					
				}
				
				log_system.info("Product list get for categry: "+ categoryName);
				System.out.println(category.getText());
				category.click();
				handle_ajax_call.HandleAjaxCall();
				log_system.info("Verify Product by category: "+ categoryName);
				WebElement ProductListPagebycategory=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'cl__subcategories-list']"));				
				List<WebElement> ProductList_li=ProductListPagebycategory.findElements(By.tagName("li"));
				
				ArrayList<String> ProductListCategoryPage=new ArrayList<>();
				for(WebElement ProductList_li_itra:ProductList_li)
				{						
					act.moveToElement(ProductList_li_itra).build().perform();					
					ProductListCategoryPage.add(ProductList_li_itra.getText().toLowerCase());					
				}

				if(!ProductListCategoryPage.equals(ProductListmenu))
				{
					error.add("Product List mismatch for category: "+ categoryName);
				}
				
				if(error.size()>0)
				{
 					Status=0;
				}
				else
				{
					Status=1;
				}
			}
		} catch (Exception e) {
			Driver.get(Driver.getCurrentUrl());
			Status=0;
		}
		

		log_system.info("Status of verify Category and Product on Home Page: "+Status);
		return Status;
	}
	
	@SuppressWarnings({ "unused" })
	public int VerifySiteMapFromCategoryPage(String ElementKey, String ElementSelector) 
	{	
		int sitemapcount=0;
		int divcount=0;
		LinkedHashMap<String, ArrayList<String>> category_product_details= new LinkedHashMap<String, ArrayList<String>>();
		ArrayList<String> error =new ArrayList<>();
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement element;
		List<WebElement> element_list = null;		
		element=Driver.findElement(element_locator);
		element_list=element.findElements(By.xpath("li"));
		int count=0;
		
		for(WebElement Category_product:element_list)
		{
			
			count++;
			
		}
		Driver.findElement(By.xpath("//a[normalize-space(@class) = 'header__category-trigger hidden-xs']")).click();
		try {
			LinkedHashMap<String, ArrayList<String>> CategoryandSubCategory_list=new LinkedHashMap<String,ArrayList<String>>();
			
			for(int i=1;i<=count;i++)
			{
				 				
											
				WebElement category = null;
				category = Driver.findElement(By.xpath("//li[starts-with(@class, 'level0 nav-"+i+"')]//div[normalize-space(@class) = 'mmenu__parent-category']//a[normalize-space(@class) = 'mmenu__parent-category-link level-top']"));
				Actions act=new Actions(Driver);
				act.moveToElement(category).build().perform();
				String categoryName=category.getText();
				WebElement product_li_temp=null;
				
				product_li_temp=category.findElement(By.xpath("//li[starts-with(@class, 'level0 nav-"+i+"')]/div[normalize-space(@class) = 'mmenu__sub-category-container']//div[normalize-space(@class) = 'mmenu__sub-category']//ul[normalize-space(@class) = 'level0 submenu']"));
				List<WebElement> product_li=null;
				product_li=product_li_temp.findElements(By.tagName("li"));
				ArrayList<String> SubCategory=new ArrayList<String>();
				for(WebElement Product_subcategory:product_li)
				{
										
					String productName=Product_subcategory.getText();
					if(productName.length()>0)
						SubCategory.add(productName.toLowerCase());
					
				}
				CategoryandSubCategory_list.put(categoryName, SubCategory);	
			}
			Driver.get(Driver.getCurrentUrl());;
			Set<String> CategorySet=CategoryandSubCategory_list.keySet();
			count=0;
			for(String Category_itr:CategorySet)
			{
				count++;
				Driver.findElement(By.xpath("//a[normalize-space(@class) = 'header__category-trigger hidden-xs']")).click();
				WebElement category = Driver.findElement(By.xpath("//li[starts-with(@class, 'level0 nav-"+count+"')]//div[normalize-space(@class) = 'mmenu__parent-category']//a[normalize-space(@class) = 'mmenu__parent-category-link level-top']"));
				Actions act=new Actions(Driver);
				act.moveToElement(category).build().perform();
				category.click();
				ArrayList<String> Subcategory_list=CategoryandSubCategory_list.get(Category_itr);
				for(String Subcategory:Subcategory_list)
				{
					WebElement subcategory_ele=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'cl__subcategories-list']")); 				
					List<WebElement> product_li=subcategory_ele.findElements(By.tagName("li"));
					List<WebElement> product_li_random=new ArrayList<WebElement>();
					for(int i=0;i<2;i++)
					{
						Random rdm=new Random();							
						int index=rdm.nextInt(product_li.size());
						WebElement ProductName=product_li.get(index);						
						product_li_random.add(ProductName);
					}					
					for(WebElement subcategory:product_li_random)
					{
						if(subcategory.getText().toLowerCase().contains(Subcategory.toLowerCase()))
						{
							act.moveToElement(subcategory).build().perform();
							subcategory.click();
							act.moveToElement(Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'items breadcrumbs__list']"))).build().perform();
							String Sitemap=Driver.findElement(By.xpath("//ul[normalize-space(@class) = 'items breadcrumbs__list']")).getText();
							if(Sitemap.toLowerCase().contains(Category_itr.toLowerCase()) && Sitemap.toLowerCase().contains(Subcategory.toLowerCase()))
							{
								
							}
							else
							{
								sitemapcount++;
							}
							Driver.navigate().back();
							break;
						}
					}
				}
				
			}
			
		} catch (Exception e) {
			
			Status=0;
		}
		if(sitemapcount>0)
		{
			Status=0;
		}
		else
		{
			Status=1;
		}
		log_system.info("Status of verify Category and Product on Home Page: "+Status);
		return Status;
	}
	
	
	
	
	
	
	
	@SuppressWarnings("unused")
	public int MoveToProductList(String ElementKey, String ElementSelector,String CategoryName,String ProductListName) 
	{	
		
		int divcount=0;
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement element;
		List<WebElement> element_list = null;
		
		element=Driver.findElement(element_locator);
		element_list=element.findElements(By.xpath("li"));
		int count=0;
		
		for(WebElement Category_product:element_list)
		{
			
			count++;
			
		}
		
		try {
			Driver.findElement(By.xpath("//a[normalize-space(@class) = 'header__category-trigger hidden-xs']")).click();
			loop_break:
			for(int i=1;i<=count;i++)
			{
				
				int productcount=0;
				
				WebElement category=null;
				category = Driver.findElement(By.xpath("//li[starts-with(@class, 'level0 nav-"+i+"')]//div[normalize-space(@class) = 'mmenu__parent-category']//a[normalize-space(@class) = 'mmenu__parent-category-link level-top']"));				
				Actions act=new Actions(Driver);
				act.moveToElement(category).build().perform();
				
				String categoryName=category.getText();
				
				if(categoryName.toLowerCase().equals(CategoryName.toLowerCase()))
				{
					WebElement product_li_temp=null;					
					product_li_temp=category.findElement(By.xpath("//li[starts-with(@class, 'level0 nav-"+i+"')]/div[normalize-space(@class) = 'mmenu__sub-category-container']//div[normalize-space(@class) = 'mmenu__sub-category']//ul[normalize-space(@class) = 'level0 submenu']"));
					List<WebElement> product_li=null;
					product_li=product_li_temp.findElements(By.tagName("li"));
					ArrayList<String> ProductListmenu=new ArrayList<>();
					for(WebElement Product_count:product_li)
					{
						productcount++;
						WebElement product = null;
						product=Product_count;
						act.moveToElement(product).build().perform();
						String productName=product.getText();
						if(productName.toLowerCase().equals(ProductListName.toLowerCase()))
						{
							product.click();
							Status=1;
							log_system.info("User navigated to: "+ categoryName+" --> "+productName);
							break loop_break;
						}												
					}

				}
					
			}
		} catch (Exception e) {

			log_system.info("User not navigated");
			Status=0;
		}
				
		log_system.info("Status of verify Category and Product on Home Page: "+Status);
		return Status;
	}
	
	@SuppressWarnings("unused")
	public int MoveToCategory(String ElementKey, String ElementSelector,String CategoryName) 
	{	
		int divcount=0;
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement element;
		List<WebElement> element_list = null;
		
		element=Driver.findElement(element_locator);
		element_list=element.findElements(By.xpath("li"));
		int count=0;
		
		for(WebElement Category_product:element_list)
		{
			
			count++;
			
		}
		
		try {
			Driver.findElement(By.xpath("//a[normalize-space(@class) = 'header__category-trigger hidden-xs']")).click();
			loop_break:
			for(int i=1;i<=count;i++)
			{				
				int productcount=0;				
				WebElement category=null;
				category = Driver.findElement(By.xpath("//li[starts-with(@class, 'level0 nav-"+i+"')]//div[normalize-space(@class) = 'mmenu__parent-category']//a[normalize-space(@class) = 'mmenu__parent-category-link level-top']"));				
				Actions act=new Actions(Driver);
				act.moveToElement(category).build().perform();				
				String categoryName=category.getText();
				if(categoryName.toLowerCase().equals(CategoryName.toLowerCase()))
				{
					category.click();
					log_system.info("Category found and clicked: " + categoryName);
					Status=1;
				}
			}
		} catch (Exception e) {

			log_system.info("User not navigated");
			Status=0;
		}
				
		log_system.info("Status of verify Category and Product on Home Page: "+Status);
		return Status;
	}

	
	

	public int VerifyMiniCart(String ElementKey, String ElementSelector,String cartmessage) 
	{
		ArrayList<String> error_log=new ArrayList<>();
		try {
			
 			if(Product_added_details.isEmpty())
			{
 				element_locator=element_loc.getElement(ElementKey, ElementSelector);
 				WebElement block_content=Driver.findElement(element_locator);
 				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
 				block_content=block_content.findElement(By.tagName("strong"));
 				
 				if(block_content.getText().trim().equals(cartmessage.trim()))
 				{
 					log_system.info("correct message appearing for minicart empty");
 				}
 				else
 				{
 					error_log.add("Incorrect message for minicart empty");
 				}
			}
			else
			{
				element_locator=element_loc.getElement(ElementKey, ElementSelector);
				WebElement block_content=Driver.findElement(element_locator);
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart__upper-container _block']"));
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'subtotal']"));
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'amount price-container']"));

				float minicartprice=Float.parseFloat(block_content.getText().replace("$", ""));
				Set<String> Product_added_details_itrator=Product_added_details.keySet();
				float totalprice=0;
				
				for(String price_list:Product_added_details_itrator)
				{
					String price=Product_added_details.get(price_list).get(0).replace("$","");
					String offer_price=Product_added_details.get(price_list).get(1);
					if(offer_price!=null)
					{
						offer_price=offer_price.replace("$", "");
						price=offer_price;
					}
					float product_count=Float.parseFloat(Product_added_details.get(price_list).get(2));
					price=String.valueOf(Float.parseFloat(price)*product_count);
					totalprice=Float.parseFloat(price)+totalprice;
					
				}
				
				BigDecimal bd = new BigDecimal(totalprice);
				totalprice =Float.parseFloat(String.valueOf(bd.setScale(2, RoundingMode.HALF_UP)));
			    
				if(totalprice==minicartprice)
				{
					block_content=Driver.findElement(element_locator);
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart-items-wrapper minicart__items-wrapper _block']"));
					block_content=block_content.findElement(By.tagName("ol"));
					List<WebElement> product_li=block_content.findElements(By.tagName("li"));
					
					for(WebElement product_li_itrate:product_li)
					{
											
						
						String minicart_ProductName=product_li_itrate.findElement(By.xpath(".//strong[normalize-space(@class) = 'product-item-name minicart__product-item-name _block']")).getText();
						WebElement ele_minicart_ProductCount=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
						ele_minicart_ProductCount=ele_minicart_ProductCount.findElement(By.tagName("input"));
						String minicart_ProductCount=ele_minicart_ProductCount.getAttribute("data-item-qty");
						WebElement ele_minicart_ProductPrice=product_li_itrate.findElement(By.xpath(".//span[@class='price']"));												
						String minicart_ProductPrice=ele_minicart_ProductPrice.getText();
						if(Product_added_details.containsKey(minicart_ProductName))
						{
							
							String ProductPrice=Product_added_details.get(minicart_ProductName).get(0);
							String offer_price=Product_added_details.get(minicart_ProductName).get(1);
							if(offer_price!=null)
							{
								ProductPrice=offer_price;
							}
							if(minicart_ProductPrice.equals(ProductPrice))
							{
								String ProductCount=Product_added_details.get(minicart_ProductName).get(2);
								if(minicart_ProductCount.equals(ProductCount))
								{
									log_system.info("Product details mapped for: "+ minicart_ProductName);
								}
								else
								{
									error_log.add("Incorrect count details for: "+ minicart_ProductName);
									log_system.info("Incorrect count details for: "+ minicart_ProductName);
								}
							}
							else
							{
								error_log.add("Incorrect price details for: "+ minicart_ProductName);
								log_system.info("Incorrect price details for: "+ minicart_ProductName);
							}
						}
						else
						{
							error_log.add("Incorrect Product Name for: "+ minicart_ProductName);
							log_system.info("Incorrect Product Name for: "+ minicart_ProductName);
							
						}
						
					}
				}
				else
				{
					error_log.add("Incorrect Product total price");
					log_system.info("Incorrect Product total price");
				}
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}		
		if(error_log.isEmpty())
			Status=1;
		else
			Status=0;
		
		return Status;
	}
	
	public int VerifyBrokenLink() throws IOException 
	{
		HttpURLConnection huc = null;
		String url = null;
		int respCode = 200;
		List<WebElement> links = Driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		int errorcount=0;
		while(it.hasNext())
		{
            
            url = it.next().getAttribute("href");
            
            try {

				if(url!=null && !url.contains("javascript:void(0)") && !url.contains("tel:"))
				{
	            	
					
					huc = (HttpURLConnection)(new java.net.URL(url).openConnection());
				    
				    huc.setRequestMethod("HEAD");
				    
				    huc.connect();
				    
				    respCode = huc.getResponseCode();
				    
				    if(respCode >= 400){
				        System.out.println(url+" is a broken link");
				        log_system.error(url+" is a broken link");
				        errorcount++;
				    }            
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
            
		}
		
		if(errorcount==0)
		{
			Status=1;
		}
		return Status;
	}
	
	
	@SuppressWarnings("unused")
	public int VerifyMiniCartMsg(String ElementKey, String ElementSelector,String cartmessage) 
	{
		ArrayList<String> error_log=new ArrayList<>();
		try {
			
 			if(Product_added_details.isEmpty())
			{
 				element_locator=element_loc.getElement(ElementKey, ElementSelector);
 				WebElement block_content=Driver.findElement(element_locator);
 				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
 				block_content=block_content.findElement(By.tagName("strong"));
 				
 				if(block_content.getText().trim().equals(cartmessage.trim()))
 				{
 					log_system.info("correct message appearing for minicart empty");
 				}
 				else
 				{
 					error_log.add("Incorrect message for minicart empty");
 				}
			}
			else
			{
				
				float Total_Cost=0;
				do
				{
					element_locator=element_loc.getElement(ElementKey, ElementSelector);
					WebElement block_content=Driver.findElement(element_locator);
					Total_Cost=Float.parseFloat(block_content.findElement(By.xpath(".//div[normalize-space(@class) = 'amount price-container']")).getText().replace("$", ""));					
					if(Total_Cost<35)
					{
						String ProductName=null; 
						Random rdm=new Random();
						ArrayList<String> product_list_Collection=new ArrayList<String>();
						Set<String> product_category_set=Product_added_details.keySet();
						for(String product_name:product_category_set)
						{
							product_list_Collection.add(product_name);
						}			
						int index=rdm.nextInt(product_list_Collection.size());
						ProductName=product_list_Collection.get(index);
						
						
						block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart__upper-container _block']"));
						block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'subtotal']"));
						block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'amount price-container']"));

						float minicartprice=Float.parseFloat(block_content.getText().replace("$", ""));
						Set<String> Product_added_details_itrator=Product_added_details.keySet();
						float totalprice=0;
						
						for(String price_list:Product_added_details_itrator)
						{
							String price=Product_added_details.get(price_list).get(0).replace("$","");
							String price_offer=Product_added_details.get(price_list).get(1);
							if(price_offer!=null)
							{
								price_offer=price_offer.replace("$", "");
								price=price_offer;
							}
							float product_count=Float.parseFloat(Product_added_details.get(price_list).get(2));
							price=String.valueOf(Float.parseFloat(price)*product_count);
							totalprice=Float.parseFloat(price)+totalprice;
							
						}
						
						BigDecimal bd = new BigDecimal(totalprice);
						totalprice =Float.parseFloat(String.valueOf(bd.setScale(2, RoundingMode.HALF_UP)));
					    
						if(totalprice==minicartprice)
						{
							block_content=Driver.findElement(element_locator);
							block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
							block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart-items-wrapper minicart__items-wrapper _block']"));
							block_content=block_content.findElement(By.tagName("ol"));
							List<WebElement> product_li=block_content.findElements(By.tagName("li"));
							
							for(WebElement product_li_itrate:product_li)
							{
												
								String minicart_ProductName=product_li_itrate.findElement(By.xpath(".//strong[normalize-space(@class) = 'product-item-name minicart__product-item-name _block']")).getText();
								WebElement ele_minicart_ProductCount=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
								ele_minicart_ProductCount=ele_minicart_ProductCount.findElement(By.tagName("input"));
								String minicart_ProductCount=ele_minicart_ProductCount.getAttribute("data-item-qty");
								WebElement ele_minicart_ProductPrice=product_li_itrate.findElement(By.xpath(".//span[@class='price']"));												
								String minicart_ProductPrice=ele_minicart_ProductPrice.getText();						
								if(minicart_ProductName.contains(ProductName))
								{
									if(Product_added_details.containsKey(minicart_ProductName))
									{
										Actions act=new Actions(Driver);
										WebElement ele_minicart_AddProduct=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
										ele_minicart_AddProduct=ele_minicart_AddProduct.findElement(By.xpath(".//button[contains(text(),'+')]"));
										act.moveToElement(ele_minicart_AddProduct).build().perform();
										ele_minicart_AddProduct.click();
										Thread.sleep(3000);
										ArrayList<String> productlist_temp=Product_added_details.get(minicart_ProductName);
										ArrayList<String> Productdetails = new ArrayList<String>();								
										String currect_Product_price=productlist_temp.get(0);;
										int current_Product_count=Integer.parseInt(productlist_temp.get(2));
										String currect_Product_price_offer=productlist_temp.get(1);;								
										current_Product_count++;
										Productdetails.add(currect_Product_price);
										Productdetails.add(currect_Product_price_offer);
										Productdetails.add(String.valueOf(current_Product_count));
										Product_added_details.put(ProductName, Productdetails);																																	
									}
									else
									{
										error_log.add("Incorrect Product Name for: "+ minicart_ProductName);
										log_system.info("Incorrect Product Name for: "+ minicart_ProductName);										
									}
								}								
							}
						}
						else
						{
							error_log.add("Incorrect Product total price");
							log_system.info("Incorrect Product total price");
							break;
						}
					}
					
				}
				while(Total_Cost<35);
				float msg_cost=50-Total_Cost;
				BigDecimal bd = new BigDecimal(msg_cost);
				msg_cost =Float.parseFloat(String.valueOf(bd.setScale(2, RoundingMode.HALF_UP)));
				element_locator=element_loc.getElement(ElementKey, ElementSelector);
				WebElement block_content=Driver.findElement(element_locator);
				if(block_content.findElement(By.xpath(".//div[normalize-space(@class) = 'minicart__min-order-amount-message minicart-custom-message']")).getText().contains(String.valueOf(msg_cost)))
				{
					do
					{						
						element_locator=element_loc.getElement(ElementKey, ElementSelector);
						block_content=Driver.findElement(element_locator);
						Total_Cost=Float.parseFloat(block_content.findElement(By.xpath(".//div[normalize-space(@class) = 'amount price-container']")).getText().replace("$", ""));					
						if(Total_Cost<50)
						{
							String ProductName=null; 
							Random rdm=new Random();
							ArrayList<String> product_list_Collection=new ArrayList<String>();
							Set<String> product_category_set=Product_added_details.keySet();
							for(String product_name:product_category_set)
							{
								product_list_Collection.add(product_name);
							}			
							int index=rdm.nextInt(product_list_Collection.size());
							ProductName=product_list_Collection.get(index);
							
							
							block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart__upper-container _block']"));
							block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'subtotal']"));
							block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'amount price-container']"));

							float minicartprice=Float.parseFloat(block_content.getText().replace("$", ""));
							Set<String> Product_added_details_itrator=Product_added_details.keySet();
							float totalprice=0;
							
							for(String price_list:Product_added_details_itrator)
							{
								String price=Product_added_details.get(price_list).get(0).replace("$","");
								String price_offer=Product_added_details.get(price_list).get(1);
								if(price_offer!=null)
								{
									price_offer=price_offer.replace("$", "");
									price=price_offer;
								}
								float product_count=Float.parseFloat(Product_added_details.get(price_list).get(2));
								price=String.valueOf(Float.parseFloat(price)*product_count);
								totalprice=Float.parseFloat(price)+totalprice;
								
							}
							
							BigDecimal bd1 = new BigDecimal(totalprice);
							totalprice =Float.parseFloat(String.valueOf(bd1.setScale(2, RoundingMode.HALF_UP)));
						    
							if(totalprice==minicartprice)
							{
								block_content=Driver.findElement(element_locator);
								block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
								block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart-items-wrapper minicart__items-wrapper _block']"));
								block_content=block_content.findElement(By.tagName("ol"));
								List<WebElement> product_li=block_content.findElements(By.tagName("li"));
								
								for(WebElement product_li_itrate:product_li)
								{
													
									String minicart_ProductName=product_li_itrate.findElement(By.xpath(".//strong[normalize-space(@class) = 'product-item-name minicart__product-item-name _block']")).getText();
									WebElement ele_minicart_ProductCount=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
									ele_minicart_ProductCount=ele_minicart_ProductCount.findElement(By.tagName("input"));
									String minicart_ProductCount=ele_minicart_ProductCount.getAttribute("data-item-qty");
									WebElement ele_minicart_ProductPrice=product_li_itrate.findElement(By.xpath(".//span[@class='price']"));												
									String minicart_ProductPrice=ele_minicart_ProductPrice.getText();						
									if(minicart_ProductName.contains(ProductName))
									{
										if(Product_added_details.containsKey(minicart_ProductName))
										{
											Actions act=new Actions(Driver);
											WebElement ele_minicart_AddProduct=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
											ele_minicart_AddProduct=ele_minicart_AddProduct.findElement(By.xpath(".//button[contains(text(),'+')]"));
											act.moveToElement(ele_minicart_AddProduct).build().perform();
											ele_minicart_AddProduct.click();
											Thread.sleep(3000);
											ArrayList<String> productlist_temp=Product_added_details.get(minicart_ProductName);
											ArrayList<String> Productdetails = new ArrayList<String>();								
											String currect_Product_price=productlist_temp.get(0);;
											int current_Product_count=Integer.parseInt(productlist_temp.get(2));
											String currect_Product_price_offer=productlist_temp.get(1);;								
											current_Product_count++;
											Productdetails.add(currect_Product_price);
											Productdetails.add(currect_Product_price_offer);
											Productdetails.add(String.valueOf(current_Product_count));
											Product_added_details.put(ProductName, Productdetails);																																	
										}
										else
										{
											error_log.add("Incorrect Product Name for: "+ minicart_ProductName);
											log_system.info("Incorrect Product Name for: "+ minicart_ProductName);										
										}
									}								
								}
							}
							else
							{
								error_log.add("Incorrect Product total price");
								log_system.info("Incorrect Product total price");
								break;
							}
						}
						
					}
					while(Total_Cost<50);
					element_locator=element_loc.getElement(ElementKey, ElementSelector);
					block_content=Driver.findElement(element_locator);
					if(block_content.findElement(By.xpath(".//div[normalize-space(@class) = 'minicart__min-order-amount-message minicart-custom-message']")).getText().contains("Congratulations! You have received free shipping on this order."))
					{
						Status=1;
					}
				}

				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}		
		
		
		return Status;
	}
	

	@SuppressWarnings("unused")
	public int AddProductfromMiniCart(String ElementKey, String ElementSelector) throws InterruptedException 
	{
		Thread.sleep(5000);
		ArrayList<String> error_log=new ArrayList<>();
		
		String ProductName=null; 
		Random rdm=new Random();
		ArrayList<String> product_list_Collection=new ArrayList<String>();
		Set<String> product_category_set=Product_added_details.keySet();
		for(String product_name:product_category_set)
		{
			product_list_Collection.add(product_name);
		}			
		int index=rdm.nextInt(product_list_Collection.size());
		ProductName=product_list_Collection.get(index);
		try {
			
 			if(Product_added_details.isEmpty())
			{
 				element_locator=element_loc.getElement(ElementKey, ElementSelector);
 				WebElement block_content=Driver.findElement(element_locator);
 				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
 				block_content=block_content.findElement(By.tagName("strong"));
 				
 				if(block_content.getText().trim().equals(ProductName.trim()))
 				{
 					log_system.info("correct message appearing for minicart empty");
 				}
 				else
 				{
 					error_log.add("Incorrect message for minicart empty");
 				}
			}
			else
			{					
				element_locator=element_loc.getElement(ElementKey, ElementSelector);
				WebElement block_content=Driver.findElement(element_locator);
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart__upper-container _block']"));
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'subtotal']"));
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'amount price-container']"));

				float minicartprice=Float.parseFloat(block_content.getText().replace("$", ""));
				Set<String> Product_added_details_itrator=Product_added_details.keySet();
				float totalprice=0;
				
				for(String price_list:Product_added_details_itrator)
				{
					String price=Product_added_details.get(price_list).get(0).replace("$","");
					String offer_price=Product_added_details.get(price_list).get(1);
					if(offer_price!=null)
					{
						offer_price=offer_price.replace("$", "");
						price=offer_price;
					}
					
					float product_count=Float.parseFloat(Product_added_details.get(price_list).get(2));
					price=String.valueOf(Float.parseFloat(price)*product_count);
					totalprice=Float.parseFloat(price)+totalprice;
					
				}
				
				BigDecimal bd = new BigDecimal(totalprice);
				totalprice =Float.parseFloat(String.valueOf(bd.setScale(2, RoundingMode.HALF_UP)));
			    
				if(totalprice==minicartprice)
				{
					block_content=Driver.findElement(element_locator);
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart-items-wrapper minicart__items-wrapper _block']"));
					block_content=block_content.findElement(By.tagName("ol"));
					List<WebElement> product_li=block_content.findElements(By.tagName("li"));
					
					for(WebElement product_li_itrate:product_li)
					{
										
						String minicart_ProductName=product_li_itrate.findElement(By.xpath(".//strong[normalize-space(@class) = 'product-item-name minicart__product-item-name _block']")).getText();
						WebElement ele_minicart_ProductCount=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
						ele_minicart_ProductCount=ele_minicart_ProductCount.findElement(By.tagName("input"));
						String minicart_ProductCount=ele_minicart_ProductCount.getAttribute("data-item-qty");
						WebElement ele_minicart_ProductPrice=product_li_itrate.findElement(By.xpath(".//span[@class='price']"));												
						String minicart_ProductPrice=ele_minicart_ProductPrice.getText();						
						if(minicart_ProductName.contains(ProductName))
						{
							if(Product_added_details.containsKey(minicart_ProductName))
							{
								Actions act=new Actions(Driver);
								WebElement ele_minicart_AddProduct=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
								ele_minicart_AddProduct=ele_minicart_AddProduct.findElement(By.xpath(".//button[contains(text(),'+')]"));
								act.moveToElement(ele_minicart_AddProduct).build().perform();
								ele_minicart_AddProduct.click();
								
								ArrayList<String> productlist_temp=Product_added_details.get(minicart_ProductName);
								ArrayList<String> Productdetails = new ArrayList<String>();								
								String currect_Product_price=productlist_temp.get(0);;
								int current_Product_count=Integer.parseInt(productlist_temp.get(2));
								String currect_Product_price_offer=productlist_temp.get(1);;								
								current_Product_count++;
								Productdetails.add(currect_Product_price);
								Productdetails.add(currect_Product_price_offer);
								Productdetails.add(String.valueOf(current_Product_count));
								Product_added_details.put(ProductName, Productdetails);
																					
								Status=1;
								log_system.info("Product Added");
								log_system.info("Status of AddProductfromMiniCart: "+Status);
							}
							else
							{
								error_log.add("Incorrect Product Name for: "+ minicart_ProductName);
								log_system.info("Incorrect Product Name for: "+ minicart_ProductName);
								
							}
						}
						
						
						
					}
				}
				else
				{
					error_log.add("Incorrect Product total price");
					log_system.info("Incorrect Product total price");
				}
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}		
		if(error_log.isEmpty())
			Status=1;
		else
			Status=0;
		
		return Status;
	}


	@SuppressWarnings("unused")
	public int RemoveProductfromMiniCart(String ElementKey, String ElementSelector) throws InterruptedException 
	{
		Thread.sleep(5000);
		ArrayList<String> error_log=new ArrayList<>();
		
		String ProductName=null; 
		Random rdm=new Random();
		ArrayList<String> product_list_Collection=new ArrayList<String>();
		Set<String> product_category_set=Product_added_details.keySet();
		for(String product_name:product_category_set)
		{
			product_list_Collection.add(product_name);
		}			
		int index=rdm.nextInt(product_list_Collection.size());
		ProductName=product_list_Collection.get(index);
		
		
		try {
			
 			if(Product_added_details.isEmpty())
			{
 				element_locator=element_loc.getElement(ElementKey, ElementSelector);
 				WebElement block_content=Driver.findElement(element_locator);
 				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
 				block_content=block_content.findElement(By.tagName("strong"));
 				
 				if(block_content.getText().trim().equals(ProductName.trim()))
 				{
 					log_system.info("correct message appearing for minicart empty");
 				}
 				else
 				{
 					error_log.add("Incorrect message for minicart empty");
 				}
			}
			else
			{
				element_locator=element_loc.getElement(ElementKey, ElementSelector);
				WebElement block_content=Driver.findElement(element_locator);
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart__upper-container _block']"));
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'subtotal']"));
				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'amount price-container']"));

				float minicartprice=Float.parseFloat(block_content.getText().replace("$", ""));
				Set<String> Product_added_details_itrator=Product_added_details.keySet();
				float totalprice=0;
				
				for(String price_list:Product_added_details_itrator)
				{
					String price=Product_added_details.get(price_list).get(0).replace("$","");
					String offer_price=Product_added_details.get(price_list).get(1);
					if(offer_price!=null)
					{
						offer_price=offer_price.replace("$", "");
						price=offer_price;
					}
					float product_count=Float.parseFloat(Product_added_details.get(price_list).get(2));
					price=String.valueOf(Float.parseFloat(price)*product_count);
					totalprice=Float.parseFloat(price)+totalprice;
					
				}
				
				BigDecimal bd = new BigDecimal(totalprice);
				totalprice =Float.parseFloat(String.valueOf(bd.setScale(2, RoundingMode.HALF_UP)));
			    
				if(totalprice==minicartprice)
				{
					block_content=Driver.findElement(element_locator);
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart-items-wrapper minicart__items-wrapper _block']"));
					block_content=block_content.findElement(By.tagName("ol"));
					List<WebElement> product_li=block_content.findElements(By.tagName("li"));
					
					for(WebElement product_li_itrate:product_li)
					{
						String minicart_ProductName=product_li_itrate.findElement(By.xpath(".//strong[normalize-space(@class) = 'product-item-name minicart__product-item-name _block']")).getText();
						WebElement ele_minicart_ProductCount=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
						ele_minicart_ProductCount=ele_minicart_ProductCount.findElement(By.tagName("input"));
						String minicart_ProductCount=ele_minicart_ProductCount.getAttribute("data-item-qty");
						WebElement ele_minicart_ProductPrice=product_li_itrate.findElement(By.xpath(".//span[@class='price']"));												
						String minicart_ProductPrice=ele_minicart_ProductPrice.getText();						
						if(minicart_ProductName.contains(ProductName))
						{
							if(Product_added_details.containsKey(minicart_ProductName))
							{
								Actions act=new Actions(Driver);
								WebElement ele_minicart_RemoveProduct=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
								ele_minicart_RemoveProduct=ele_minicart_RemoveProduct.findElement(By.xpath(".//button[contains(text(),'—')]"));
								act.moveToElement(ele_minicart_RemoveProduct).build().perform();
								ele_minicart_RemoveProduct.click();
								
								ArrayList<String> productlist_temp=Product_added_details.get(minicart_ProductName);
								ArrayList<String> Productdetails = new ArrayList<String>();								
								String currect_Product_price=productlist_temp.get(0);;
								int current_Product_count=Integer.parseInt(productlist_temp.get(2));
								String currect_Product_price_offer=productlist_temp.get(1);;								
								current_Product_count--;
								if(current_Product_count>0)
								{
									Productdetails.add(currect_Product_price);
									Productdetails.add(currect_Product_price_offer);
									Productdetails.add(String.valueOf(current_Product_count));
									Product_added_details.put(ProductName, Productdetails);
								}
								else
								{
									Product_added_details.remove(ProductName);
								}
																					
								Status=1;
								log_system.info("Product removed");
								log_system.info("Status of removeProductfromMiniCart: "+Status);
							}
							else
							{
								error_log.add("Incorrect Product Name for: "+ minicart_ProductName);
								log_system.info("Incorrect Product Name for: "+ minicart_ProductName);
								
							}
						}
					}
				}
				else
				{
					error_log.add("Incorrect Product total price");
					log_system.info("Incorrect Product total price");
				}
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}		
		if(error_log.isEmpty())
			Status=1;
		else
			Status=0;
		
		return Status;
	}

	
	@SuppressWarnings("unused")
	public int DeleteProductfromMiniCart(String ElementKey, String ElementSelector,String AllRemove) throws InterruptedException 
	{
		Thread.sleep(5000);
		ArrayList<String> error_log=new ArrayList<>();
		
		String ProductName=null; 
		Random rdm=new Random();
		ArrayList<String> product_list_Collection=new ArrayList<String>();
		Set<String> product_category_set=Product_added_details.keySet();
		for(String product_name:product_category_set)
		{
			product_list_Collection.add(product_name);
		}			
		if(!product_list_Collection.isEmpty())
		{
			int index=rdm.nextInt(product_list_Collection.size());
			ProductName=product_list_Collection.get(index);
		}
		
		
		
		try {
			
 			if(Product_added_details.isEmpty())
			{
 				element_locator=element_loc.getElement(ElementKey, ElementSelector);
 				WebElement block_content=Driver.findElement(element_locator);
 				block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
 				block_content=block_content.findElement(By.tagName("strong"));
 				
 				if(block_content.getText().trim().equals("You have no items in your shopping cart.".trim()))
 				{
 					log_system.info("correct message appearing for minicart empty");
 				}
 				else
 				{
 					error_log.add("Incorrect message for minicart empty");
 				}
			}
			else
			{
				
				if(AllRemove.toLowerCase().contains("all"))
				{
					
					product_list_Collection.clear();
					product_category_set=Product_added_details.keySet();
					for(String product_name:product_category_set)
					{
						product_list_Collection.add(product_name);
					}
					
					
					for(String Product_Name:product_list_Collection)
					{
						element_locator=element_loc.getElement(ElementKey, ElementSelector);
						WebElement block_content=Driver.findElement(element_locator);
						block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart__upper-container _block']"));
						block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'subtotal']"));
						block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'amount price-container']"));

						float minicartprice=Float.parseFloat(block_content.getText().replace("$", ""));
						Set<String> Product_added_details_itrator=Product_added_details.keySet();
						float totalprice=0;
						
						for(String price_list:Product_added_details_itrator)
						{
							String price=Product_added_details.get(price_list).get(0).replace("$","");
							String price_offer=Product_added_details.get(price_list).get(1);
							if(price_offer!=null)
							{
								price_offer=price_offer.replace("$", "");
								price=price_offer;
							}
							float product_count=Float.parseFloat(Product_added_details.get(price_list).get(2));
							price=String.valueOf(Float.parseFloat(price)*product_count);
							totalprice=Float.parseFloat(price)+totalprice;
							
						}
						
						BigDecimal bd = new BigDecimal(totalprice);
						totalprice =Float.parseFloat(String.valueOf(bd.setScale(2, RoundingMode.HALF_UP)));
					    
						if(totalprice==minicartprice)
						{
							block_content=Driver.findElement(element_locator);
							block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
							block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart-items-wrapper minicart__items-wrapper _block']"));
							block_content=block_content.findElement(By.tagName("ol"));
							List<WebElement> product_li=block_content.findElements(By.tagName("li"));
							
							for(WebElement product_li_itrate:product_li)
							{
								String minicart_ProductName=product_li_itrate.findElement(By.xpath(".//strong[normalize-space(@class) = 'product-item-name minicart__product-item-name _block']")).getText();
								WebElement ele_minicart_ProductCount=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
								ele_minicart_ProductCount=ele_minicart_ProductCount.findElement(By.tagName("input"));
								String minicart_ProductCount=ele_minicart_ProductCount.getAttribute("data-item-qty");
								WebElement ele_minicart_ProductPrice=product_li_itrate.findElement(By.xpath(".//span[@class='price']"));												
								String minicart_ProductPrice=ele_minicart_ProductPrice.getText();						
								if(minicart_ProductName.contains(Product_Name))
								{
									if(Product_added_details.containsKey(minicart_ProductName))
									{
										Actions act=new Actions(Driver);
										WebElement ele_minicart_DeleteProduct=product_li_itrate.findElement(By.xpath(".//a[normalize-space(@class) = 'action delete cc__delete-icon icon-close']"));								
										act.moveToElement(ele_minicart_DeleteProduct).build().perform();
										ele_minicart_DeleteProduct.click();
										Thread.sleep(4000);
										
										act.moveToElement(Driver.findElement(By.xpath("//button[normalize-space(@class) = 'action-primary action-accept btn__default']"))).build().perform();
										Driver.findElement(By.xpath("//button[normalize-space(@class) = 'action-primary action-accept btn__default']")).click();
										Thread.sleep(4000);
										ArrayList<String> productlist_temp=Product_added_details.get(minicart_ProductName);
										Product_added_details.remove(Product_Name);
																							
										Status=1;
										log_system.info("Product removed");
										log_system.info("Status of removeProductfromMiniCart: "+Status);
									}
									else
									{
										error_log.add("Incorrect Product Name for: "+ minicart_ProductName);
										log_system.info("Incorrect Product Name for: "+ minicart_ProductName);
										
									}
								}
								
								
								
							}
						}
						else
						{
							error_log.add("Incorrect Product total price");
							log_system.info("Incorrect Product total price");
						}
					}
					

				}
				else
				{
					element_locator=element_loc.getElement(ElementKey, ElementSelector);
					WebElement block_content=Driver.findElement(element_locator);
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart__upper-container _block']"));
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'subtotal']"));
					block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'amount price-container']"));

					float minicartprice=Float.parseFloat(block_content.getText().replace("$", ""));
					Set<String> Product_added_details_itrator=Product_added_details.keySet();
					float totalprice=0;
					
					for(String price_list:Product_added_details_itrator)
					{
						String price=Product_added_details.get(price_list).get(0).replace("$","");
						String price_offer=Product_added_details.get(price_list).get(1);
						if(price_offer!=null)
						{
							price_offer=price_offer.replace("$", "");
							price=price_offer;
						}
						float product_count=Float.parseFloat(Product_added_details.get(price_list).get(2));
						price=String.valueOf(Float.parseFloat(price)*product_count);
						totalprice=Float.parseFloat(price)+totalprice;
						
					}
					
					BigDecimal bd = new BigDecimal(totalprice);
					totalprice =Float.parseFloat(String.valueOf(bd.setScale(2, RoundingMode.HALF_UP)));
				    
					if(totalprice==minicartprice)
					{
						block_content=Driver.findElement(element_locator);
						block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'block-content']"));
						block_content=block_content.findElement(By.xpath("//div[normalize-space(@class) = 'minicart-items-wrapper minicart__items-wrapper _block']"));
						block_content=block_content.findElement(By.tagName("ol"));
						List<WebElement> product_li=block_content.findElements(By.tagName("li"));
						
						for(WebElement product_li_itrate:product_li)
						{
							String minicart_ProductName=product_li_itrate.findElement(By.xpath(".//strong[normalize-space(@class) = 'product-item-name minicart__product-item-name _block']")).getText();
							WebElement ele_minicart_ProductCount=product_li_itrate.findElement(By.xpath(".//div[normalize-space(@class) = 'details-qty qty _block minicart__details-qty']"));
							ele_minicart_ProductCount=ele_minicart_ProductCount.findElement(By.tagName("input"));
							String minicart_ProductCount=ele_minicart_ProductCount.getAttribute("data-item-qty");
							WebElement ele_minicart_ProductPrice=product_li_itrate.findElement(By.xpath(".//span[@class='price']"));												
							String minicart_ProductPrice=ele_minicart_ProductPrice.getText();						if(minicart_ProductName.contains(ProductName))
							{
								if(Product_added_details.containsKey(minicart_ProductName))
								{
									Actions act=new Actions(Driver);
									WebElement ele_minicart_DeleteProduct=product_li_itrate.findElement(By.xpath(".//a[normalize-space(@class) = 'action delete cc__delete-icon icon-close']"));								
									act.moveToElement(ele_minicart_DeleteProduct).build().perform();
									ele_minicart_DeleteProduct.click();
									Thread.sleep(4000);
									
									act.moveToElement(Driver.findElement(By.xpath("//button[normalize-space(@class) = 'action-primary action-accept btn__default']"))).build().perform();
									Driver.findElement(By.xpath("//button[normalize-space(@class) = 'action-primary action-accept btn__default']")).click();
									ArrayList<String> productlist_temp=Product_added_details.get(minicart_ProductName);
									Product_added_details.remove(ProductName);
									Status=1;
									log_system.info("Product removed");
									log_system.info("Status of removeProductfromMiniCart: "+Status);
								}
								else
								{
									error_log.add("Incorrect Product Name for: "+ minicart_ProductName);
									log_system.info("Incorrect Product Name for: "+ minicart_ProductName);
									
								}
							}
							
							
							
						}
					}
					else
					{
						error_log.add("Incorrect Product total price");
						log_system.info("Incorrect Product total price");
					}

				}
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}		
		if(error_log.isEmpty())
			Status=1;
		else
			Status=0;
		
		return Status;
	}	
	
	
	
	
	public int SortBy(String ElementKey, String ElementSelector,String SortType)  throws Exception
	{				
		ArrayList<String> errorLog =new ArrayList<>();
		element_locator=element_loc.getElement(ElementKey, ElementSelector);		
		int count_sort_found=0;
		ArrayList<String> productname_sequence_default=new ArrayList<String>();
		ArrayList<String> productname_sequence_sort_apply=new ArrayList<String>();
		ArrayList<Float> productprice_sequence_default=new ArrayList<Float>();
		ArrayList<Float> productprice_sequence_sort_apply=new ArrayList<Float>();
		int pagecount=0;
		try {
			WebElement product_container=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'products wrapper cp__products-wrapper grid products-grid']"));
			product_container=product_container.findElement(By.tagName("ol"));
			List<WebElement> product_li_list=product_container.findElements(By.xpath("li"));
			
			for(WebElement product_li:product_li_list)
			{
				WebElement product_name=product_li.findElement(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
				WebElement product_price=product_li.findElement(By.xpath(".//div[normalize-space(@class) = 'price-box price-final_price']"));
				productname_sequence_default.add(product_name.getText());
				if(product_price.getText().contains("Special Price"))					
					productprice_sequence_default.add(Float.valueOf(product_price.getText().split("Special Price")[0].replace("$", "").trim()));
				else
					productprice_sequence_default.add(Float.valueOf(product_price.getText().split("Special Price")[0].replace("$", "").trim()));
																						
			}
			
			
			WebElement element_page=Driver.findElement(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[4]/div[2]/ul"));
			
			List<WebElement> element_page_list=element_page.findElements(By.xpath(".//li[normalize-space(@class) = 'item']"));
			pagecount=element_page_list.size();
			for(WebElement element_page_list_itr:element_page_list)
			{
				
				Actions act=new Actions(Driver);
				act.moveToElement(element_page_list_itr).build().perform();
				element_page_list_itr.click();
				product_container=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'products wrapper cp__products-wrapper grid products-grid']"));
				product_container=product_container.findElement(By.tagName("ol"));
				product_li_list=product_container.findElements(By.xpath("li"));
				
				for(WebElement product_li:product_li_list)
				{
					WebElement product_name=product_li.findElement(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
					WebElement product_price=product_li.findElement(By.xpath(".//div[normalize-space(@class) = 'price-box price-final_price']"));
					productname_sequence_default.add(product_name.getText());
					if(product_price.getText().contains("Special Price"))
						productprice_sequence_default.add(Float.valueOf(product_price.getText().split("Special Price")[0].replace("$", "").trim()));
					else
						productprice_sequence_default.add(Float.valueOf(product_price.getText().split("Special Price")[0].replace("$", "").trim()));
				}
			}
						
			
		} catch (Exception e) {

			
		}
		
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,-1500)");
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(By.xpath("//button[normalize-space(@class) = 'action switch']")));
		Driver.findElement(By.xpath("//span[normalize-space(@class) = 'filter__sortTrigger']")).click();
		WebElement sort_ul=Driver.findElement(element_locator);
		List<WebElement> sort_li_list=sort_ul.findElements(By.tagName("li"));
		for(WebElement sort_li:sort_li_list)
		{
			System.out.println(sort_li.getText().toLowerCase());
			System.out.println(SortType.toLowerCase());
			if(sort_li.getText().toLowerCase().equals(SortType.toLowerCase()))
			{
				sort_li.click();
				break;
			}
		}
		
		if(pagecount>0)
		{
			Driver.findElement(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[4]/div[2]/ul/li[2]/a")).click();
		}
		
		
		try {
			
			WebElement product_container_sort_apply=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'products wrapper cp__products-wrapper grid products-grid']"));
			product_container_sort_apply=product_container_sort_apply.findElement(By.tagName("ol"));
			List<WebElement> product_li_list_sort_apply=product_container_sort_apply.findElements(By.xpath("li"));
			for(WebElement product_li:product_li_list_sort_apply)
			{
				WebElement product_name=product_li.findElement(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
				WebElement product_price=product_li.findElement(By.xpath(".//div[normalize-space(@class) = 'price-box price-final_price']"));
				productname_sequence_sort_apply.add(product_name.getText());
				if(product_price.getText().contains("Special Price"))
					productprice_sequence_sort_apply.add(Float.valueOf(product_price.getText().split("Special Price")[0].replace("$", "").trim()));	
				else
					productprice_sequence_sort_apply.add(Float.valueOf(product_price.getText().split("Special Price")[0].replace("$", "").trim()));	
																	
			}
			
			
			WebElement element_page=Driver.findElement(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[4]/div[2]/ul"));
			
			List<WebElement> element_page_list=element_page.findElements(By.xpath(".//li[normalize-space(@class) = 'item']"));
			
			for(WebElement element_page_list_itr:element_page_list)
			{
				
				
				act.moveToElement(element_page_list_itr).build().perform();
				element_page_list_itr.click();
				product_container_sort_apply=Driver.findElement(By.xpath("//div[normalize-space(@class) = 'products wrapper cp__products-wrapper grid products-grid']"));
				product_container_sort_apply=product_container_sort_apply.findElement(By.tagName("ol"));
				product_li_list_sort_apply=product_container_sort_apply.findElements(By.xpath("li"));
				for(WebElement product_li:product_li_list_sort_apply)
				{
					WebElement product_name=product_li.findElement(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
					WebElement product_price=product_li.findElement(By.xpath(".//div[normalize-space(@class) = 'price-box price-final_price']"));
					productname_sequence_sort_apply.add(product_name.getText());
					if(product_price.getText().contains("Special Price"))
						productprice_sequence_sort_apply.add(Float.valueOf(product_price.getText().split("Special Price")[0].replace("$", "").trim()));	
					else
						productprice_sequence_sort_apply.add(Float.valueOf(product_price.getText().split("Special Price")[0].replace("$", "").trim()));										
				}
			}
						
			
		} catch (Exception e) {

			
		}

		
		if(SortType.equals("Product Name"))
			Collections.sort(productname_sequence_default);
		
								
		else if(SortType.equals("Price : Low to High"))
			Collections.sort(productprice_sequence_default);
						
		else if(SortType.equals("Price : High to Low"))
			Collections.sort(productprice_sequence_default,Collections.reverseOrder());
		
		
		int listsize=0;
		if(SortType.equals("Product Name"))
		{
			listsize=productname_sequence_default.size();
			for(int i=0;i<listsize;i++)
			{						
				if(!productname_sequence_default.get(i).equals(productname_sequence_sort_apply.get(i)))
				{
					errorLog.add("incorrect sort for product: "+ productname_sequence_default.get(i));
					count_sort_found++;
				}						
			}				
		}
								
		else if(SortType.equals("Price : Low to High"))
		{
			listsize=productprice_sequence_default.size();
			for(int i=0;i<listsize;i++)
			{						
				if(!productprice_sequence_default.get(i).equals(productprice_sequence_sort_apply.get(i)))
				{
					System.out.println(i);
					System.out.println(productprice_sequence_default.get(i));
					System.out.println(productprice_sequence_sort_apply.get(i));
					errorLog.add("incorrect sort for product: "+ productname_sequence_default.get(i));
					count_sort_found++;
				}						
			}				
		}					
		else if(SortType.equals("Price : High to Low"))
		{					
			listsize=productprice_sequence_default.size();
			for(int i=0;i<listsize;i++)
			{						
				if(!productprice_sequence_default.get(i).equals(productprice_sequence_sort_apply.get(i)))
				{
					System.out.println(i);
					System.out.println(productprice_sequence_default.get(i));
					System.out.println(productprice_sequence_sort_apply.get(i));
					errorLog.add("incorrect sort for product: "+ productname_sequence_default.get(i));
					count_sort_found++;
				}						
			}				
		}
		
			
		if(count_sort_found==0)
		{
			Status=1;
		}
		if(pagecount>0)
		{
			Driver.findElement(By.xpath("//*[@id=\"amasty-shopby-product-list\"]/div[4]/div[2]/ul/li[2]/a")).click();
		}
		return Status;
	}
	
	
	public int Click(String ElementKey, String ElementSelector)  throws Exception
	{				
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,-1000)");
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		Driver.findElement(element_locator).click();
		Status=1;
		log_system.info("click perfomed");
		log_system.info("Status of Click: "+Status);
		return Status;
	}
	
	public int SelectMyAccountTab(String ElementKey, String ElementSelector,String MenuName)  throws Exception
	{	
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,-1000)");
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement menu=Driver.findElement(element_locator);
		List<WebElement> menu_list=menu.findElements(By.xpath(".//li[normalize-space(@class) = 'nav item']"));
		for(WebElement menu_list_itr:menu_list)
		{
			if(menu_list_itr.getText().contains(MenuName))
			{
				Actions act=new Actions(Driver);
				act.moveToElement(Driver.findElement(element_locator)).build().perform();
				WebDriverWait wait = new WebDriverWait(Driver, 40);
				wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
				menu_list_itr.click();
				Status=1;
				break;
			}
			
				
		}
		
		
		log_system.info("SelectMyAccountTab perfomed");
		log_system.info("Status of SelectMyAccountTab: "+Status);
		return Status;
	}
	
	public int SetText(String ElementKey, String ElementSelector,String InputString)  throws Exception
	{		
		if(InputString.equals("Randomemailid"))
		{
			if(Randamemailuser!=null)
				InputString=Randamemailuser;
			else
			Randamemailuser=InputString=r_email.random_email_genrator();
			
		}
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,-1000)");
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));		
		Driver.findElement(element_locator).sendKeys(Keys.CONTROL+"a");
		Driver.findElement(element_locator).sendKeys(Keys.BACK_SPACE);
		Driver.findElement(element_locator).sendKeys(InputString);
		Status=1;
		log_system.info("Text Entered");
		log_system.info("Status of SetText: "+Status);
		return Status;
	}
	
	
	
	
	
	public int wait(int waittime) throws InterruptedException
	{
		Thread.sleep(waittime);
		Status=1;
		return Status;
	}
	
	public int ClearText(String ElementKey, String ElementSelector)  throws Exception
	{				
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act=new Actions(Driver);
		act.moveToElement(Driver.findElement(element_locator)).build().perform();
		Driver.findElement(element_locator).sendKeys(Keys.CONTROL+"a");
		Driver.findElement(element_locator).sendKeys(Keys.BACK_SPACE);
		Status=1;
		log_system.info("Text Cleared");
		log_system.info("Status of ClearText: "+Status);
		return Status;
	}
	
	public int SearchProduct(String ElementKey, String ElementSelector,String ProductName)
	{		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement element_product_Wraper_list=Driver.findElement(element_locator);
		List<WebElement> element_product_item_wraper=element_product_Wraper_list.findElements(By.tagName("ol"));
		
		ProductSearch:
			for(WebElement element_product_item_wraper_itrator:element_product_item_wraper)
			{	

				List<WebElement> element_product_item_container=element_product_item_wraper_itrator.findElements(By.tagName("li"));
				for(WebElement element_product_item_container_itrator:element_product_item_container)
				{	
					
					List<WebElement> element_product_item_info_container=element_product_item_container_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product-item-info product__card']"));
					for(WebElement element_product_item_info_cart:element_product_item_info_container)
					{						
						
						List<WebElement> element_product_item_info_details_cart=element_product_item_info_cart.findElements(By.xpath(".//div[normalize-space(@class) = 'product details product-item-details product__card-details']"));
						for(WebElement element_product_item_info_cart_itrator:element_product_item_info_details_cart)
						{
							
							List<WebElement> element_product_item_info_details_cart_name=element_product_item_info_cart_itrator.findElements(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
					
							
							for(WebElement element_product_item_info_details_cart_name_itrator:element_product_item_info_details_cart_name)
							{
								if(element_product_item_info_details_cart_name_itrator.getText().contains(ProductName))
								{
									Actions act=new Actions(Driver);
									act.moveToElement(element_product_item_info_details_cart_name_itrator).build().perform();
									Status=1;
									log_system.info("Product Appearing on the screen");
									log_system.info("Status of Product Search: "+Status);
									break ProductSearch;
								}
										
							}
							
						}
					}								 
				}
			}

		if(Status==0)
		{
			
			log_system.info("Product details not found: "+ ProductName);
			log_system.info("Status of Product Search: "+Status);
		}
		return Status;
	}

	
	@SuppressWarnings("unused")
	public int SearchAndAddToWishlist(String ElementKey, String ElementSelector,String ProductName) throws InterruptedException
	{		
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement element_product_Wraper_list=Driver.findElement(element_locator);
		List<WebElement> element_product_item_wraper=element_product_Wraper_list.findElements(By.tagName("ol"));
		ArrayList<String> Productdetails = new ArrayList<String>();
		String currect_Product_name=null;
		String currect_Product_price=null;		
		String currect_Product_price_offer=null;
		
		Productwishlist:
		if(!Product_wishlist_details.containsKey(ProductName))
		{
			for(WebElement element_product_item_wraper_itrator:element_product_item_wraper)
			{	
				List<WebElement> element_product_item_container=element_product_item_wraper_itrator.findElements(By.tagName("li"));
				for(WebElement element_product_item_container_itrator:element_product_item_container)
				{						
					List<WebElement> element_product_item_info_container=element_product_item_container_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product-item-info product__card']"));
					for(WebElement element_product_item_info_cart:element_product_item_info_container)
					{						
						List<WebElement> element_product_item_info_details_cart=element_product_item_info_cart.findElements(By.xpath(".//div[normalize-space(@class) = 'product details product-item-details product__card-details']"));
						for(WebElement element_product_item_info_cart_itrator:element_product_item_info_details_cart)
						{
							List<WebElement> element_product_item_info_details_cart_name=element_product_item_info_cart_itrator.findElements(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
							List<WebElement> element_product_item_info_details_cart_price=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product__price-container']"));
							List<WebElement> element_product_item_info_details_cart_add_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'actions-primary product__action-primary']"));
							List<WebElement> element_product_item_info_details_cart_addmore_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product__actions action__secondary']"));
							List<WebElement> element_product_item_info_details_cart_wishlist_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'actions-secondary product__action-secondry']"));
							
							for(WebElement element_product_item_info_details_cart_name_itrator:element_product_item_info_details_cart_name)
							{
								Actions act=new Actions(Driver);
								act.moveToElement(element_product_item_info_details_cart_name_itrator).build().perform();
								
								if(element_product_item_info_details_cart_name_itrator.getText().toLowerCase().toString().equals(ProductName.toLowerCase().toString()))
								{
									WebElement currect_Product_element= element_product_item_info_cart_itrator;
									currect_Product_name=element_product_item_info_details_cart_name_itrator.getText().toString();
									ProductSearchbreak:
									for(WebElement element_product_item_info_details_cart_price_itrator:element_product_item_info_details_cart_price)
									{											
										if(element_product_item_info_details_cart_price_itrator.getText().contains("Special Price".toString()))
										{
											currect_Product_price=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[0].toString().trim();
											currect_Product_price_offer=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[1].toString().trim();
										}
										else
										{
											currect_Product_price=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[0].toString();
										}
																					
										break ProductSearchbreak;
									}
									for(WebElement wishist_itar:element_product_item_info_details_cart_wishlist_container)
									{
										List<WebElement> wishlistlink=wishist_itar.findElements(By.xpath(".//a[normalize-space(@class) = 'action towishlist']"));
										for(WebElement wishlist:wishlistlink)
										{
											if(wishlist.getText().contains("Add to Wish List"))
											{
												wishlist.click();
												Productdetails.add(currect_Product_price);
												Productdetails.add(currect_Product_price_offer);													
												Product_wishlist_details.put(currect_Product_name, Productdetails);													
												Status=1;
												log_system.info("Product Added to wihlist");
												log_system.info("Status of Search And Add To Wishlist: "+Status);
												break Productwishlist;
											}
										}
									}								
								}
							}
						}
					}
				}
			}
		}
		else
		{
			Status=1;
			log_system.info("Product already exist in wishlist");
			log_system.info("Status of Search And Add To Wishlist: "+Status);										
			break Productwishlist;
		}
		Thread.sleep(5000);
		ArrayList<String> errorlog=new ArrayList<>();
		if(Status==1)
		{
			Driver.findElement(By.xpath(".//span[normalize-space(@class) = 'customer-name']")).click();
			Driver.findElement(By.xpath(".//li[normalize-space(@class) = 'link wishlist']//a[contains(text(),'My Wish List')]")).click();
			Set<String> Productwishlist=Product_wishlist_details.keySet();
			int productfound=0;
			for(String productnamewishlist:Productwishlist)
			{				
				WebElement element_ol=Driver.findElement(By.xpath("//ol[normalize-space(@class) = 'product-items wishlist__list']"));
				List<WebElement> element_li=element_ol.findElements(By.tagName("li"));
				for(WebElement wishlist:element_li)
				{
					String Product_ID=wishlist.getAttribute("id");
					String xpath="//*[@id=\""+Product_ID+"\"]//a[@data-role='remove']";
					if(wishlist.getText().contains(productnamewishlist))
					{
						Driver.findElement(By.xpath(xpath)).click();
						productfound=1;
						break;					
					}					
					
				}
				if(productfound==0)
				{
					errorlog.add("Product not added in wishlist: "+ productnamewishlist);
				}
			}			
		}
		return Status;
	}

	
	
	
	public int HeaderMenuSearch(String ElementKey, String ElementSelector,String LinkName)
	{		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement element_HeaderMenu=Driver.findElement(element_locator);
		
		List<WebElement> elements=element_HeaderMenu.findElements(By.tagName("li"));
		for(WebElement elements_li:elements)
		{
			Actions act=new Actions(Driver);			
			if(elements_li.getText().toLowerCase().toString().equals(LinkName.toLowerCase().toString()))
			{
				act.moveToElement(elements_li).build().perform();
				Status=1;
				log_system.info("Link found: "+ LinkName);
				log_system.info("Status of HeaderMenuSearch: "+Status);
				break;
			}
			else
			{
				Status=0;
			}
		}
		
		if(Status==0)
		{
			log_system.info("Link not found: "+ LinkName);
			log_system.info("Status of HeaderMenuSearch: "+Status);
		}
		return Status;
	}
	
	
	
	
	@SuppressWarnings({ "unused" })
	public int MoveAndAddProduct(String ElementKey, String ElementSelector,String Exist) throws InterruptedException
	{	
		Thread.sleep(3000);
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement element_product_Wraper_list=Driver.findElement(element_locator);
		List<WebElement> element_product_item_wraper=element_product_Wraper_list.findElements(By.tagName("ol"));
		ArrayList<String> product_list_Collection=new ArrayList<String>();
		String ProductName=null;
		Random rdm=new Random();
		if(Exist.toLowerCase().contains("exist"))
		{
			Set<String> product_category_set=Product_added_details.keySet();
			for(String product_name:product_category_set)
			{
				product_list_Collection.add(product_name);
			}			
			int index=rdm.nextInt(product_list_Collection.size());
			ProductName=product_list_Collection.get(index);
		}
		else
		{
			for(WebElement element_product_item_wraper_itrator:element_product_item_wraper)
			{	
				List<WebElement> element_product_item_container=element_product_item_wraper_itrator.findElements(By.tagName("li"));
				for(WebElement element_product_item_container_itrator:element_product_item_container)
				{						
					List<WebElement> element_product_item_info_container=element_product_item_container_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product-item-info product__card']"));					
					for(WebElement element_product_item_info_cart:element_product_item_info_container)
					{	
						List<WebElement> element_product_item_info_details_cart=element_product_item_info_cart.findElements(By.xpath(".//div[normalize-space(@class) = 'product details product-item-details product__card-details']"));						
						for(WebElement element_product_item_info_cart_itrator:element_product_item_info_details_cart)
						{
							List<WebElement> element_product_item_info_details_cart_name=element_product_item_info_cart_itrator.findElements(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));							
							for(WebElement element_product_item_info_details_cart_name_itrator:element_product_item_info_details_cart_name)
							{								
								product_list_Collection.add(element_product_item_info_details_cart_name_itrator.getText());
							}
						}
					}
				}
			}
		

			int index=rdm.nextInt(product_list_Collection.size());
			ProductName=product_list_Collection.get(index);
		}
		
					
		Thread.sleep(3000);
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		element_product_Wraper_list=Driver.findElement(element_locator);
		element_product_item_wraper=element_product_Wraper_list.findElements(By.tagName("ol"));
		
		ArrayList<String> Productdetails = new ArrayList<String>();
		String currect_Product_name=null;
		String currect_Product_price=null;
		String current_Product_count=null;
		String currect_Product_price_offer=null;
		int productfoundstatus=0;
		ProductSearch:
			for(WebElement element_product_item_wraper_itrator:element_product_item_wraper)
			{	
				List<WebElement> element_product_item_container=element_product_item_wraper_itrator.findElements(By.tagName("li"));
				for(WebElement element_product_item_container_itrator:element_product_item_container)
				{						
					List<WebElement> element_product_item_info_container=element_product_item_container_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product-item-info product__card']"));					
					for(WebElement element_product_item_info_cart:element_product_item_info_container)
					{	
						List<WebElement> element_product_item_info_details_cart=element_product_item_info_cart.findElements(By.xpath(".//div[normalize-space(@class) = 'product details product-item-details product__card-details']"));						
						for(WebElement element_product_item_info_cart_itrator:element_product_item_info_details_cart)
						{
							List<WebElement> element_product_item_info_details_cart_name=element_product_item_info_cart_itrator.findElements(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
							List<WebElement> element_product_item_info_details_cart_price=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product__price-container']"));
							List<WebElement> element_product_item_info_details_cart_add_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'actions-primary product__action-primary']"));
							List<WebElement> element_product_item_info_details_cart_addmore_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product__actions action__secondary']"));
							List<WebElement> element_product_item_info_details_cart_wishlist_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'actions-secondary product__action-secondry']"));
							
							for(WebElement element_product_item_info_details_cart_name_itrator:element_product_item_info_details_cart_name)
							{
								Actions act=new Actions(Driver);
								act.moveToElement(element_product_item_info_details_cart_name_itrator).build().perform();
								
								if(element_product_item_info_details_cart_name_itrator.getText().toLowerCase().toString().equals(ProductName.toLowerCase().toString()))
								{
									
									
									productfoundstatus=1;
									if(element_product_item_info_details_cart_name_itrator.getText().toLowerCase().toString().equals(ProductName.toLowerCase().toString()))
									{			
															
										WebElement currect_Product_element= element_product_item_info_cart_itrator;
										currect_Product_name=element_product_item_info_details_cart_name_itrator.getText().toString();
										ProductSearchbreak:
										for(WebElement element_product_item_info_details_cart_price_itrator:element_product_item_info_details_cart_price)
										{											
											if(element_product_item_info_details_cart_price_itrator.getText().contains("Special Price".toString()))
											{
												currect_Product_price=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[0].toString().trim();
												currect_Product_price_offer=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[1].toString().trim();
											}
											else
											{
												currect_Product_price=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[0].toString();
											}
																						
											break ProductSearchbreak;
										}
										
									}											
									if(productfoundstatus==1)
									{
										if(Product_added_details.containsKey(ProductName))
										{										
											for(WebElement element_product_item_info_details_cart_add_container_itrate:element_product_item_info_details_cart_addmore_container)
											{

												List<WebElement> element_product_item_info_details_cart_add_button=element_product_item_info_details_cart_add_container_itrate.findElements(By.xpath(".//button[contains(text(),'+')]"));											
												for(WebElement element_product_item_info_details_cart_add_button_itrate:element_product_item_info_details_cart_add_button)
												{							
													int divcount1=0;
													act.moveToElement(element_product_item_info_details_cart_name_itrator).build().perform();
													
													WebElement addmoreProduct=element_product_item_info_details_cart_add_button_itrate;
													if(addmoreProduct.getText().equals("+"))
													{
														if(addmoreProduct.isDisplayed()==true)
														{												
															act.moveToElement(addmoreProduct).build().perform();
															Thread.sleep(2000);
															addmoreProduct.click();	
															Thread.sleep(4000);
															ArrayList<String> productlist_temp=Product_added_details.get(currect_Product_name);
															int productlastcount=Integer.parseInt(productlist_temp.get(2));
															current_Product_count=String.valueOf(productlastcount+1);																												
															Productdetails.add(currect_Product_price);
															Productdetails.add(currect_Product_price_offer);
															Productdetails.add(current_Product_count);
															Product_added_details.put(currect_Product_name, Productdetails);													
															Status=1;
															log_system.info("Product Added");
															log_system.info("Status of Product move and add: "+Status);												
														}
														break ProductSearch;
													}
																										
													
												}										
											}
										}
										else
										{
											for(WebElement element_product_item_info_details_cart_add_container_itrate:element_product_item_info_details_cart_add_container)
											{
												List<WebElement> element_product_item_info_details_cart_add_button=element_product_item_info_cart_itrator.findElements(By.tagName("button"));
												for(WebElement element_product_item_info_details_cart_add_button_itrate:element_product_item_info_details_cart_add_button)
												{
													act.moveToElement(element_product_item_info_details_cart_add_button_itrate).build().perform();
													if(element_product_item_info_details_cart_add_button_itrate.isDisplayed()==true)
													{																
														Thread.sleep(2000);
														element_product_item_info_details_cart_add_button_itrate.click();
														Thread.sleep(4000);
														current_Product_count=String.valueOf(1);																																	
														Productdetails.add(currect_Product_price);
														Productdetails.add(currect_Product_price_offer);
														Productdetails.add(current_Product_count);
														Product_added_details.put(currect_Product_name, Productdetails);													
														Status=1;
														log_system.info("Product Added");
														log_system.info("Status of Product move and add: "+Status);												
													}
													break ProductSearch;
												}										
											}											
										}
									}
									else
									{
										Status=0;
										log_system.info("Product not found");
										log_system.info("Status of Product move and add: "+Status);
									}
																		
								}
							}
							
						}
					}								 
				}
			}	
		return Status;
	}
	
	
	
	@SuppressWarnings({ "unused"})
	public int MoveAndRemoveProduct(String ElementKey, String ElementSelector,String AllProduct) throws InterruptedException
	{		
		int MoveAndRemoveProduct=0;
		if(AllProduct.toLowerCase().contains("all"))
		{
			ArrayList<String> product_list_collection=new ArrayList<String>();
			Set<String> product_category_set=Product_added_details.keySet();
			for(String product_name:product_category_set)
			{
				product_list_collection.add(product_name);
			}
			for(String product_name:product_list_collection)
			{
				
				ArrayList<String> productlist_temp=Product_added_details.get(product_name);
				int productlastcount=Integer.parseInt(productlist_temp.get(2));
				for(int i=0;i<productlastcount;i++)
				{
					element_locator=element_loc.getElement(ElementKey, ElementSelector);
					WebElement element_product_Wraper_list=Driver.findElement(element_locator);
					List<WebElement> element_product_item_wraper=element_product_Wraper_list.findElements(By.tagName("ol"));
					
					ArrayList<String> Productdetails = new ArrayList<String>();
					String currect_Product_name=null;
					String currect_Product_price=null;
					String current_Product_count=null;
					String currect_Product_price_offer=null;
					int productsearchcount=0;
					ProductSearch:
				for(WebElement element_product_item_wraper_itrator:element_product_item_wraper)
				{
					List<WebElement> element_product_item_container=element_product_item_wraper_itrator.findElements(By.tagName("li"));
					for(WebElement element_product_item_container_itrator:element_product_item_container)
					{						
						List<WebElement> element_product_item_info_container=element_product_item_container_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product-item-info product__card']"));					
						for(WebElement element_product_item_info_cart:element_product_item_info_container)
						{	
							List<WebElement> element_product_item_info_details_cart=element_product_item_info_cart.findElements(By.xpath(".//div[normalize-space(@class) = 'product details product-item-details product__card-details']"));
							for(WebElement element_product_item_info_cart_itrator:element_product_item_info_details_cart)
							{
								
								List<WebElement> element_product_item_info_details_cart_name=element_product_item_info_cart_itrator.findElements(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
								List<WebElement> element_product_item_info_details_cart_price=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product__price-container']"));
								List<WebElement> element_product_item_info_details_cart_add_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'actions-primary product__action-primary']"));
								List<WebElement> element_product_item_info_details_cart_addmore_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product__actions action__secondary']"));
								List<WebElement> element_product_item_info_details_cart_wishlist_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'actions-secondary product__action-secondry']"));
								
								for(WebElement element_product_item_info_details_cart_name_itrator:element_product_item_info_details_cart_name)
								{
									
									Actions act=new Actions(Driver);
									act.moveToElement(element_product_item_info_details_cart_name_itrator).build().perform();
									productsearchcount++;
									if(element_product_item_info_details_cart_name_itrator.getText().toLowerCase().toString().trim().equals(product_name.toLowerCase().trim().toString()))
									{									
										
										if(element_product_item_info_details_cart_name_itrator.getText().toLowerCase().toString().equals(product_name.toLowerCase().toString()))
										{			
																
											WebElement currect_Product_element= element_product_item_info_cart_itrator;
											currect_Product_name=element_product_item_info_details_cart_name_itrator.getText().toString();
											ProductSearchbreak:
											for(WebElement element_product_item_info_details_cart_price_itrator:element_product_item_info_details_cart_price)
											{											
												if(element_product_item_info_details_cart_price_itrator.getText().contains("Special Price".toString()))
												{
													currect_Product_price=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[0].toString().trim();
													currect_Product_price_offer=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[1].toString().trim();
												}
												else
												{
													currect_Product_price=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[0].toString();
												}
																							
												break ProductSearchbreak;
											}
												
										}		
										
										if(Product_added_details.containsKey(product_name))
										{
											for(WebElement element_product_item_info_details_cart_add_container_itrate:element_product_item_info_details_cart_addmore_container)
											{

												List<WebElement> element_product_item_info_details_cart_add_button=element_product_item_info_details_cart_add_container_itrate.findElements(By.tagName("button"));											
												for(WebElement element_product_item_info_details_cart_add_button_itrate:element_product_item_info_details_cart_add_button)
												{							
													int divcount1=0;
													act.moveToElement(element_product_item_info_details_cart_name_itrator).build().perform();
													
													WebElement addmoreProduct=element_product_item_info_details_cart_add_button_itrate;
													System.out.println(addmoreProduct.getText());
													if(addmoreProduct.getText().equals("—"))
													{
														if(addmoreProduct.isDisplayed()==true)
														{												
															act.moveToElement(addmoreProduct).build().perform();															
															addmoreProduct.click();	
															Thread.sleep(5000);
															productlist_temp=Product_added_details.get(currect_Product_name);
															productlastcount=Integer.parseInt(productlist_temp.get(2));
															current_Product_count=String.valueOf(productlastcount-1);																												
															Productdetails.add(currect_Product_price);
															Productdetails.add(currect_Product_price_offer);
															Productdetails.add(current_Product_count);
															if(Integer.parseInt(current_Product_count)>0)
															{
																Product_added_details.put(currect_Product_name, Productdetails);
															}
															else
															{
																Product_added_details.remove(currect_Product_name);
															}
															Status=1;
															log_system.info("Product Removed");
															log_system.info("Status of Product move and Remove: "+Status);												
														}
														break ProductSearch;
													}
																										
													
												}										
											}

										}
										else
										{
											MoveAndRemoveProduct++;
											log_system.info("Product found on screen but there is no product added in the cart");
											log_system.info("Status of Product move and remove: "+Status);
											
										}
										
									}
								}
								
							}
						}								 
					}
				}
				}
				
				
				
			}
		}
		else
		{
			Random rdm=new Random();
			ArrayList<String> product_list_collection=new ArrayList<String>();
			Set<String> product_category_set=Product_added_details.keySet();
			for(String product_name:product_category_set)
			{
				product_list_collection.add(product_name);
			}			
			int index=rdm.nextInt(product_list_collection.size());
			String ProductName=product_list_collection.get(index);
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			WebElement element_product_Wraper_list=Driver.findElement(element_locator);
			List<WebElement> element_product_item_wraper=element_product_Wraper_list.findElements(By.tagName("ol"));
			
			ArrayList<String> Productdetails = new ArrayList<String>();
			String currect_Product_name=null;
			String currect_Product_price=null;
			String current_Product_count=null;
			String currect_Product_price_offer=null;
			int productsearchcount=0;
			
			ProductSearch:
				for(WebElement element_product_item_wraper_itrator:element_product_item_wraper)
				{	
					List<WebElement> element_product_item_container=element_product_item_wraper_itrator.findElements(By.tagName("li"));
					for(WebElement element_product_item_container_itrator:element_product_item_container)
					{						
						List<WebElement> element_product_item_info_container=element_product_item_container_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product-item-info product__card']"));					
						for(WebElement element_product_item_info_cart:element_product_item_info_container)
						{	
							List<WebElement> element_product_item_info_details_cart=element_product_item_info_cart.findElements(By.xpath(".//div[normalize-space(@class) = 'product details product-item-details product__card-details']"));
							for(WebElement element_product_item_info_cart_itrator:element_product_item_info_details_cart)
							{
								
								List<WebElement> element_product_item_info_details_cart_name=element_product_item_info_cart_itrator.findElements(By.xpath(".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"));
								List<WebElement> element_product_item_info_details_cart_price=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product__price-container']"));
								List<WebElement> element_product_item_info_details_cart_add_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'actions-primary product__action-primary']"));
								List<WebElement> element_product_item_info_details_cart_addmore_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'product__actions action__secondary']"));
								List<WebElement> element_product_item_info_details_cart_wishlist_container=element_product_item_info_cart_itrator.findElements(By.xpath(".//div[normalize-space(@class) = 'actions-secondary product__action-secondry']"));
								
								for(WebElement element_product_item_info_details_cart_name_itrator:element_product_item_info_details_cart_name)
								{
									
									Actions act=new Actions(Driver);
									act.moveToElement(element_product_item_info_details_cart_name_itrator).build().perform();
									productsearchcount++;
									if(element_product_item_info_details_cart_name_itrator.getText().toLowerCase().toString().equals(ProductName.toLowerCase().toString()))
									{									
										
										if(element_product_item_info_details_cart_name_itrator.getText().toLowerCase().toString().equals(ProductName.toLowerCase().toString()))
										{			
																
											WebElement currect_Product_element= element_product_item_info_cart_itrator;
											currect_Product_name=element_product_item_info_details_cart_name_itrator.getText().toString();
											ProductSearchbreak:
											for(WebElement element_product_item_info_details_cart_price_itrator:element_product_item_info_details_cart_price)
											{											
												if(element_product_item_info_details_cart_price_itrator.getText().contains("Special Price".toString()))
												{
													currect_Product_price=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[0].toString().trim();
													currect_Product_price_offer=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[1].toString().trim();
												}
												else
												{
													currect_Product_price=element_product_item_info_details_cart_price_itrator.getText().trim().split("Special Price")[0].toString();
												}
																							
												break ProductSearchbreak;
											}
												
										}		
										
										if(Product_added_details.containsKey(ProductName))
										{
											for(WebElement element_product_item_info_details_cart_add_container_itrate:element_product_item_info_details_cart_addmore_container)
											{

												List<WebElement> element_product_item_info_details_cart_add_button=element_product_item_info_details_cart_add_container_itrate.findElements(By.tagName("button"));											
												for(WebElement element_product_item_info_details_cart_add_button_itrate:element_product_item_info_details_cart_add_button)
												{							
													int divcount1=0;
													act.moveToElement(element_product_item_info_details_cart_name_itrator).build().perform();
													
													WebElement addmoreProduct=element_product_item_info_details_cart_add_button_itrate;
													if(addmoreProduct.getText().equals("—"))
													{
														if(addmoreProduct.isDisplayed()==true)
														{												
															act.moveToElement(addmoreProduct).build().perform();
															addmoreProduct.click();
															Thread.sleep(5000);															
															ArrayList<String> productlist_temp=Product_added_details.get(currect_Product_name);
															int productlastcount=Integer.parseInt(productlist_temp.get(2));
															current_Product_count=String.valueOf(productlastcount-1);																												
															Productdetails.add(currect_Product_price);
															Productdetails.add(currect_Product_price_offer);
															Productdetails.add(current_Product_count);
															if(Integer.parseInt(current_Product_count)>0)
															{
																Product_added_details.put(currect_Product_name, Productdetails);
															}
															else
															{
																Product_added_details.remove(currect_Product_name);
															}
															Status=1;
															log_system.info("Product Removed");
															log_system.info("Status of Product move and Remove: "+Status);												
														}
														break ProductSearch;
													}
																										
													
												}										
											}

										}
										else
										{
											MoveAndRemoveProduct++;
											log_system.info("Product found on screen but there is no product added in the cart");
											log_system.info("Status of Product move and remove: "+Status);
											
										}
										
									}
								}
								
							}
						}								 
					}
				}
		}
		
		if(MoveAndRemoveProduct>0)
		{
			Status=0;
		}
			
		return Status;
	}
	
	
	
	public int SelectSubstitute(String ElementKey, String ElementSelector,String Substitute_Type) throws InterruptedException
	{
		
		handle_ajax_call.HandleAjaxCall();
		Thread.sleep(4000);
		((JavascriptExecutor) Driver).executeScript("window.scrollBy(0, -1000)", "");
		Random rdm=new Random();
		ArrayList<String> product_list_collection=new ArrayList<String>();
		Set<String> product_category_set=Product_added_details.keySet();
		for(String product_name:product_category_set)
		{
			product_list_collection.add(product_name);
		}			
		int index=rdm.nextInt(product_list_collection.size());
		String ProductName=product_list_collection.get(index);
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement Shopping_cart_table=Driver.findElement(element_locator);
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
		List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
		
		Substitue_select:
		for(WebElement element_cart_item_info:element_cart_item_list)
		{			
			if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
			{
				WebElement ele_Substitute=element_cart_item_info.findElement(By.xpath(".//div[normalize-space(@class) = 'substitue-selection cc__allow-substitute']"));
				if(Substitute_Type.equals("Allow Substitute"))
				{
					WebElement Allow_Substitute=ele_Substitute.findElement(By.xpath(".//input[starts-with(@id,'allowed')]"));
					Thread.sleep(4000);
					handle_ajax_call.HandleAjaxCall();
					Allow_Substitute.click();
					Thread.sleep(5000);
					Status=1;
					log_system.info("Select Substitute done for Product: "+ ProductName+ " as Allow Substitute");
					log_system.info("Status of select Product substitue: "+Status);
				}
				else if(Substitute_Type.equals("Do Not Allow Substitute"))
				{
					WebElement Allow_Substitute=ele_Substitute.findElement(By.xpath(".//input[starts-with(@id,'notallowed')]"));
					handle_ajax_call.HandleAjaxCall();					
					Allow_Substitute.click();					
					Thread.sleep(5000);
					Status=1;
					log_system.info("Select Substitute done for Product: "+ ProductName+ " as Do Not Allow Substitute");
					log_system.info("Status of select Product substitue: "+Status);
				}
				else
				{
					Status=0;
					log_system.info("Select Substitute Not Done for Product: "+ ProductName+" as Product not found");
					log_system.info("Status of select Product substitue: "+Status);
				}
				break Substitue_select;
			}											
		}
				
		return Status;
	}
	
	
	public int AddProductfromViewCart(String ElementKey, String ElementSelector) throws InterruptedException
	{	
				
		Random rdm=new Random();
		ArrayList<String> product_list_collection=new ArrayList<String>();
		Set<String> product_category_set=Product_added_details.keySet();
		for(String product_name:product_category_set)
		{
			product_list_collection.add(product_name);
		}			
		int index=rdm.nextInt(product_list_collection.size());
		String ProductName=product_list_collection.get(index);
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement Shopping_cart_table=Driver.findElement(element_locator);
		WebDriverWait wait = new WebDriverWait(Driver, 40);
		wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
		List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
		Substitue_select:
		for(WebElement element_cart_item_info:element_cart_item_list)
		{				
			if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
			{
				WebElement ele_Substitute=element_cart_item_info.findElement(By.xpath(".//div[normalize-space(@class) = 'control qty qty__add-substract qty__minus-plus']"));
				ele_Substitute=element_cart_item_info.findElement(By.xpath(".//button[contains(text(),'+')]"));
				ele_Substitute.click();
				ArrayList<String> productlist_temp=Product_added_details.get(ProductName);
				ArrayList<String> Productdetails = new ArrayList<String>();								
				String currect_Product_price=productlist_temp.get(0);;
				int current_Product_count=Integer.parseInt(productlist_temp.get(2));
				String currect_Product_price_offer=productlist_temp.get(1);;								
				current_Product_count++;
				Productdetails.add(currect_Product_price);
				Productdetails.add(currect_Product_price_offer);
				Productdetails.add(String.valueOf(current_Product_count));
				Product_added_details.put(ProductName, Productdetails);
				
				Status=1;
				log_system.info("Product Added");
				log_system.info("Status of AddProductfromViewCart: "+Status);
				break Substitue_select;
			}											
		}
				
		return Status;
	}
	
	
	public int AddInstruction(String ElementKey, String ElementSelector,String Instruction) throws InterruptedException
	{	
		Thread.sleep(4000);
		handle_ajax_call.HandleAjaxCall();
		Random rdm=new Random();
		ArrayList<String> product_list_collection=new ArrayList<String>();
		Set<String> product_category_set=Product_added_details.keySet();
		for(String product_name:product_category_set)
		{
			product_list_collection.add(product_name);
		}			
		int index=rdm.nextInt(product_list_collection.size());
		String ProductName=product_list_collection.get(index);
		
		
		if(Instuction_Added.contains(ProductName))
		{
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			WebElement Shopping_cart_table=Driver.findElement(element_locator);
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
			List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
			Substitue_select:
			for(WebElement element_cart_item_info:element_cart_item_list)
			{				
				if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
				{
					handle_ajax_call.HandleAjaxCall();
					WebElement ele_Substitute_instruction=element_cart_item_info.findElement(By.xpath(".//a[normalize-space(@class) = 'cc__gift-edit cc__icon-instructions icon-instructions']"));
					Actions act=new Actions(Driver);
					act.moveToElement(ele_Substitute_instruction).build().perform();
					ele_Substitute_instruction.click();
					WebElement ele_Substitute_instruction_txt=element_cart_item_info.findElement(By.xpath(".//textarea[normalize-space(@class) = 'input-text cc__gift-textarea']"));
					act.moveToElement(ele_Substitute_instruction_txt).build().perform();
					ele_Substitute_instruction_txt.sendKeys(Keys.CONTROL+"a");
					ele_Substitute_instruction_txt.sendKeys(Keys.BACK_SPACE);
					ele_Substitute_instruction_txt.sendKeys(Instruction);
					WebElement ele_Substitute_instruction_save_btn=element_cart_item_info.findElement(By.xpath(".//button[normalize-space(@class) = 'btn btn__default']"));
					act.moveToElement(ele_Substitute_instruction_save_btn).build().perform();
					ele_Substitute_instruction_save_btn.click();
					Thread.sleep(3000);
					Status=1;
					log_system.info("Instruction Added");
					log_system.info("Status of AddInstruction: "+Status);
					break Substitue_select;
				}											
			}
		}
		else
		{
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			WebElement Shopping_cart_table=Driver.findElement(element_locator);
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
			List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
			Substitue_select:
			for(WebElement element_cart_item_info:element_cart_item_list)
			{				
				if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
				{
					WebElement ele_Substitute_instruction=element_cart_item_info.findElement(By.xpath(".//a[normalize-space(@class) = 'cc__gift-edit cc__icon-instructions icon-instructions']"));
					Actions act=new Actions(Driver);
					act.moveToElement(ele_Substitute_instruction).build().perform();
					ele_Substitute_instruction.click();
					WebElement ele_Substitute_instruction_txt=element_cart_item_info.findElement(By.xpath(".//textarea[normalize-space(@class) = 'input-text cc__gift-textarea']"));
					act.moveToElement(ele_Substitute_instruction_txt).build().perform();
					ele_Substitute_instruction_txt.sendKeys(Instruction);
					WebElement ele_Substitute_instruction_save_btn=element_cart_item_info.findElement(By.xpath(".//button[normalize-space(@class) = 'btn btn__default']"));
					act.moveToElement(ele_Substitute_instruction_save_btn).build().perform();
					ele_Substitute_instruction_save_btn.click();
					Instuction_Added.add(ProductName);
					Thread.sleep(3000);
					Status=1;
					log_system.info("Instruction Added");
					log_system.info("Status of AddInstruction: "+Status);
					break Substitue_select;
				}											
			}
		}
		
				
		return Status;
	}

	
	public int EditInstruction(String ElementKey, String ElementSelector,String Instruction) throws InterruptedException
	{	
		if(!Instuction_Added.isEmpty())
		{
			Random rdm=new Random();				
			int index=rdm.nextInt(Instuction_Added.size());
			String ProductName=Instuction_Added.get(index);
			
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			WebElement Shopping_cart_table=Driver.findElement(element_locator);
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
			List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
			Substitue_select:
			for(WebElement element_cart_item_info:element_cart_item_list)
			{				
				if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
				{
					WebElement ele_Substitute_instruction=element_cart_item_info.findElement(By.xpath(".//a[normalize-space(@class) = 'cc__gift-edit cc__icon-instructions icon-instructions']"));
					Actions act=new Actions(Driver);
					act.moveToElement(ele_Substitute_instruction).build().perform();
					ele_Substitute_instruction.click();
					WebElement ele_Substitute_instruction_txt=element_cart_item_info.findElement(By.xpath(".//textarea[normalize-space(@class) = 'input-text cc__gift-textarea']"));
					act.moveToElement(ele_Substitute_instruction_txt).build().perform();
					ele_Substitute_instruction_txt.sendKeys(Keys.CONTROL+"a");
					ele_Substitute_instruction_txt.sendKeys(Keys.BACK_SPACE);
					ele_Substitute_instruction_txt.sendKeys(Instruction);
					WebElement ele_Substitute_instruction_save_btn=element_cart_item_info.findElement(By.xpath(".//button[normalize-space(@class) = 'btn btn__default']"));
					act.moveToElement(ele_Substitute_instruction_save_btn).build().perform();
					ele_Substitute_instruction_save_btn.click();
					Thread.sleep(3000);
					Status=1;
					log_system.info("Instruction Added");
					log_system.info("Status of AddInstruction: "+Status);
					break Substitue_select;
				}											
			}
		}
		else
		{
			log_system.info("Instruction not added for any product");
			Status=1;
		}
				
		return Status;
	}
	
	public int RemoveInstruction(String ElementKey, String ElementSelector) throws InterruptedException
	{	
		if(!Instuction_Added.isEmpty())
		{
			Random rdm=new Random();				
			int index=rdm.nextInt(Instuction_Added.size());
			String ProductName=Instuction_Added.get(index);
			
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			WebElement Shopping_cart_table=Driver.findElement(element_locator);
			WebDriverWait wait = new WebDriverWait(Driver, 40);
			wait.until(ExpectedConditions.presenceOfElementLocated(element_locator));
			List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
			Substitue_select:
			for(WebElement element_cart_item_info:element_cart_item_list)
			{				
				if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
				{
					WebElement ele_Substitute_instruction=element_cart_item_info.findElement(By.xpath(".//a[normalize-space(@class) = 'action delete-item-trigger action-delete cc__remove cc__clear-instruction']"));
					Actions act=new Actions(Driver);
					act.moveToElement(ele_Substitute_instruction).build().perform();
					ele_Substitute_instruction.click();
					Thread.sleep(3000);
					Instuction_Added.remove(ProductName);
					Status=1;
					log_system.info("Instruction Added");
					log_system.info("Status of AddInstruction: "+Status);
					break Substitue_select;
				}											
			}
		}
		else
		{
			log_system.info("Instruction not added for any product");
			Status=1;
		}
				
		return Status;
	}
	
	public int RemoveProductfromViewCart(String ElementKey, String ElementSelector) throws InterruptedException
	{	
		
		Random rdm=new Random();
		ArrayList<String> product_list_collection=new ArrayList<String>();
		Set<String> product_category_set=Product_added_details.keySet();
		for(String product_name:product_category_set)
		{
			product_list_collection.add(product_name);
		}			
		int index=rdm.nextInt(product_list_collection.size());
		String ProductName=product_list_collection.get(index);
		
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		WebElement Shopping_cart_table=Driver.findElement(element_locator);
		List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
		Substitue_select:
		for(WebElement element_cart_item_info:element_cart_item_list)
		{				
			if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
			{
				WebElement ele_Substitute=element_cart_item_info.findElement(By.xpath(".//div[normalize-space(@class) = 'control qty qty__add-substract qty__minus-plus']"));
				ele_Substitute=element_cart_item_info.findElement(By.xpath(".//button[contains(text(),'—')]"));
				Actions act=new Actions(Driver);
				act.moveToElement(ele_Substitute).build().perform();
				ele_Substitute.click();
				ArrayList<String> productlist_temp=Product_added_details.get(ProductName);
				ArrayList<String> Productdetails = new ArrayList<String>();								
				String currect_Product_price=productlist_temp.get(0);;
				int current_Product_count=Integer.parseInt(productlist_temp.get(2));
				String currect_Product_price_offer=productlist_temp.get(1);;								
				current_Product_count--;
				if(current_Product_count>0)
				{
					Productdetails.add(currect_Product_price);
					Productdetails.add(currect_Product_price_offer);
					Productdetails.add(String.valueOf(current_Product_count));
					Product_added_details.put(ProductName, Productdetails);
				}
				else
				{
					Product_added_details.remove(ProductName);
					Instuction_Added.remove(ProductName);
				}
																	
				Status=1;
				log_system.info("Product removed");
				log_system.info("Status of removeProductfromViewCart: "+Status);
				break Substitue_select;
			}											
		}
				
		return Status;
	}

	
	public int DeleteProductfromViewCart(String ElementKey, String ElementSelector,String DeleteAll) throws InterruptedException
	{	
				
		if(DeleteAll.toLowerCase().contains("all"))
		{			
			ArrayList<String> product_list_collection=new ArrayList<String>();
			Set<String> product_category_set=Product_added_details.keySet();
			for(String product_name:product_category_set)
			{
				product_list_collection.add(product_name);
			}			
			
			for(String ProductName:product_list_collection)
			{
				element_locator=element_loc.getElement(ElementKey, ElementSelector);
				WebElement Shopping_cart_table=Driver.findElement(element_locator);
				List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
				Substitue_select:
				for(WebElement element_cart_item_info:element_cart_item_list)
				{				
					if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
					{
						WebElement ele_Substitute=element_cart_item_info.findElement(By.xpath(".//a[normalize-space(@class) = 'action delete-item-trigger action-delete cc__remove']"));

						Actions act=new Actions(Driver);
						act.moveToElement(ele_Substitute).build().perform();
						ele_Substitute.click();
						Product_added_details.remove(ProductName);
						Instuction_Added.remove(ProductName);
						Status=1;
						log_system.info("Product Delete");
						log_system.info("Status of DeleteProductfromViewCart: "+Status);
						break Substitue_select;
					}											
				}
			}
			
			
		}
		else
		{
			Random rdm=new Random();
			ArrayList<String> product_list_collection=new ArrayList<String>();
			Set<String> product_category_set=Product_added_details.keySet();
			for(String product_name:product_category_set)
			{
				product_list_collection.add(product_name);
			}			
			int index=rdm.nextInt(product_list_collection.size());
			String ProductName=product_list_collection.get(index);
			
			
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			WebElement Shopping_cart_table=Driver.findElement(element_locator);
			List<WebElement> element_cart_item_list=Shopping_cart_table.findElements(By.xpath(".//tbody[normalize-space(@class) = 'cart item']"));
			Substitue_select:
			for(WebElement element_cart_item_info:element_cart_item_list)
			{				
				if(element_cart_item_info.getText().toLowerCase().toString().contains(ProductName.toLowerCase().toString()))
				{
					WebElement ele_Substitute=element_cart_item_info.findElement(By.xpath(".//a[normalize-space(@class) = 'action delete-item-trigger action-delete cc__remove']"));
					Actions act=new Actions(Driver);
					act.moveToElement(ele_Substitute).build().perform();
					ele_Substitute.click();
					Product_added_details.remove(ProductName);															
					Status=1;
					log_system.info("Product Delete");
					log_system.info("Status of DeleteProductfromViewCart: "+Status);
					break Substitue_select;
				}											
			}
		}
		
				
		return Status;
	}

	public int VerifySummaryViewCart(String ElementKey, String ElementSelector) throws InterruptedException
	{	
		handle_ajax_call.HandleAjaxCall();
		Thread.sleep(8000);
		if(!Product_added_details.isEmpty())
		{
			element_locator=element_loc.getElement(ElementKey, ElementSelector);
			handle_ajax_call.HandleAjaxCall();
			((JavascriptExecutor) Driver).executeScript("window.scrollBy(0, -1000)", "");								
			WebElement Shopping_cart_table=Driver.findElement(element_locator);			
			float totalPrice=0;
			Set<String> keyset=Product_added_details.keySet();		
			for(String Product_name:keyset)
			{
				String price=Product_added_details.get(Product_name).get(0).replace("$","");
				String offer_price=Product_added_details.get(Product_name).get(1);
				
				if(offer_price!=null)
				{
					offer_price=offer_price.replace("$", "");
					price=offer_price;
				}
				float product_count=Float.parseFloat(Product_added_details.get(Product_name).get(2));
				price=String.valueOf(Float.parseFloat(price)*product_count);
				totalPrice=Float.parseFloat(price)+totalPrice;				
			}
			
			float Subtotalprice=Float.parseFloat(Shopping_cart_table.findElement(By.xpath(".//span[normalize-space(@data-th) = 'Subtotal']")).getText().replace("$", ""));
			float Shipingprice = 0;
			try {
				String Shipingprice_=Shopping_cart_table.findElement(By.xpath(".//span[normalize-space(@data-th) = 'Shipping']")).getText().replace("$", "");
				if(!Shipingprice_.contains("Free"))
				{
					Shipingprice=Float.parseFloat(Shopping_cart_table.findElement(By.xpath(".//span[normalize-space(@data-th) = 'Shipping']")).getText().replace("$", ""));
				}
			} catch (NumberFormatException e) {
				
			}			
			float orderamount=Float.parseFloat(Shopping_cart_table.findElement(By.xpath(".//td[normalize-space(@data-th) = 'Order Total']")).getText().replace("$", ""));
			
			BigDecimal bd = new BigDecimal(totalPrice);
			totalPrice =Float.parseFloat(String.valueOf(bd.setScale(2, RoundingMode.HALF_UP)));
			
			if(totalPrice<50.00)
			{
				if(Subtotalprice==totalPrice)
				{
					totalPrice=totalPrice+Shipingprice;
					BigDecimal bd1 = new BigDecimal(totalPrice);		
					totalPrice =Float.parseFloat(String.valueOf(bd1.setScale(2, RoundingMode.HALF_UP)));
					if(totalPrice==orderamount)
					{
						Status=1;
					}
				}
			}				
			else
			{
				if(Subtotalprice==totalPrice)
				{
					if(totalPrice==orderamount)
					{
						Status=1;
					}
				}
			}
				
		}
			
		else
		{
			if(Driver.findElement(By.xpath(".//div[normalize-space(@class) = 'cart-empty']")).getText().contains("You have no items in your shopping cart."))
				Status=1;
		}
			

		return Status;
	}
	
	
	public int SelectSlot(String ElementKey, String ElementSelector,String selection_date,String Selection_time) throws InterruptedException
	{
		Thread.sleep(3000);
		int Date_search=0;
		int Time_search=0;
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,-1000)");
		WebElement element;
		element_locator=element_loc.getElement(ElementKey, ElementSelector);
		Actions act1=new Actions(Driver);
		act1.moveToElement(Driver.findElement(element_locator)).build().perform();
		element=Driver.findElement(element_locator);		
		element=element.findElement(By.tagName("tbody"));
		List<WebElement> elements=element.findElements(By.tagName("tr"));
		break_slot:
		for(WebElement element2:elements)
		{
			if(element2.getText().toLowerCase().toString().contains(selection_date.toLowerCase().toString()))
			{
				Date_search++;
				elements=element2.findElements(By.tagName("td"));
				for(WebElement element3:elements)
				{
					if(element3.getText().toLowerCase().toString().contains(Selection_time.toLowerCase().toString()))
					{						
						elements=element2.findElements(By.tagName("div"));
						for(WebElement element4:elements)
						{
							if(element4.getText().toLowerCase().toString().contains(Selection_time.toLowerCase().toString()))
							{
								Time_search++;
								
								if(element4.getAttribute("class").toLowerCase().toString().equals("Slot".toLowerCase().toString()) || element4.getAttribute("class").toLowerCase().toString().equals("slot selected".toLowerCase().toString()))
								{									
									Actions act=new Actions(Driver);
									act.moveToElement(element4).build().perform();
									element4.click();
									if(element4.getAttribute("class").toLowerCase().toString().equals("slot selected".toLowerCase().toString()))
									{
										Status=1;
										log_system.info("Slot Selected: "+selection_date+" "+ Selection_time);
										log_system.info("Status of select Product substitue: "+Status);
										break break_slot;
									}
									else
									{
										Status=1;
										log_system.info("system is not able to select slot: "+selection_date+" "+ Selection_time);
										log_system.info("Status of select Product substitue: "+Status);
										break break_slot;
									}
								}
								else
								{
									Status=0;
									log_system.info("Slot is disabled: "+ selection_date+" "+Selection_time);
									log_system.info("Status of Selection of slot: "+Status);
									break break_slot;
								}
								
							}
						}
					}
				}
			}
		}
		
		if(Date_search<=0)
		{
			Status=0;
			log_system.info("Slot date not founnd: "+ selection_date+" "+Selection_time);
			log_system.info("Status of slot Selection: "+Status);
		}
		else if(Time_search<=0)
		{
			Status=0;
			log_system.info("Slot Time not founnd: "+ selection_date+" "+Selection_time);
			log_system.info("Status of slot Selection: "+Status);
		}
		return Status;
	}
	
	
	public int CloseBrowser(String Browser_type) throws Exception
	{				
		if(Browser_type.contains("All"))
		{
			
			Driver.quit();
			Status=1;
			log_system.info("Browser Closed successfully");
			log_system.info("Status of Close Browser: "+Status);
		}
		else if (Browser_type.contains("Child"))
		{
			
			 for (String winHandle : Driver.getWindowHandles()) {
				 if(!winHandle.equals(mainwindow))
				 {
					 Driver.close();
					 Driver.switchTo().window(mainwindow);
					 Status=1;
				 }
			        
			    }
		}
		return Status;
	}
	
	public void QuitDriver() throws Exception
	{					
		
		
		reports.flush();
		log_system.info("Execution Done");
		System.exit(0);
		
	}
}
