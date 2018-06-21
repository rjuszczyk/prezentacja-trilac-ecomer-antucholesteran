package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import pl.pharmaway.prezentacjatrilac.animation.DefaultAnimations;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

public class Page12 extends FooterFragment{

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View p12_1 = view.findViewById(R.id.p12_1);
        View p12_2 = view.findViewById(R.id.p12_2);
        View p12_3 = view.findViewById(R.id.p12_3);
        View p12_4 = view.findViewById(R.id.p12_4);

        if (savedInstanceState == null) {
            setVisible(
                    p12_1,
                    p12_2,
                    p12_3,
                    p12_4
            );

            animateIn(500, outAnimator,

                    p12_1,
                    p12_2,
                    p12_3,
                    p12_4
            );
        } else {
            setVisible(
                    p12_1,
                    p12_2,
                    p12_3,
                    p12_4
            );
        }
    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page12;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page13();
    }
}
