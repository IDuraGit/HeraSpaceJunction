package heraSpaceCoreAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeraSpaceDataCrosser
 */
public class HeraSpaceDataCrosser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HeraSpaceDataCrosser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	boolean showRoute = false;
	boolean notAuth = false;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// At the moment for Ultrahack it read the regulationsData from a local
		// file
		// In the real prototype it will connect an API from administration
		// using the Blockchain
		
		


		getDataRegulations();

		// At the moment for Ultrahack it read the regulationsData from a local
		// file
		// In the real prototype it will connect an API from domain data expert.

		getSeaFoodPref();

		// At the moment for Ultrahack it read the regulationsData from a local
		// file
		// In the real prototype it will connect an API from ESA using OData
		// In this mock there are already an implemented OData connection based
		// of an already existing Maven based Olingo.org example.

		getSentinelSatelliteProductsUUI();

		// ReadData Regulations file Blockchain
		// ReadData seaFood file
		// ReadData Satellite file

		// Write three methods for reading-Done

		// Write one method with that three parameters

		// match the temperature of the fish type with the one coming form the
		// satellite (NRT), and other variables applicable to the
		// tuna octopus, and schrimp //Every fish type likes different things

		String fishType = request.getParameter("fishType");

		dataCrosser(getSeaFoodPref(), getDataRegulations(),
				getSentinelSatelliteProductsUUI(), fishType);

		System.out.print(request.getParameter("fishType"));

		toCharacterArray(request.getParameter("fishType"));

		// Show in the front end coordinates and a picture of a boat, that is
		// the best route to follow available, but if a parameter from the water
		// changes the route is dynamically adapted.

		// It synchronize the whole fishing industry, adding transparency
		// figting piracy

		if (showRoute == true) {

			response.sendRedirect("index1.html");
		}

		if (notAuth == true) {
			showRoute = false;
			response.sendRedirect("index2.html");
		}

	}

	
	private String dataCrosser(String dataPref, String dataReg, String dataSat,
			String fishType) {

		String crossedOutput = "";

		for (int i = 0; i < dataPref.length(); i++) {

			if (dataPref.contains(fishType) && dataReg.contains("allowed")
					&& dataSat.contains("S3A_SR_2_WAT")) {

				showRoute = true;

			} else {
				showRoute = false;
				notAuth = true;

			}

		}

		System.out.println(dataPref);

		return crossedOutput;
	}

	public Character[] toCharacterArray(String s) {

		if (s == null) {
			return null;
		}

		int len = s.length();
		Character[] array = new Character[len];
		for (int i = 0; i < len; i++) {
			array[i] = new Character(s.charAt(i));
		}

		return array;
	}

	public String getSentinelSatelliteProductsUUI() throws IOException {

		BufferedReader br = new BufferedReader(
				new FileReader(
						"C:\\heraSpacePrototype\\my-car-service\\src\\SentinelSatelliteProductsUUID.txt"));

		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			return everything;
		} finally {
			br.close();
		}

	}

	public String getDataRegulations() throws IOException {

		BufferedReader br = new BufferedReader(
				new FileReader(
						"C:\\heraSpacePrototype\\my-car-service\\src\\dataRegulations.txt"));

		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			return everything;
		} finally {
			br.close();
		}

	}

	public String getSeaFoodPref() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(
				"C:\\heraSpacePrototype\\my-car-service\\src\\seaFoodPref.txt"));

		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			System.out.println(line);
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			System.out.println("everything" + everything);
			return everything;
		} finally {
			br.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
