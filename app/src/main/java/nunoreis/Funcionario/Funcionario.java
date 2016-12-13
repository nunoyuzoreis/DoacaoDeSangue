/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nunoreis.Funcionario;

/**
 *
 * @author EJComp
 */
public class Funcionario {
    private String login;
    private String senha;
    
    public Funcionario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }
}
