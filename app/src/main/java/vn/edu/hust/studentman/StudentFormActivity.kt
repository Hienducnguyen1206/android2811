package vn.edu.hust.studentman

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class StudentFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_form)

        val nameEditText = findViewById<EditText>(R.id.edit_student_name)
        val idEditText = findViewById<EditText>(R.id.edit_student_id)
        val saveButton = findViewById<Button>(R.id.btn_save)

        val existingData = intent.getStringExtra("student_data")
        if (existingData != null) {
            val (name, id) = existingData.split(" - ")
            nameEditText.setText(name)
            idEditText.setText(id)
        }

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val id = idEditText.text.toString().trim()
            if (name.isNotEmpty() && id.isNotEmpty()) {
                val resultIntent = intent.apply {
                    putExtra("student_data", "$name - $id")
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
