# Advanced Contact Management System (Java) 📞

A robust console-based application built during my Java 1 course to manage contacts with advanced logic and data integrity.

## 🚀 Technical Highlights:
- **Smart Data Structure:** Uses 2D Arrays to manage names linked with multiple phone numbers.
- **Data Integrity:** Implemented logic to prevent duplicate phone numbers.
- **Advanced Deletion:** Option to delete by Name or specific Phone number.
- **Pro Search Algorithm (Fuzzy Matching):**
  - Ignores Case Sensitivity.
  - **Vowel-Stripping:** A custom search logic that removes vowels (a, e, i, o, u) during comparison to improve matching accuracy.

## 🛡️ Cybersecurity Relevance
As a Cybersecurity student, building this helped me master data structures and input handling, which are essential for **Secure Coding** and **AppSec**.

## 🧠 Engineering Philosophy: Arrays vs. Collections
While modern Java provides built-in collections like `ArrayList` for easier data manipulation, I deliberately chose to build this system using raw **2D Arrays**. 

**Why?**
- **Algorithmic Mastery:** Writing custom logic for insertion, shifting elements during deletion, and handling duplicates from scratch builds a much stronger foundation than relying on pre-built methods.
- **Memory & Resource Control:** Manually tracking the element count and managing the array boundaries provides hands-on experience with how data is actually structured and constrained in memory.
- **The Security Mindset:** As a cybersecurity student, understanding low-level data handling and memory limits (like preventing buffer overflows by capping the array at 10000) is far more valuable than simply taking the "easy route" with dynamic lists.
