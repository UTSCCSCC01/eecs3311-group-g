package dataGetters;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class getElectricityAcceDataTest {

	@Test
	public void testSetCC() {
		String expected = "can";
		getElectricityAcceData elec = new getElectricityAcceData();
		elec.setCC(expected);
		assertEquals(expected, elec.countryCode);
	}

	@Test
	public void testSetY1() {
		String expected = "1999";
		getElectricityAcceData elec = new getElectricityAcceData();
		elec.setY1(expected);
		assertEquals(expected, elec.urlP4);
	}

	@Test
	public void testSetY2() {
		String expected = "1999";
		getElectricityAcceData elec = new getElectricityAcceData();
		elec.setY2(expected);
		assertEquals(expected, elec.urlP5);
	}



	@Test
	public void testGetData() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getElectricityAcceData elec = new getElectricityAcceData();
		elec.setCC(cc);
		elec.setY1(y1);
		elec.setY2(y2);
		String test = elec.setFinalUrl();
		elec.dataRetrievedList = new Vector<Double>();
		Vector<Double> results = new Vector<Double>();
		results = elec.getData(test);
		assertEquals(results.size(), (Integer.parseInt(y2) - Integer.parseInt(y1))+1);
	}

	@Test
	public void testSetFinalUrl() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getElectricityAcceData elec = new getElectricityAcceData();
		elec.setCC(cc);
		elec.setY1(y1);
		elec.setY2(y2);
		elec.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/EG.ELC.ACCS.ZS?date=1999:2004&format=json";
		assertEquals(expected, elec.getFinalURL());
	}	
	
	@Test
	public void testGetFinalURL() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getElectricityAcceData elec = new getElectricityAcceData();
		elec.setCC(cc);
		elec.setY1(y1);
		elec.setY2(y2);
		elec.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/EG.ELC.ACCS.ZS?date=1999:2004&format=json";
		assertEquals(expected, elec.getFinalURL());
	}

}
