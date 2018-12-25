package com.example.qt.recycler.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.qt.recycler.Adapter.Adapter;
import com.example.qt.recycler.Adapter.RecyclerItemClickListener;
import com.example.qt.recycler.MainActivity;
import com.example.qt.recycler.Model.Person;
import com.example.qt.recycler.R;
import com.example.qt.recycler.interfaces.Comunicator;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListarFragment extends Fragment{

    private RecyclerView rv;
    private ArrayList<Person> persons = new ArrayList<>();
    private Comunicator comunicator;
    DetalhesFragment detalhesFragment= new DetalhesFragment();

    public ListarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        comunicator = (Comunicator) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate( R.layout.fragment_listar, container, false );
        rv = (RecyclerView)v.findViewById(R.id.rv);

        receberDados();

        Adapter adapter= new Adapter(this,getActivity(),persons);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getActivity());
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener( getActivity(), rv, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //comunicator.openFragment( R.id.fragment,detalhesFragment);//precisa do remove para remover o anterior e aparecer o novo e n add na pilha
                        comunicator.replaceFragment( R.id.fragment, detalhesFragment );//add o fragment na pilha ai volta para ele
                        //comunicator.removeFragment( R.id.fragment );
                        Toast.makeText(getContext(),"Aqui", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                } )
        );

        return v;
    }

    public void receberDados(){
        Bundle bundle= getArguments();

        if(bundle != null){
            persons= bundle.getParcelableArrayList( "persons" );
        }
    }



}
