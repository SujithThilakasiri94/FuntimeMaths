package ServerRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import Questionnaire.Question;
import Questionnaire.RemoteQuestions;
import Questionnaire.connection;

public class questionServer extends UnicastRemoteObject implements RemoteQuestions {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Cookie;
	private String[] login = new String[2];
	Vector<Question> myQuestions = new Vector<Question>();

	protected questionServer() throws RemoteException {
		super();
		System.out.println("Question Created");

		connection c = new connection();
		Statement sta = null;
		ResultSet re = null;
		ArrayList<String> Q = new ArrayList<String>();
		ArrayList<String[]> A = new ArrayList<String[]>();

		try {
			String sql = "select * from questions";

			sta = c.get().createStatement();
			re = sta.executeQuery(sql);

			while (re.next()) {
				int j = 0;

				Q.add(re.getString("Question"));

				for (int i = 3; i <= 7; i++) {
					if (re.getString(i) != null) {
						j++;
					}
				}

				String[] an = new String[j];

				for (int i = 0; i < j; i++) {
					an[i] = re.getString(i + 3);
				}
				A.add(an);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Question q1 = new Question(Q.get(0), A.get(0));
		myQuestions.add(q1);
		Question q2 = new Question(Q.get(1), A.get(1));
		myQuestions.add(q2);
		Question q3 = new Question(Q.get(2), A.get(2));
		myQuestions.add(q3);
		Question q4 = new Question(Q.get(3), A.get(3));
		myQuestions.add(q4);
		Question q5 = new Question(Q.get(4), A.get(4));
		myQuestions.add(q5);
		Question q6 = new Question(Q.get(5), A.get(5));
		myQuestions.add(q6);
		Question q7 = new Question(Q.get(6), A.get(6));
		myQuestions.add(q7);
		Question q8 = new Question(Q.get(7), A.get(7));
		myQuestions.add(q8);
		Question q9 = new Question(Q.get(8), A.get(8));
		myQuestions.add(q9);

	}

	@Override
	public int getNumOfQuestion() throws RemoteException {
		return myQuestions.size();
	}

	@Override
	public Question getQuestion(int x) throws RemoteException {
		return myQuestions.elementAt(x);
	}

	@Override
	public void addAnswer(int x, String ans) throws RemoteException {
		myQuestions.elementAt(x).addAnswer(ans);
	}

	@Override
	public Vector<Question> getDetails(String cookie) throws RemoteException {
		if (cookie.equals(Cookie)) {
			return myQuestions;
		} else {
			return null;
		}
	}

	@Override
	public String[] login(String username, String password) throws RemoteException {

		connection c1 = new connection();
		Statement sta = null;
		ResultSet re = null;

		try {
			String sql = "select * from register where Name = \"" + username + "\"and Password = \"" + password + "\"";

			sta = c1.get().createStatement();
			re = sta.executeQuery(sql);
			if (re.next() == true) {
				Cookie = "abc" + Math.random();
				login[0] = re.getString("type");
				login[1] = Cookie;
				return login;
			} else {
				login[0] = "wrongpassword";
				login[1] = "NotSet";
				return login;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			login[0] = "wrongpassword";
			login[1] = "NotSet";
			return login;
		}
	}

	@Override
	public ArrayList<Object[]> loadQ() throws RemoteException {

		connection db = new connection();
		Connection cn = db.get();

		String sql = "SELECT * from questions";
		ResultSet rs;
		Statement stat;
		ArrayList<Object[]> obArray = new ArrayList<Object[]>();

		try {
			stat = cn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {

				Object[] ob = new Object[7];

				ob[0] = rs.getInt("idQuestions");
				ob[1] = rs.getString("question");
				ob[2] = rs.getString("Answer_1");
				ob[3] = rs.getString("Answer_2");
				ob[4] = rs.getString("Answer_3");
				ob[5] = rs.getString("Answer_4");
				ob[6] = rs.getString("Answer_5");

				obArray.add(ob);
			}
			return obArray;

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateQue(int qid, String que, String a1, String a2, String a3, String a4, String a5)
			throws RemoteException {

		connection db = new connection();
		Connection cn = db.get();

		String sql = "UPDATE questions set Question = ?, Answer_1 = ?, Answer_2 = ?, Answer_3 = ?, Answer_4 = ?, Answer_5 = ? where idQuestions = ?";
		PreparedStatement stat;

		try {
			stat = cn.prepareStatement(sql);
			stat.setString(1, que);
			stat.setString(2, a1);
			stat.setString(3, a2);
			stat.setString(4, a3);
			stat.setString(5, a4);
			stat.setString(6, a5);
			stat.setInt(7, qid);
			stat.execute();

			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}
}
