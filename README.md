# Behavior Driven Components For Android 
#### by [Nuuday](https://nuuday.com/?_ga=2.177655397.1522986134.1602592361-2052711778.1601640763&_gac=1.49031508.1601640763.CjwKCAjwn9v7BRBqEiwAbq1Ey9n3yaRxy73jAPy5bQ1DTgcIDYxJjT1S-cZyIdgQL_I7qn3r5inSKxoCFxUQAvD_BwE)
Decouple Your Component Logic Through Behaviors And Get Out Of BaseClass Hell.

## How to get it
Published through jitpack, so add this to your project level gradle file:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
And use this in your module level gradle files:
```
implementation 'com.github.nuuday:nuuday-android-bdc:1.0.0'
```

## What is this library about? What's the problem?
Imagine all your fragments need to be able to do "A" (you call this class "BaseFragment"). As time goes on, most of your fragments need to do "B", and some need to do "C".

Then, the product evolves and you want a fragment that is able to do "B"+"C" **but NOT "A"**.

If you used inheritance, you are now stuck. "C" came from "B" which came from "A". Do you now create a "B" fragment with duplicated behavior from "A"?

Inheritance can cause a multitude of problems, many well described through:
- [The wikipedia entry on Composition Over Inheritance](https://en.wikipedia.org/wiki/Composition_over_inheritance)
- [A great video on the subject by Fun Fun Function](https://www.youtube.com/watch?v=wfMtDGfHWpA)
- [The open discussion on Stack Overflow](https://stackoverflow.com/questions/49002/prefer-composition-over-inheritance)

## So how does this library solve the issue?
This library makes Android components use the principle of [composition ](https://en.wikipedia.org/wiki/Composition_over_inheritance)[over ](https://www.youtube.com/watch?v=wfMtDGfHWpA)[inheritance](https://stackoverflow.com/questions/49002/prefer-composition-over-inheritance). 

Decouple uncorrelated logic into declared **Behaviors**. Behaviors gets called in order of declaration, with the same lifecycle methods as the parent component.

For example, here's a fragment from the sample project with 5 independent behaviors:

```kotlin
class MainFragment : BehaviorDrivenFragment() {

    init {
        behaviours.addAll(
            SetMainViewAndViewModelFragmentBehavior(..),
            ControlHeadlineTextAnimationsFragmentBehavior(..),
            ToDoListFragmentBehavior(..),
            NavigateToNuudayFragmentBehavior(..),
            ControlInputDoneActionFragmentBehavior(..)
        )
    }
    
}
```

Every behavior has a single UI responsibility, and each of the behaviors make sense in themselves if you interact with the sample application. 

A Behavior is just a simple Kotlin interface, that is hooked into the same lifecycle as its parent, with methods you can choose to override if you need them. Just like a regular Android UI component:

```kotlin
interface FragmentBehaviour {

    fun onCreate(savedState: Bundle?){
        // Override for onCreate behavior
    }

    fun onResume(){
        // Override for onResume behavior
    }

    fun onPause(){
        // Override for onPause behavior
    }
    
    fun onDestroy(){
        // Override for onDestroy behavior
    }

    fun onCreateViewBehavior(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return null // Override and return a view to propegate it to parent fragment
    }

    ..
}
```

In case the parent component needs a return value, the first behavior to provide it, gets returned by the parent.

**When refactoring with this library, it is recommended to move all component code into a starter behavior first, and not go for a hybrid approach, which can cause lifecycle complexity. Then start decopuling, after the first behavior is created.**

## Sample project
A small ToDo app is used to illustrate the mechanism of Behavior Driven Components.

![](design/design_screenshot.png)

The sample uses both a behavior driven application, activity and fragment.

## I have a component that needs to become behavior driven, but is not in the library?
If you implement the IBehaviorDrivenComponent interface (IBehaviorDrivenFragment for example), you can hook any native component into a behavior driven architecture. An exotic Activity class, Fragment class, Service class etc.

This way you can start using behavior driven architecture on all native components with lifecycles. Views are not included in current behavior driven architecture though, but feel free to make a pull request for it.

License
-------

    Copyright 2020 Nuuday

    The library is licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


