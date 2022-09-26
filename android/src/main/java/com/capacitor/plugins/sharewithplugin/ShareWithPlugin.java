package com.capacitor.plugins.sharewithplugin;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@CapacitorPlugin(name = "ShareWith")
public class ShareWithPlugin extends Plugin {

    @Override
    protected void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);
        String action = intent.getAction();

        if (!Intent.ACTION_SEND.equals(action) && !Intent.ACTION_SEND_MULTIPLE.equals(action)) {
            return;
        }

        if(Intent.ACTION_SEND.equals(action)) {
            Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
            if(imageUri == null) {
                return;
            }

            Map<String, String> imageData = getImageDataFromUri(imageUri);
            JSObject ret = new JSObject();
            for (Map.Entry<String, String> entry : imageData.entrySet()) {
                ret.put(entry.getKey(), entry.getValue());
            }
            notifyListeners("FILE_SINGLE", ret, true);
        } else {
            ArrayList<Uri> imageUriArray = intent.getParcelableArrayListExtra(Intent.EXTRA_STREAM);

            if(imageUriArray == null) {
                return;
            }

            JSObject retArray = new JSObject();
            for(int i = 0; i < imageUriArray.size(); i++) {
                Map<String, String> imageData = getImageDataFromUri(imageUriArray.get(i));
                JSObject ret = new JSObject();
                for (Map.Entry<String, String> entry : imageData.entrySet()) {
                    ret.put(entry.getKey(), entry.getValue());
                }
                retArray.put(Integer.toString(i), ret);
            }
            notifyListeners("FILE_MULTIPLE", retArray, true);
        }
    }

    public Map<String, String> getImageDataFromUri(Uri uri) {
        Map<String, String> imageData = new HashMap<>();
        ContentResolver contentResolver = getContext().getContentResolver();

        String imageType = contentResolver.getType(uri);
        String[] imageTypeArr = imageType.split("/");
        String imageExt = imageTypeArr.length > 1 ? imageTypeArr[1] : "";

        imageData.put("uri", uri.toString());
        imageData.put("ext", imageExt);

        return imageData;
    }
}
