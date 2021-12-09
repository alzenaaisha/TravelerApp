package com.example.traveler;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.traveler.model.PariwisataModel;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    private TextView name, description, latitude, longitude;
    private ImageView thumbnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //menghilangkan action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        name = findViewById(R.id.nama_wisata_detail);
        description = findViewById(R.id.deskripsi_detail);
        latitude = findViewById(R.id.latitude_detail);
        longitude = findViewById(R.id.longitude_detail);
        thumbnail = findViewById(R.id.gambar_wisata_detail);

        name.setText(getIntent().getStringExtra("name"));
        description.setText(getIntent().getStringExtra( "description"));
        latitude.setText(getIntent().getStringExtra( "latitude"));
        longitude.setText(getIntent().getStringExtra("longitude"));
        Picasso.get().load(getIntent().getStringExtra("thumbnail"))
                .resize(1920,1080).placeholder(R.drawable.loading_image).error(R.drawable.error_image)
                .into(thumbnail);
    }

    public void openLocation(View view) {
        name.setText(getIntent().getStringExtra("name"));
        String loc = name.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}