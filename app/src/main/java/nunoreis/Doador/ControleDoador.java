/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nunoreis.Doador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author EJComp
 */
public class ControleDoador {
    //Controla o tamanho máximo das variáveis
    private final int lim2 = 2;   //dia, mes
    private final int lim4 = 4;   //ano
    private final int lim10 = 10; //telefone(residencial)
    private final int lim11 = 11; //cpf, telefone(móvel)
    private final int lim60 = 60; //nome, nomePai, nomeMae, naturalidade, nacionalidade,
                                  //rLogradouro, rNome, rNumero, rBairro, rCidade, rEstado
                                  //pLogradouro, pNome, pNumero, pBairro, pCidade, pEstado
    
    //Controla os caracteres permitidos das variáveis 
    private final String alfa = "^[A-Z a-zÁÉÍÓÚÂÊÔÇÃÕáéíóúâêôãõç]+$";
    private final String numeric = "^\\d+$";
    private final String alfanumeric = "\"^[A-Z a-z 0-9ÁÉÍÓÚÂÊÔÇÃÕáéíóúâêôãõç]+$\"$";
    
    private ControleDoador(){}
    
    public static ControleDoador getInstance(){
        return ControleDoadorHolder.INSTANCE;
    }
    
    private static class ControleDoadorHolder{
        private static final ControleDoador INSTANCE = new ControleDoador();
    }
    
    public void registrarDoador(String nome, String nomePai, String nomeMae,
            String dia, String mes, String ano, int sexo, int estadoCivil, String naturalidade,
            String nacionalidade, String cpf, int escolaridade, String telefone,
            String rLogradouro, String rNome, String rNumero, String rBairro, String rCidade, String rEstado,
            String pLogradouro, String pNome, String pNumero, String pBairro, String pCidade, String pEstado
            ) throws Exception{
        
        
        ValidaDados(nome, nomePai, nomeMae, dia, mes, ano, naturalidade,nacionalidade, cpf, telefone,
                rLogradouro, rNome, rNumero, rBairro, rCidade, rEstado,
                pLogradouro, pNome, pNumero, pBairro, pCidade, pEstado);
        
        Date date = ValidaData(dia, mes, ano);
        ValidaIdade(date);

        //Antes de adicionar o doador, verificar se o cpf dele já não está cadastrado
        if(CatalogoDoador.getInstance().ObterDoador(cpf) == null)
            CatalogoDoador.getInstance().Registrar(nome, nomePai, nomeMae, date, sexo,
                    estadoCivil, naturalidade, nacionalidade, cpf, escolaridade,
                    telefone, rLogradouro, rNome, rNumero, rBairro, rCidade, rEstado,
                    pLogradouro, pNome, pNumero, pBairro, pCidade, pEstado);
        else
            throw new Exception("Doador já cadastrado!");
    }
    
    //Verifica se todos os dados foram inseridos corretamente
    private void ValidaDados(String nome, String nomePai, String nomeMae, String dia, String mes, String ano,
            String naturalidade, String nacionalidade, String cpf, String telefone,
            String rLogradouro, String rNome, String rNumero, String rBairro, String rCidade, String rEstado,
            String pLogradouro, String pNome, String pNumero, String pBairro, String pCidade, String pEstado
            ) throws Exception{
        
        //Removendo espaços em branco indesejáveis
        nome = nome.trim();
        nomePai = nomePai.trim();
        nomeMae = nomeMae.trim();
        dia = dia.trim();
        mes = mes.trim();
        ano = ano.trim();
        naturalidade = naturalidade.trim();
        nacionalidade = nacionalidade.trim();
        cpf = cpf.trim();
        telefone = telefone.trim();
        rLogradouro = rLogradouro.trim();
        rNome = rNome.trim();
        rNumero = rNumero.trim();
        rBairro = rBairro.trim();
        rCidade = rCidade.trim();
        rEstado = rEstado.trim();
        pLogradouro = pLogradouro.trim();
        pNome = pNome.trim();
        pNumero = pNumero.trim();
        pBairro = pBairro.trim();
        pCidade = pCidade.trim();
        pEstado = pEstado.trim();
        
        //Verificando Nomes em branco
        //Verificando quantidade máxima de caracteres
        //Verificando caracteres permitidos
        if(nome.equals(""))
            throw new Exception("O Nome do Doador não pode estar em branco!");

        if(nome.length()> lim60)
            throw new Exception("O Nome do Doador não pode ter mais do que 60 caracteres!");
        
        if(!nome.matches(alfa))
            throw new Exception("O Nome do Doador pode conter apenas letras!");
        
        
        if(nomePai.equals(""))
            throw new Exception("O Nome do Pai do Doador não pode estar em branco!");
        
        if(nomePai.length()> lim60)
            throw new Exception("O Nome do Pai do Doador não pode ter mais do que 60 caracteres!");
        
        if(!nomePai.matches(alfa))
            throw new Exception("O Nome do Pai do Doador pode conter apenas letras!");

        
        if(nomeMae.equals(""))
            throw new Exception("O Nome da Mãe do Doador não pode estar em branco!");
        
        if(nomeMae.length()> lim60)
            throw new Exception("O Nome da Mãe do Doador não pode ter mais do que 60 caracteres!");
        
        if(!nomeMae.matches(alfa))
            throw new Exception("O Nome da Mãe do Doador pode conter apenas letras!");
        
        
        if(dia.equals(""))
            throw new Exception("O Dia de Nascimento do Doador não pode estar em branco!");
        
        if(dia.length()> lim2)
            throw new Exception("O Dia de Nascimento do Doador não pode ter mais do que 2 caracteres!");
        
        if(!dia.matches(numeric))
            throw new Exception("O Dia de Nascimento do Doador pode conter apenas números!");
        
        
         if(mes.equals(""))
            throw new Exception("O Mês de Nascimento do Doador não pode estar em branco!");
        
        if(mes.length()> lim2)
            throw new Exception("O mês de Nascimento do Doador não pode ter mais do que 2 caracteres!");
        
        if(!mes.matches(numeric))
            throw new Exception("O Mês de Nascimento do Doador pode conter apenas números!");
        
        
         if(ano.equals(""))
            throw new Exception("O Ano de Nascimento do Doador não pode estar em branco!");
        
        if(ano.length() != lim4)
            throw new Exception("O Ano de Nascimento do Doador deve ter 4 caracteres!");
        
        if(!ano.matches(numeric))
            throw new Exception("O Ano de Nascimento do Doador pode conter apenas números!");
        
        
        if(naturalidade.equals(""))
            throw new Exception("A Naturalidade (cidade onde nasceu) do Doador não pode estar em branco!");
        
        if(naturalidade.length()> lim60)
            throw new Exception("A Naturalidade (cidade onde nasceu) do Doador não pode ter mais do que 60 caracteres!");
        
        if(!naturalidade.matches(alfa))
            throw new Exception("A Naturalidade (cidade onde nasceu) do Doador pode conter apenas letras!");
        
        
        if(nacionalidade.equals(""))
            throw new Exception("A Nacionalidade (Pais onde nasceu) do Doador não pode estar em branco!");
        
        if(nacionalidade.length()> lim60)
            throw new Exception("A Nacionalidade (Pais onde nasceu) do Doador não pode ter mais do que 60 caracteres!");
        
        if(!nacionalidade.matches(alfa))
            throw new Exception("A Nacionalidade (Pais onde nasceu) do Doador pode conter apenas letras!");
        
        
        if(cpf.equals(""))
            throw new Exception("O CPF do Doador não pode estar em branco!");
        
        //if(cpf.length() != lim11)
          //  throw new Exception("O CPF do Doador deve conter 11 caracteres!");
        
        //if(!cpf.matches(numeric))
          //  throw new Exception("O CPF do Doador pode conter apenas números!");
        
        
       if(telefone.equals(""))
            throw new Exception("O Telefone do Doador não pode estar em branco!");
        
        if(telefone.length() < lim10 || telefone.length() > lim11)
            throw new Exception("O Telefone do Doador deve conter entre 10 e 11 caracteres!");
        
        if(!telefone.matches(numeric))
            throw new Exception("O Telefone do Doador pode conter apenas números!"); 
        
        
        if(rLogradouro.equals(""))
            throw new Exception("O Logradouro (Rua, Avenida, Travessa, Estrada...) da Residencia do Doador não pode estar em branco!");

        if(rLogradouro.length()> lim60)
            throw new Exception("O Logradouro (Rua, Avenida, Travessa, Estrada...) da Residencia do Doador não pode ter mais do que 30 caracteres!");
        
        if(!rLogradouro.matches(alfa))
            throw new Exception("O Logradouro (Rua, Avenida, Travessa, Estrada...) da Residencia do Doador pode conter apenas letras!");
        
        
        if(rNome.equals(""))
            throw new Exception("O Nome do Logradouro da Residencia do Doador não pode estar em branco!");

        if(rNome.length()> lim60)
            throw new Exception("O Nome do Logradouro da Residencia do Doador não pode ter mais do que 60 caracteres!");
        
        //if(!rNome.matches(alfanumeric))
          //  throw new Exception("O Nome do Logradouro da Residencia do Doador pode conter apenas letras e números!");
       
        
        if(rNumero.equals(""))
            throw new Exception("O Número da Residencia do Doador não pode estar em branco!");

        if(rNumero.length()> lim60)
            throw new Exception("O Número da Residencia do Doador não pode ter mais do que 60 caracteres!");
        
        //if(!rNumero.matches(alfanumeric))
          //  throw new Exception("O Número da Residencia do Doador pode conter apenas letras e números!");

        
        if(rBairro.equals(""))
            throw new Exception("O Bairro da Residencia do Doador não pode estar em branco!");

        if(rBairro.length()> lim60)
            throw new Exception("O Bairro da Residencia do Doador não pode ter mais do que 60 caracteres!");
        
        //if(!rBairro.matches(alfanumeric))
          //  throw new Exception("O Bairro da Residencia do Doador pode conter apenas letras e números!");
       
        
        if(rCidade.equals(""))
            throw new Exception("A Cidade da Residencia do Doador não pode estar em branco!");

        if(rCidade.length()> lim60)
            throw new Exception("A Cidade da Residencia do Doador não pode ter mais do que 60 caracteres!");
        
        //if(!rCidade.matches(alfanumeric))
          //  throw new Exception("A Cidade da Residencia do Doador pode conter apenas letras e números!");
       
        
        if(rEstado.equals(""))
            throw new Exception("O Estado da Residencia do Doador não pode estar em branco!");

        if(rEstado.length()> lim60)
            throw new Exception("O Estado da Residencia do Doador não pode ter mais do que 60 caracteres!");
        
        if(!rEstado.matches(alfa))
            throw new Exception("O Estado da Residencia do Doador pode conter apenas letras!");
        
        
        //Tratando endereço Profissional
        
        if(!pLogradouro.isEmpty() || !pNome.isEmpty() || !pNumero.isEmpty() || !pBairro.isEmpty() ||
                !pCidade.isEmpty() || !pEstado.isEmpty()){
            
            if(pLogradouro.equals(""))
                throw new Exception("O Logradouro (Rua, Avenida, Travessa, Estrada...) Profissional do Doador não pode estar em branco!");

            if(pLogradouro.length()> lim60)
                throw new Exception("O Logradouro (Rua, Avenida, Travessa, Estrada...) Profissional do Doador não pode ter mais do que 30 caracteres!");

            if(!pLogradouro.matches(alfa))
                throw new Exception("O Logradouro (Rua, Avenida, Travessa, Estrada...) Profissional do Doador pode conter apenas letras!");


            if(pNome.equals(""))
                throw new Exception("O Nome do Logradouro Profissional do Doador não pode estar em branco!");

            if(pNome.length()> lim60)
                throw new Exception("O Nome do Logradouro Profissional do Doador não pode ter mais do que 60 caracteres!");

            //if(!pNome.matches(alfanumeric))
              //  throw new Exception("O Nome do Logradouro Profissional do Doador pode conter apenas letras e números!");


            if(pNumero.equals(""))
                throw new Exception("O Número Profissional do Doador não pode estar em branco!");

            if(pNumero.length()> lim60)
                throw new Exception("O Número Profissional do Doador não pode ter mais do que 60 caracteres!");

            //if(!pNumero.matches(alfanumeric))
              //  throw new Exception("O Número Profissional do Doador pode conter apenas letras e números!");


            if(pBairro.equals(""))
                throw new Exception("O Bairro Profissional do Doador não pode estar em branco!");

            if(pBairro.length()> lim60)
                throw new Exception("O Bairro Profissional do Doador não pode ter mais do que 60 caracteres!");

            //if(!pBairro.matches(alfanumeric))
              //  throw new Exception("O Bairro Profissional do Doador pode conter apenas letras e números!");


            if(pCidade.equals(""))
                throw new Exception("A Cidade Profissional do Doador não pode estar em branco!");

            if(pCidade.length()> lim60)
                throw new Exception("A Cidade Profissional do Doador não pode ter mais do que 60 caracteres!");

           // if(!pCidade.matches(alfanumeric))
             //   throw new Exception("A Cidade Profissional do Doador pode conter apenas letras e números!");


            if(pEstado.equals(""))
                throw new Exception("O Estado Profissional do Doador não pode estar em branco!");

            if(pEstado.length()> lim60)
                throw new Exception("O Estado Profissional do Doador não pode ter mais do que 60 caracteres!");

            if(!pEstado.matches(alfa))
                throw new Exception("O Estado Profissional do Doador pode conter apenas letras!");
        }
    }
    
    private Date ValidaData(String dia, String mes, String ano) throws Exception{
        String dataString = dia + "/"+ mes + "/"+ ano;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        try {
            Date data = sdf.parse(dataString);
            return data;
        }
        catch(ParseException e) {
            throw new Exception("A data é inválida!");
        }
    }
    
    private void ValidaIdade(Date nascimento) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        dateFormat.format(date);
        
        
        int anoNascimento = nascimento.getYear();
        int diferenca = date.getYear() - anoNascimento;
        
        //Verifica se o doador tem 17 ou menos anos
        if (diferenca < 18)
            throw new Exception("O Doador tem menos de 18 anos! Impossível realizar o Registro!");
        
        //Verifica se o doador tem mais de 70 ou mais anos
        if (diferenca > 70)
            throw new Exception("O Doador tem mais de 69 anos! Impossível realizar o Registro!");
        
        date.setYear(anoNascimento);
        //Caso o doador 
        if (diferenca == 18)
            if(date.compareTo(nascimento) < 0)
                throw new Exception("O Doador tem menos de 18 anos! Impossível realizar o Registro!");
            
        if (diferenca == 70)
            if(date.compareTo(nascimento) > 0)
                throw new Exception("O Doador tem mais de 69 anos! Impossível realizar o Registro!");
    }
}
