# RevisewithArsh

## Print Anagrams Together 

Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.<br/> <b>Approach</b>
<h3> store all pairs in the hashmap such that key is sorted order of the string and value is array list of strings 
<h3>words[] = {act,god,cat,dog,tac}</h3>
<h3>act --> [act,cat,tac] <br/>dog --> [god , dog] </h3>

## Count the subarrays having product less than k 

Given an array of positive numbers, the task is to find the number of possible contiguous subarrays having product less than a given number k.
<br/> <b>Approach</b>
<h3> Iterate from the start of the array and start computing the product of numbers till i and if that product is less than k that simply consider all subarrays between start index and current index else divide product by starting index until the product becomes less than k and then count number of subarrays.
<h3>Time complexity - O(n) </h3><br/> we are simply iterating over the array and for every index calculating the count.
<h3>Space complexity - O(1) </h3><br/> we are not using any extra space.

## Run Length Encoding 

Given a string, Your task is to  complete the function encode that returns the run length encoded string for the given string.
eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
<br/> <b>Approach</b>
<h3> count=1<br/> Iterate and increment the count if current and previous character are same else set count=1 and do the same.</h3>

## Ugly Numbers 

Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included. Write a program to find Nth Ugly Number.
<br/> <b>Approach</b>
<h3> Consider the min of multiples of 2 , 3 , 5 but only those multiples which are itself mutilple of 2,3,5 <br>
For example multiples of 2 are 2,4,6,8,10,12,14,16<br> don't consider 14 because 14 = 2*7 <br/> so we are finding the multiples of 2,3,5 which are multiples of 2,3,5 and that is what we store in dp array. <br/> we track the count of last multiple of 2,3,5 and every time we get the min we increase the count of that multiple.<br/>
dp[] = [1->ptr2,ptr3,ptr5]  and min of (2*dp[ptr2],3*dp[ptr3],5*dp[ptr5]) is 2*dp[ptr2] so increase ptr2 by 1.  </h3>

## Find the position of M-th item 

M items are to be delivered in a circle of size N. Find the position where the M-th item will be delivered if we start from a given position K. Note that items are distributed at adjacent positions starting from K.
<br/> <b>Approach</b>
<h3> Take use of modulus operator </h3>

## Total Decoding Messages 

A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:
<br/> <b>Approach</b>
<h3> Char at ith index can form encoding with itself and also form encoding with with its prev character if it is between 1 and 26 so for every index store its encoding in dp[] and encodings at ith index = dp[i-1]+dp[i-2] conditions applied. </h3>

## Number following a pattern  

Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can't repeat.
<br/> <b>Approach</b>
<h3> Make an array and take one counter variable and print all numbers left before and increase counter when char is I else do nothing.  </h3>

## Find Missing And Repeating   

Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.
<br/> <b>Approach</b>
<h3> Take xor of all elements of array and elements from 1 to N. the resulting xor is the xor of duplicate and the missing element and all other elements are cancelled with each other. find the rightmost set bit which will help them seperate into two groups.Each group xor has either duplicate elements or one of the missing and repeating element. So taking xor of these groups give you seperate missing and repeating elements. So iterate over the array and find the elements which is repeating and the other one is missing.  </h3>

