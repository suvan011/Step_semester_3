# Week 9 — Part B Quiz and Part C Concepts

## Part B — Quiz answers
1. **B — O(1)**
2. **C — Insertion**
3. **C — Match required operations and constraints to the strengths of data structures**
4. **C — Time vs space trade-offs**
5. **B — O(m + n)**
6. **C — Linear data structure**
7. **C — O(n)**
8. **D — Linked list**
9. **B — O(m × n)**
10. **C — Organize, store, and access data efficiently for specific operations**

## Part C — Concept answers

### 1. Searching in unsorted vs sorted 1D arrays
An unsorted array generally requires a linear scan, taking O(n) time in the worst case. A sorted array can use binary search, which halves the remaining search range each step and takes O(log n) time. Binary search requires the data to remain sorted.

### 2. Why O(2n) becomes O(n)
Big-O ignores constant factors. Both 2n and n grow linearly, so O(2n) simplifies to O(n).

### 3. Traversal in linear vs non-linear structures
In a linear structure such as an array, elements are visited in sequence. In a non-linear structure such as a tree, traversal follows relationships such as parent and child, using strategies like depth-first or breadth-first search.