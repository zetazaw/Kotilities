# Kotilities
Some useful Kotlin extension functions and MVP framework

### Usage for log
Anywhere (activity, fragment, framework's presenter) just need
```
logX("message") 
``` 
or 
```
logX("message", "e") 
```
### Usage for recyclerview
Also just need setup
```
yourRecyclerView.setup(items, R.layout.item_main, { item ->
            this.tv_item.text = item //item is string you can also use objects
            this.setOnClickListener { logX("clicked $item") }
    })
```

## Project Gradle
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
## App Gradle

```
dependencies {
    ...
    implementation 'com.github.zetazaw:kotilities:0.0.2.1'
}
