package model;

import android.content.Context;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

import javax.json.JsonReader;

/**
 * Created by Hossam on 4/6/2016.
 */
public class JsonHandler {
    private Context mContext;

    public JsonHandler(Context mContext) {
        this.mContext = mContext;
    }

    public Data loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = mContext.getAssets().open("default.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        Gson gson = new Gson();
        Type DataType = new TypeToken<Data>() {
        }.getType();

        json=json.replace(" ","");

        Data data = gson.fromJson(json, DataType);
        return data;

    }
}
