package com.example.a1_navigation_activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.util.LruCache;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;



        public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
            private RecyclerAdapterApp.ViewHolder viewHolder;
            private LruCache<String, Bitmap> memoryCache;


            public DownloadImage(RecyclerAdapterApp.ViewHolder viewHolder, LruCache<String, Bitmap> memoryCache) {
                this.viewHolder = viewHolder;
                this.memoryCache = memoryCache;
            }

            @Override
            protected Bitmap doInBackground(String ...params) {
                Bitmap bitmap = memoryCache.get(params[0]);
                try {
                    if(bitmap==null){
                    HttpURLConnection connection = (HttpsURLConnection) new URL(params[0]).openConnection();
                    connection.setDoInput(true);
                    connection.connect();

                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    addBitmapToMemoryCache(params[0],bitmap);}
                }
                catch (Exception e)
                {
                    Log.d("MyApp", String.valueOf(e));
                }
                return bitmap;
            }
            public void addBitmapToMemoryCache(String url, Bitmap bitmap) {
                if(memoryCache.get(url)==null)
                    memoryCache.put(url,bitmap);
            }

            protected void onPostExecute(Bitmap result) {
                // Update the UI with the processed data on the main thread
                viewHolder.logo.setImageBitmap(result);
            }



}
