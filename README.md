# Kotilities
Some useful Kotlin extension functions and MVP framework


### Gradle
allprojects {

    repositories {
    
        jcenter()
        
        maven { url "https://jitpack.io" }
        
    }
}
### Gradle
dependencies {

    compile fileTree(dir: 'libs', include: ['*.jar'])
    
    ...
    
    compile 'com.github.zetazaw:Beach:-SNAPSHOT'
}
