package br.com.developer.otisops.chooseyourmarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by mauro on 20/07/2016.
 */

public class DbHelper extends SQLiteOpenHelper{

    //constantes
    private static final String NOMEBASE = "MeusProdutos";
    private static final int VERSAOBASE = 2;

    //construtor
    public DbHelper(Context context){
        super(context, NOMEBASE, null, VERSAOBASE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //cria a query
        String sqlCreateTabelaProdutos = "CREATE TABLE produtos("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"nome VARCHAR (30) NOT NULL, "
                +"marca VARCHAR (30) NOT NULL,"
                +"unidade VARCHAR (2) NOT NULL,"
                +"qte_unidade VARCHAR (5) NOT NULL"
                +")";
        //executa a query
        sqLiteDatabase.execSQL(sqlCreateTabelaProdutos);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sqlDropTabelaProdutos = "DROP TABLE produtos";

        //executa a query
        sqLiteDatabase.execSQL(sqlDropTabelaProdutos);
        //cria a tabela novamente
        onCreate(sqLiteDatabase);
    }
    public boolean inserirProduto(Produtos produto){

        //abre base de dados com permissao de escrita
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nome", produto.getNomeProd());
        cv.put("marca", produto.getMarcaProd());
        cv.put("unidade", produto.getUnProd());
        cv.put("qte_unidade", produto.getQteUnProd());

        db.insert("produtos", null, cv);

        db.close();
        return true;
    }

    public List<Produtos> selectTodosOsProdutos(){
        List<Produtos> listProdutos = new ArrayList<Produtos>();

        SQLiteDatabase db = getReadableDatabase();
        String sqlSelectTodosProdutos = "SELECT * FROM produtos";

        Cursor cursor = db.rawQuery(sqlSelectTodosProdutos, null);

        if (cursor.moveToFirst()){
            do {
                Produtos produto = new Produtos();
                produto.setIdProd(cursor.getInt(0));
                produto.setNomeProd(cursor.getString(1));
                produto.setMarcaProd(cursor.getString(2));
                produto.setUnProd(cursor.getString(3));
                produto.setQteUnProd(cursor.getString(4));

                listProdutos.add(produto);
            }while (cursor.moveToNext());
        }
        db.close();
        return listProdutos;
    }
}
