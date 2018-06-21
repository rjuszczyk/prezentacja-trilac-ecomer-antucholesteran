package pl.pharmaway.prezentacjatrilac;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewPropertyAnimator;

import pl.pharmaway.prezentacjatrilac.animation.AnimationOperator;
import pl.pharmaway.prezentacjatrilac.animation.DefaultAnimations;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

public class Page4 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View p2_1 = view.findViewById(R.id.p4_1);
        View p2_2 = view.findViewById(R.id.p4_2);
        View p2_3 = view.findViewById(R.id.p4_3);

        if (savedInstanceState == null) {

            Cancelable c = animateInCombined(500,
                    new Object[]{DefaultAnimations.beforeComeFromLeft, DefaultAnimations.translateIn, p2_1});
            CancelableDuration c2 = animateInCombined(500,
                    new Object[]{DefaultAnimations.beforeComeFromLeft, DefaultAnimations.translateIn, p2_2});

            CancelableDuration c3 = animateInCombined(c2.getAnimationLength(),
                    new Object[]{DefaultAnimations.beforeFadeIn, DefaultAnimations.fadeIn, p2_3});

        } else {
            setVisible(
                    p2_1,
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
        return R.layout.page4;
    }

    @Override
    protected Fragment getNextFragment() {
        throw new RuntimeException("unused");
    }

    @Override
    protected void onNextClicked() {
        Intent intent = new Intent(getActivity(), Page5.class);
        startActivity(intent);
    }
}
