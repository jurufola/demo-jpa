package fr.diginamic.entites;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_debut")
    private LocalDateTime date_debut;

    @Column(name = "date_fin")
    private LocalDateTime date_fin;

    @Column(name = "delai")
    private  int delai;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany
    @JoinTable(name = "compo", joinColumns = @JoinColumn(name = "id_emp", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_liv", referencedColumnName = "id"))
    private List<Livre> livres;

    public Emprunt(LocalDateTime date_debut, LocalDateTime date_fin, int delai, Client client, List<Livre> livres) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.delai = delai;
        this.client = client;
        this.livres = livres;
    }

    public Emprunt() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", delai=" + delai +
                //", client=" + client +
                //", livres=" + affichLivres(livres) +
                '}';
    }

    public String affichLivres(List<Livre> livres) {
        String message = "";
        for (Livre livre : livres) {
            message += livre;
        }
        return message;
    }
}
