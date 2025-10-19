package com.example.s4649630assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar

class S4649630DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_s4649630_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val courseName = arguments?.getString("courseName")
        val courseCode = arguments?.getString("courseCode")
        val instructor = arguments?.getString("instructor")
        val credits = arguments?.getString("credits")
        val description = arguments?.getString("description")

        view.findViewById<TextView>(R.id.tvCourseName).text = courseName ?: "No Title"
        view.findViewById<TextView>(R.id.tvCourseCode).text = "Course Code: ${courseCode ?: "N/A"}"
        view.findViewById<TextView>(R.id.tvInstructor).text = "Instructor: ${instructor ?: "N/A"}"
        view.findViewById<TextView>(R.id.tvCredits).text = "Credits: ${credits ?: "N/A"}"
        view.findViewById<TextView>(R.id.tvDescription).text = "Description: ${description ?: "N/A"}"

        //  Back arrow to navigate back to Dashboard
        view.findViewById<MaterialToolbar>(R.id.topAppBar)
            .setNavigationOnClickListener {
                findNavController().navigateUp()
            }
    }
}
