package com.example.qt.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.qt.recycler.Adapter.Adapter;
import com.example.qt.recycler.Adapter.RecyclerItemClickListener;
import com.example.qt.recycler.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> persons = new ArrayList<>();
    private RecyclerView rv;
    RecyclerItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeData();

        rv = (RecyclerView)findViewById(R.id.rv);

        Adapter adapter= new Adapter(persons);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( MainActivity.this );
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);


    }

    private void initializeData(){
        persons.add(new Person("Fillipe Cordeiro", "31 anos", R.drawable.fillipe));
        persons.add(new Person("Joao da Silva", "25 anos", R.drawable.joao));
        persons.add(new Person("Maria Dolores", "35 anos", R.drawable.maria));
    }
}
