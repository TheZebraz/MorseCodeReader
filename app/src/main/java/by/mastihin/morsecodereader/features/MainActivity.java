package by.mastihin.morsecodereader.features;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.presenter.InjectPresenter;

import by.mastihin.morsecodereader.R;

public class MainActivity extends AppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.main_button);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    time = System.currentTimeMillis();
                    return true;
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    Log.d("TIME", Long.toString(System.currentTimeMillis() - time));
                    return true;
                }
                return false;
            }
        });
    }
}
