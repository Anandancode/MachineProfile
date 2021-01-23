package com.machinetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView myVideosRCYLV;
    private LinearLayout myVideoLAY, myLikedLAY;
    private ImageView myMenuIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        classAndWidgetInitialize();
    }

    private void classAndWidgetInitialize() {
        myVideosRCYLV = (RecyclerView) findViewById(R.id.activity_main_RCYLV_videos);
        myVideoLAY = (LinearLayout) findViewById(R.id.activity_main_LAY_videos);
        myLikedLAY = (LinearLayout) findViewById(R.id.activity_main_LAY_liked);
        myMenuIMG = (ImageView) findViewById(R.id.activity_main_IMG_menu);

        clickListener();
        loadData();
    }

    private void clickListener() {
        myVideoLAY.setOnClickListener(this);
        myLikedLAY.setOnClickListener(this);
        myMenuIMG.setOnClickListener(this);
    }

    private void loadData() {
        GridLayoutManager manager = new GridLayoutManager(MainActivity.this, 3, GridLayoutManager.VERTICAL, false);
        myVideosRCYLV.setLayoutManager(manager);
        myVideosRCYLV.setNestedScrollingEnabled(false);
        VideosRecylerAdapter aMainRecyclerAdapter = new VideosRecylerAdapter(MainActivity.this);
        myVideosRCYLV.setAdapter(aMainRecyclerAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_LAY_videos:
                myVideoLAY.setAlpha(1f);
                myLikedLAY.setAlpha(0.5f);
                loadData();
                break;

            case R.id.activity_main_LAY_liked:
                myLikedLAY.setAlpha(1f);
                myVideoLAY.setAlpha(0.5f);
                loadData();
                break;

            case R.id.activity_main_IMG_menu:
                showMenuDialog();
                break;
        }
    }

    private void showMenuDialog() {
        final Dialog aPopDialog = new Dialog(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        aPopDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        final View aDialogView = inflater.inflate(R.layout.dialog_share, null);
        Window window = aPopDialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.TOP | Gravity.RIGHT;
        wlp.width = LinearLayout.LayoutParams.MATCH_PARENT;
        wlp.y = 70;  //if you want give margin from top
        wlp.x = 50;
      //  wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        aPopDialog.setContentView(aDialogView);
        aPopDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        aPopDialog.show();
    }
}