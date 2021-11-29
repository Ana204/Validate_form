package app.novo.formvalidate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Email, telefone, sobreNome, primeiroNome;
    Button salvar, apagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initForm();
        buttonApagar();
        buttonSalvar();
    }
    private void initForm() {

        Email = findViewById(R.id.Email);
        telefone = findViewById(R.id.telefone);
        sobreNome = findViewById(R.id.sobreNome);
        primeiroNome = findViewById(R.id.primeiroNome);
        salvar = findViewById(R.id.salvar);
        apagar = findViewById(R.id.apagar);
    }

    private boolean validarForm() {

        boolean form = true;

        if (TextUtils.isEmpty(primeiroNome.getText().toString())){
            primeiroNome.setError("Preencha o campo com seu primeiro nome");
            primeiroNome.requestFocus();
            form = false;
        }
        if (TextUtils.isEmpty(sobreNome.getText().toString())){
            sobreNome.setError("Preencha o campo com seu sobreNome");
            form = false;
        }
        if (TextUtils.isEmpty(telefone.getText().toString())){
            telefone.setError("Preencha o campo com seu telefone");
            form = false;
        }
        if (TextUtils.isEmpty(Email.getText().toString())){
            Email.setError("Preencha o campo com seu email");
            form = false;
        }

        return form;
    }

    private void buttonSalvar() {

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validarForm()){
                    Toast.makeText(MainActivity.this, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void buttonApagar() {

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                primeiroNome.setText("");
                sobreNome.setText("");
                telefone.setText("");
                Email.setText("");

                Toast.makeText(MainActivity.this, "Dados apagados com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}