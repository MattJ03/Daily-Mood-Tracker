package com.example.dailymoodtracker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.app.*;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import java.util.zip.Inflater;


public class ProfileFragment  extends Fragment {

    Button shareBtn;
    ImageView profilePicture

    public ProfileFragment() { //empty constrcutor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState)


}
