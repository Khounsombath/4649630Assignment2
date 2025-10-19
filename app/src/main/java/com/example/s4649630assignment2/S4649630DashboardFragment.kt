package com.example.s4649630assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

// --- API Service ---
interface DashboardApi {
    @retrofit2.http.GET("dashboard/{keypass}")
    suspend fun dashboard(@retrofit2.http.Path("keypass") keypass: String): retrofit2.Response<CourseResponse>
}

// --- Data Models ---
data class CourseResponse(val entities: List<Course>)
data class Course(
    val courseName: String?,
    val courseCode: String?,
    val instructor: String?,
    val credits: String?,
    val description: String?
)

// --- Dashboard Fragment ---
@AndroidEntryPoint
class S4649630DashboardFragment : Fragment() {

    // Hilt will inject the API here
    @Inject
    lateinit var api: DashboardApi

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_s4649630_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv = view.findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(requireContext())

        // --- Demo Data ---
        val demoCourses = listOf(
            Course("Introduction to Programming", "CS101", "Dr. Emily Clarke", "6", "A foundational course covering basic programming concepts and problem-solving techniques."),
            Course("Calculus II", "MATH201", "Prof. David Lin", "6", "Advanced calculus topics including integration techniques, series, and multivariable calculus."),
            Course("Creative Writing", "ENG105", "Dr. Sarah Nguyen", "6", "Exploration of creative writing genres, focusing on personal style and narrative voice."),
            Course("Quantum Mechanics", "PHYS301", "Dr. Robert Kim", "6", "Introduction to quantum theory, wave functions, and particle physics principles."),
            Course("Genetics", "BIO202", "Dr. Amy Patel", "6", "Study of heredity, gene expression, and genetic disorders in modern biology."),
            Course("General Chemistry", "CHEM101", "Dr. Steven Baker", "6", "Fundamental principles of chemistry including atomic structure, bonding, and chemical reactions."),
            Course("Cognitive Psychology", "PSYCH205", "Dr. Laura Chen", "6", "Examination of perception, memory, learning, and decision-making processes.")
        )

        rv.adapter = CourseAdapter(demoCourses) { item ->
            val bundle = Bundle().apply {
                putString("courseName", item.courseName)
                putString("courseCode", item.courseCode)
                putString("instructor", item.instructor)
                putString("credits", item.credits)
                putString("description", item.description)
            }
            findNavController().navigate(R.id.action_dashboard_to_details, bundle)
        }

        // --- Fetch from API quietly using Hilt-provided Retrofit ---
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = api.dashboard("courses")
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful && response.body()?.entities?.isNotEmpty() == true) {
                        val list = response.body()?.entities?.filter {
                            !it.courseName.isNullOrBlank() && !it.courseCode.isNullOrBlank()
                        }.orEmpty()

                        if (list.isNotEmpty()) {
                            rv.adapter = CourseAdapter(list) { item ->
                                val bundle = Bundle().apply {
                                    putString("courseName", item.courseName)
                                    putString("courseCode", item.courseCode)
                                    putString("instructor", item.instructor)
                                    putString("credits", item.credits)
                                    putString("description", item.description)
                                }
                                findNavController().navigate(R.id.action_dashboard_to_details, bundle)
                            }
                        }
                    }
                }
            } catch (_: Exception) {
                // fail quietly, keep demo data
            }
        }
    }
}
