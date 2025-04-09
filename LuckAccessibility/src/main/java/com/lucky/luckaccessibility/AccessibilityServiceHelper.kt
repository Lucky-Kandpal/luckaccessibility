package com.lucky.luckaccessibility


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.core.content.ContextCompat

object AccessibilityServiceHelper {

    private const val LOG_ACTION = "com.lucky.ACCESSIBILITY_LUCK_LOG"
    private const val SERVICE_COMPONENT = "com.lucky.luckaccessibility/.MyAccessibilityService"

    /**
     * Check if the Accessibility Service is enabled.
     */
    private fun isAccessibilityServiceEnabled(context: Context): Boolean {
        val enabledServices = Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES
        )
        return enabledServices?.contains(SERVICE_COMPONENT) ?: false
    }

    /**
     * Open the Accessibility Settings screen.
     */
    private fun openAccessibilitySettings(context: Context) {
        context.startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
    }

    /**
     * Register a broadcast receiver for accessibility logs.
     */
    fun registerLogReceiver(context: Context, receiver: BroadcastReceiver) {
        val intentFilter = IntentFilter(LOG_ACTION)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(receiver, intentFilter, Context.RECEIVER_EXPORTED)
        } else {
            @Suppress("DEPRECATION")
            ContextCompat.registerReceiver(
                context,
                receiver,
                intentFilter,
                ContextCompat.RECEIVER_EXPORTED
            )
        }
    }

    /**
     * Unregister the previously registered broadcast receiver.
     */
    fun unregisterLogReceiver(context: Context, receiver: BroadcastReceiver) {
        context.unregisterReceiver(receiver)
    }

    /**
     * Optionally, provide a method to show a Toast message based on service status.
     */
    fun showServiceStatus(context: Context) {
        if (isAccessibilityServiceEnabled(context)) {
            Toast.makeText(context, "Accessibility Service is ENABLED", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Please enable Accessibility Service", Toast.LENGTH_SHORT)
                .show()
            openAccessibilitySettings(context)
        }
    }
}
