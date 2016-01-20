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
 * Open internet connection, and tet image URL from instagram in background.
 * Set simpleDraweeView to display the image
 *
 * Created by Anni Zhu on 12/11/15.
 */
public class InstagramApp extends AsyncTask<String, Void, String> {

    public static final String APIURL = "https://api.instagram.com/v1";
    private String imageUrlString;
    private Context mContext;
    private SimpleDraweeView mSimpleDraweeView;

    //constructor
    public InstagramApp(Context context, SimpleDraweeView simpleDraweeView){
        mContext = context;
        mSimpleDraweeView = simpleDraweeView;
    }

    @Override
    /**
     * Open internet connection, and tet image URL from instagram in background.
     * @param urls is access token
     */
    protected String doInBackground(String... urls) {

        String urlString = APIURL + "/users/self/media/recent?access_token=" + urls[0];

        try {
            //Open internet connection
            URL url = new URL(urlString);
            Log.i("URL", "Opening URL " + url.toString());
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //get input stream from the website, and convert it to string
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            String response = streamToString(in);
            urlConnection.disconnect();

            //Change the response into JSON
            JSONObject jsonObject = (JSONObject) new JSONTokener(response).nextValue();
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            //Get the url of frist image/latest image in low_resolution format
            JSONObject mainImageJsonObject = jsonArray.getJSONObject(0).getJSONObject("images").getJSONObject("low_resolution");
            imageUrlString = mainImageJsonObject.getString("url");
            Log.d("imageUrl", imageUrlString);

            return imageUrlString;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Set simpleDraweeView to display the image
     * @param result passed from doInBackground
     */
    @Override
    protected void onPostExecute(String result){
        Uri uri = Uri.parse(result);
        mSimpleDraweeView.setImageURI(uri);

        //Display Toast
        CharSequence latest = "This is the latest image from instagram!";
        CharSequence no = "Images from instagram can't be set as wallpaper or shared!";
        int duration = Toast.LENGTH_SHORT;
        Toast latestImage = Toast.makeText(mContext,latest,duration);
        latestImage.show();
        Toast sorry = Toast.makeText(mContext, no, duration);
        sorry.show();

    }

    /**
     *Convert the input stream to String
     */
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


