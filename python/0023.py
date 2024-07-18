# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def merge2Lists(self, l1, l2):
        dummy = ListNode()
        head = dummy

        while l1 or l2:
            if not l1:
                head.next = l2
                break
            if not l2:
                head.next = l1
                break
            
            if l1.val < l2.val:
                head.next = l1
                head = head.next
                l1 = l1.next
            else:
                head.next = l2
                head = head.next
                l2 = l2.next
        
        return dummy.next

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if len(lists) == 0: return None

        k = len(lists)
        while k > 1:
            tmp = [self.merge2Lists(lists[i], lists[i+1]) for i in range(0, k-1, 2)]
            if k % 2 != 0: tmp.append(lists[-1])

            lists = tmp
            k = len(lists)

        return lists[0]

