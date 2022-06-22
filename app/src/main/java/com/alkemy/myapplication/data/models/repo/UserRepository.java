package com.alkemy.myapplication.data.models.repo;

import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.alkemy.myapplication.core.DataBaseConection;
import com.alkemy.myapplication.core.FirebaseAuthConection;
import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.ui.view.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.DocumentSnapshot;
import java.util.HashMap;
import java.util.Map;


public class UserRepository extends AppCompatActivity implements DataBaseConection, FirebaseAuthConection {

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
                            Long token,
                            Long cellphone) {

        Map<String, Object> userHashMap = new HashMap<>();
        userHashMap.put("id", id);
        userHashMap.put("name", name);
        userHashMap.put("user", user);
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
                    Toast.makeText(MainActivity.getInstance(), "Login Correcto", Toast.LENGTH_SHORT).show();
                    Log.d("Auth", "Inicio de sesion correcto");
                    db.collection("users").document(user).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            DocumentSnapshot document = task.getResult();
                            usuario = document.toObject(User.class);
                            Log.d("Auth", usuario.getName());
                            Log.d("Auth", usuario.getUser());
                            String token = usuario.getToken().toString();
                            Log.d("Auth", token );
                            MainActivity.getInstance().showHome(usuario);
                        }
                    });
                } else {
                    Log.d("Auth", "Usuario o contraseña incorrecta");
                    Toast.makeText(MainActivity.getInstance(), "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

    public void getUser(String user) {

//        db.collection("users").document(user).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                DocumentSnapshot document = task.getResult();
//                usuario = document.toObject(User.class);
//                Log.d("Auth", usuario.getName());
//            }
//        });
//        return usuario;
//
//    }

    }
}







