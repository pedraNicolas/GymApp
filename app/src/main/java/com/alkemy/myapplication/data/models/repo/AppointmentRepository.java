package com.alkemy.myapplication.data.models.repo;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.alkemy.myapplication.core.DataBaseConection;
import com.alkemy.myapplication.data.models.User;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class AppointmentRepository implements DataBaseConection {
    public void appointment(ArrayList<String> list, User user, int caso) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("empty")) {
                list.set(i, user.getUser());
                break;
            }
        }
        String horario = "horario" + String.valueOf(caso);
        System.out.println(horario);
        db.collection("electrofitness")
                .document("martes")
                .update(horario, list)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, "reemplazado");
                    }
                });
    }

    public boolean userAppointment(ArrayList<String> list,
                                   User user) {
        for (int i = 0;
             i < list.size();
             i++) {
            if (list.get(i).equals(user.getUser())) {
                return true;
            }
        }
        return false;

    }
}
