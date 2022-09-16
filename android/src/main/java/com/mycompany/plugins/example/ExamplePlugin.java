package com.mycompany.plugins.example;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@CapacitorPlugin(name = "Example")
public class ExamplePlugin extends Plugin {

    @Override
    protected void handleOnNewIntent(Intent intent) {
        super.handleOnNewIntent(intent);

        String action = intent.getAction();
        Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);

        if (!Intent.ACTION_SEND.equals(action) || imageUri == null) {
            return;
        }

        String base64EncodedString = getBase64StringFromUri(imageUri);

        JSObject ret = new JSObject();
        ret.put("base64Image", base64EncodedString);
        notifyListeners("imageShared", ret, true);

    }

    public String getBase64StringFromUri(Uri uri) {
        String base64String = "";
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

            byte[] bytes = stream.toByteArray();

            base64String = "data:image/jpg;base64," + Base64.encodeToString(bytes, Base64.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64String;
    }
}
