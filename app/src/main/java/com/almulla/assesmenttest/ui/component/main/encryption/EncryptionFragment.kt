package com.almulla.assesmenttest.ui.component.main.encryption

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.viewModels
import com.almulla.assesmenttest.R
import com.almulla.assesmenttest.databinding.FragmentEncryptionBinding
import com.almulla.assesmenttest.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


/** This fragment is used to show Encryption screen */
@AndroidEntryPoint
class EncryptionFragment : BaseFragment<FragmentEncryptionBinding>(), View.OnClickListener {

    private val encryptionVm: EncryptionVm by viewModels()

    override fun getLayout(): Int {
        return R.layout.fragment_encryption
    }

    override fun observeViewModel() {
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initViewBinding() {

    }

    override fun onClick(view: View?) {
        getBinding().apply {
            when (view) {
            }
        }
    }

}