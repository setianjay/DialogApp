package com.setianjay.dialogapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.setianjay.dialogapp.databinding.ActivityMainBinding
import com.setianjay.dialogapp.utils.CharUtil

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        binding.btnDialog1.setOnClickListener(this)
        binding.btnDialog2.setOnClickListener(this)
        binding.btnDialog3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnDialog1 -> {
                showDialog1()
            }
            R.id.btnDialog2 -> {
                showDialog2()
            }
            R.id.btnDialog3 -> {
            showDialog3()
        }
        }
    }

    private fun showDialog1() {
        val dialog = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_add_contact)
            .setTitle("Add Contact")
            .setMessage("Do you want at Mr. Bitch to your contact?")
            .setPositiveButton("Add") { dialogInterface, _ ->
                Toast.makeText(applicationContext, "Added contact successfully", Toast.LENGTH_SHORT)
                    .show()
                binding.tvResult.visibility = View.VISIBLE
                binding.tvResult.text = "You added Mr. Bitch to your contact"
            }
            .setNegativeButton("Cancel") { _, _ ->
                Toast.makeText(
                    applicationContext,
                    "You don't addes Mr. Bitch to your contact",
                    Toast.LENGTH_SHORT
                ).show()
            }.create()

        dialog.show()
    }

    private fun showDialog2() {
        val options = arrayOf("First option", "Second option", "Third options")
        var optionChoose: String? = null

        val dialog = AlertDialog.Builder(this)
            .setTitle("Choose on of these options")
            .setSingleChoiceItems(options, 0) { _, i ->
                Toast.makeText(
                    applicationContext,
                    "You choose the option ${options[i]}",
                    Toast.LENGTH_SHORT
                ).show()
                optionChoose = options[i]
            }
            .setPositiveButton("Submit") { _, _ ->
                binding.tvResult.visibility = View.VISIBLE
                binding.tvResult.text = optionChoose
            }.setNegativeButton("Decline") { _, _ ->
                Toast.makeText(applicationContext, "You don't choose anything", Toast.LENGTH_SHORT)
                    .show()
            }.create()

        dialog.show()
    }

    private fun showDialog3(){
        val hobbies = arrayOf("Basket","Football","Baseball")
        val hobbiesChoose = arrayListOf<String>()
        var choose: String = ""

        val dialog = AlertDialog.Builder(this)
            .setTitle("Choose on of these options")
            .setMultiChoiceItems(hobbies, booleanArrayOf(false,false,false)) { _, i, isChecked ->
                if(isChecked){
                    Toast.makeText(
                        applicationContext,
                        "You choose the option ${hobbies[i]}",
                        Toast.LENGTH_SHORT
                    ).show()
                   hobbiesChoose.add(hobbies[i])
                }
            }
            .setPositiveButton("Submit") { _, i ->
                Toast.makeText(applicationContext, "You don't choose anything", Toast.LENGTH_SHORT)
                    .show()
                for (i in hobbiesChoose.indices){
                    choose += "${hobbiesChoose[i]},"
                }
                binding.tvResult.visibility = View.VISIBLE
                binding.tvResult.text = CharUtil.dropLastChar(choose,',')
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(applicationContext, "You don't choose anything", Toast.LENGTH_SHORT)
                    .show()
            }.create()

        dialog.show()
    }

}
