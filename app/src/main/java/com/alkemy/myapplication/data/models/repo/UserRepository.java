package com.alkemy.myapplication.data.models.repo;

import android.util.Log;

import com.alkemy.myapplication.core.DataBaseConection;
import com.alkemy.myapplication.data.models.User;
import com.alkemy.myapplication.databinding.ActivityUserResponseBinding;

import java.util.HashMap;
import java.util.Map;

public class UserRepository implements DataBaseConection {


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
    };

}
