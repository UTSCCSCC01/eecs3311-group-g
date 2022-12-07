/*************************************************
 * FALL 2022
 * EECS 3311 GUI SAMPLE CODE
 * ONLT AS A REFERENCE TO SEE THE USE OF THE jFree FRAMEWORK
 * THE CODE BELOW DOES NOT DEPICT THE DESIGN TO BE FOLLOWED 
 */

package plotter.gui;

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
import javax.swing.JOptionPane;
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
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import Analysis.*;

import dataGetters.CountryIndicator;

public class MainUI2 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static MainUI2 instance;
	public static MainUI2 getInstance() {
		if (instance == null)
			instance = new MainUI2();

		return instance;
	}
     
	public void actionPerformed(ActionEvent e) {
	 
	 String countryName= countriesList.getItemAt(countriesList.getSelectedIndex());
	 String countryIBAN= countryCode.get(countryName);
	 String startYear=fromList.getItemAt(fromList.getSelectedIndex());
	 String endYear= toList.getItemAt(toList.getSelectedIndex());
	 String analysisType = methodsList.getItemAt(methodsList.getSelectedIndex());
	 int analysisSwitch = getKey(methodsNames, analysisType); 
	 int startY= Integer.parseInt(startYear);
	 int endY=Integer.parseInt(endYear);
	 Vector<Double> output = new Vector<Double>();
	 if(startY>endY) {
		    JOptionPane.showMessageDialog(new JFrame(), "Please select year 1 less than year 2", "Dialog", JOptionPane.ERROR_MESSAGE); 
	 }
	 if(analysisType == null) {
		 JOptionPane.showMessageDialog(new JFrame(), "Please select an analysis before recalculating", "Dialog", JOptionPane.ERROR_MESSAGE); 
	 }
	 switch(analysisSwitch) {
	  case 1:
		  output = Acc2ElecVsAcc2Net.performAnalysis(startYear, endYear, countryIBAN);
		  break;
	  case 2:
		  output = accessToSafeWater.performAnalysis(startYear, endYear, countryIBAN);	
		  break;
	  case 3:
		  output = AgriculturalLandVsCarbonEmissions.performAnalysis(startYear, endYear, countryIBAN);	
		  break;
	  case 4:
		  output = CarbonEmVsFFUse.performAnalysis(startYear, endYear, countryIBAN);	
		  break;
	  case 5:
		  output = carbonEmVSSafeH2O.performAnalysis(startYear, endYear, countryIBAN);	
		  break;
	  case 6:
		  output = fossilFuelUsage.performAnalysis(startYear, endYear, countryIBAN);	
		  break;
	  case 7:
		  output = gdpGrowthPerYear.performAnalysis(startYear, endYear, countryIBAN);	
		  break;
	  case 8:
		  output = popDensVsAgricLand.performAnalysis(startYear, endYear, countryIBAN);
		  break;
	  default:
		  JOptionPane.showMessageDialog(new JFrame(), "Error Invalid Analysis", "Dialog", JOptionPane.ERROR_MESSAGE); 
	}
	 if(output.contains(0.0)) {
		  JOptionPane.showMessageDialog(new JFrame(), "Not enough data, please try another analysis or change the dates", "Dialog", JOptionPane.ERROR_MESSAGE); 
	 }
	 DefaultCategoryDataset line_bar_dataset = createLine_and_barChartDataSet(output, startY);
	 XYDataset scatter_time_Dataset = CreatetimesetDataSet(output, startY, analysisType);
	doReport(output,startY,endY, analysisType);
	System.out.println(output);
	JPanel west=new JPanel();
	//createScatter(west, scatter_time_Dataset, analysisType);
	//createTimeS(west,indicator,startY,endY);
	createBar(west, line_bar_dataset, analysisType);
	//createLine(west, line_bar_dataset, analysisType);
	//createB(west,indicator,startY,endY);	
	}
	
	public int getKey(HashMap<Integer, String> map, String name) {
		int keyVal = -1;
		for (int i = 0; i < map.size(); i++) {
			if (name.equals(map.get(i))) {
				keyVal = i;
				return keyVal;
			}
		}
		return keyVal;
	}
	
	private void doReport(Vector<Double> list, int startY, int endY, String name) {
	int j=0;
	String reportmessage= name + "==============================\n" ;
		for(int i=endY;i>=startY;i--) {
			reportmessage = reportmessage + String.format(name,i,list.get(j));
			j++;
		}
	 report.setText(reportmessage);
}
static int k=0;
private List<ChartPanel> panelList=new ArrayList<ChartPanel>();
private List<XYPlot> plotList= new ArrayList<XYPlot>();
  

	Vector<String> countriesNames=new Vector<String>();
	Map<String,String> countryCode=new HashMap<String,String>();
	JComboBox<String> countriesList = new JComboBox<String>(countriesNames);
	Vector<String> years = new Vector<String>();
	JComboBox<String> fromList = new JComboBox<String>(years);
	JComboBox<String> methodsList = new JComboBox<String>();
	JComboBox<String> toList = new JComboBox<String>(years);
	HashMap<Integer, String> methodsNames = new HashMap<Integer, String>();
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

		//Vector<String> methodsNames = new Vector<String>();
		methodsNames.put(1,"Access to Electricity vs Access to Internet");
		methodsNames.put(2,"Access to safe drinking water");
		methodsNames.put(3,"Agricultural land vs carbon emissions");
		methodsNames.put(4,"Carbon emissions vs Fossil Fuel Usage");
		methodsNames.put(5,"Carbon emissions vs safe drinking water");
		methodsNames.put(6,"Fossil Fuel Usage");
		methodsNames.put(7,"GDP growth per year");
		methodsNames.put(8,"Pupulation Density vs Agricultural land percentage");
		
		for (int i = 0; i < methodsNames.size(); i++) {
			methodsList.addItem(methodsNames.get(i));
		}

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
		//createCharts(west);

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);
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

	private void createScatter(JPanel west, XYDataset dataset, String name) {

		XYPlot plot = new XYPlot();
		XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);

		plot.setDataset(0, dataset);
		plot.setRenderer(0, itemrenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.mapDatasetToRangeAxis(0, 0);
		JFreeChart scatterChart = new JFreeChart(name ,new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		ChartPanel chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}


	private static int count=0;
	private static int count1=0;//define another counter
	private CategoryPlot[] p=new CategoryPlot[1];
	

private void createBar(JPanel west, DefaultCategoryDataset dataBar, String name) {
		
	
		CategoryPlot plot = new CategoryPlot();
		BarRenderer barrenderer1 = new BarRenderer();

		plot.setDataset(0, dataBar);
		plot.setRenderer(0, barrenderer1);
		CategoryAxis domainAxis = new CategoryAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(name));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis

		JFreeChart barChart = new JFreeChart(name,new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		// Different way to create bar chart
		/*
		 * dataset = new DefaultCategoryDataset();
		 * 
		 * dataset.addValue(3.946, "Unemployed", "Men"); dataset.addValue(96.054,
		 * "Employed", "Men"); dataset.addValue(3.837, "Unemployed", "Women");
		 * dataset.addValue(96.163, "Employed", "Women"); barChart =
		 * ChartFactory.createBarChart("Unemployment: Men vs Women", "Gender",
		 * "Percentage", dataset, PlotOrientation.VERTICAL, true, true, false);
		 */

		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}

public DefaultCategoryDataset  createLine_and_barChartDataSet(Vector<Double> list, int year) {
			DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
			for(int i = 0; i < list.size(); i++) {
				dataset.addValue(list.get(i), "data", Integer.toString(year+i));
			}
		return dataset;
	}
	
public XYDataset  CreatetimesetDataSet(Vector<Double> list, int year, String name) {
	XYSeries  dataset = new XYSeries (name);
		for(int i = 0; i < list.size(); i++) {
			dataset.add((double)(year + i), (double) list.get(i));
		}
		XYSeriesCollection XYdataset = new XYSeriesCollection( );          
	      XYdataset.addSeries(dataset);          
	return XYdataset;
	}
	
private void createLine(JPanel west, DefaultCategoryDataset dataLine, String name) {
		JFreeChart chart = ChartFactory.createLineChart(name, "Year", "", dataLine, PlotOrientation.VERTICAL, true, true, false);
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
				new TextTitle(name, new Font("Serif", java.awt.Font.BOLD, 18)));
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}

private void createTimeSeries(JPanel west, XYDataset dataset, String name) {
		
		XYPlot plot = new XYPlot();
		XYSplineRenderer splinerenderer1 = new XYSplineRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, splinerenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));



		plot.mapDatasetToRangeAxis(0, 0);
		plot.mapDatasetToRangeAxis(1, 1); 

		JFreeChart chart = new JFreeChart(name, new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

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
