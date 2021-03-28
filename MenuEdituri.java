import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.border.TitledBorder;

import Controller.Controller_Autori;
import Controller.Controller_Editura;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class MenuEdituri extends JFrame {

    private Controller_Editura ctrl_edituri;
	Image image = null;
	private JPanel contentPane;
	private JTextField txtEdituri;
	private ShowEdituri showEdituri = new ShowEdituri();
	private AddEditura addEditura = new AddEditura();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEdituri frame = new MenuEdituri();
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
	public MenuEdituri() {
		
		try 
    	{
			image = ImageIO.read(new File("C:\\Users\\surdu\\eclipse-workspace\\lab5\\src\\poza4.jpg"));
		}
	catch (IOException e)
    	{
			e.printStackTrace();
		}
		
		setTitle("Edituri");
		setResizable(false);
		setBounds(100, 100, 697, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEdituri = new JTextField();
		txtEdituri.setText("Edituri");
		txtEdituri.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdituri.setFont(new Font("Pristina", Font.BOLD, 39));
		txtEdituri.setEditable(false);
		txtEdituri.setColumns(10);
		txtEdituri.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtEdituri.setBackground(SystemColor.activeCaption);
		txtEdituri.setBounds(257, 77, 157, 54);
		contentPane.add(txtEdituri);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 470, 81, 40);
		contentPane.add(btnNewButton_1);
		JPanel j = new JPanelWithBackground(image);
		j.setBounds(0, 0, 690, 520);
		contentPane.add(j);
		j.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("2.Afisare");
		btnNewButton_3.setBounds(224, 319, 230, 54);
		j.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showEdituri.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(250, 250, 210));
		btnNewButton_3.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		
		JButton btnNewButton_3_1 = new JButton("1.Adauga");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addEditura.setVisible(true);
			}
		});
		btnNewButton_3_1.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		btnNewButton_3_1.setBackground(new Color(250, 250, 210));
		btnNewButton_3_1.setBounds(224, 232, 230, 54);
		j.add(btnNewButton_3_1);
	}

	public MenuEdituri(Controller_Editura ctrl_edituri2) {
		this.ctrl_edituri = ctrl_edituri2;
	}

}
