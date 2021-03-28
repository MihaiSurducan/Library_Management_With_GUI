package UI;

import Controller.*;
import View.*;

import java.io.*;


public class UI {
    private Controller_Carti ctrl_carti;
    private Controller_Autori ctrl_autori;
    private Controller_Editura ctrl_edituri;
    
    public void runApp() {
        MeniuPrincipal();
        String option_principal = ReadString("Introduceti optiunea dorita: ");
        String out_option = new String("X");
        while (!(option_principal.equals(out_option))) {
            switch (option_principal) {
                case "A":
                    runCarti();
                    break;
                case "B":
                    runAutori();
                    break;
                case "C":
                    runEdituri();
                    break;
                case "T":
                    runTabel();
                    break;
                case "X":
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            MeniuPrincipal();
            option_principal = ReadString("Introduceti optiunea dorita: ");
        }
        System.out.println("Program terminat!");
    }
    
    


    public UI(Controller_Carti ctrl_carti, Controller_Autori ctrl_autori,Controller_Editura ctrl_edituri) {
        this.ctrl_carti = ctrl_carti;
        this.ctrl_autori = ctrl_autori;
        this.ctrl_edituri = ctrl_edituri;
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
    
    public double ReadDoubleNumber(String sir) {
        System.out.println(sir);
        double n = -1;
        while (n < 0) {
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader buff = new BufferedReader(reader);
            try {
                String text = buff.readLine();
                n = Double.parseDouble(text);
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

    public void MeniuPrincipal() {
        System.out.println("---------- MENIU PRINCIPAL ----------");
        System.out.println("            A. Carti");
        System.out.println("            B. Autori");
        System.out.println("            C. Edituri");;
        System.out.println("            T. Tabele");
        System.out.println("            X. Exit");
        System.out.println("-------------------------------------");
    }

    public void DisplayMenu_Carti() {
        System.out.println("--------------- MENU ----------------");
        System.out.println("            1. Add carte");
        System.out.println("            2. Update carte");
        System.out.println("            3. Delete carte");
        System.out.println("            4. Afisare carti");
        System.out.println("            0. Back");
        System.out.println("-------------------------------------");
    }

    public void DisplayMenu_Autori() {
        System.out.println("--------------- MENU ----------------");
        System.out.println("            1. Add autor");
        System.out.println("            2. Afisare autori");
        System.out.println("            0. Back");
        System.out.println("-------------------------------------");
    }
    
    public void DisplayMenu_Edituri() {
        System.out.println("--------------- MENU ----------------");
        System.out.println("            1. Add editura");
        System.out.println("            2. Afisare edituri");
        System.out.println("            0. Back");
        System.out.println("-------------------------------------");
    }

    public void DisplayMenu_Tabel() {
        System.out.println("--------------------------------- MENU ---------------------------------");
        System.out.println("1. Tabel cu toate cartile unui autor dat");
        System.out.println("2. Tabel cu toate cartile aparute la o anumita editura");
        System.out.println("0. Back");
        System.out.println("------------------------------------------------------------------------");
    }
    
    public void runCarti() {
        DisplayMenu_Carti();
        int option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        ctrl_carti.readFromFile_Carti();
        while (option != 0) {
            switch (option) {
                case 1:
                    int id = ReadNaturalNumber("Introduceti id-ul cartii: ");
                    String titlu = ReadString("Introduceti titlul cartii: ");
                    String nume = ReadString("Introduceti numele autorului: ");
                    int an = ReadNaturalNumber("Introduceti anul aparitiei: ");
                    double pret = ReadDoubleNumber("Introduceti pretul carti: ");
                    String editura = ReadString("Introduceti editura: ");
                    String cota = ReadString("Introduceti cota: ");
                    try {
                        ctrl_carti.addCarte(id,titlu,nume,an,pret,editura,cota);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    int idCarte = ReadNaturalNumber("Introduceti id-ul cartii de actualizat: ");
                    if (ctrl_carti.searchByIdCarte(idCarte)) {
                    	String titlu_nou = ReadString("Introduceti titlul cartii: ");
                        String nume_nou = ReadString("Introduceti numele autorului: ");
                        int an_nou = ReadNaturalNumber("Introduceti anul aparitiei: ");
                        double pret_nou= ReadDoubleNumber("Introduceti pretul carti: ");
                        String editura_noua = ReadString("Introduceti editura: ");
                        String cota_noua = ReadString("Introduceti cota: ");
                        if (titlu_nou.equals("")) {
                            titlu_nou = ctrl_carti.searchByIdCarte_Obiect(idCarte).getTitlu();
                        }
                        if (nume_nou.equals("")) {
                            nume_nou = ctrl_carti.searchByIdCarte_Obiect(idCarte).getNumeAutor();
                        }
                        if (editura_noua.equals("")) {
                            editura_noua = ctrl_carti.searchByIdCarte_Obiect(idCarte).getEditura();
                        }
                        if (pret_nou == 0) {
                            pret_nou = ctrl_carti.searchByIdCarte_Obiect(idCarte).getPret();
                        }
                        if (cota_noua.equals("")) {
                            cota_noua = ctrl_carti.searchByIdCarte_Obiect(idCarte).getCota();
                        }
                        if (an_nou == 0) {
                        	an_nou = ctrl_carti.searchByIdCarte_Obiect(idCarte).getAn();
                        }
                        ctrl_carti.updateCarte(idCarte,titlu_nou,nume_nou,an_nou,pret_nou,editura_noua,cota_noua);
                    } else {
                        System.out.println("Nu exista id-ul introdus! ");
                    }
                    break;
                case 3:
                    int idCarte1 = ReadNaturalNumber("Introduceti id-ul cartii de sters: ");
                    try {

                        if (ctrl_carti.searchByIdCarte(idCarte1)) {
                            ctrl_carti.deleteCarte(idCarte1);
                        }
                        else {
                            System.out.println("Nu exista id-ul introdus! ");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    CapTabel.afisCarti_total_sus();
                    CorpTabel.afisCarti_total(ctrl_carti.getAll());
                    CapTabel.afisCarti_total_jos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            DisplayMenu_Carti();
            option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        }
    }

    public void runAutori() {
        DisplayMenu_Autori();
        int option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        ctrl_autori.readFromFile_Autori();
        while (option != 0) {
            switch (option) {
            	case 1:
	                int id = ReadNaturalNumber("Introduceti id-ul autorului: ");
	                String nume = ReadString("Introduceti numele autorului: ");
	                try {
	                    ctrl_autori.addAutor(id, nume);
	                } catch (Exception e) {
	                    e.getMessage();
	                }
	                break;
                case 2:
                    CapTabel.afisAutori_total_sus();
                    CorpTabel.afisAutori_total(ctrl_autori.getAll());
                    CapTabel.afisAutori_total_jos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            DisplayMenu_Autori();
            option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        }
    }
    
    public void runEdituri() {
        DisplayMenu_Edituri();
        int option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        ctrl_edituri.readFromFile_Edituri();
        while (option != 0) {
            switch (option) {
            	case 1:
	                int id = ReadNaturalNumber("Introduceti id-ul editurii: ");
	                String nume = ReadString("Introduceti numele editurii: ");
	                try {
	                    ctrl_edituri.addEditura(id, nume);
	                } catch (Exception e) {
	                    e.getMessage();
	                }
	                break;
                case 2:
                    CapTabel.afisEdituri_total_sus();
                    CorpTabel.afisEdituri_total(ctrl_edituri.getAll());
                    CapTabel.afisEdituri_total_jos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            DisplayMenu_Edituri();
            option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        }
    }
    
    
    

    public void runTabel() {
        DisplayMenu_Tabel();
        int option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        ctrl_carti.readFromFile_Carti();
        ctrl_autori.readFromFile_Autori();
        
        ctrl_edituri.readFromFile_Edituri();
        
        while (option != 0) {
            switch (option) {
                case 1:
                	String numeAutor = ReadString("Introduceti numele autorului: ");
                    CapTabel.afisCartiAutor_sus();
                    CorpTabel.afisCartiAutor(ctrl_carti.getAll(), numeAutor);
                    CapTabel.afisCartiAutor_jos();
                    break;
                case 2:
                	String numeEditura = ReadString("Introduceti numele editurii: ");
                    CapTabel.afisCartiEditura_sus();
                    CorpTabel.afisCartiEditura(ctrl_carti.getAll(), numeEditura);
                    CapTabel.afisCartiEditura_jos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;
            }
            DisplayMenu_Tabel();
            option = ReadNaturalNumber("Introduceti optiunea dorita: ");
        }
    }
}

