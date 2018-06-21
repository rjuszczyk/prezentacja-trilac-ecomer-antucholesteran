package pl.pharmaway.prezentacjatrilac;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page15 extends FooterFragment{

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View p15_1 = view.findViewById(R.id.p15_1);
        View p15_2 = view.findViewById(R.id.p15_2);
        View p15_3 = view.findViewById(R.id.p15_3);

        if (savedInstanceState == null) {
            setVisible(
                    p15_1,
                    p15_2,
                    p15_3
            );

            animateIn(500, outAnimator,
                    p15_1,
                    p15_2,
                    p15_3
            );
        } else {
            setVisible(
                    p15_1,
                    p15_2,
                    p15_3
            );
        }
    }

    @Override
    protected void onNextClicked() {
        Intent intent = new Intent(getActivity(), FormActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page15;
    }

    
    @Override
    protected Fragment getNextFragment() {
        return null;
    }
}
