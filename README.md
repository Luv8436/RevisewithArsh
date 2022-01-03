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

