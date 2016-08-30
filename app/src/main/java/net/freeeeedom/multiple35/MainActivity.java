package net.freeeeedom.multiple35;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int SWIPE_MIN_DISTANCE = 200;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGestureDetector = new GestureDetector(this, mOnGestureListener);

    }

    // これがないとGestureDetectorが動かない
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private final GestureDetector.SimpleOnGestureListener mOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            try {

                // 開始位置から終了位置の移動距離が指定値より大きい
                // 軸の移動速度が指定値より大きいの判定

                if (event1.getY() - event2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    // 下から上
                    Toast.makeText(MainActivity.this, "下から上", Toast.LENGTH_SHORT).show();

                }else if (event2.getY() - event1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                    // 上から下
                    Toast.makeText(MainActivity.this, "上から下", Toast.LENGTH_SHORT).show();

                } else if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    // 右から左
                    Toast.makeText(MainActivity.this, "右から左", Toast.LENGTH_SHORT).show();

                } else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    // 左から右
                    Toast.makeText(MainActivity.this, "左から右", Toast.LENGTH_SHORT).show();

                }

            } catch (Exception e) {
                // nothing
            }
            return false;
        }
    };

}
