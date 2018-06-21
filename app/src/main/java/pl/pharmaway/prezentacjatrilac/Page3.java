package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewPropertyAnimator;

import pl.pharmaway.prezentacjatrilac.animation.DefaultAnimations;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

public class Page3 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View p2_1 = view.findViewById(R.id.p3_1);
        View p2_2 = view.findViewById(R.id.p3_2);
        View p2_3 = view.findViewById(R.id.p3_3);
        View p2_4 = view.findViewById(R.id.p3_4);

        if (savedInstanceState == null) {

            Cancelable c = animateInCombined(500,
                    new Object[]{DefaultAnimations.beforeComeFromLeft, DefaultAnimations.translateIn, p2_1},
                    new Object[]{DefaultAnimations.beforeFadeIn, DefaultAnimations.fadeIn, p2_2},
                    new Object[]{DefaultAnimations.beforeComeFromRight, DefaultAnimations.translateIn, p2_3},
                    new Object[]{DefaultAnimations.beforeFadeIn, DefaultAnimations.fadeIn, p2_4}
            );

        } else {
            setVisible(
                    p2_1,
                    p2_2,
                    p2_3,
                    p2_4
            );
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page3;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page4();
    }
}
