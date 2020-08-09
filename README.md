# Things-To-Do
# Android Architecture Components
![](https://cdn-images-1.medium.com/max/800/1*WVdFMYmEoCdXniy7ulDe5g.png)


## Read article [here](https://medium.com/proandroiddev/android-architecture-components-cb1ea88d3835)
Android Architecture Components (AAC) is a new collection of libraries that contains the lifecycle-aware components. It can solve problems with configuration changes, supports data persistence, reduces boilerplate code, helps to prevent memory leaks and simplifies async data loading into your UI. I can’t say that it brings absolutely new approaches for solving these issues, but, finally, we have a formal, single and official direction.

AAC provides some abstractions to deal with Android lifecycle:
* LifecycleOwner
* LiveData
* ViewModel

The main benefit is the fact that our UI components, like TextView or RecycleView, observe LiveData, which, in turn, observes the lifecycle of an Activity or Fragment, using a LifecycleObserver.
