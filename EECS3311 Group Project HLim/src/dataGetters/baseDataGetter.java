package dataGetters;

import java.util.Vector;

public class baseDataGetter {
	public String urlP1 = "http://api.worldbank.org/v2/country/";
	String countryCode;
	String urlP3;
	String urlP4;
	String urlP5;
	String urlP6 = "&format=json";
	public Vector<Double> dataRetrievedList;
	public String finalUrl;
	public void setCC(String c) {
		this.countryCode = c;
	}
	public void setY1(String y1) {
		this.urlP4 = y1;
	}
	public void setY2(String y2) {
		this.urlP5 = y2;
	}
	public void setDataCode(String code) {
		this.urlP3 = code;
	}
	public String getFinalURL() {
		String output = this.finalUrl;
		return output;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Vector<Double> getData(String s){
		return null;
		
	}
	public String setFinalUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
