package com.example.qt.recycler.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qt.recycler.Adapter.Adapter;
import com.example.qt.recycler.MainActivity;
import com.example.qt.recycler.Model.Person;
import com.example.qt.recycler.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarFragment extends Fragment {

    private RecyclerView rv;
    private ArrayList<Person> persons = new ArrayList<>();

    public ListarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate( R.layout.fragment_listar, container, false );
        rv = (RecyclerView)v.findViewById(R.id.rv);

        receberDados();

        Adapter adapter= new Adapter(persons);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity());
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);

        return v;
    }

    public void receberDados(){
        Bundle bundle= getArguments();

        if(bundle != null){
            persons= bundle.getParcelableArrayList( "persons" );
        }
    }

}
