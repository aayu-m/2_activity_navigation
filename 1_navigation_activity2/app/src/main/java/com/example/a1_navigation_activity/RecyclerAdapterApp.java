package com.example.a1_navigation_activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterApp extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int type =1;
    private final Context context;
    private final List<Object>list;
    private final LruCache<String, Bitmap> memoryCache;


    public RecyclerAdapterApp(Context context, List<Object>list, LruCache<String, Bitmap> memoryCache){
        this.context= context;
        this.list=list;
        this.memoryCache=memoryCache;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView appName;
        private TextView appDeveloper;
        private TextView appDesc;
        public ImageView logo;

        private Button addApp;

        public ViewHolder(@NonNull View view){
            super(view);
            appName = (TextView) view.findViewById(R.id.appName);
            appDesc = (TextView) view.findViewById(R.id.appDesc);
            appDeveloper = (TextView) view.findViewById(R.id.appDeveloper);
            logo = (ImageView) view.findViewById(R.id.logo);
            addApp= (Button) view.findViewById(R.id.addApp);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_app, parent, false);
        return new ViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewholder, int position) {
        ViewHolder viewHolder = (ViewHolder) viewholder;
        Application app = (Application) list.get(position);

        viewHolder.appName.setText(app.getAppName());
        viewHolder.appDeveloper.setText(app.getAppDeveloper());
        viewHolder.appDesc.setText(app.getAppDescription());

        String url = app.getLogoLink();



       new DownloadImage(viewHolder,memoryCache).execute(url);
        viewHolder.addApp.setOnClickListener( new View.OnClickListener(){
                @Override
        public void onClick(View v) {
                    Log.d("MyApp", "onCreate: working");
                    showToast("add an app");
                }

        });


    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

    }

}
