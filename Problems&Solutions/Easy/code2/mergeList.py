# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeTwoLists(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        # Initialize a dummy node to simplify the code.
        dummy = ListNode()
        # Initialize a current node to the dummy node.
        current = dummy

        while list1 and list2:
            if list1.val < list2.val:
                # Append the smaller node to the merged list.
                current.next = list1
                list1 = list1.next
            else:
                current.next = list2
                list2 = list2.next
            # Move the current pointer forward.
            current = current.next

        # Append any remaining elements from both lists, if any.
        if list1:
            current.next = list1
        if list2:
            current.next = list2

        # Return the merged list, starting from the next node of the dummy node.
        return dummy.next





