package com.examplecode.accessibilityservice

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lucky.luckaccessibility.AccessibilityServiceHelper

class MainActivity : AppCompatActivity() {

    private val logReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val node = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent?.getParcelableExtra("log_data", AccessibilityNodeInfo::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent?.getParcelableExtra("log_data")
            }
            Log.d("MainActivityLogssReceive", "Received log data: $node ,, node data:- ${node?.text}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Register the log receiver using the library helper
        AccessibilityServiceHelper.registerLogReceiver(this, logReceiver)

        // Check service status on button click using the helper method
        findViewById<Button>(R.id.btnCheckAccessibility).setOnClickListener {
            AccessibilityServiceHelper.showServiceStatus(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        AccessibilityServiceHelper.unregisterLogReceiver(this, logReceiver)
    }
}
