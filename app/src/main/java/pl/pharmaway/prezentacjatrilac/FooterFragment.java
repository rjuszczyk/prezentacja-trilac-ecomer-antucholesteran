package pl.pharmaway.prezentacjatrilac;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.List;

import pl.pharmaway.prezentacjatrilac.animation.AnimationOperator;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

public abstract class FooterFragment extends Fragment {

    protected AnimationOperator inAnimator =  new AnimationOperator() {
        @Override
        public ViewPropertyAnimator apply(ViewPropertyAnimator animator) {
            return animator.alpha(1);
        }
    };

    protected AnimationOperator outAnimator =  new AnimationOperator() {
        @Override
        public ViewPropertyAnimator apply(ViewPropertyAnimator animator) {
            return animator.alpha(0);
        }
    };

    @Nullable private View buttonNext;
    @Nullable private View buttonPrev;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResourceId(), container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonPrev = view.findViewById(R.id.button_prev);
        buttonNext = view.findViewById(R.id.button_next);

        if (buttonNext != null) {
            buttonNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onNextClicked();
                }
            });
        }
        if (buttonPrev != null) {
            buttonPrev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onPrevClicked();
                }
            });
        }
    }

    protected CancelableDuration animateInCombined(final long initialDelay2, final Object[]... combined) {
        final long initialDelay = 0;
        final long delay = 0;//getDelay();
        final long duration = 0;//getDuration();

        final List<ViewPropertyAnimator> animations = new ArrayList<>();

        for (int i = 0; i < combined.length; i++) {
            View paragraph = (View) combined[i][2];
            FooterActivity.StateBeforeAnimation stateBeforeAnimation = (FooterActivity.StateBeforeAnimation) combined[i][0];
            AnimationOperator animationOpeartor = (AnimationOperator) combined[i][1];
            if(stateBeforeAnimation != null) {
                stateBeforeAnimation.stateBefore(paragraph);
            }
            ViewPropertyAnimator animation = animationOpeartor.apply(paragraph.animate())
                    .setDuration(duration)
                    .setStartDelay(initialDelay + i * delay + i * duration);
            animation.start();
            animations.add(animation);
        }

        return new CancelableDuration() {
            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public void cancel() {
                for (ViewPropertyAnimator animation : animations) {
                    animation.cancel();
                }
            }

            public int getAnimationLength() {
                return (int) (initialDelay + combined.length*(delay+duration)+duration);
            }
        };
    }

    interface CancelableDuration extends Cancelable {
        int getAnimationLength();
    }

    protected void onNextClicked() {
        Fragment nextFragment;
        if(isGoToSummary()) {
            nextFragment = new Page9();
        } else {
            nextFragment = getNextFragment();
        }

        if(nextFragment != null) {
            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, nextFragment)
                    .addToBackStack("pages")
                    .commit();
        } else {
            Intent intent = new Intent(getActivity(), FormActivity.class);
            getActivity().startActivity(intent);
        }
    }

    public boolean isGoToSummary() {
        return ((ContainerActivity)getActivity()).goToSummary;
    }

    protected void onPrevClicked() {
        if(((ContainerActivity)getActivity()).goToSummary) {
            getActivity().finish();
        } else {
            getActivity().onBackPressed();
        }
    }

    protected long getDelay() {
        return 100;
    }

    protected long getDuration() {
        return 800;
    }

    protected Cancelable animateIn(long initialDelay, AnimationOperator animationOpeartor, View... paragraphs) {
        initialDelay = 0;
        long delay = 0;//getDelay();
        long duration = 0;//getDuration();

        final List<ViewPropertyAnimator> animations = new ArrayList<>();

        for (int i = 0; i < paragraphs.length; i++) {
            View paragraph = paragraphs[i];
            ViewPropertyAnimator animation = animationOpeartor.apply(paragraph.animate())
                    .setDuration(duration)
                    .setStartDelay(initialDelay + i * delay + i * duration);
            animation.start();
            animations.add(animation);
        }

        return new Cancelable() {
            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public void cancel() {
                for (ViewPropertyAnimator animation : animations) {
                    animation.cancel();
                }
            }
        };
    }

    protected void setInvisible(View... paragraphs) {
        for (View paragraph : paragraphs) {
            paragraph.setAlpha(0);
        }
    }

    protected void setVisible(View... views) {
        for (View view : views) {
            view.setAlpha(1);
        }
    }

    @LayoutRes
    protected abstract int getLayoutResourceId();

    protected abstract Fragment getNextFragment();
}
