package nunoreis.doacaodesangue;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nunoreis.Funcionario.ControleFuncionario;
import nunoreis.Funcionario.Funcionario;
import nunoreis.Funcionario.Gerente;


public class RegistrarFuncionario extends ActionBarActivity {

    private Button mRegistrarFuncionario;
    private Button mCancelarFuncionario;
    private EditText mLoginFuncionario;
    private EditText mSenhaFuncionario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_funcionario);


        mLoginFuncionario = (EditText) findViewById(R.id.login_funcionario);
        mSenhaFuncionario = (EditText) findViewById(R.id.senha_funcionario);
        mCancelarFuncionario = (Button) findViewById(R.id.botao_cancelar_funcionario);
        mRegistrarFuncionario = (Button) findViewById(R.id.botao_registrar_funcionario);
        mRegistrarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = mLoginFuncionario.getText().toString();
                String senha = mSenhaFuncionario.getText().toString();
                try {
                    ControleFuncionario.getInstance().RegistrarFuncionario(login, senha);
                    finish();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        mCancelarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registrar_funcionario, menu);
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
}
