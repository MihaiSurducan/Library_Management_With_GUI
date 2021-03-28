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

import Controller.Controller_Editura;
import Controller.Controller_Carti;
import Model.Carte;
import Repository.RepoEdituri;
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

public class TableCartiEditura extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnNewButton;
	private Tabel2 tabel2 = new Tabel2("");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableCartiEditura frame = new TableCartiEditura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TableCartiEditura() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		String[] string= {"Edituri:","Corint","Humanitas","Gama","Economica","Litera","Tineretului","Academia Romana"};
        JComboBox comboBox = new JComboBox(string);
        comboBox.setSelectedIndex(0);     

		
        getContentPane().add(comboBox);
		
		
		comboBox.setEditable(true);
		contentPane.add(comboBox, BorderLayout.NORTH);
		
		btnNewButton = new JButton("Afiseaza tabel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nume = comboBox.getSelectedItem().toString();
				new Tabel2(nume).setVisible(true);
;			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, Color.PINK, null, Color.CYAN, null));
		btnNewButton.setMargin(new Insets(20, 140, 20, 140));
		btnNewButton.setSize(new Dimension(30, 30));
		contentPane.add(btnNewButton, BorderLayout.CENTER);
		
	}
	

}

