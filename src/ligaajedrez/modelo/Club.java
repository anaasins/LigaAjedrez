/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez.modelo;

/**
 *
 * @author jbeltran
 */
public class Club {
    private String name;
    private FederacionModel federation;
    /*private Entrenador trainer;
    private Gerente manager;*/

    public Club() {
    }

    public Club(String name, FederacionModel federation) {
        this.name = name;
        this.federation = federation;
    }

    /*public Club(String name, FederacionModel federation, Entrenador trainer, Gerente manager) {
        this.name = name;
        this.federation = federation;
        this.trainer = trainer;
        this.manager = manager;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FederacionModel getFederation() {
        return federation;
    }

    public void setFederation(FederacionModel federation) {
        this.federation = federation;
    }

    /*public Entrenador getTrainer() {
        return trainer;
    }

    public void setTrainer(Entrenador trainer) {
        this.trainer = trainer;
    }

    public Gerente getManager() {
        return manager;
    }

    public void setManager(Gerente manager) {
        this.manager = manager;
    }*/

    @Override
    public String toString() {
        return "Club: " + name + ", " + federation.toString();
    }
}
