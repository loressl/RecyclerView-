package com.example.qt.recycler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.qt.recycler.Adapter.Adapter;
import com.example.qt.recycler.Adapter.RecyclerItemClickListener;
import com.example.qt.recycler.Model.Person;
import com.example.qt.recycler.fragment.ListarFragment;
import com.example.qt.recycler.interfaces.Comunicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Comunicator {

    private ArrayList<Person> persons = new ArrayList<>();
    private RecyclerView rv;
    RecyclerItemClickListener listener;
    ListarFragment listarFragment= new ListarFragment();
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeData();
        Bundle bundle= new Bundle(  );
        bundle.putParcelableArrayList( "persons", persons );
        listarFragment.setArguments( bundle );

        openFragment( R.id.fragment, listarFragment );

    }

    private void initializeData(){
        persons.add(new Person("Fillipe Cordeiro", "31 anos", R.drawable.fillipe));
        persons.add(new Person("Joao da Silva", "25 anos", R.drawable.joao));
        persons.add(new Person("Maria Dolores", "35 anos", R.drawable.maria));
    }


    @Override
    public void openFragment(int id, Fragment fragment) {
        FragmentTransaction ft= fm.beginTransaction();
        ft.add( id, fragment );
        ft.commit();
    }

    @Override
    public void replaceFragment(int id, Fragment fragment) {
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace( id, fragment );
        ft.addToBackStack( null );//adiciona o fragmento na pilha
        ft.commit();
    }

    @Override
    public void removeFragment(int id) {
        Fragment fragment= fm.findFragmentById( id );
        FragmentTransaction ft= fm.beginTransaction();
        ft.remove( fragment );
        ft.commit();
    }
}
