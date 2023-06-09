package gustavo.maia.ava3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoBebe_2 extends AppCompatActivity {

    private TextView info_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_bebe2);

        getSupportActionBar().hide();

    }

    private void InciarComponentes(){
        info_2 = findViewById(R.id.info_2);

    }
}