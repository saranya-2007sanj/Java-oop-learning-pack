#!/usr/bin/env bash
# Runs every example and all 20 exercise solutions; writes verification/run_log.txt
cd "$(dirname "$0")"
mkdir -p verification
LOG=verification/run_log.txt
: > "$LOG"
echo "JDK: $(java -version 2>&1 | head -1)" >> "$LOG"
fail=0
for f in src/examples/E*.java exercises/Solutions.java; do
  echo "=== $f ===" >> "$LOG"
  if java "$f" >> "$LOG" 2>&1; then echo "[PASS] $f" | tee -a "$LOG"; else echo "[FAIL] $f" | tee -a "$LOG"; fail=1; fi
done
exit $fail
