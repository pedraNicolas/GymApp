package com.alkemy.myapplication.core;

import static com.google.firebase.firestore.FirebaseFirestore.getInstance;



import com.google.firebase.firestore.FirebaseFirestore;

public interface DataBaseConection {
    FirebaseFirestore db = getInstance();
}
