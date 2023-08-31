package com.nkuppan.expensemanager.feature.category.delete

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nkuppan.expensemanager.core.common.utils.KEY_DELETE_STATUS
import com.nkuppan.expensemanager.feature.category.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoryDeleteDialog : DialogFragment() {

    private val args: CategoryDeleteDialogArgs by navArgs()

    private val viewModel: CategoryDeleteViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(com.nkuppan.expensemanager.core.ui.R.string.delete)
        alertDialog.setMessage(com.nkuppan.expensemanager.core.ui.R.string.delete_item_message)

        alertDialog.setPositiveButton(com.nkuppan.expensemanager.core.ui.R.string.ok) { _: DialogInterface, _: Int ->
            viewModel.deleteCategory(args.category)
        }

        alertDialog.setNegativeButton(com.nkuppan.expensemanager.core.ui.R.string.cancel) { aDialog: DialogInterface, _: Int ->
            aDialog.dismiss()
        }

        initObservers()

        return alertDialog.create()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.deleted.collectLatest { deleted ->
                        findNavController().also {
                            it.previousBackStackEntry?.savedStateHandle?.set(
                                KEY_DELETE_STATUS,
                                deleted
                            )
                            it.popBackStack()
                        }
                    }
                }
            }
        }
    }
}