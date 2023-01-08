package Questionnaire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

public interface RemoteQuestions extends Remote {
	/**
	 * Number of questions on the server.
	 * @return questions
	 * @throws RemoteException
	 */
	public int getNumOfQuestion() throws RemoteException; 
	/**
	 * Retrieve specific question from the server. 
	 * @param x number of the question. 
	 * @return the Question. 
	 * @throws RemoteException
	 */
	public Question getQuestion(int x) throws RemoteException; 
	/**
	 * Submit the answer to the question number x.
	 * @param x question where the answer belongs to.
	 * @param ans the answer given to this question. 
	 * @throws RemoteException
	 */
	void addAnswer(int x, String ans) throws RemoteException;  
	/**
	 * Returns the answers to the questions given. 
	 * @return answers to the questions. 
	 * @param cookie get cookie
	 * @throws RemoteException
	 */
	public Vector<Question> getDetails(String cookie) throws RemoteException; 
	
	/**
	 * Returns a cookie that gives access to answers.
	 * @param password The password
	 * @param username The username
	 * @throws RemoteException
	 */
	public String[] login(String username, String password) throws RemoteException;
	
	/**
	 * Returns a question array list
	 * @return the question array
	 * @throws RemoteException
	 */
	public ArrayList<Object[]> loadQ() throws RemoteException;
	
	/**
	 * Returns a cookie that gives access to answers.
	 * @param qid question ID
	 * @param que question
	 * @param a1  answer 1
	 * @param a2  answer 2
	 * @param a3  answer 3
	 * @param a4  answer 4
	 * @param a5  answer 5
	 * @return the boolean value true o false
	 * @throws RemoteException
	 */
	
	public boolean updateQue(int qid, String que, String a1, String a2, String a3, String a4, String a5) throws RemoteException;
}
