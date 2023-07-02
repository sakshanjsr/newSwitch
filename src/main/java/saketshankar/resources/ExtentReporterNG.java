package saketshankar.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		
		String path = "C://Users//Sanjay Prasad//eclipse-workspace//SeleniumFrameDesign//Results//index.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path) ;
		sparkReporter.config().setReportName("Saket Automation Report");
		sparkReporter.config().setDocumentTitle("Saket Automation");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Tester", "Saket Shankar");
		return extent;
		
	}

}
