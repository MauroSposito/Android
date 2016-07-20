package br.com.developer.otisops.chooseyourmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by mauro on 20/07/2016.
 */

public class DashBoardActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

    }

    public void onClickPromocao(View v){
        trace("Clicou Promocao");
    }

    public void onClickBasico(View v){
        trace("clicou Basico");
    }

    public void onClickConfig(View v){
        trace("Clicou add item");
    }

    public void onClickSobre(View v){
        trace("Sobre");
    }

    public void onClickExit(View v){ finish();  }

    public void toast (String msg)
    {
        Toast.makeText (getApplicationContext(), msg, Toast.LENGTH_SHORT).show ();
    }

    private void trace (String msg)
    {
        toast (msg);
    }
}
