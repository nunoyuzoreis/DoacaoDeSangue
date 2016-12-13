package nunoreis.doacaodesangue;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import nunoreis.Doador.ControleDoador;


public class RegistrarDoador extends ActionBarActivity implements DatePickerDialog.OnDateSetListener {

    //variaveis da interface
    //variaveis usadas na fragment da data de nascimento
    private Button mEscolherData;
    private int mAno;
    private int mMes;
    private int mDia;
    private TextView mMostraData;

    //variaveis de inserção no catalogo
    String nome;
    String nomePai;
    String nomeMae;
    String dia;
    String mes;
    String ano;
    int sexo;
    int estadoCivil;
    String naturalidade;
    String nacionalidade;
    String cpf;
    int escolaridade;
    String telefone;
    String rLogradouro;
    String rNome;
    String rNumero;
    String rBairro;
    String rCidade;
    String rEstado;
    String pLogradouro;
    String pNome;
    String pNumero;
    String pBairro;
    String pCidade;
    String pEstado;

    //variaveis de texto
    private EditText mNomeDoador;
    private EditText mNomePai;
    private EditText mNomeMae;
    private EditText mCPF;
    private EditText mTelefone;
    private EditText mNaturalidade;
    private EditText mNacionalidade;
    private EditText mrLogradouro;
    private EditText mrNomeRua;
    private EditText mrNumero;
    private EditText mrBairro;
    private EditText mrCidade;
    private EditText mrEstado;
    private EditText mpLogradouro;
    private EditText mpNomeRua;
    private EditText mpNumero;
    private EditText mpBairro;
    private EditText mpCidade;
    private EditText mpEstado;

    //radioButtons e radiogroup
    private RadioGroup mRadioGroupSexo;
    private RadioGroup mRadioGroupEstadoCivil;
    private RadioGroup mRadioGroupEscolaridade;

    private RadioButton mRadioButtonSexo;
    private RadioButton mRadioButtonEstadoCivil;
    private RadioButton mRadioButtonEscolaridade;

    //botoes
    private Button mBotaoCancelar;
    private Button mBotaoRegistrar;

    //mascara para cpf
    private TextWatcher cpfMask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_doador);

        //Captura os elementos da interface
        //data de nascimento
        mEscolherData = (Button) findViewById(R.id.botaoDataNasc);
        mMostraData = (TextView) findViewById(R.id.textoDataNasc);

        //edittext
        mNomeDoador = (EditText) findViewById(R.id.nomeDoador);
        mNomeMae = (EditText) findViewById(R.id.nomeMae);
        mNomePai = (EditText) findViewById(R.id.nomePai);
        mCPF = (EditText) findViewById(R.id.cpf);
        mTelefone = (EditText) findViewById(R.id.telefone);
        mNacionalidade = (EditText) findViewById(R.id.nacionalidade);
        mNaturalidade = (EditText) findViewById(R.id.naturalidade);
        mrLogradouro = (EditText) findViewById(R.id.rLogradouro);
        mrNomeRua = (EditText) findViewById(R.id.rNome);
        mrNumero = (EditText) findViewById(R.id.rNumero);
        mrBairro = (EditText) findViewById(R.id.rBairro);
        mrCidade = (EditText) findViewById(R.id.rCidade);
        mrEstado = (EditText) findViewById(R.id.rEstado);
        mpLogradouro = (EditText) findViewById(R.id.pLogradouro);
        mpNomeRua = (EditText) findViewById(R.id.pNome);
        mpNumero = (EditText) findViewById(R.id.pNumero);
        mpBairro = (EditText) findViewById(R.id.pBairro);
        mpCidade = (EditText) findViewById(R.id.pCidade);
        mpEstado = (EditText) findViewById(R.id.pEstado);

        //radiobuttons

        mRadioGroupEscolaridade = (RadioGroup) findViewById(R.id.radioEscolaridade);
        mRadioGroupEstadoCivil = (RadioGroup) findViewById(R.id.radioEstadoCivil);
        mRadioGroupSexo = (RadioGroup) findViewById(R.id.radioSexo);

        //botoes
        mBotaoCancelar = (Button) findViewById(R.id.botao_cancelar_doador);
        mBotaoRegistrar = (Button) findViewById(R.id.botao_registrar_doador);


        //mascara do cpf
        cpfMask = Mask.insert("###.###.###-##", mCPF);
        mCPF.addTextChangedListener(cpfMask);


        //Seta onClickListener para o botao Data Nascimento
        mEscolherData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Create a new DatePickerFragment
                DialogFragment newFragment = new DatePickerFragment();

                // Display DatePickerFragment
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });

        //Seta onClickListener para o botao Registrar
        mBotaoRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //pega as Strings dos EditText
                nome = mNomeDoador.getText().toString();
                nomeMae = mNomeMae.getText().toString();
                nomePai = mNomePai.getText().toString();
                cpf = mCPF.getText().toString();
                telefone = mTelefone.getText().toString();
                naturalidade = mNaturalidade.getText().toString();
                nacionalidade = mNacionalidade.getText().toString();
                rLogradouro = mrLogradouro.getText().toString();
                rNome = mrNomeRua.getText().toString();
                rNumero = mrNumero.getText().toString();
                rBairro = mrBairro.getText().toString();
                rCidade = mrCidade.getText().toString();
                rEstado = mrEstado.getText().toString();
                pLogradouro = mpLogradouro.getText().toString();
                pNome = mpNomeRua.getText().toString();
                pNumero = mpNumero.getText().toString();
                pBairro = mpBairro.getText().toString();
                pCidade = mpCidade.getText().toString();
                pEstado = mpEstado.getText().toString();

                //pega o id do radio button selecionado do radiogroup
                int sexoSelecionado = mRadioGroupSexo.getCheckedRadioButtonId();
                int estadoCivilSelecionado = mRadioGroupEstadoCivil.getCheckedRadioButtonId();
                int escolaridadeSelecionado = mRadioGroupEscolaridade.getCheckedRadioButtonId();

                //pega o proprio radiobutton selecionado
                mRadioButtonSexo = (RadioButton) findViewById(sexoSelecionado);
                mRadioButtonEstadoCivil = (RadioButton) findViewById(estadoCivilSelecionado);
                mRadioButtonEscolaridade = (RadioButton) findViewById(escolaridadeSelecionado);

                //seta os inteiros para o indice do radiobutton selecionado
                sexo = mRadioGroupSexo.indexOfChild(mRadioButtonSexo);
                estadoCivil = mRadioGroupEstadoCivil.indexOfChild(mRadioButtonEstadoCivil);
                escolaridade = mRadioGroupEscolaridade.indexOfChild(mRadioButtonEscolaridade);

                if(dia!=null && mes!=null && ano!=null)
                {
                    try {
                        ControleDoador.getInstance().registrarDoador(nome, nomePai, nomeMae, dia, mes, ano, sexo,
                                estadoCivil, naturalidade, nacionalidade, cpf, escolaridade, telefone,
                                rLogradouro, rNome, rNumero, rBairro, rCidade, rEstado,
                                pLogradouro, pNome, pNumero, pBairro, pCidade, pEstado);
                        Toast.makeText(getApplicationContext(), "Doador Registrado Com Sucesso!",
                                Toast.LENGTH_LONG).show();
                        finish();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                }
                else Toast.makeText(getApplicationContext(), "Selecione a data de nascimento!",
                        Toast.LENGTH_LONG).show();


            }
        });

        //Seta onClickListener para o botao Cancelar
        mBotaoCancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registrar_doador, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        mAno = year;
        ano = String.valueOf(mAno); //transforma o int ano em string para o catalogo

        mMes = monthOfYear;
        mes = String.valueOf(mMes); //transforma o int mes em string

        mDia = dayOfMonth;
        dia = String.valueOf(mDia); //transforma o int dia em string

        atualizaTextViewData();

    }

    private void atualizaTextViewData() {
        mMostraData.setText(new StringBuilder()
                // Month is 0 based so add 1
                .append(mDia).append("-").append(mMes + 1).append("-")
                .append(mAno).append(" "));
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            ((DatePickerDialog.OnDateSetListener) getActivity()).onDateSet(view, year,
                    monthOfYear, dayOfMonth);

        }
    }
}
