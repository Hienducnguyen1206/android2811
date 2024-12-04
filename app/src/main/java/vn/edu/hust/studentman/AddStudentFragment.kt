package vn.edu.hust.studentman

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddStudentFragment : Fragment(R.layout.fragment_add_student) {

    private lateinit var studentNameEditText: EditText
    private lateinit var studentIDEditText: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studentNameEditText = view.findViewById(R.id.etStudentName)
        studentIDEditText = view.findViewById(R.id.etStudentID)

        view.findViewById<Button>(R.id.btnSaveStudent).setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            val studentID = studentIDEditText.text.toString()

            if (studentName.isNotEmpty() && studentID.isNotEmpty()) {
                val studentData = "$studentName - $studentID"
                val action = AddStudentFragmentDirections.actionAddStudentFragmentToStudentListFragment()
                findNavController().navigate(action)
                val bundle = Bundle()
                bundle.putString("newStudentData", studentData)
                parentFragmentManager.setFragmentResult("newStudentData", bundle)
            } else {
                Toast.makeText(requireContext(), "Please enter valid student information", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
