class MedianFinder {
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minheap = new PriorityQueue<>();

    public MedianFinder() {
    }

    public void addNum(int num) {
        if (maxheap.size() == 0)
            maxheap.add(num);
        else {
            if (num > maxheap.peek())
                minheap.add(num);
            else if (maxheap.peek() > num)
                maxheap.add(num);
            else if (maxheap.peek() == num) {
                maxheap.add(num);
            }
            if (1 < Math.abs(minheap.size() - maxheap.size())) {
                if (minheap.size() > maxheap.size())
                    maxheap.add(minheap.remove());
                else
                    minheap.add(maxheap.remove());
            }
        }
    }

    public double findMedian() {
        double ans = 0.0;
        if (minheap.size() == 0 && maxheap.size() == 0)
            return ans;
        else if (minheap.size() >= 1 && maxheap.size() >= 1 && minheap.size() == maxheap.size()) {
            int a = minheap.peek();
            int b = maxheap.peek();
            ans = (a + b) / 2.0;
            return ans;
        } else {
            if (minheap.size() > maxheap.size()) {
                return (double) minheap.peek();
            } else
                return (double) maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */