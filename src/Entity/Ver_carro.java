/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author Cyber
 */
public class Ver_carro {
private int idcaro;    
private String Model ;
private String Cor ;
private String Ano ;
private String Marca ;
private Integer id_clie;

    public Ver_carro() {
    }

    public Ver_carro(String Model, String Cor, String Ano, String Marca ,Integer id_cliente) {
        this.Model = Model;
        this.Cor = Cor;
        this.Ano = Ano;
        this.Marca = Marca;
        this.id_clie = id_cliente;
    }

    public void setIdcaro(int idcaro) {
        this.idcaro = idcaro;
    }

    public int getIdcaro() {
        return idcaro;
    }

    
    public Integer getId_clie() {
        return id_clie;
    }

    public void setId_clie(Integer id_clie) {
        this.id_clie = id_clie;
    }
    

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ver_carro other = (Ver_carro) obj;
        if (!Objects.equals(this.Model, other.Model)) {
            return false;
        }
        if (!Objects.equals(this.Cor, other.Cor)) {
            return false;
        }
        if (!Objects.equals(this.Ano, other.Ano)) {
            return false;
        }
        if (!Objects.equals(this.Marca, other.Marca)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carro{" + "Model=" + Model + ", Cor=" + Cor + ", Ano=" + Ano + ", Marca=" + Marca + '}';
    }

    public int getCPF() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}
