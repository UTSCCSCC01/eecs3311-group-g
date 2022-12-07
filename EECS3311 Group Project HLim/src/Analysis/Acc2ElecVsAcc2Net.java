package Analysis;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import dataGetters.*;

public class Acc2ElecVsAcc2Net implements MethodStrategy{
	//public static perform
	public static Vector<Double> performAnalysis(String y1, String y2, String CC){
		final DecimalFormat dec = new DecimalFormat("0.00");
		int analysis1 = 4;
		int analysis2 = 5;
		
		Vector<Double> analysis = new Vector<Double>();
		Vector<Double> list1;
		Vector<Double> list2;
		
		getElectricityAcceData data1 = (getElectricityAcceData) dataFactory.createdataGetter(analysis1);
		data1.setCC(CC);
		data1.setY1(y1);
		data1.setY2(y2);
		data1.setFinalUrl();
		data1.dataRetrievedList = new Vector<Double>();
		list1 = data1.getData(data1.getFinalURL());
		
		getInternetData data2 = (getInternetData) dataFactory.createdataGetter(analysis2);
		data2.setCC(CC);
		data2.setY1(y1);
		data2.setY2(y2);
		data2.setFinalUrl();
		data2.dataRetrievedList = new Vector<Double>();
		list2 = data2.getData(data2.getFinalURL());

		
		for (int i = 0; i < list1.size(); i++) {
			analysis.add(Double. parseDouble(dec.format(list1.get(i)/list2.get(i))));
		}
		return analysis;
	}
	
	public void methodAnalysis(String y1, String y2, String CC) {
		Acc2ElecVsAcc2Net.performAnalysis(y1, y2, CC);

	}

}
