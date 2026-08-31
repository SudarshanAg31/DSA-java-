class Solution {

    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int firstCritical = -1;
        int lastCritical = -1;

        int minDistance = Integer.MAX_VALUE;

        int index = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {

            // Check whether curr is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = index;
                }

                // We already have a previous critical point
                if (lastCritical != -1) {
                    minDistance = Math.min(
                        minDistance,
                        index - lastCritical
                    );
                }

                lastCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Less than 2 critical points
        if (firstCritical == lastCritical) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastCritical - firstCritical;

        return new int[]{minDistance, maxDistance};
    }
}