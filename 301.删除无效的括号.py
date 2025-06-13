#
# @lc app=leetcode.cn id=301 lang=python3
#
# [301] 删除无效的括号
#

# @lc code=start
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        def backtrack(index, left_count, right_count, left_rem, right_rem, curr):
            # 已经处理完所有字符
            if index == len(s):
                if left_rem == 0 and right_rem == 0 and left_count == right_count:
                    result.add("".join(curr))
                return

            char = s[index]

            if char == "(":
                # 删除当前左括号
                if left_rem > 0:
                    backtrack(
                        index + 1,
                        left_count,
                        right_count,
                        left_rem - 1,
                        right_rem,
                        curr,
                    )
                # 保留当前左括号
                curr.append(char)
                backtrack(
                    index + 1, left_count + 1, right_count, left_rem, right_rem, curr
                )
                curr.pop()

            elif char == ")":
                # 删除当前右括号
                if right_rem > 0:
                    backtrack(
                        index + 1,
                        left_count,
                        right_count,
                        left_rem,
                        right_rem - 1,
                        curr,
                    )
                # 只有当前右括号数量小于左括号数量时才能保留
                if right_count < left_count:
                    curr.append(char)
                    backtrack(
                        index + 1,
                        left_count,
                        right_count + 1,
                        left_rem,
                        right_rem,
                        curr,
                    )
                    curr.pop()

            else:
                # 非括号字符直接保留
                curr.append(char)
                backtrack(index + 1, left_count, right_count, left_rem, right_rem, curr)
                curr.pop()

        result = set()
        # 计算需要删除的左括号和右括号数量
        left = right = 0
        for char in s:
            if char == "(":
                left += 1
            elif char == ")":
                if left == 0:
                    right += 1
                else:
                    left -= 1

        backtrack(0, 0, 0, left, right, [])
        return list(result) if result else [""]


# @lc code=end
