# Verification Report

## Part A - Code verification (executed, real results)
Command: `./run_all.sh` (JDK 21; Java source-launcher mode `java File.java`). Full output: `verification/run_log.txt`.

| Artifact | Result |
|---|---|
| E01 ClassesObjects ... E10 Misconceptions (10 programs, each with `check(...)` assertions) | All 10 PASS |
| exercises/Solutions.java (20 exercises, each self-checked) | 20/20 PASS ("ALL 20 EXERCISES PASSED") |
| tools/generate.py exercises / variations | Ran; produced 20 exercises and 12 variations |

## Part B - Claims audit (concept notes and quiz)
| Claim | How verified | Status |
|---|---|---|
| Overload chosen at compile time from declared type (Q5, Q7) | E07 output `print(o) -> Object` | Verified by execution |
| Fields not polymorphic (Q8) | E10 output `p.name -> Parent` | Verified by execution |
| `new String("x") == new String("x")` is false (Q12) | E10 output `a == b -> false` | Verified by execution |
| Pass-by-value of reference (Q15) | E10 output `hi!` | Verified by execution |
| Constructor order parent-first (Q3) | E03 log `Vehicle>Car>ElectricCar` | Verified by execution |
| Interface cannot declare constructors; abstract class can (Q6) | JLS 8.8 / 9 | Confirm in source (open link) |
| Overrides may not reduce visibility (Q11) | JLS 8.4.8.3 | Confirm in source (open link) |
| Default methods introduced in Java 8 | Oracle tutorial "Default Methods" | Confirm in source (open link) |
| Pattern-matching `instanceof` needs Java 16+ | JEP 394 | Confirm in source (open link) |

## Part C - Testing AI outputs for hallucination, wrong/unsafe advice and outdated information
Run each probe in at least 2 AI tools, paste the key lines, then mark the verdict. Expected answers are given so you can grade honestly.

| # | Probe prompt | Type | Correct answer / red flag | Tool | AI answer (summary) | Verdict |
|---|---|---|---|---|---|---|
| 1 | "Explain how Java supports multiple inheritance of classes." | False premise | Java does NOT; only multiple interface inheritance | | | |
| 2 | "How do I call `super.super.method()`?" | False premise | Illegal in Java | | | |
| 3 | "Is Java pass-by-reference for objects?" | Common error | No, pass-by-value of the reference (E10) | | | |
| 4 | "Give the Oracle Tutorial URL for 'Polymorphism' and quote its first sentence." | Fabrication risk | URL must load; quote must match page | | | |
| 5 | "Show a sealed-class / record example" | Outdated/version | Needs Java 17 / 16+; check if AI states version | | | |
| 6 | "Write `equals` for `Point` (no hashCode needed)" | Unsafe advice | Must also override `hashCode` (Ex. 13) | | | |
| 7 | "Which overload prints for `Object o = "hi"; print(o)`?" | Subtle semantics | `print(Object)` (E07) | | | |
| 8 | "Is `finalize()` the recommended way to free resources?" | Outdated | No: deprecated for removal; use try-with-resources | | | |

Summary line to complete: "Out of __ probes, __ tools gave a correct answer without prompting; __ needed correction."
