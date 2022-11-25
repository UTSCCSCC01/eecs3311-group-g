/*************************************************
 * FALL 2022
 * EECS 3311 GUI SAMPLE CODE
 * ONLT AS A REFERENCE TO SEE THE USE OF THE jFree FRAMEWORK
 * THE CODE BELOW DOES NOT DEPICT THE DESIGN TO BE FOLLOWED 
 */

package statsVisualiser.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class MainUI2 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MainUI2 instance;
    private static CountryIndicator indicator;
	public static MainUI2 getInstance() {
		if (instance == null)
			instance = new MainUI2();

		return instance;
	}
     
	public void actionPerformed(ActionEvent e) {
	 indicator= new CountryIndicator();
	 //instance=new MainUI2();
	 String countryName= countriesList.getItemAt(countriesList.getSelectedIndex());
	 //System.out.println(countryName);
	 String countryIBAN= countryCode.get(countryName);
	 String startYear=fromList.getItemAt(fromList.getSelectedIndex());//start year in string from
	 String endYear= toList.getItemAt(toList.getSelectedIndex());//end year in string form
	 int startY= Integer.parseInt(startYear);//start year in int form
	 int endY=Integer.parseInt(endYear);//end year in int form
	 if(startY<endY) {
		 indicator.getAgriculturalLand(countryIBAN, startY, endY);
	 indicator.getCarbonExposure(countryIBAN, startY, endY);
	 }
	doReport(indicator,startY,endY);
	//JPanel west=new JPanel();
	createTimeS(west,indicator,startY,endY);
	createB(west,indicator,startY,endY);
	//createLine(west,indicator,startY,endY);
	 // createCharts(this.west,indicator,startY,endY);
	
	}
private void doReport(CountryIndicator indicator, int startY, int endY) {
	 int j=0;
	 String reportmessage="AgriculturallandperArea vs carbon emission \n" + "==============================\n" ;
	 for(int i=endY;i>=startY;i--) {
	reportmessage=reportmessage+String.format("Year %d \n Agricultural Land per Area ->%.2f",i,indicator.agrLandList.get(j))
	        
		 +"%\n"+String.format("Carbon emission per capita -> %.2f\n\n", indicator.carbonEmList.get(j));
		 j++;
	 }

	 report.setText(reportmessage);
}
static int k=0;
private List<ChartPanel> panelList=new ArrayList<ChartPanel>();
private List<XYPlot> plotList= new ArrayList<XYPlot>();
  
private void createTimeS(JPanel west, CountryIndicator indicator, int startY, int endY) {
	TimeSeries series1 = new TimeSeries("Agricultural Land Per Area");
	TimeSeries series2 = new TimeSeries("Carbon Emission per Area");
	int j=0;
	for(int i=startY;i<endY+1;i++) {
		series1.add(new Year(i),indicator.agrLandList.get(j));
		series2.add(new Year(i),indicator.carbonEmList.get(j));
		j++;
	}
	

	TimeSeriesCollection dataset2 = new TimeSeriesCollection();
	dataset2.addSeries(series2);
	dataset2.addSeries(series1);
//
//	TimeSeries series3 = new TimeSeries("Hospital Beds/1000 people");
//	series3.add(new Year(2018), 2.92);
//	series3.add(new Year(2017), 2.87);
//	series3.add(new Year(2016), 2.77);
//	series3.add(new Year(2015), 2.8);
//	series3.add(new Year(2014), 2.83);
//	series3.add(new Year(2013), 2.89);
//	series3.add(new Year(2012), 2.93);
//	series3.add(new Year(2011), 2.97);
//	series3.add(new Year(2010), 3.05);

	TimeSeriesCollection dataset = new TimeSeriesCollection();
	//dataset.addSeries(series1);
	//dataset.addSeries(series2);

	if(k==0) {
	XYPlot plot = new XYPlot();
	
	XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
	XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

	plot.setDataset(0, dataset2);
	plot.setRenderer(0, itemrenderer1);
	DateAxis domainAxis = new DateAxis("Year");
	plot.setDomainAxis(domainAxis);
	plot.setRangeAxis(new NumberAxis(""));

//	plot.setDataset(1, dataset2);
//	plot.setRenderer(1, itemrenderer2);
//	plot.setRangeAxis(1, new NumberAxis("US$"));

	plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
	//plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

	JFreeChart scatterChart = new JFreeChart("Agricultural Land Per Area vs Carbon Emission Per Area",
			new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
     
	//if(j==0)
	ChartPanel chartPanel = new ChartPanel(scatterChart);
    plotList.add(plot);panelList.add(chartPanel);
	chartPanel.setPreferredSize(new Dimension(400, 300));
	chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	chartPanel.setBackground(Color.white);
	west.add(chartPanel);
	k++;
}
	else{
		XYPlot plot=plotList.get(0);
		plot.setDataset(0, dataset2);
JFreeChart scatterChart = new JFreeChart("Agricultural Land Per Area vs Carbon Emission Per Area",
		new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
         ChartPanel panel=panelList.get(0);
         panel=new ChartPanel(scatterChart);
       //  System.out.println(panel.equals(panelList.get(0)));
        panel.setPreferredSize(new Dimension(400, 300));
     	panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
     	panel.setBackground(Color.white);
       west.add(panel);
       west.remove(panelList.get(0));
       panelList.set(0, panel);
       
	}
}
	Vector<String> countriesNames=new Vector<String>();
Map<String,String> countryCode=new HashMap<String,String>();
JComboBox<String> countriesList = new JComboBox<String>(countriesNames);
Vector<String> years = new Vector<String>();
JComboBox<String> fromList = new JComboBox<String>(years);
JComboBox<String> toList = new JComboBox<String>(years);
JPanel west = new JPanel();
	private MainUI2() {
		// Set window title
		super("Country Statistics");
  //indicator= new CountryIndicator();
		// Set top bar
		JLabel chooseCountryLabel = new JLabel("Choose a country: ");
		
//		Vector<String> countriesNames=new Vector<String>();
//		Map<String,String> countryCode=new HashMap<String,String>();
//		JComboBox<String> countriesList = new JComboBox<String>(countriesNames);
//		Vector<String> years = new Vector<String>();
//		JComboBox<String> fromList = new JComboBox<String>(years);
//		JComboBox<String> toList = new JComboBox<String>(years);
		 
		//Vector<String> countriesNames = new Vector<String>();
		//Vector<String> countriesNames=new Vector<String>();
		//Map<String,String> countryCode=new HashMap<String,String>();
		countryCode.put( "USA","usa");
		countryCode.put("Canada","usa");
		countryCode.put("France","fra");
		countryCode.put("China","chn");
		countryCode.put("Brazil","bra");
		countriesNames.add("USA");
		countriesNames.add("Canada");
		countriesNames.add("France");
		countriesNames.add("China");
		countriesNames.add("Brazil");
		countriesNames.sort(null);
		
		//JComboBox<String> countriesList = new JComboBox<String>(countriesNames);

		JLabel from = new JLabel("From");
		JLabel to = new JLabel("To");
		//Vector<String> years = new Vector<String>();
		for (int i = 2021; i >= 2010; i--) {
			years.add("" + i);
		}
//		JComboBox<String> fromList = new JComboBox<String>(years);
//		JComboBox<String> toList = new JComboBox<String>(years);

		JPanel north = new JPanel();
		north.add(chooseCountryLabel);
		north.add(countriesList);
		north.add(from);
		north.add(fromList);
		north.add(to);
		north.add(toList);

		// Set bottom bar
		JButton recalculate = new JButton("Recalculate");
         recalculate.addActionListener(this);
		JLabel viewsLabel = new JLabel("Available Views: ");

		Vector<String> viewsNames = new Vector<String>();
		viewsNames.add("Pie Chart");
		viewsNames.add("Line Chart");
		viewsNames.add("Bar Chart");
		viewsNames.add("Scatter Chart");
		viewsNames.add("Report");
		JComboBox<String> viewsList = new JComboBox<String>(viewsNames);
		JButton addView = new JButton("+");
		JButton removeView = new JButton("-");
        addView.addActionListener(this);
        removeView.addActionListener(this);
		JLabel methodLabel = new JLabel("        Choose analysis method: ");

		Vector<String> methodsNames = new Vector<String>();
		//methodsNames.add("Mortality");
		//methodsNames.add("Agricultural Land Per Area vs carbon emission");
		//methodsNames.add("Mortality vs Expenses & Hospital Beds");
		methodsNames.add("Mortality vs GDP");
		methodsNames.add("Population density vs GDP Growth vs safety drinking ");
		//methodsNames.add("Unemployment");

		JComboBox<String> methodsList = new JComboBox<String>(methodsNames);

		JPanel south = new JPanel();
		south.add(viewsLabel);
		south.add(viewsList);
		south.add(addView);
		south.add(removeView);

		south.add(methodLabel);
		south.add(methodsList);
		south.add(recalculate);

		JPanel east = new JPanel();
      //  indicator=new CountryIndicator();
		// Set charts region
		//JPanel west = new JPanel();
		west.setLayout(new GridLayout(2, 0));
		createCharts(west);

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);
	}

	private void createCharts(JPanel west) {
	indicator=new CountryIndicator();
	indicator.getAgriculturalLand("can", 2010, 2018);
	indicator.getCarbonExposure("can",2010, 2018);
	doReport(indicator,2010,2018);
	createTimeS(west,indicator,2010,2018);
	createB(west,indicator,2010,2018);
		//createLine(west);
		//createTimeSeries(west);
		//createBar(west);
		//createPie(west);
		//createScatter(west);
		createReport(west);

	}
	JTextArea report = new JTextArea();
	private void createReport(JPanel west) {
		//JTextArea report = new JTextArea();
		report.setEditable(false);
		report.setPreferredSize(new Dimension(400, 300));
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
	
		//String reportMessage, reportMessage2;

//		//reportMessage = "Mortality vs Expenses & Hospital Beds\n" + "==============================\n" + "Year 2018:\n"
//				+ "\tMortality/1000 births => 5.6\n" + "\tHealth Expenditure per Capita => 10624\n"
//				+ "\tHospital Beds/1000 people => 2.92\n" + "\n" + "Year 2017:\n" + "\tMortality/1000 births => 5.7\n"
//				+ "\tHealth Expenditure per Capita => 10209\n" + "\tHospital Beds/1000 people => 2.87\n" + "\n"
//				+ "Year 2016:\n" + "\tMortality/1000 births => 5.8\n" + "\tHealth Expenditure per Capita => 9877\n"
//				+ "\tHospital Beds/1000 people => 2.77\n";
//
//		reportMessage2 = "Unemployment: Mev vs Women\n" + "==========================\n" + "Men=>\n"
//				+ "\tEmployed: 96.054%\n" + "\tUnemployed: 3.946%\n" + "\n" + "Women=>\n" + "\tEmployed: 96.163%\n"
//				+ "\tUnemployed: 3.837%\n";

		//report.setText(reportMessage);
		JScrollPane outputScrollPane = new JScrollPane(report);
		west.add(outputScrollPane);
	}

//	private void createScatter(JPanel west) {
//		TimeSeries series1 = new TimeSeries("Agricultural Land Per Area");
//		series1.add(new Year(2018), 5.6);
//		series1.add(new Year(2017), 5.7);
//		series1.add(new Year(2016), 5.8);
//		series1.add(new Year(2015), 5.8);
//		series1.add(new Year(2014), 5.9);
//		series1.add(new Year(2013), 6.0);
//		series1.add(new Year(2012), 6.1);
//		series1.add(new Year(2011), 6.2);
//		series1.add(new Year(2010), 6.4);
//
//		TimeSeries series2 = new TimeSeries("Health Expenditure per Capita");
//		series2.add(new Year(2018), 10624);
//		series2.add(new Year(2017), 10209);
//		series2.add(new Year(2016), 9877);
//		series2.add(new Year(2015), 9491);
//		series2.add(new Year(2014), 9023);
//		series2.add(new Year(2013), 8599);
//		series2.add(new Year(2012), 8399);
//		series2.add(new Year(2011), 8130);
//		series2.add(new Year(2010), 7930);
//		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
//		dataset2.addSeries(series2);
//
//		TimeSeries series3 = new TimeSeries("Hospital Beds/1000 people");
//		series3.add(new Year(2018), 2.92);
//		series3.add(new Year(2017), 2.87);
//		series3.add(new Year(2016), 2.77);
//		series3.add(new Year(2015), 2.8);
//		series3.add(new Year(2014), 2.83);
//		series3.add(new Year(2013), 2.89);
//		series3.add(new Year(2012), 2.93);
//		series3.add(new Year(2011), 2.97);
//		series3.add(new Year(2010), 3.05);
//
//		TimeSeriesCollection dataset = new TimeSeriesCollection();
//		dataset.addSeries(series1);
//		dataset.addSeries(series3);
//
//		XYPlot plot = new XYPlot();
//		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
//		XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);
//
//		plot.setDataset(0, dataset);
//		plot.setRenderer(0, itemrenderer1);
//		DateAxis domainAxis = new DateAxis("Year");
//		plot.setDomainAxis(domainAxis);
//		plot.setRangeAxis(new NumberAxis(""));
//
//		plot.setDataset(1, dataset2);
//		plot.setRenderer(1, itemrenderer2);
//		plot.setRangeAxis(1, new NumberAxis("US$"));
//
//		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
//		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis
//
//		JFreeChart scatterChart = new JFreeChart("Mortality vs Expenses & Hospital Beds",
//				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
//
//		ChartPanel chartPanel = new ChartPanel(scatterChart);
//		chartPanel.setPreferredSize(new Dimension(400, 300));
//		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
//		chartPanel.setBackground(Color.white);
//		west.add(chartPanel);
//	}

//	private void createPie(JPanel west) {
//		// Different way to create pie chart
//		/*
//		 * var dataset = new DefaultPieDataset(); dataset.setValue("Unemployed", 3.837);
//		 * dataset.setValue("Employed", 96.163);
//		 * 
//		 * JFreeChart pieChart = ChartFactory.createPieChart("Women's Unemployment",
//		 * dataset, true, true, false);
//		 */
//
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		dataset.addValue(3.946, "Unemployed", "Men");
//		dataset.addValue(96.054, "Employed", "Men");
//		dataset.addValue(3.837, "Unemployed", "Women");
//		dataset.addValue(96.163, "Employed", "Women");
//
//		JFreeChart pieChart = ChartFactory.createMultiplePieChart("Unemployment: Men vs Women", dataset,
//				TableOrder.BY_COLUMN, true, true, false);
//
//		ChartPanel chartPanel = new ChartPanel(pieChart);
//		chartPanel.setPreferredSize(new Dimension(400, 300));
//		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
//		chartPanel.setBackground(Color.white);
//		west.add(chartPanel);
//	}
	private static int count=0;
	private static int count1=0;//define another counter
	private CategoryPlot[] p=new CategoryPlot[1];
	
private void createB(JPanel west,CountryIndicator indicator, int startY, int endY) {
	DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	DefaultCategoryDataset dataset2 = new DefaultCategoryDataset(); 
	int j=0;
	for(int i=endY;i>startY;i--) {
		String value=String.valueOf(i);
		dataset.setValue(indicator.agrLandList.get(j), "AgricutlturalLandPerArea",value);
	dataset2.setValue(indicator.carbonEmList.get(j), "Carbon Emission Per Area",value);
		j++;
	}

	CategoryPlot plot=new CategoryPlot();
	BarRenderer b1=new BarRenderer();
	BarRenderer b2=new BarRenderer();
	if(count==0) {
	
	plot.setDataset(0, dataset);
	plot.setRenderer(0, b1);
	CategoryAxis domainAxis = new CategoryAxis("Year");
	plot.setDomainAxis(domainAxis);
	plot.setRangeAxis(new NumberAxis(""));
	plot.setDataset(1, dataset2);
	plot.setRenderer(1, b2);
	
    plot.setRangeAxis(1,new NumberAxis("%percentage"));
    plot.mapDatasetToRangeAxis(0, 0);
    plot.mapDatasetToRangeAxis(1, 1);
	JFreeChart barChart = new JFreeChart("Agricultural Land PerArea vs Carbon Emission perArea",
			new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
	p[0]=plot;
	ChartPanel chartPanel = new ChartPanel(barChart);
	panelList.add(chartPanel);//System.out.println("size of panelList "+panelList.size());
	chartPanel.setPreferredSize(new Dimension(400, 300));
	chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	chartPanel.setBackground(Color.white);
	west.add(chartPanel);
	count++;
	}
	else {
		CategoryPlot newPlot=p[0];
		newPlot.setDataset(0, dataset);
		newPlot.setRenderer(0, b1);
		newPlot.setDataset(1, dataset2);
		newPlot.setRenderer(1, b2);
		JFreeChart barChart = new JFreeChart("Agricultural Land PerArea vs Carbon Emission perArea",
				new Font("Serif", java.awt.Font.BOLD, 18), newPlot, true);
		ChartPanel panel= panelList.get(1);
		panel=new ChartPanel(barChart);
		panel.setPreferredSize(new Dimension(400, 300));
		panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		panel.setBackground(Color.white);
		west.add(panel);
		west.remove(panelList.get(1));
		
		panelList.set(1, panel);
		
		
	}
}
//	private void createBar(JPanel west) {
//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		dataset.setValue(5.6, "Mortality/1000 births", "2018");
//		dataset.setValue(5.7, "Mortality/1000 births", "2017");
//		dataset.setValue(5.8, "Mortality/1000 births", "2016");
//		dataset.setValue(5.8, "Mortality/1000 births", "2015");
//		dataset.setValue(5.9, "Mortality/1000 births", "2014");
//		dataset.setValue(6, "Mortality/1000 births", "2013");
//		dataset.setValue(6.1, "Mortality/1000 births", "2012");
//		dataset.setValue(6.2, "Mortality/1000 births", "2011");
//		dataset.setValue(6.4, "Mortality/1000 births", "2010");
//
//		dataset.setValue(2.92, "Hospital beds/1000 people", "2018");
//		dataset.setValue(2.87, "Hospital beds/1000 people", "2017");
//		dataset.setValue(2.77, "Hospital beds/1000 people", "2016");
//		dataset.setValue(2.8, "Hospital beds/1000 people", "2015");
//		dataset.setValue(2.83, "Hospital beds/1000 people", "2014");
//		dataset.setValue(2.89, "Hospital beds/1000 people", "2013");
//		dataset.setValue(2.93, "Hospital beds/1000 people", "2012");
//		dataset.setValue(2.97, "Hospital beds/1000 people", "2011");
//		dataset.setValue(3.05, "Hospital beds/1000 people", "2010");
//
//		DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
//
//		dataset2.setValue(10623, "Health Expenditure per Capita", "2018");
//		dataset2.setValue(10209, "Health Expenditure per Capita", "2017");
//		dataset2.setValue(9877, "Health Expenditure per Capita", "2016");
//		dataset2.setValue(9491, "Health Expenditure per Capita", "2015");
//		dataset2.setValue(9023, "Health Expenditure per Capita", "2014");
//		dataset2.setValue(8599, "Health Expenditure per Capita", "2013");
//		dataset2.setValue(8399, "Health Expenditure per Capita", "2012");
//		dataset2.setValue(8130, "Health Expenditure per Capita", "2011");
//		dataset2.setValue(7930, "Health Expenditure per Capita", "2010");
//
//		CategoryPlot plot = new CategoryPlot();
//		BarRenderer barrenderer1 = new BarRenderer();
//		BarRenderer barrenderer2 = new BarRenderer();
//
//		plot.setDataset(0, dataset);
//		plot.setRenderer(0, barrenderer1);
//		CategoryAxis domainAxis = new CategoryAxis("Year");
//		plot.setDomainAxis(domainAxis);
//		plot.setRangeAxis(new NumberAxis(""));
//
//		plot.setDataset(1, dataset2);
//		plot.setRenderer(1, barrenderer2);
//		plot.setRangeAxis(1, new NumberAxis("US$"));
//
//		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
//		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis
//
//		JFreeChart barChart = new JFreeChart("Mortality vs Expenses & Hospital Beds",
//				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
//
//		// Different way to create bar chart
//		/*
//		 * dataset = new DefaultCategoryDataset();
//		 * 
//		 * dataset.addValue(3.946, "Unemployed", "Men"); dataset.addValue(96.054,
//		 * "Employed", "Men"); dataset.addValue(3.837, "Unemployed", "Women");
//		 * dataset.addValue(96.163, "Employed", "Women"); barChart =
//		 * ChartFactory.createBarChart("Unemployment: Men vs Women", "Gender",
//		 * "Percentage", dataset, PlotOrientation.VERTICAL, true, true, false);
//		 */
//
//		ChartPanel chartPanel = new ChartPanel(barChart);
//		chartPanel.setPreferredSize(new Dimension(400, 300));
//		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
//		chartPanel.setBackground(Color.white);
//		west.add(chartPanel);
//	}
private void createLine(JPanel west, CountryIndicator indicator, int startY, int endY) {
	XYSeries series1 = new XYSeries("AgriculturalLandPerArea");
	XYSeries series2 = new XYSeries("CArbon Emission PerArea"); int j=0;
	for(int i=endY;i>=startY;i--) {
		series1.add(startY,indicator.agrLandList.get(j));
		series2.add(startY,indicator.carbonEmList.get(j));
		j++;
	}
	XYSeriesCollection dataset = new XYSeriesCollection();
	dataset.addSeries(series1); dataset.addSeries(series2);
	JFreeChart chart = ChartFactory.createXYLineChart("AgriculturalLandPerArea vs carbonEmission", "Year", "", dataset,
			PlotOrientation.VERTICAL, true, true, false);
XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

	  XYPlot plot = chart.getXYPlot();



	
	renderer.setSeriesPaint(0, Color.RED);
	renderer.setSeriesStroke(0, new BasicStroke(2.0f));

	plot.setRenderer(renderer);
	plot.setBackgroundPaint(Color.white);

	plot.setRangeGridlinesVisible(true);
	plot.setRangeGridlinePaint(Color.BLACK);

	plot.setDomainGridlinesVisible(true);
	plot.setDomainGridlinePaint(Color.BLACK);

	chart.getLegend().setFrame(BlockBorder.NONE);

	chart.setTitle(
			new TextTitle("AgriculturalLandPerArea vs CarbonEmission", new Font("Serif", java.awt.Font.BOLD, 18)));

	ChartPanel chartPanel = new ChartPanel(chart);
	chartPanel.setPreferredSize(new Dimension(400, 300));
	chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	chartPanel.setBackground(Color.white);
	west.add(chartPanel);
	if(count1==0) {
	panelList.add(chartPanel);
	count1++;
	}
	else {
		west.remove(panelList.get(2));
		panelList.set(2, chartPanel);
	}
}
	private void createLine(JPanel west) {
		XYSeries series1 = new XYSeries("Mortality/1000 births");
		series1.add(2018, 5.6);
		series1.add(2017, 5.7);
		series1.add(2016, 5.8);
		series1.add(2015, 5.8);
		series1.add(2014, 5.9);
		series1.add(2013, 6.0);
		series1.add(2012, 6.1);
		series1.add(2011, 6.2);
		series1.add(2010, 6.4);

		XYSeries series2 = new XYSeries("Health Expenditure per Capita");
		series2.add(2018, 10624);
		series2.add(2017, 10209);
		series2.add(2016, 9877);
		series2.add(2015, 9491);
		series2.add(2014, 9023);
		series2.add(2013, 8599);
		series2.add(2012, 8399);
		series2.add(2011, 8130);
		series2.add(2010, 7930);

		XYSeries series3 = new XYSeries("Hospital Beds/1000 people");
		series3.add(2018, 2.92);
		series3.add(2017, 2.87);
		series3.add(2016, 2.77);
		series3.add(2015, 2.8);
		series3.add(2014, 2.83);
		series3.add(2013, 2.89);
		series3.add(2012, 2.93);
		series3.add(2011, 2.97);
		series3.add(2010, 3.05);

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);

		JFreeChart chart = ChartFactory.createXYLineChart("Mortality vs Expenses & Hospital Beds", "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(
				new TextTitle("Mortality vs Expenses & Hospital Beds", new Font("Serif", java.awt.Font.BOLD, 18)));

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);

	}

	private void createTimeSeries(JPanel west) {
		TimeSeries series1 = new TimeSeries("Mortality/1000 births");
		series1.add(new Year(2018), 5.6);
		series1.add(new Year(2017), 5.7);
		series1.add(new Year(2016), 5.8);
		series1.add(new Year(2015), 5.8);
		series1.add(new Year(2014), 5.9);
		series1.add(new Year(2013), 6.0);
		series1.add(new Year(2012), 6.1);
		series1.add(new Year(2011), 6.2);
		series1.add(new Year(2010), 6.4);

		TimeSeries series2 = new TimeSeries("Health Expenditure per Capita");
		series2.add(new Year(2018), 10624);
		series2.add(new Year(2017), 10209);
		series2.add(new Year(2016), 9877);
		series2.add(new Year(2015), 9491);
		series2.add(new Year(2014), 9023);
		series2.add(new Year(2013), 8599);
		series2.add(new Year(2012), 8399);
		series2.add(new Year(2011), 8130);
		series2.add(new Year(2010), 7930);
		TimeSeriesCollection dataset2 = new TimeSeriesCollection();
		dataset2.addSeries(series2);

		TimeSeries series3 = new TimeSeries("Hospital Beds/1000 people");
		series3.add(new Year(2018), 2.92);
		series3.add(new Year(2017), 2.87);
		series3.add(new Year(2016), 2.77);
		series3.add(new Year(2015), 2.8);
		series3.add(new Year(2014), 2.83);
		series3.add(new Year(2013), 2.89);
		series3.add(new Year(2012), 2.93);
		series3.add(new Year(2011), 2.97);
		series3.add(new Year(2010), 3.05);

		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series3);

		XYPlot plot = new XYPlot();
		XYSplineRenderer splinerenderer1 = new XYSplineRenderer();
		XYSplineRenderer splinerenderer2 = new XYSplineRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, splinerenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.setDataset(1, dataset2);
		plot.setRenderer(1, splinerenderer2);
		plot.setRangeAxis(1, new NumberAxis("US$"));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart chart = new JFreeChart("Mortality vs Expenses & Hospital Beds",
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);

	}

	public static void main(String[] args) {

		JFrame frame = MainUI2.getInstance();
		frame.setSize(900, 600);
		frame.pack();
		frame.setVisible(true);
	}
	// TODO Auto-generated method stub

	

}