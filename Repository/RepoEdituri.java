package Repository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import Model.Editura;
import java.util.Scanner;

public class RepoEdituri {
    private List<Editura> edituriList;
    private String fileName;

    public RepoEdituri(String fileName) {
        this.fileName = fileName;
        edituriList = new ArrayList<>();
    }

    public RepoEdituri(List<Editura> edituriList, String fileName) {
        this.edituriList = edituriList;
        this.fileName = fileName;
    }

    public int getSize() {
        return edituriList.size();
    }

    public void readFromFile_Edituri() {
        try {
            FileInputStream fileInput = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            edituriList.clear();
            while ((line = br.readLine()) != null) {
                String components[] = line.split(",");
                String string_id_editura = components[0].trim();
                String nume = components[1].trim();
                int id = Integer.parseInt(string_id_editura);
                Editura editura = new Editura(id,nume);
                edituriList.add(editura);
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

        for (int i = 0; i < edituriList.size(); i++) {
            bw.write(edituriList.get(i).toStringForWriteToFile());
            bw.newLine();
        }
        bw.close();
    }

    public int searchByIdEditura(int id) {
        for (int i = 0; i < edituriList.size(); i++) {
            if (edituriList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
   
    public void addEditura(Editura a) throws Exception {
        int position = searchByIdEditura(a.getId());
        if (position == -1)
        {
            edituriList.add(a);
            writeToFile();
        } else
            throw new Exception("Editura exista deja !");
    }

    public void updateEditura(Editura a) throws Exception {
        int position = searchByIdEditura(a.getId());
        if (position == -1) {
            throw new Exception("Editura nu exista!");
        } else {
            edituriList.set(position, a);
            writeToFile();
        }
    }

    public void deleteEditura(Editura a) throws Exception {
        int position = searchByIdEditura(a.getId());
        if (position == -1) {
            throw new Exception("Editura nu exista!");
        } else {
            edituriList.remove(position);
            writeToFile();
        }
    }

    public List<Editura> getAll() {
        return edituriList;
    }

    public Editura getEditura(int position) {
        return edituriList.get(position);
    }
}