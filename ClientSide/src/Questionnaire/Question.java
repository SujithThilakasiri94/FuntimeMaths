package Questionnaire;

import java.io.Serializable;
import java.util.Hashtable;

public class Question implements Serializable {

	/**
	 * question model class
	 */
	private static final long serialVersionUID = 1L;
	private String[] answers;
	private String question;
	private Hashtable<String, Integer> freq = new Hashtable<String, Integer>();

	public Question(String question, String[] answers) {
		super();
		this.answers = answers;
		this.question = question;
	}

	public String[] getAnswers() {
		return answers;
	}

	public String getQuestion() {
		return question;
	}

	public void addAnswer(String ans) {
		int no = getFreq(ans);
		freq.put(ans, no + 1);
	}

	public int getFreq(String ans) {
		Integer no = freq.get(ans);
		if (no == null) {
			return 0;
		}
		return no;
	}
}
