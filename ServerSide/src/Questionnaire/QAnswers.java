package Questionnaire;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

public class QAnswers {
	
	private Vector<Question> questionData;
	
	public QAnswers(Vector<Question> qData) {
		super();
		this.questionData = qData;
	}
	
	public String basicAnalysis() {	
		StringBuffer report = new StringBuffer(); 
		for(int i = 0; i < questionData.size(); i++ ) { 
			Question que = questionData.elementAt(i); 

			report.append(que.getQuestion()); 
			String [] answers = que.getAnswers(); 			
			for(int j = 0; j < answers.length; j++ ) { 
				report.append(" "+answers[j]+" - "+ que.getFreq(answers[j])+";");
			}
			report.append(System.lineSeparator()); 
		}
		return report.toString(); 
	}
	
	public ArrayList<String> getBarChartURL() { 
		return getImageFromData(getJSON()); 
	}
	
	public ArrayList<String> getJSON() {
		
		ArrayList<String> arr = new ArrayList<String>();
		String report = "";
		for(int i = 0; i < questionData.size(); i++ ) { 
			report = "{";
			Question q = questionData.elementAt(i);
			//if( i > 0 ) { report += ","; }
			report += "\"" + q.getQuestion() +"\": {"; 

			String [] answers = q.getAnswers(); 			
			for(int j = 0; j < answers.length; j++ ) { 
				if( j > 0 ) { report += ","; } 
				report += "\""+answers[j]+"\" : "+ q.getFreq(answers[j]);
			}
			report += "}}";
			arr.add(report);
		}
		//report += "}";
		//System.out.println(report);
		for(int x=0;x<arr.size();x++) {
			System.out.println( arr.get(x) );
		}
		return arr; 
	}
	
	private ArrayList<String> getImageFromData(ArrayList<String> arr) {
		ArrayList<String> urls = new ArrayList<String>();
		String what ="";
		for(int i=0; i<arr.size(); i++) {
			what = arr.get(i).toString();
		try {
			String url = "http://uob.perisic.com/uob/analysis.php";
			URL obj;

			obj = new URL(url);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "CIS007-3 Example Code 18/19");


			String urlParameters = "data="+what;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString()); 
			
			urls.add(response.toString());
			//return response.toString(); 
		} catch (Exception e) {
			System.out.println("Something went wrong with connecting to the server.");
			e.printStackTrace();
			//return null; 
		}
		}
		return urls;

	}

}
