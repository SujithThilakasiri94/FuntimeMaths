package GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Questionnaire.questionSet;

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection sqlConn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	protected static final Window Q_1 = null;
	private JFrame frame;
	private questionSet questionnaire = new questionSet();
	private JTextField textuser;
	private JPasswordField passwordField;
	private JTextField r1;
	private JTextField r4;
	private JTextField r5;
	private JPasswordField r6;
	private JPasswordField r7;
	private JTextField editQue;
	private JTable table;
	private JTextField editAns_1;
	private JTextField editAns_2;
	private JTextField editAns_3;
	private JTextField editAns_4;
	private JTextField editAns_5;
	JPanel panel_edit_que;
	private JTextField editQueid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(845, 551);
		frame.setBounds(100, 100, 845, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 0));
		panelMain.setLayout(null);
		panelMain.setVisible(false);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.getContentPane().add(panelMain, "name_257837612796300");

		JButton btnUserLogin = new JButton("Player Login");
		btnUserLogin.setBackground(new Color(102, 153, 102));
		btnUserLogin.setFocusPainted(false);
		btnUserLogin
				.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Sport-Football-Player-Male-Light-icon.png")));
		btnUserLogin.setForeground(new Color(0, 0, 0));
		btnUserLogin.setFont(new Font("SansSerif", Font.PLAIN, 25));

		btnUserLogin.setBounds(107, 149, 263, 79);
		panelMain.add(btnUserLogin);

		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBackground(new Color(102, 153, 102));
		btnAdminLogin.setFocusPainted(false);
		btnAdminLogin.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsLogin.png")));
		btnAdminLogin.setForeground(new Color(0, 0, 0));
		btnAdminLogin.setFont(new Font("SansSerif", Font.PLAIN, 25));

		btnAdminLogin.setBounds(107, 378, 263, 79);
		panelMain.add(btnAdminLogin);

		JButton btnUserRegister = new JButton("User Register");
		btnUserRegister.setBackground(new Color(102, 153, 102));
		btnUserRegister.setFocusPainted(false);
		btnUserRegister.setForeground(new Color(0, 0, 0));
		btnUserRegister.setFont(new Font("SansSerif", Font.PLAIN, 25));
		btnUserRegister.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsRegister.png")));

		btnUserRegister.setBounds(107, 263, 263, 79);
		panelMain.add(btnUserRegister);

		JLabel lblNewLabel_27 = new JLabel("");
		lblNewLabel_27.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsMain.png")));
		lblNewLabel_27.setBounds(449, 181, 313, 259);
		panelMain.add(lblNewLabel_27);

		JLabel lblNewLabel_4_4_1_6 = new JLabel("FunTime Maths");
		lblNewLabel_4_4_1_6.setForeground(new Color(211, 211, 211));
		lblNewLabel_4_4_1_6.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_4_4_1_6.setBounds(219, 35, 421, 94);
		panelMain.add(lblNewLabel_4_4_1_6);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsBackgroundResized.jpg")));
		lblNewLabel_2.setBounds(0, 0, 829, 482);
		panelMain.add(lblNewLabel_2);

//------------------------------------------------------------------------------------------------------------------------

		// -----------------------------------------------------------------------------------------------

		JPanel panel_admin_login = new JPanel();
		panel_admin_login.setBackground(new Color(255, 255, 0));
		frame.getContentPane().add(panel_admin_login, "name_257837625856200");
		panel_admin_login.setLayout(null);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setIcon(new ImageIcon(MainGUI.class.getResource("/img/lock-icon (1).png")));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(101, 221, 208, 85);
		panel_admin_login.add(lblPassword);

		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsLogin.png")));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 22));
		lblNewLabel.setBounds(101, 118, 221, 91);
		panel_admin_login.add(lblNewLabel);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setIcon(new ImageIcon(MainGUI.class.getResource("/img/logout-icon.png")));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 18));

		btnNewButton.setBounds(101, 365, 130, 40);
		panel_admin_login.add(btnNewButton);

		textuser = new JTextField();
		textuser.setFont(new Font("SansSerif", Font.PLAIN, 22));
		textuser.setBounds(315, 154, 336, 31);
		panel_admin_login.add(textuser);
		textuser.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SansSerif", Font.PLAIN, 22));
		passwordField.setBounds(319, 243, 332, 31);
		panel_admin_login.add(passwordField);

		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setIcon(new ImageIcon(MainGUI.class.getResource("/img/home-icon.png")));
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_admin_login.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(613, 365, 130, 40);
		panel_admin_login.add(btnNewButton_1);

		JLabel lblNewLabel_4_4_1_5 = new JLabel("FunTime Maths");
		lblNewLabel_4_4_1_5.setForeground(new Color(211, 211, 211));
		lblNewLabel_4_4_1_5.setFont(new Font("Source Serif Pro Semibold", Font.BOLD, 50));
		lblNewLabel_4_4_1_5.setBounds(217, 0, 452, 94);
		panel_admin_login.add(lblNewLabel_4_4_1_5);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsBackgroundResized.jpg")));
		lblNewLabel_1.setBounds(0, 0, 829, 506);
		panel_admin_login.add(lblNewLabel_1);

		JPanel panel_admin_dash = new JPanel();
		panel_admin_dash.setBorder(null);
		panel_admin_dash.setBackground(new Color(204, 204, 255));
		frame.getContentPane().add(panel_admin_dash, "name_257837642338900");
		panel_admin_dash.setLayout(null);

		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.setIcon(new ImageIcon(MainGUI.class.getResource("/img/ho.png")));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_admin_login.setVisible(false);
				panel_admin_dash.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(464, 350, 281, 73);
		panel_admin_dash.add(btnNewButton_2);

		JLabel lblNewLabel_26 = new JLabel("");
		lblNewLabel_26.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsMain.png")));
		lblNewLabel_26.setBounds(56, 139, 373, 284);
		panel_admin_dash.add(lblNewLabel_26);

		JButton btnNewButton_14 = new JButton("Manage Questions");
		btnNewButton_14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadQ();
				panel_edit_que.setVisible(true);
				panel_admin_dash.setVisible(false);

			}
		});
		btnNewButton_14.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Actions-mail-mark-task-icon.png")));
		btnNewButton_14.setForeground(new Color(0, 0, 0));
		btnNewButton_14.setFont(new Font("SansSerif", Font.PLAIN, 20));
		btnNewButton_14.setBackground(new Color(255, 255, 255));
		btnNewButton_14.setBounds(464, 145, 281, 73);
		panel_admin_dash.add(btnNewButton_14);

		JLabel lblNewLabel_4_4_1_4 = new JLabel("FunTime Maths");
		lblNewLabel_4_4_1_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_4_1_4.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_4_4_1_4.setBounds(228, 11, 421, 94);
		panel_admin_dash.add(lblNewLabel_4_4_1_4);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsBackgroundResized.jpg")));
		lblNewLabel_4.setBounds(0, 0, 829, 482);
		panel_admin_dash.add(lblNewLabel_4);

		JPanel panel_reg = new JPanel();
		panel_reg.setBackground(new Color(255, 165, 0));
		frame.getContentPane().add(panel_reg, "name_53502912892900");
		panel_reg.setLayout(null);

		ButtonGroup g1 = new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 102));
		panel.setBounds(88, 102, 437, 333);
		panel_reg.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Name");
		lblNewLabel_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_12.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_12.setBounds(24, 43, 77, 14);
		panel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Email");
		lblNewLabel_13.setForeground(new Color(0, 0, 0));
		lblNewLabel_13.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_13.setBounds(29, 190, 147, 19);
		panel.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Telephone No");
		lblNewLabel_14.setForeground(new Color(0, 0, 0));
		lblNewLabel_14.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_14.setBounds(24, 144, 102, 35);
		panel.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Password");
		lblNewLabel_15.setForeground(new Color(0, 0, 0));
		lblNewLabel_15.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_15.setBounds(24, 236, 102, 19);
		panel.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("Comfirm Password");
		lblNewLabel_16.setForeground(new Color(0, 0, 0));
		lblNewLabel_16.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_16.setBounds(24, 282, 140, 19);
		panel.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("Gender");
		lblNewLabel_17.setForeground(new Color(0, 0, 0));
		lblNewLabel_17.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_17.setBounds(24, 86, 77, 26);
		panel.add(lblNewLabel_17);

		r1 = new JTextField();
		r1.setFont(new Font("SansSerif", Font.BOLD, 15));
		r1.setBounds(174, 28, 232, 35);
		panel.add(r1);
		r1.setColumns(10);

		JRadioButton r2 = new JRadioButton("Male");
		r2.setForeground(new Color(0, 0, 0));
		r2.setContentAreaFilled(false);
		r2.setFont(new Font("SansSerif", Font.BOLD, 13));
		r2.setBounds(200, 83, 77, 35);
		panel.add(r2);

		g1.add(r2);

		JRadioButton r3 = new JRadioButton("Fe-Male");
		r3.setForeground(new Color(0, 0, 0));
		r3.setContentAreaFilled(false);
		r3.setFont(new Font("SansSerif", Font.BOLD, 13));
		r3.setBounds(279, 83, 96, 35);
		panel.add(r3);
		g1.add(r3);

		r4 = new JTextField();
		r4.setFont(new Font("SansSerif", Font.BOLD, 15));
		r4.setBounds(174, 137, 232, 34);
		panel.add(r4);
		r4.setColumns(10);

		r5 = new JTextField();
		r5.setFont(new Font("SansSerif", Font.BOLD, 15));
		r5.setBounds(174, 182, 232, 37);
		panel.add(r5);
		r5.setColumns(10);

		r6 = new JPasswordField();
		r6.setFont(new Font("SansSerif", Font.BOLD, 15));
		r6.setBounds(174, 230, 232, 35);
		panel.add(r6);

		r7 = new JPasswordField();
		r7.setFont(new Font("SansSerif", Font.BOLD, 15));
		r7.setBounds(174, 276, 232, 35);
		panel.add(r7);

		// Register Button
		JButton r8 = new JButton("Register");
		r8.setIcon(new ImageIcon(MainGUI.class.getResource("/img/User-Interface-Login-icon (1).png")));
		r8.setBounds(609, 202, 143, 37);
		panel_reg.add(r8);
		r8.setForeground(new Color(0, 0, 0));
		r8.setBackground(new Color(255, 255, 255));
		r8.setFont(new Font("SansSerif", Font.BOLD, 16));

		JButton btnNewButton_13 = new JButton("Back");
		btnNewButton_13.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Go-back-icon (1).png")));
		btnNewButton_13.setBounds(609, 314, 143, 37);
		panel_reg.add(btnNewButton_13);
		btnNewButton_13.setForeground(new Color(0, 0, 0));
		btnNewButton_13.setBackground(new Color(255, 255, 255));
		btnNewButton_13.setFont(new Font("SansSerif", Font.BOLD, 16));

		JLabel lblNewLabel_4_4_1_3 = new JLabel("FunTime Maths");
		lblNewLabel_4_4_1_3.setForeground(new Color(204, 204, 204));
		lblNewLabel_4_4_1_3.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_4_4_1_3.setBounds(191, 11, 450, 94);
		panel_reg.add(lblNewLabel_4_4_1_3);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsBackgroundResized.jpg")));
		lblNewLabel_3.setBounds(0, 0, 829, 482);
		panel_reg.add(lblNewLabel_3);
		btnNewButton_13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panelMain.setVisible(true);
				panel_reg.setVisible(false);
			}
		});
		r8.addActionListener(new ActionListener() {
			@Override
			@SuppressWarnings({ "deprecation" })
			public void actionPerformed(ActionEvent e) {

				String Gender;
				if (r2.isSelected()) {
					Gender = "male";

				} else
					Gender = "female";

				// Validations
				if (r6.getText().equals(r7.getText())) {

					try {
						Class.forName("com.mysql.jdbc.Driver");
						sqlConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/funMaths",
						"root", "root1234");
						pst = sqlConn.prepareStatement(
								"INSERT INTO register (`Name`, `Gender`, `TepNo`, `E-mail`, `Password`) VALUES (?,?,?,?,?)");
						pst.setString(1, r1.getText());
						pst.setString(2, Gender);
						pst.setInt(3, Integer.parseInt(r4.getText()));
						pst.setString(4, r5.getText());
						pst.setString(5, r6.getText());

						pst.execute();
						JOptionPane.showMessageDialog(frame, "Registered");

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(frame, "Error");
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else
					JOptionPane.showMessageDialog(frame, "User Name or Password not valid !");

			}
		});

		panel_edit_que = new JPanel();
		panel_edit_que.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel_edit_que, "name_452472276869900");
		panel_edit_que.setVisible(false);
		panel_edit_que.setLayout(null);

		editQueid = new JTextField();
		editQueid.setFont(new Font("Tahoma", Font.BOLD, 15));
		editQueid.setEnabled(false);
		editQueid.setBounds(30, 101, 73, 33);
		panel_edit_que.add(editQueid);

		editQue = new JTextField();
		editQue.setFont(new Font("Tahoma", Font.BOLD, 12));
		editQue.setBounds(30, 145, 473, 111);
		panel_edit_que.add(editQue);
		editQue.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 283, 584, 166);
		panel_edit_que.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		editAns_1 = new JTextField();
		editAns_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		editAns_1.setBounds(622, 107, 140, 20);
		panel_edit_que.add(editAns_1);
		editAns_1.setColumns(10);

		editAns_2 = new JTextField();
		editAns_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		editAns_2.setColumns(10);
		editAns_2.setBounds(622, 138, 140, 20);
		panel_edit_que.add(editAns_2);

		editAns_3 = new JTextField();
		editAns_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		editAns_3.setColumns(10);
		editAns_3.setBounds(622, 169, 140, 20);
		panel_edit_que.add(editAns_3);

		editAns_4 = new JTextField();
		editAns_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		editAns_4.setColumns(10);
		editAns_4.setBounds(622, 198, 140, 20);
		panel_edit_que.add(editAns_4);

		editAns_5 = new JTextField();
		editAns_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		editAns_5.setColumns(10);
		editAns_5.setBounds(622, 229, 140, 20);
		panel_edit_que.add(editAns_5);

		JButton edit_que = new JButton("Update");
		edit_que.setIcon(new ImageIcon(MainGUI.class.getResource("/img/system-software-update-icon (1).png")));
		edit_que.setBackground(new Color(153, 204, 255));
		edit_que.setForeground(new Color(0, 0, 0));
		edit_que.setFont(new Font("SansSerif", Font.PLAIN, 18));
		edit_que.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean s = questionnaire.updateQue(Integer.parseInt(editQueid.getText()), editQue.getText(),
						editAns_1.getText(), editAns_2.getText(), editAns_3.getText(), editAns_4.getText(),
						editAns_5.getText());
				if (s) {
					JOptionPane.showMessageDialog(frame, "Update");
					loadQ();
				}
			}
		});
		edit_que.setBounds(654, 340, 152, 41);
		panel_edit_que.add(edit_que);

		JButton btnNewButton_15 = new JButton("Back");
		btnNewButton_15.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Go-back-icon (1).png")));
		btnNewButton_15.setForeground(new Color(0, 0, 0));
		btnNewButton_15.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btnNewButton_15.setBackground(new Color(153, 204, 255));
		btnNewButton_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_edit_que.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		btnNewButton_15.setBounds(654, 400, 152, 41);
		panel_edit_que.add(btnNewButton_15);

		JLabel lblNewLabel_4_4_1_2 = new JLabel("FunTime Maths");
		lblNewLabel_4_4_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_4_1_2.setFont(new Font("Source Serif Pro Semibold", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel_4_4_1_2.setBounds(199, 0, 384, 94);
		panel_edit_que.add(lblNewLabel_4_4_1_2);

		JLabel lblNewLabel_32 = new JLabel("Option 1");
		lblNewLabel_32.setForeground(new Color(255, 255, 255));
		lblNewLabel_32.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_32.setBounds(538, 112, 63, 14);
		panel_edit_que.add(lblNewLabel_32);

		JLabel lblNewLabel_33 = new JLabel("Option 2");
		lblNewLabel_33.setForeground(new Color(255, 255, 255));
		lblNewLabel_33.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_33.setBounds(538, 143, 63, 14);
		panel_edit_que.add(lblNewLabel_33);

		JLabel lblNewLabel_34 = new JLabel("Option 3");
		lblNewLabel_34.setForeground(new Color(255, 255, 255));
		lblNewLabel_34.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_34.setBounds(538, 174, 63, 14);
		panel_edit_que.add(lblNewLabel_34);

		JLabel lblNewLabel_35 = new JLabel("Option 4");
		lblNewLabel_35.setForeground(new Color(255, 255, 255));
		lblNewLabel_35.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_35.setBounds(538, 203, 63, 14);
		panel_edit_que.add(lblNewLabel_35);

		JLabel lblNewLabel_36 = new JLabel("Answer");
		lblNewLabel_36.setForeground(new Color(255, 255, 255));
		lblNewLabel_36.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_36.setBounds(548, 232, 49, 14);
		panel_edit_que.add(lblNewLabel_36);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MainGUI.class.getResource("/img/mathsBackgroundResized.jpg")));
		lblNewLabel_5.setBounds(0, 0, 829, 482);
		panel_edit_que.add(lblNewLabel_5);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				TableModel model = table.getModel();
				editQueid.setText(model.getValueAt(row, 0).toString());
				editQue.setText(model.getValueAt(row, 1).toString());
				editAns_1.setText(model.getValueAt(row, 2).toString());
				editAns_2.setText(model.getValueAt(row, 3).toString());
				editAns_3.setText(model.getValueAt(row, 4).toString());
				editAns_4.setText(model.getValueAt(row, 5).toString());
				editAns_5.setText(model.getValueAt(row, 6).toString());

			}
		});
		// check password

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = textuser.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				System.out.println("Checking Password...");
				String result[] = questionnaire.login(user, pass);
				if (result[0].equals("wrongpassword")) {
					System.out.println("Wrong Password");
					JOptionPane.showMessageDialog(frame, "Wrong password");
					panel_admin_login.setVisible(false);
					panelMain.setVisible(true);
				} else if (result[0].equals("admin")) {
					System.out.println("Successful Login!");
					panelMain.setVisible(false);
					panel_admin_login.setVisible(false);
					panel_admin_dash.setVisible(true);
				} else {
					System.out.println("Successful Login!");
					panelMain.setVisible(false);
					panel_admin_login.setVisible(false);

				}
			}
		});

		btnAdminLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel_admin_login.setVisible(true);
				panelMain.setVisible(false);
			}
		});

		btnUserLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				new PlayerLogin().setVisible(true);

			}
		});

		btnUserRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panelMain.setVisible(false);
				panel_reg.setVisible(true);

			}
		});
	}

	public void loadQ() {

		ArrayList<Object[]> obj = questionnaire.loadQ();

		System.out.println(obj);

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "qID", "Question", "ans1", "ans2", "ans3", "ans4", "ans5" }) {

			private static final long serialVersionUID = 8845522513340293589L;
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);

		for (int i = 0; i < obj.size(); i++) {
			DefaultTableModel m = (DefaultTableModel) table.getModel();
			m.addRow(obj.get(i));
		}
	}
}
