package pl.pharmaway.prezentacjatrilac;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;

import com.sprylab.android.widget.TextureVideoView;

import java.util.ArrayList;
import java.util.List;

import pl.pharmaway.prezentacjatrilac.animation.AnimationOperator;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

public abstract class FooterActivity extends AppCompatActivity {

    @Nullable private View buttonNext;
    @Nullable private View buttonPrev;
    private TextureVideoView mVideoView;
    TimeSpendInApp timeSpendInApp;
    long startTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        timeSpendInApp = new TimeSpendInApp(getSharedPreferences("appPrefs", Context.MODE_PRIVATE));

        getWindow().getDecorView().setSystemUiVisibility(
                SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                SYSTEM_UI_FLAG_FULLSCREEN |
                SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setContentView(getLayoutResourceId());
        mVideoView = findViewById(R.id.video_view);

        buttonPrev = findViewById(R.id.button_prev);
        buttonNext = findViewById(R.id.button_next);

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

        if(mVideoView != null) {
            initVideoView();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        long delta = System.currentTimeMillis() - startTime;
        timeSpendInApp.addTime(delta);
    }

    protected void onNextClicked() {
        Intent intent = new Intent(this, getNextActivity());
        startActivity(intent);
    }

    protected void onPrevClicked() {
        onBackPressed();
    }

    @LayoutRes
    protected abstract int getLayoutResourceId();

    protected abstract Class<?> getNextActivity();

    private void initVideoView() {
        mVideoView.setVideoPath(getVideoPath());
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(final MediaPlayer mp) {
                mVideoView.start();
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    public String getVideoPath() {
        return "android.resource://" + getPackageName() + "/" + R.raw.movie;
    }

    protected void setVisible(View... views) {
        for (View view : views) {
            view.setAlpha(1);
            view.setScaleX(1);
            view.setScaleY(1);
            view.setTranslationX(0);
        }
    }

    protected long getDelay() {
        return 500;
    }

    protected long getDuration() {
        return 1500;
    }

    protected Cancelable animateInCombined(final long initialDelay, final Object[]... combined) {
        final long delay = getDelay();
        final long duration = getDuration();

        final List<ViewPropertyAnimator> animations = new ArrayList<>();

        for (int i = 0; i < combined.length; i++) {
            View paragraph = (View) combined[i][2];
            StateBeforeAnimation stateBeforeAnimation = (StateBeforeAnimation) combined[i][0];
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

            public int getAnimationLength() {
                return (int) (initialDelay + combined.length*(delay+duration)+duration);
            }
        };
    }

    public interface StateBeforeAnimation {
        void stateBefore(View view);
    }
}
