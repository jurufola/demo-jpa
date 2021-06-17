package fr.diginamic.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "auteur")
    private String auteur;

    @ManyToMany
    @JoinTable(name = "compo", joinColumns = @JoinColumn(name = "id_liv", referencedColumnName = "id"),
                                inverseJoinColumns = @JoinColumn(name = "id_emp", referencedColumnName = "id"))
    private List<Emprunt> emprunts;

    public Livre() {

    }

    public Livre(String titre, String auteur, List<Emprunt> emprunts) {
        this.titre = titre;
        this.auteur = auteur;
        this.emprunts = emprunts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", emprunts=" + emprunts +
                '}';
    }
}
