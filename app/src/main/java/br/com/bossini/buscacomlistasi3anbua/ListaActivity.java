package br.com.bossini.buscacomlistasi3anbua;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    private List<String> base = new ArrayList<>();
    private ListView nomesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        nomesListView = (ListView) findViewById(R.id.nomesListView);
        carregaBase();
        Intent origemIntent = getIntent();
        Bundle b = origemIntent.getExtras();
        String busca = b.getString("busca");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fazBusca(busca));
        nomesListView.setAdapter(adapter);
    }

    private void carregaBase (){
        base.add("Ana Paula");
        base.add ("Tiago Roberto");
        base.add ("Dayanne");
        base.add ("Bia");
    }

    private List <String> fazBusca (String busca){
        List <String> resultado = new ArrayList <>();
        if (busca == null || busca.length() <= 0)
            return base;
        for (String s : base){
            if (s.contains(busca)){
                resultado.add(s);
            }
        }
        return resultado;
    }
}
