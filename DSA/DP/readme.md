# DP:
 Is a Systematic and Efficiently way of solving problems by solving it's sub problems. (May sound like Recursion or Divide and Conquer initially).
## Characteristics of a DP problem are:
    i. It has "Overlapping Sub problems" i.e. We solve same sub problem "mutilple times" while we try solving the core problem.
    ii. Optimal Sub structure - If we can solve all sub problems we could solve the core problem.

-> It systematically and efficiently searches for all possible solutions for a given problem.

## Types of DP:
i. Tabulation (Bottom Up) -> Tabulation is a way of solving subproblems first using iteration while storing the output of subprobles in a Table (array)
ii. Memoization (Top Down) -> Memoization is a way of solving subProblems using recursion while storing the output in a Array or HashMap.

# Framework/ Tips to Identify a DP Problem:
Sometimes it could be difficult to approach a problem from above DP characteristics. Following chars provide more easy/simple to identify DP problems.

    a. First Characteristic: Problem asks for "Extremes"
    i.e. Longest/Shortest/ Maximum/ minimum/ Highest or lowest kind of terms could be seen in the problem. 
    b. Second Characteristic: Decisions at each step matters
    i.e. If a decision at a given step impacts the result then it's a DP problem.

    DP vs Greedy:
    2nd characteristic helps to identify DP over Greedy i.e. In Greedy we become greedy and only pick the Max/min/longest/shortest solution at each.
    However in some problems this greedy approach may only lead to a wrong answer. In which case we should use DP. 
    -> Assume a given question is Greedy until you come up with a counter example that says it doesn't work for this problem. 

### Example 1: 

House Robber is an excellent example of a dynamic programming problem. The problem description is:
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
In this problem, each decision will affect what options are available to the robber in the future. For example,
with the test case nums = (2, 7, 9, 3, 1], the optimal solution is to rob the houses with 2, 9, and 1 money.
However, if we were to iterate from left to right in a greedy manner, our first decision would be whether to rob the first or second house. 7 is way more money than 2, so if we were greedy, we would choose to rob house 7.
However, this prevents us from robbing the house with 9 money. As you can see, our decision between robbing the first or second house affects which options are available for future decisions.

### Example 2: 
Longest Increasing Subsequence is another example of a classic dynamic programming problem. In this problem, we need to determine the length of the longest (first characteristic) subsequence that is strictly
increasing. For example, if we had the input nums = (1, 2, 6, 3, 5], the answer would be 4, from the
subsequence |1, 2, 3, 5]. Again, the important decision comes when we arrive at the 6 - do we take it or not take it? If we decide to take it, then we get to increase our current length by 1, but it affects the future - we can no longer take the 3 or 5. Of course, with such a small example, it's easy to see why we shouldn't take it - but how are we supposed to design an algorithm that can always make the correct decision with huge inputs?
Imagine if nums contained 10, 000 numbers instead.
When you're solving a problem on your own and trying to decide if the second characteristic is applicable, assume it isn't, then try to think of a counterexample that proves a greedy algorithm won't work. If you can think of an example where earlier decisions affect future decisions, then DP is