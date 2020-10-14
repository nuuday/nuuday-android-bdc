# Behavior Driven Components For Android 
#### by [Nuuday](https://nuuday.com/?_ga=2.177655397.1522986134.1602592361-2052711778.1601640763&_gac=1.49031508.1601640763.CjwKCAjwn9v7BRBqEiwAbq1Ey9n3yaRxy73jAPy5bQ1DTgcIDYxJjT1S-cZyIdgQL_I7qn3r5inSKxoCFxUQAvD_BwE)
Decouple Your Android Component Logic Through Behaviors And Get Out Of Base-Class Hell.

## What is this library about? What's the problem?
>All my fragments need to track if they are opened for user insight purposes, wait, except maybe one..

>Oh well, I'll just make a BaseFragment with tracking and ignore it in that one component..

>Alright, but now some of my fragments inheriting BaseFragment needs a shared feature, but not others... 

>How in the world do I solve this in a nice way? More inheritance layers?

If you've ever made a BaseFragment (or another BaseComponent), then a problem like the one above is probably something you've encountered. 

**So, what is the problem:**
- Using BaseComponents causes a multitude of problems as your project gains more complexity
- Component code in Android can quickly grow beyond comprehension as more features are added to the component
- A single Fragment or Activity can often begin to take care of many UI responsibilities, that are functionally separate, but which all needs to live in the same component 
- An Application object often grows to take care of a range of initialization, twisting the onCreate() function into an unholy mess

## So how does this library solve the issue?
This library makes Android components use the principle of [composition ](https://en.wikipedia.org/wiki/Composition_over_inheritance)[over ](https://www.youtube.com/watch?v=wfMtDGfHWpA)[inheritance](https://stackoverflow.com/questions/49002/prefer-composition-over-inheritance). 

Decouple uncorrelated logic into declared **Behaviors**. Behaviors gets called in order of declaration, with the same lifecycle methods as the parent component.

For example, here's a fragment, close to the sample projects MainFragment:

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

A Behavior is just a simple Kotlin interface, that is hooked into the same lifecycle as its parent, with methods you can choose to override if you need them. Just like a regular Android component:

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

**When refactoring with this library, it is recommended to move all component code into behaviors and not go for a hybrid approach, which can cause lifecycle complexity**

## Sample project
A small ToDo app is used to illustrate the mechanism of Behavior Driven Components.

![](design/design_screenshot.png)

The sample uses both a behavior driven application, activity and fragment.

## I have a component that needs to become behavior driven, but is not in the library?
If you implement the IBehaviorDrivenComponent interface (IBehaviorDrivenFragment for example), you can hook any native component into a behavior driven architecture.

This way you can start using behavior driven architecture on all native toplevel components with lifecycles.

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


