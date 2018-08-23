package goCanvasLogin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class login {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		String State = "VA";
		
		File f = new File("src");
		File fs = new File(f,"canvas-release-9.7.3.1.apk");
		
		//Created a desired capabilities object to set Emulator, and provide the app to test on.
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PixelXL");
		cap.setCapability(MobileCapabilityType.APP , fs.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		//detecting the pop up permissions 
		cap.setCapability("appWaitPackage", "com.google.android.packageinstaller");
		cap.setCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.GrantPermissionsActivity");
		/*cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.gocanvas");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.gocanvas.library.intro.IntroFragmentActivity");*/
		
	
		//create a android driver object. arguments takes 1. the host url object 2.desired cap
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//granting the permission by clicking allow
		driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
		driver.findElementByXPath("//android.widget.Button[@text='Log In']").click();
		driver.findElementById("com.gocanvas:id/username").sendKeys("testbeta1@yopmail.com");
		driver.findElementById("com.gocanvas:id/password").sendKeys("canvas");
		driver.findElementByXPath("//android.widget.Button[@text='Log In']").click();
		
		
		//wait till the on boarding is over and the element specified is detected.
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
		            .id("com.gocanvas:id/action_search")));
		
		driver.findElementByXPath("//android.widget.TextView[@text='Sales Order/Invoice Receipt']").click();
		//name
		driver.findElement(By.xpath("//android.widget.ScrollView[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='0']")).sendKeys("Saurabh");
		//address
		driver.findElement(By.xpath("//android.widget.ScrollView[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='2']/android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='0']")).sendKeys("Freedom Drive");
		driver.hideKeyboard();
		//city
		driver.findElement(By.xpath("//android.widget.ScrollView[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='0']")).sendKeys("Freedom Drive");
		driver.hideKeyboard();
		//State
		driver.findElement(By.xpath("//android.widget.ScrollView[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='4']/android.widget.Button[@index='1']")).click();
		//scrolling to find VA
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+State+"\").instance(0))").click();
		
		//WebDriverWait stall = new WebDriverWait(driver, 30);
		//stall.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='5']/android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='0']")));
		
		           //.id("com.gocanvas:id/action_search")));
		
		//Zip
		//driver.findElement(By.xpath("//android.widget.ScrollView[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='5']/android.widget.LinearLayout[@index='1']/android.widget.EditText[@index='0']")).setValue("20190");;
		//next Button
		driver.findElementById("com.gocanvas:id/finishButton").click();
		
		
		//driver.findElementByXPath("//android.widget.RelativeLayout[@index='0']/android.widget.FrameLayout[@index='3']/android.widget.LinearLayout[@index='0']/android.widget.Button[@index='1']").click();
		/*WebDriverWait wait3 = new WebDriverWait(driver, 30);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By
		            .id("com.gocanvas:id/finishButton")));
		driver.findElementById("com.gocanvas:id/finishButton").click();
		
		WebDriverWait wait4 = new WebDriverWait(driver, 30);
		wait4.until(ExpectedConditions.presenceOfElementLocated(By
		            .id("//android.widget.Button[@text='ALLOW']")));
		driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
		
		
		WebDriverWait wait5 = new WebDriverWait(driver, 30);
		wait5.until(ExpectedConditions.presenceOfElementLocated(By
		            .id("com.gocanvas:id/finishButton")));
		driver.findElementById("com.gocanvas:id/finishButton").click();*/
		//driver.findElement(By.id("com.gocanvas:id/action_search")).click();
		 
		//	
		/*while (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).size()>0) {
		    driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][2]")).click();
		}*/
		
		//driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
		//driver.findElementByXPath("//android.widget.Button[@text='ALLow']").click();
	}

}
