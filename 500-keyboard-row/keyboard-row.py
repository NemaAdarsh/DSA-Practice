class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        r = [set("qwertyuiop"), set("asdfghjkl"), set("zxcvbnm")]
        return [w for w in words if any(set(w.lower()) <= row for row in r)]
