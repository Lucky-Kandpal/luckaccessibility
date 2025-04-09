package com.lucky.luckaccessibility

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class MyAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null || event.source == null) return

        val rootNode = rootInActiveWindow
        if (rootNode != null) {
            traverseNode(rootNode)
        }
    }

    private fun traverseNode(node: AccessibilityNodeInfo?) {
        if (node == null) return

        val text = node.text
        val contentDescription = node.contentDescription

        if (!text.isNullOrEmpty() || !contentDescription.isNullOrEmpty()) {
            val nodeCopy = AccessibilityNodeInfo.obtain(node)
            Log.e("AccessibilityLib", "TEXT:- ${nodeCopy.text} CONTENT DESCRIPTION:- ${nodeCopy.contentDescription}")
            val intent = Intent("com.lucky.ACCESSIBILITY_LUCK_LOG")
            intent.putExtra("log_data", nodeCopy)
            sendBroadcast(intent)
        }

        for (i in 0 until node.childCount) {
            traverseNode(node.getChild(i))
        }
    }

    override fun onInterrupt() {
        Log.d("AccessibilityLib", "Service Interrupted")
    }
}
