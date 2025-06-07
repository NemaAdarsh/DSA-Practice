class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        return sum((4 - (i and grid[i-1][j]) - (j and grid[i][j-1]) - (i+1 < len(grid) and grid[i+1][j]) - (j+1 < len(grid[0]) and grid[i][j+1])) for i in range(len(grid)) for j in range(len(grid[0])) if grid[i][j])
