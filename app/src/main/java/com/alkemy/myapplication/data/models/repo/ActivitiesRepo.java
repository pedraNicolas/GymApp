package com.alkemy.myapplication.data.models.repo;

import static com.alkemy.myapplication.core.DataBaseConection.db;

import androidx.annotation.NonNull;

import com.alkemy.myapplication.data.models.GymActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

enum actividades {
    electrofitness
}

public class ActivitiesRepo {
    //GymActivity electrofitness = new GymActivity();
        public void getActivities(String a) {
        db.collection("electrofitness").document("lunes").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot document = task.getResult();
                GymActivity gymActivity = document.toObject(GymActivity.class);
                System.out.println(gymActivity);
                System.out.println(gymActivity.getName());
                System.out.println(gymActivity.getDays());
                System.out.println("hola");
            }
        });
    }
}
//new OnSuccessListener<DocumentSnapshot>() {
//@Override
//public void onSuccess(DocumentSnapshot documentSnapshot) {
//        if (documentSnapshot.exists()) {
//        activity = documentSnapshot.toObject(GymActivities.class);
//        }
//        }
//
//        });
