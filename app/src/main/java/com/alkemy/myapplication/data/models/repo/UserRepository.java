package com.alkemy.myapplication.data.models.repo;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.alkemy.myapplication.core.DataBaseConection;
import com.alkemy.myapplication.core.FirebaseAuthConection;
import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.data.network.services.encrypter.EncrypterServiceImplement;
import com.alkemy.myapplication.databinding.ActivityUserResponseBinding;
import com.alkemy.myapplication.ui.view.MainActivity;
import com.alkemy.myapplication.ui.view.NewUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Authentication;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository extends AppCompatActivity implements DataBaseConection, FirebaseAuthConection {


    EncrypterServiceImplement encrypterServiceImplement = new EncrypterServiceImplement();
    User usuario;
    boolean auth;


    public void createUser(String user,
                           String password) {
        mAuth.createUserWithEmailAndPassword(user, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("SingIn", "Usuario dado de alta");
                }
            }
        });
    }

    public void setUserData(String id,
                            String name,
                            String user,
                            String password,
                            int token,
                            int cellphone) {

        Map<String, Object> userHashMap = new HashMap<>();
        userHashMap.put("id", id);
        userHashMap.put("name", name);
        userHashMap.put("user", user);
        userHashMap.put("password", password);
        userHashMap.put("token", token);
        db.collection("users").document(user).set(userHashMap);
        System.out.println(userHashMap);
        Log.d("SingInUser", "Usuario creado");
    }


    public void login(String user,
                 String password) {

        mAuth.signInWithEmailAndPassword(user, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("Auth", "Inicio de sesion correcto");
                    MainActivity.getInstance().showHome();
                    Toast.makeText(MainActivity.getInstance(), "Login Correcto", Toast.LENGTH_SHORT).show();

                } else {
                    Log.d("Auth", "Usuario o contraseña incorrecta");
                    Toast.makeText(MainActivity.getInstance(), "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

}







