package by.mastihin.morsecodereader.features;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private long time;

    public void onActionDown() {
        time = System.currentTimeMillis();
    }

    public void onActionUp() {
        showTime(System.currentTimeMillis() - time);
    }

    private void showTime(long touchLength) {
        getViewState().showTime(touchLength);
    }

}
