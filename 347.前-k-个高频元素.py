#
# @lc app=leetcode.cn id=347 lang=python3
#
# [347] 前 K 个高频元素
#
from collections import Counter
from heapq import nlargest
from typing import List


# @lc code=start
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        """
        使用字典统计每个元素的频率，然后使用堆来找出前 k 个高频元素。
        """

        # 统计每个元素的频率
        count = Counter(nums)

        # 使用 nlargest 找出前 k 个高频元素
        return nlargest(k, count.keys(), key=count.get)


# @lc code=end
