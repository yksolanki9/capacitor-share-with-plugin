package com.mycompany.plugins.example;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Example")
public class ExamplePlugin extends Plugin {

//    private Example implementation = new Example();
//
//    @PluginMethod
//    public void echo(PluginCall call) {
//        String value = call.getString("value");
//
//        JSObject ret = new JSObject();
//        ret.put("value", implementation.echo(value));
//        call.resolve(ret);
//    }

    @Override
    public void load() {
        Intent intent = new Intent();
        String intentAction = intent.getAction();
        String intentType = intent.getType();

        if(Intent.ACTION_SEND.equals(intentAction) && intentType.startsWith("image")) {
            Log.d("test", intentType);
            Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
            JSObject ret = new JSObject();
            ret.put("imageUri", imageUri);
            notifyListeners("imageShared", ret);
        }
        getActivity().startActivity(intent);
    }

}
