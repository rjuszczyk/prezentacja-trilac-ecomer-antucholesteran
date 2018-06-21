package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import pl.pharmaway.prezentacjatrilac.animation.DefaultAnimations;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

public class Page6 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View p2_1 = view.findViewById(R.id.p6_1);
        View p2_2 = view.findViewById(R.id.p6_2);
        View p2_3 = view.findViewById(R.id.p6_3);

        if (savedInstanceState == null) {

            Cancelable c = animateInCombined(500,
                    new Object[]{DefaultAnimations.beforeFadeIn, DefaultAnimations.fadeIn, p2_1},
                    new Object[]{DefaultAnimations.beforeFadeIn, DefaultAnimations.fadeIn, p2_2},
                    new Object[]{DefaultAnimations.beforeFadeIn, DefaultAnimations.fadeIn, p2_3}
            );

        } else {
            setVisible(
                    p2_1,
                    p2_2,
                    p2_3
            );
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page6;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page7();
    }
}
