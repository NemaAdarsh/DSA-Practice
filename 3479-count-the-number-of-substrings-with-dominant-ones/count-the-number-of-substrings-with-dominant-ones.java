class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        java.util.ArrayList<Integer> zeros = new java.util.ArrayList<>();
        for (int i = 0; i < n; i++) if (s.charAt(i) == '0') zeros.add(i);
        long ans = 0;
        int Z = zeros.size();
        int K = (int)Math.sqrt(n) + 2;
        long onesOnly = 0;
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                int j = i;
                while (j < n && s.charAt(j) == '1') j++;
                long len = j - i;
                onesOnly += len * (len + 1) / 2;
                i = j;
            } else i++;
        }
        ans += onesOnly;
        for (int z = 1; z <= K; z++) {
            if (z > Z) break;
            long needLen = (long)z * z + z;
            for (int startZeroIdx = 0; startZeroIdx + z - 1 < Z; startZeroIdx++) {
                int firstZero = zeros.get(startZeroIdx);
                int lastZero = zeros.get(startZeroIdx + z - 1);
                int prev = startZeroIdx == 0 ? -1 : zeros.get(startZeroIdx - 1);
                int next = (startZeroIdx + z >= Z) ? n : zeros.get(startZeroIdx + z);
                int A = prev + 1;
                int B = firstZero;
                int C = lastZero;
                int D = next - 1;
                if (B < A) continue;
                if (C > D) continue;
                for (int sPos = A; sPos <= B; sPos++) {
                    long minE = Math.max(C, sPos + needLen - 1);
                    if (minE > D) continue;
                    ans += D - minE + 1;
                }
            }
        }
        return (int)ans;
    }
}
