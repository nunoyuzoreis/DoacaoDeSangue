/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nunoreis.Funcionario;

import java.util.ArrayList;

/**
 *
 * @author EJComp
 */
public class CatalogoFuncionario {
    private final ArrayList<Funcionario> funcionarios;
    
    private CatalogoFuncionario(){
        funcionarios = new ArrayList();
        Funcionario funcionario = new Funcionario("Teco", "Chaves");
        funcionarios.add(funcionario);
    }
    
    public static CatalogoFuncionario getInstance(){
        return CatalogoFuncionarioHolder.INSTANCE;
    }
    
    private static class CatalogoFuncionarioHolder{
        private static final CatalogoFuncionario INSTANCE = new CatalogoFuncionario();
    }
    
    public Funcionario ObterFuncionario (String login){
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getLogin().equals(login)) {
                return funcionario;
            }
        }
        return null;
    }
    
    public void Registrar(String login, String senha){
        Funcionario novoFuncionario = new Funcionario(login, senha);
        funcionarios.add(novoFuncionario);
    }
}
