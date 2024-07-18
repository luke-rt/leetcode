# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow,fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        curr = slow.next
        slow.next = None

        while curr:
            next = curr.next
            curr.next = prev

            prev, curr = curr, next

        first = head
        last = prev

        while last:
            ln, fn = last.next, first.next
            last.next = first.next
            first.next = last

            last, first = ln, fn

