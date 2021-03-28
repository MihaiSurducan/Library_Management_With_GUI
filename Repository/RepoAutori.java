package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Model.Autor;
import java.util.Scanner;

public class RepoAutori {
    private List<Autor> autoriList;
    private String fileName;

    //constructor implicit

    public RepoAutori(String fileName) {
        this.fileName = fileName;
        autoriList = new ArrayList<>();
    }

    public RepoAutori(List<Autor> autoriList, String fileName) {
        this.autoriList = autoriList;
        this.fileName = fileName;
    }

    public int getSize() {
        return autoriList.size();
    }

    public void readFromFile_Autori() {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            autoriList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String string_id_autor = components[0].trim();
                String nume_autor = components[1];
                int id = Integer.parseInt(string_id_autor);
                Autor autor = new Autor(id,nume_autor);
                autoriList.add(autor);
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

        for (int i = 0; i < autoriList.size(); i++) {
            bw.write(autoriList.get(i).toStringForWriteToFile());
            bw.newLine();
        }
        bw.close();
    }

    public int searchByIdAutor(int id) {
        for (int i = 0; i < autoriList.size(); i++) {
            if (autoriList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void addAutor(Autor a) throws Exception {
        int position = searchByIdAutor(a.getId());
        if (position == -1)
        {
            autoriList.add(a);
            writeToFile();
        } else
            throw new Exception("Autorul exista deja !");
    }
    
    public void updateAutor(Autor a) throws Exception {
        int position = searchByIdAutor(a.getId());
        if (position == -1) {
            throw new Exception("Autorul nu exista!");
        } else {
            autoriList.set(position, a);
            writeToFile();
        }
    }
    
    public void schimbareAutori(Autor a, Autor b) throws Exception {
        int positionA = searchByIdAutor(a.getId());
        int positionB = searchByIdAutor(b.getId());
        
        autoriList.set(positionA, b);
        autoriList.set(positionB, a);        
    }

    public List<Autor> getAll() {
        return autoriList;
    }

    public Autor getAutor(int position) {
        return autoriList.get(position);
    }
}