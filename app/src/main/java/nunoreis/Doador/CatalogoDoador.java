/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nunoreis.Doador;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author EJComp
 */
public class CatalogoDoador {
    private final ArrayList<Doador> doadores;
    
    private CatalogoDoador(){
        doadores = new ArrayList<>();
    }
    
    public static CatalogoDoador getInstance(){
        return CatalogoDoadorHolder.INSTANCE;
    }
    
    private static class CatalogoDoadorHolder{
        private static final CatalogoDoador INSTANCE = new CatalogoDoador();
    }
    
    public Doador ObterDoador (String cpf){
        for (Doador doador : doadores) {
            if (doador.getCpf().equals(cpf)) {
                return doador;
            }
        }
        return null;
    }
    
    public void Registrar(String nome, String nomePai, String nomeMae, Date nascimento, int sexo,
            int estadoCivil, String naturalidade, String nacionalidade, String cpf, int escolaridade, String telefone,
            String rLogradouro, String rNome, String rNumero, String rBairro, String rCidade, String rEstado,
            String pLogradouro, String pNome, String pNumero, String pBairro, String pCidade, String pEstado){
        
        Doador novoDoador = new Doador(nome, nomePai, nomeMae, nascimento, sexo, estadoCivil, naturalidade,
                nacionalidade, cpf, escolaridade, telefone, rLogradouro, rNome, rNumero, rBairro, rCidade,
                rEstado, pLogradouro, pNome, pNumero, pBairro, pCidade, pEstado);

        doadores.add(novoDoador);
    }
}


            