# Kokis                  ![alt tag](https://api.bintray.com/packages/prihannimsara/KokisRepository/kokis/images/download.svg)



This is Kokis android library. It can be used to minimize the complexity of sharedpreferences and to store and retrieve data in the android application in a simpler way. This library will make your code neat and yes it will make your code shorter compared to what you get from using sharedperfernces.Remember this is developed using sharedpreferences and it is a library which makes programming easier.



![alt tag](https://user-images.githubusercontent.com/29063580/27034382-23bcc2ca-4f9b-11e7-8189-f8ddada96a20.jpg)

For the android project just include the following dependency inside you build.gradle's depedency list.

## Gradle

```java
repositories{
   jcenter()
 }
```

```java
 dependencies {
   ...
   compile 'com.prihanofficial:kokis:1.0.0'
 }
```

#### if you using maven use following Maven

```java
<dependency>
  <groupId>com.prihanofficial</groupId>
  <artifactId>kokis</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

After setup installing lib to your project you just need only to call it using just few lines of code. It will return you a string with the results.

## Usage

#### To use Kokis Android Libarary

Add this code segment inside  your Application class or Activity class

```java
Kokis.setContext(this)
                .setSharedPreferencesName(getPackageName())
                .setMode(Mode.PRIVATE)
                .setUseDefaultSharedPreference(UserDefault.NO)
                .build();
```

#### This contain multiple pre-defined Modes.

```java
Mode.PRIVATE         // By setting this mode, the file can only be accessed using calling application
Mode.WORLD_READABLE  // This mode allow other application to read the preferences
Mode.WORLD_WRITEABLE // This mode allow other application to write the preferences
Mode.MULTI_PROCESS   // This method will check for modification of preferences even if the sharedpreference instance has already been loaded
```

#### This contain multiple pre-defined UserDefaults.

```java
UserDefault.YES      // Libarary name get as a sharedpreference name 
UserDefault.NO       // User given name get as a sharedpreference name
```

#### After initialization, you can use simple one-line methods to save values to the Kokis anywhere in your app, such as:

```java
Kokis.setKokisByteArray(key, byteArray);
Kokis.setKokisShort(key, short);
Kokis.setKokisInt(key, int);
Kokis.setKokisLong(key, loang);
Kokis.setKokisFloat(key, float);
Kokis.setKokisDouble(key, double);
Kokis.setKokisBoolean(key, boolean);
Kokis.setKokisString(key, String);
```

#### Retrieving data from the Kokis can be as simple as:

```java
Kokis.getKokisByteArray(key, String);
Kokis.getKokisShort(key, String);
Kokis.getKokisInt(key, int);
Kokis.getKokisLong(key, long);
Kokis.getKokisFloat(key, float);
Kokis.getKokisDouble(key, String);
Kokis.getKokisBoolean(key, boolean);
Kokis.getKokisString(key, String);
 ```

#### Delete data from the Kokis can be as simple as;

```java
Kokis.deleteKokisKey(key);
Kokis.clearAllKokisData();
```

## Limitations

- Currently min SDK is set to 17

## Changelog

- 1.1.0
    - Stable the release with sample code
- 1.0.0
    - Initial release

## Author

Prihan Nimsara, [prihanofficial.com](http://prihanofficial.com)

Checkout my other contributions, https://github.com/PrihanNimsara?tab=repositories

## License

Copyright 2017 Prihan Nimsara

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
