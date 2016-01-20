package com.example.imagecure.imagecure;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by anniland on 12/11/15.
 */
public class InstagramApp extends AsyncTask<String, Void, String> {

    public static final String APIURL = "https://api.instagram.com/v1";
    private String imageUrlString;
    private Context mContext;
    private SimpleDraweeView mSimpleDraweeView;



    //"384903007.a81889d.a76ab40a078f4a77b4af63fad54c8f3f";
    public InstagramApp(Context context, SimpleDraweeView simpleDraweeView){
        mContext = context;
       mSimpleDraweeView = simpleDraweeView;
    }

    @Override
    protected String doInBackground(String... urls) {

        String urlString = APIURL + "/users/self/media/recent?access_token=" + urls[0];

        try {
            URL url = new URL(urlString);
            Log.i("URL", "Opening URL " + url.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String response = streamToString(in);
            Log.i("response", response);
            urlConnection.disconnect();

            JSONObject jsonObject = (JSONObject) new JSONTokener(response).nextValue();
            JSONArray jsonArray = jsonObject.getJSONArray("data");

            JSONObject mainImageJsonObject = jsonArray.getJSONObject(0).getJSONObject("images").getJSONObject("low_resolution");
            imageUrlString = mainImageJsonObject.getString("url");
            Log.d("imageUrl", imageUrlString);

            return imageUrlString;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    @Override
    protected void onPostExecute(String result){
        Uri uri = Uri.parse(result);
        mSimpleDraweeView.setImageURI(uri);
        String format = result.substring(result.length() - 3);
        if(format.equalsIgnoreCase("gif")){
            //Context context = getApplicationContext();
            CharSequence no = "gif can't be set as wallpaper or shared!";
            int duration = Toast.LENGTH_SHORT;
            Toast sorry = Toast.makeText(mContext, no, duration);
            sorry.show();
        }
    }


    private String streamToString(InputStream is) throws IOException {
        String str = "";

        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is));

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                reader.close();
            } finally {
                is.close();
            }

            str = sb.toString();
        }

        return str;
    }
}


