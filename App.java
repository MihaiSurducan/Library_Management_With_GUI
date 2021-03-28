import Repository.*;
import Controller.*;
import UI.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class App {
	public static void main(String[] args) {
	RepoCarti repo_carti = new RepoCarti("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Carti.txt");
    RepoAutori repo_autori = new RepoAutori("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Autori.txt");
    RepoEdituri repo_edituri = new RepoEdituri("C:\\Users\\surdu\\eclipse-workspace\\Lab5\\src\\Editura.txt");
    Controller_Carti ctrl_carti = new Controller_Carti(repo_carti);
    Controller_Autori ctrl_autori = new Controller_Autori(repo_autori);
    Controller_Editura ctrl_edituri = new Controller_Editura(repo_edituri);
    UI ui = new UI(ctrl_carti, ctrl_autori, ctrl_edituri);
    ui.runApp();
	}
}