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
public class Gerente {
    private String login;
    private String senha;
    
    
    //Construtor cria o login padrão
    public Gerente(){
        this.login = "gerente";
        this.senha = "gerente";
    }
    
    public static Gerente getInstance(){
        return GerenteHolder.INSTANCE;
    }
    
    private static class GerenteHolder{
        private static final Gerente INSTANCE = new Gerente();
    }
    
    
    public void AcessarSistema(String login, String senha) throws Exception{
        if(!(this.login.equals(login) && this.senha.equals(senha))){//Verifica se login e senha estão corretos
            throw new Exception("Login ou Senha Inválidos!\nTente novamente!");
        }
    }
    

    public void AlterarDadosGerente(String login, String senha) throws Exception{
        login = login.trim();
        senha = senha.trim();
        
        if(login.length() < 4)
            throw new Exception("O Login não pode ter menos de 4 caracteres");
        
        if(login.length() > 30)
            throw new Exception("O Login não pode ter mais de 30 caracteres");
        
        
        if(senha.length() < 4)
            throw new Exception("A Senha não pode ter menos de 4 caracteres");
        
        if(senha.length() > 30)
            throw new Exception("A Senha não pode ter mais de 30 caracteres");
        
        this.login = login;
        this.senha = senha;
    }
    
    //Falta Implementação
    public boolean VerificaPrimeiroAcesso(){
        return ("gerente".equals(login) && "gerente".equals(senha));
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }   
}