package com.example.dailymoodtracker;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.camera.view.PreviewView;
import androidx.camera.*;
import androidx.camera.core.*;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.zip.Inflater;


public class ProfileFragment  extends Fragment {

    public ProfileFragment() {

    }

    Button shareBtn;
    ImageView profilePicture;
    private PreviewView previewView;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        shareBtn = view.findViewById(R.id.buttonShare);
        profilePicture = view.findViewById(R.id.imageAddPicture);
        previewView = view.findViewById(R.id.previewView);

        cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext());

        shareBtn.setOnClickListener(view1 -> {
         Intent intent = new Intent(Intent.ACTION_SEND);
         startActivity(intent);

        });

        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                bindPreview(cameraProvider, previewView);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });


    }


}
