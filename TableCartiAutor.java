import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class TableCartiAutor extends JFrame {

	
	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private Tabel1 tabel1 = new Tabel1("Popa Anca");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableCartiAutor frame = new TableCartiAutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TableCartiAutor() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] string= {"Autori:","1.Ion Creanga","2.Alvin Toffler","3.Mihai Eminescu","4.Vasile Alecsandri","5.Liviu Rebreanu","6.Lucian Blaga","7.Tudor Arghezi"};
        JComboBox comboBox = new JComboBox(string);
        comboBox.setSelectedIndex(0);
        getContentPane().add(comboBox);
		
		comboBox.setEditable(true);
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		btnNewButton = new JButton("Afiseaza tabel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nume = comboBox.getSelectedItem().toString();
				new Tabel1(nume).setVisible(true);
;			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.PINK, null, Color.CYAN, null));
		btnNewButton.setMargin(new Insets(20, 140, 20, 140));
		btnNewButton.setSize(new Dimension(30, 30));
		contentPane.add(btnNewButton, BorderLayout.CENTER);
		
	}
	
	
	
	/*
    Descriere: citeste un string
    Input: String sir
    Output: String
     */

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
