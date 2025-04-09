```markdown
# 🔍 LuckAccessibility – Make Android Accessibility Easy!

[![](https://jitpack.io/v/Lucky-Kandpal/luckaccessibility.svg)](https://jitpack.io/#Lucky-Kandpal/luckaccessibility)

**LuckAccessibility** is a **Kotlin-based Android library** that helps you **monitor and interact with accessibility events** in your app — without writing tons of boilerplate!

Whether you're just getting started with Android development or already experienced, this library saves time and simplifies your AccessibilityService workflow.

---

## ✨ Why Use LuckAccessibility?

- ✅ Skip the hassle of creating your own AccessibilityService
- 📡 Built-in logging using BroadcastReceiver
- 🔍 Instantly check if the accessibility service is enabled
- 🌳 Easily inspect the view hierarchy of apps
- 💡 Works on Android 7.0 (API 24) up to Android 15 (API 35)

---

## 📦 Installation

### 1️⃣ Add JitPack to your **root `build.gradle`**:
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### 2️⃣ Add the dependency to your **app `build.gradle`**:
```groovy
dependencies {
    implementation 'com.github.Lucky-Kandpal:luckaccessibility:1.0.1'
}
```



## 🧠 Library Structure

```
luckaccessibility/
├── luckaccessibility/            # 📚 Main Library
│   ├── AccessibilityServiceHelper.kt  # 👉 Helper methods
│   └── MyAccessibilityService.kt      # 🔄 Core accessibility logic
└── app/                          # 📱 Demo App
```

---

## 🚀 Quick Start

### ✅ 1. Check if Accessibility Service is Enabled
```kotlin
AccessibilityServiceHelper.showServiceStatus(context)
```

### 📡 2. Register for Accessibility Events
```kotlin
AccessibilityServiceHelper.registerLogReceiver(context, receiver)
```

---

## 📱 Demo App Snippet

```kotlin
class MainActivity : AppCompatActivity() {
    private val logReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val node = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent?.getParcelableExtra("log_data", AccessibilityNodeInfo::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent?.getParcelableExtra("log_data")
            }
            Log.d("MainActivity", "Node Text: ${node?.text}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔐 Check if the accessibility service is enabled
        AccessibilityServiceHelper.showServiceStatus(this)

        // 📡 Register receiver to listen to logs
        AccessibilityServiceHelper.registerLogReceiver(this, logReceiver)
    }
}
```

---

## 📝 How to Enable Accessibility Service

> This library **requires manual permission** from the user:

**Go to:**  
`Settings > Accessibility > Installed Services > Your App Name > Enable`

This allows the app to monitor accessibility events and the view hierarchy.

---

## 🙌 Contributing

Found a bug? Have an idea to improve the library?  
Feel free to open an issue or submit a pull request!

Let's make accessibility more accessible, together 🚀

---

## 👤 Author

**Lucky Kandpal**  
🔗 [LinkedIn](https://www.linkedin.com/in/luckykandpal/)  
📦 [JitPack Repository](https://jitpack.io/#Lucky-Kandpal/luckaccessibility)

---

> Made with ❤️ to help developers build more inclusive Android apps.
```

---

Would you like to:

- Add GIFs or screenshots from the demo app?
- Include Gradle badge, Kotlin version badge, or Android API level badge?
- Add a section for troubleshooting or FAQs?

Happy to help you polish it even more!
