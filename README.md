# Behavior Driven Components For Android by Nuuday
Make Your Android App Composable And Get Out Of Base-Class Hell.

## What is this library about? What's the problem?
*"All my fragments that inherits from my BaseFragment need to know if they're connected to the internet, wait, except this one, but it needs all the other features.."*
*"Oh well, I'll just ignore that part of my basefragment and hack around it"*

If you've ever made a BaseFragment in your Android project or a BaseActivity, BaseApplication, BaseService or something similar, then a problem like the one above is probably something you've encountered. 

**But this library IS for you, if you can at least partially agree that:**
- Using BaseComponents causes a multitude of problems as your project scales
- Component code in Android can quickly grow beyond comprehension as more features are added to the component
- A single Android Fragment or Activity can often grow to take care of multiple UI responsibilities, that are unconnected, but all needs to be in the same component 
- An Application object can often grow to take care of a multitude of initializations, twisting your onCreate() function into an unholy mess

## So how does this library solve the issue?




## Sample project
![](design/design_screenshot.png)


## 


License
-------

    Copyright 2020 Nuuday

    the library is licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


