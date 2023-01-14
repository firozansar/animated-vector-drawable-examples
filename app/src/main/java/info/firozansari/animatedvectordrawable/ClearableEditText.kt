package info.firozansari.animatedvectordrawable

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText

/**
 * Created by firoz on 25/03/2017.
 */
class ClearableEditText : AppCompatEditText, TextWatcher {
    private var mClearTextBitmap: Bitmap? = null
    private val mClearTextButtonPaddingRight = 0
    private var mIsClearTextButtonEnabled = false
    private var mIsClearTextButtonVisible = false
    private val mIsHandlingAction = false
    private var mPaint: Paint? = null
    private var DEFAULT_CLEAR_BUTTON_DRAWABLE = R.drawable.ic_clear_search_api_holo_light

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!,
        attrs,
        defStyle
    )

    fun enableClearTextButton(enable: Boolean) {
        if (enable && !mIsClearTextButtonEnabled) {
            mPaint = Paint()
            loadClearButtonBitmap()
            setPadding(
                getPaddingLeft(),
                getPaddingTop(),
                getPaddingRight() + mClearTextBitmap!!.width,
                getPaddingBottom()
            )
            addTextChangedListener(this)
        } else if (!enable && mIsClearTextButtonEnabled) {
            if (mClearTextBitmap != null) {
                setPadding(
                    getPaddingLeft(),
                    getPaddingTop(),
                    getPaddingRight() - mClearTextBitmap!!.width,
                    getPaddingBottom()
                )
                removeClearButtonBitmap()
            }
            mPaint = null
            removeTextChangedListener(this)
        }
        mIsClearTextButtonEnabled = enable
        invalidate()
    }

    private fun loadClearButtonBitmap() {
        if (mClearTextBitmap == null) {
            mClearTextBitmap =
                BitmapFactory.decodeResource(getResources(), DEFAULT_CLEAR_BUTTON_DRAWABLE)
        }
    }

    private fun removeClearButtonBitmap() {
        if (mClearTextBitmap != null) {
            mClearTextBitmap!!.recycle()
            mClearTextBitmap = null
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (!mIsClearTextButtonEnabled || !mIsClearTextButtonVisible || event.x <= (getRight() - getPaddingRight()) as Float) {
            super.onTouchEvent(event)
        } else true
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
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (mIsClearTextButtonEnabled && mIsClearTextButtonVisible && mClearTextBitmap != null) {
            canvas.drawBitmap(
                mClearTextBitmap!!,
                (getScrollX() + getWidth() - mClearTextBitmap!!.width - mClearTextButtonPaddingRight) as Float,
                (getScrollY() + (getHeight() - mClearTextBitmap!!.height) / 2) as Float,
                mPaint
            )
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (mIsClearTextButtonEnabled) {
            loadClearButtonBitmap()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        removeClearButtonBitmap()
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        if (s != null && s.length > 0) {
            mIsClearTextButtonVisible = true
        }
    }

    override fun afterTextChanged(s: Editable) {}
    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
}