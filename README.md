# Kotilities
Some useful Kotlin extension functions and MVP framework

### Usage
Anywhere (activity, fragment, framework's presenter) 
just - 
```
logX("message") 
``` 
or 
```
logX("message", "e") 
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
        implementation 'com.github.zetazaw:Kotilities:master-SNAPSHOT'
    }
