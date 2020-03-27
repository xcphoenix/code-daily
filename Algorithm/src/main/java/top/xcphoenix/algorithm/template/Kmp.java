package top.xcphoenix.algorithm.template;

/**
 * @author      xuanc
 * @date        2020/3/27 下午3:17
 * @version     1.0
 */ 
public class Kmp {

    private static int charSize = 256;
    private int[][] dp;
    private String pat;

    /**
     * @param pat 模式串
     */
    public Kmp(String pat) {
        this.pat = pat;
        init();
    }

    /**
     * <h1>KMP</h1>
     * 令 <code>M = pat.length()</code>、<code>N = txt.length()</code>
     * <li> 时间复杂度：<code>O(N)</code></li>
     * <li> 空间复杂度：<code>O(M)</code></li>
     *
     * @param txt 文本串
     * @return 子串的起始索引，找不到则返回 -1
     */
    public int search(String txt) {
        int m = pat.length();
        int n = txt.length();

        // 初始状态
        int status = 0;
        for (int i = 0; i < n; i++) {
            // 获取下一个状态
            status = dp[status][txt.charAt(i)];
            // 如果到达最后一个状态，返回txt中的子串的下标
            if (status == m) {
                return i - m + 1;
            }
        }

        return -1;
    }

    private void init() {
        int m = pat.length();
        dp = new int[m][charSize];

        // base case
        dp[0][pat.charAt(0)] = 1;
        // dp[x][ch] 为 pat.charAt(j) 不符合时要跳转的状态
        int x = 0;

        /*
         * 状态0无需推导
         */
        for (int status = 1; status < m; status++) {
            for (int ch = 0; ch < charSize; ch++) {

                /*
                 * 如果是第一次
                 * - 字符 ch = ch' 匹配
                 *   那么 dp[1][ch'] = 0 + 1 成立，可以走向下一个状态
                 * - ch = ch' 不匹配
                 *   那么 dp[1][ch'] = dp[0][ch']
                 *   如果第二个字符与第一个字符相同，那么返回状态1，否则返回状态0
                 * 其他情况：
                 * - 依赖于dp[x][ch]的正确性
                 */

                if (ch == pat.charAt(status)) {
                    // 状态推进
                    dp[status][ch] = status + 1;
                } else {
                    // 回退
                    dp[status][ch] = dp[x][ch];
                }
            }

            /*
             * 第一次：
             *      如果 ch' 与 pat 的第一个字符相等，那么为 1，否则为 0，也就是：x 为
             * 其他：
             *      （这里的状态是本次循环状态的前一个状态）
             *      因为 x 与 status 状态有着最长的相同的前缀，很明显第一次满足这个条件
             * 　　　递归关系为：x = dp[x][pat.charAt(status)]
             *      - pat.charAt(status)　当前状态对应的字符
             *      - dp[i][j] i状态下，如果对应字符为j的下一个状态
             *      　　
             * 　　　那么 dp[x][pat.charAt(status)] 就是在 与 status 状态有着最长的相同的前缀下，
             *      对应字符为 pat.charAt(status) 时的下一个状态。
             *      很明显有 x < status，也就是上面的值是已知的
             *
             *      对于 x 和 status 状态： 0 ~ x 与 status - x ~ status 所对应的字符串是一一匹配的，即子串是相同的
             *      设下一个状态 status + 1 对应的字符为 ch'，那么如果 x + 1 对应的字符与 ch' 相符，那么 x++
             *      否则，x 为应该回滚到 x'，使得 0 ~ x' 与 status - x' ~ status 对应的子串相同
             *
             *      这个子问题等同于我们正在解决的问题：有两个指针i和j，i 指向 txt，j 指向 pat，此时以指针为结束符号，有
             *      0 ~ j 对应的子串与 i-j ~ j 对应的子串相等，如果下一个字符不匹配，为了避免不必要的比较，
             *  　　 我们直接将指针 j 回滚到 j'，保证 0 ~ j' 与 i - 1 - j' ~ i - 1 对应的子串是相同的
             *
             *      所以我们可以直接使用总体的策略：
             * 　　　
             *      // 获取下一个状态
             *      status = dp[status][txt.charAt(i)];
             *
             *      所以到最后可以描述为：x = dp[x][pat.charAt(i)]（值以前算过，是已知并且正确的）
             *
             */

            // 更新状态
            x = dp[x][pat.charAt(status)];
            System.out.println("new shadow status: " + x);
        }
    }

    public static void main(String[] args) {
        String pat = "ababc";
        String txt = "ababc";

        Kmp kmp = new Kmp(pat);
        int val = kmp.search(txt);

        System.out.println(val + ", " + txt.indexOf(pat) + " => " + (txt.indexOf(pat) == val));
    }

}
