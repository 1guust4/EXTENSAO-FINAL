package gustavo.maia.ava3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeStartup extends AppCompatActivity {

    private TextView info_1,info_2,info_3;
    private Button back_login,seta_direita,seta_esquerda;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_startup);


        getSupportActionBar().hide();
        IniciarComponentes();

        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomeStartup.this,LoginStartup.class);
                startActivity(intent);
                finish();
            }
        });


        info_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeStartup.this,InfoBebe.class);
                startActivity(intent);

            }
        });


        info_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeStartup.this,InfoBebe_2.class);
                startActivity(intent);
            }
        });

        seta_direita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeStartup.this,Semana_3.class);
                startActivity(intent);
            }
        });



    }


    private void IniciarComponentes(){
        info_1 = findViewById(R.id.info_1);
        info_2 = findViewById(R.id.info_2);

        back_login = findViewById(R.id.back_login);
        seta_direita = findViewById(R.id.seta_direita);
        seta_esquerda = findViewById(R.id.seta_esquerda);



    }


}