package by.mastihin.morsecodereader.features;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTouch;
import by.mastihin.morsecodereader.R;

public class MainActivity extends MvpAppCompatActivity implements MainView, View.OnTouchListener {

    @InjectPresenter
    MainPresenter presenter;

    @BindView(R.id.textiew_main)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showTime(long touchLength) {
        textView.setText(getString(R.string.main_touch_lenght_format, touchLength));
    }

    @SuppressLint("ClickableViewAccessibility")
    @OnTouch(R.id.button_main)
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            presenter.onActionDown();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            presenter.onActionUp();
        }
        return false;
    }
}
