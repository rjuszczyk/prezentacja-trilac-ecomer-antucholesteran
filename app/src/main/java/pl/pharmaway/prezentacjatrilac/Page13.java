package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page13 extends FooterFragment{

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View p13_1 = view.findViewById(R.id.p13_1);

        if (savedInstanceState == null) {
            setVisible(
                    p13_1
            );

            animateIn(500, outAnimator,

                    p13_1
            );
        } else {
            setVisible(
                    p13_1
            );
        }
    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page13;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page14();
    }
}
