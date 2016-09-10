# Learning Outcomes
After studying this code and completing the corresponding exercises, you should be able to,

1. [Utilize User Stories `[LO-UserStories]`](#utilize-user-stories-lo-userstories)
1. [Utilize use cases `[LO-UseCases]`](#utilize-use-cases-lo-usecases)
1. [Use Non Functional Requirements `[LO-NFR]`](#use-non-functional-requirements-lo-nfr)
1. [Use Polymorphism `[LO-Polymorphism]`](#use-polymorphism-lo-polymorphism)
1. [Use abstract classes/methods `[LO-Abstract]`](#use-abstract-classesmethods-lo-abstract)
1. [Follow Liskov Substitution Principle `[LO-LSP]`](#follow-liskov-substitution-principle-lo-lsp)
1. [Use Java-FX for GUI programming `[LO-JavaFx]`](#use-java-fx-for-gui-programming-lo-javafx)



------------------------------------------------------------------------------------------------------

## Utilize User Stories `[LO-UserStories]`
  
#### Exercise: Add more user stories 

* Assume you are planing to expand the functionality of the AddressBook (but keep it as a CLI application).
  What other user stories do you think AddressBook should support? Add those user stories to the `DeveloperGuide.md`. 

------------------------------------------------------------------------------------------------------

## Utilize use cases `[LO-UseCases]`

#### Exercise: Add an 'Edit tag' use case 
* Add a use case to the `DeveloperGuide.md` to cover the case of editing an existing tag.<br> 
  e.g. change tag `friends` to `buddies` <br>
  Assume that AddressBook confirms the change with the user before carrying out the operation. 

------------------------------------------------------------------------------------------------------

## Use Non Functional Requirements `[LO-NFR]`

#### Exercise: Add more NFRs 

* Add some more NFRs to the `DeveloperGuide.md`

------------------------------------------------------------------------------------------------------

## Use Polymorphism `[LO-Polymorphism]`

Note how the `Command::execute()` method shows polymorphic behavior. 

#### Exercise: Add a polymorphic `isMutating` method 

* Add an `abstract` method `boolean isMutating()` to the `Command` class. This method will return `true` for
  command types that mutate the data. e.g. `AddCommand`
* Currently, AddressBook data are saved to the file after every command. 
  Take advantage of the the new method you added to limit file saving to only for command types that mutate data.<br>
  i.e. `add` command should always save the data while `list` command should never save data to the file.

Note: There may be better ways to limit file saving to commands that mutate data. The above approach, while not
 optimal, will give you chance to implement a polymorphic behavior.  

------------------------------------------------------------------------------------------------------

## Use abstract classes/methods `[LO-Abstract]`

Covered by `[LO-Polymorphism]`

------------------------------------------------------------------------------------------------------

## Follow Liskov Substitution Principle `[LO-LSP]`

#### Exercise: Add an exception to an overridden method

* Add a `throws Exception` clause to the `AddCommand::execute` method. Notice how Java compiler will not allow it,
  unless you add the same `throws` clause to the parent class method. This is because if a child class throws
  an exception that is not specified by the Parent's contract, the child class is no longer substitutable in place of 
  the parent class.
* Also note that while in the above example the compiler enforces LSP, there are other situations where it is up to
  the programmer to enforce it. For example, if the method in the parent class works for `null` input, the overridden
  method in the child class should not reject `null` inputs. This will not be enforced by the compiler.
  
------------------------------------------------------------------------------------------------------

## Use Java-FX for GUI programming `[LO-JavaFx]`

**Resources**

* [JavaFX 8 Tutorial](http://code.makery.ch/library/javafx-8-tutorial/) by Marco Jakob

#### Exercise: Add class-level members

* If you are new to JavaFX, follow Marco's tutorial given above.
* Do some enhancements to the AddressBook GUI. e.g. add an application icon, change size/style 

------------------------------------------------------------------------------------------------------

