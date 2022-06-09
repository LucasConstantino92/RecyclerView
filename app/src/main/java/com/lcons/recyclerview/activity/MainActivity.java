package com.lcons.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lcons.recyclerview.R;
import com.lcons.recyclerview.adapter.Adapter;
import com.lcons.recyclerview.model.Filme;
import com.lcons.recyclerview.model.ItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de Filmes
        this.criaFilmes();

        //Configurar Adapter
        Adapter adapter = new Adapter(listaFilmes);


        //Configurar RecyclerView (Converter em View)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Evento de Clique
        recyclerView.addOnItemTouchListener(
                new ItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new ItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(MainActivity.this,
                                        "Clicou no filme " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(MainActivity.this,
                                        "Segurou no filme " + filme.getTituloFilme(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    public void criaFilmes() {

        Filme filme = new Filme("Homem-Aranha", "2021", "Fantasia");
        this.listaFilmes.add(filme);

        filme = new Filme("Procurando Nemo", "2002", "Animação");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "2017", "Ficção");
        this.listaFilmes.add(filme);

        filme = new Filme("It: A Coisa", "2017", "Drama/Terror");
        this.listaFilmes.add(filme);

        filme = new Filme("Pica-pau: O Filme", "2017", "Cmédia/Animação");
        this.listaFilmes.add(filme);

        filme = new Filme("Carros 3", "2017", "Comédia");
        this.listaFilmes.add(filme);

        filme = new Filme("A Mumia", "2017", "Drama/Aventura");
        this.listaFilmes.add(filme);

    }
}