package info.firozansari.animatedvectordrawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;


/**
 * Created by firoz on 25/03/2017.
 */

public class ClearableEditText extends android.support.v7.widget.AppCompatEditText implements TextWatcher {
    private static final int DEFAULT_CLEAR_BUTTON_DRAWABLE;
    private Bitmap mClearTextBitmap;
    private int mClearTextButtonPaddingRight;
    private boolean mIsClearTextButtonEnabled;
    private boolean mIsClearTextButtonVisible;
    private boolean mIsHandlingAction;
    private Paint mPaint;

    static {
        DEFAULT_CLEAR_BUTTON_DRAWABLE = R.drawable.ic_clear_search_api_holo_light;
    }

    public ClearableEditText(Context context) {
        super(context);
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClearableEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void enableClearTextButton(boolean enable) {
        if (enable && !this.mIsClearTextButtonEnabled) {
            this.mPaint = new Paint();
            loadClearButtonBitmap();
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() + this.mClearTextBitmap.getWidth(), getPaddingBottom());
            addTextChangedListener(this);
        } else if (!enable && this.mIsClearTextButtonEnabled) {
            if (this.mClearTextBitmap != null) {
                setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight() - this.mClearTextBitmap.getWidth(), getPaddingBottom());
                removeClearButtonBitmap();
            }
            this.mPaint = null;
            removeTextChangedListener(this);
        }
        this.mIsClearTextButtonEnabled = enable;
        invalidate();
    }

    private void loadClearButtonBitmap() {
        if (this.mClearTextBitmap == null) {
            this.mClearTextBitmap = BitmapFactory.decodeResource(getResources(), DEFAULT_CLEAR_BUTTON_DRAWABLE);
        }
    }

    private void removeClearButtonBitmap() {
        if (this.mClearTextBitmap != null) {
            this.mClearTextBitmap.recycle();
            this.mClearTextBitmap = null;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!this.mIsClearTextButtonEnabled || !this.mIsClearTextButtonVisible || event.getX() <= ((float) (getRight() - getPaddingRight()))) {
            return super.onTouchEvent(event);
        }
        /*switch (event.getAction()) {
            case FileUtils.READ_PERM 0:
                this.mIsHandlingAction = true;
                return true;
            case FileUtils.WRITE_PERM 1:
                if (this.mIsHandlingAction) {
                    setText(BuildConfig.VERSION_NAME);
                }
                this.mIsHandlingAction = false;
                return true;
            case ContactManager.PICK_REQ_CODE 3:
                this.mIsHandlingAction = false;
                return true;
            default:
                return true;

        }*/

        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIsClearTextButtonEnabled && this.mIsClearTextButtonVisible && this.mClearTextBitmap != null) {
            canvas.drawBitmap(this.mClearTextBitmap, (float) (((getScrollX() + getWidth()) - this.mClearTextBitmap.getWidth()) - this.mClearTextButtonPaddingRight), (float) (getScrollY() + ((getHeight() - this.mClearTextBitmap.getHeight()) / 2)), this.mPaint);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsClearTextButtonEnabled) {
            loadClearButtonBitmap();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeClearButtonBitmap();
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(s != null && s.length() > 0) {
            this.mIsClearTextButtonVisible = true;
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }


}
