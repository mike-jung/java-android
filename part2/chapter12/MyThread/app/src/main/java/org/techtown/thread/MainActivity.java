package org.techtown.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageView2;
    EditText editText;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        editText = findViewById(R.id.editTextTextPersonName);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DogThread thread1 = new DogThread(0);
                thread1.start();

                DogThread thread2 = new DogThread(1);
                thread2.start();
            }
        });
    }

    class DogThread extends Thread {
        int dogIndex;
        int stateIndex;

        ArrayList<Integer> images = new ArrayList<Integer>();

        public DogThread(int index) {
            dogIndex = index;

            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_running);
            images.add(R.drawable.dog_biting);
        }

        public void run() {
            stateIndex = 0;
            for (int i = 0; i < 9; i++) {
                final String msg = "dog #" + dogIndex + " state : " + stateIndex;

                handler.post(new Runnable() {
                    public void run() {
                        editText.append(msg + "\n");

                        if (dogIndex == 0) {
                            imageView.setImageResource(images.get(stateIndex));
                        } else if (dogIndex == 1) {
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }
                });

                try {
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stateIndex++;
                if (stateIndex >= images.size()) {
                    stateIndex = 0;
                }
            }
        }

        public int getRandomTime(int min, int max) {
            return min + (int)(Math.random() * (max - min));
        }
    }

}
