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

import Controller.Controller_Carti;
import Controller.Controller_Editura;
import Model.Autor;
import Model.Editura;
import Repository.RepoCarti;
import Repository.RepoEdituri;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class ShowEdituri extends JFrame {

	RepoEdituri repo_edituri = new RepoEdituri("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Editura.txt");
    private  Controller_Editura ctrl_edituri = new Controller_Editura(repo_edituri);
    
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowEdituri frame = new ShowEdituri();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ShowEdituri() {
		setTitle("Afisare edituri");
		setBounds(100, 100, 820, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ctrl_edituri.readFromFile_Edituri();
        List<Editura> listEdituri = new ArrayList<>();
		listEdituri = ctrl_edituri.getAll();
		
		String[] columnNames = 
				{"ID",
                "Nume"};
		
		Object[][] data = new Object[listEdituri.size()+1][4];
		
		data[0][0] = "ID";
		data[0][1] = "Nume";
		
		for (int i = 1; i < listEdituri.size()+1; i++) {
				data[i][0] = listEdituri.get(i-1).getId();
				data[i][1] = listEdituri.get(i-1).getNume();
		}
		
		table = new JTable(data,columnNames);
		table.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		table.setBackground(new Color(224, 255, 255));
		contentPane.add(table, BorderLayout.CENTER);	
	}

}