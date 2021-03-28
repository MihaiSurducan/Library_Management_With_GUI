import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.border.TitledBorder;

import Controller.Controller_Autori;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;

public class MenuAutori extends JFrame {

    private Controller_Autori ctrl_autori;
	Image image = null;
	private JPanel contentPane;
	private JTextField txtAutori;
	private ShowAutori showAutori = new ShowAutori();
	private AddAutor addAutor = new AddAutor();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAutori frame = new MenuAutori();
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
	public MenuAutori() {
		
		try 
    	{
			image = ImageIO.read(new File("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\poza2.jpg"));
		}
	catch (IOException e)
    	{
			e.printStackTrace();
		}
		
		setTitle("Autori");
		setResizable(false);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAutori = new JTextField();
		txtAutori.setText("Autori");
		txtAutori.setHorizontalAlignment(SwingConstants.CENTER);
		txtAutori.setFont(new Font("Pristina", Font.BOLD, 39));
		txtAutori.setEditable(false);
		txtAutori.setColumns(10);
		txtAutori.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtAutori.setBackground(SystemColor.activeCaption);
		txtAutori.setBounds(258, 73, 157, 54);
		contentPane.add(txtAutori);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 469, 81, 40);
		contentPane.add(btnNewButton);
		JPanel j = new JPanelWithBackground(image);
		j.setBounds(0, 0, 690, 520);
		contentPane.add(j);
		j.setLayout(null);
		
		JButton btnNewButton_3_1 = new JButton("2.Afisare");
		btnNewButton_3_1.setBounds(231, 328, 230, 54);
		j.add(btnNewButton_3_1);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAutori.setVisible(true);
			}
		});
		btnNewButton_3_1.setBackground(new Color(250, 250, 210));
		btnNewButton_3_1.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		
		JButton btnNewButton_3_1_1 = new JButton("1.Adauga");
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addAutor.setVisible(true);
			}
		});
		btnNewButton_3_1_1.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		btnNewButton_3_1_1.setBackground(new Color(250, 250, 210));
		btnNewButton_3_1_1.setBounds(231, 237, 230, 54);
		j.add(btnNewButton_3_1_1);
	}

	public MenuAutori(Controller_Autori ctrl_autori) {
		this.ctrl_autori = ctrl_autori;
	}
}
