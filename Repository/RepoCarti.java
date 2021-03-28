package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Model.Carte;
import java.util.Scanner;

public class RepoCarti {
    private List<Carte> cartiList;
    private String fileName;

    public RepoCarti(String fileName) {
        this.fileName = fileName;
        cartiList = new ArrayList<>();
    }

    public RepoCarti(List<Carte> cartiList, String fileName) {
        this.cartiList = cartiList;
        this.fileName = fileName;
    }
    
    public int getSize() {
        return cartiList.size();
    }

    public void readFromFile_Carti() {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            cartiList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String string_id_carte = components[0].trim();
                String titlu = components[1].trim();
                String nume_autor = components[2].trim();
                String string_an = components[3].trim();
                String string_pret = components[4].trim();
                String editura = components[5].trim();
                String cota = components[6].trim();
                int an = Integer.parseInt(string_an);
                int id = Integer.parseInt(string_id_carte);
                double pret = Double.parseDouble(string_pret);
                Carte carte = new Carte(id,titlu,nume_autor,an,pret,editura,cota);
                cartiList.add(carte);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Eroare in citirea din fisier!");
        }
    }

    public void writeToFile() throws IOException {
        File fileOutput = new File(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutput);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        for (int i = 0; i < cartiList.size(); i++) {
            bw.write(cartiList.get(i).toStringForWriteToFile());
            bw.newLine();
        }
        bw.close();
    }

    public int searchByIdCarte(int id) {
        for (int i = 0; i < cartiList.size(); i++) {
            if (cartiList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void addCarte(Carte a) throws Exception {
        int position = searchByIdCarte(a.getId());
        if (position == -1)
        {
            cartiList.add(a);
            writeToFile();
        } else
            throw new Exception("Cartea exista deja !");
    }
    
    public void updateCarte(Carte a) throws Exception {
        int position = searchByIdCarte(a.getId());
        if (position == -1) {
            throw new Exception("Cartea nu exista!");
        } else {
            cartiList.set(position, a);
            writeToFile();
        }
    }

    public void deleteCarte(Carte a) throws Exception {
        int position = searchByIdCarte(a.getId());
        if (position == -1) {
            throw new Exception("Cartea nu exista!");
        } else {
            cartiList.remove(position);
            writeToFile();
        }
    }

    public List<Carte> getAll() {
        return cartiList;
    }

    public Carte getCarte(int position) {
        return cartiList.get(position);
    }
}