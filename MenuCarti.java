import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

import Controller.Controller_Carti;
import Model.Carte;
import Repository.RepoCarti;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JDesktopPane;
import java.awt.ScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class MenuCarti extends JFrame {
	
	RepoCarti repo_carti = new RepoCarti("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Carti.txt");
    private Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);
	private JPanel contentPane;
	private JTextField txtCarti;
	Image image = null;
	static MenuCarti frame = new MenuCarti();
	private AddCarte addCarte = new AddCarte();
	private ShowCarti showCarti = new ShowCarti();
	JTextArea textarea2;
	JTextField text2;
    private final static String newline = "\n";

    public int ReadNaturalNumber(String sir) {
        System.out.println(sir);
        int n = -1;
        while (n < 0) {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader buff = new BufferedReader(reader);
            try {
                String text = buff.readLine();
                n = Integer.parseInt(text);
                if (n < 0)
                    System.out.println("Introduceti un numar mai mare ca 0!");
            } catch (IOException e) {

                System.out.println("Introduceti un numar pozitiv" + e.getMessage());
            } catch (NumberFormatException ex) {

                System.out.println("Introduceti un numar pozitiv" + ex.getMessage());
            }
        }
        return n;
    }

    public String ReadString(String sir) {
        System.out.println(sir);
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(reader);
        String text = "";
        try {
            text = buff.readLine();
        } catch (IOException e) {

            System.out.println("Eroare la citire!" + e.getMessage());
        }
        return text;
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//MenuCarti frame = new MenuCarti();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuCarti() {
		try 
    	{
			image = ImageIO.read(new File("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\poza3.jpg"));
		}
	catch (IOException e)
    	{
			e.printStackTrace();
		}
				
		ctrl_carti.readFromFile_Carti();
		
		setTitle("Carti");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCarti = new JTextField();
		txtCarti.setText("Carti");
		txtCarti.setHorizontalAlignment(SwingConstants.CENTER);
		txtCarti.setFont(new Font("Pristina", Font.BOLD, 39));
		txtCarti.setEditable(false);
		txtCarti.setColumns(10);
		txtCarti.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtCarti.setBackground(SystemColor.activeCaption);
		txtCarti.setBounds(241, 40, 157, 54);
		contentPane.add(txtCarti);
		
		JPanel j = new JPanelWithBackground(image);
		j.setBounds(0, 0, 687, 508);
		contentPane.add(j);
		j.setLayout(null);
		JLabel lblNewLabel = new JLabel("Carti:");
		lblNewLabel.setBounds(463, 177, 176, 262);
		j.add(lblNewLabel);	
		
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); -->inchide tot
			}
		});
		
		
		btnNewButton_4.setBackground(new Color(176, 196, 222));
		btnNewButton_4.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		btnNewButton_4.setBounds(10, 457, 81, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("1.Adauga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCarte.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(250, 250, 210));
		btnNewButton.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		btnNewButton.setBounds(207, 135, 230, 54);
		contentPane.add(btnNewButton);
		
		JButton btnafisare = new JButton("2.Afisare");
		btnafisare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showCarti.setVisible(true);
			}
		});
		
		btnafisare.setBackground(new Color(250, 250, 210));
		btnafisare.setFont(new Font("Poor Richard", Font.PLAIN, 23));
		btnafisare.setBounds(207, 405, 230, 54);
		contentPane.add(btnafisare);

	}

	public MenuCarti(Controller_Carti ctrl_carti2) {
		this.ctrl_carti = ctrl_carti2;
	}
}