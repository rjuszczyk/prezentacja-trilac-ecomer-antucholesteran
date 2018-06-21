package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Page5 extends FooterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page5;
    }

    @Override
    protected Class<?> getNextActivity() {
        return Page6.class;
    }

    @Override
    protected void onNextClicked() {
        ContainerActivity.start(this, Page6.class, false);
    }
}
