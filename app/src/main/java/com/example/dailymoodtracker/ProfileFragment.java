package com.example.dailymoodtracker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.camera.view.PreviewView;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.*;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.Manifest;
import android.os.Bundle;

import com.google.common.util.concurrent.ListenableFuture;

import java.io.File;
import java.util.zip.Inflater;


public class ProfileFragment  extends Fragment {

    public ProfileFragment() {

    }

    Button shareBtn, captureButton;
    Handler handler = new Handler();
    Runnable sendPicture;
    ImageView profilePicture;
    private PreviewView previewView;
    private ImageCapture imageCapture;
    String number = "39492949";
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
        captureButton = view.findViewById(R.id.buttonCapture);


        cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext());

        ShareViewModel viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);

        profilePicture.setOnClickListener(view3 -> {
            previewView.setVisibility(View.VISIBLE);
            cameraProviderFuture.addListener(() -> {
                try {
                    ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                    bindPreview(cameraProvider, previewView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, ContextCompat.getMainExecutor(requireContext()));
        });


        shareBtn.setOnClickListener(view1 -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + number));
            intent.putExtra("sms_body", "This is my profile");
            startActivity(intent);
        });

        captureButton.setOnClickListener(view4 -> {
            takePhoto();

        });

    }

    private void bindPreview(ProcessCameraProvider cameraProvider, PreviewView previewView) {
        Preview preview = new Preview.Builder().build();
        imageCapture = new ImageCapture.Builder().build();


        CameraSelector cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA;
        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        cameraProvider.unbindAll();
        cameraProvider.bindToLifecycle(
                getViewLifecycleOwner(),
                cameraSelector,
                preview, imageCapture
        );
    }

    private void takePhoto() {
        if (imageCapture == null) {
            return;
        }
        File fileOutput = new File(requireContext().getExternalFilesDir(null), System.currentTimeMillis() + ".jpg");

        ImageCapture.OutputFileOptions outputOptions = new ImageCapture.OutputFileOptions.Builder(fileOutput).build();

        imageCapture.takePicture(
                outputOptions,
                ContextCompat.getMainExecutor(requireContext()),
                new ImageCapture.OnImageSavedCallback() {
                    @Override
                    public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                        Toast.makeText(getContext(), "Image saved as profile picture", Toast.LENGTH_SHORT).show();
                        String filePath = fileOutput.getAbsolutePath();
                        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                        profilePicture.setImageBitmap(bitmap);


                        ShareViewModel viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
                        viewModel.setPhotoPath(filePath);

                        // Store the path in ViewModel
                        ShareViewModel viewModel1 = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
                        viewModel1.setPhotoPath(filePath);

                    }



                    @Override
                    public void onError(@NonNull ImageCaptureException exception) {
                        Toast.makeText(getContext(), "Image failed to save", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

}
