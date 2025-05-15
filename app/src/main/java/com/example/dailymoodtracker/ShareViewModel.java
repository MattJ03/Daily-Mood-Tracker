package com.example.dailymoodtracker;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

   private final MutableLiveData<String> photoPath = new MutableLiveData<>();

   public void setPhotoPath(String path) {
       photoPath.setValue(path);
   }

   public MutableLiveData<String> getPhotoPath() {
       return photoPath;
   }
}
