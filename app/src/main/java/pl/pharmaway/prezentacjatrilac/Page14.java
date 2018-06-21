package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page14 extends FooterFragment{

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View p12_1 = view.findViewById(R.id.p14_1);
        View p12_2 = view.findViewById(R.id.p14_2);

        if (savedInstanceState == null) {
            setVisible(
                    p12_1,
                    p12_2
            );

            animateIn(500, outAnimator,

                    p12_1,
                    p12_2
            );
        } else {
            setVisible(
                    p12_1,
                    p12_2
            );
        }
    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page14;
    }


    @Override
    protected Fragment getNextFragment() {
        return new Page15();
    }
}
