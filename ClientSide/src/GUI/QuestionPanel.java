package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class QuestionPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String userName;
	public String question;
	public String answer;
	public int qID = 1;
	public int min, sec, marks = 0, uID;
	Timer time;

	private JPanel contentPane;
	private final JSeparator separator = new JSeparator();
	private JTextField tfDisplayName;
	private JTextField tfDisplayQuestion;
	private JTextField tfTimeMin;
	private JTextField tfTimeSec;
	private JTextField tfQuestionNo;
	private JTextField tfMarks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					String userName1 = null;
					QuestionPanel frame = new QuestionPanel(userName1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public QuestionPanel(String userName1) {
		setResizable(false);

		userName = userName1;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 497);
		setSize(1152, 768);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.control);
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		separator.setForeground(new Color(204, 153, 255));
		separator.setBounds(0, 141, 1136, 8);
		contentPane.add(separator);

		JLabel lblNewLabel = new JLabel("Total time");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(597, 51, 103, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("10min");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(710, 52, 79, 27);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Time taken");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_2.setBounds(856, 53, 110, 24);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_6 = new JLabel("Name");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_6.setBounds(24, 236, 57, 29);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Total Question");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_7.setBounds(23, 333, 130, 27);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Question No");
		lblNewLabel_8.setForeground(new Color(0, 0, 0));
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_8.setBounds(24, 427, 110, 21);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Marks");
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_9.setBounds(24, 505, 87, 21);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_12 = new JLabel("10");
		lblNewLabel_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_12.setBounds(163, 333, 46, 27);
		contentPane.add(lblNewLabel_12);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(300, 172, 805, 421);
		contentPane.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnOption1 = new JRadioButton("New radio button");
		rdbtnOption1.setBackground(new Color(204, 204, 204));
		rdbtnOption1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rdbtnOption1.setBounds(100, 165, 260, 23);
		panel.add(rdbtnOption1);

		JRadioButton rdbtnOption2 = new JRadioButton("New radio button");
		rdbtnOption2.setBackground(new Color(204, 204, 204));
		rdbtnOption2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rdbtnOption2.setBounds(100, 206, 260, 23);
		panel.add(rdbtnOption2);

		JRadioButton rdbtnOption3 = new JRadioButton("New radio button");
		rdbtnOption3.setBackground(new Color(204, 204, 204));
		rdbtnOption3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rdbtnOption3.setBounds(100, 245, 260, 23);
		panel.add(rdbtnOption3);

		JRadioButton rdbtnOption4 = new JRadioButton("New radio button");
		rdbtnOption4.setBackground(new Color(204, 204, 204));
		rdbtnOption4.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rdbtnOption4.setBounds(100, 286, 260, 23);
		panel.add(rdbtnOption4);

		tfDisplayQuestion = new JTextField();
		tfDisplayQuestion.setBackground(new Color(255, 255, 255));
		tfDisplayQuestion.setEditable(false);
		tfDisplayQuestion.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfDisplayQuestion.setBounds(31, 79, 748, 79);
		panel.add(tfDisplayQuestion);
		tfDisplayQuestion.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon(QuestionPanel.class.getResource("/img/Actions-document-save-icon.png")));
		btnSubmit.setBackground(new Color(204, 204, 204));
		btnSubmit.setForeground(new Color(255, 51, 0));
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerCheck(rdbtnOption4, rdbtnOption3, rdbtnOption2, rdbtnOption1);
				submit();

			}

		});
		btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnSubmit.setBounds(52, 629, 138, 43);
		contentPane.add(btnSubmit);

		tfDisplayName = new JTextField();
		tfDisplayName.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfDisplayName.setForeground(new Color(0, 0, 0));
		tfDisplayName.setBackground(new Color(153, 153, 153));
		tfDisplayName.setEditable(false);
		tfDisplayName.setBounds(111, 237, 168, 28);
		contentPane.add(tfDisplayName);
		tfDisplayName.setColumns(10);
		tfDisplayName.setText(userName);

		tfTimeMin = new JTextField();
		tfTimeMin.setFont(new Font("Tahoma", Font.BOLD, 20));
		tfTimeMin.setForeground(new Color(255, 102, 51));
		tfTimeMin.setBackground(new Color(211, 211, 211));
		tfTimeMin.setEditable(false);
		tfTimeMin.setBounds(976, 56, 37, 24);
		contentPane.add(tfTimeMin);
		tfTimeMin.setColumns(10);

		tfTimeSec = new JTextField();
		tfTimeSec.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfTimeSec.setForeground(new Color(255, 102, 51));
		tfTimeSec.setBackground(new Color(211, 211, 211));
		tfTimeSec.setEditable(false);
		tfTimeSec.setBounds(1023, 57, 37, 23);
		contentPane.add(tfTimeSec);
		tfTimeSec.setColumns(10);

		tfQuestionNo = new JTextField();
		tfQuestionNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfQuestionNo.setForeground(new Color(0, 0, 0));
		tfQuestionNo.setBackground(new Color(153, 153, 153));
		tfQuestionNo.setEditable(false);
		tfQuestionNo.setBounds(161, 428, 44, 20);
		contentPane.add(tfQuestionNo);
		tfQuestionNo.setColumns(10);
		tfQuestionNo.setText(Integer.toString(qID));

		tfMarks = new JTextField();
		tfMarks.setFont(new Font("Tahoma", Font.BOLD, 18));
		tfMarks.setForeground(new Color(0, 0, 0));
		tfMarks.setBackground(new Color(153, 153, 153));
		tfMarks.setEditable(false);
		tfMarks.setBounds(161, 506, 46, 20);
		contentPane.add(tfMarks);
		tfMarks.setColumns(10);
		tfMarks.setText(Integer.toString(marks));

		setLocationRelativeTo(this);
		time = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				tfTimeSec.setText(String.valueOf(sec));
				tfTimeMin.setText(String.valueOf(min));

				if (sec == 60) {
					sec = 0;
					min++;
					if (min == 5) {

						time.stop();
						answerCheck(rdbtnOption4, rdbtnOption3, rdbtnOption2, rdbtnOption1);
						submit();
					}
				}

				sec++;

			}

		});

		time.start();
		question(rdbtnOption1, rdbtnOption2, rdbtnOption3, rdbtnOption4);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(QuestionPanel.class.getResource("/img/App-lists-icon.png")));
		lblNewLabel_3.setBounds(599, 245, 135, 90);
		panel.add(lblNewLabel_3);

		JButton btnNext = new JButton("Next");
		btnNext.setIcon(new ImageIcon(QuestionPanel.class.getResource("/img/Actions-go-next-icon (1).png")));
		btnNext.setBackground(new Color(204, 204, 204));
		btnNext.setForeground(new Color(255, 51, 0));
		btnNext.setBounds(944, 629, 138, 43);
		contentPane.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (qID == 9) {
					btnNext.setVisible(false);
				} else {
					qID = qID + 1;
					answerCheck(rdbtnOption1, rdbtnOption2, rdbtnOption3, rdbtnOption4);
					question(rdbtnOption1, rdbtnOption2, rdbtnOption3, rdbtnOption4);

				}

			}

		});
		btnNext.setFont(new Font("Segoe UI", Font.BOLD, 20));

		JLabel lblNewLabel_4 = new JLabel("Quiz");
		lblNewLabel_4.setIcon(
				new ImageIcon(QuestionPanel.class.getResource("/img/Sport-Football-Player-Male-Light-icon.png")));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_4.setBounds(47, 11, 183, 106);
		contentPane.add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 153));
		panel_1.setBounds(10, 172, 286, 421);
		contentPane.add(panel_1);

		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(QuestionPanel.class.getResource("/img/quizBack.jpg")));
		lblNewLabel_5.setBounds(0, 0, 1136, 729);
		contentPane.add(lblNewLabel_5);

	}

	public void answerCheck(AbstractButton rdbtnOption4, AbstractButton rdbtnOption3, AbstractButton rdbtnOption2,
			AbstractButton rdbtnOption1) {
		String studentAswer = "";

		if (rdbtnOption1.isSelected()) {

			studentAswer = rdbtnOption1.getText();

		}

		if (rdbtnOption2.isSelected()) {

			studentAswer = rdbtnOption2.getText();

		}

		if (rdbtnOption3.isSelected()) {

			studentAswer = rdbtnOption3.getText();

		}

		if (rdbtnOption4.isSelected()) {

			studentAswer = rdbtnOption4.getText();

		}

		System.out.println("studentAswer = " + studentAswer);

		if (studentAswer.equals(answer)) {

			marks = marks + 10;
			String strMark = String.valueOf(marks);
			tfMarks.setText(strMark);
		}

	}

	public void submit() {
		userName = tfDisplayName.getText();
//		try {
//			Connection conn = DriverManager.getConnection(
//					"jdbc:mysql://funmaths.cymfgpdjcecz.us-west-1.rds.amazonaws.com:3306/funMaths", "root", "root1234");
//			Statement stmt = conn.createStatement();
//
////			String query = "select * from register where Name = '" + userName + "'";
////			ResultSet rs = stmt.executeQuery(query);
////			System.out.println("query success");
////			rs.getString(1);
////			System.out.println("uID = " + rs);
////			System.out.println("User Id for " + userName + "is " + uID);
////
////			stmt.executeQuery("INSERT INTO playerMarks " + "VALUES (uID,marks)");
//
//			setVisible(false);
//			showChart();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}

	public void question(AbstractButton rdbtnOption4, AbstractButton rdbtnOption3, AbstractButton rdbtnOption2,
			AbstractButton rdbtnOption1) {
		tfQuestionNo.setText(Integer.toString(qID));

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/funMaths",
				"root", "root1234");
			Statement stmt = conn.createStatement();
			String query = "select * from questions order by rand();";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				tfDisplayQuestion.setText(rs.getString(2));

				rdbtnOption1.setText(rs.getString(3));

				rdbtnOption2.setText(rs.getString(4));

				rdbtnOption3.setText(rs.getString(5));

				rdbtnOption4.setText(rs.getString(6));
				answer = rs.getString(7);
				System.out.println("Answer = " + answer);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

	public void showChart() {

		DefaultPieDataset piedata = new DefaultPieDataset();
		piedata.setValue("Inorrect Answers", (100 - marks));
		piedata.setValue("Correct Answers", marks);

		JFreeChart chart = ChartFactory.createPieChart("Score Summary", piedata, true, true, true);
		// PiePlot plot = (PiePlot) chart.getPlot();
		// plot.setForegroundAlpha(TOP_ALIGNMENT);
		ChartFrame frame = new ChartFrame("Score Summary", chart);
		frame.setVisible(true);
		frame.setSize(800, 500);

	}
}
