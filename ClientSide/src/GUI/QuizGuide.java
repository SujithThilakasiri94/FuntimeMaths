package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class QuizGuide extends JFrame {
	public String userName;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1208050061955878293L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			String userName1 = null;
			QuizGuide dialog = new QuizGuide(userName1);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public QuizGuide(String userName1) {
		setResizable(false);

		userName = userName1;

		getContentPane().setBackground(new Color(255, 255, 102));
		setBounds(100, 100, 818, 497);
		setSize(1152, 768);
		getContentPane().setLayout(null);
		{
			JButton btnStartQuiz = new JButton("Start Quiz");
			btnStartQuiz.setBackground(new Color(204, 204, 204));
			btnStartQuiz.setIcon(new ImageIcon(QuizGuide.class.getResource("/img/mathsStart.png")));
			btnStartQuiz.setForeground(new Color(255, 51, 0));
			btnStartQuiz.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					new QuestionPanel(userName).setVisible(true);
					System.out.println("QG user " + userName);
				}
			});
			btnStartQuiz.setFont(new Font("Segoe UI", Font.BOLD, 18));
			btnStartQuiz.setBounds(495, 601, 203, 65);
			getContentPane().add(btnStartQuiz);
		}

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(QuizGuide.class.getResource("/img/Sport-Football-Player-Male-Light-icon.png")));
		lblNewLabel.setBounds(25, 11, 71, 65);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Instruction For The Quiz");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel_1.setBounds(106, 27, 426, 37);
		getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textHighlight);
		separator.setBounds(0, 104, 1350, 19);
		getContentPane().add(separator);

		JTextArea txtUser = new JTextArea();
		txtUser.setEditable(false);
		txtUser.setFont(new Font("SansSerif", Font.BOLD, 18));
		txtUser.setText(
				"01 ) User must complete the 10 question multiple choise Quiz within the 10 minutes time frame \r\nallocated for the quiz.\r\n\r\n02 ) Backward navigation is disabled.\r\n\r\n03 ) Calculators not Allowed.\r\n\r\n\t\t\t\r\n\t\t\tNumber of Questions = 10\r\n\t\t\tAllocated Time = 10 minutes ");
		txtUser.setBounds(64, 255, 984, 249);
		getContentPane().add(txtUser);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(QuizGuide.class.getResource("/img/quizBack.jpg")));
		lblNewLabel_2.setBounds(0, 0, 1136, 729);
		getContentPane().add(lblNewLabel_2);

	}

}
