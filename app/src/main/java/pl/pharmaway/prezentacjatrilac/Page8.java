package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import pl.pharmaway.prezentacjatrilac.animation.DefaultAnimations;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

public class Page8 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View p2_2 = view.findViewById(R.id.p8_2);
        View p2_3 = view.findViewById(R.id.p8_3);
        View p2_4 = view.findViewById(R.id.p8_4);

        if (savedInstanceState == null) {

            Cancelable c = animateInCombined(500,

                    new Object[]{DefaultAnimations.beforeFadeIn, DefaultAnimations.fadeIn, p2_2},
                    new Object[]{DefaultAnimations.beforeFadeAndScaleIn, DefaultAnimations.scaleIn, p2_3},
                    new Object[]{DefaultAnimations.beforeFadeIn, DefaultAnimations.fadeIn, p2_4}
            );

        } else {
            setVisible(
                    p2_4,
                    p2_2,
                    p2_3
            );
        }
    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page8;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page9();
    }
}
