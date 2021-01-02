/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Cyber
 */
public class Ver_pessoa {
     private static final Logger LOG = Logger.getLogger(Ver_pessoa.class.getName());
    private static String Nome ;
    private static Integer CPF ;
    private static String Data_Nascimento ;
    private static String Sexo ;

    public Ver_pessoa() {
    }

    public Ver_pessoa(String Nome, Integer CPF, String Data_Nascimento, String Sexo) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Data_Nascimento = Data_Nascimento;
        this.Sexo = Sexo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }

    public String getData_Nascimento() {
        return Data_Nascimento;
    }

    public void setData_Nascimento(String Data_Nascimento) {
        this.Data_Nascimento = Data_Nascimento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.CPF);
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
        final Ver_pessoa other = (Ver_pessoa) obj;
        if (this.Sexo != other.Sexo) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Data_Nascimento, other.Data_Nascimento)) {
            return false;
        }
        if (!Objects.equals(this.CPF, other.CPF)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "Nome=" + Nome + ", CPF=" + CPF + ", Data_Nascimento=" + Data_Nascimento + ", Sexo=" + Sexo + '}';
    }

    public void getData_Nascimento(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
