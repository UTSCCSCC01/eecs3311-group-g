package Analysis;

import java.util.Vector;
import Analysis.Acc2ElecVsAcc2Net;
import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestCase;
import java.util.*;

import org.junit.Test;

import dataGetters.*;
public class Acc2ElecVsAcc2NetTest extends TestCase {



//Map<String,String> countryCode= new HashMap<String,String>();
//	
//    countryCode.put("can", "Canada");
//	countryCode.put("bra", "Brazil");
//	countryCode.put("chn", "Canada");
//	countryCode.put("can", "Canada");
//	countryCode.put("can", "Canada");

	
	@Test (timeout=30000)
	
	public void test_1() {
	String year1 = "2004";
	String year2 = "2010";
	String CC = "can";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	
	}
	@Test (timeout=30000)
	
	public void test_2() {
	String year1 = "2000";
	String year2 = "2010";
	String CC = "bra";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	
	}
	@Test (timeout=30000)
	public void test_3() {
	String year1 = "2000";
	String year2 = "2019";
	String CC = "chn";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_4() {
	String year1 = "2000";
	String year2 = "2014";
	String CC = "chn";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_5() {
	String year1 = "2000";
	String year2 = "2014";
	String CC = "chn";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1);
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_6() {
	String year1 = "2000";
	String year2 = "2009";
	String CC = "fra";
	
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue("String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_7() {
	String year1 = "2000";
	String year2 = "2014";
	String CC = "usa";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_8() {
	String year1 = "2000";
	String year2 = "2014";
	String CC = "chn";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_9() {
	String year1 = "2000";
	String year2 = "2007";
	String CC = "fra";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	
	@Test (timeout=30000)
	public void test_10() {
	String year1 = "2002";
	String year2 = "2016";
	String CC = "fra";
	assertTrue("Year1 is greater than year2 comparing in terms of integer", Integer.parseInt(year2)>=Integer.parseInt(year1));
	assertTrue(" String Length of country abbrievation is not equal to 3 ", CC.length()==3);
	assertTrue("year1 is greater than year2", year1.compareTo(year2)<=1 );
	Acc2ElecVsAcc2Net compareIndic =new Acc2ElecVsAcc2Net();
	Vector<Double> dataList= compareIndic.performAnalysis(year1, year2, CC);
	int size= Integer.parseInt(year2)-Integer.parseInt(year1)+1;
	assertEquals("Sizes are not equal", size, dataList.size());
	}
	

}
