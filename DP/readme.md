# DP:
 Is a Systematic and Efficient way of solving problems by solving it's sub problems. (May sound like Recursion or Divide and Conquer initially).

 -> It systematically and efficiently searches for all possible solutions for a given problem.
## Characteristics of a DP problem are:
    i. It has "Overlapping Sub problems" i.e. We solve same sub problem "mutilple times" while we try solving the core problem.
    ii. Optimal Sub structure - If we can solve all sub problems we could solve the core problem.

FYI: Ability of DP to tackle Overalapping Sub problems is the major Diff between DP and D&C.


## Types of DP:
    i. Tabulation (Bottom Up) -> Tabulation is a way of solving subproblems first using iteration while storing the output of subprobles in a Table (array).
    ii. Memoization (Top Down) -> Memoization is a way of solving subProblems using recursion while storing the output in a Array or HashMap.

# Framework/ Tips to Identify a DP Problem:
Sometimes it could be difficult to approach a problem from above DP characteristics. Following chars provide more easy/simple wat to identify DP problems:

    a. First Characteristic: Most of the DP problem asks for "Extremes"
    i.e. Longest/Shortest/ Maximum/ minimum/ Highest or lowest kind of terms could be seen in the problem. 
    Example:
    -> What is the minimum cost of doing...
    -> What is the maximum profit from...
    -> How many ways are there to do...
    -> What is the longest possible...
    -> Is it possible to reach a certain point...

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
increasing. 

For example, if we had the input nums = (1, 2, 6, 3, 5], the answer would be 4, from the
subsequence |1, 2, 3, 5]. Again, the important decision comes when we arrive at the 6 - do we take it or not take it? If we decide to take it, then we get to increase our current length by 1, but it affects the future - we can no longer take the 3 or 5.

Imagine if nums contained 10, 000 numbers instead.

## Observartion:

When you're solving a problem on your own and trying to decide if the second characteristic is applicable, assume it isn't, then try to think of a counterexample that proves a greedy algorithm won't work. If you can think of an example where earlier decisions affect future decisions, then DP is

# Framework to Solve DP Questions

    Step 1: Define the State Variable -> A state Variable is the value we would like to store and reuse identify those variables a form a DP data structure (array or HashMap)
    Step 2: Deduce the recurrence Relationship
    Step 3: Use either Bottom up or Top Down Approach

## 1. State

In DP before we start solving a problem, we need to decide which is the state variable. 
-> Simply put I should ask myself, on which variable am I taking decisions on? -> State Variable
-> For example in house robber I'm deciding on the houses index (Assuming we are given array as input).
-> Every unique value of represents a unique state.
-> Note: There could be multiple state variables

### Good Analogy:

You might be wondering what "relevant" means here. Picture this problem in real life: you are on a set of stairs, and you want to know how many ways there are to climb to say, the 10th step. We're definitely interested in what step you're currently standing on. However, we aren't interested in what color your socks are. You could certainly include sock color as a state variable. Standing on the 8th step wearing green socks is a different state than standing on the 8th step wearing red socks. However, changing the color of your socks will not change the number of ways to reach the 10th step from your current position. Thus the color of your socks is an irrelevant variable. In terms of figuring out how many ways there are to climb the set of stairs, the only relevant variable is what stair you are currently on.

## 2. Recurrence Relationship:

A recurrence relation is an equation that relates different states with each other. Let's say that we needed to find how many ways we can climb to the 30th stair. Well, the problem states that we are allowed to take either 1 or 2 steps at a time. Logically, that means to climb to the 30th stair, we arrived from either the 28th or 29th stair. Therefore, the number of ways we can climb to the 30th stair is equal to the number of ways we can climb to the 28th stair plus the number of ways we can climb to the 29th stair.

The problem is, we don't know how many ways there are to climb to the 28th or 29th stair. However, we can use the logic from above to define a recurrence relation. In this case, 
    dp(i) = dp(i - 1) + dp(i - 2)
    dp(i) = dp(i - 1) + dp(i - 2)
As you can see, information about some states gives us information about other states.

## 3. Base Case

The equation on its own will continue forever to negative infinity. We need base cases so that the function will eventually return an actual number.

Finding the base cases is often the easiest part of solving a DP problem, and just involves a little bit of logical thinking.