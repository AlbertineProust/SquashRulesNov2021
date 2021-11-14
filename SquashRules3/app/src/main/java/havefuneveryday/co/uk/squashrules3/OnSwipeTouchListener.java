package havefuneveryday.co.uk.squashrules3;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class OnSwipeTouchListener implements  android.view.View.OnTouchListener {
    protected
    GestureDetector gestureDetector = null;

    public OnSwipeTouchListener(Context paramContext) { this.gestureDetector = new GestureDetector((GestureDetector.OnGestureListener) paramContext); }


    public void onSwipeLeft() {}

    public void onSwipeRight() {}

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent) { return this.gestureDetector.onTouchEvent(paramMotionEvent); }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_DISTANCE_THRESHOLD = 100;

        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        private GestureListener() {}

        public boolean onDown(MotionEvent param1MotionEvent) { return true; }

        public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
            param1Float2 = param1MotionEvent2.getX() - param1MotionEvent1.getX();
            float f1 = param1MotionEvent2.getY();
            float f2 = param1MotionEvent1.getY();
            if (Math.abs(param1Float2) > Math.abs(f1 - f2) && Math.abs(param1Float2) > 100.0F && Math.abs(param1Float1) > 100.0F) {
                if (param1Float2 > 0.0F) {
                    OnSwipeTouchListener.this.onSwipeRight();
                    return true;
                }
                OnSwipeTouchListener.this.onSwipeLeft();
                return true;
            }
            return false;
        }
    }
}

