'''
Given two strings s1 and s2, return true if s2 contains a 
permutation
 of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 
'''

'''
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        start = 0
        current_window = Counter()
        s1_count = Counter(s1)

        for end in range(len(s2)):
            current_window[s2[end]] += 1

        
            while end - start + 1 > len(s1):
                if current_window[s2[start]] == 1:
                    del current_window[s2[start]]
                else:
                    current_window[s2[start]] -= 1
                start += 1
            
            if current_window == s1_count:
                return True
    
        return False
     
'''



def checkInclusion(s1, s2):
    if len(s1) > len(s2):
        return False

    s1_map = {}
    for c in s1:
        if c in s1_map:
            s1_map[c] += 1
        else:
            s1_map[c] = 1

    s2_map = {}
    for i in range(len(s1)):
        if s2[i] in s2_map:
            s2_map[s2[i]] += 1
        else:
            s2_map[s2[i]] = 1

    if s1_map == s2_map:
        return True

    for i in range(len(s1), len(s2)):
        if s2[i] in s2_map:
            s2_map[s2[i]] += 1
        else:
            s2_map[s2[i]] = 1

        if s2_map[s2[i - len(s1)]] == 1:
            del s2_map[s2[i - len(s1)]]
        else:
            s2_map[s2[i - len(s1)]] -= 1

        if s1_map == s2_map:
            return True

    return False