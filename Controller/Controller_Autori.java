package Controller;

import Model.Autor;
import Repository.RepoAutori;

import java.util.*;

public class Controller_Autori {
    private RepoAutori repo;

    public Controller_Autori(RepoAutori repo) {
        this.repo = repo;
    }

    public void readFromFile_Autori() {
        repo.readFromFile_Autori();
    }

    public void addAutor(int id, String nume_autor) {
    	Autor autor = new Autor(id,nume_autor);
    	try {
            repo.addAutor(autor);
            System.out.println("Autorul a fost adaugat!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Autor> getAll() {
        return repo.getAll();
    }
    
    public void updateAutor(int id, String nume_autor) {
    	Autor autor = new Autor(id,nume_autor);
    	try {
            repo.updateAutor(autor);
            System.out.println("Autorul a fost actualizata!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
}