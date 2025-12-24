class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total = 0;
        for (int a : apple) total += a;
        Arrays.sort(capacity);
        int sum = 0, count = 0;
        for (int i = capacity.length - 1; i >= 0 && sum < total; i--) {
            sum += capacity[i];
            count++;
        }
        return count;
    }
}
