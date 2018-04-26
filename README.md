# Toasty

<div align="center">
	<img src="https://github.com/ChanphengHor/PToasting/blob/master/toast_screen/screen_all.jpg">
	<a href="https://github.com/ChanphengHor/PToasting/tree/master/toast_screen"> See All Screenshort </a>
</div>

## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	implementation 'com.github.ChanphengHor:PToasting:1.0.0'
}
```

## Configuration

For this Configuration you can use to your Base/Super Class or onCreate to a activity

```java
PToast.edit()
	.setDuration(PToast.LENGTH_SHORT)
	.setGravity(Gravity.BOTTOM,0,50) / .setGravity(Gravity.BOTTOM)
	.hasMargin(true)
	.setTransparent(false)
	.done(); // finally
```


## Usage

PToast just simply use static class : 

Displaying a simple PToast:

``` java
PToast.show(this,"This is simple PToast !!");
```
Displaying a danger PToast:

``` java
PToast.danger(this,"This is Danger PToast !!");
```
Displaying a warning PToast:

``` java
PToast.warning(this,"This is Warning PToast !!");
```
Displaying a info PToast:

``` java
PToast.info(this,"This is Info PToast !!");
```
Displaying a success PToast:

``` java
PToast.success(this,"This is Success PToast !!");
```
Displaying a <strong>strong</strong> PToast:

``` java
PToast.success(this,"Strong : ","=> this is Strong PToast !!");
```
Displaying a html PToast:

``` java
PToast.successAsHTML(this,"<strong>Strong</strong> <u>Underline</u> => html Tag Toast");
```
## Credit by Hor Chanpheng
