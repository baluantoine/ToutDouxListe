package exercicepje.sm.fr.toutdouxliste;

/**
 * Created by Formation on 11/01/2018.
 */

public class Task {
    private String nom;
    private Long idTask;

    public Task() {

    }

    public Task(String nom, Long idTask) {
        this.nom = nom;
        this.idTask = idTask;
    }

    public String getNom() {
        return nom;
    }

    public Task setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public Long getIdTask() {
        return idTask;
    }

    public Task setIdTask(Long idTask) {
        this.idTask = idTask;
        return this;
    }
}
