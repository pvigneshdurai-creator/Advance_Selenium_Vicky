package TestAddress;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoShop_GenericUtility.BaseTest5;
import Com.DemoWebShop_POM.Addresses;

public class TC_002_Verify_User_is_able_to_delete_address_or_not extends BaseTest5{
	
	@Test
	public void  deleteAddress() throws InterruptedException,EncryptedDocumentException,IOException{
		
		Thread.sleep(2000);
		webDriverUtility.javaScriptScrollToElement(driver,homePage.getAddressesBtn());
		homePage.getAddressesBtn().click();
		
		Addresses addresses = new Addresses(driver);
		addresses.getDeleteBtn().click();
		Thread.sleep(2000);
		webDriverUtility.alertForAccept(driver);
		
		Thread.sleep(3000);
		webDriverUtility.webPageScreenshot(driver);
	
	}

}
