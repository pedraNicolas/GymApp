package com.alkemy.myapplication.ui.view.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alkemy.myapplication.R;
import com.alkemy.myapplication.data.models.RecyclerView.Adapter;
import com.alkemy.myapplication.data.models.RecyclerView.ItemClickListener;
import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.data.models.repo.DateRepository;
import com.alkemy.myapplication.data.models.repo.DateRepositoryCallBack;
import com.alkemy.myapplication.databinding.FragmentReservationBinding;
import com.alkemy.myapplication.ui.viewmodel.HomeFragmentViewModel;

import java.util.ArrayList;
import java.util.Map;


public class ReservationFragment extends Fragment {
    private HomeFragmentViewModel homeFragmentViewModel = new HomeFragmentViewModel();
    private FragmentReservationBinding binding;
    public LinearLayoutManager layoutManager;
    DateRepository dateRepository = new DateRepository();
    Adapter adapter;

    public ReservationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReservationBinding.inflate(inflater, container, false);
        homeFragmentViewModel = new ViewModelProvider(requireActivity()).get(HomeFragmentViewModel.class);
        User user = homeFragmentViewModel.getSelectedItem().getValue();
        Log.d("fragment", user.getName());

        dateRepository.date(new DateRepositoryCallBack() {
            @Override
            public void onCallback(Map<String, Object> list) {
                initRecyclerView(list);
            }
        });

        return binding.getRoot();
    }

    //Inicializar el RecyclerView
    public void initRecyclerView(Map<String, Object> list) {
        layoutManager = new LinearLayoutManager(this.getContext());
        binding.recyclerViewId.setLayoutManager(layoutManager);
        adapter = new Adapter(list, new ItemClickListener() {
            @Override
            public void onItemClick(ArrayList<String> list, String string, int caso, int emptys) {
                //Decide que ocurre cuando se hace click en un item
                if(homeFragmentViewModel.userAppointmentVM(list,homeFragmentViewModel.getSelectedItem().getValue())){
                    Toast.makeText(getContext(), "Usted ya tiene un turno agendado a esta hora", Toast.LENGTH_SHORT).show();
                }else{alertDialog(string, list, caso);}
            }
        });
        binding.recyclerViewId.setAdapter(adapter);
    }

    //Alert Dialog para confirmar turno
    public void alertDialog(String string, ArrayList<String> list, int caso) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this.getActivity());
        alertDialog.setTitle("Confirmar reserva");
        alertDialog.setMessage("¿Desea confirmar su reserva para el turno de las " + string + "?");
        alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                aceptar(list, caso);
                changeFragment();
            }
        });
        alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cancelar();
            }
        });
        alertDialog.show();
    }

    public void aceptar(ArrayList<String> list, int caso) {
        User user = homeFragmentViewModel.getSelectedItem().getValue();
        homeFragmentViewModel.setAppointmentRepositoryVM(list, user, caso);
        Toast.makeText(this.getActivity(), "Turno confirmado", Toast.LENGTH_SHORT).show();


    }

    public void cancelar() {

    }

    //Recargar el fragmento para actualizar cambios
    private void changeFragment() {
        Fragment reservationFragment = new ReservationFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, reservationFragment);
        transaction.commit();
    }

}