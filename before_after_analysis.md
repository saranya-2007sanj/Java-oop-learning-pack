# Before / After Analysis

## 1. Understanding: misconception (before) vs verified fact (after)
| Topic | BEFORE (typical unverified belief / risky AI claim) | AFTER (verified) | Proof |
|---|---|---|---|
| Fields | "Child's field overrides the parent's" | Fields are hidden; declared type decides | E10, Q8 |
| Overloads | "Runtime type picks the method" | Compile-time, declared type | E07, Q7 |
| Strings | "`==` compares text" | References; use `equals` | E10, Q12 |
| Parameters | "Objects passed by reference" | Reference passed by value | E10, Q15 |
| `equals` | "Override equals only" | Also `hashCode` or sets break | Ex. 13 |

## 2. Workflow: how the pack changed after adding verification
| Aspect | Before (AI draft only) | After (verify + automate) |
|---|---|---|
| Code | Unrun snippets in chat | 30 programs executed with assertions (`run_all.sh`) |
| Quiz answers | Assumed | 5 of 15 questions tied to executed output; rest cross-referenced to JLS |
| Exercises | Hand-written once | Generated doc from tested source + 12 template variants (`generate.py`) |
| Diagrams | Free-drawn | Mermaid from code; arrows checked against class declarations |

## 3. Learner impact (fill with real data from a pilot, e.g. 5-10 classmates)
| Measure | Before (pre-test) | After (using the pack) | Notes |
|---|---|---|---|
| Quiz score (out of 15), average | | | |
| Misconception questions correct (Q5, Q7, Q8, Q12, Q15) | | | |
| Time to complete exercises | | | |
| Confidence (1-5) | | | |

> No learner data has been collected by this draft; leave section 3 blank until you run a pilot, then write one paragraph of honest conclusions.
