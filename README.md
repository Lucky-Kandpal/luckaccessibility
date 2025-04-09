

```markdown
# LuckAccessibility 🔍📱

A **Kotlin-based Android library** that simplifies working with Android **Accessibility Services**, making it easy to monitor and interact with accessibility events and view hierarchies. Designed for developers who need a quick and efficient way to integrate accessibility functionality into their Android apps.

[![](https://jitpack.io/v/Lucky-Kandpal/luckaccessibility.svg)](https://jitpack.io/#Lucky-Kandpal/luckaccessibility)

---

## 🚀 Features

- 📦 Easy integration of Accessibility Service functionality  
- 📡 Built-in Broadcast Receiver for accessibility events  
- ✅ Helper methods to check service status  
- 🧭 Traverse and inspect the View Hierarchy  
- 🧩 Compatible with Android 15 (API 35) and below  

---

## 📁 Project Structure

```
luckaccessibility/
├── luckaccessibility/            # Main library module
│   ├── AccessibilityServiceHelper.kt
│   └── MyAccessibilityService.kt
└── app/                          # Demo application
```

- **`AccessibilityServiceHelper`**  
  - Handles checking service status  
  - Registers broadcast receivers for accessibility events

- **`MyAccessibilityService`**  
  - Core implementation of Android's `AccessibilityService`  

---

## 📦 Setup

### 1. Add JitPack to your root `build.gradle`
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### 2. Add the library to your app `build.gradle`
```groovy
dependencies {
    implementation 'com.github.Lucky-Kandpal:luckaccessibility:latest-version'
}
```
current latest-version is '1.0.0'

Replace `latest-version` with the latest release tag available on [JitPack](https://jitpack.io/#Lucky-Kandpal/luckaccessibility).

---

## ✅ Requirements

- **Minimum SDK**: 24  
- **Target SDK**: 35  
- **Language**: Kotlin  
- **JVM Target**: 11  

---

## 🛠️ Usage

### Check if Accessibility Service is Enabled
```kotlin
AccessibilityServiceHelper.showServiceStatus(context)
```

### Register for Accessibility Events
```kotlin
AccessibilityServiceHelper.registerLogReceiver(context, receiver)
```

You can use a `BroadcastReceiver` to receive accessibility event logs and handle them in your app.

---

## 📱 Demo App

A sample app is included in the repository to demonstrate how to use the library in real-world applications.

---

## 🤝 Contributing

Contributions, suggestions, and issues are always welcome!  
Feel free to open a PR or submit an issue if you find a bug or want to propose a new feature.

---

## 🧑‍💻 Author

**Lucky Kandpal**  
📧 [LinkedIn](https://www.linkedin.com/in/luckykandpal/)  
🔗 [JitPack Repo](https://jitpack.io/#Lucky-Kandpal/luckaccessibility)

---

```

