package vn.edu.hust.studentman

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

class StudentListFragment : Fragment(R.layout.fragment_student_list) {

    private lateinit var studentListView: ListView
    private lateinit var studentAdapter: ArrayAdapter<String>
    private val students = mutableListOf(
        "Nguyễn Văn An - SV001",
        "Trần Thị Bảo - SV002",
        "Lê Hoàng Cường - SV003",
        "Phạm Thị Dung - SV004",
        "Đỗ Minh Đức - SV005"
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studentListView = view.findViewById(R.id.listViewStudents)
        studentAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, students)
        studentListView.adapter = studentAdapter

        // Register Context Menu for the ListView
        registerForContextMenu(studentListView)

        // Navigate to AddStudentFragment when Add New button is clicked
        view.findViewById<Button>(R.id.btnAddStudent).setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentListFragmentToAddStudentFragment()
            findNavController().navigate(action)
        }

        studentListView.setOnItemClickListener { _, _, position, _ ->
            val selectedStudent = students[position]
            val action = StudentListFragmentDirections
                .actionStudentListFragmentToEditStudentFragment(selectedStudent)
            findNavController().navigate(action)
        }

        // Receive new student data using FragmentResultListener
        parentFragmentManager.setFragmentResultListener("newStudentData", viewLifecycleOwner) { _, bundle ->
            val newStudentData = bundle.getString("newStudentData")
            newStudentData?.let {
                students.add(it)
                studentAdapter.notifyDataSetChanged()
                Snackbar.make(view, "$it added", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val selectedPosition = info.position
        when (item.itemId) {
            R.id.menu_edit -> {
                val studentData = students[selectedPosition]
                val action = StudentListFragmentDirections
                    .actionStudentListFragmentToEditStudentFragment(studentData)
                findNavController().navigate(action)
                return true
            }
            R.id.menu_remove -> {
                val removedStudent = students.removeAt(selectedPosition)
                studentAdapter.notifyDataSetChanged()
                Snackbar.make(requireView(), "$removedStudent removed", Snackbar.LENGTH_LONG).show()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
