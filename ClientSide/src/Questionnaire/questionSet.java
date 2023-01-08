package Questionnaire;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;


public class questionSet {

	RemoteQuestions myQ;

	public questionSet() {
		super();

		try {
			myQ = (RemoteQuestions) Naming.lookup("rmi://localhost:1099/QuestionService1819");
			System.out.println("done");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Is your server running?");
			e.printStackTrace();
		}
	}

	// get number of questions
	
	public int numOfQuestions() {
		try {
			return myQ.getNumOfQuestion();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public String getQuestion(int i) {

		try {
			return myQ.getQuestion(i).getQuestion();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "no connection to server";
		}
	}

	// get number of answers
	
	public String[] getAnswers(int i) {
		try {
			return myQ.getQuestion(i).getAnswers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void submitAnswer(int i, String answer) {
		try {
			myQ.addAnswer(i, answer);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] login(String username, String password) {
		try {
			return myQ.login(username, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	public void reportAnswers(String cookie) {

		try {
			Vector<Question> answers = myQ.getDetails(cookie);
			if (answers == null) {
				System.out.println("You must be logged in to retrieve the Answers");
			} else {
				QAnswers myAnswers = new QAnswers(answers);

				System.out.println("Basic analysis:");
				System.out.println(myAnswers.basicAnalysis());

			}
		} catch (RemoteException e) {
			System.out.println("Something went wrong: " + e.toString());
			e.printStackTrace();
		}
	}

	public ArrayList<Object[]> loadQ() {
		try {
			return myQ.loadQ();
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	//Update Questions
	
	public boolean updateQue(int qid, String que, String a1, String a2, String a3, String a4, String a5) {
		try {
			return myQ.updateQue(qid, que, a1, a2, a3, a4, a5);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
