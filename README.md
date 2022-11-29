# CRED Swipe Animation

### What?

Design and implement a working pull-down animation.

### TL/DR

- The UI is written in Kotlin with Jetpack Compose
- The Animations are done using Jetpack Compose Animation and Gestures.
- The Data Layer is abstracted into *BusinessLogic→Services→Repositories→DataSources*
- UI is written in such a way that ensures:
    - Atomic Components are reusable across screens
    - UI Theme is passed Top→Bottom in the UI hierarchy
    - Animation Wrappers can work with any compatible UI component → There is no tight coupling b/w animations and UI components.
    - UI shows consistent behavior across different screen sizes -
        - Parent Composables don’t have hard-coded dimensions and spacing.
        - Child Composables make use of Local Screen Density to make calculations wherever applicable.

### Dependencies Used

| Jetpack Compose | Android's recommended modern toolkit for building native UI |
| --- | --- |
| Compose Navigation | Navigation component's support for Jetpack Compose |
| Dagger<>Hilt | Dependency Injection |
|  Ktor | Networking |
|  Gson | Serialisation<>Deserialisation  |

### UI Anatomy:

![UI Anatomy](https://user-images.githubusercontent.com/26869672/204601377-36131540-d640-4a84-b3f4-b10f1fb4eabf.png)

### Core Code Organisation

**The presentation Layer**

- The **“views”** package contains the core of the UI presentation for the application.
- The idea is to make use of atomic principles and divide views into three separate logical units
    - **Activities**
        - One Activity → MainActivity
    - **Screens** → Screens are Basically made of composable which mimic one UI screen on mobile.
    - **Components** → Components are reusable basic UI blocks. These are three types -
        - **atoms** → The most fundamental UI unit
        - **compounds** → Multiple atoms combine to make compounds, compounds make up the screens
        - **anim** → This package contains animations. Animations are also composables but with animation states which wrap other composables to display animations.

> **Notes** - I had the option of going with Fragments instead of Screens to leverage fragment lifecycle but I wanted to try out the idea of using composable screens which do not require fragments. 
In the production application which I maintain, I have used the idea of ***“One Activity → Many Fragments”***
> 

![Untitled](CRED%20Mobile%20Harsh%20Joshi%20d4b3d82beb324373b232553a5b4704f6/Untitled%201.png)

**The Data Layer**

- The data layer makes use of a data-access hierarchy
- ViewModel consumes the injected **Business Logic.**
- **Business Logic** calls **Services** → **Services** Talk to **Repositories** → **Repositories** have the option to talk to **LocalDataSource** or **RemoteDataSources** which have their respective Database/Networking implementations.
- For this assignment, to keep things simple I have opted for a simple Abstraction and not gone towards implementing LocalDataSource.

![Untitled](CRED%20Mobile%20Harsh%20Joshi%20d4b3d82beb324373b232553a5b4704f6/Untitled%202.png)

> **Notes** - For this assignment, I have kept the Data Layer on the Android Client itself. Ideally, I would prefer (which I also do on the Production apps) to keep this layer on KMM. It gets easier to maintain the business Logic and multiple clients (including iOS) can consume the business logic.
> 

**The Domain Layer**

- The ViewModels would ingest business Logic and work with the Data layer using BusinessLogic Interfaces.
- Each ViewModel shall extend “**BaseViewModel”**
- BaseViewModel encapsulated common view modal functions.

### Functional Requirements

- Implement a pull-down animation where the user has to drag the circle view into the
bottom container view -
    
    [Cred 1- Animation.mp4](CRED%20Mobile%20Harsh%20Joshi%20d4b3d82beb324373b232553a5b4704f6/Cred_1-_Animation.mp4)
    

- The circle view can only be dragged in a vertical straight line as shown in the sample
video below
- If the user drops it outside the container, the circle should go back to its initial position
    
    [Cred-2 Vertical Swipe.mp4](CRED%20Mobile%20Harsh%20Joshi%20d4b3d82beb324373b232553a5b4704f6/Cred-2_Vertical_Swipe.mp4)
    

- If the user drags and drops the circle in the container view, the circle should stay in
the container view and make the network call
a. On success: The card should expand 
b. On failure: The circle should go back to its initial position and show an error toast
    
    [Cred-3 Failure Case.mp4](CRED%20Mobile%20Harsh%20Joshi%20d4b3d82beb324373b232553a5b4704f6/Cred-3_Failure_Case.mp4)
    

- Implement both success and failure cases, you can have a toggle button to simulate both
the cases
    
    [Cred-4 E2E.mp4](CRED%20Mobile%20Harsh%20Joshi%20d4b3d82beb324373b232553a5b4704f6/Cred-4_E2E.mp4)
    

### Design Considerations/Assumptions

- The animation will be triggered when the user swipes down the screen.
- The animation should be smooth and responsive.
- The animation should be easy to maintain and extend.
- The animation should work consistently across different screen sizes

### Other Assumptions for This Assignment

- Test Cases and Code Coverage is not required.
- A deployment Pipeline Setup is not needed.
- KMM implementation for Data Layer is not required.
- Local Persistence/ Cache for the Networking layer is not required.
