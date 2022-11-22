package gustavo.maia.ava3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LoginStartup extends AppCompatActivity {

    private TextView text_cadasto;
    private EditText Caixa_Login,Caixa_Senha;
    private Button bt_login;
    private ProgressBar load_login;
    String[] mensagens = {"Preencha todos os campos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_startup);



        getSupportActionBar().hide();
        IniciarComponetes();

        text_cadasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginStartup.this,CadastroStartup.class);
                startActivity(intent);
            }
        });


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Caixa_Login.getText().toString();
                String senha = Caixa_Senha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    AutenticarUsuario(v);
                }

            }
        });
    }


    private void AutenticarUsuario(View view){

        String email = Caixa_Login.getText().toString();
        String senha = Caixa_Senha.getText().toString();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if(task.isSuccessful()){
                    load_login.setVisibility(View.VISIBLE);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            HomeStartup();
                        }
                    },3000);
                }else{
                    String erro;

                    try {
                        throw task.getException();

                    }catch (Exception e){
                        erro = "Erro ao logar o usuário";
                        Snackbar snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT);
                        snackbar.setBackgroundTint(Color.WHITE);
                        snackbar.setTextColor(Color.BLACK);
                        snackbar.show();
                    }
                }
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser usuarioAtual = FirebaseAuth.getInstance().getCurrentUser();

        if(usuarioAtual != null ){
            HomeStartup();
        }
    }

    private void HomeStartup(){
        Intent intent = new Intent(LoginStartup.this,HomeStartup.class);
        startActivity(intent);
        finish();
    }

    private void IniciarComponetes(){
        text_cadasto = findViewById(R.id.text_cadastro);
        Caixa_Login = findViewById(R.id.Caixa_Login);
        Caixa_Senha = findViewById(R.id.Caixa_Senha);
        bt_login = findViewById(R.id.bt_login);
        load_login = findViewById(R.id.load_login);


    }
}