package com.alkemy.myapplication.data.models.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alkemy.myapplication.R;
import com.alkemy.myapplication.data.models.repo.DateRepository;

import java.util.ArrayList;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<AdapterViewHolder> {
    DateRepository dateRepository;
    Map<String, Object> list;
    private ItemClickListener mItemListener;


    public Adapter(Map<String, Object> list, ItemClickListener itemClickListener) {
        this.list = list;
        this.mItemListener = itemClickListener;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new AdapterViewHolder(layoutInflater.inflate(R.layout.reservation_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        String hora;
        switch (position) {
            case 0:
                hora = "08:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 1:
                hora = "08:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 2:
                hora = "09:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 3:
                hora = "09:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 4:
                hora = "10:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 5:
                hora = "10:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 6:
                hora = "11:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 7:
                hora = "11:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 8:
                hora = "12:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 9:
                hora = "12:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 10:
                hora = "13:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 11:
                hora = "13:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 12:
                hora = "14:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 13:
                hora = "14:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 14:
                hora = "15:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 15:
                hora = "15:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 16:
                hora = "16:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 17:
                hora = "16:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 18:
                hora = "17:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 19:
                hora = "17:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 20:
                hora = "18:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 21:
                hora = "18:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 22:
                hora = "19:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 23:
                hora = "19:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 24:
                hora = "20:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 25:
                hora = "20:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 26:
                hora = "21:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 27:
                hora = "21:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 28:
                hora = "22:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 29:
                hora = "22:30";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
            case 30:
                hora = "23:00";
                holder.render(setRender(hora), position, setEmptys(setRender(hora)),hora,mItemListener);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }



    public ArrayList<String> setRender(String horary) {
        return (ArrayList<String>) list.get(horary);
    }

    public int setEmptys(ArrayList<String> list) {
        int empty = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().equals("empty")) {
                empty++;
            }
        }
        return empty;
    }
}


