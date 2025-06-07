class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        ranks = {s: str(i+1) for i, s in enumerate(sorted(score, reverse=True))}
        for i, medal in enumerate(["Gold Medal", "Silver Medal", "Bronze Medal"]):
            if i < len(score): ranks[sorted(score, reverse=True)[i]] = medal
        return [ranks[s] for s in score]
