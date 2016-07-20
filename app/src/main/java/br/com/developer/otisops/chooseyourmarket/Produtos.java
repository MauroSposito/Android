package br.com.developer.otisops.chooseyourmarket;

/**
 * Created by mauro on 20/07/2016.
 */
public class Produtos {

    private int idProd;
    private String nomeProd;
    private String marcaProd;
    private String unProd;
    private String qteUnProd;


    // Contrutores
    public Produtos(){}

    public Produtos(int idProd, String nomeProd, String marcaProd, String unProd, String qteUnProd) {
        this.idProd = idProd;
        this.nomeProd = nomeProd;
        this.marcaProd = marcaProd;
        this.unProd = unProd;
        this.qteUnProd = qteUnProd;
    }

    //Getters e Setters
    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd.toUpperCase();
    }

    public String getMarcaProd() {
        return marcaProd;
    }

    public void setMarcaProd(String marcaProd) {
        this.marcaProd = marcaProd.toUpperCase();
    }

    public String getUnProd() {
        return unProd;
    }

    public void setUnProd(String unProd) {
        this.unProd = unProd.toUpperCase();
    }

    public String getQteUnProd() {
        return qteUnProd;
    }

    public void setQteUnProd(String qteUnProd) {
        this.qteUnProd = qteUnProd.toUpperCase();
    }

    @Override
    public String toString() {
        return  nomeProd + " " + qteUnProd+ " " + unProd +" "+ marcaProd ;

    }

}
