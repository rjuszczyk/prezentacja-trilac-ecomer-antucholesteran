package pl.pharmaway.prezentacjatrilac;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page10 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View item1 = view.findViewById(R.id.page9_1);
        View item2 = view.findViewById(R.id.page9_2);
        View item3 = view.findViewById(R.id.page9_3);

        if (savedInstanceState == null) {
            setInvisible(
                    item1,
                    item2,
                    item3
            );

            animateIn(500, inAnimator,

                    item1,
                    item2,
                    item3
            );
        } else {
            setVisible(

                    item1,
                    item2,
                    item3
            );
        }

        view.findViewById(R.id.button_sg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Page0.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page10;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page11();
    }
}
