package vn.edu.poly.broadcastreceiverexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // gui de lieu ve MainActivity
                Intent intent = new Intent(MainActivity.ON_TEST);

                intent.putExtra("data", "Hello Man Hinh 1, Man hinh 1 nghe ro tra loi!!!");

                sendBroadcast(intent);

            }
        });


    }
}
