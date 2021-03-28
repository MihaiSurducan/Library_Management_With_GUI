import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Autori;
import Controller.Controller_Carti;
import Model.Autor;
import Model.Carte;
import Repository.RepoAutori;
import Repository.RepoCarti;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class ShowCarti extends JFrame {
	
	RepoCarti repo_carti = new RepoCarti("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Carti.txt");
    private  Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);

	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowCarti frame = new ShowCarti();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowCarti() {
		setTitle("Afisare carti");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ctrl_carti.readFromFile_Carti();
        List<Carte> listCarti = new ArrayList<>();
		listCarti = ctrl_carti.getAll();
		
		String[] columnNames = 
				{"ID",
                "Titlu","Nume autor",
                "An","Pret","Editura",
                "Cota"};
		
		Object[][] data = new Object[listCarti.size()+1][7];
		
		data[0][0] = "ID";
		data[0][1] = "Titlu";
		data[0][2] = "Nume autor";
		data[0][3] = "An";
		data[0][4] = "Pret";
		data[0][5] = "Editura";
		data[0][6] = "Cota";
		
		for (int i = 1; i < listCarti.size()+1; i++) {
				data[i][0] = listCarti.get(i-1).getId();
				data[i][1] = listCarti.get(i-1).getTitlu();
				data[i][2] = listCarti.get(i-1).getNumeAutor();
				data[i][3] = listCarti.get(i-1).getAn();
				data[i][4] = listCarti.get(i-1).getPret();
				data[i][5] = listCarti.get(i-1).getEditura();
				data[i][6] = listCarti.get(i-1).getCota();
		}
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table.setBackground(new Color(224, 255, 255));
		contentPane.add(table, BorderLayout.CENTER);	
	}

}
