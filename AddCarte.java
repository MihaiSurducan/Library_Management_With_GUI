import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Carti;
import Repository.RepoCarti;

import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCarte extends JFrame {
	
	RepoCarti repo_carti = new RepoCarti("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Carti.txt");
    private  Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	Image image = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCarte frame = new AddCarte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddCarte() {
		
		try 
    	{
			image = ImageIO.read(new File("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\poza5.jpg"));
		}
	catch (IOException e)
    	{
			e.printStackTrace();
		}
		
		setTitle("Adaugare carte");
		setBounds(100, 100, 453, 559);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnIntroducetiDatelePentru = new JTextPane();
		txtpnIntroducetiDatelePentru.setBackground(new Color(224, 255, 255));
		txtpnIntroducetiDatelePentru.setFont(new Font("Sitka Small", Font.PLAIN, 19));
		txtpnIntroducetiDatelePentru.setBounds(49, 5, 361, 44);
		txtpnIntroducetiDatelePentru.setText("Introduceti datele pentru adaugare:");
		txtpnIntroducetiDatelePentru.setEditable(false);
		contentPane.add(txtpnIntroducetiDatelePentru);
		
		JTextPane txtpnId = new JTextPane();
		txtpnId.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		txtpnId.setText("ID:");
		txtpnId.setBounds(103, 85, 51, 28);
		contentPane.add(txtpnId);
		
		JTextPane txtpnTitlu = new JTextPane();
		txtpnTitlu.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnTitlu.setText("Titlu:");
		txtpnTitlu.setBounds(103, 124, 51, 28);
		contentPane.add(txtpnTitlu);
		
		JTextPane txtpnAutor = new JTextPane();
		txtpnAutor.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnAutor.setText("Autor:");
		txtpnAutor.setBounds(103, 175, 51, 28);
		contentPane.add(txtpnAutor);
		
		JTextPane txtpnAn = new JTextPane();
		txtpnAn.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnAn.setText("An:");
		txtpnAn.setBounds(103, 221, 51, 28);
		contentPane.add(txtpnAn);
		
		JTextPane txtpnPret = new JTextPane();
		txtpnPret.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnPret.setText("Pret:");
		txtpnPret.setBounds(103, 324, 81, 32);
		contentPane.add(txtpnPret);
		
		JTextPane txtpnEditura = new JTextPane();
		txtpnEditura.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnEditura.setText("Editura:");
		txtpnEditura.setBounds(103, 270, 66, 28);
		contentPane.add(txtpnEditura);
				
		JTextPane txtpnCota = new JTextPane();
		txtpnCota.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		txtpnCota.setText("Cota:");
		txtpnCota.setBounds(103, 377, 51, 28);
		contentPane.add(txtpnCota);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(212, 93, 96, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(212, 132, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(212, 183, 96, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(212, 229, 96, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(212, 278, 96, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(212, 324, 96, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(212, 377, 96, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int id = Integer.parseInt(textField.getText());
		        String titlu = textField_1.getText();
		        String nume = textField_2.getText();
		        int an = Integer.parseInt(textField_3.getText());
		        double pret = Double.parseDouble(textField_4.getText());
		        String editura = textField_5.getText();
		        String cota = textField_6.getText();
                try {
                    ctrl_carti.addCarte(id,titlu,nume,an,pret,editura,cota);
                } catch (Exception e) {
                	e.getMessage();
                }
                
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 19));
		btnNewButton.setBounds(167, 436, 89, 44);
		contentPane.add(btnNewButton);
		
		
	}
	
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
	
}
