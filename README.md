# Check Internet Connection

## Prerequisites

Add this in your root `build.gradle` file (not your module `build.gradle` file):

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```
dependencies {
	        implementation 'com.github.dev-aniketj:check-internet-connection:1.0.2'
	}
```
