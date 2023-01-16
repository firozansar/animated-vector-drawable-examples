package info.firozansari.animatedvectordrawable

import android.graphics.drawable.Animatable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import info.firozansari.animatedvectordrawable.databinding.FragmentBottomSheetBinding

@AndroidEntryPoint
class MainBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.example1.setOnClickListener { animate(it as ImageView) }
        binding.example2.setOnClickListener { animate(it as ImageView) }
        binding.closeButton.setOnClickListener {
            dismiss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBottomSheetBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun animate(view: ImageView) {
        val drawable = view.drawable
        if (drawable is Animatable) {
            (drawable as Animatable).start()
        }
    }
}
