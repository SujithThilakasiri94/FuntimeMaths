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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PlayerLogin extends JFrame {

	public String userName;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUserName;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PlayerLogin frame = new PlayerLogin();
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
	public PlayerLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Player Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(SystemColor.windowText);
		lblNewLabel.setBounds(94, 30, 153, 32);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(24, 16, 64, 64);
		lblNewLabel_1.setIcon(
				new ImageIcon(PlayerLogin.class.getResource("/img/Sport-Football-Player-Male-Light-icon.png")));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setBackground(SystemColor.window);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_2.setBounds(94, 153, 122, 49);
		contentPane.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 91, 752, 7);
		contentPane.add(separator);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(94, 261, 122, 25);
		contentPane.add(lblNewLabel_3);

		tfUserName = new JTextField();
		tfUserName.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfUserName.setBounds(218, 162, 406, 38);
		contentPane.add(tfUserName);
		tfUserName.setColumns(10);

		JButton btnPwd = new JButton("Login");
		btnPwd.setIcon(new ImageIcon(PlayerLogin.class.getResource("/img/logout-icon.png")));
		btnPwd.setForeground(new Color(0, 0, 0));
		btnPwd.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				// login button code
				try {
					Class.forName("com.mysql.jdbc.Driver");
					;
					Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/funMaths",
						"root", "root1234");

					String userName = tfUserName.getText();
					String password = pfPassword.getText();

					Statement stmt = con.createStatement();
					String sql = "select * from register where Name = '" + userName + "' and Password = '" + password
							+ "' ";
					ResultSet rs = stmt.executeQuery(sql);

					if (rs.next()) {

						setVisible(false);
						new QuizGuide(userName).setVisible(true);

					} else {
						JOptionPane.showMessageDialog(null, "Invalid User Name or Password !");
					}
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

			}
		});
		btnPwd.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnPwd.setBounds(218, 372, 136, 41);
		contentPane.add(btnPwd);

		JButton btnClear = new JButton("Clear");
		btnClear.setIcon(new ImageIcon(PlayerLogin.class.getResource("/img/trash-icon (1).png")));
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// button reset code
				tfUserName.setText("");
				pfPassword.setText("");

			}
		});
		btnClear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnClear.setBounds(482, 372, 142, 41);
		contentPane.add(btnClear);

		pfPassword = new JPasswordField();
		pfPassword.setFont(new Font("Segoe UI", Font.BOLD, 18));
		pfPassword.setBounds(218, 261, 406, 38);
		contentPane.add(pfPassword);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(PlayerLogin.class.getResource("/img/mathsBackgroundResized.jpg")));
		lblNewLabel_4.setBounds(0, 0, 752, 441);
		contentPane.add(lblNewLabel_4);
	}
}
