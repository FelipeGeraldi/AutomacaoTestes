package br.com.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

//Felipe Geraldi 28/06/2020


public class SeleniumWebDriver {

	public static WebDriver driver;

	// Exemplo tipo navegador: WebDriver driver = new InternetExplorerDriver();
	// Exemplo tipo navegador: WebDriver driver = new ChromeDriver();

	public SeleniumWebDriver() {
		// Identifica onde esta o chromedriver
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();

	}

	// RETORNA DRIVER SELENIUM
	public WebDriver pegarDriver() {
		return driver;

	}

	// Exemplo: driver.get("http://www.google.com");
	public void abrirBrowser(String url) {
		driver.get(url);
	}

	// Exemplo: driver.close();
	public void fecharJanelaClose() {
		driver.close();
	}

	// Exemplo: driver.quit();
	public void fecharJanelaQuit() {
		driver.quit();

	}

	// Exemplo: driver.findElement(By.id("coolestWidgetEvah"));
	public void localizaElementoId(String id) {
		driver.findElement(By.id(id));

	}

	// Exemplo: driver.findElement(By.tagName("iframe"));
	public void localizaElementoTagName(String TagName) {
		driver.findElement(By.tagName(TagName));

	}

	// Exemplo: driver.findElement(By.name("cheese"));
	public void localizaElementoName(String Name) {
		driver.findElement(By.name(Name));

	}

	// Exemplo: driver.findElement(By.linkText("cheese"));
	public void localizaElementoLinkText(String LinkText) {
		driver.findElement(By.linkText(LinkText));

	}

	// Exemplo: driver.findElement(By.partialLinkText("cheese"));
	public void localizaElementoPartialLinkText(String PartialLinkText) {
		driver.findElement(By.partialLinkText(PartialLinkText));

	}

	// Exemplo: driver.findElement(By.cssSelector("#food span.dairy.aged"))
	public void localizaElementoCssSelector(String CssSelector) {
		driver.findElement(By.cssSelector(CssSelector));

	}

	// Exemplo: driver.findElements(By.xpath("//input"));
	public void localizaElementoXpath(String Xpath) {
		driver.findElement(By.xpath(Xpath));

	}

	// Retorna a URL da pagina da janela atual do browser
	public String retornaURLJanelaAtual() {

		return driver.getCurrentUrl();

	}

	// Retorna o codigo-fonte da pagina da janela atual do browser
	public String RetornaCodigoFonteAtual() {

		return driver.getPageSource();

	}

	// Retorna o titulo da pagina atual do browser
	public String retornaTituloPaginaAtual() {

		return driver.getTitle();
	}

	// Retorna o identificador da janela atual do browser
	public String retornaIdentificadorJanelaAtual() {

		return driver.getWindowHandle();

	}

	// Exemplo: driver.navigate().to("http://www.example.com");
	public void acessaHistoricoBrowserNavegadorUmaPagina(String url) {

		driver.navigate().to(url);

	}

	// Exemplo: driver.navigate().forward(); avanca pagina
	public void avancaPagina() {

		driver.navigate().forward();

	}

	// Exemplo: driver.navigate().back(); volta pagina
	public void voltaPagina() {

		driver.navigate().back();

	}

	// Exemplo: driver.switchTo().window(handle);
	public void focoFrameJanelaWindow(String handle) {

		driver.switchTo().window(handle);

	}

	// Exemplo: driver.switchTo().alert();
	public void focoFrameJanelaAlert() {

		driver.switchTo().alert();

	}

	// acessaFrame
	public void acessaFrame(String id) {
		driver.switchTo().frame(id);

	}

	// Pega o texto do elemento do id
	public void pegaTexto(String idPegaTexto) {

		driver.findElement(By.id(idPegaTexto)).getText();

	}

	// Limpa Campo de texto id
	public void limpaCampoId(String idLimpaCampo) {

		if (driver.findElement(By.id(idLimpaCampo)).isDisplayed())
			driver.findElement(By.id(idLimpaCampo)).clear();

	}

	// Limpa Campo de texto xpath
	public void limpaCampoXpath(String idLimpaCampo) {

		driver.findElement(By.xpath(idLimpaCampo)).clear();

	}

	// ClickId
	public void clickId(String clickId) throws InterruptedException {

		if (driver.findElement(By.id(clickId)).isDisplayed()) {
			driver.findElement(By.id(clickId)).click();

		}
	}

	// ClickClass
	public void clickClass(String clickClass) {

		if (driver.findElement(By.className(clickClass)).isDisplayed()) {
			driver.findElement(By.className(clickClass)).click();

		}
	}

	// ClickName
	public void clickName(String clickName) {

		driver.findElement(By.name(clickName)).click();

	}

	// ClickXpath
	public void clickXpath(String clickXpath) {

		driver.findElement(By.xpath(clickXpath)).click();
	}

	// ClickcssSelector
	public void clickidSelector(String clickidSelector) {

		driver.findElement(By.id(clickidSelector)).click();
	}

	// ClickLink
	public void clickLink(String clickLink) {

		driver.findElement(By.linkText(clickLink)).click();
	}

	// Visualizar se o elemento esta visivel para o utilizador
	public void verificaElementoVisivel(String idElementoVisivel) {

		driver.findElement(By.id(idElementoVisivel)).isDisplayed();
	}

	// Verifica se o elemento esta ativo na tela em determinado momento
	public void verificaElementoAtivo(String idElementoAtivo) {

		driver.findElement(By.id(idElementoAtivo)).isEnabled();
	}

	// Verifica se o elemento está selecionado no determinado momento
	public void verificaElementoSelecionado(String idElementoSelecionado) {

		driver.findElement(By.id(idElementoSelecionado)).isSelected();
	}

	// Inserir valores em determinados campos do browser com id
	public void insereValorCampoId(String id, String insereValor) throws InterruptedException {

		driver.findElement(By.id(id)).sendKeys(insereValor);
	}

	// Inserir valores em determinados campos do browser com xpath
	public void insereValorCampoXpath(String xpath, String insereValor) throws InterruptedException {

		driver.findElement(By.xpath(xpath)).sendKeys(insereValor);
	}

	// Inserir valores em determinados campos do browser com class
	public void insereValorCampoClass(String className, String insereValor) {

		driver.findElement(By.className(className)).sendKeys(insereValor);
	}

	// Inserir valores em determinados campos do browser com css
	public void insereValorCampoCss(String css, String insereValor) {

		driver.findElement(By.cssSelector(css)).sendKeys(insereValor);
	}

	// Inserir valores em determinados campos do browser com name
	public void insereValorCampoName(String name, String insereValor) {

		driver.findElement(By.name(name)).sendKeys(insereValor);
	}

	// Trabalhando com teclado windows
	// id
	public void comandoTecladoid(Keys campo, String idTeclado) {

		driver.findElement(By.id(idTeclado)).sendKeys(campo);

	}

	// class
	public void comandoTecladoclass(Keys campo, String classTeclado) {

		driver.findElement(By.className(classTeclado)).sendKeys(campo);

	}

	// xpath
	public void comandoTecladoxpath(String xpathTeclado) {

		driver.findElement(By.xpath(xpathTeclado)).sendKeys(Keys.ENTER);

	}

	// name
	public void comandoTecladoname(Keys campo, String nameTeclado) {

		driver.findElement(By.name(nameTeclado)).sendKeys(campo);

	}

	// linktext
	public void comandoTecladolinktext(Keys campo, String linktextTeclado) {

		driver.findElement(By.linkText(linktextTeclado)).sendKeys(campo);

	}

	// css
	public void comandoTecladocss(Keys campo, String cssTeclado) {

		driver.findElement(By.cssSelector(cssTeclado)).sendKeys(campo);

	}

	// maximize
	public void maximize() {

		driver.manage().window().maximize();

	}

	// Espera load
	public void waitcomponentvisibleload() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		ExpectedCondition<Boolean> condition = ExpectedConditions
				.invisibilityOfElementLocated(By.id("mrwp_spner_loading_"));
		wait.until(condition);
		Thread.sleep(500);
	}

	// Espera componente
	public void waitcomponentvisibleid(String id) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		ExpectedCondition<WebElement> condition = ExpectedConditions.elementToBeClickable(By.id(id));
		wait.until(condition);
		Thread.sleep(1000);
	}

	// Aguarda o componente ficar visivel co xpath
	public void waitcomponentvisiblexpath(String ident) throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 100000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ident)));
		Thread.sleep(1000);
	}

	// importe de imagens selenium

	public void importFile() throws InterruptedException {

		File imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {

			Files.copy(imagem, new File("C:\\Projeto\\" + dataAtual() + ".png"));

			String filePath = "C:\\Projeto\\" + dataAtual() + ".png";
			WebElement chooseFile = driver.findElement(By.className("file-input"));
			chooseFile.sendKeys(filePath);

			Thread.sleep(1000);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	

	// pegarTextoId
	public String pegarTextoId(String id) {

		return driver.findElement(By.id(id)).getText();

	}

	// pegarTextoName
	public void pegarTextoName(String name) {

		driver.findElement(By.name(name)).getText();

	}

	// pegarTextoXpath
	public String pegarTextoXpath(String xpath) {

		return driver.findElement(By.xpath(xpath)).getText();

	}

	// pegarTextoCssSelector
	public String pegarTextoCssSelector(String cssSelector) {

		return driver.findElement(By.cssSelector(cssSelector)).getText();

	}

	// valida texto id
	public void validatextid(String idgettext, String textvalidado) {

		driver.findElement(By.id(idgettext)).getText().compareTo(textvalidado);

	}

	// valida texto xpath
	public void validatextxpath(String xpathgettext, String textvalidado) {

		driver.findElement(By.xpath(xpathgettext)).getText().compareTo(textvalidado);

	}

	// Print
	public void takesScreenshot(String TelaLoginScreenshot) {

		File imagemPesquisa = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(imagemPesquisa,
					new File("C:\\Projeto\\" + TelaLoginScreenshot + "" + dataAtual() + ".jpg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String dataAtual() {
		String infordate = null;
		Locale locale = new Locale("pt", "BR");
		Date data = new Date();
		SimpleDateFormat formatarDate = new SimpleDateFormat("yyyyMMddHHmmss", locale);
		infordate = formatarDate.format(data);
		return infordate;

	}

	public void descerpagina() throws AWTException, InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 9000)");

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(3000);

	}
}
