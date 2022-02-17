package fr.epf.min1.gestionclient

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*


class AddClientActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)


        // All EditText elements
        val lastNameEditText = findViewById<EditText>(R.id.last_name_edittext)
        val firstNameEditText = findViewById<EditText>(R.id.first_name_edittext)
        val emailEditText = findViewById<EditText>(R.id.email_edittext)


        // RadioGroup for gender
        val genderRadioGroup = findViewById<RadioGroup>(R.id.gender_radiogroup)
        val selectedGender = genderRadioGroup.checkedRadioButtonId
        var genderRadioButton = findViewById<RadioButton>(selectedGender)
        genderRadioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { radioGroup, checkedId ->
            genderRadioButton = findViewById(checkedId)
        })


        // SeekBar for age
        val ageSeekBar = findViewById<SeekBar>(R.id.age_seekbar)
        var ageTextView = findViewById<TextView>(R.id.age_textview)
        ageSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar?, age: Int, fromUser: Boolean) {
                ageSeekBar!!.progress = age
                ageTextView.text = age.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })


        // dialog Spinner for level
        val levelSpinner = this@AddClientActivity.findViewById<Spinner>(R.id.level_spinner)
        val adapter = ArrayAdapter.createFromResource(this, R.array.level_items, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        levelSpinner.adapter = adapter
        levelSpinner.onItemSelectedListener = this


        // Switch for actual disponibility
        val switchTextView = findViewById<TextView>(R.id.active_switch)
        val activeSwitch = findViewById<Switch>(R.id.switch_button)
        val activeSwitchString = "Actif"
        val inactiveSwitchString = "Inactif"
        activeSwitch.setOnClickListener {
            if (activeSwitch.isChecked) {
                switchTextView.text = activeSwitchString
            } else {
                switchTextView.text = inactiveSwitchString
            }
        }


        val addButton = findViewById<Button>(R.id.add_client_button)
        addButton.setOnClickListener {
            Log.d("EPF", "Nom : ${lastNameEditText.text}")
            Log.d("EPF", "Prénom : ${firstNameEditText.text}")
            Log.d("EPF", "Sexe : ${genderRadioButton.text}")
            Log.d("EPF", "Email : ${emailEditText.text}")
            Log.d("EPF", "Age : ${ageTextView.text}")
            Log.d("EPF", "Niveau : ${levelSpinner.selectedItem}")
            Log.d("EPF", "état : ${switchTextView.text}")
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(this, "LOL", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}

