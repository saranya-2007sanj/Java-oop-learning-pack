# 5-Minute Final Demo Script

1. **(30 s) Problem & audience** - slide 1-2: can AI teach OOP well, and how do we trust it?
2. **(60 s) Concept -> code -> UML** - open `uml/UML.md` (E04 diagram), then run `java src/examples/E04_Polymorphism.java`. Point out the loop that never changes when a new Shape is added.
3. **(60 s) Misconception demo** - run `java src/examples/E10_Misconceptions.java`; show `p.name -> Parent` and ask the audience to predict first.
4. **(45 s) Verify everything** - run `./run_all.sh`; show 11 PASS lines and "ALL 20 EXERCISES PASSED".
5. **(45 s) Automation** - run `python3 tools/generate.py variations --seed 99`; open `docs/exercise_variations.md`.
6. **(45 s) AI testing** - show the filled hallucination table (verification report Part C) and one wrong AI answer you caught.
7. **(15 s) Wrap-up** - quiz + checklist for self-study; ethics: verify, explain, credit.
