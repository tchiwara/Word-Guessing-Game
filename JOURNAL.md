# Developer Journal — Word Guessing Game

---

## Constructor Return Type Bug
Tried to give a constructor a return type. Compiler screamed.
Rule burned in: constructors have no return type, not even void.

---

## The `this` Keyword — From Theory to Reality
Used `this` before but never understood the practicality.
Today it clicked — without it, the constructor was assigning
parameters to themselves. Instance variables stayed null/0.
Discovered this when `checkLetter()` couldn't see `wordToGuess`.
Now I understand why it exists, not just how to use it.

---
## The Two-Variable Loop Bug

Tried to use `i` for both iterating AND tracking position.  
Two jobs, one variable — broke everything.

Dry run on paper caught it. Lesson: one variable, one job.

Brain was boiling. Stepped away. Came back fresh and spotted it.

That's when I learned the accumulator with early exit pattern.

---

## Pseudocode Saves Lives
Kept rushing to code without pseudocode or dry runs.
Result: boiling head, broken logic, wasted time.
New rule: Algorithm → Flowchart → Pseudocode → Code.
Never touch the keyboard until the logic works on paper.

---

## Scanner Side Effects Bug
Program was asking for input twice. Confusing at first.
Cause: called `scanner.next()` twice — once to validate,
once to return. Each call consumes input from the stream.
Fix: store result in variable, reuse it.
Principle: methods with side effects — call once, store result.

---

## Exception ≠ Validation
Assumed entering a number would throw `InputMismatchException`
with `scanner.next()`. Wrong. `next()` accepts anything as String.
Exceptions handle runtime errors. Conditions handle business logic.
Used `Character.isLetter()` for explicit validation instead.
Important shift: from relying on exceptions to designing
intentional validation logic.

---

## Unreachable Code
Put `attempts--` after `return false`. Compiler caught it.
Java is strict for a reason — in production, that bug means
a user never loses attempts and exploits the system.
Enterprise-grade strictness isn't bureaucracy. It's protection.

---

## Boolean Assignment Trick
Discovered `running = (choice == 1)` replaces an entire if/else.
Felt obvious after seeing it. That feeling = pattern library growing.

---

## The `getValidInput(int min, int max)` Moment
Was about to write two separate input methods.
Spotted the duplication. Extracted the difference as parameters.
One method, flexible, reusable.
Simple solutions always feel obvious in hindsight.

---

## Enum Design
Learned enums are pre-created objects — no `new` needed.
Each constant runs the constructor once at program startup.
`Difficulty.Easy` exists before `main` even starts.
Filed away: Java is doing work behind the scenes I can't always see.