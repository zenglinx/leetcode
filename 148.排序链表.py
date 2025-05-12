#
# @lc app=leetcode.cn id=148 lang=python3
#
# [148] 排序链表
#


# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # 快慢指针找到中点
        def findMid(head: ListNode) -> ListNode:
            slow = head
            fast = head.next

            while fast and fast.next:
                slow = slow.next
                fast = fast.next.next

            return slow

        # 合并两个有序链表
        def mergeTwoLists(l1: ListNode, l2: ListNode) -> ListNode:
            dummy = ListNode(-1)
            curr = dummy

            while l1 and l2:
                if l1.val < l2.val:
                    curr.next = l1
                    l1 = l1.next
                else:
                    curr.next = l2
                    l2 = l2.next
                curr = curr.next

            curr.next = l1 if l1 else l2

            return dummy.next

        if not head or not head.next:
            return head

        mid = findMid(head)
        right = mid.next
        mid.next = None

        left = self.sortList(head)
        right = self.sortList(right)

        return mergeTwoLists(left, right)


# @lc code=end
