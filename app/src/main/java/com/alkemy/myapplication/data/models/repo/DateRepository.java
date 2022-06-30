package com.alkemy.myapplication.data.models.repo;

import androidx.annotation.NonNull;

import com.alkemy.myapplication.core.DataBaseConection;
import com.alkemy.myapplication.data.models.Shifts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DateRepository implements DataBaseConection {
       public void date(final DateRepositoryCallBack myCallBack) {
        db.collection("electrofitness").document("martes").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Shifts shifts = document.toObject(Shifts.class);
                    Map<String, Object> shiftsHashMap = new HashMap<>();
                    shiftsHashMap.put("08:00", shifts.getHorario1());
                    shiftsHashMap.put("08:30", shifts.getHorario2());
                    shiftsHashMap.put("09:00", shifts.getHorario3());
                    shiftsHashMap.put("09:30", shifts.getHorario4());
                    shiftsHashMap.put("10:00", shifts.getHorario5());
                    shiftsHashMap.put("10:30", shifts.getHorario6());
                    shiftsHashMap.put("11:00", shifts.getHorario7());
                    shiftsHashMap.put("11:30", shifts.getHorario8());
                    shiftsHashMap.put("12:00", shifts.getHorario9());
                    shiftsHashMap.put("12:30", shifts.getHorario10());
                    shiftsHashMap.put("13:00", shifts.getHorario11());
                    shiftsHashMap.put("13:30", shifts.getHorario12());
                    shiftsHashMap.put("14:00", shifts.getHorario13());
                    shiftsHashMap.put("14:30", shifts.getHorario14());
                    shiftsHashMap.put("15:00", shifts.getHorario15());
                    shiftsHashMap.put("15:30", shifts.getHorario16());
                    shiftsHashMap.put("16:00", shifts.getHorario17());
                    shiftsHashMap.put("16:30", shifts.getHorario18());
                    shiftsHashMap.put("17:00", shifts.getHorario19());
                    shiftsHashMap.put("17:30", shifts.getHorario20());
                    shiftsHashMap.put("18:00", shifts.getHorario21());
                    shiftsHashMap.put("18:30", shifts.getHorario22());
                    shiftsHashMap.put("19:00", shifts.getHorario23());
                    shiftsHashMap.put("19:30", shifts.getHorario24());
                    shiftsHashMap.put("20:00", shifts.getHorario25());
                    shiftsHashMap.put("20:30", shifts.getHorario26());
                    shiftsHashMap.put("21:00", shifts.getHorario27());
                    shiftsHashMap.put("21:30", shifts.getHorario28());
                    shiftsHashMap.put("22:00", shifts.getHorario29());
                    shiftsHashMap.put("22:30", shifts.getHorario30());
                    shiftsHashMap.put("23:00", shifts.getHorario31());
                    List<Object> list = new ArrayList<>(shiftsHashMap.values());
                    myCallBack.onCallback(shiftsHashMap);
                }
            }
        });

    }

}
