package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

import java.util.Date;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class PostDetailsActivity extends AppCompatActivity {
    private TextView tvDetailsUsername;
    private ImageView ivDetailsImage;
    private TextView tvDetailsDescription; //null
    private TextView timeStamp;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);
        // get post
        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        Date createdAt = post.getCreatedAt();
        String timeAgo = post.calculateTimeAgo(createdAt);
        //Bind the post data to the view elements
        tvDetailsUsername = findViewById(R.id.tvDetailsUsername);
        tvDetailsDescription = findViewById(R.id.tvDetailsDescription);
        ivDetailsImage = findViewById(R.id.ivDetailsImage);
        timeStamp = findViewById(R.id.timeStamp);

        tvDetailsDescription.setText(post.getDescription());
        tvDetailsUsername.setText(post.getUser().getUsername());
        timeStamp.setText(timeAgo);
        ParseFile image = post.getImage();
        if (image != null) {
            int radius = 100; // corner radius, higher value = more rounded
            int margin = 0; // crop margin, set to 0 for corners with no crop
            GlideApp.with(this)
                    .load(image.getUrl())
                    .fitCenter() // scale image to fill the entire ImageView
                    .transform(new RoundedCornersTransformation(radius, margin))
                    .into(ivDetailsImage);
        }
    }
}