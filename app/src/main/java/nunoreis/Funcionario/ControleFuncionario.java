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
public class ControleFuncionario {
    
    private ControleFuncionario(){}
    
    public static ControleFuncionario getInstance(){
        return ControleFuncionarioHolder.INSTANCE;
    }
    
    private static class ControleFuncionarioHolder{
        private static final ControleFuncionario INSTANCE = new ControleFuncionario();
    }
    
    public void RegistrarFuncionario(String login, String senha) throws Exception{
        if(login.equals(""))
            throw new Exception("O Login não pode estar em branco!");
        
        if(senha.equals(""))
            throw new Exception("A Senha não pode estar em branco!");
        
        if(CatalogoFuncionario.getInstance().ObterFuncionario(login) != null)
            throw new Exception("Usuário já cadastrado!");
        
        CatalogoFuncionario.getInstance().Registrar(login, senha);
    }
    
    public void AcessarSistema(String login, String senha) throws Exception{
        Funcionario funcionario = CatalogoFuncionario.getInstance().ObterFuncionario(login);
        if(funcionario != null){
            String verLogin = funcionario.getLogin();
            String verSenha = funcionario.getSenha();
            
            if(!(verSenha.equals(senha))){//Verifica se login e senha estão corretos
                throw new Exception("Login ou Senha inválidos!\nTente novamente!");
            }
        }
        else
            throw new Exception("Login ou Senha inválidos!\nTente novamente!");
        
        
    }
}
