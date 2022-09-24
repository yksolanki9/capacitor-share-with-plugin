package com.capacitor.plugins.sharewithplugin;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

        try {
            ContentResolver contentResolver = getContext().getContentResolver();

            Bitmap bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] bytes = stream.toByteArray();
            String imageBase64 = "data:image/jpeg;base64," + Base64.encodeToString(bytes, Base64.DEFAULT);

            String imageType = contentResolver.getType(uri);
            String[] imageTypeArr = imageType.split("/");
            String imageExt = imageTypeArr.length > 1 ? imageTypeArr[1] : "";

            imageData.put("base64", imageBase64);
            imageData.put("uri", uri.toString());
            imageData.put("ext", imageExt);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageData;
    }
}
