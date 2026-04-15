package Com.DemoShop_GenericUtility;

public interface FrameWorkConstants {
	
	JavaUtility4 jUtil= new JavaUtility4();

	static final String excelFilePath="./src/test/resources/TestData/addressDataN2.xlsx";
	
	static final String propertyFilePath="./src/test/resources/TestData/CommonDataN2.properties";
	
	static final String screenshotPath="./screenshot/"+jUtil.localDateAndTime()+".png";
	
	static final String listenersScreenshotPath="./listenersScreenshots/"+jUtil.localDateAndTime()+".png";
	
	static final String reportsPath="./reports/"+jUtil.localDateAndTime()+".html";
	
}

	/*JavaUtility4 jUtil = new JavaUtility4();

	String excelFilePath = "./src/test/resorces/TestData/addressDataN2.xlsx";
	String propertyFilePath = "./src/test/resorces/TestData/commonDataN2.properties";
	String screenshotPath = "./screenshot/" + jUtil.localDataAndTime() + ".png";
	String listenersScreenshotPath = "./listener/" + jUtil.localDataAndTime() + ".png";
	String reportPath = "./report/"  +jUtil.localDataAndTime() + ".html";
	
}*/
