package DailyAlg;

public class BinarySearchLC {
    public static void main(String[] args) {
        int[][] nums = {{1}, {3}};
        TreeNodeT testNode = new TreeNodeT(1, new TreeNodeT(2, new TreeNodeT(4), new TreeNodeT(5)), new TreeNodeT(3, null, null));
//        searchRange(nums, 8);
//        searchMatrix(nums, 3);
        countNodes(testNode);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        int res = -1;
        if (low > high) {
            return -1;
        }
        int mid = (low + high) >> 1;
        if (low > high || mid >= nums.length) {
            return -1;
        }
        if (nums[mid] == target) {
            res = mid;
        } else if (nums[mid] < target) {
            res = binarySearch(nums, mid + 1, high, target);
        } else if (nums[mid] > target) {
            res = binarySearch(nums, low, mid - 1, target);
        }
        return res;
    }

    public static int[] searchRange(int[] nums, int target) {
        int initialIndex = binarySearch(nums, 0, nums.length - 1, target);
        int[] res = {-1, -1};
        if (initialIndex == -1) {
            return res;
        }
        int startIndex = initialIndex;
        int endIndex = initialIndex;

        while ((startIndex > 0 && nums[startIndex - 1] == target) || nums[endIndex] == target) {
            if (startIndex > 0 && nums[startIndex - 1] == target) {
                startIndex--;
            }

            if (endIndex < nums.length - 1) {
                endIndex++;
            }
        }
        if (nums[startIndex] == target && startIndex > 0) {
            startIndex--;
        }
        if (nums[endIndex] == target && endIndex < nums.length - 1) {
            endIndex++;
        }
        return null;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // get target row
        int rows = matrix.length;
        int cols = matrix[0].length;
        int startRow = 0;
        int endRow = rows - 1;



        int row = -1;
        if (rows == 1) {
            row = 0;
        } else {
            while (startRow < endRow) {
                int midRow = (startRow + endRow) >> 1;

                if (matrix[midRow][0] <= target && matrix[midRow + 1][0] > target) {
                    row = midRow;
                    break;
                } else if (matrix[midRow][0] > target) {
                    endRow = midRow - 1;
                } else {
                    startRow = midRow + 1;
                }
            }

            if (matrix[startRow][0] <= target && matrix[startRow][cols - 1] > target) {
                row = startRow;
            }
        }



        if (row == -1) {
            return false;
        }

        int left = 0;
        int right = cols - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (matrix[row][mid] < target) {
                left = mid + 1;
            } else if (matrix[row][mid] == target) {
                return true;
            } else {
                right = mid - 1;
            }
        }

        return false;




    }

    public static int countNodes(TreeNodeT root) {
        if (root == null) {
            return 0;
        }
        TreeNodeT node = root;
        int level = -1;
        while (node != null) {
            node = node.left;
            level++;
        }

        int l = 1 << level;
        int r = (1 << (level + 1)) -1;
        int m = l;
        while (l <= r) {

            m = (l + r) >> 1;
            if (l == r) {
                if (exists(root, level, m)) {
                    return m;

                } else {
                    return m - 1;

                }
            }
            if (exists(root, level, m)) {
                l = m + 1;

            } else {
                r = m - 1;

            }
        }
        return m;

    }
    public static boolean exists(TreeNodeT root, int level, int k) {
        int bits = 1 << (level - 1);
        TreeNodeT node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}

 class TreeNodeT {
      int val;
      TreeNodeT left;
      TreeNodeT right;
      TreeNodeT() {}
      TreeNodeT(int val) { this.val = val; }
      TreeNodeT(int val, TreeNodeT left, TreeNodeT right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
