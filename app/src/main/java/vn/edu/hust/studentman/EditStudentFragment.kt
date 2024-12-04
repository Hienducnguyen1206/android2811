package vn.edu.hust.studentman

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EditStudentFragment : Fragment(R.layout.fragment_edit_student) {

    private lateinit var studentNameEditText: EditText
    private lateinit var studentIDEditText: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studentNameEditText = view.findViewById(R.id.etEditStudentName)
        studentIDEditText = view.findViewById(R.id.etEditStudentID)

        val studentData = EditStudentFragmentArgs.fromBundle(requireArguments()).studentData
        val studentInfo = studentData.split(" - ")
        studentNameEditText.setText(studentInfo[0])
        studentIDEditText.setText(studentInfo[1])

        view.findViewById<Button>(R.id.btnSaveChanges).setOnClickListener {
            val updatedStudentName = studentNameEditText.text.toString()
            val updatedStudentID = studentIDEditText.text.toString()

            if (updatedStudentName.isNotEmpty() && updatedStudentID.isNotEmpty()) {
                val action = EditStudentFragmentDirections.actionEditStudentFragmentToStudentListFragment()
                findNavController().navigate(action)
            } else {
                Toast.makeText(requireContext(), "Please enter valid student information", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
