# Java Notes — Word Guessing Game

## RULE #1 — Constructors Have No Return Type
Not even `void`. A return type = compiler error.

## Enums — Pass Actual Values, Not Types
```java
// WRONG
Easy(10, String[])
// CORRECT
Easy(10, new String[]{"cat", "dog"})
```

## In Getters — `this` keyword Is Unnecessary
No naming conflict in getters = `this` is redundant noise.

---

## The `this` Keyword

References the current object. Disambiguates instance variables
from constructor parameters with the same name.
```java
// Without this — assigns parameter to itself
wordToGuess = wordToGuess; // instance variable never set

// With this — correct
this.wordToGuess = wordToGuess;
```

**Rule:** Every constructor parameter that maps to an instance
variable needs `this.`

---
## Accumulator with Early Exit Pattern

An accumulator is a variable used to track progress across a loop — like counting, summing, or checking a condition.

The key idea:
- Declare the accumulator **outside the loop** so it retains its value
- Update it **inside the loop**
- Exit early as soon as the final condition is determined

Instead of scanning everything, you stop the moment you already know the answer.

Example mindset:
- Looking for a missing `_` in a word?
- The moment you find `_` → stop → no need to continue

Pattern:
````
boolean foundUnderscore = false;

for(int i = 0; i < guessedLetters.length; i++){
    if(guessedLetters[i] == '_'){
        foundUnderscore = true;
        break; // early exit
    }
}

if(!foundUnderscore){
    // player wins
}
````

---
## **Non-negotiable workflow:**
> Algorithm → Flowchart → Pseudocode → Code
> Never touch the keyboard until the logic works on paper.

---

## Input Validation & Guard Clauses

**Core question:** *"What values are actually valid here?"*
```java
// Guard clause pattern
if(invalid) return; // handle invalid first
// clean logic continues

// Boolean assignment trick
running = (choice == 1); // instead of if/else
```

**Key questions before every condition:**
- What inputs are valid?
- What would break this?
- Can I handle the invalid case first?

---

## Design Thinking — Extract the Parameter

When you find yourself writing the same method twice with
slightly different values — stop. That difference is a parameter.
```java
// BAD
getDifficultyInput()  // validates 1-3
getPlayAgainInput()   // validates 1-2

// GOOD
getValidInput(int min, int max)
```

**Rule:** Whatever changes → becomes a parameter.
Whatever stays the same → stays in the method.

---

## Character Input in Java

`Scanner` has no `nextChar()`. Workaround:
```java
char ch = scanner.next().toLowerCase().charAt(0);
```

`scanner.next()` accepts anything — no `InputMismatchException`
for numbers. Use `Character.isLetter()` for explicit validation.

---

## Side Effects Rule

If a method has side effects (consuming input, reading a stream,
querying a database) — **call it once, store the result.**
```java
// WRONG — reads input twice
if(Character.isLetter(scanner.next().charAt(0)))
    return scanner.next().toLowerCase().charAt(0);

// CORRECT — reads once, reuses
char ch = scanner.next().toLowerCase().charAt(0);
if(Character.isLetter(ch)) return ch;
```

---

## Method vs Class Decision

**Create a method** → reusable action that belongs to current class.

**Create a class** → distinct concept with its own data and behavior.

---

## Enums — No `new` Required

Java pre-creates all enum constants at program startup.
They exist before `main` even runs.
```java
Difficulty.Easy   // already exists, just access it
Difficulty.Medium
Difficulty.Hard
```

Constructor runs once per constant. `this` refers to the
constant being created at that moment.

---

## return vs break — Control Flow Clarity

### Key Understanding
A `return` statement does not just exit a loop — it exits the entire method.

When Java encounters `return`:
- Execution of the current method stops immediately
- Control goes back to where the method was called
- A value is returned (if required)

---

### Example — return inside a loop

```java
public int findIndex(int[] nums, int target){
    for(int i = 0; i < nums.length; i++){
        if(nums[i] == target){
            return i; // exits loop AND method immediately
        }
    }
    return -1;
}
```

Once `return` runs:
- Loop stops
- Method ends
- Nothing after it executes

---

### break vs return

#### break
```java
break;
```
- exits only the loop
- method continues executing after the loop

#### return
```java
return value;
```
- exits the entire method
- no further code in the method runs

---

### Example — difference in behavior

Using `break`:
```java
public void test(){
    for(int i = 0; i < 5; i++){
        if(i == 2){
            break;
        }
        System.out.println(i);
    }
    System.out.println("After loop");
}
```

Output:
```
0
1
After loop
```

Using `return`:
```java
public void test(){
    for(int i = 0; i < 5; i++){
        if(i == 2){
            return;
        }
        System.out.println(i);
    }
    System.out.println("After loop");
}
```

Output:
```
0
1
```

"After loop" never executes.

---

### Early Exit Pattern (Cleaner Approach)

Instead of:
```java
int result = -1;

for(...){
    if(condition){
        result = something;
        break;
    }
}

return result;
```

Prefer:
```java
for(...){
    if(condition){
        return something;
    }
}

return -1;
```

This removes unnecessary variables and keeps logic simple.

---

### Mental Model

- break = “I’m done with this loop”
- return = “I’m done with this entire function”

---

### Rule to remember

- Use return when the answer is found
- Use break when the loop is done but the method still has work

---

### Common Mistake

Thinking:
> "return exits the loop"

Correct understanding:
> return exits the entire method immediately
