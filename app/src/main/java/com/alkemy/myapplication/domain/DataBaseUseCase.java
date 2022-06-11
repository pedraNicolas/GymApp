package com.alkemy.myapplication.domain;

import com.alkemy.myapplication.core.DataBaseConection;
import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.data.models.repo.UserRepository;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.Map;

public class DataBaseUseCase implements DataBaseConection {
    UserRepository userRepository = new UserRepository();
    public void setUser( String id,
                         String name,
                         String user,
                         String password,
                         int token,
                         int cellphone){
        userRepository.setUserData(id,name,user,password,token,cellphone);

    }

//    static void saveUser(String document, Map<String, Object> userDates){
//        db.collection("users").document(document).set(userDates);
//    }
//    static void getUser(String document){
//        db.collection("users").get().addOnSuccessListener(new OnSuccessListener(){
//
//
//
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                Map<String, Object> user = documentSnapshot.getData();
//            }
//        });
//    }
}
