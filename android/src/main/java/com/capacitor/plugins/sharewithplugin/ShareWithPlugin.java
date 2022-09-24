package com.capacitor.plugins.sharewithplugin;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.util.HashMap;
import java.util.Map;

@CapacitorPlugin(name = "ShareWith")
public class ShareWithPlugin extends Plugin {

    @Override
    protected void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);

        String action = intent.getAction();
        Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);

        if (!Intent.ACTION_SEND.equals(action) || imageUri == null) {
            return;
        }

        Map<String, String> imageData = getImageDataFromUri(imageUri);

        JSObject ret = new JSObject();

        for (Map.Entry<String, String> entry : imageData.entrySet()) {
            ret.put(entry.getKey(), entry.getValue());
        }

        notifyListeners("imageShared", ret, true);
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
