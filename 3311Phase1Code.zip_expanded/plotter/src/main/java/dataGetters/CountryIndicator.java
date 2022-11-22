package dataGetters;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import org.jfree.data.json.impl.JSONArray;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
public class CountryIndicator {
Vector<Double> carbonEmList;
Vector<Double> agrLandList;
	public CountryIndicator() {
	carbonEmList=new Vector<Double>();
	agrLandList=new Vector<Double>();
}
	public String getAgriculturalLand(String country, int startYear, int endYear) {
		String urlString = 
		String.format("http://api.worldbank.org/v2/country/%s/indicator/AG.LND.AGRI.ZS?date=%d:%d&format=json", country,startYear,endYear);
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
			if(startYear<endYear)
			for(int i=0;i<sizeofResults;i++) {
				landPerYear= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
				
				boolean correct= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull();
				if(correct) 
					landPerArea=0.0;
				else
				landPerArea= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();
				this.agrLandList.add(landPerArea);
				//System.out.printf("Land per Area is %.2f for the year %d\n", landPerArea, landPerYear);
		 cumu= cumu+String.format("Land per Area is %.2f for the year %d\n", landPerArea, landPerYear);
				cumuPerYear=cumuPerYear+landPerArea;
			}
			//System.out.println("size of results is  "+sizeofResults);
			cumu=cumu+String.format("Average land per Area is %.2f\n",cumuPerYear/sizeofResults);
			//System.out.printf("Average land per Area is %.2f", cumuPerYear/sizeofResults);
		}
		}
		catch(IOException e) {
			// excception is catched if something goes wrong
		}
		return cumu;
	}
	
	public String getCarbonExposure(String country,int startYear,int endYear) {
		String p= "EN.ATM.CO2E.PC";
		String q="EN.ATM.METH.PC";//not working
		String urlString = 
				String.format("http://api.worldbank.org/v2/country/%s/indicator/EN.ATM.CO2E.PC?date=%d:%d&format=json", country,p,startYear,endYear);
		double carbonEmPerYear=0.0;
	int carbonPerYear=0;
	double cumuPerYear=0.0;
	//Vector<Double> carbonEmList=new Vector<Double>();
	//System.out.println("code first execution"); //code first exec
	String cumu= "";
		try {
			URL url=new URL(urlString);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			//if response code is 200, then ok
			int responseCode=200;
			if(conn.getResponseCode()==responseCode) {
				//System.out.println("code second execution");//code second exec
				Scanner sc= new Scanner(url.openStream());
			 String inline="";
			 while(sc.hasNext())
			inline+= sc.nextLine();
			 sc.close();
			//Process the JsonArray as one line
			 JsonArray jsonArray =new JsonParser().parse(inline).getAsJsonArray();
			int size=jsonArray.size();
			//System.out.println(size);
			//get the size of results
			int sizeofResults=jsonArray.get(1).getAsJsonArray().size();
			if(startYear<endYear)
			for(int i=0;i<sizeofResults;i++) {
				carbonPerYear= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
				
				boolean correct= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull();
				if(correct) 
					carbonEmPerYear=0.0;
				else
				carbonEmPerYear= jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();
				this.carbonEmList.add(carbonEmPerYear);
				//System.out.printf("Carbon Emission is %.2f for the year %d\n", carbonEmPerYear, carbonPerYear);
		 cumu= cumu+String.format("Carbon Emission is %.2f for the year %d\n", carbonEmPerYear, carbonPerYear);
				cumuPerYear=cumuPerYear+carbonEmPerYear;
			}
			//System.out.println("size of results is  "+sizeofResults);
			cumu=cumu+String.format("Average Carbon Emission per Area is %.2f\n",cumuPerYear/sizeofResults);
			//System.out.printf("Average Carbon Emission is %.2f", cumuPerYear/sizeofResults);
		}
			else
				System.out.println("Connection failed");
		}
		
			
		catch(IOException e) {
			// excception is catched if something goes wrong
		}
		//return carbonEmList;
		return cumu;
	}
	public static void main(String[] args) {
		CountryIndicator a=new CountryIndicator();
		System.out.println(a.getAgriculturalLand("can", 2000, 2004));
		
		CountryIndicator b=new CountryIndicator();
		System.out.println(a.getCarbonExposure("can", 2005, 2007));
		
	//	a.getCarbonExposure("can", 2000, 2001);
		
	}
}

