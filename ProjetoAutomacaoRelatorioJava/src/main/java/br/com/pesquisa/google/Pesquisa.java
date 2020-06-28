package br.com.pesquisa.google;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.ClickAction;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import br.com.utils.ExcelApiTest;
import br.com.utils.ExtentManager;
import br.com.utils.SeleniumWebDriver;


//Felipe Geraldi 28/06/2020



public class Pesquisa {

	private ExtentReports extent = ExtentManager.getInstance();
	private ExtentTest test;
	private SeleniumWebDriver driver;

	@After
	public void endtest() {
		driver.fecharJanelaQuit();

	}

	@Before
	public void startest() throws Exception {

		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new SeleniumWebDriver();
		driver.abrirBrowser("https://www.google.com.br/");
		driver.maximize();

	}

	@Test
	public void pesquisando() throws Exception {

		// nome da Aba excel
		String sheet = "TelaGoogle";

		ExcelApiTest eat = new ExcelApiTest("massa/MassaProjeto.xlsx");

		for (int i = 2; i < 3; i++) {

			test = extent.startTest(eat.getCellData(sheet, "startTest", i))
					.assignCategory(eat.getCellData(sheet, "assignCategory", i));

				try{
				
				//Acessar Google - Escrever Teste
				if (i == 2) {
					driver.waitcomponentvisibleload();
					driver.insereValorCampoName(eat.getCellData(sheet, "nameCampo", 2),"Testes");
					driver.waitcomponentvisibleload();
					driver.clickName(eat.getCellData(sheet, "nameBtn", 2));
				
				}
				
			
		
			

				driver.takesScreenshot("TelaGoogleScreenshot");
				test.addScreenCapture("C:\\Projeto\\TelaGoogleScreenshot" + "" + driver.dataAtual() + ".jpg");
				test.log(LogStatus.PASS, eat.getCellData(sheet, "logstatuspass", i));
				Assert.assertTrue(true);
				extent.endTest(test);
				extent.flush();

			} catch (NoSuchElementException e) {

				test.log(LogStatus.FAIL, "<pre>" + e.toString() + "</pre>");
				driver.takesScreenshot("TelaScreenshotFalha");
				test.addScreenCapture("C:\\Projeto\\TelaGoogleScreenshotFalha" + "" + driver.dataAtual() + ".jpg");
				driver.fecharJanelaQuit();
				extent.endTest(test);
				extent.flush();

				throw e;

			}

		}

	}
}
