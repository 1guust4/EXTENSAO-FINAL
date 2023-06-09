package gustavo.maia.ava3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Semana_3 extends AppCompatActivity {

    private TextView info_1_semana_3,info_2_semana_3;
    private Button back_login,seta_esquerda,seta_direita;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semana3);


        getSupportActionBar().hide();
        IniciarComponentes();

        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Semana_3.this,LoginStartup.class);
                startActivity(intent);
                finish();
            }
        });


        info_1_semana_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Semana_3.this,InfoBebe_Semana_3.class);
                startActivity(intent);

            }
        });


        info_2_semana_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Semana_3.this,InfoBebe_2_Semana_3.class);
                startActivity(intent);
            }
        });

        seta_esquerda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Semana_3.this,HomeStartup.class);
                startActivity(intent);
            }
        });

        seta_direita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Semana_3.this,Semana_4.class);
                startActivity(intent);
            }
        });



    }


    private void IniciarComponentes(){
        info_1_semana_3 = findViewById(R.id.info_1_semana_3);
        info_2_semana_3 = findViewById(R.id.info_2_semana_3);
        back_login = findViewById(R.id.back_login);
        seta_esquerda = findViewById(R.id.seta_esquerda);
        seta_direita = findViewById(R.id.seta_direita);



    }


}