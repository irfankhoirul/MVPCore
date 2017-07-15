# MVPCore

This is a library that provide core components to build Android app that implementing Model View Presenter architecture. The example of usage can be seen in [LoginRegisterMVP](https://github.com/irfankhoirul/LoginRegisterMVP) repository.

### How to Use

Add this dependency to your module level of build.gradle
```groovy
dependencies {
    compile 'com.github.irfankhoirul:MVPCore:0.1.5'
}
```

And this repository to your project level of build.gradle 
```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```


## License

    Copyright 2016-2017 Irfan Khoirul Muhlishin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.