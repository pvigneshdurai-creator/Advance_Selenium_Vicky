package TestAddress;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoShop_GenericUtility.BaseTest5;
import Com.DemoShop_GenericUtility.FileUtility;
import Com.DemoWebShop_POM.AddressPage;
import Com.DemoWebShop_POM.Addresses;

public class TC_001_Verify_User_is_able_to_add_address_or_not_Test extends BaseTest5 {

	@Test
	public void addAddress() throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(2000);
		webDriverUtility.javaScriptScrollToElement(driver, homePage.getAddressesBtn());
		homePage.getAddressesBtn().click();

		Addresses addressPage = new Addresses(driver);
		webDriverUtility.javaScriptScrollToElement(driver, addressPage.getAddNewBtn());
		addressPage.getAddNewBtn().click();

		AddressPage addNewAddressPage = new AddressPage(driver);
		addNewAddressPage.getFirstNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		addNewAddressPage.getLastNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		addNewAddressPage.getEmailTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));

		webDriverUtility.selectByVisibleText(addNewAddressPage.getCountryDropDown(),
				fileUtility.readDataFromExcelFile("Sheet1", 1, 3));

		// address.getCountryDropDown().sendKeys(fileUtility.readDataFromExcelFile("Sheet1",
		// 1, 3));

		addNewAddressPage.getCityTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		addNewAddressPage.getAddress1TextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		addNewAddressPage.getZipCodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 6));
		addNewAddressPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 7));
		addNewAddressPage.getSaveBtn().click();
		Thread.sleep(3000);
		webDriverUtility.webPageScreenshot(driver);

	}

}
