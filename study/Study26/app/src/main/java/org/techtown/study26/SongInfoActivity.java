package org.techtown.study26;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SongInfoActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;
    ImageView imageView;

    int imageId = R.drawable.song;

    Animation fadeInAnim;
    Animation fadeOutAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_info);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        imageView = findViewById(R.id.imageView);

        fadeInAnim = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadeOutAnim = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        fadeOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                changeImage();
                imageView.startAnimation(fadeInAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        Button closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.startAnimation(fadeOutAnim);
            }
        });

    }

    public void changeImage() {
        if (imageId == R.drawable.song) {
            imageId = R.drawable.song2;
            imageView.setImageResource(imageId);
        } else if (imageId == R.drawable.song2) {
            imageId = R.drawable.song3;
            imageView.setImageResource(imageId);
        } else if (imageId == R.drawable.song3) {
            imageId = R.drawable.song;
            imageView.setImageResource(imageId);
        }
    }

    public void saveData() {
        String name = input1.getText().toString();
        String singer = input2.getText().toString();

        Intent dataIntent = new Intent();
        dataIntent.putExtra("name", name);
        dataIntent.putExtra("singer", singer);
        dataIntent.putExtra("imageId", imageId);
        setResult(101, dataIntent);

        finish();
    }

}