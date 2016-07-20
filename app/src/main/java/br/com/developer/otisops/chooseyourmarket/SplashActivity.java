package br.com.developer.otisops.chooseyourmarket;
import  android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by mauro on 18/07/2016.
 */
public class SplashActivity extends AppCompatActivity implements Runnable {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Handler handler = new Handler();

        handler.postDelayed(this, 4000);
    }

    @Override
    public void run() {
        finish();
        Intent i = new Intent(this, DashBoardActivity.class);
        startActivity(i);
        finish();
    }
}
