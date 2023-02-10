package com.harjot.activity_spinner

import android.R
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.core.view.get
import com.harjot.activity_spinner.databinding.ActivityMainBinding
import com.harjot.activity_spinner.databinding.FabBtnDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var spinner: Spinner
    lateinit var spinnerAdapter: ArrayAdapter<String>
    lateinit var arrayAdapter: ArrayAdapter<String>

    var spinnerArray= arrayListOf<String>()
    var arrayList= arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        spinner=binding.spinner

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)

        spinnerAdapter= ArrayAdapter(this, R.layout.simple_list_item_1, spinnerArray)
        binding.spinner.adapter= spinnerAdapter

        binding.lvListView.adapter= arrayAdapter

        binding.fabBtn.setOnClickListener{
            var dialog=Dialog(this)
            var dialogBinding=FabBtnDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

            dialogBinding.btnAdd1.setOnClickListener {
                if(dialogBinding.etItemName.text.toString().trim().isNullOrEmpty()){
                    dialogBinding.etItemName.error="Enter Item"
                    Toast.makeText(this,"Enter Item !!!", Toast.LENGTH_LONG).show()
                }
                else{
                    spinnerArray.add(dialogBinding.etItemName.text.toString())
                    spinnerAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
        binding.btnAdd2.setOnClickListener {
            if(binding.spinner.toString().trim().isNullOrEmpty()){
                Toast.makeText(this, "Enter Spinner Item", Toast.LENGTH_SHORT).show()
            }
            else{
                arrayList.add(binding.spinner.toString())
                arrayAdapter.notifyDataSetChanged()
            }
        }

    }
}