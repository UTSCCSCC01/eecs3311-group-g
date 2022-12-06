package dataGetters;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class getFFUseDataTest {

	@Test
	public void testSetCC() {
		String expected = "can";
		getFFUseData FosFuel = new getFFUseData();
		FosFuel.setCC(expected);
		assertEquals(expected, FosFuel.countryCode);
	}

	@Test
	public void testSetY1() {
		String expected = "1999";
		getFFUseData FosFuel = new getFFUseData();
		FosFuel.setY1(expected);
		assertEquals(expected, FosFuel.urlP4);
	}

	@Test
	public void testSetY2() {
		String expected = "1999";
		getFFUseData FosFuel = new getFFUseData();
		FosFuel.setY2(expected);
		assertEquals(expected, FosFuel.urlP5);
	}



	@Test
	public void testGetData() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getFFUseData FosFuel = new getFFUseData();
		FosFuel.setCC(cc);
		FosFuel.setY1(y1);
		FosFuel.setY2(y2);
		String test = FosFuel.setFinalUrl();
		FosFuel.dataRetrievedList = new Vector<Double>();
		Vector<Double> results = new Vector<Double>();
		results = FosFuel.getData(test);
		assertEquals(results.size(), (Integer.parseInt(y2) - Integer.parseInt(y1))+1);
	}

	@Test
	public void testSetFinalUrl() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getFFUseData FosFuel = new getFFUseData();
		FosFuel.setCC(cc);
		FosFuel.setY1(y1);
		FosFuel.setY2(y2);
		FosFuel.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/EG.USE.COMM.FO.ZS?date=1999:2004&format=json";
		assertEquals(expected, FosFuel.getFinalURL());
	}	
	
	@Test
	public void testGetFinalURL() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getFFUseData FosFuel = new getFFUseData();
		FosFuel.setCC(cc);
		FosFuel.setY1(y1);
		FosFuel.setY2(y2);
		FosFuel.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/EG.USE.COMM.FO.ZS?date=1999:2004&format=json";
		assertEquals(expected, FosFuel.getFinalURL());
	}


}
