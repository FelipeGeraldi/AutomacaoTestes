package br.com.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.relevantcodes.extentreports.ExtentReports;

//Felipe Geraldi 28/06/2020


public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {

		Locale locale = new Locale("pt", "BR");
		Date data = new Date();
		SimpleDateFormat formatarDate = new SimpleDateFormat("ddMMyyyyHHmmss", locale);
		String date = formatarDate.format(data);

		if (extent == null) {
			extent = new ExtentReports("C:\\Projeto\\Relatorio" + date + ".html", true);

			// optional
			extent.config().documentTitle("Automation Report").reportName("Regression").reportHeadline("");

			// optional
			try {
				extent.addSystemInfo("Selenium Version", "3.141.59").addSystemInfo("Environment","Staging/Homologacao:0.0.0.0").addSystemInfo("IP", InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return extent;
	}

}
