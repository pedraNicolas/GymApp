package com.alkemy.myapplication.data.models.RecyclerView;

import static java.lang.String.valueOf;

import android.graphics.Color;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.alkemy.myapplication.R;
import com.alkemy.myapplication.domain.DataBaseUseCase;
import com.alkemy.myapplication.ui.view.fragments.ReservationFragment;

import java.util.ArrayList;

public class AdapterViewHolder extends RecyclerView.ViewHolder {
    TextView horary, quota, textview2;
    CardView cardview;
    DataBaseUseCase dataBaseUseCase;

    public AdapterViewHolder(@NonNull View itemView) {
        super(itemView);
        horary = (TextView) itemView.findViewById(R.id.horaryId);
        quota = (TextView) itemView.findViewById(R.id.quotaId);
        textview2 = (TextView) itemView.findViewById(R.id.textView2);
        cardview = (CardView) itemView.findViewById(R.id.cardBackgroundColorId);

    }

    public void render(ArrayList<String> list, int position, int emptys, String hora, ItemClickListener mItemListener) {
        String name;
        switch (position) {
            case 0:
                name = "08:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));


                break;
            case 1:
                name = "08:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 2:
                name = "09:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 3:
                name = "09:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 4:
                name = "10:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 5:
                name = "10:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 6:
                name = "11:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 7:
                name = "11:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 8:
                name = "12:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 9:
                name = "12:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 10:
                name = "13:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 11:
                name = "13:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 12:
                name = "14:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 13:
                name = "14:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 14:
                name = "15:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 15:
                name = "15:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 16:
                name = "16:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 17:
                name = "16:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 18:
                name = "17:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 19:
                name = "17:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 20:
                name = "18:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 21:
                name = "18:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 22:
                name = "19:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 23:
                name = "19:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 24:
                name = "20:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 25:
                name = "20:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 26:
                name = "21:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 27:
                name = "21:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 28:
                name = "22:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 29:
                name = "22:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 30:
                name = "23:00";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
            case 31:
                name = "23:30";
                horary.setText(name);
                quota.setText(String.valueOf(emptys));

                break;
        }
        if (emptys != 0) {
            cardview.setCardBackgroundColor(Color.rgb(94, 186, 125));
            cardview.setOnClickListener(view -> {
                mItemListener.onItemClick(list, hora, position + 1,emptys);

            });
        } else
            cardview.setCardBackgroundColor(Color.rgb(255, 157, 143));
    }

}


