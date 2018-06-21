package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page7 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View item1 = view.findViewById(R.id.p7_1);
        View item2 = view.findViewById(R.id.p7_2);
        View item3 = view.findViewById(R.id.p7_3);
        View item4 = view.findViewById(R.id.p7_4);

        if (savedInstanceState == null) {
            setInvisible(
                    item1,
                    item2,
                    item3,
                    item4
            );

            animateIn(500, inAnimator,

                    item1,
                    item2,
                    item3,
                    item4
            );
        } else {
            setVisible(
                    item1,
                    item2,
                    item3,
                    item4
            );
        }
    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page7;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page8();
    }
}
