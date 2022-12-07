package dataGetters;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class getDataAgricultureTest {

	@Test
	public void testSetCC() {
		String expected = "can";
		getDataAgriculture agr = new getDataAgriculture();
		agr.setCC(expected);
		assertEquals(expected, agr.countryCode);
	}

	@Test
	public void testSetY1() {
		String expected = "1999";
		getDataAgriculture agr = new getDataAgriculture();
		agr.setY1(expected);
		assertEquals(expected, agr.urlP4);
	}

	@Test
	public void testSetY2() {
		String expected = "1999";
		getDataAgriculture agr = new getDataAgriculture();
		agr.setY2(expected);
		assertEquals(expected, agr.urlP5);
	}



	@Test
	public void testGetData() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataAgriculture agr = new getDataAgriculture();
		agr.setCC(cc);
		agr.setY1(y1);
		agr.setY2(y2);
		String test = agr.setFinalUrl();
		agr.dataRetrievedList = new Vector<Double>();
		Vector<Double> results = new Vector<Double>();
		results = agr.getData(test);
		assertEquals(results.size(), (Integer.parseInt(y2) - Integer.parseInt(y1))+1);
	}

	@Test
	public void testSetFinalUrl() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataAgriculture agr = new getDataAgriculture();
		agr.setCC(cc);
		agr.setY1(y1);
		agr.setY2(y2);
		agr.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/AG.LND.AGRI.ZS?date=1999:2004&format=json";
		assertEquals(expected, agr.getFinalURL());
	}	
	
	@Test
	public void testGetFinalURL() {
		String cc = "can";
		String y1 ="1999";
		String y2 = "2004";
		getDataAgriculture agr = new getDataAgriculture();
		agr.setCC(cc);
		agr.setY1(y1);
		agr.setY2(y2);
		agr.setFinalUrl();
		String expected = "http://api.worldbank.org/v2/country/can/indicator/AG.LND.AGRI.ZS?date=1999:2004&format=json";
		assertEquals(expected, agr.getFinalURL());
	}




}
