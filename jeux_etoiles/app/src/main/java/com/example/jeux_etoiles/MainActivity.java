package com.example.jeux_etoiles;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.animation.ObjectAnimator;
import android.view.animation.TranslateAnimation;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            ImageView vaisseau = findViewById(R.id.imageView13);

            ImageView meteorite1 = findViewById(R.id.imageView12);

            ImageView meteorite2 = findViewById(R.id.imageView14);

            ImageView meteorite3 = findViewById(R.id.imageView11);

            ImageView meteorite4 = findViewById(R.id.imageView3);

            float rd_x = (float) (Math.random()*500);
            float rd_y = (float) (Math.random()*1000);
            //ObjectAnimator animator = ObjectAnimator.ofFloat(meteorite4, "translationY",rd_x, rd_y);
            Path path = new Path();
            path.arcTo(0f, 0f , 1000f, 1000f, 0f , −359f, true);
            animatorsOfAsteroid = ObjectAnimator.ofFloat(imageViewOfAsteroid, View.X, View.Y, path);
            animatorsOfAsteroid.setDuration(4000);
            animatorsOfAsteroid.setRepeatCount(Animation.INFINITE);
            animatorsOfAsteroid.start ();

            animator.setDuration(1000); // Durée de l'animation en millisecondes
            animator.start();

            meteorite3.setTranslationX(200);
            meteorite3.setTranslationY(1300);

            meteorite2.setTranslationX(500);
            meteorite2.setTranslationY(1000);

            meteorite1.setTranslationX(500);
            meteorite1.setTranslationY(500);

            vaisseau.setTranslationX(500);
            vaisseau.setTranslationY(150);

            return insets;
        });
    }

    public boolean onTouch(MotionEvent event) {

        float x0 = event.getX();
        float y0 =event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x0 = event.getX();
                y0 =event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float x1 = event.getX();
                float y1 = event.getY();
                float x = x1-x0;
                float y = y1-y0;
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
            }
        return true;
        }

    public boolean sontEnCollision(ImageView firstView, ImageView secondView) {
        int [] firstPosition = new int[2];
        int [] secondPosition = new int[2];
        firstView .getLocationOnScreen(firstPosition);
        secondView.getLocationOnScreen(secondPosition);

        Rect rectFirstView = new Rect(firstPosition [0], firstPosition [1],
                firstPosition [0] + firstView .getMeasuredWidth(), firstPosition [1] + firstView .getMeasuredHeight());
        Rect rectSecondView = new Rect(secondPosition[0], secondPosition[1],
                secondPosition[0] + secondView.getMeasuredWidth(), secondPosition[1] + secondView.getMeasuredHeight());
        return(rectFirstView. intersect (rectSecondView));
        }
    public class MainActivity extends Activity implements SensorEventListener {
        private SensorManager mSensorManager;
        private Sensor accelerometer;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity main);
            mSensorManager = (SensorManager) getSystemService(Context.SENSOR SERVICE); // on recupere l accelerometre a partir du SensorManager
            accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE ACCELEROMETER);// on associe l ecouteur d’evenements au SensorManager
            mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR DELAY NORMAL);
            }
        @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {// TODO Auto−generated method stub
            }
        @Override
    public void onSensorChanged(SensorEvent event) {// TODO Auto−generated method stub
            float gammaX = event.values[0], gammaY = event.values[1], gammaZ = event.values[2];
            Log.d(”Valeurs accelerometre”,gammaX+”,”+gammaY+”,”+gammaZ);
            }
        }

}