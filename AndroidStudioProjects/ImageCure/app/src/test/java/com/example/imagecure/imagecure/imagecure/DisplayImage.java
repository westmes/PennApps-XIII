package com.example.imagecure.imagecure;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.io.IOException;
import java.util.Random;


public class DisplayImage extends AppCompatActivity {

    private Uri uri;
    Context context;
    String imageUrl;
    String format;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig
                .newBuilder(context)
                .setDownsampleEnabled(true)
                .build();


        Fresco.initialize(context,imagePipelineConfig);
        setContentView(R.layout.activity_display_image);

        Intent intent = getIntent();
        int i = intent.getIntExtra("Button", 0);
        int animal = intent.getIntExtra("ImageSet", 0);

        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);

        Random rand = new Random();
        int j = rand.nextInt(5);
        if (animal == 1) {
            ImageSet_cat imageSet = new ImageSet_cat();
            uri = Uri.parse(imageSet.getImage(i, j));
            String str = imageSet.getImage(i,j);
            format = str.substring(str.length() - 3);
        } else {
            ImageSet_dog imageSet = new ImageSet_dog();
            uri = Uri.parse(imageSet.getImage(i, j));
            String str = imageSet.getImage(i,j);
            format = str.substring(str.length() - 3);
        }

        draweeView.setImageURI(uri);

        if(format.equalsIgnoreCase("gif")){
            CharSequence no = "gif can't be set as wallpaper or shared!";
            int duration = Toast.LENGTH_SHORT;
            Toast sorry = Toast.makeText(context, no, duration);
            sorry.show();
        }

        ControllerListener listener = new BaseControllerListener() {

           // @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (imageInfo == null) {
                    return;
                }
                QualityInfo qualityInfo = imageInfo.getQualityInfo();
                FLog.d("Final image received! " +
                                "Size %d x %d",
                        "Quality level %d, good enough: %s, full quality: %s",
                        imageInfo.getWidth(),
                        imageInfo.getHeight(),
                        qualityInfo.getQuality(),
                        qualityInfo.isOfGoodEnoughQuality(),
                        qualityInfo.isOfFullQuality());

            }

            //@Override
            public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
                FLog.d("Intermediate image received", "Intermediate image received");
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                FLog.e(getClass(), throwable, "Error loading %s", id);
            }
        };

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .setTapToRetryEnabled(true)
                .setOldController(draweeView.getController())
                .setControllerListener(listener)
                .build();

        draweeView.setController(controller);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.menu_display, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        final int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        ImagePipeline imagePipeline = Fresco.getImagePipeline();

        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(uri)
                .setRequestPriority(Priority.HIGH)
                .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                .build();

        final DataSource<CloseableReference<CloseableImage>> dataSource =
                imagePipeline.fetchDecodedImage(imageRequest, context);

        try {
            dataSource.subscribe(new BaseBitmapDataSubscriber() {
                @Override
                public void onNewResultImpl(@Nullable Bitmap bitmap) {
                    if (bitmap == null) {
                        Log.d("bitMapNull", "Bitmap data source returned success, but bitmap null.");
                    }
                    if (id == R.id.action_setwallpaper) {
                        setWallPaper(bitmap);
                        return;
                    }else if(id == R.id.menu_item_share) {
                        shareBitmap(bitmap);
                        return;                 }
                }

                @Override
                public void onFailureImpl(DataSource dataSource) {
                        // No cleanup required here
                }
            }, CallerThreadExecutor.getInstance());
        } finally {
            if (dataSource != null) {
                dataSource.close();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void setWallPaper(Bitmap bitmap){

        Context context = getApplicationContext();
        CharSequence set = "Set as Wallpaper! ";
        int duration = Toast.LENGTH_SHORT;
        Toast success = Toast.makeText(context, set, duration);

        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(),
                bitmap, "Image Description", null);
        WallpaperManager wpm = WallpaperManager.getInstance(this);
        try{
            wpm.setBitmap(bitmap);
            success.show();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public void shareBitmap(Bitmap bitmap) {

        String path = MediaStore.Images.Media.insertImage(context.getContentResolver(),
                bitmap, "Image Description", null);

        Uri bmpUri = Uri.parse(path);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "Share Image"));


    }


}

