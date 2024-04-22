package com.miniproject.attendx.submitAttendance

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.miniproject.attendx.Dashboard.Dashboard_activity
import com.miniproject.attendx.R
import com.miniproject.attendx.attendance.markedDataObj
import com.miniproject.attendx.databinding.ActivitySubmitAttendanceBinding

class SubmitAttendanceActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubmitAttendanceBinding
    var data = arrayListOf<markedDataObj>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySubmitAttendanceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // status bar color
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimary)

        data = intent.getSerializableExtra("report") as ArrayList<markedDataObj>
        binding.submitAttendanceToolbarTextview.text =
            "Attendance report for " + intent.getStringExtra("coursename")
        binding.submitAttendanceRecyclerView.adapter = submit_attendance_recycleView_adapter(data)
        binding.submitAttendanceButton.setOnClickListener {
            MaterialAlertDialogBuilder(this).setTitle("Are you sure you want to submit the attendance?")
                .setPositiveButton("YES") { _, _ ->


                    // Show a progress dialog while uploading attendance
                    val progressDialog = ProgressDialog(this)
                    progressDialog.setMessage("Uploading attendance...")
                    progressDialog.setCancelable(false) // Prevent dismissing by tapping outside
                    progressDialog.show()

                    // Simulate attendance upload process with a delay (replace with actual upload logic)
                    Handler().postDelayed({
                        // Dismiss the progress dialog after attendance is uploaded
                        progressDialog.dismiss()

                        // Show a success message or animation indicating successful upload
                        Toast.makeText(this, "Attendance uploaded successfully", Toast.LENGTH_SHORT)
                            .show()

                        // Navigate to the dashboard activity
                        val intent = Intent(this, Dashboard_activity::class.java)
                        startActivity(intent)
                    }, 2000) // Adjust delay as needed (2 seconds in this example)

//                    var intent = Intent(this, Dashboard_activity::class.java)
//                    startActivity(intent)
                }.setNegativeButton("CANCEL") { _, _ ->

                }.show()

        }


    }

    override fun onBackPressed() {
        super.onBackPressedDispatcher

    }
}