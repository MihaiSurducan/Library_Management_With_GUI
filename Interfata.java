import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;


import Controller.Controller_Autori;
import Controller.Controller_Carti;
import Controller.Controller_Editura;
import Repository.RepoCarti;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;


public class Interfata extends JFrame{

	private MenuCarti menuCarti = new MenuCarti();
	private MenuAutori menuAutori = new MenuAutori();
	private MenuEdituri menuEdituri = new MenuEdituri();
	private MenuTabele menuTabele = new MenuTabele();
	private JFrame frmBiblioteca;
	Image image = null;
	private JTextField txtBiblioteca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfata window = new Interfata();
					window.frmBiblioteca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfata() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmBiblioteca = new JFrame();
		frmBiblioteca.setResizable(false);
		
		try 
        	{
				image = ImageIO.read(new File("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\poza2.jpg"));
			}
		catch (IOException e)
        	{
				e.printStackTrace();
			}
		
		frmBiblioteca.setVisible(true); 
		
		
		frmBiblioteca.getContentPane().setEnabled(false);
		frmBiblioteca.setTitle("Biblioteca");
		frmBiblioteca.setBounds(100, 100, 700, 531);
		frmBiblioteca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBiblioteca.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "JPanel title", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(-6, -16, 685, 528);
		frmBiblioteca.getContentPane().add(panel);
		panel.setLayout(null);
		JPanel j = new JPanelWithBackground(image);
		j.setBounds(6, 16, 696, 501);
		panel.add(j);
		j.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("TABELE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuTabele.setVisible(true);
			}
		});
		btnNewButton_4.setForeground(Color.BLACK);
		btnNewButton_4.setBackground(new Color(255, 239, 213));
		btnNewButton_4.setFont(new Font("Ravie", Font.PLAIN, 15));
		btnNewButton_4.setBounds(281, 391, 119, 49);
		j.add(btnNewButton_4);
		
		
		JButton btnNewButton = new JButton("Carti");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuCarti.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 239, 213));
		btnNewButton.setFont(new Font("Ravie", Font.PLAIN, 15));
		btnNewButton.setBounds(169, 169, 108, 49);
		j.add(btnNewButton);
		
		
		JButton btnNewButton_2 = new JButton("Edituri");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuEdituri.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(255, 239, 213));
		btnNewButton_2.setFont(new Font("Ravie", Font.PLAIN, 15));
		btnNewButton_2.setBounds(158, 283, 130, 49);
		j.add(btnNewButton_2);
		
		
		JButton btnNewButton_1 = new JButton("Autori");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuAutori.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 239, 213));
		btnNewButton_1.setFont(new Font("Ravie", Font.PLAIN, 15));
		btnNewButton_1.setBounds(398, 169, 108, 49);
		j.add(btnNewButton_1);
		
		txtBiblioteca = new JTextField();
		txtBiblioteca.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtBiblioteca.setEditable(false);
		txtBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		txtBiblioteca.setBackground(SystemColor.activeCaption);
		txtBiblioteca.setFont(new Font("Pristina", Font.BOLD, 39));
		txtBiblioteca.setText("Biblioteca");
		txtBiblioteca.setBounds(255, 55, 157, 54);
		j.add(txtBiblioteca);
		txtBiblioteca.setColumns(10);
	}
	
	
}
