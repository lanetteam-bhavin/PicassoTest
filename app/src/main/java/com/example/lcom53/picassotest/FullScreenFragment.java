package com.example.lcom53.picassotest;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullScreenFragment extends DialogFragment {
    private int mShortAnimationDuration;
    boolean requestAnimation = false;
    View mView, thumbView;
    Bitmap mResId;

    public static FullScreenFragment newInstance() {
        return new FullScreenFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.CardDetailsDialogStyle);
        if (ivFullScreen != null) {
            if (requestAnimation && mView != null && thumbView != null && mResId != null) {
                showAnimation(mView, thumbView, mResId);
            }
        }
    }

    public ImageView getIvFullScreen() {
        return ivFullScreen;
    }

    ImageView ivFullScreen;

    public FullScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getDialog() != null) {
            getDialog().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getDialog().getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getDialog().getWindow().setStatusBarColor(Color.RED);
            }
        }
        if (ivFullScreen != null) {
            if (requestAnimation && mView != null && thumbView != null && mResId != null) {
                showAnimation(mView, thumbView, mResId);
            }
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mShortAnimationDuration = activity.getResources().getInteger(android.R.integer.config_longAnimTime);
    }

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.full_screen, container, false);
        ivFullScreen = (ImageView) rootView.findViewById(R.id.ivFullScreen);
        if (ivFullScreen != null) {
            if (requestAnimation && mView != null && thumbView != null && mResId != null) {
                showAnimation(mView, thumbView, mResId);
            }
        }
        return rootView;
    }

    //    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        LayoutInflater inflater = getActivity().getLayoutInflater();
//        rootView = inflater.inflate(R.layout.full_screen, null);
//        ivFullScreen = (ImageView) rootView.findViewById(R.id.ivFullScreen);
//        builder.setView(rootView);
//        // Create the AlertDialog object and return it
//        return builder.create();
//    }
    Animator mCurrentAnimator;

    public void showAnimation(View MainView, final View thumbView, Bitmap imageResId) {
        requestAnimation = true;
        if (ivFullScreen == null) {
            mView = MainView;
            this.thumbView = thumbView;
            this.mResId = imageResId;
            return;
        }
        if (mCurrentAnimator != null) {
            mCurrentAnimator.cancel();
        }
        // Load the high-resolution "zoomed-in" image.
        final ImageView expandedImageView = ivFullScreen;
        expandedImageView.setImageBitmap(imageResId);
        // Calculate the starting and ending bounds for the zoomed-in image. This step
        // involves lots of math. Yay, math.
        final Rect startBounds = new Rect();
        final Rect finalBounds = new Rect();
        final Point globalOffset = new Point();
        // The start bounds are the global visible rectangle of the thumbnail, and the
        // final bounds are the global visible rectangle of the container view. Also
        // set the container view's offset as the origin for the bounds, since that's
        // the origin for the positioning animation properties (X, Y).
        thumbView.getGlobalVisibleRect(startBounds);
        MainView.getGlobalVisibleRect(finalBounds, globalOffset);
        startBounds.offset(-globalOffset.x, -globalOffset.y);
        finalBounds.offset(-globalOffset.x, -globalOffset.y);
        // Adjust the start bounds to be the same aspect ratio as the final bounds using the
        // "center crop" technique. This prevents undesirable stretching during the animation.
        // Also calculate the start scaling factor (the end scaling factor is always 1.0).
        float startScale;
        if ((float) finalBounds.width() / finalBounds.height()
                > (float) startBounds.width() / startBounds.height())

        {
            // Extend start bounds horizontally
            startScale = (float) startBounds.height() / finalBounds.height();
            float startWidth = startScale * finalBounds.width();
            float deltaWidth = (startWidth - startBounds.width()) / 2;
            startBounds.left -= deltaWidth;
            startBounds.right += deltaWidth;
        } else

        {
            // Extend start bounds vertically
            startScale = (float) startBounds.width() / finalBounds.width();
            float startHeight = startScale * finalBounds.height();
            float deltaHeight = (startHeight - startBounds.height()) / 2;
            startBounds.top -= deltaHeight;
            startBounds.bottom += deltaHeight;
        }

        // Hide the thumbnail and show the zoomed-in view. When the animation begins,
        // it will position the zoomed-in view in the place of the thumbnail.
        thumbView.setAlpha(0f);
        expandedImageView.setVisibility(View.VISIBLE);

        // Set the pivot point for SCALE_X and SCALE_Y transformations to the top-left corner of
        // the zoomed-in view (the default is the center of the view).
        expandedImageView.setPivotX(0f);
        expandedImageView.setPivotY(0f);

        // Construct and run the parallel animation of the four translation and scale properties
        // (X, Y, SCALE_X, and SCALE_Y).
        AnimatorSet set = new AnimatorSet();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)

        {
            set
                    .play(ObjectAnimator.ofFloat(expandedImageView, View.X, startBounds.left,
                            finalBounds.left))
                    .with(ObjectAnimator.ofFloat(expandedImageView, View.Y, startBounds.top,
                            finalBounds.top))
                    .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X, startScale, 1f))
                    .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_Y, startScale, 1f));
        }

        set.setDuration(mShortAnimationDuration);
        set.setInterpolator(new

                        DecelerateInterpolator()

        );
        set.addListener(new

                                AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationStart(Animator animation) {
                                        super.onAnimationStart(animation);
                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        mCurrentAnimator = null;
                                    }

                                    @Override
                                    public void onAnimationCancel(Animator animation) {
                                        mCurrentAnimator = null;
                                    }
                                }

        );
        set.start();
        mCurrentAnimator = set;

        // Upon clicking the zoomed-in image, it should zoom back down to the original bounds
        // and show the thumbnail instead of the expanded image.
        final float startScaleFinal = startScale;
        expandedImageView.setOnClickListener(new View.OnClickListener()

                                             {
                                                 @Override
                                                 public void onClick(View view) {
                                                     if (mCurrentAnimator != null) {
                                                         mCurrentAnimator.cancel();
                                                     }

                                                     // Animate the four positioning/sizing properties in parallel, back to their
                                                     // original values.
                                                     AnimatorSet set = new AnimatorSet();
                                                     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                                                         set
                                                                 .play(ObjectAnimator.ofFloat(expandedImageView, View.X, startBounds.left))
                                                                 .with(ObjectAnimator.ofFloat(expandedImageView, View.Y, startBounds.top))
                                                                 .with(ObjectAnimator
                                                                         .ofFloat(expandedImageView, View.SCALE_X, startScaleFinal))
                                                                 .with(ObjectAnimator
                                                                         .ofFloat(expandedImageView, View.SCALE_Y, startScaleFinal));
                                                     }
                                                     set.setDuration(mShortAnimationDuration);
                                                     set.setInterpolator(new DecelerateInterpolator());
                                                     set.addListener(new AnimatorListenerAdapter() {
                                                         @Override
                                                         public void onAnimationEnd(Animator animation) {
                                                             thumbView.setAlpha(1f);
                                                             expandedImageView.setVisibility(View.GONE);
                                                             dismiss();
                                                             mCurrentAnimator = null;
                                                         }

                                                         @Override
                                                         public void onAnimationCancel(Animator animation) {
                                                             thumbView.setAlpha(1f);
                                                             expandedImageView.setVisibility(View.GONE);
                                                             dismiss();
                                                             mCurrentAnimator = null;
                                                         }
                                                     });
                                                     set.start();
                                                     mCurrentAnimator = set;
                                                 }
                                             }

        );
    }
}
