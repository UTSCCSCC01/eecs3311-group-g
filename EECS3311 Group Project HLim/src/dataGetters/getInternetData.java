package dataGetters;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.jfree.data.json.impl.JSONArray;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;


public class getInternetData extends baseDataGetter{
	String urlP1 = "http://api.worldbank.org/v2/country/";
	String countryCode;
	String urlP3 = "/indicator/IT.NET.USER.ZS?date=";
	String urlP4;
	String urlP5;
	String urlP6 = "&format=json";
	private String finalUrl;
	public Vector<Double> dataRetrievedList;

	
	public String setFinalUrl() {
		this.finalUrl = urlP1 + this.countryCode + urlP3 + this.urlP4 + ":" + this.urlP5 + urlP6;
		return finalUrl;
	}
	public void setCC(String c) {
		this.countryCode = c;
	}
	public void setY1(String y1) {
		this.urlP4 = y1;
	}
	public void setY2(String y2) {
		this.urlP5 = y2;
	}
	public String getFinalURL() {
		String output = this.finalUrl;
		return output;
	}
	@Override
	public Vector<Double> getData(String finalUrl) {
		
		String urlString = finalUrl;
		double landPerArea=0.0;
	int landPerYear=0;
	double cumuPerYear=0.0;
	String cumu= "";
		try {
			URL url=new URL(urlString);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			//if response code is 200, then ok
			int responseCode=200;
			if(conn.getResponseCode()==responseCode) {
			 Scanner sc= new Scanner(url.openStream());
			 String inline="";
			 while(sc.hasNextLine())
			inline+= sc.nextLine();
			 sc.close();
			//Process the JsonArray as one line
			 JsonArray jsonArray =new JsonParser().parse(inline).getAsJsonArray();
			int size=jsonArray.size();
			//get the size of results
			int sizeofResults=jsonArray.get(1).getAsJsonArray().size();
			if(Integer.parseInt(this.urlP4)<Integer.parseInt(this.urlP5))
			for(int i=0;i<sizeofResults;i++) {
				landPerYear= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
				
				boolean correct= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull();
				if(correct) 
					landPerArea=0.0;
				else
				landPerArea= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();
				this.dataRetrievedList.add(landPerArea);
				//System.out.printf("Land per Area is %.2f for the year %d\n", landPerArea, landPerYear);
		 cumu= cumu+String.format("Percent of people able to access the interner %.2f for the year %d\n", landPerArea, landPerYear);
				cumuPerYear=cumuPerYear+landPerArea;
			}
			//System.out.println("size of results is  "+sizeofResults);
			cumu=cumu+String.format("Average percent of people with accesss to the internet %.2f\n",cumuPerYear/sizeofResults);
			//System.out.printf("Average land per Area is %.2f", cumuPerYear/sizeofResults);
		}
		}
		catch(IOException e) {
			// excception is catched if something goes wrong
		}
		return dataRetrievedList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getInternetData dataFetch = new getInternetData();
		dataFetch.setCC("can");
		dataFetch.setY1("2006");
		dataFetch.setY2("2012");
		dataFetch.setFinalUrl();
		
		dataFetch.dataRetrievedList = new Vector<Double>();
		
		System.out.println(dataFetch.finalUrl);
		System.out.println(dataFetch.getData(dataFetch.finalUrl));
		
	}

}
