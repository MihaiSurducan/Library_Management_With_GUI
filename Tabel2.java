import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_Autori;
import Controller.Controller_Carti;
import Controller.Controller_Editura;
import Model.Carte;
import Repository.RepoAutori;
import Repository.RepoCarti;
import Repository.RepoEdituri;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class Tabel2 extends JFrame {

	RepoCarti repo_carti = new RepoCarti("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Carti.txt");
    private  Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);
    
    RepoEdituri repo_edituri = new RepoEdituri("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Editura.txt");
    private  Controller_Editura ctrl_edituri = new Controller_Editura(repo_edituri);
    
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Tabel2 frame = new Tabel2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Tabel2() {
		initialize("");
	}
	
	public Tabel2(String numeEditura) {
		initialize(numeEditura);
	}
	
	public void initialize(String numeEditura) {
		setTitle("TABEL Carti de la o Editura");
		ctrl_carti.readFromFile_Carti();
		ctrl_edituri.readFromFile_Edituri();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		
		String nume = numeEditura;
        List<Carte> listCartiEditura = new ArrayList<>();
		listCartiEditura = afisCartiEditura(ctrl_carti.getAll(),numeEditura);
		
		String[] columnNames = 
				{"ID",
                "Titlu",
                "Autor",
                "An",
                "Pret",
                "Editura",
                "Cota"};
		
		Object[][] data = new Object[listCartiEditura.size()+1][8];
			
		data[0][0] = "ID";
		data[0][1] = "Titlu";
		data[0][2] = "Autor";
		data[0][3] = "An";
		data[0][4] = "Pret";
		data[0][5] = "Editura";
		data[0][6] = "Cota";
		
		for (int i = 1; i < listCartiEditura.size()+1; i++) {
				data[i][0] = listCartiEditura.get(i-1).getId();
				data[i][1] = listCartiEditura.get(i-1).getTitlu();
				data[i][2] = listCartiEditura.get(i-1).getNumeAutor();
				data[i][3] = listCartiEditura.get(i-1).getAn();
				data[i][4] = listCartiEditura.get(i-1).getPret();
				data[i][5] = listCartiEditura.get(i-1).getEditura();
				data[i][6] = listCartiEditura.get(i-1).getCota();
		}
		
		table_1 = new JTable(data,columnNames);
		//table_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table_1.setBackground(new Color(224, 255, 255));
		contentPane.add(table_1, BorderLayout.CENTER);
	}
	
    public static List<Carte> afisCartiEditura(List<Carte> cartiList, String numeEditura) {
    	List<Carte> listCarti = new ArrayList<>();
        for (int i = 0; i < cartiList.size(); i++) {
                if (numeEditura.contains(cartiList.get(i).getEditura())) {
                    listCarti.add(cartiList.get(i));
                }
        }
        
       return listCarti;   
    }
    
    
}