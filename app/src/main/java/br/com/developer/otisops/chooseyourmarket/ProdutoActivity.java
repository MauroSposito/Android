package br.com.developer.otisops.chooseyourmarket;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by mauro on 20/07/2016.
 */
public class ProdutoActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edProduto;
    EditText edMarca;
    EditText edUnMedida;
    EditText edQtMedida;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadproduto);

        edProduto = (EditText) findViewById(R.id.edProduto);
        edMarca = (EditText) findViewById(R.id.edMarca);
        edUnMedida = (EditText) findViewById(R.id.edUnMedida);
        edQtMedida = (EditText) findViewById(R.id.edQtMedida);

        //Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        //btnConfirmar.setOnClickListener(this);
    }

    public void onClickCancelar(View v){
        finish();
    }

    public void onClick (View v){

        Produtos produto = new Produtos();
        produto.setNomeProd(edProduto.getText().toString());
        produto.setMarcaProd(edMarca.getText().toString());
        produto.setUnProd(edUnMedida.getText().toString());
        produto.setQteUnProd(edQtMedida.getText().toString());

        if ((!produto.getNomeProd().isEmpty()) ||
                (!produto.getMarcaProd().isEmpty()) ||
                (!produto.getUnProd().isEmpty()) ||
                (!produto.getQteUnProd().isEmpty())){

            DbHelper dbHelper = new DbHelper(this);
            dbHelper.inserirProduto(produto);
            dbHelper.close();
            Toast msg = Toast.makeText(this,"Produto Cadastrado com sucesso",Toast.LENGTH_SHORT);
            msg.show();
        } else{
            Toast msg = Toast.makeText(this,"Todos os campos devem ser preenchidos",Toast.LENGTH_SHORT);
            msg.show();
        }
        finish();

    }
}
