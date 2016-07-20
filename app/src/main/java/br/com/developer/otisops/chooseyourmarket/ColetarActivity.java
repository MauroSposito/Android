package br.com.developer.otisops.chooseyourmarket;

import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;


        import java.util.Collection;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.List;
/**
 * Created by mauro on 20/07/2016.
 */

public class ColetarActivity extends AppCompatActivity  {
    private ListView lvMostraTodosOsProdutos;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        lvMostraTodosOsProdutos = (ListView) findViewById(R.id.lbList);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    public void onClickIncluir(View v) {
        startActivityForResult(new Intent(this, ProdutoActivity.class), 1);

    }

    public void onResume() {
        super.onResume();
        DbHelper dbHelper = new DbHelper(this);
        List<Produtos> listaProdutos = dbHelper.selectTodosOsProdutos();

        Collections.sort(listaProdutos, new Comparator<Produtos>() {
            public int compare(Produtos p1, Produtos p2) {
                return p1.getNomeProd().toUpperCase().compareTo(p2.getNomeProd().toUpperCase());
            }
        });

        ArrayAdapter<Produtos> adapter = new ArrayAdapter<Produtos> (this, android.R.layout.simple_list_item_1, listaProdutos);

        lvMostraTodosOsProdutos.setAdapter(adapter);
        lvMostraTodosOsProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Item = parent.getItemAtPosition(position).toString();
                Toast msg = Toast.makeText(ColetarActivity.this, Item,Toast.LENGTH_SHORT);
                msg.show();
            }
        });





    }






}