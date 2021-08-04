package LoginFormDesign;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.omg.CORBA.FREE_MEM;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameLogin extends JFrame {
	
	private Image img_logo = new ImageIcon(FrameLogin.class.getResource("/PNG/bbank.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
	private Image img_man = new ImageIcon(FrameLogin.class.getResource("/PNG/man.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_password = new ImageIcon(FrameLogin.class.getResource("/PNG/ppassword.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	private Image img_key = new ImageIcon(FrameLogin.class.getResource("/PNG/kkey.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	
	
	private JPanel contentPane;
	private JPasswordField pwdPassword;
	private JTextField textUser;
	private JLabel lblMess = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelUser = new JPanel();
		panelUser.setBackground(Color.WHITE);
		panelUser.setBorder(null);
		panelUser.setForeground(Color.WHITE);
		panelUser.setBounds(170, 159, 242, 38);
		contentPane.add(panelUser);
		panelUser.setLayout(null);
		
		textUser = new JTextField();
		textUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textUser.getText().equals("Username")) {
					textUser.setText("");
				}else {
					textUser.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textUser.getText().equals("")) {
					textUser.setText("Username");
				}
			}
		});
		textUser.setForeground(Color.BLACK);
		textUser.setBorder(null);
		textUser.setFont(new Font("Arial", Font.PLAIN, 12));
		textUser.setText("Username");
		textUser.setBounds(10, 11, 177, 20);
		panelUser.add(textUser);
		textUser.setColumns(10);
		
		JLabel UserLogo = new JLabel("");
		UserLogo.setBounds(210, 0, 32, 38);
		panelUser.add(UserLogo);
		UserLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		UserLogo.setHorizontalAlignment(SwingConstants.CENTER);
		UserLogo.setIcon(new ImageIcon(img_man));
		
		JPanel panelPass = new JPanel();
		panelPass.setBackground(Color.WHITE);
		panelPass.setBounds(170, 208, 242, 38);
		contentPane.add(panelPass);
		panelPass.setLayout(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals("Password")) {
					pwdPassword.setEchoChar('●');
					pwdPassword.setText("");
				}else {
					pwdPassword.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("")) {
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar((char)0);
				}
			}
		});
		pwdPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		pwdPassword.setBorder(null);
		pwdPassword.setEchoChar((char)0);
		pwdPassword.setText("Password");
		pwdPassword.setBounds(10, 11, 180, 20);
		panelPass.add(pwdPassword);
		
		JLabel LogoPass = new JLabel("");
		LogoPass.setBounds(210, 0, 32, 38);
		panelPass.add(LogoPass);
		LogoPass.setHorizontalTextPosition(SwingConstants.CENTER);
		LogoPass.setIcon(new ImageIcon(img_password));
		
		JPanel panelLG = new JPanel();
		panelLG.setBackground(new Color(47, 79, 79));
		panelLG.setForeground(Color.WHITE);
		panelLG.setBounds(170, 285, 242, 38);
		contentPane.add(panelLG);
		panelLG.setLayout(null);
		
		JLabel LOGIN = new JLabel("LOG IN");
		LOGIN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textUser.getText().equals("admin") && pwdPassword.getText().equals("123456")) {
					lblMess.setText("");
					JOptionPane.showMessageDialog(null, "Login successful");
				}else if(textUser.getText().equals("") || pwdPassword.getText().equals("")
						|| textUser.getText().equals("Username") || pwdPassword.getText().equals("Password")) {
					lblMess.setText("Please input all requirement!");
				}else {
					lblMess.setText("Username or Password is wrong");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panelLG.setBackground(new Color(30, 60, 60));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelLG.setBackground(new Color(47, 79, 79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panelLG.setBackground(new Color(60, 60, 80));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panelLG.setBackground(new Color(47, 79, 79));
			}
		});
		LOGIN.setForeground(Color.WHITE);
		LOGIN.setFont(new Font("Arial", Font.BOLD, 14));
		LOGIN.setHorizontalAlignment(SwingConstants.CENTER);
		LOGIN.setBounds(0, 0, 242, 38);
		LOGIN.setIcon(new ImageIcon(img_key));
		panelLG.add(LOGIN);
		
		JLabel DELETE = new JLabel("X");
		DELETE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//if(JOptionPane.show));
					FrameLogin.this.dispose();//dong cua so
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				DELETE.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				DELETE.setForeground(Color.WHITE);
			}
		});
		DELETE.setHorizontalAlignment(SwingConstants.CENTER);
		DELETE.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		DELETE.setForeground(Color.WHITE);
		DELETE.setBounds(580, 0, 20, 20);
		contentPane.add(DELETE);
		
		JLabel Logo = new JLabel("");
		Logo.setHorizontalAlignment(SwingConstants.CENTER);
		Logo.setBounds(170, 11, 242, 133);
		contentPane.add(Logo);
		Logo.setIcon(new ImageIcon(img_logo));
		
		lblMess.setForeground(new Color(255, 0, 0));
		lblMess.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblMess.setBounds(170, 257, 242, 14);
		contentPane.add(lblMess);
		setLocationRelativeTo(null);
	}
}
