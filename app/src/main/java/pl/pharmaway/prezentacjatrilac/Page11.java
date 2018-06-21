package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page11 extends FooterFragment{

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page11;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page12();
    }
}
