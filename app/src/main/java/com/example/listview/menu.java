package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class menu extends AppCompatActivity {

    private LinearLayout tulispesan;
    private LinearLayout inbox;
    private LinearLayout tentangkita;

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4,
            R.drawable.image_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.include_main);

        carouselView = findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        tulispesan = findViewById(R.id.tulispesan);
        inbox = findViewById(R.id.inbox);
        tentangkita = findViewById(R.id.tentangkita);

        tulispesan.setOnClickListener(new LinearLayout.OnClickListener() {
            @Override
            public void onClick(View v) {
                tulispesan();
            }
        });

        inbox.setOnClickListener(new LinearLayout.OnClickListener() {
            @Override
            public void onClick(View v) {
                inbox();
            }
        });

        tentangkita.setOnClickListener(new LinearLayout.OnClickListener() {
            @Override
            public void onClick(View v) {
                tentangkita();
            }
        });
    }


    private void tulispesan() {
        Intent i = new Intent((Context) this, write_message.class);
        startActivity(i);
    }

    private void inbox() {
        Intent i = new Intent((Context) this, inbox.class);
        startActivity(i);
    }

    private void tentangkita() {
        Intent i = new Intent((Context) this, tentang_kita.class);
        startActivity(i);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


}
