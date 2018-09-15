package vn.edu.poly.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;

    public final static String ON_TEST = "on_test";

    private TextView tvData;
    private Button btnOpenSecondAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("onCreateMainActivity", "onCreateMainActivity");

        btnOpenSecondAct = findViewById(R.id.btnOpenSecondAct);

        btnOpenSecondAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });





        tvData = findViewById(R.id.tvData);

        // khoi tao broadcastReceiver
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.e("onReceive", "onReceive");
                String data = intent.getStringExtra("data");



                

                tvData.setText(data);
            }
        };
        IntentFilter intentFilter = new IntentFilter(ON_TEST);

        // Dang ki broadcast
        registerReceiver(broadcastReceiver, intentFilter);


    }
}
