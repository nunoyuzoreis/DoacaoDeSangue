/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nunoreis.Doador;

import java.util.Date;

/**
 *
 * @author EJComp
 */
public class Doador {
    private String nome;
    private String nomePai;
    private String nomeMae;
    private Date nascimento;
    private int sexo;
    private int estadoCivil;
    private String naturalidade;
    private String nacionalidade;
    private String cpf;
    private int escolaridade;
    private String telefone;
    private Endereco enderecoResidencial;
    private Endereco enderecoProfissional;

    public Doador(String nome, String nomePai, String nomeMae, Date nascimento, int sexo, int estadoCivil,
            String naturalidade, String nacionalidade, String cpf, int escolaridade, String telefone,
            String rLogradouro, String rNome, String rNumero, String rBairro, String rCidade, String rEstado,
            String pLogradouro, String pNome, String pNumero, String pBairro, String pCidade, String pEstado) {
        this.nome = nome;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.naturalidade = naturalidade;
        this.nacionalidade = nacionalidade;
        this.cpf = cpf;
        this.escolaridade = escolaridade;
        this.telefone = telefone;
        this.enderecoResidencial = new Endereco(rLogradouro, rNome, rNumero, rBairro,
                rCidade, rEstado);
        if (pLogradouro.isEmpty() && pNome.isEmpty() && pNumero.isEmpty() && pBairro.isEmpty() &&
                pCidade.isEmpty() && pEstado.isEmpty()) //verificar se o endereço profissional é vazio)
            this.enderecoProfissional = null;
        else
            this.enderecoProfissional = new Endereco(pLogradouro, pNome, pNumero, pBairro,
                pCidade, pEstado);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(Endereco enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public Endereco getEnderecoProfissional() {
        return enderecoProfissional;
    }

    public void setEnderecoProfissional(Endereco enderecoProfissional) {
        this.enderecoProfissional = enderecoProfissional;
    }
}
