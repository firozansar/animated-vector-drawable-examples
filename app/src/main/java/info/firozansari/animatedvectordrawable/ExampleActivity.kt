package info.firozansari.animatedvectordrawable

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExampleActivity : AppCompatActivity() {
    private var container: ViewGroup? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        container = findViewById<ViewGroup>(R.id.container).setOnClickListener({
            for (i in 0 until container.getChildCount()) {
                animateDrawables(container.getChildAt(i))
            }
        })

        for (i in 0 until container.getChildCount()) {
            val child: View = container.getChildAt(i)
            (child as? TextView)?.setOnClickListener(View.OnClickListener {
                for (i in 0 until container.getChildCount()) {
                    animateDrawables(container.getChildAt(i))
                }
            })
        }
    }

    private fun animateDrawables(view: View) {
        if (view !is TextView) {
            return
        }
        val textView: TextView = view as TextView
        for (drawable in textView.getCompoundDrawables()) {
            if (drawable is Animatable) {
                (drawable as Animatable).start()
            }
        }
    }
}
