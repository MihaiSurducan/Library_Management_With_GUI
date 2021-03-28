import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Autori;
import Controller.Controller_Carti;
import Model.Carte;
import Repository.RepoAutori;
import Repository.RepoCarti;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

public class Tabel1 extends JFrame {

	RepoCarti repo_carti = new RepoCarti("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Carti.txt");
    private  Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);
    
    RepoAutori repo_autori = new RepoAutori("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Autori.txt");
    private  Controller_Autori ctrl_autori = new Controller_Autori(repo_autori);
    
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Tabel1 frame = new Tabel1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Tabel1() {
		initialize("");
	}

	/**
	 * Create the frame.
	 */
	public Tabel1(String numeAutor) {
		initialize(numeAutor);
	}
	
	public void initialize(String numeAutor) {
		setTitle("TABEL Carti de la un Autor");
		ctrl_carti.readFromFile_Carti();
		ctrl_autori.readFromFile_Autori();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		//contentPane.add(table, BorderLayout.CENTER);
		String nume = numeAutor;
        List<Carte> listCartiAutor = new ArrayList<>();
		listCartiAutor = afisCartiAutor(ctrl_carti.getAll(),numeAutor);
		
		String[] columnNames = 
				{"ID",
                "Titlu",
                "Autor",
                "An",
                "Pret",
                "Editura",
                "Cota"};
		
		Object[][] data = new Object[listCartiAutor.size()+1][8];
		
		data[0][0] = "ID";
		data[0][1] = "Titlu";
		data[0][2] = "Autor";
		data[0][3] = "An";
		data[0][4] = "Pret";
		data[0][5] = "Editura";
		data[0][6] = "Cota";
		
		for (int i = 1; i < listCartiAutor.size()+1; i++) {
				data[i][0] = listCartiAutor.get(i-1).getId();
				data[i][1] = listCartiAutor.get(i-1).getTitlu();
				data[i][2] = listCartiAutor.get(i-1).getNumeAutor();
				data[i][3] = listCartiAutor.get(i-1).getAn();
				data[i][4] = listCartiAutor.get(i-1).getPret();
				data[i][5] = listCartiAutor.get(i-1).getEditura();
				data[i][6] = listCartiAutor.get(i-1).getCota();
		}
		
		table_1 = new JTable(data,columnNames);
		table_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table_1.setBackground(new Color(224, 255, 255));
		contentPane.add(table_1, BorderLayout.CENTER);
	}
	
    public static List<Carte> afisCartiAutor(List<Carte> cartiList, String numeAutor) {
    	List<Carte> listCarti = new ArrayList<>();
        for (int i = 0; i < cartiList.size(); i++) {
                if (numeAutor.contains(cartiList.get(i).getNumeAutor())) {
                    listCarti.add(cartiList.get(i));
                }
        }
        
       return listCarti;   
    }  
}
